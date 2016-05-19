package com.yjn.retrofitdemo.intf;

import com.yjn.retrofitdemo.bean.CdrBean;
import com.yjn.retrofitdemo.bean.GitHubUserBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Author:0027008122 [yang.jianan@zte.com.cn]
 * Date:2016-05-19
 * Time:9:39
 * Version:1.0
 * TaskId:
 */
public interface MyInterface {
    @GET("/users/{users}")
    Call<GitHubUserBean> repo(@Path("users") String user);

    // http://10.45.5.224:8080/api/services/subscriber/v1/cdr/msisdn/862015082014?year=2016&month=03
    @GET("/api/services/subscriber/v1/cdr/msisdn/{msisdn}")
    Call<CdrBean> cdr(@Path("msisdn") String msisdn, @QueryMap Map<String, String> options);

}
