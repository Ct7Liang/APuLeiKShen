package com.android.ct7liang.collapsing;

import android.content.Intent;
import android.view.View;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;

public class ScrollTypeActivity extends BaseActivity{

    @Override
    public int setLayout() {
        return R.layout.activity_scroll_type;
    }

    @Override
    public void findView() {
        findViewById(R.id.a).setOnClickListener(this);
        findViewById(R.id.c).setOnClickListener(this);
        findViewById(R.id.b).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
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
        switch (view.getId()){
            case R.id.a:
                startActivity(new Intent(mAct, ScrollingActivity.class));
                break;
            case R.id.c:
                startActivity(new Intent(mAct, Scrolling01Activity.class));
                break;
            case R.id.b:
                startActivity(new Intent(mAct, CustomScrollingActivity.class));
                break;
            case R.id.back:
                finish();
                break;
        }
    }
}
