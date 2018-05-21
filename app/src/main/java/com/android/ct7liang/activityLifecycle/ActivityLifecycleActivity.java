package com.android.ct7liang.activityLifecycle;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.QueryImageResourceActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.LogUtils;
import com.ct7liang.tangyuan.utils.ScreenInfoUtil;
import java.util.ArrayList;

/**
 *
 */

public class ActivityLifecycleActivity extends BaseActivity {

    private TextView A;
    private StringBuilder content;
    private ArrayList<Integer> list;

    @Override
    public int setLayout() {
        return R.layout.activity_activity_lifecycle;
    }

    @Override
    public void getOnCreateParams(Bundle savedInstanceState) {
        super.getOnCreateParams(savedInstanceState);
        content = new StringBuilder("onCreate()\n");
        LogUtils.write("onCreate()");
    }

    @Override
    public void findView() {
        A = findViewById(R.id.a);
        findViewById(R.id.btn).setOnClickListener(this);
        findViewById(R.id.image).setOnClickListener(this);
    }

    @Override
    protected void setStatusBar() {
        findViewById(R.id.title_back_ground).setBackgroundResource(R.color.AppThemeColor);
        findViewById(R.id.title_back_ground).setPadding(0, ScreenInfoUtil.getStatusHeight(this), 0, 0);
        ((TextView)findViewById(R.id.center_text)).setText("Activity的生命周期");
        findViewById(R.id.left_image).setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initFinish() {
        list = new ArrayList<>();
        list.add(R.mipmap.activity_live_image);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.left_image:
                finish();
                break;
            case R.id.btn:
                content = new StringBuilder();
                A.setText("");
                break;
            case R.id.image:
                QueryImageResourceActivity.start(this, list, 0);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.write("onStart()");
        A.setText(content.append("onStart()\n"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.write("onStop()");
        A.setText(content.append("onStop()\n"));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.write("onRestart()");
        A.setText(content.append("onRestart()\n"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.write("onResume()");
        A.setText(content.append("onResume()\n"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.write("onPause()");
        A.setText(content.append("onPause()\n"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.write("onDestroy()");
        A.setText(content.append("onDestroy()\n"));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtils.write("onSaveInstanceState()");
        A.setText(content.append("onSaveInstanceState()\n"));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtils.write("onRestoreInstanceState()");
        A.setText(content.append("onRestoreInstanceState()\n"));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LogUtils.write("onConfigurationChanged()");
        A.setText(content.append("onConfigurationChanged()\n"));
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        LogUtils.write("onWindowFocusChanged()");
        A.setText(content.append("onWindowFocusChanged():"+ hasFocus +"\n"));
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogUtils.write("onAttachedToWindow()");
        A.setText(content.append("onAttachedToWindow()\n"));
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtils.write("onDetachedFromWindow()");
        A.setText(content.append("onDetachedFromWindow()\n"));
    }

//    DisplayManagerService: Display device changed state: "内置屏幕", OFF
}