package com.yjn.retrofitdemo.core;

import com.yjn.retrofitdemo.intf.MyInterface;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-05-27 11:26
 * Version: 1.0
 * TaskId:
 * Description:
 */
public class MainFactory {
    static MyInterface myInterface;
    static MyInterface mGithubInterface;

    protected static final Object monitor = new Object();

    public static MyInterface getMyinterfaceInstance() {
        synchronized (monitor) {
            if (myInterface == null) {
                myInterface = new MainRetrofit().getService();
            }
            return myInterface;
        }
    }

    public static MyInterface getGithubInterface() {
        synchronized (monitor) {
            if (mGithubInterface == null) {
                mGithubInterface = new MainRetrofit().getGithubService();
            }
            return mGithubInterface;
        }
    }
}
