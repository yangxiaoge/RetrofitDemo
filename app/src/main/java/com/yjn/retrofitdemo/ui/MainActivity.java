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
import com.yjn.retrofitdemo.advance_retrofit.PreferencesHelper;
import com.yjn.retrofitdemo.bean.AcctBalanceList;
import com.yjn.retrofitdemo.bean.CdrBean;
import com.yjn.retrofitdemo.bean.DepGroup;
import com.yjn.retrofitdemo.bean.GitHubUserBean;
import com.yjn.retrofitdemo.bean.LoginData;
import com.yjn.retrofitdemo.bean.LoginResponse;
import com.yjn.retrofitdemo.core.MainFactory;
import com.yjn.retrofitdemo.dialog_customer_layout.CustomerDialogActivity;
import com.yjn.retrofitdemo.dialog_edittext.PasswordDialogEditActivity;
import com.yjn.retrofitdemo.gank_io_retrofit.activity.GankRetrofitMainActivity;
import com.yjn.retrofitdemo.intf.MyInterface;
import com.yjn.retrofitdemo.litepal.LitePal_Activity;
import com.yjn.retrofitdemo.login_widget.LoginActivity;
import com.yjn.retrofitdemo.vectorAnimate.VectorAnimateActivity;

import java.text.DecimalFormat;
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

    private String custCode = ""; //雅典娜登录成功后返回的 custCode

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

        // java千分位格式化
        System.out.println("java千分位格式化数据: " + DecimalFormat.getNumberInstance().format(Double.parseDouble("1000000999999")) + "");
        while (true) {
            for (int i = 0; i < 10; i++) {
                if (i == 6) {
                    System.out.println("while终断");
                    Toast.makeText(this, "while终断", Toast.LENGTH_SHORT).show();
                    return; // return跳出循环体!, break 跳出当前循环体 ,continue 跳过当前循环体continue后面的代码，继续执行下一个循环
                }
                System.out.println("while1111");
                //Toast.makeText(this, "while1111", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @OnClick({R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6,
            R.id.advance_retrofit, R.id.athena, R.id.button7, R.id.litepal, R.id.dialog_edit,
            R.id.customer_dialog, R.id.nice_retrofit, R.id.vectorAnimate, R.id.login})
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
                // 雅典娜登录
                athenaLogin();
                break;
            case R.id.button7:
                startActivity(new Intent(this, ScrollTitleList.class));
                break;
            case R.id.litepal:
                startActivity(new Intent(this, LitePal_Activity.class));
                break;
            case R.id.dialog_edit:
                startActivity(new Intent(this, PasswordDialogEditActivity.class));
                break;
            case R.id.customer_dialog:
                startActivity(new Intent(this, CustomerDialogActivity.class));
                break;
            case R.id.nice_retrofit:
                startActivity(new Intent(this, GankRetrofitMainActivity.class));
                break;
            case R.id.vectorAnimate:
                startActivity(new Intent(this, VectorAnimateActivity.class));
                break;
            case R.id.login:
                startActivity(new Intent(this, LoginActivity.class));
                break;

        }
    }

    private void athenaLogin() {
        final MyInterface athenaService = MainFactory.getAthenaInterface();
        Map<String, String> params = new HashMap<>();
        params.put("prefix", "95");
        params.put("sdn", "9201005832");
        params.put("pwd", "1UUYBGXJB54=");
        params.put("meid", "864895021268485");
        params.put("os", "iPhone7s Plus");
        params.put("os_version", "7.0");
        params.put("app_version", "1024");
        // login
        Observable<LoginResponse> athenaLogin = athenaService.athenaLogin(params);
        athenaLogin.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginResponse>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("LoginResponse--- onCompleted");

                        // 查询account list
                        qryAcctBalList(athenaService, custCode);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("LoginResponse--- onError");
                    }

                    @Override
                    public void onNext(LoginResponse loginResponse) {
                        Toast.makeText(MainActivity.this, "雅典娜登录成功", Toast.LENGTH_SHORT).show();
                        Logger.d("雅典娜登录返回数据↓↓↓");
                        Logger.d("javabean转成json字符串" + "↓↓↓");
                        Logger.json(new Gson().toJson(loginResponse));
                        Logger.d("javabean tostring" + "↓↓↓");
                        Logger.d(loginResponse.toString());
                        new PreferencesHelper(MainActivity.this).setToken(loginResponse.getAccessToken());
                        custCode = loginResponse.getAcctNbr();
                    }
                });

    }

    private void qryAcctBalList(MyInterface athenaService, String code) {
        //query athenaGetAcctBalList
        Observable<AcctBalanceList> acctBalanceListObservable = athenaService.athenaGetAcctBalList(code);
        acctBalanceListObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AcctBalanceList>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("qry AcctBalanceList--- onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("qry AcctBalanceList--- onError");
                    }

                    @Override
                    public void onNext(AcctBalanceList acctBalanceList) {
                        Logger.d(new Gson().toJson(acctBalanceList));
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
