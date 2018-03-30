package com.android.ct7liang.collapsing;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.ct7liang.R;
import com.jaeger.library.StatusBarUtil;

public class CustomScrollingActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_scrolling);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        StatusBarUtil.setColor(this, getResources().getColor(R.color.AppThemeColor), 0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("再见");
        setSupportActionBar(toolbar);

        ((TextView)findViewById(R.id.title)).setText("一千个伤心的理由");
        findViewById(R.id.back).setOnClickListener(this);
        final View view = findViewById(R.id.title_bar);

        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.toolbar_layout);


        AppBarLayout app_bar=(AppBarLayout)findViewById(R.id.app_bar);
        app_bar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    view.setVisibility(View.GONE);
                    collapsingToolbarLayout.setTitle("再见");//设置title为EXPANDED
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    collapsingToolbarLayout.setTitle("");//设置title不显示
                    view.setVisibility(View.VISIBLE);
                } else {
                    collapsingToolbarLayout.setTitle("再见");//设置title为INTERNEDIATE
                    view.setVisibility(View.GONE);
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
        }
    }
}
