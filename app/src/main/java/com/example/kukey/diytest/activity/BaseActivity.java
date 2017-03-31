package com.example.kukey.diytest.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kukey.diytest.R;

/**
 * Created by kukey on 2017/3/31.
 */

public abstract class BaseActivity extends Activity{

    private FrameLayout mContentLayoutRoot;
    private RelativeLayout mTitleLayoutRoot;
    private TextView mTvTitle;
    private ImageView mIvBackBar;
    private LinearLayout mMenuLayoutRoot;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window win = getWindow();
        win.setContentView(R.layout.activity_base);

        mTitleLayoutRoot = (RelativeLayout) win.findViewById(R.id.base_rl_title_root);
        mTvTitle = (TextView) mTitleLayoutRoot.findViewById(R.id.base_tv_title);
        mIvBackBar = (ImageView) mTitleLayoutRoot.findViewById(R.id.base_iv_backbar);
        mIvBackBar.setOnClickListener(mClickerListener);
        mMenuLayoutRoot = (LinearLayout) mTitleLayoutRoot.findViewById(R.id.base_ll_menu_root);
        mContentLayoutRoot = (FrameLayout) win.findViewById(R.id.base_fl_content_root);
        onActivityCreate(savedInstanceState);
    }

    protected abstract void onActivityCreate(Bundle savedInstanceState);

    protected void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG);
    }

    protected void hideTitleLayout() {
        mTitleLayoutRoot.setVisibility(View.GONE);
    }

    protected void showTitleLayout() {
        mTitleLayoutRoot.setVisibility(View.VISIBLE);
    }

    protected void hideBackBar() {
        mIvBackBar.setVisibility(View.GONE);
    }

    protected void showBackBar() {
        mIvBackBar.setVisibility(View.VISIBLE);
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T findById(int id) {
        return (T) mContentLayoutRoot.findViewById(id);
    }

    @Override
    public View findViewById(int id) {
        return mContentLayoutRoot.findViewById(id);
    }

    private void clearContentView() {
        mContentLayoutRoot.removeAllViews();
    }

    @Override
    public void setContentView(int layoutResID) {
        clearContentView();
        getLayoutInflater().inflate(layoutResID, mContentLayoutRoot, true);
    }

    @Override
    public void setContentView(View view) {
        clearContentView();
        mContentLayoutRoot.addView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        clearContentView();
        mContentLayoutRoot.addView(view, params);
    }

    private View.OnClickListener mClickerListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            onBackPressed();
        }
    };

    @Override
    public void setTitle(CharSequence title) {
        mTvTitle.setText(title);
    };

    @Override
    public void setTitle(int titleId) {
        mTvTitle.setText(titleId);
    };

    protected void setTitleGravity(int position) {
        mTvTitle.setGravity(Gravity.CENTER);
    }

}
