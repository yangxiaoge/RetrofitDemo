package com.yjn.retrofitdemo.advance_retrofit;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-08-29 19:19
 * Version: 1.0
 * TaskId:
 * Description:
 */
public interface UserService {
    @POST("/login")
    Observable<Response<UserEntity>> login(@Body LoginRequest loginRequest);

    /* == ↑ 同于上面 . 相当于把LoginRequest 里的参数摆放出来，效果是一样的 */
    @FormUrlEncoded
    @POST("/login")
    Observable<Response<UserEntity>> loginOtherWay(
            @Field("phone") String phone,
            @Field("password") String password,
            @Field("macAddress") String macAddress,
            @Field("ip") String ip
    );

    /* == 同于 @GET("/users/username")... */
    @GET("/users/{username}")
    Observable<UserEntity> getInfo(@Path("username") String username);
}
