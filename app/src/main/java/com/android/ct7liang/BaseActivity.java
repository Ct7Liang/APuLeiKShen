package com.android.ct7liang;

import com.ct7liang.tangyuan.BasisActivity;
import com.jaeger.library.StatusBarUtil;

/**
 * Created by Administrator on 2018-02-08.
 *
 */
public abstract class BaseActivity extends BasisActivity {

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.AppThemeColor), 0);
    }

}
