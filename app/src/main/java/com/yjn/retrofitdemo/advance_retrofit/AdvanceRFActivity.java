package com.yjn.retrofitdemo.advance_retrofit;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.yjn.retrofitdemo.R;
import com.yjn.retrofitdemo.vectorAnimate.VectorAnimateActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
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

    @Bind(R.id.rg_img_backgroud)
    ImageView rg_img_backgroud;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit);
        ButterKnife.bind(this);

        getInfo = (Button) findViewById(R.id.getInfo);
        textInfo = (TextView) findViewById(R.id.textView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 设置背景图动画
                Animation animation = AnimationUtils.loadAnimation(AdvanceRFActivity.this,R.anim.translate_anim);
                rg_img_backgroud.setAnimation(animation);
            }
        },200);

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
                        Logger.i(userEntity.toString());
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
                        Logger.i(model.toString());
                    }
                });

        Map<String,String> map = new HashMap<>();
        map.put("name","364804051@qq.com");
        map.put("password","yjn991926");
        map.put("macAddress","");
        map.put("ip","");
        new UserApi().login(new LoginRequest("364804051@qq.com","yjn991926","",""))
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
