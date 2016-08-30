package com.yjn.retrofitdemo.core;

import com.orhanobut.logger.Logger;
import com.yjn.retrofitdemo.BuildConfig;
import com.yjn.retrofitdemo.advance_retrofit.BASE64.BASE64Encoder;
import com.yjn.retrofitdemo.constants.BaseUrl;
import com.yjn.retrofitdemo.intf.MyInterface;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-05-27 11:18
 * Version: 1.0
 * TaskId:
 * Description:
 */
public class MainRetrofit {
    final MyInterface mService;
    final MyInterface githubService;
    final MyInterface athenaService;

    public MainRetrofit() {
        Logger.init("BaseApi");
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        // 日志, 如果是 debug模式, 就是打开启日志(自己要配置 全局 debug, 这里是默认的true)
        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        //OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request original = chain.request();
                Request.Builder builder = original.newBuilder()
                        .method(original.method(), original.body())
                        //添加请求头部
                        .header("timestamp", String.valueOf(new Date().getTime()))
                        .header("accesstoken", " ")
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .header("Accept-Charset", "utf-8")
                        .header("Content-Language", "en")
                        .header("User-Agent", "DataMall Client")
                        .header("Device", "android");

                try {
                    String generateHmacSHA256Signature = generateHmacSHA256Signature(" ", String.valueOf(new Date().getTime()));
                    builder.header("sign", generateHmacSHA256Signature);
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                }

                Request finalRequest = builder.build();
                HttpUrl url = finalRequest.url().newBuilder()
                        // 在原链接上添加后缀，相当于在url上添加了 &platform=android&v=1.0
                        .addQueryParameter("platform", "android")
                        .addQueryParameter("v", "1.0")
                        .build();
                Logger.i(url.toString());
                finalRequest = finalRequest.newBuilder().url(url).build();

                return chain.proceed(builder.build());
            }
        });
        OkHttpClient client = clientBuilder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl.MI_BSER_URL)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mService = retrofit.create(MyInterface.class);

        Retrofit retrofitGithub = new Retrofit.Builder()
                .baseUrl(BaseUrl.GITHUB_URL)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        githubService = retrofitGithub.create(MyInterface.class);

        Retrofit athenaRf = new Retrofit.Builder()
                .baseUrl(BaseUrl.ATHENA_BSER_URL)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        athenaService = athenaRf.create(MyInterface.class);
    }

    public String generateHmacSHA256Signature(String data, String key) throws GeneralSecurityException {
        byte[] hmacData = null;

        try {
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKey);
            hmacData = mac.doFinal(data.getBytes("UTF-8"));
            return new BASE64Encoder().encode(hmacData);
        } catch (UnsupportedEncodingException e) {
            throw new GeneralSecurityException(e);
        }
    }

    /**
     * @return MyInterface 对象
     */
    public MyInterface getService() {
        return mService;
    }

    /**
     * @return MyInterface 对象
     */
    public MyInterface getGithubService() {
        return githubService;
    }

    public MyInterface getAthenaService() {
        return athenaService;
    }
}
