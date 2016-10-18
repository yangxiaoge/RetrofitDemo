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
    private Locale locale;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //switchLanguage(Locale.SIMPLIFIED_CHINESE); //这里最好在本地配置文件取
    }
    public void switchLanguage(Locale locale) {
        this.locale = locale;
        //应用内配置语言
        Resources resources = getResources();//获得res资源对象
        Configuration config = resources.getConfiguration();//获得设置对象
        DisplayMetrics dm = resources.getDisplayMetrics();//获得屏幕参数：主要是分辨率，像素等。
        config.locale = locale; //简体中文
        resources.updateConfiguration(config, dm);

    }

    /**
     * 设置字体大小不随手机设置而改变
     * @return Resources
     */
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config=new Configuration();
        //config.setToDefaults(); //由于本app有多语言切换,所以不要用 default 的 locale
        config.setLocale(locale);
        res.updateConfiguration(config,res.getDisplayMetrics() );
        return res;
    }
}
