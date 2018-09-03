package com.android.ct7liang.menu.boomMenu;

import android.view.View;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.ToastUtils;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;
import com.nightonke.boommenu.Animation.BoomEnum;
import com.nightonke.boommenu.Animation.EaseEnum;
import com.nightonke.boommenu.Animation.OrderEnum;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceAlignmentEnum;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import static com.android.ct7liang.R.id.boom;

public class SimpleCircleButtonActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_simple_circle_button;
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
        BoomMenuButton boomMenuButton = (BoomMenuButton) findViewById(boom);

        //设置点击菜单条目样式(简单的圆形)
        boomMenuButton.setButtonEnum(ButtonEnum.SimpleCircle);

        //设置点击按钮上面的小点的排列样式 第一个数字表示小点的个数 第二个数字表示排列的样式种类
        boomMenuButton.setPiecePlaceEnum(PiecePlaceEnum.DOT_5_4);
//        boomMenuButton.setPiecePlaceEnum(PiecePlaceEnum.Share);  不以小点儿的形式显示 而是以分享的样式显示

        //设置点击后菜单选项的排列样式 第一个数字表示小点的个数 第二个数字表示排列的样式种类
        // ButtonPlaceEnum.Horizontal
        // ButtonPlaceEnum.Vertical  通用样式 横向排列 纵向排列
        boomMenuButton.setButtonPlaceEnum(ButtonPlaceEnum.SC_5_4);

        //注: 按钮上面小点的排列样式和菜单选项的排列样式 里面第一个数字必须相同 即列表条目和按钮上小点的个数必须相同

        for (int i = 0; i < boomMenuButton.getPiecePlaceEnum().pieceNumber(); i++) {
            //根据菜单选项的数目 添加相同数量的builder 设置图标 设置条目监听
            boomMenuButton.addBuilder(
                    new SimpleCircleButton.Builder()
                            .normalImageRes(R.mipmap.huaji)
                            .listener(new OnBMClickListener() {
                                @Override
                                public void onBoomButtonClick(int index) {
                                    ToastUtils.showStatic(mAct, "这是第个"+ index +"选项");
                                }
                            })
            );
        }

        //删除boomMenuButton上面已经添加的菜单按钮
//        boomMenuButton.clearBuilders();

        //设置boomMenuButton是否可以拖动
        boomMenuButton.setDraggable(true);

        //设置菜单选项移动轨迹动画样式
        boomMenuButton.setBoomEnum(BoomEnum.RANDOM);

        //设置菜单选项显示的位置 上 下 左 右 左上 右上 左下 右下
        boomMenuButton.setButtonPlaceAlignmentEnum(ButtonPlaceAlignmentEnum.Top);
        //设置菜单选项 距上边距距离  位置为上时适用
        boomMenuButton.setButtonTopMargin(50);
        //设置菜单选项 距下边距距离  位置为下时适用
        boomMenuButton.setButtonBottomMargin(50);
        //设置菜单选项 距左边距距离  位置为左时适用
        boomMenuButton.setButtonLeftMargin(50);
        //设置菜单选项 距右边距距离  位置为右时适用
        boomMenuButton.setButtonRightMargin(50);

        //设置菜单选项出入顺序
        boomMenuButton.setOrderEnum(OrderEnum.DEFAULT); //默认顺序 先进先出
        boomMenuButton.setOrderEnum(OrderEnum.REVERSE); //先进后出
        boomMenuButton.setOrderEnum(OrderEnum.RANDOM); //随机顺序

        boomMenuButton.setShowMoveEaseEnum(EaseEnum.EaseOutSine);
        boomMenuButton.setHideMoveEaseEnum(EaseEnum.EaseOutSine);
        boomMenuButton.setShowRotateEaseEnum(EaseEnum.EaseInBounce);
        boomMenuButton.setHideRotateEaseEnum(EaseEnum.EaseInBounce);
        boomMenuButton.setShowScaleEaseEnum(EaseEnum.EaseInCubic);
        boomMenuButton.setHideScaleEaseEnum(EaseEnum.EaseInCubic);

//        boomMenuButton.setShowDuration(500);  //单个菜单选项从弹出到固定的动画时间
//        boomMenuButton.setHideDuration(500);  //单个菜单选项从收起到消失的动画时间

//        boomMenuButton.setShowDelay(500); //连续的菜单选项之间显示时触发的间隔
//        boomMenuButton.setHideDelay(500); //连续的菜单选项之间消失时触发的间隔

//        boomMenuButton.boom(); 代码控制菜单选项显示
//        boomMenuButton.reboom(); 代码控制菜单选项消失
//        boomMenuButton.boomImmediately(); 代码控制菜单选项立即显示
//        boomMenuButton.reboomImmediately(); 代码控制菜单选项立即消失

//        boomMenuButton.setAutoHide(false);  是否在点击菜单选项后自动隐藏菜单选项列表

//        boomMenuButton.setUse3DTransformAnimation(true);  是否使用3D动画
    }

    @Override
    public void initData() {}

    @Override
    public void initView() {}

    @Override
    public void initFinish() {}

    @Override
    public void onClick(View view) {}
}
