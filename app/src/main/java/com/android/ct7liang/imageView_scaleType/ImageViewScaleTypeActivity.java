package com.android.ct7liang.imageView_scaleType;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.ScreenInfoUtil;
import com.zaaach.toprightmenu.MenuItem;
import com.zaaach.toprightmenu.TopRightMenu;
import java.util.ArrayList;
import java.util.List;

public class ImageViewScaleTypeActivity extends BaseActivity {

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

    @Override
    public int setLayout() {
        return R.layout.activity_image_view_scale_type;
    }

    @Override
    public void findView() {
        findViewById(R.id.back).setOnClickListener(this);
        ((TextView)findViewById(R.id.title)).setText(types[0]);
        test = findViewById(R.id.test);
        test.setOnClickListener(this);
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
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.imageView:
                imgIndex++;
                if (imgIndex==imgResource.length){
                    imgIndex = 0;
                }
                image.setImageResource(imgResource[imgIndex]);
                break;
            case R.id.test:
                new TopRightMenu(this)
                    .setHeight(RecyclerView.LayoutParams.WRAP_CONTENT)     //默认高度480
                    .setWidth(ScreenInfoUtil.getScreenWH(mAct)[0]/3)      //默认宽度wrap_content
                    .showIcon(false)     //显示菜单图标，默认为true
                            .setAnimationStyle(R.style.TRM_ANIM_STYLE)
                            .addMenuList(menuItems)
                            .setOnMenuItemClickListener(new TopRightMenu.OnMenuItemClickListener() {
                                @Override
                                public void onMenuItemClick(int position) {
                                    ((TextView)findViewById(R.id.title)).setText(types[position]);
                                    image.setScaleType(scaleTypes[position]);
                                }
                            })
                            .showAsDropDown(test, -225, 0);	//带偏移量
                break;
        }
    }
}
