package com.yjn.retrofitdemo.advance_retrofit;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-08-29 19:23
 * Version: 1.0
 * TaskId:
 * Description:
 */
public class LoginRequest {
    public String name;
    public String password;
    public String macAddress;
    public String ip;

    public LoginRequest(String name, String password, String macAddress, String ip) {
        this.name = name;
        this.password = password;
        this.macAddress = macAddress;
        this.ip = ip;
    }
}
