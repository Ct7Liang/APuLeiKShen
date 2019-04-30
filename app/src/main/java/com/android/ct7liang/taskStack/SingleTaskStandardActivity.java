package com.android.ct7liang.taskStack;

import android.content.Intent;
import android.view.View;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;

public class SingleTaskStandardActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_single_task_standard;
    }


    @Override
    protected void setStatusBar() {
        TitleBarView titleBarView = findViewById(R.id.title_bar_view);
        titleBarView.setStatusBar(this);
    }

    @Override
    public void initSurface() {
        findViewById(R.id.btn).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        initStatusBar();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn:
                startActivity(new Intent(this, SingleTaskStandardActivity.class));
                break;
            case R.id.btn1:
                startActivity(new Intent(this, SingleTaskActivity.class));
                break;
        }
    }
}
