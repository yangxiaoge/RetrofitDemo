package com.yjn.retrofitdemo.advance_retrofit;

import com.orhanobut.logger.Logger;

import java.io.IOException;

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
 * Time: 2016-08-29 19:26
 * Version: 1.0
 * TaskId:
 * Description:
 */
public class BaseApi {
    private Retrofit getRetrofit(final String baseUrl, final boolean isWithToken) {
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        //增加日志
        httpClient.addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request.Builder builder = original.newBuilder()
                        .method(original.method(), original.body())
                        //添加请求头部
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .header("key", "value")
                        .header("key2", "value2");
                if (isWithToken)
                    builder.header("token", App.get().getPreferencesHelper().getToken());

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

        OkHttpClient okHttpClient = httpClient.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    public Retrofit getRetrofit() {
        return getRetrofit(Urls.BASE_URL, false);
    }

    public Retrofit getRetrofitWithToken() {
        return getRetrofit(Urls.BASE_URL, true);
    }

}
