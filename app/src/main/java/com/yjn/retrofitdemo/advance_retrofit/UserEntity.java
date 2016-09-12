package com.yjn.retrofitdemo.advance_retrofit;

public class UserEntity {
    private String login;
    private int id;
    private String avatar_url;
    private String gravatar_id;
    private String url;

    @Override
    public String toString() {
        return "UserEntity{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", avatar_url='" + avatar_url + '\'' +
                ", gravatar_id='" + gravatar_id + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

//    private String pwd;
//    private String sdn;
//    private String app_version;
//    private String os;
//    private String os_version;
//    private String prefix;
//    private String meid;
}