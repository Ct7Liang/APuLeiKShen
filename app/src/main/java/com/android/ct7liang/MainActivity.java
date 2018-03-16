package com.android.ct7liang;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.android.ct7liang.bank_card.CheckBankCardActivity;
import com.android.ct7liang.crash.CrashActivity;
import com.android.ct7liang.fucking_slide.FuckingVolumeActivity;
import com.android.ct7liang.imageView_scaleType.ImageViewScaleTypeActivity;
import com.android.ct7liang.loading.LoadingActivity;
import com.android.ct7liang.taiji.TaiJiActivity;
import com.android.ct7liang.zxing.ZXingActivity;

public class MainActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void findView() {
        findViewById(R.id.back).setOnClickListener(this);
        findViewById(R.id.zxing).setOnClickListener(this);
        findViewById(R.id.crash).setOnClickListener(this);
        findViewById(R.id.fucking).setOnClickListener(this);
        findViewById(R.id.taiji).setOnClickListener(this);
        findViewById(R.id.luhn).setOnClickListener(this);
        findViewById(R.id.scale_type).setOnClickListener(this);
        findViewById(R.id.loading).setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        ((TextView)findViewById(R.id.title)).setText(getResources().getString(R.string.app_name));
    }

    @Override
    public void initFinish() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                exitApp();
                break;
            case R.id.zxing:
                startActivity(new Intent(mAct, ZXingActivity.class));
                break;
            case R.id.crash:
                startActivity(new Intent(mAct, CrashActivity.class));
                break;
            case R.id.fucking:
                startActivity(new Intent(mAct, FuckingVolumeActivity.class));
                break;
            case R.id.taiji:
                startActivity(new Intent(mAct, TaiJiActivity.class));
                break;
            case R.id.luhn:
                startActivity(new Intent(mAct, CheckBankCardActivity.class));
                break;
            case R.id.scale_type:
                startActivity(new Intent(mAct, ImageViewScaleTypeActivity.class));
                break;
            case R.id.loading:
                startActivity(new Intent(mAct, LoadingActivity.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        exitApp();
    }

}