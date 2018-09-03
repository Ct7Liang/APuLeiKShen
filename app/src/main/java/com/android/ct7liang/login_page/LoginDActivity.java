package com.android.ct7liang.login_page;

import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.AppFolder;
import com.ct7liang.tangyuan.utils.loading.LoadingDialog;

import java.io.File;

public class LoginDActivity extends BaseActivity {

    private CommonVideoView mVideoView;
    private View top;
    private File file;

    @Override
    public int setLayout() {
        return R.layout.activity_login_d;
    }

    @Override
    public void findView() {
        initStatusBar();
        mVideoView = (CommonVideoView)findViewById(R.id.commonVideoView);
        top = findViewById(R.id.top);
        findViewById(R.id.login).setOnClickListener(this);
    }

    @Override
    public void initData() {
        file = new File(AppFolder.get(), "login_video");
        if (!file.exists()){
            file.mkdirs();
        }
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
            case R.id.login:
                LoadingDialog.show(this, false, "请稍后...", null, null);
//                showProgressDialog();
                playVideoView();
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (top.getVisibility()==View.GONE){
            playVideoView();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mVideoView.stopPlayback();
    }

    private void playVideoView() {
        File[] files = file.listFiles();
        if (files.length==0){
            mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_01));
        }else{
            mVideoView.setVideoURI(Uri.parse(files[0].getAbsolutePath()));
        }
        //播放
        mVideoView.start();
        //循环播放
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
//                cancelProgress();
                LoadingDialog.dismiss();
                top.setVisibility(View.GONE);
            }
        });
        mVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_01));
                mVideoView.start();
                return true;
            }
        });
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mVideoView.start();
            }
        });
    }
}