package com.android.ct7liang.taiji;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;

public class TaiJiActivity extends BaseActivity {

    private TaiJiView mTaiJi;

    @Override
    public int setLayout() {
        return R.layout.activity_taiji;
    }



    @Override
    protected void setStatusBar() {
        TitleBarView titleBarView = findViewById(R.id.title_bar_view);
        titleBarView.setStatusBar(this);
    }

    @Override
    public void initSurface() {
        initStatusBar();
        mTaiJi = (TaiJiView) findViewById(R.id.taiJi);
        mTaiJi.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.taiJi:
                Animation animation = AnimationUtils.loadAnimation(TaiJiActivity.this, R.anim.taiji_rotate);
                mTaiJi.startAnimation(animation);//开始动画
                break;
        }
    }
}