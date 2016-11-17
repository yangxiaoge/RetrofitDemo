package com.yjn.retrofitdemo.ui;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by yjn on 2016/10/31.
 */

public class MyProgressDialog extends ProgressDialog {

    public MyProgressDialog(Context context) {
        super(context);
    }

    public MyProgressDialog(Context context, int theme) {
        super(context, theme);
    }
}
