package com.yjn.retrofitdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.yjn.retrofitdemo.R;
import com.yjn.retrofitdemo.advance_retrofit.AdvanceRFActivity;
import com.yjn.retrofitdemo.bean.CdrBean;
import com.yjn.retrofitdemo.bean.DepGroup;
import com.yjn.retrofitdemo.bean.GitHubUserBean;
import com.yjn.retrofitdemo.bean.LoginData;
import com.yjn.retrofitdemo.bean.LoginResponse;
import com.yjn.retrofitdemo.core.MainFactory;
import com.yjn.retrofitdemo.intf.MyInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    @Bind(R.id.github_name)
    TextView githubName;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.cdrText)
    TextView cdrText;
    @Bind(R.id.button2)
    Button button2;
    @Bind(R.id.button3)
    Button button3;
    @Bind(R.id.button4)
    Button button4;
    @Bind(R.id.button5)
    Button changeLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
     /*   //应用内配置语言
        Resources resources = getResources();//获得res资源对象
        Configuration config = resources.getConfiguration();//获得设置对象
        DisplayMetrics dm = resources.getDisplayMetrics();//获得屏幕参数：主要是分辨率，像素等。
        config.locale = Locale.KOREA; //简体中文
        resources.updateConfiguration(config, dm);*/

    }

    @OnClick({R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.advance_retrofit, R.id.athena})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                initData();
                break;
            case R.id.button2:
                qryCdr();
//                queryDepGroup();
                break;
            case R.id.button3:
                login();
                break;
            case R.id.button4:
                queryDepGroup();
                break;
            case R.id.button5:
                Toast.makeText(this, "点我", Toast.LENGTH_SHORT).show();
                switchLanguage(Locale.US);
                startActivity(new Intent(this, MainActivity.class));
                this.finish();
                break;
            case R.id.button6:
                switchLanguage(Locale.SIMPLIFIED_CHINESE);
                startActivity(new Intent(this, MainActivity.class));
                this.finish();
                break;
            case R.id.advance_retrofit:
                startActivity(new Intent(this, AdvanceRFActivity.class));
                break;
            case R.id.athena:
                athenaLogin();
                break;

        }
    }

    private void athenaLogin() {
        MyInterface athenaService = MainFactory.getAthenaInterface();
        Map<String, String> params = new HashMap<>();
        params.put("prefix", "95");
        params.put("sdn", "2016042007");
        params.put("pwd", "QFfpQMMfO6o=");
        params.put("meid", "864895021268485");
        params.put("os", "Android");
        params.put("os_version", "4.2.2");
        params.put("app_version", "1101");
        Observable<LoginResponse> athena = athenaService.athenaLogin(params);
        athena.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginResponse>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("LoginResponse--- onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("LoginResponse--- onError");
                    }

                    @Override
                    public void onNext(LoginResponse loginResponse) {
                        Toast.makeText(MainActivity.this, "雅典娜登录成功", Toast.LENGTH_SHORT).show();
                        Logger.d("雅典娜登录返回数据:");
                        Logger.d("javabean转成jsonv1" + "↓↓↓");
                        Logger.json(new Gson().toJson(loginResponse));
                        Logger.d("javabean tostring" + "↓↓↓");
                        Logger.d(loginResponse.toString());
                    }
                });
    }


    // 获取github用户信息
    private void initData() {
        MyInterface myInterfaceService = MainFactory.getGithubInterface();
        Observable<GitHubUserBean> call = myInterfaceService.repo("yangxiaoge");
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GitHubUserBean>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("GitHubUserBean--- onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("GitHubUserBean--- onError");
                    }

                    @Override
                    public void onNext(GitHubUserBean response) {
                        githubName.setText(response.getLogin());
                        Toast.makeText(MainActivity.this, response.getLogin(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    /**
     * rxjava + retrofit
     * 所内登录
     */
    private void login() {
        Map<String, Object> msisdnParams = new HashMap();
        msisdnParams.put("prefix", "86");
        msisdnParams.put("sdn", "2015082014");
        msisdnParams.put("pwd", "1UUYBGXJB54=");
        msisdnParams.put("meid", "123456789012");
        msisdnParams.put("os", "Android");
        msisdnParams.put("os_version", "6.0");
        msisdnParams.put("app_version", "1.0");

        MyInterface loginIft = MainFactory.getMyinterfaceInstance();
        Observable<LoginResponse> loginService = loginIft.login(new LoginData("1UUYBGXJB54="
                , "1.0"
                , "6.0"
                , "2015082014"
                , "123456789012"
                , "86"
                , "Android")
        );

        loginService
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginResponse>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted-----");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError------");
                    }

                    @Override
                    public void onNext(LoginResponse loginData) {
                        System.out.println("onNext------");
                        System.out.println("登录成功啦-->" + loginData.toString());
                        Toast.makeText(MainActivity.this, "登录成功啦-->", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    /**
     * 查询 freebies 组
     */
    private void queryDepGroup() {

        MyInterface itf = MainFactory.getMyinterfaceInstance();

        Map<String, String> map = new HashMap();
        map.put("relaType", "5");
        map.put("srcOfferId", "985");
        Call<List<DepGroup>> cdr = itf.depGroup(map);
        cdr.enqueue(new Callback<List<DepGroup>>() {
            @Override
            public void onResponse(Call<List<DepGroup>> call, Response<List<DepGroup>> response) {
                Toast.makeText(MainActivity.this, "dep", Toast.LENGTH_SHORT).show();
//                System.out.println("查询DepGroup结果--->" + new Gson().toJson(response.body()));
                /*Logger.init();
                Logger.d("↓↓↓↓↓ response.body()↓↓↓↓↓");
                Logger.json(new Gson().toJson(response.body()));
                Logger.d("↓↓↓↓↓ response↓↓↓↓↓");
                Logger.json(new Gson().toJson(response));*/
            }

            @Override
            public void onFailure(Call<List<DepGroup>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

    // 查询cdr,  内网环境!
    private void qryCdr() {
        MyInterface itf = MainFactory.getMyinterfaceInstance();

        String msisdn = "862015082014";
        Map<String, String> map = new HashMap();
        map.put("year", "2016");
        map.put("month", "03");
        Call<CdrBean> cdr = itf.cdr(msisdn, map);
        cdr.enqueue(new Callback<CdrBean>() {
            @Override
            public void onResponse(Call<CdrBean> call, Response<CdrBean> response) {
                System.out.println("查询CDR结果--->" + response.body());
                cdrText.setText(response.body().getDataTotalVolume() + "");
            }

            @Override
            public void onFailure(Call<CdrBean> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

}
