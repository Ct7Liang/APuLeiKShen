package com.android.ct7liang;

import android.app.Application;

import com.ct7liang.tangyuan.utils.LogUtils;
import com.ct7liang.tangyuan.utils.SpUtils;
import com.ct7liang.tangyuan.utils.ToastUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * Created by Administrator on 2018-02-08.
 *
 */

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SpUtils.init(this);//初始化SharedPreferences
        ToastUtils.setIsShowTestEnable(true); //是否显示用于测试的Toast 默认为true
        LogUtils.setTag("TAG");
        LogUtils.setLogEnable(true); //后台日志 默认为true
        LogUtils.setShowLocationEnable(true); //打印日志的时候是否打印位置信息 默认为false

        initZXing();
    }

    private void initZXing() {
        ZXingLibrary.initDisplayOpinion(this);
    }
}
