package com.android.ct7liang.fucking_slide;

import android.content.Context;
import android.media.AudioManager;
import android.view.View;
import android.widget.TextView;

import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.licrafter.library.VolumeSliderView;

public class FuckingVolumeActivity extends BaseActivity {

    private VolumeSliderView mVolumeSliderView;
    private AudioManager mAm;
    private TextView tv;

    @Override
    public int setLayout() {
        return R.layout.activity_fucking_volume;
    }

    @Override
    public void findView() {
        findViewById(R.id.back).setOnClickListener(this);
        ((TextView)findViewById(R.id.title)).setText("反人类手机音量控制器");
        mVolumeSliderView = (VolumeSliderView) findViewById(R.id.fucking);
        tv = (TextView) findViewById(R.id.tv);
    }

    @Override
    public void initData() {}

    @Override
    public void initView() {}

    @Override
    public void initFinish() {
        mAm = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int streamVolume = mAm.getStreamVolume(AudioManager.STREAM_MUSIC);
        final int maxVolume = mAm.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        tv.setText("当前音量值: " + streamVolume + "  最大音量值: " + maxVolume);
        mVolumeSliderView.setOnVolumeSlideListener(new VolumeSliderView.OnVolumeSlideListener() {
            @Override
            public void result(int volume) {
                int i = volume*maxVolume;
                int j = i/100;
                tv.setText("当前音量值: " + j + "  最大音量值: " + maxVolume);
                mAm.setStreamVolume(AudioManager.STREAM_MUSIC, j, AudioManager.FLAG_PLAY_SOUND);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
        }
    }
}
