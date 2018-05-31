package com.android.ct7liang.zxing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.android.ct7liang.utils.BitmapFileUtils;
import com.ct7liang.tangyuan.AppFolder;
import com.ct7liang.tangyuan.utils.LogUtils;
import com.ct7liang.tangyuan.utils.ToastUtils;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.io.File;

/**
 * ZXing二维码扫描
 * (注意:需要增加相关权限)
 * <uses-permission android:name="android.permission.CAMERA"/>
 * <uses-permission android:name="android.permission.FLASHLIGHT" />
 * <uses-feature android:name="android.hardware.camera" />
 * <uses-feature android:name="android.hardware.camera.autofocus" />
 * <uses-permission android:name="android.permission.VIBRATE" />
 * <uses-permission android:name="android.permission.WAKE_LOCK" />
 * <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
 * <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
 * <uses-permission android:name="android.permission.INTERNET" />
 */
public class ZXingActivity extends BaseActivity {

    private TextView text;
    private ImageView image;
    private int REQUEST_CODE = 123;
    private int REQUEST_IMAGE = 234;
    private EditText editText;
    private Bitmap mBitmap;
    private Bitmap logo;

    @Override
    public int setLayout() {
        return R.layout.activity_zxing;
    }

    @Override
    public void findView() {
        text = (TextView) findViewById(R.id.text);
        image = (ImageView) findViewById(R.id.image);
        editText = (EditText) findViewById(R.id.edit_text);
        findViewById(R.id.scan).setOnClickListener(this);
        findViewById(R.id.scan_local).setOnClickListener(this);
        findViewById(R.id.create).setOnClickListener(this);
        findViewById(R.id.create_with_logo).setOnClickListener(this);
        findViewById(R.id.my_style_scan).setOnClickListener(this);
        findViewById(R.id.save).setOnClickListener(this);
        initStatusBar();
    }

    @Override
    protected void setStatusBar() {
        TitleBarView titleBarView = findViewById(R.id.title_bar_view);
        titleBarView.setStatusBar(this);
    }

    @Override
    public void initData() {
        logo = BitmapFactory.decodeResource(getResources(), R.mipmap.huaji);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initFinish() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scan:
                /**直接扫描*/
                Intent intent1 = new Intent(mAct, CaptureActivity.class);
                startActivityForResult(intent1, REQUEST_CODE);
                break;
            case R.id.scan_local:
                /**扫描本地图片*/
                Intent intent2 = new Intent(Intent.ACTION_GET_CONTENT);
                intent2.addCategory(Intent.CATEGORY_OPENABLE);
                intent2.setType("image/*");
                startActivityForResult(intent2, REQUEST_IMAGE);
                break;
            case R.id.my_style_scan:
                /**自定义扫码界面*/
                Intent intent3 = new Intent(mAct, MyStyleScanActivity.class);
                startActivityForResult(intent3, REQUEST_CODE);
                break;
            case R.id.create:
                /**生成二维码*/
                String content = editText.getText().toString().trim();
                if (TextUtils.isEmpty(content)) {
                    ToastUtils.showStatic(mAct, "您的输入为空!");
                    return;
                }
                mBitmap = CodeUtils.createImage(content, 400, 400, null);
                if (mBitmap==null){
                    ToastUtils.showStatic(mAct, "生成二维码失败!");
                }
                image.setImageBitmap(mBitmap);
                break;
            case R.id.create_with_logo:
                /**生成二维码(带logo)*/
                String content2 = editText.getText().toString().trim();
                if (TextUtils.isEmpty(content2)) {
                    ToastUtils.showStatic(mAct, "您的输入为空!");
                    return;
                }
                mBitmap = CodeUtils.createImage(content2, 400, 400, logo);
                if (mBitmap ==null){
                    ToastUtils.showStatic(mAct, "生成二维码失败!");
                }
                image.setImageBitmap(mBitmap);
                break;
            case R.id.save:
                if (mBitmap==null){
                    ToastUtils.showStatic(mAct, "你还没有生成二维码!");
                    return;
                }
                File dir = new File(AppFolder.get().getPath(), "QRCodeImage");
                if (!dir.exists()){
                    dir.mkdirs();
                }
                File imageFile = new File(dir, System.currentTimeMillis()+".jpg");
                BitmapFileUtils.Bitmap2File(mBitmap, imageFile);
                ToastUtils.showStatic(mAct, "保存成功!  " + imageFile.getAbsolutePath());
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**处理二维码扫描结果*/
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    text.setText("二维码内容:  " + result);
                    LogUtils.write(result);
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    text.setText("解析二维码失败");
                }
            }
        }
        /**处理对二维码图片扫描结果*/
        if (requestCode == REQUEST_IMAGE) {
            if (data != null) {
                Uri uri = data.getData();
                CodeUtils.analyzeBitmap(ImageUtil.getImageAbsolutePath(this, uri), new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        text.setText("二维码内容:  " + result);
                        LogUtils.write(result);
                    }
                    @Override
                    public void onAnalyzeFailed() {
                        text.setText("解析二维码失败");
                    }
                });
            }
        }
    }
}
