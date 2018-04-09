package com.android.ct7liang.login_page;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.ScreenInfoUtil;

public class LoginCategoryActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_login_category;
    }

    @Override
    public void findView() {
        findViewById(R.id.title_back_ground).setBackgroundResource(R.color.AppThemeColor);
        ((TextView)findViewById(R.id.left_text)).setText("登录页面");
        findViewById(R.id.left_image).setOnClickListener(this);
        findViewById(R.id.a).setOnClickListener(this);
        findViewById(R.id.b).setOnClickListener(this);
        findViewById(R.id.c).setOnClickListener(this);
        findViewById(R.id.d).setOnClickListener(this);
        findViewById(R.id.e).setOnClickListener(this);
    }

    @Override
    protected void setStatusBar() {
        findViewById(R.id.title_back_ground).setPadding(0, ScreenInfoUtil.getStatusHeight(this), 0, 0);
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
            case R.id.e:
                startActivity(new Intent(this, LoginEActivity.class));
                break;
        }
    }
}
