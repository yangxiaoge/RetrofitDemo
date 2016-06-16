package com.yjn.retrofitdemo.bean;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-05-26 15:34
 * Version: 1.0
 * TaskId:
 * Description:
 */
public class LoginData {
    String pwd;
    String app_version;
    String os_version;
    String sdn;
    String meid;
    String prefix;
    String os;

    public LoginData(String pwd, String app_version, String os_version, String sdn, String meid, String prefix, String os) {
        this.pwd = pwd;
        this.app_version = app_version;
        this.os_version = os_version;
        this.sdn = sdn;
        this.meid = meid;
        this.prefix = prefix;
        this.os = os;
    }
}
