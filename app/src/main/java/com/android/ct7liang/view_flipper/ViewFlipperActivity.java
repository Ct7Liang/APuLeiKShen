package com.android.ct7liang.view_flipper;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.ToastUtils;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;

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

    private ViewFlipper flipperView;

    @Override
    public int setLayout() {
        return R.layout.activity_view_flipper;
    }

    @Override
    protected void setStatusBar() {
        TitleBarView titleBarView = findViewById(R.id.title_bar_view);
        titleBarView.setStatusBar(this);

        //设置FlipperView
        flipperView = findViewById(R.id.filpper);
        flipperView.setFlipInterval(2000);
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
            flipperView.addView(view);
        }
    }

    @Override
    public void initSurface() {
        initStatusBar();
        findViewById(R.id.title_back_ground).setBackgroundResource(R.color.AppThemeColor);
        findViewById(R.id.left_image).setOnClickListener(this);
        ((TextView)findViewById(R.id.center_text)).setText("FlipperView");
        findViewById(R.id.btn_oc).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.left_image:
                finish();
                break;
            case R.id.btn_oc:
                if (flipperView.isFlipping()){
                    flipperView.stopFlipping();
                }else{
                    flipperView.startFlipping();
                }
                break;
        }
    }
}