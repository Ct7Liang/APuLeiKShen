package com.android.ct7liang;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class SplashActivity extends BaseActivity {

    private static SplashActivity activity;

    private static Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            activity.startActivity(new Intent(activity, MainActivity.class));
            activity.finish();
        }
    };

    @Override
    protected void setStatusBar() {
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        getWindow().setFlags(flag, flag);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void findView() {
        ImageView image = (ImageView) findViewById(R.id.image);
        image.setImageResource(R.drawable.splash_img_01);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initFinish() {
        activity = this;
        handler.sendEmptyMessageDelayed(0, 4500);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activity = null;
        handler.removeMessages(0);
    }
}