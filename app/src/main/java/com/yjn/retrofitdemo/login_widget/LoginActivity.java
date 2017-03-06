package com.yjn.retrofitdemo.login_widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.yjn.retrofitdemo.R;
import com.yjn.retrofitdemo.widget.ClearWriteEditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <pre>
 *      Author: Yang.JiaNan
 *      Time: 2017/3/6 10:21
 *      Email: yang.jianan@zte.com.cn
 *      Desc:
 * </pre>
 */
public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.login_btn)
    Button loginBtn;
    @Bind(R.id.de_login_phone)
    ClearWriteEditText deLoginPhone;
    @Bind(R.id.de_login_password)
    ClearWriteEditText deLoginPassword;
    @Bind(R.id.rg_img_backgroud)
    ImageView rgImgBackgroud;

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);
        mContext = LoginActivity.this;

        //设置背景动画
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = new AnimationUtils().loadAnimation(mContext, R.anim.translate_anim);
                rgImgBackgroud.setAnimation(animation);
            }
        }, 200);
    }

    @OnClick({R.id.login_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn:

                if (TextUtils.isEmpty(deLoginPhone.getText().toString().trim())) {
                    NToast.shortToast(mContext, "手机号为空");
                    deLoginPhone.setShakeAnimation();
                    return;
                }

                if (TextUtils.isEmpty(deLoginPassword.getText().toString().trim())) {
                    NToast.shortToast(mContext, "密码为空");
                    deLoginPassword.setShakeAnimation();
                    return;
                }

                showDialog(); //显示loading

                break;
        }
    }

    private void showDialog() {
        LoadDialog.show(mContext);
        // 3秒后dismiss
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                LoadDialog.dismiss(mContext);
            }
        }, 3000);
    }
}
