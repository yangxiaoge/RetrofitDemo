package com.yjn.retrofitdemo.dialog_edittext;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.yjn.retrofitdemo.R;
import com.yjn.retrofitdemo.dialog_edittext.library.GridPasswordView;

/**
 * Created by yjn on 2016/11/21.
 */

public class PasswordDialogEditActivity extends AppCompatActivity {
    private GridPasswordView gridPasswordView;
    private boolean isFirst = true;
    private String firstPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_edit);
        gridPasswordView = (GridPasswordView) findViewById(R.id.gpv_normal);
        gridPasswordView.setPasswordVisibility(true);

        onPwdChangedTest();
    }

    void onPwdChangedTest() {
        gridPasswordView.setOnPasswordChangedListener(new GridPasswordView.OnPasswordChangedListener() {
            @Override
            public void onTextChanged(String psw) {
                if (psw.length() == 6 && isFirst) {
                    Toast.makeText(PasswordDialogEditActivity.this, gridPasswordView.getPassWord(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onInputFinish(String psw) {
            }
        });
    }
}
