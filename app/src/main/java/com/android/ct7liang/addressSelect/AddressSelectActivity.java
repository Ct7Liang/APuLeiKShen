package com.android.ct7liang.addressSelect;

import android.view.View;
import android.widget.Toast;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.address.AddressUtils;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;

public class AddressSelectActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_address_select;
    }

    @Override
    protected void setStatusBar() {
        TitleBarView titleBarView = findViewById(R.id.title_bar_view);
        titleBarView.setStatusBar(this);
    }

    @Override
    public void initSurface() {
        initStatusBar();
        findViewById(R.id.btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn:
                AddressUtils.getInstance().showSelectWindow(findViewById(R.id.btn), mAct, new AddressUtils.OnAddressSelected() {
                    @Override
                    public void onSelected(String code, String name) {
                        Toast.makeText(mAct, code + " -- " + name, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.back:
                finish();
                break;
        }
    }
}