package com.example.kukey.diytest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kukey.diytest.R;
import com.example.kukey.diytest.adapter.GuideViewAdapter;
import com.example.kukey.diytest.config.AppConfig;
import com.example.kukey.diytest.global.AppConstants;

import java.util.ArrayList;
import java.util.List;

public class WelcomeGuideActivity extends Activity  {

	public static final String TAG = "WelcomeGuideActivity";
	private ViewPager viewPage;
	// 图片
	private int[] imageView = { R.mipmap.pic_guidepage_1, R.mipmap.pic_guidepage_2,
			R.mipmap.pic_guidepage_3, R.mipmap.pic_guidepage_4 };
	private List<View> list;
	// 底部小点的图片
	private LinearLayout llPoint;
	//立即进入按钮
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		initview();
		initoper();
		addView();
		addPoint();

	}

	private void initoper() {
		// 进入按钮
		textView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
//				PageManage.toPageKeepOldPageState(PageDataKey.login);
				AppConfig.getInstance().putBoolean(AppConstants.FIRST_OPEN, true);
				Intent intent = new Intent(WelcomeGuideActivity.this, SplashActivity.class);
				startActivity(intent);
				finish();
			}
		});

		// 2.监听当前显示的页面，将对应的小圆点设置为选中状态，其它设置为未选中状态
		viewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				monitorPoint(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				Log.i( TAG,"arg0--"+ arg0);
			}
		});

	}

	private void initview() {
		viewPage = (ViewPager) findViewById(R.id.viewpage);
		llPoint = (LinearLayout) findViewById(R.id.llPoint);
		textView = (TextView) findViewById(R.id.guideTv);

	}

	/**
	 * 添加图片到view
	 */
	private void addView() {
		list = new ArrayList<View>();
		// 将imageview添加到view
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		for (int i = 0; i < imageView.length; i++) {
			ImageView iv = new ImageView(this);
			iv.setLayoutParams(params);
			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			iv.setImageResource(imageView[i]);
			list.add(iv);
		}
		// 加入适配器
		viewPage.setAdapter(new GuideViewAdapter(list));

	}

	/**
	 * 添加小圆点
	 */
	private void addPoint() {
		// 1.根据图片多少，添加多少小圆点
		for (int i = 0; i < imageView.length; i++) {
			LinearLayout.LayoutParams pointParams = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
			if (i < 1) {
				pointParams.setMargins(0, 0, 0, 0);
			} else {
				pointParams.setMargins(10, 0, 0, 0);
			}
			ImageView iv = new ImageView(this);
			iv.setLayoutParams(pointParams);
//			iv.setBackgroundResource(R.mipmap.point_normal);
			iv.setBackgroundColor(getResources().getColor(R.color.white));
			llPoint.addView(iv);
		}
//		llPoint.getChildAt(0).setBackgroundResource(R.mipmap.point_select);
		llPoint.getChildAt(0).setBackgroundColor(getResources().getColor(R.color.red));

	}

	/**
	 * 判断小圆点
	 *
	 * @param position
	 */
	private void monitorPoint(int position) {
		for (int i = 0; i < imageView.length; i++) {
			if (i == position) {
				llPoint.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.red));
			} else {
				llPoint.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.white));
			}
		}
		// 3.当滑动到最后一个添加按钮点击进入，
		if (position == imageView.length - 1) {
			textView.setVisibility(View.VISIBLE);
		} else {
			textView.setVisibility(View.GONE);
		}
	}
}
