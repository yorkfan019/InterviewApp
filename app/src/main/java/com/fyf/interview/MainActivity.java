package com.fyf.interview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;


public class MainActivity extends Activity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.edit_text);
    }

}
