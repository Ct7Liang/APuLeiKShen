package com.android.ct7liang.addressSelect;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.address.AddressUtils;

public class AddressSelectActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_address_select;
    }

    @Override
    public void findView() {
        ((TextView)findViewById(R.id.title)).setText("地址三级联动控件");
        findViewById(R.id.btn).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
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