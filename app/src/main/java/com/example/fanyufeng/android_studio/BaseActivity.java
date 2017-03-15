package com.example.fanyufeng.android_studio;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class BaseActivity extends Activity {

    public static List<Activity> activityList = new ArrayList<Activity>();
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerActivity(this);
        sharedPreferences = this.getSharedPreferences("login",MODE_PRIVATE);
        editor =  sharedPreferences.edit();
    }

    public void registerActivity(Activity activity){
        if(!activityList.contains(activity)) {
            activityList.add(activity);
        }
    }

    protected void clearActivity(){
        for(int i=0;i<activityList.size();i++) {
            if(null != activityList.get(i)){
                activityList.get(i).finish();
            }
        }
    }

    public void exit(){
        clearActivity();
        System.exit(0);
    }


}
