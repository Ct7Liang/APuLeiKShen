package com.android.ct7liang.switch_button;

import android.view.View;
import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.ToastUtils;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;
import com.suke.widget.SwitchButton;


public class SwitchButtonActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_switch_button;
    }

    @Override
    protected void setStatusBar() {
        TitleBarView titleBarView = findViewById(R.id.title_bar_view);
        titleBarView.setStatusBar(this);
    }

    @Override
    public void initSurface() {
        initStatusBar();

        SwitchButton switchButton = findViewById(R.id.switch_button);
        switchButton.setChecked(false);
        switchButton.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                ToastUtils.showStatic(mAct, isChecked?"开启":"关闭");
            }
        });
    }



    @Override
    public void onClick(View view) {}
}
