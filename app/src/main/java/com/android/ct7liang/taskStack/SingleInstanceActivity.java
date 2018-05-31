package com.android.ct7liang.taskStack;

import android.content.Intent;
import android.view.View;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;

public class SingleInstanceActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_single_instance;
    }



    @Override
    public void findView() {
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
            case R.id.btn:
                startActivity(new Intent(this, SingleInstanceActivity.class));
                break;
        }
    }
}
