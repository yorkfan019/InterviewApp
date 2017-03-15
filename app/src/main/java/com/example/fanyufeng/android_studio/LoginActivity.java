package com.example.fanyufeng.android_studio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends BaseActivity {

    EditText pwd,name;
    Button login,exit;
    CheckBox cb,auto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = (EditText)findViewById(R.id.name);
        pwd = (EditText)findViewById(R.id.pwd);
        login = (Button)findViewById(R.id.login);
        exit = (Button)findViewById(R.id.exit_login);
        cb = (CheckBox)findViewById(R.id.remember);
        auto =(CheckBox)findViewById(R.id.auto_login);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    editor.putBoolean("remember",true);
                }
                else{
                    editor.putBoolean("remember", false);
                }
            }
        });
        auto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    editor.putBoolean("auto",true);
                }
                else{
                    editor.putBoolean("auto",false);

                }
            }
        });

        Boolean remember = sharedPreferences.getBoolean("remember",false);
        Boolean auto_login = sharedPreferences.getBoolean("auto",false);
        if(auto_login){
            auto.setChecked(true);
        }
        if(remember){
            name.setText(sharedPreferences.getString("name", ""));
            pwd.setText(sharedPreferences.getString("pwd", ""));
            cb.setChecked(true);
            if(auto_login){
                String NAME = name.getText().toString().trim();
                String PWD = pwd.getText().toString().trim();
                if (NAME.equals("fan") && PWD.equals("123456")){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }

            }

        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NAME = name.getText().toString().trim();
                String PWD = pwd.getText().toString().trim();
                editor.putString("name",NAME);
                editor.putString("pwd", PWD);
                editor.commit();
                if (NAME.equals("fan") && PWD.equals("123456")) {

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "error login ", Toast.LENGTH_LONG).show();
                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NAME = name.getText().toString().trim();
                String PWD = pwd.getText().toString().trim();
                editor.putString("name", NAME);
                editor.putString("pwd", PWD);
                editor.commit();
                exit();
            }
        });
    }

}
