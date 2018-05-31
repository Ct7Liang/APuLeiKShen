package com.android.ct7liang.taskStack;

import android.content.Intent;
import android.view.View;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;

public class TaskStackActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_task_stack;
    }

    @Override
    public void findView() {
        findViewById(R.id.standard).setOnClickListener(this);
        findViewById(R.id.singleTop).setOnClickListener(this);
        findViewById(R.id.singleTask).setOnClickListener(this);
        findViewById(R.id.singleInstance).setOnClickListener(this);
        initStatusBar();
    }

    @Override
    protected void setStatusBar() {
        TitleBarView titleBarView = findViewById(R.id.title_bar_view);
        titleBarView.setStatusBar(this);
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
            case R.id.standard:
                startActivity(new Intent(this, StandardActivity.class));
                break;
            case R.id.singleTop:
                startActivity(new Intent(this, SingleTopActivity.class));
                break;
            case R.id.singleTask:
                startActivity(new Intent(this, SingleTaskActivity.class));
                break;
            case R.id.singleInstance:
                startActivity(new Intent(this, SingleInstanceActivity.class));
                break;
        }
    }
}
