package com.android.ct7liang.html;

import android.content.Intent;
import android.view.View;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;

public class HtmlSelectActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_html_select;
    }

    @Override
    protected void setStatusBar() {
        TitleBarView titleBarView = findViewById(R.id.title_bar_view);
        titleBarView.setStatusBar(this);
    }

    @Override
    public void initSurface() {
        initStatusBar();
        findViewById(R.id.yqh).setOnClickListener(this);
        findViewById(R.id.zp).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, HtmlDetailActivity.class);
        switch (view.getId()){
            case R.id.yqh:
                i.putExtra("url", "file:///android_asset/YQH/index.html");
                break;
            case R.id.zp:
                i.putExtra("url", "file:///android_asset/ZP/index.html");
                break;
        }
        startActivity(i);
    }
}
