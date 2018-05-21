package com.android.ct7liang.bankCardCheck;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.QueryImageResourceActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.ToastUtils;
import java.util.ArrayList;

public class CheckBankCardActivity extends BaseActivity {

    private EditText edit;
    private ArrayList<Integer> list = new ArrayList<>();

    @Override
    public int setLayout() {
        return R.layout.activity_check_bank_card;
    }

    @Override
    public void findView() {
        findViewById(R.id.back).setOnClickListener(this);
        ((TextView)findViewById(R.id.title)).setText("符合Luhn规则的银行卡卡号的格式");
        edit = findViewById(R.id.edit);
        findViewById(R.id.check).setOnClickListener(this);
        findViewById(R.id.img_a).setOnClickListener(this);
        findViewById(R.id.img_b).setOnClickListener(this);
    }

    @Override
    public void initData() {
        list.add(R.mipmap.luhn01);
        list.add(R.mipmap.luhn02);
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
            case R.id.back:
                finish();
                break;
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
