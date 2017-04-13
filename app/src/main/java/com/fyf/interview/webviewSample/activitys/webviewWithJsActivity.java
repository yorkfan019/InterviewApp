package com.fyf.interview.webviewSample.activitys;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

import com.fyf.interview.R;

public class webviewWithJsActivity extends AppCompatActivity {

    private WebView contentWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_with_js);

        contentWebView = (WebView) findViewById(R.id.webview);
        contentWebView.getSettings().setJavaScriptEnabled(true);
        contentWebView.loadUrl("file:///android_asset/testWeb.html");
        contentWebView.addJavascriptInterface(webviewWithJsActivity.this,"android");

        //Button按钮 无参调用HTML js方法
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 无参数调用 JS的方法
                contentWebView.loadUrl("javascript:javacalljs()");

            }
        });
        //Button按钮 有参调用HTML js方法
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 传递参数调用JS的方法
                contentWebView.loadUrl("javascript:javacalljswith(" + "'york_test_webview_content'" + ")");
            }
        });

    }

    //由于安全原因 targetSdkVersion>=17需要加 @JavascriptInterface
    //JS调用Android JAVA方法名和HTML中的按钮 onclick后的别名后面的名字对应
    @JavascriptInterface
    public void startFunction(){

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(webviewWithJsActivity.this,"show",Toast.LENGTH_LONG).show();

            }
        });
    }

    @JavascriptInterface
    public void startFunction(final String text){
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                new AlertDialog.Builder(webviewWithJsActivity.this).setMessage(text).show();

            }
        });


    }

}
