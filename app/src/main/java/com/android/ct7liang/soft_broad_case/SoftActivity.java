package com.android.ct7liang.soft_broad_case;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;

public class SoftActivity extends BaseActivity {

    private EditText editText;
    private EditText editText01;

    @Override
    public int setLayout() {
        return R.layout.activity_edit_text;
    }

    @Override
    public void findView() {
        editText = findViewById(R.id.et_edit_text);
        editText01 = findViewById(R.id.et_edit_text_01);
        findViewById(R.id.close_01).setOnClickListener(this);
        findViewById(R.id.close).setOnClickListener(this);
        findViewById(R.id.open_01).setOnClickListener(this);
        findViewById(R.id.open).setOnClickListener(this);
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
            case R.id.close:
                editText.clearFocus();
                InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                break;
            case R.id.open:
                editText.requestFocus();
                InputMethodManager immer = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
                immer.showSoftInput(editText, 0);
                break;
            case R.id.close_01:
                editText01.clearFocus();
                InputMethodManager imm01 = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm01.hideSoftInputFromWindow(editText01.getWindowToken(), 0);
                break;
            case R.id.open_01:
                editText01.requestFocus();
                InputMethodManager immer01 = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
                immer01.showSoftInput(editText01, 0);
                break;
        }
    }
}
