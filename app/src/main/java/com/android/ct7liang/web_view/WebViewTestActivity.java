package com.android.ct7liang.web_view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import com.android.ct7liang.BaseActivity;
import com.android.ct7liang.R;
import com.ct7liang.tangyuan.utils.LogUtils;
import com.ct7liang.tangyuan.utils.ToastUtils;
import com.ct7liang.tangyuan.view_titlebar.TitleBarView;


@SuppressLint("SetJavaScriptEnabled")  //SuppressLint一定要加上去！！！低版本可能没问题，高版本JS铁定调不了Android里面的方法
public class WebViewTestActivity extends BaseActivity {

    private WebView webView;
    private String url = "http://m.kuaixiaoren.com/app/businessdetail/supplier_message_id/8066/user_id/884/user_type/1";
    private String url1 = "https://www.baidu.com/";
    private EditText editText;

    @Override
    public int setLayout() {
        return R.layout.activity_web_view_test;
    }

    @Override
    public void findView() {
        webView = findViewById(R.id.webView);
        editText = findViewById(R.id.edit);
        findViewById(R.id.btn).setOnClickListener(this);
    }

    @Override
    public void initData() {}

    @Override
    public void initView() {
        initStatusBar();
        initWebView();
    }

    @Override
    protected void setStatusBar() {
        TitleBarView titleBarView = findViewById(R.id.title_bar_view);
        titleBarView.setStatusBar(this);
        titleBarView.setOnLeftImgClick(new TitleBarView.OnLeftImgClick() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void initFinish() {}

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn:
                String trim = editText.getText().toString().trim();
                if (!trim.equals("")){
                    //此为Android调用Js里面的方法
                    //javascript:后面跟的androidGetJs就是js里面定义的方法. 然后我们将android中的值传入显示在了div上
                    webView.loadUrl("javascript:androidGetJs('" + trim + "')");
                }
                break;
        }
    }

    private void initWebView() {
        webView.loadUrl("file:///android_asset/android_js.html");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);//允许使用js
        webView.setWebViewClient(webViewClient);
        webView.setWebChromeClient(webChromeClient);
        //此为Js调用Android中的方法
        //  在Js中用了androidjs.showInfoFromJs("我是被Js调用的Android代码,
        //将html的数据传入Android吐司中")调用android的方法, androidjs对应该方法的第二个参数
        webView.addJavascriptInterface(new JavaScriptInterface(this), "androidjs");
    }

    /**
     * 配置Js调用Android里面的方法
     */
    private class JavaScriptInterface{
        private Context context;
        public JavaScriptInterface(Context context){
            this.context = context;
        }
        @JavascriptInterface  //记得在方法前加上@JavascriptInterface
        public String showInfoFromJs(final String string){
            ((Activity)context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ToastUtils.showStatic(mAct, string);
                }
            });
            return string;
        }
    }

    private WebViewClient webViewClient = new WebViewClient(){
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO: 2018-05-31 页面加载前
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO: 2018-05-31 页面加载完成
            super.onPageFinished(view, url);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO: 2018-05-31 重写该方法,禁用外部浏览器
            view.loadUrl(url);
            return true;
        }

    };

    private WebChromeClient webChromeClient = new WebChromeClient(){
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            AlertDialog.Builder localBuilder = new AlertDialog.Builder(webView.getContext());
            localBuilder.setMessage(message).setPositiveButton("确定",null);
            localBuilder.setCancelable(false);
            localBuilder.create().show();
            //注意:
            //必须要这一句代码:result.confirm()表示:
            //处理结果为确定状态同时唤醒WebCore线程
            //否则不能继续点击按钮
            result.confirm();
            return true;
//            return super.onJsAlert(view, url, message, result);
        }
        @Override
        public void onReceivedTitle(WebView view, String title) {
            // TODO: 2018-05-31 获取网页标题
            super.onReceivedTitle(view, title);
            LogUtils.write("网页标题: " + title);
        }
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            // TODO: 2018-05-31 页面加载进度
            ToastUtils.showStatic(mAct, newProgress+"");
        }
    };

}