package com.android.ct7liang.taiji;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;

public class TaiJiActivity extends BaseActivity {

    private TaiJiView mTaiJi;

    @Override
    public int setLayout() {
        return R.layout.activity_taiji;
    }

    @Override
    public void findView() {
        findViewById(R.id.back).setOnClickListener(this);
        mTaiJi = (TaiJiView) findViewById(R.id.taiJi);
        mTaiJi.setOnClickListener(this);
    }

    @Override
    public void initData() {}

    @Override
    public void initView() {}

    @Override
    public void initFinish() {}

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.taiJi:
                Animation animation = AnimationUtils.loadAnimation(TaiJiActivity.this, R.anim.taiji_rotate);
                mTaiJi.startAnimation(animation);//开始动画
                break;
        }
    }
}