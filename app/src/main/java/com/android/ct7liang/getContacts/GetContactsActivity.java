package com.android.ct7liang.getContacts;

import android.view.View;
import android.widget.TextView;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;

public class GetContactsActivity extends BaseActivity {

    private boolean isTrue;
    private TextView tv;

    @Override
    public int setLayout() {
        return R.layout.activity_get_contacts;
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
        tv = findViewById(R.id.tv);
    }

    @Override
    public void onClick(View view) {
        String data = null;
        switch (view.getId()){
            case R.id.btn:
                if (!isTrue){
                    data = ContactsUtils.getData(this, getContentResolver());
                }else{
                    data = LastContactUtils.getData(this, getContentResolver());
                }
                isTrue = !isTrue;
                break;
        }
        if (data!=null){
            tv.setText(data);
        }
    }
}
