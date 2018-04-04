package com.android.ct7liang.blur;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.ScreenInfoUtil;
import com.ct7liang.tangyuan.utils.ToastUtils;

import jp.wasabeef.blurry.Blurry;

public class BlurAActivity extends BaseActivity {

    private ImageView imageView;
    private EditText edit_a;
    private EditText edit_b;

    @Override
    public int setLayout() {
        return R.layout.activity_blur_a;
    }

    @Override
    protected void setStatusBar() {
        findViewById(R.id.title_back_ground).setPadding(0, ScreenInfoUtil.getStatusHeight(this), 0 ,0);
    }

    @Override
    public void findView() {
        findViewById(R.id.title_back_ground).setBackgroundColor(Color.parseColor("#00000000"));
        ((TextView)findViewById(R.id.left_text)).setText("图片模糊");
        findViewById(R.id.left_image).setOnClickListener(this);
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
            case R.id.left_image:
                finish();
                break;
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
