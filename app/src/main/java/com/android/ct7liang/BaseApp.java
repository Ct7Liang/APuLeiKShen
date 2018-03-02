package com.android.ct7liang;

import android.app.Application;

import com.ct7liang.tangyuan.AppFolder;
import com.ct7liang.tangyuan.utils.LogUtils;
import com.ct7liang.tangyuan.utils.SpUtils;
import com.ct7liang.tangyuan.utils.ToastUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import cat.ereza.customactivityoncrash.config.CaocConfig;

/**
 * Created by Administrator on 2018-02-08.
 *
 */

public class BaseApp extends Application {

    public static CaocConfig.Builder builder;

    @Override
    public void onCreate() {
        super.onCreate();

        SpUtils.init(this);//初始化SharedPreferences
        ToastUtils.setIsShowTestEnable(true); //是否显示用于测试的Toast 默认为true
        LogUtils.setTag("TAG");
        LogUtils.setLogEnable(true); //后台日志 默认为true
        LogUtils.setShowLocationEnable(true); //打印日志的时候是否打印位置信息 默认为false
        AppFolder.createAppFolder("MyApp");

        initCrash();
        initZxing();

    }

    private void initCrash() {
        //整个配置属性，可以设置一个或多个，也可以一个都不设置
        builder = CaocConfig.Builder.create()
                //程序在后台时，发生崩溃的三种处理方式
                //BackgroundMode.BACKGROUND_MODE_SHOW_CUSTOM: //当应用程序处于后台时崩溃，也会启动错误页面，
                //BackgroundMode.BACKGROUND_MODE_CRASH:      //当应用程序处于后台崩溃时显示默认系统错误（一个系统提示的错误对话框），
                //BackgroundMode.BACKGROUND_MODE_SILENT:     //当应用程序处于后台时崩溃，默默地关闭程序！这种模式我感觉最好
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //default: CaocConfig.BACKGROUND_MODE_SHOW_CUSTOM
                //这阻止了对崩溃的拦截,false表示阻止。用它来禁用customactivityoncrash框架
                .enabled(true) //default: true
                //这将隐藏错误活动中的“错误详细信息”按钮，从而隐藏堆栈跟踪。
                .showErrorDetails(false) //default: true
                //是否可以重启页面
                .showRestartButton(false) //default: true
                //错误页面中显示错误详细信息
                .logErrorOnRestart(false) //default: true
                //错误页面中显示错误详细信息
                .trackActivities(true) //default: false
                //定义应用程序崩溃之间的最短时间，以确定我们不在崩溃循环中。比如：在规定的时间内再次崩溃，框架将不处理，让系统处理！
                .minTimeBetweenCrashesMs(2000); //default: 3000
                //崩溃页面显示的图标
//                .errorDrawable(R.mipmap.ic_launcher)//default: bug image
//                .restartActivity(MainActivity.class)      //重新启动后的页面
//                .errorActivity(DefaultErrorActivity.class) //程序崩溃后显示的页面
//                .eventListener(new CustomEventListener())//设置监听
        builder.apply();
    }

    private void initZxing() {
        ZXingLibrary.initDisplayOpinion(this);
    }

    /**
     * 监听程序崩溃/重启
     */
    private static class CustomEventListener implements CustomActivityOnCrash.EventListener {
        //程序崩溃回调
        @Override
        public void onLaunchErrorActivity() {
            LogUtils.write("onLaunchErrorActivity()");
        }
        //重启程序时回调
        @Override
        public void onRestartAppFromErrorActivity() {
            LogUtils.write("onRestartAppFromErrorActivity()");
        }
        //在崩溃提示页面关闭程序时回调
        @Override
        public void onCloseAppFromErrorActivity() {
            LogUtils.write("onCloseAppFromErrorActivity()");
        }
    }
}