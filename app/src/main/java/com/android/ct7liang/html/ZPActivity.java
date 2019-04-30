package com.android.ct7liang.html;

import android.view.View;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;

public class ZPActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_zp;
    }


    @Override
    protected void setStatusBar() {
        TitleBarView titleBarView = findViewById(R.id.title_bar_view);
        titleBarView.setStatusBar(this);
    }

    @Override
    public void initSurface() {
        initStatusBar();
    }

    @Override
    public void onClick(View view) {

    }
}
