package com.example.kukey.diytest.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.example.kukey.diytest.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {



    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        setTitle("花生理财");
        setTitleGravity(Gravity.CENTER);
		hideTitleLayout();
        hideBackBar();
    }

    @Override
    public void onClick(View v) {

    }
}
