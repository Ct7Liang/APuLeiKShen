package com.android.ct7liang.taskStack;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.ScreenInfoUtil;

public class TaskStackActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_task_stack;
    }

    @Override
    protected void setStatusBar() {
        findViewById(R.id.title_back_ground).setBackgroundResource(R.color.AppThemeColor);
        findViewById(R.id.title_back_ground).setPadding(0, ScreenInfoUtil.getStatusHeight(this), 0 , 0);
        findViewById(R.id.left_image).setOnClickListener(this);
        ((TextView)findViewById(R.id.center_text)).setText("Activity启动模式");
    }

    @Override
    public void findView() {
        findViewById(R.id.standard).setOnClickListener(this);
        findViewById(R.id.singleTop).setOnClickListener(this);
        findViewById(R.id.singleTask).setOnClickListener(this);
        findViewById(R.id.singleInstance).setOnClickListener(this);
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
