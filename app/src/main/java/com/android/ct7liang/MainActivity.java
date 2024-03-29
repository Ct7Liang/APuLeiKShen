package com.android.ct7liang;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.ct7liang.activityLifecycle.ActivityLifecycleActivity;
import com.android.ct7liang.addressSelect.AddressSelectActivity;
import com.android.ct7liang.android_gif_drawable.GifDrawableActivity;
import com.android.ct7liang.bankCardCheck.CheckBankCardActivity;
import com.android.ct7liang.bilibiliDanmu.BiliBiliDanmuActivity;
import com.android.ct7liang.changeLogo.ChangeLogoActivity;
import com.android.ct7liang.collapsing.ScrollTypeActivity;
import com.android.ct7liang.crash.CrashActivity;
import com.android.ct7liang.fucking_slide.FuckingVolumeActivity;
import com.android.ct7liang.getContacts.GetContactsActivity;
import com.android.ct7liang.gsyVideoPlayer.GsyVideoPlayerActivity;
import com.android.ct7liang.html.HtmlSelectActivity;
import com.android.ct7liang.imageBlur.ImageBlurActivity;
import com.android.ct7liang.imageView_scaleType.ImageViewScaleTypeActivity;
import com.android.ct7liang.loading.LoadingActivity;
import com.android.ct7liang.login_page.LoginCategoryActivity;
import com.android.ct7liang.menu.MenuActivity;
import com.android.ct7liang.soft_broad_case.SoftActivity;
import com.android.ct7liang.switch_button.SwitchButtonActivity;
import com.android.ct7liang.taiji.TaiJiActivity;
import com.android.ct7liang.taskStack.TaskStackActivity;
import com.android.ct7liang.view_flipper.ViewFlipperActivity;
import com.android.ct7liang.watches.WatchesActivity;
import com.android.ct7liang.zxing.ZXingActivity;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;

public class MainActivity extends BaseActivity {

    private MainItemBean[] dataArr = {
        new MainItemBean("二维码扫描", ZXingActivity.class),
        new MainItemBean("App崩溃处理", CrashActivity.class),
        new MainItemBean("反人类音量控制器", FuckingVolumeActivity.class),
        new MainItemBean("自定义 - 太极", TaiJiActivity.class),
        new MainItemBean("银行卡卡号格式校验", CheckBankCardActivity.class),
        new MainItemBean("ImageView的ScaleType属性", ImageViewScaleTypeActivity.class),
        new MainItemBean("优美流畅的自定义加载视图", LoadingActivity.class),
        new MainItemBean("自定义 - 地址选择器", AddressSelectActivity.class),
        new MainItemBean("BiliBili - 烈焰弹幕使", BiliBiliDanmuActivity.class),
        new MainItemBean("可折叠标题栏", ScrollTypeActivity.class),
        new MainItemBean("SwitchButton", SwitchButtonActivity.class),
        new MainItemBean("图片模糊处理", ImageBlurActivity.class),
        new MainItemBean("仿QQ登录界面", LoginCategoryActivity.class),
        new MainItemBean("菜单控件", MenuActivity.class),
        new MainItemBean("更改App图标", ChangeLogoActivity.class),
        new MainItemBean("键盘焦点处理", SoftActivity.class),
        new MainItemBean("ViewFlipper", ViewFlipperActivity.class),
        new MainItemBean("Activity的生命周期", ActivityLifecycleActivity.class),
        new MainItemBean("Activity的启动模式", TaskStackActivity.class),
        new MainItemBean("加载本地静态Html页面", HtmlSelectActivity.class),
        new MainItemBean("获取手机通话记录", GetContactsActivity.class),
        new MainItemBean("使用GSYVideoPlayer", GsyVideoPlayerActivity.class),
        new MainItemBean("自定义 - 钟表", WatchesActivity.class),
        new MainItemBean("android-gif-drawable - Gif控件", GifDrawableActivity.class),
    };

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void setStatusBar() {
        TitleBarView titleBarView = findViewById(R.id.title_bar_view);
        titleBarView.setStatusBar(this);
        titleBarView.setOnLeftImgClick(new TitleBarView.OnLeftImgClick() {
            @Override
            public void onClick(View view) {
                exitApp();
            }
        });
    }

    @Override
    public void initSurface() {
        initStatusBar();
        ListView listView = findViewById(R.id.menuList);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return dataArr.length;
            }
            @Override
            public Object getItem(int i) {
                return null;
            }
            @Override
            public long getItemId(int i) {
                return 0;
            }
            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                View v;
                if (view == null){
                    v = View.inflate(mAct, R.layout.item_main_menu, null);
                }else{
                    v = view;
                }
                ((TextView)v.findViewById(R.id.name)).setText(dataArr[i].name);
                return v;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(mAct, dataArr[i].cls));
            }
        });
    }

    @Override
    public void onClick(View v) {}

    @Override
    public void onBackPressed() {
        exitApp();
    }

}