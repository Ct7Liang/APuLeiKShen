package com.android.ct7liang.status_bar;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;

public class StatusBarCategoryActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_status_bar_category;
    }

    @Override
    public void findView() {
        findViewById(R.id.left_image).setOnClickListener(this);
        ((TextView)findViewById(R.id.center_text)).setText("沉浸式状态栏实现");
        findViewById(R.id.title_back_ground).setBackgroundResource(R.color.AppThemeColor);
        findViewById(R.id.a).setOnClickListener(this);
        findViewById(R.id.b).setOnClickListener(this);
        findViewById(R.id.c).setOnClickListener(this);
        findViewById(R.id.d).setOnClickListener(this);
        findViewById(R.id.e).setOnClickListener(this);
        findViewById(R.id.f).setOnClickListener(this);
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
            case R.id.a:
                startActivity(new Intent(this, StatusBarAActivity.class));
                break;
            case R.id.b:
                startActivity(new Intent(this, StatusBarBActivity.class));
                break;
            case R.id.c:
                startActivity(new Intent(this, StatusBarCActivity.class));
                break;
            case R.id.d:
                startActivity(new Intent(this, StatusBarDActivity.class));
                break;
            case R.id.e:
                startActivity(new Intent(this, StatusBarEActivity.class));
                break;
            case R.id.f:
                startActivity(new Intent(this, StatusBarFActivity.class));
                break;
        }
    }
}