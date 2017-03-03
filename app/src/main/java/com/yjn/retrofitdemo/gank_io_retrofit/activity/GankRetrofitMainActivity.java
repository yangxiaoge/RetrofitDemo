package com.yjn.retrofitdemo.gank_io_retrofit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


import com.yjn.retrofitdemo.R;
import com.yjn.retrofitdemo.gank_io_retrofit.entity.Subject;
import com.yjn.retrofitdemo.gank_io_retrofit.http.HttpMethods;
import com.yjn.retrofitdemo.gank_io_retrofit.subscribers.ProgressSubscriber;
import com.yjn.retrofitdemo.gank_io_retrofit.subscribers.SubscriberOnNextListener;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * https://github.com/tough1985/RxjavaRetrofitDemo/blob/step6
 */
public class GankRetrofitMainActivity extends AppCompatActivity {

    @Bind(R.id.click_me_BN)
    Button clickMeBN;
    @Bind(R.id.result_TV)
    TextView resultTV;

    /**
     * 不要用Activity直接实现这个接口，
     * 因为在一个Activity或者Fragment中，可能会发出多个请求
     */
    private SubscriberOnNextListener getTopMovieOnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gank_retrofit);
        ButterKnife.bind(this);

        getTopMovieOnNext = new SubscriberOnNextListener<List<Subject>>() {
            //接受到请求结果之后对UI的处理
            @Override
            public void onNext(List<Subject> subjects) {
                resultTV.setText(subjects.toString());
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    /**
     * 如果 GankRetrofitMainActivity是 singleTask启动模式, 那么如果GankRetrofitMainActivity在栈中已经存在,
     * 下次被调用时走的方法就是onNewIntent(不排除内存不足的时候也走onCreate)
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent); //must store the new intent unless getIntent() will return the old one

        Log.d("GankRetrofitMain","onNewIntent");
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @OnClick(R.id.click_me_BN)
    public void onClick() {
        getMovie();
    }

    //进行网络请求
    private void getMovie(){

        HttpMethods.getInstance().getTopMovie(new ProgressSubscriber(getTopMovieOnNext, GankRetrofitMainActivity.this), 0, 10);
    }
}
