package com.yjn.retrofitdemo.ui;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import java.util.Locale;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-08-30 9:14
 * Version: 1.0
 * TaskId:
 * Description:
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //switchLanguage(Locale.SIMPLIFIED_CHINESE); //这里最好在本地配置文件取
    }
    public void switchLanguage(Locale locale) {
        //应用内配置语言
        Resources resources = getResources();//获得res资源对象
        Configuration config = resources.getConfiguration();//获得设置对象
        DisplayMetrics dm = resources.getDisplayMetrics();//获得屏幕参数：主要是分辨率，像素等。
        config.locale = locale; //简体中文
        resources.updateConfiguration(config, dm);

    }
}
