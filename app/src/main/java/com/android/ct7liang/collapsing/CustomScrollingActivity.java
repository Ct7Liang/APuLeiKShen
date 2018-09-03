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
import com.android.ct7liang.R;

public class CustomScrollingActivity extends AppCompatActivity implements View.OnClickListener, AppBarLayout.OnOffsetChangedListener {

    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_scrolling);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.AppThemeColor), 0);
//        StatusBarUtil.setTranslucent(this, 0);
//        StatusBarUtil.setTransparent(this);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("蒹葭");

        collapsingToolbarLayout = findViewById(R.id.toolbar_layout);

        appBarLayout = (AppBarLayout)findViewById(R.id.app_bar);
        appBarLayout.addOnOffsetChangedListener(this);

//        ((TextView)findViewById(R.id.title)).setText("一千个伤心的理由");
//        findViewById(R.id.back).setOnClickListener(this);
//        final View view = findViewById(R.id.title_bar);

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

    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (verticalOffset == 0) {  //展开
            collapsingToolbarLayout.setTitle("蒹葭");
        } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {  //闭合
            collapsingToolbarLayout.setTitle("");
        } else { //中间态
            collapsingToolbarLayout.setTitle("蒹葭");
        }
    }
}