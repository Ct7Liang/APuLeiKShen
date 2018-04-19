package com.android.ct7liang;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.android.ct7liang.address_select.AddressSelectActivity;
import com.android.ct7liang.bank_card.CheckBankCardActivity;
import com.android.ct7liang.bilibili_danmu.BiliBiliDanmuActivity;
import com.android.ct7liang.blur.BlurAActivity;
import com.android.ct7liang.collapsing.ScrollTypeActivity;
import com.android.ct7liang.crash.CrashActivity;
import com.android.ct7liang.fucking_slide.FuckingVolumeActivity;
import com.android.ct7liang.imageView_scaleType.ImageViewScaleTypeActivity;
import com.android.ct7liang.loading.LoadingActivity;
import com.android.ct7liang.login_page.LoginCategoryActivity;
import com.android.ct7liang.menu.MenuActivity;
import com.android.ct7liang.status_bar.StatusBarCategoryActivity;
import com.android.ct7liang.switch_button.SwitchButtonActivity;
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
        findViewById(R.id.address_select).setOnClickListener(this);
        findViewById(R.id.danmu).setOnClickListener(this);
        findViewById(R.id.scroll).setOnClickListener(this);
        findViewById(R.id.switch_button).setOnClickListener(this);
        findViewById(R.id.status_bar).setOnClickListener(this);
        findViewById(R.id.image_blur).setOnClickListener(this);
        findViewById(R.id.login_page).setOnClickListener(this);
        findViewById(R.id.menu).setOnClickListener(this);
    }

    @Override
    public void initData() {}

    @Override
    public void initView() {
        ((TextView)findViewById(R.id.title)).setText(getResources().getString(R.string.app_name));
    }

    @Override
    public void initFinish() {}

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
            case R.id.address_select:
                startActivity(new Intent(mAct, AddressSelectActivity.class));
                break;
            case R.id.danmu:
                startActivity(new Intent(mAct, BiliBiliDanmuActivity.class));
                break;
            case R.id.scroll:
                startActivity(new Intent(mAct, ScrollTypeActivity.class));
                break;
            case R.id.switch_button:
                startActivity(new Intent(mAct, SwitchButtonActivity.class));
                break;
            case R.id.status_bar:
                startActivity(new Intent(mAct, StatusBarCategoryActivity.class));
                break;
            case R.id.image_blur:
                startActivity(new Intent(mAct, BlurAActivity.class));
                break;
            case R.id.login_page:
                startActivity(new Intent(mAct, LoginCategoryActivity.class));
                break;
            case R.id.menu:
                startActivity(new Intent(mAct, MenuActivity.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        exitApp();
    }

}