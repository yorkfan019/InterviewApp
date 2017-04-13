package com.fyf.interview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fyf.interview.persistence.activitiys.PostListActivity;
import com.fyf.interview.webviewSample.activitys.webviewWithJsActivity;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button persistenceButton = (Button) findViewById(R.id.btn_persistence_sample);
        Button webviewButton = (Button) findViewById(R.id.btn_webview_sample);
        persistenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PostListActivity.class);
                startActivity(i); // brings up the other activity
            }
        });
        webviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, webviewWithJsActivity.class);
                startActivity(i); // brings up the other activity
            }
        });
    }

}
