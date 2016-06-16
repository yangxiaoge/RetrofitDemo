package com.yjn.retrofitdemo.intf;

import com.yjn.retrofitdemo.bean.CdrBean;
import com.yjn.retrofitdemo.bean.DepGroup;
import com.yjn.retrofitdemo.bean.GitHubUserBean;
import com.yjn.retrofitdemo.bean.LoginData;
import com.yjn.retrofitdemo.bean.LoginResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Author:0027008122 [yang.jianan@zte.com.cn]
 * Date:2016-05-19
 * Time:9:39
 * Version:1.0
 * TaskId:
 */
public interface MyInterface {

   /*
    // retrofit2单独使用
    @GET("/users/{users}")
    Call<GitHubUserBean> repo(@Path("users") String user);*/

    // Rxjava + retrofit2 搭配, 获取github用户信息
    @GET("/users/{users}")
    Observable<GitHubUserBean> repo(@Path("users") String user);

    // http://10.45.5.224:8080/api/services/subscriber/v1/cdr/msisdn/862015082014?year=2016&month=03
    @GET("subscriber/v1/cdr/msisdn/{msisdn}")
    Call<CdrBean> cdr(@Path("msisdn") String msisdn, @QueryMap Map<String, String> options);

    /**
     * 查询 freebies 赠送 group
     *
     * @param options
     * @return
     */
    @GET("offer/v1/RelaOfferGroup")
    Call<List<DepGroup>> depGroup(@QueryMap Map<String, String> options);

    /**
     * Rxjava + retrofit2 登录
     * @param
     * @return
     */
    @POST("auth/v1/login/subs")
    Observable<LoginResponse> login(@Body LoginData loginData);
}
