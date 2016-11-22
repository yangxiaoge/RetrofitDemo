package com.yjn.retrofitdemo.dialog_customer_layout;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yjn.retrofitdemo.R;

/**
 * Created by yjn on 2016/11/21.
 */

public class CustomerDialogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_dialog_layout);
    }

    public void showDialog(View view) {
        showPasswordSetDailog();
    }

    private void showPasswordSetDailog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        View view = View.inflate(this, R.layout.dailog_set_smscode, null);
        // dialog.setView(view);// 将自定义的布局文件设置给dialog
        dialog.setView(view, dpToPx(this,55), 0, dpToPx(this,55), 0);// 设置边距为0,保证在2.x的版本上运行没问题

        final EditText etPasswordConfirm = (EditText) view
                .findViewById(R.id.sms_code);

        Button btnOK = (Button) view.findViewById(R.id.btn_ok);
        Button btnCancel = (Button) view.findViewById(R.id.btn_cancel);

        btnOK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String passwordConfirm = etPasswordConfirm.getText().toString();
                Toast.makeText(CustomerDialogActivity.this, "smscode" + passwordConfirm,
                        Toast.LENGTH_SHORT).show();
                dialog.dismiss();// 隐藏dialog
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();// 隐藏dialog
            }
        });

        dialog.setCancelable(false);
        dialog.show();
    }
    public int dpToPx(Context context, int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
