package com.android.ct7liang.switch_button;

import android.view.View;
import android.widget.TextView;
import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.ToastUtils;
import com.suke.widget.SwitchButton;

public class SwitchButtonActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_switch_button;
    }

    @Override
    public void findView() {
        findViewById(R.id.back).setOnClickListener(this);
        ((TextView)findViewById(R.id.title)).setText("SwitchButton");
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
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
    public void initFinish() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
        }
    }
}
