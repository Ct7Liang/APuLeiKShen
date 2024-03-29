package com.android.ct7liang.crash;

import android.view.View;
import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.BaseApp;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;

/**
 * 解决 注入依赖后 Error:Failed to resolve: com.android.support:appcompat-v7:27.0.1
 * project build.gradle :
 *  allprojects {
 *      repositories {
 *          jcenter()
 *          maven { url 'https://maven.google.com' }
 *      }
 *  }
 */
public class CrashActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_crash;
    }

    @Override
    protected void setStatusBar() {
        super.setStatusBar();
        TitleBarView titleBarView = findViewById(R.id.title_bar_view);
        titleBarView.setStatusBar(this);
    }

    @Override
    public void initSurface() {
        findViewById(R.id.a).setOnClickListener(this);
        findViewById(R.id.b).setOnClickListener(this);
        findViewById(R.id.c).setOnClickListener(this);
        findViewById(R.id.d).setOnClickListener(this);
        initStatusBar();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.a:
                BaseApp.builder.errorActivity(DealCrashActivityA.class);
                break;
            case R.id.b:
                BaseApp.builder.errorActivity(DealCrashActivityB.class);
                break;
            case R.id.c:
                BaseApp.builder.errorActivity(null);
                break;
            case R.id.d:
                throw new NullPointerException("该异常用于测试崩溃处理模块!");
        }
    }
}
