package com.android.ct7liang.menu.boomMenu;

import android.view.View;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;

public class SquarePieceCornerRadiusActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_square_piece_corner_radius;
    }

    @Override
    protected void setStatusBar() {
        TitleBarView titleBarView = findViewById(R.id.title_bar_view);
        titleBarView.setStatusBar(this);
    }

    @Override
    public void findView() {
        initStatusBar();
        //查找控件
        BoomMenuButton boomMenuButton = (BoomMenuButton) findViewById(R.id.boom);

        for (int i = 0; i < boomMenuButton.getPiecePlaceEnum().pieceNumber(); i++) {
            //根据菜单选项的数目 添加相同数量的builder 设置图标
            boomMenuButton.addBuilder(
                    new SimpleCircleButton.Builder()
                    .isRound(false)
                    .buttonCornerRadius(20)
                    .shadowCornerRadius(20)
            );
        }

        //查找控件
        BoomMenuButton boomMenuButton1 = (BoomMenuButton) findViewById(R.id.boom1);

        for (int i = 0; i < boomMenuButton1.getPiecePlaceEnum().pieceNumber(); i++) {
            //根据菜单选项的数目 添加相同数量的builder 设置图标
            boomMenuButton1.addBuilder(
                    new TextInsideCircleButton.Builder()
                            .isRound(false)
                            .buttonCornerRadius(20)
                            .shadowCornerRadius(20)
                            .normalText("这是第"+i+"个")
            );
        }

        //查找控件
        BoomMenuButton boomMenuButton2 = (BoomMenuButton) findViewById(R.id.boom2);

        for (int i = 0; i < boomMenuButton2.getPiecePlaceEnum().pieceNumber(); i++) {
            //根据菜单选项的数目 添加相同数量的builder 设置图标
            boomMenuButton2.addBuilder(
                    new TextOutsideCircleButton.Builder()
                            .isRound(false)
                            .buttonCornerRadius(20)
                            .shadowCornerRadius(20)
                            .normalText("这是第"+i+"个")
            );
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
