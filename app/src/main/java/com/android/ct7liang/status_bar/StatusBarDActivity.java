package com.android.ct7liang.status_bar;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.ScreenInfoUtil;

public class StatusBarDActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_status_bar_d;
    }

    @Override
    public void findView() {
        findViewById(R.id.left_image).setOnClickListener(this);
        findViewById(R.id.title_back_ground).setBackgroundColor(Color.parseColor("#00FFFFFF"));
        ((TextView)findViewById(R.id.left_text)).setText("标题栏+背景图片沉浸");
    }

    @Override
    protected void setStatusBar() {
        findViewById(R.id.title_back_ground).setPadding(0, ScreenInfoUtil.getStatusHeight(this), 0, 0);
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
