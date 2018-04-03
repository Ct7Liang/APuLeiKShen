package com.android.ct7liang.status_bar;

import android.graphics.Color;
import android.view.View;
import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.ScreenInfoUtil;

public class StatusBarAActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_status_bar_a;
    }

    @Override
    protected void setStatusBar() {
        findViewById(R.id.title_back_ground).setPadding(0, ScreenInfoUtil.getStatusHeight(this), 0, 0);
    }

    @Override
    public void findView() {
        findViewById(R.id.title_back_ground).setBackgroundColor(Color.parseColor("#D84C29"));
        findViewById(R.id.left_image).setOnClickListener(this);
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
            case R.id.left_image:
                finish();
                break;
        }
    }
}