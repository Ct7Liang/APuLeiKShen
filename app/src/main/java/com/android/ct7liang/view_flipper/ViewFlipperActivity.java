package com.android.ct7liang.view_flipper;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.ToastUtils;

public class ViewFlipperActivity extends BaseActivity {

    private int[] resource = {
            R.mipmap.icon01,
            R.mipmap.icon02,
            R.mipmap.icon03,
            R.mipmap.icon04,
            R.mipmap.icon05,
            R.mipmap.icon06
    };

    private String[] title = {
            "富强民主",
            "文明和谐",
            "自由平等",
            "公正法治",
            "爱国敬业",
            "诚信友善",
    };

    @Override
    public int setLayout() {
        return R.layout.activity_view_flipper;
    }

    @Override
    public void findView() {
        ViewFlipper viewFlipper = findViewById(R.id.filpper);
        for (int i = 0; i < resource.length; i++) {
            View view = View.inflate(this, R.layout.item_flipper_view, null);
            ((ImageView)view.findViewById(R.id.image)).setImageResource(resource[i]);
            ((TextView)view.findViewById(R.id.title)).setText(title[i]);
            final int finalI = i;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUtils.showStatic(mAct, title[finalI]);
                }
            });
            viewFlipper.addView(view);
        }
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

    }
}