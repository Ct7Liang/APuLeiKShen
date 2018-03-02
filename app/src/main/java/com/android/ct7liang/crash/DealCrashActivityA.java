package com.android.ct7liang.crash;

import android.view.View;
import android.widget.TextView;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;

public class DealCrashActivityA extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_deal_crash_a;
    }

    @Override
    public void findView() {
        findViewById(R.id.back).setOnClickListener(this);
        ((TextView)findViewById(R.id.title)).setText("崩溃后跳转页面A");
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                exitApp();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        exitApp();
    }
}