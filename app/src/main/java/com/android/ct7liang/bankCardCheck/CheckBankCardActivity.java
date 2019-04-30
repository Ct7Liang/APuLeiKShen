package com.android.ct7liang.bankCardCheck;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.QueryImageResourceActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.ToastUtils;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;

import java.util.ArrayList;

public class CheckBankCardActivity extends BaseActivity {

    private EditText edit;
    private ArrayList<Integer> list = new ArrayList<>();

    @Override
    public int setLayout() {
        return R.layout.activity_check_bank_card;
    }

    @Override
    protected void setStatusBar() {
        TitleBarView titleBarView = findViewById(R.id.title_bar_view);
        titleBarView.setStatusBar(this);
    }

    @Override
    public void initSurface() {
        initStatusBar();
        edit = findViewById(R.id.edit);
        findViewById(R.id.check).setOnClickListener(this);
        findViewById(R.id.img_a).setOnClickListener(this);
        findViewById(R.id.img_b).setOnClickListener(this);
        list.add(R.mipmap.luhn01);
        list.add(R.mipmap.luhn02);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.check:
                String trim = edit.getText().toString().trim();
                if (TextUtils.isEmpty(trim)){
                    ToastUtils.showStatic(mAct, "请首先输入一个银行卡号码!");
                    return;
                }
                if (BankCardUtils.isTrue(trim)){
                    ToastUtils.showStatic(mAct, "该银行卡号码符合Luhn规则");
                }else{
                    ToastUtils.showStatic(mAct, "该银行卡号码不符合Luhn规则");
                }
                break;
            case R.id.img_a:
                QueryImageResourceActivity.start(mAct, list, 0);
                break;
            case R.id.img_b:
                QueryImageResourceActivity.start(mAct, list, 1);
                break;
        }
    }
}
