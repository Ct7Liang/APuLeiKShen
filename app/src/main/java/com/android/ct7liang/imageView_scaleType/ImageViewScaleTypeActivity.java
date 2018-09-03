package com.android.ct7liang.imageView_scaleType;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.ScreenUtil;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;
import com.zaaach.toprightmenu.MenuItem;
import com.zaaach.toprightmenu.TopRightMenu;
import java.util.ArrayList;
import java.util.List;


public class ImageViewScaleTypeActivity extends BaseActivity implements TitleBarView.OnRightImgClick {

    private String[] types = {"CENTER", "CENTER_CROP", "CENTER_INSIDE", "FIT_CENTER", "FIT_XY", "FIT_START", "FIT_END"};
    private ImageView.ScaleType[] scaleTypes = {
            ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP,
            ImageView.ScaleType.CENTER_INSIDE, ImageView.ScaleType.FIT_CENTER,
            ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_END};
    private int[] imgResource = {R.mipmap.img_scale_type_a, R.mipmap.img_scale_type_b, R.mipmap.img_scale_type_c, R.mipmap.img_scale_type_d};
    private View test;
    private List<MenuItem> menuItems;
    private ImageView image;
    private int imgIndex;
    private TitleBarView titleBarView;

    @Override
    public int setLayout() {
        return R.layout.activity_image_view_scale_type;
    }

    @Override
    public void findView() {
        initStatusBar();

        test = findViewById(R.id.right_image);

        image = findViewById(R.id.imageView);
        image.setImageResource(imgResource[imgIndex]);
        image.setOnClickListener(this);
        //添加菜单项
        menuItems = new ArrayList<>();
        for (int i = 0; i < types.length; i++) {
            menuItems.add(new MenuItem(types[i]));
        }
    }

    @Override
    protected void setStatusBar() {
        titleBarView = findViewById(R.id.title_bar_view);
        titleBarView.setStatusBar(this);
        titleBarView.setTitleText(types[0], "#FFFFFF", 16, true);
        titleBarView.setOnRightImgClick(new TitleBarView.OnRightImgClick() {
            @Override
            public void onClick(View view) {
                new TopRightMenu(mAct)
                        .setHeight(RecyclerView.LayoutParams.WRAP_CONTENT)     //默认高度480
                        .setWidth(ScreenUtil.getUtils().getScreenWidth(mAct)/3)      //默认宽度wrap_content
                        .showIcon(false)     //显示菜单图标，默认为true
                        .setAnimationStyle(R.style.TRM_ANIM_STYLE)
                        .addMenuList(menuItems)
                        .setOnMenuItemClickListener(new TopRightMenu.OnMenuItemClickListener() {
                            @Override
                            public void onMenuItemClick(int position) {
                                titleBarView.setTitleText(types[position], "#FFFFFF", 16, true);
                                image.setScaleType(scaleTypes[position]);
                            }
                        })
                        .showAsDropDown(test, -225, 0);	//带偏移量
            }
        });
    }

    @Override
    public void initData() {}

    @Override
    public void initView() {}

    @Override
    public void initFinish() {}

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageView:
                imgIndex++;
                if (imgIndex==imgResource.length){
                    imgIndex = 0;
                }
                image.setImageResource(imgResource[imgIndex]);
                break;
        }
    }
}
