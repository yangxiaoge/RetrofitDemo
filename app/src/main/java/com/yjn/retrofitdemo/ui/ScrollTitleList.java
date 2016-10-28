package com.yjn.retrofitdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.yjn.retrofitdemo.R;

/**
 * Created by yjn on 2016/10/26.
 */
public class ScrollTitleList extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrolllist);
    }

    public void first(View view) {
        Toast.makeText(this,"111111111",Toast.LENGTH_SHORT).show();
    }

    public void second(View view) {
        Toast.makeText(this,"2222222",Toast.LENGTH_SHORT).show();
    }
}
