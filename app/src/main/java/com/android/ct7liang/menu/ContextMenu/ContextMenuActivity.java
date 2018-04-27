package com.android.ct7liang.menu.ContextMenu;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.ToastUtils;
import com.yalantis.contextmenu.lib.ContextMenuDialogFragment;
import com.yalantis.contextmenu.lib.MenuObject;
import com.yalantis.contextmenu.lib.interfaces.OnMenuItemClickListener;
import java.util.ArrayList;

public class ContextMenuActivity extends BaseActivity implements OnMenuItemClickListener {

    private EditText et_delay;
    private EditText et_duration;
    private CheckBox cb_fitSystemWindow;
    private CheckBox cb_clipToPadding;
    private ArrayList<MenuObject> menuObjects;
    private int actionBarHeight;

    @Override
    public int setLayout() {
        return R.layout.activity_context_menu;
    }

    @Override
    public void findView() {
        et_delay = findViewById(R.id.delay);
        et_duration = findViewById(R.id.duration);
        cb_fitSystemWindow = findViewById(R.id.fitSystemWindow);
        cb_clipToPadding = findViewById(R.id.clipToPadding);
        findViewById(R.id.title_back_ground).setBackgroundResource(R.color.AppThemeColor);
        findViewById(R.id.left_image).setOnClickListener(this);
        findViewById(R.id.right).setOnClickListener(this);
        ((TextView)findViewById(R.id.center_text)).setText("ContextMenu");
        ((ImageView)findViewById(R.id.right_image)).setImageResource(R.mipmap.top_title_more);
    }

    @Override
    public void initData() {
        actionBarHeight = 0;
        TypedValue tv = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
        }
    }

    @Override
    public void initView() {
        menuObjects = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            MenuObject menuObject = new MenuObject();
            menuObject.setBgColor(Color.parseColor("#FFFFFF"));
            menuObject.setDividerColor(R.color.white);
            switch (i){
                case 0:
                    menuObject.setTitle("收起");
                    menuObject.setResource(R.mipmap.a);
                    break;
                case 1:
                    menuObject.setTitle("菜单1");
                    menuObject.setResource(R.mipmap.b);
                    break;
                case 2:
                    menuObject.setTitle("菜单2");
                    menuObject.setResource(R.mipmap.c);
                    break;
                case 3:
                    menuObject.setTitle("菜单3");
                    menuObject.setResource(R.mipmap.d);
                    break;
                case 4:
                    menuObject.setTitle("菜单4");
                    menuObject.setResource(R.mipmap.e);
                    break;
                case 5:
                    menuObject.setTitle("菜单5");
                    menuObject.setResource(R.mipmap.f);
                    break;
            }
            menuObjects.add(menuObject);
        }
    }

    @Override
    public void initFinish() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.left_image:
                finish();
                break;
            case R.id.right:
                String delayStr = et_delay.getText().toString().trim();
                String durationStr = et_duration.getText().toString().trim();
                int delay = TextUtils.isEmpty(delayStr)?100:Integer.parseInt(delayStr);
                int duration = TextUtils.isEmpty(durationStr)?100:Integer.parseInt(durationStr);
                ContextMenuDialogFragment fragment = ContextMenuDialogFragment.newInstance(
                        actionBarHeight,
                        menuObjects,
                        delay,
                        duration,
                        cb_fitSystemWindow.isChecked(),
                        cb_clipToPadding.isChecked());
                fragment.setItemClickListener(this);
                fragment.show(getSupportFragmentManager(), "MenuContext");
                break;
        }
    }

    @Override
    public void onMenuItemClick(View clickedView, int position) {
        ToastUtils.showStatic(this, "点击了第"+position+"个菜单");
    }

}