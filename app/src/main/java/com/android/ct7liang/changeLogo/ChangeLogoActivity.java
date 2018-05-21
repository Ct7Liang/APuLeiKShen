package com.android.ct7liang.changeLogo;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.ToastUtils;
import java.util.List;

public class ChangeLogoActivity extends BaseActivity {

    private String[] activity_aliases = {
            "com.android.ct7liang.icon",
            "com.android.ct7liang.icon01",
            "com.android.ct7liang.icon02",
            "com.android.ct7liang.icon03",
            "com.android.ct7liang.icon04",
            "com.android.ct7liang.icon05",
            "com.android.ct7liang.icon06"
    };

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    changeIcon(activity_aliases[0]);
                    break;
                case 1:
                    changeIcon(activity_aliases[1]);
                    break;
                case 2:
                    changeIcon(activity_aliases[2]);
                    break;
                case 3:
                    changeIcon(activity_aliases[3]);
                    break;
                case 4:
                    changeIcon(activity_aliases[4]);
                    break;
                case 5:
                    changeIcon(activity_aliases[5]);
                    break;
                case 6:
                    changeIcon(activity_aliases[6]);
                    break;
            }
        }
    };

    @Override
    public int setLayout() {
        return R.layout.activity_change_logo;
    }

    @Override
    public void findView() {
        findViewById(R.id.resume_icon).setOnClickListener(this);
        findViewById(R.id.change_icon_01).setOnClickListener(this);
        findViewById(R.id.change_icon_02).setOnClickListener(this);
        findViewById(R.id.change_icon_03).setOnClickListener(this);
        findViewById(R.id.change_icon_04).setOnClickListener(this);
        findViewById(R.id.change_icon_05).setOnClickListener(this);
        findViewById(R.id.change_icon_06).setOnClickListener(this);
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
            case R.id.resume_icon:
                handler.sendEmptyMessageDelayed(0, 500);
                break;
            case R.id.change_icon_01:
                handler.sendEmptyMessageDelayed(1, 500);
                break;
            case R.id.change_icon_02:
                handler.sendEmptyMessageDelayed(2, 500);
                break;
            case R.id.change_icon_03:
                handler.sendEmptyMessageDelayed(3, 500);
                break;
            case R.id.change_icon_04:
                handler.sendEmptyMessageDelayed(4, 500);
                break;
            case R.id.change_icon_05:
                handler.sendEmptyMessageDelayed(5, 500);
                break;
            case R.id.change_icon_06:
                handler.sendEmptyMessageDelayed(6, 500);
                break;
        }
    }

    private void changeIcon(String activity_alias) {

        Context ctx = getApplication();
        PackageManager pm = ctx.getPackageManager();

        for (int i = 0; i < activity_aliases.length; i++) {
            String activity_aliase = activity_aliases[i];
            int state;
            if (activity_aliase.equals(activity_alias)){
                state = PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
            }else{
                state = PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
            }
            pm.setComponentEnabledSetting(
                    new ComponentName(ctx, activity_aliase),
                    state,
                    PackageManager.DONT_KILL_APP);
        }
        ToastUtils.showStatic(this, "success!");

        //干掉桌面app，让它自动重启。
        ActivityManager am = (ActivityManager) ctx.getSystemService(Activity.ACTIVITY_SERVICE);
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.addCategory(Intent.CATEGORY_DEFAULT);
        List<ResolveInfo> resolves = pm.queryIntentActivities(i, 0);
        for (ResolveInfo res : resolves) {
            if (res.activityInfo != null) {
                am.killBackgroundProcesses(res.activityInfo.packageName);
            }
        }

    }
}
