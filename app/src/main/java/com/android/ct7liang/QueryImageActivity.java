package com.android.ct7liang;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.android.ct7liang.utils.ViewPagerFixed;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class QueryImageActivity extends BaseActivity implements PhotoViewAttacher.OnPhotoTapListener {

    private ViewPagerFixed viewPager;
    private ArrayList<String> urls;
    private int position;

    public static void start(Context context, ArrayList<String> list, int position){
        Intent i = new Intent(context, QueryImageActivity.class);
        i.putStringArrayListExtra("list", list);
        i.putExtra("position", position);
        context.startActivity(i);
    }


    @Override
    public int setLayout() {
        return R.layout.activity_query_image;
    }

    @Override
    protected void setStatusBar() {
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        getWindow().setFlags(flag, flag);
    }

    @Override
    public void initSurface() {
        viewPager = (ViewPagerFixed) findViewById(R.id.view_pager);

        urls = getIntent().getStringArrayListExtra("list");
        position = getIntent().getIntExtra("position", 0);

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return urls.size();
            }
            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                PhotoView photoView = new PhotoView(mAct);
                photoView.setOnPhotoTapListener(QueryImageActivity.this);
                Glide.with(mAct).load(urls.get(position)).diskCacheStrategy(DiskCacheStrategy.NONE).into(photoView);
                container.addView(photoView);
                return photoView;
            }
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });
        viewPager.setCurrentItem(position);
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onPhotoTap(View view, float v, float v1) {
        finish();
    }

    @Override
    public void onOutsidePhotoTap() {

    }
}
