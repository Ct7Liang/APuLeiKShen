package com.android.ct7liang.login_page;

import android.content.Intent;
import android.view.View;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;

public class LoginCategoryActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_login_category;
    }

    @Override
    protected void setStatusBar() {
        TitleBarView titleBarView = findViewById(R.id.title_bar_view);
        titleBarView.setStatusBar(this);
    }

    @Override
    public void initSurface() {
        initStatusBar();
        findViewById(R.id.a).setOnClickListener(this);
        findViewById(R.id.b).setOnClickListener(this);
        findViewById(R.id.c).setOnClickListener(this);
        findViewById(R.id.d).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.left_image:
                finish();
                break;
            case R.id.a:
                startActivity(new Intent(this, LoginAActivity.class));
                break;
            case R.id.b:
                startActivity(new Intent(this, LoginBActivity.class));
                break;
            case R.id.c:
                startActivity(new Intent(this, LoginCActivity.class));
                break;
            case R.id.d:
                startActivity(new Intent(this, LoginDActivity.class));
                break;
        }
    }
}
