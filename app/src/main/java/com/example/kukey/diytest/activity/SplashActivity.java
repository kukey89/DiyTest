package com.example.kukey.diytest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.kukey.diytest.R;
import com.example.kukey.diytest.config.AppConfig;
import com.example.kukey.diytest.global.AppConstants;


public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 判断是否是第一次开启应用
        boolean isFirstOpen = AppConfig.getInstance().getBoolean(AppConstants.FIRST_OPEN,false);
        // 如果是第一次启动，则先进入功能引导页
        if (!isFirstOpen) {
            Intent intent = new Intent(this, WelcomeGuideActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        // 如果不是第一次启动app，则正常显示启动屏
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                enterHomeActivity();
            }
        }, 2000);
    }

    private void enterHomeActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
