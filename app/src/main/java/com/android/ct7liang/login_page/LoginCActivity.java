package com.android.ct7liang.login_page;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;

public class LoginCActivity extends BaseActivity {

    private ImageView image;

    @Override
    public int setLayout() {
        return R.layout.activity_login_c;
    }

    @Override
    protected void setStatusBar() {

    }

    @Override
    public void findView() {
        image = findViewById(R.id.image);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(mAct, R.anim.login_bg_rotate_anim);
                image.startAnimation(animation);
            }
        }, 500);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initFinish() {

    }

    @Override
    public void onClick(View view) {

    }
}
