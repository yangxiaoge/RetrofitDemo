package com.yjn.retrofitdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yjn.retrofitdemo.bean.CdrBean;
import com.yjn.retrofitdemo.bean.GitHubUserBean;
import com.yjn.retrofitdemo.constants.BaseUrl;
import com.yjn.retrofitdemo.intf.MyInterface;
import com.yjn.retrofitdemo.R;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.github_name)
    TextView githubName;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.cdrText)
    TextView cdrText;
    @Bind(R.id.button2)
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.button, R.id.button2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                initData();
                break;
            case R.id.button2:
                qryCdr();
                break;
        }
    }

    // 获取github用户信息
    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyInterface myInterfaceService = retrofit.create(MyInterface.class);
        Call<GitHubUserBean> call = myInterfaceService.repo("yangxiaoge");

        call.enqueue(new Callback<GitHubUserBean>() {
            @Override
            public void onResponse(Call<GitHubUserBean> call, Response<GitHubUserBean> response) {
                System.out.println(response.body().getLogin() + "-->" + response.message());
                System.out.println("GitHub结果-->"+response.body().toString());
                githubName.setText(response.body().getLogin());
                Toast.makeText(MainActivity.this, response.body().getLogin(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<GitHubUserBean> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

    // 查询cdr,  内网环境!
    private void qryCdr() {
        Retrofit re = new Retrofit.Builder()
                .baseUrl(BaseUrl.CdrHost)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyInterface itf = re.create(MyInterface.class);

        String msisdn = "862015082014";
        Map<String, String> map = new HashMap();
        map.put("year", "2016");
        map.put("month", "03");
        Call<CdrBean> cdr = itf.cdr(msisdn, map);
        cdr.enqueue(new Callback<CdrBean>() {
            @Override
            public void onResponse(Call<CdrBean> call, Response<CdrBean> response) {
                System.out.println("查询CDR结果--->"+response.body().toString());
                cdrText.setText(response.body().getDataTotalVolume());
            }

            @Override
            public void onFailure(Call<CdrBean> call, Throwable t) {

            }
        });
    }
}
