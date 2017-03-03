package com.yjn.retrofitdemo.vectorAnimate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.orhanobut.logger.Logger;
import com.yjn.retrofitdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <pre>
 *      Author: Yang.JiaNan
 *      Time: 2017/3/3 14:29
 *      Email: yang.jianan@zte.com.cn
 *      Desc: http://blog.csdn.net/smartbetter/article/details/54708200
 * </pre>
 */
public class VectorAnimateActivity extends AppCompatActivity {
    @Bind(R.id.image1)
    ImageView image1;
    @Bind(R.id.image2)
    ImageView image2;
    @Bind(R.id.image3)
    ImageView image3;
    @Bind(R.id.image4)
    ImageView image4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vector_animate);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.image1, R.id.image2, R.id.image3, R.id.button9})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image1:
                ObjectAnimator.ofFloat(image1, "translationX", 0F, 200F).setDuration(1000).start();
                break;
            case R.id.image2:
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(image2, "translationX", 0F, 200F);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(image2, "translationY", 0F, 200F);
                AnimatorSet set = new AnimatorSet();
//                set.playTogether(animator1, animator2); //所有动画同时播放：
                set.playSequentially(animator1, animator2); //所有动画按顺序播放：
                set.setDuration(1000).start();

                animator1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        Logger.d("X轴动画结束");
                    }
                });

                animator2.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        Logger.d("Y轴动画结束");
                    }
                });
                break;
            case R.id.image3:
                ObjectAnimator animator11 = ObjectAnimator.ofFloat(image3, "translationX", 0F, 200F);
                ObjectAnimator animator22 = ObjectAnimator.ofFloat(image3, "translationY", 0F, 200F);
                ObjectAnimator animator33 = ObjectAnimator.ofFloat(image3, "rotation", 0F, 360F);
                AnimatorSet set1 = new AnimatorSet();
                set1.play(animator11).with(animator22);//同时
                set1.play(animator33).after(animator11);//之后, 另外还有before之前
                set1.setDuration(1000).start();

                animator11.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        Logger.d("animator11动画结束");
                    }
                });
                animator22.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        Logger.d("animator22动画结束");
                    }
                });
                animator33.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        Logger.d("animator33动画结束");
                    }
                });
                break;

            //↓↓↓↓矢量图动画(VectorDrawable)↓↓↓↓↓
            case R.id.button9:
                Drawable drawable = image4.getDrawable();
                if (drawable instanceof Animatable) {
                    if (((Animatable) drawable).isRunning()) {
                        ((Animatable) drawable).stop();
                    } else {
                        Logger.d("矢量图动画");
                        ((Animatable) drawable).start();
                    }
                }
                break;
        }
    }

}
