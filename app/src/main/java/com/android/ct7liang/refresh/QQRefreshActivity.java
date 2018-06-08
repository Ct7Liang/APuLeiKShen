package com.android.ct7liang.refresh;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.DPSTransform;
import com.ct7liang.tangyuan.utils.LogUtils;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;

public class QQRefreshActivity extends BaseActivity implements View.OnTouchListener{

    private RecyclerView recyclerView;
    private int i;
    private TextView test;

    @Override
    public int setLayout() {
        return R.layout.activity_qqrefresh;
    }

    @Override
    public void findView() {
        TitleBarView titleBarView = findViewById(R.id.title_bar_view);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        test = findViewById(R.id.test);
        titleBarView.setStatusBar(this);
        initStatusBar();
    }

    @Override
    public void initData() {
        QQRefreshAdapter adapter = new QQRefreshAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setOnTouchListener(this);
        i = DPSTransform.dp2Px(this, 80f);
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

    private float fy;
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                fy = motionEvent.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float v = motionEvent.getY() - fy;
                if (v<=i && v>=-i){
                    LogUtils.write(v + "");
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(test.getLayoutParams());
                    lp.setMargins(0, (int) v, 0, 0);
                    test.setLayoutParams(lp);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return false;
    }
}
