package com.android.ct7liang.crash;

import android.view.View;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;

public class DealCrashActivityA extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_deal_crash_a;
    }

    @Override
    public void findView() {
        initStatusBar();
    }

    @Override
    protected void setStatusBar() {
        TitleBarView titleBarView = findViewById(R.id.title_bar_view);
        titleBarView.setStatusBar(this);
        titleBarView.setOnLeftImgClick(new TitleBarView.OnLeftImgClick() {
            @Override
            public void onClick(View view) {
                exitApp();
            }
        });
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

    }

    @Override
    public void onBackPressed() {
        exitApp();
    }
}