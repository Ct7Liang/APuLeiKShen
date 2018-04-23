package com.android.ct7liang.menu.boomMenu;

import android.content.Intent;
import android.view.View;
import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;


public class BoomMenuActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_boom_menu;
    }

    @Override
    public void findView() {
        findViewById(R.id.simple_circle_button).setOnClickListener(this);
        findViewById(R.id.inside_circle_button).setOnClickListener(this);
        findViewById(R.id.outside_circle_button).setOnClickListener(this);
        findViewById(R.id.ham_button).setOnClickListener(this);
        findViewById(R.id.square_and_piece_corner_radius).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.simple_circle_button:
                startActivity(new Intent(this, SimpleCircleButtonActivity.class));
                break;
            case R.id.inside_circle_button:
                startActivity(new Intent(this, TextInsideCircleButtonActivity.class));
                break;
            case R.id.outside_circle_button:
                startActivity(new Intent(this, TextOutSideCircleButtonActivity.class));
                break;
            case R.id.ham_button:
                startActivity(new Intent(this, HamButtonActivity.class));
                break;
            case R.id.square_and_piece_corner_radius:
                startActivity(new Intent(this, SquarePieceCornerRadiusActivity.class));
                break;
        }
    }

    @Override
    public void initData() {}

    @Override
    public void initView() {}

    @Override
    public void initFinish() {}

}
