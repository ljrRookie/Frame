package com.ljr.frame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.widget.TextView;


public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        TextView time = (TextView) findViewById(R.id.time);
        Time t=new Time();
        t.setToNow();
        int month=t.month+1;
        int monthDay=t.monthDay+1;
        time.setText(t.year+":"+month+":"+monthDay);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //在主线程中执行
                startActivity(new Intent(LauncherActivity.this,MainActivity.class));
                finish();
            }
        },2000);
    }
}
