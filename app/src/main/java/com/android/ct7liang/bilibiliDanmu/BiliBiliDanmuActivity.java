package com.android.ct7liang.bilibiliDanmu;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;

import java.io.InputStream;
import java.util.HashMap;
import master.flame.danmaku.controller.IDanmakuView;
import master.flame.danmaku.danmaku.loader.ILoader;
import master.flame.danmaku.danmaku.loader.IllegalDataException;
import master.flame.danmaku.danmaku.loader.android.DanmakuLoaderFactory;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.IDisplayer;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.danmaku.parser.IDataSource;
import master.flame.danmaku.ui.widget.DanmakuView;


public class BiliBiliDanmuActivity extends BaseActivity {

    private DanmakuView danmakuView;
    private DanmakuContext danmakuContext;
    private BaseDanmakuParser mParser;
    private EditText comment;

    @Override
    public int setLayout() {
        return R.layout.activity_bili_bili_danmu;
    }

    @Override
    protected void setStatusBar() {
        TitleBarView titleBarView = findViewById(R.id.title_bar_view);
        titleBarView.setStatusBar(this);
    }

    @Override
    public void initSurface() {
        initStatusBar();
        danmakuView = findViewById(R.id.DanMuKuView);
        comment = findViewById(R.id.comment);
        findViewById(R.id.rtl).setOnClickListener(this);
        findViewById(R.id.ltr).setOnClickListener(this);
        findViewById(R.id.top).setOnClickListener(this);
        findViewById(R.id.bottom).setOnClickListener(this);
        findViewById(R.id.jiao).setOnClickListener(this);
        findViewById(R.id.high).setOnClickListener(this);
        findViewById(R.id.enter).setOnClickListener(this);
        initDanmaKuView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.enter:
                startActivity(new Intent(mAct, MyDanmuActivity.class));
                break;
            case R.id.rtl:
                isEmpty();
                addDanmu(BaseDanmaku.TYPE_SCROLL_RL, comment.getText().toString());
                break;
            case R.id.ltr:
                isEmpty();
                addDanmu(BaseDanmaku.TYPE_SCROLL_LR, comment.getText().toString());
                break;
            case R.id.top:
                isEmpty();
                addDanmu(BaseDanmaku.TYPE_FIX_TOP, comment.getText().toString());
                break;
            case R.id.bottom:
                isEmpty();
                addDanmu(BaseDanmaku.TYPE_FIX_BOTTOM, comment.getText().toString());
                break;
            case R.id.jiao:
                isEmpty();
                addDanmu(BaseDanmaku.TYPE_MOVEABLE_XXX, comment.getText().toString());
                break;
            case R.id.high:
                isEmpty();
                addDanmu(BaseDanmaku.TYPE_SPECIAL, comment.getText().toString());
                break;
        }
    }

    private void isEmpty(){
        if (TextUtils.isEmpty(comment.getText().toString())){
            return;
        }
    }
    private void initDanmaKuView() {
        // 设置最大显示行数
        HashMap<Integer, Integer> maxLinesPair = new HashMap<Integer, Integer>();
        maxLinesPair.put(BaseDanmaku.TYPE_SCROLL_RL, 6); // 滚动弹幕最大显示6行
        // 设置是否禁止重叠
        HashMap<Integer, Boolean> overlappingEnablePair = new HashMap<Integer, Boolean>();
        overlappingEnablePair.put(BaseDanmaku.TYPE_SCROLL_RL, true);
        overlappingEnablePair.put(BaseDanmaku.TYPE_FIX_TOP, true);
        danmakuContext = DanmakuContext.create();
        danmakuContext
                .setDanmakuStyle(IDisplayer.DANMAKU_STYLE_STROKEN, 3)
                .setDuplicateMergingEnabled(false)
                .setScrollSpeedFactor(1.2f)
                .setScaleTextSize(1.2f)
//                .setCacheStuffer(new SpannedCacheStuffer(), mCacheStufferAdapter) // 图文混排使用SpannedCacheStuffer
//                .setCacheStuffer(new BackgroundCacheStuffer())  // 绘制背景使用BackgroundCacheStuffer
                .setMaximumLines(maxLinesPair)
                .preventOverlapping(overlappingEnablePair)
                .setDanmakuMargin(5);
        if (danmakuView != null) {
            mParser = createParser(this.getResources().openRawResource(R.raw.comments));
            danmakuView.setCallback(new master.flame.danmaku.controller.DrawHandler.Callback() {
                @Override
                public void updateTimer(DanmakuTimer timer) {}
                @Override
                public void drawingFinished() {}
                @Override
                public void danmakuShown(BaseDanmaku danmaku) {}
                @Override
                public void prepared() {
                    danmakuView.start();
                }
            });
            danmakuView.setOnDanmakuClickListener(new IDanmakuView.OnDanmakuClickListener() {
                @Override
                public boolean onDanmakuClick(IDanmakus danmakus) {
                    return false;
                }
                @Override
                public boolean onDanmakuLongClick(IDanmakus danmakus) {
                    return false;
                }
                @Override
                public boolean onViewClick(IDanmakuView view) {
                    return false;
                }
            });
            danmakuView.prepare(mParser, danmakuContext);
            danmakuView.showFPS(false);  //是否显示帧数
            danmakuView.enableDanmakuDrawingCache(true);
        }
    }
    private BaseDanmakuParser createParser(InputStream stream) {
        if (stream == null) {
            return new BaseDanmakuParser() {
                @Override
                protected Danmakus parse() {
                    return new Danmakus();
                }
            };
        }
        ILoader loader = DanmakuLoaderFactory.create(DanmakuLoaderFactory.TAG_BILI);
        try {
            loader.load(stream);
        } catch (IllegalDataException e) {
            e.printStackTrace();
        }
        BaseDanmakuParser parser = new BiliDanmukuParser();
        IDataSource<?> dataSource = loader.getDataSource();
        parser.load(dataSource);
        return parser;
    }
    private void addDanmu(int type, String comment){
        BaseDanmaku danmaku = danmakuContext.mDanmakuFactory.createDanmaku(type);
        danmaku.text = comment;
        danmaku.padding = 5;
        danmaku.priority = 0;  // 可能会被各种过滤器过滤并隐藏显示
        danmaku.isLive = true;
        danmaku.setTime(danmakuView.getCurrentTime() + 800);
        danmaku.textSize = 17f * (mParser.getDisplayer().getDensity() - 0.6f); //文本弹幕字体大小
        danmaku.textColor = getRandomColor(); //文本的颜色
        danmakuView.addDanmaku(danmaku);
    }
    private int getRandomColor() {
        int[] colors = {Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN, Color.CYAN, Color.BLACK, Color.DKGRAY};
        int i = ((int) (Math.random() * 10)) % colors.length;
        return colors[i];
    }
}
