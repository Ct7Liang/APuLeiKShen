package com.android.ct7liang.menu.boomMenu;

import android.graphics.Color;
import android.view.View;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

public class HamButtonActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_ham_button;
    }

    @Override
    public void findView() {
        initStatusBar();

        //查找控件
        BoomMenuButton boomMenuButton = (BoomMenuButton) findViewById(R.id.boom);

        //设置点击菜单条目样式(简单的圆形)
        boomMenuButton.setButtonEnum(ButtonEnum.Ham);

        //设置点击按钮上面的小点的排列样式 第一个数字表示小点的个数 第二个数字表示排列的样式种类
        boomMenuButton.setPiecePlaceEnum(PiecePlaceEnum.HAM_5);

        //设置点击后菜单选项的排列样式 第一个数字表示小点的个数 第二个数字表示排列的样式种类
        // ButtonPlaceEnum.Horizontal
        // ButtonPlaceEnum.Vertical  通用样式 横向排列 纵向排列
        boomMenuButton.setButtonPlaceEnum(ButtonPlaceEnum.HAM_5);

        //注: 按钮上面小点的排列样式和菜单选项的排列样式 里面第一个数字必须相同 即列表条目和按钮上小点的个数必须相同

        for (int i = 0; i < boomMenuButton.getPiecePlaceEnum().pieceNumber(); i++) {
            //根据菜单选项的数目 添加相同数量的builder 设置图标 主标题 副标题 文字颜色
            boomMenuButton.addBuilder(
                    new HamButton.Builder()
                            .normalImageRes(R.mipmap.huaji)
                            .normalText("这是第" + i + "个选项")
                            .normalTextColor(Color.parseColor("#00FF00"))
                            .subNormalText("这是第" + i + "个选项副标题")
                            .subNormalTextColor(Color.parseColor("#FF0000"))
                            .buttonCornerRadius(50)
                            .shadowCornerRadius(50)
            );
        }

        //设置boomMenuButton是否可以拖动
        boomMenuButton.setDraggable(true);
    }


    @Override
    protected void setStatusBar() {
        TitleBarView titleBarView = findViewById(R.id.title_bar_view);
        titleBarView.setStatusBar(this);
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
