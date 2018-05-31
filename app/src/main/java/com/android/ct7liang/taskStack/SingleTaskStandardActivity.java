package com.android.ct7liang.taskStack;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.ScreenUtil;

public class SingleTaskStandardActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_single_task_standard;
    }

    @Override
    protected void setStatusBar() {
        findViewById(R.id.title_back_ground).setBackgroundResource(R.color.AppThemeColor);
        findViewById(R.id.title_back_ground).setPadding(0, ScreenUtil.getUtils().getStatusHeight(this), 0 , 0);
        findViewById(R.id.left_image).setOnClickListener(this);
        ((TextView)findViewById(R.id.center_text)).setText("standard模式");
    }

    @Override
    public void findView() {
        findViewById(R.id.btn).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
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
            case R.id.btn:
                startActivity(new Intent(this, SingleTaskStandardActivity.class));
                break;
            case R.id.btn1:
                startActivity(new Intent(this, SingleTaskActivity.class));
                break;
        }
    }
}
