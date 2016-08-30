package com.yjn.retrofitdemo.advance_retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.yjn.retrofitdemo.R;

import okhttp3.Headers;
import retrofit2.Response;
import rx.Observer;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-08-29 19:29
 * Version: 1.0
 * TaskId:
 * Description:
 */
public class AdvanceRFActivity extends AppCompatActivity {
    private Button getInfo;
    private TextView textInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit);
        getInfo = (Button) findViewById(R.id.getInfo);
        textInfo = (TextView) findViewById(R.id.textView);

        getInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofitTest();
            }
        });
    }

    public void retrofitTest() {
        new UserApi().getInfo("xiaozhuzhu").subscribe(
                new Observer<UserEntity>() {
                    @Override
                    public void onCompleted() {
                        // 成功后
                    }

                    @Override
                    public void onError(Throwable e) {
                        // 所有的错误全在这里
                    }

                    @Override
                    public void onNext(UserEntity userEntity) {
                        // 成功后
                        Logger.i("11" + userEntity.toString());
                    }
                }
        );

        new UserApi().getInfo("yangxiaoge").subscribe(
                new HttpObserver<UserEntity>() {
                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSuccess(UserEntity model) {
                        Logger.i("22" + model.toString());
                    }
                });

        new UserApi().login(null)
                .subscribe(new HttpObserver<Response<UserEntity>>() {
                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSuccess(Response<UserEntity> model) {
                        Headers headers = model.headers();
                        Logger.i(headers.toString());
                        String token = headers.get("token");
                        App.get().getPreferencesHelper().setToken(token);
                    }
                });
    }

}
