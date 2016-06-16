package com.yjn.retrofitdemo.core;

import com.yjn.retrofitdemo.BuildConfig;
import com.yjn.retrofitdemo.constants.BaseUrl;
import com.yjn.retrofitdemo.intf.MyInterface;

import okhttp3.OkHttpClient;
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

    public MainRetrofit() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        // 日志, 如果是 debug模式, 就是打开启日志(自己要配置 全局 debug, 这里是默认的true)
        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

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
}
