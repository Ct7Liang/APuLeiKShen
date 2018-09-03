package com.android.ct7liang.imageBlur;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.ToastUtils;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;

import jp.wasabeef.blurry.Blurry;

public class ImageBlurActivity extends BaseActivity {

    private ImageView imageView;
    private EditText edit_a;
    private EditText edit_b;

    @Override
    public int setLayout() {
        return R.layout.activity_blur_a;
    }

    @Override
    protected void setStatusBar() {
        TitleBarView title = findViewById(R.id.title_bar_view);
        title.setStatusBar(this);
    }

    @Override
    public void findView() {
        initStatusBar();
        imageView = (ImageView)findViewById(R.id.image);
        edit_a = findViewById(R.id.number_a);
        edit_b = findViewById(R.id.number_b);
        findViewById(R.id.blur).setOnClickListener(this);
        findViewById(R.id.resume).setOnClickListener(this);
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
            case R.id.resume:
                imageView.setImageResource(R.mipmap.img_02);
                break;
            case R.id.blur:
                String a = edit_a.getText().toString().trim();
                String b = edit_b.getText().toString().trim();
                if (TextUtils.isEmpty(a)||TextUtils.isEmpty(b)){
                    ToastUtils.showStatic(mAct, "参数不能为空");
                    return;
                }
                int ai = Integer.parseInt(a);
                int bi = Integer.parseInt(b);
                if (ai==0||bi==0){
                    ToastUtils.showStatic(mAct, "参数不能为零");
                    return;
                }
                Blurry.with(mAct)
                        .radius(ai)
                        .sampling(bi)
                        .async()
                        .capture(imageView)
                        .into(imageView);
                break;
        }
    }
}
