package com.example.kukey.diytest.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import com.example.kukey.diytest.R;
import com.example.kukey.diytest.bean.HealthClassifyBean;
import com.example.kukey.diytest.net.AbsAPICallback;
import com.example.kukey.diytest.net.LocalService;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

        LocalService.getApi().getHealthClassify()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<List<HealthClassifyBean>>() {
                    @Override
                    protected void onDone(List<HealthClassifyBean> list) {

                        //请求成功，做相应的页面操作
                        Log.i("kukey","成功"+list.get(0).getDescription());

                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        //e.getMessage() 可获取服务器返回错误信息
                        Log.i("kukey","失败"+e);
                    }
                });
    }

    @Override
    public void onClick(View v) {

    }
}
