package com.android.ct7liang.menu;

import android.content.Intent;
import android.view.View;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.android.ct7liang.menu.boomMenu.BoomMenuActivity;
import com.android.ct7liang.menu.contextMenu.ContextMenuActivity;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;

public class MenuActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_menu;
    }

    @Override
    public void findView() {
        initStatusBar();
        findViewById(R.id.boom).setOnClickListener(this);
        findViewById(R.id.context_menu).setOnClickListener(this);
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
            case R.id.boom:
                startActivity(new Intent(this, BoomMenuActivity.class));
                break;
            case R.id.context_menu:
                startActivity(new Intent(this, ContextMenuActivity.class));
                break;
        }
    }
}
