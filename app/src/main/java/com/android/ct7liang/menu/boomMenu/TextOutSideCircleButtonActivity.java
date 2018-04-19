package com.android.ct7liang.menu.boomMenu;

import android.graphics.Color;
import android.view.View;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

public class TextOutSideCircleButtonActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_text_out_side_circle_button;
    }

    @Override
    public void findView() {
        //查找控件
        BoomMenuButton boomMenuButton = (BoomMenuButton) findViewById(R.id.boom);

        //设置菜单条目样式(内部文字标题的圆形)
        boomMenuButton.setButtonEnum(ButtonEnum.TextOutsideCircle);

        //设置点击按钮上面的小点的排列样式 第一个数字表示小点的个数 第二个数字表示排列的样式种类
        boomMenuButton.setPiecePlaceEnum(PiecePlaceEnum.DOT_5_4);

        //设置点击后菜单选项的排列样式 第一个数字表示小点的个数 第二个数字表示排列的样式种类
        // ButtonPlaceEnum.Horizontal
        // ButtonPlaceEnum.Vertical  通用样式 横向排列 纵向排列
        boomMenuButton.setButtonPlaceEnum(ButtonPlaceEnum.SC_5_4);

        //注: 按钮上面小点的排列样式和菜单选项的排列样式 里面第一个数字必须相同 即菜单选项和按钮上小点的个数必须相同

        for (int i = 0; i < boomMenuButton.getPiecePlaceEnum().pieceNumber(); i++) {
            //根据菜单选项的数目 添加相同数量的builder 设置图标 设置文字
            if (i==0){
                boomMenuButton.addBuilder(new TextOutsideCircleButton.Builder().normalImageRes(R.mipmap.huaji).normalText("这是第"+i+"个").normalTextColor(Color.parseColor("#000000")));
            }else if (i==1){
                boomMenuButton.addBuilder(new TextOutsideCircleButton.Builder().normalImageRes(R.mipmap.huaji).normalText("这是第"+i+"个"));
            }else{
                boomMenuButton.addBuilder(new TextOutsideCircleButton.Builder().normalText("这是第"+i+"个"));
            }
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
