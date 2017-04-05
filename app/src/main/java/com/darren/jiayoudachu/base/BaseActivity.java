package com.darren.jiayoudachu.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Darren on 17/3/29.
 * BaseActivity
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayoutID());
        initLayoutID();
        initView();
        initViewListener();
        initProcess();
    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T findView(int rsId) {
        return (T) findViewById(rsId);
    }

    /**
     * Activity 必须重写的方法
     * */
    /**
     * 加载布局xml
     */
    protected abstract int initLayoutID();

    /**
     * 初始化页面控件
     */
    protected abstract void initView();

    /**
     * 页面控件点击事件
     */
    protected abstract void initViewListener();

    /**
     * 界面逻辑处理，包括activity之间的bundle数据传递处理也在此方法
     */
    protected abstract void initProcess();

    /**
     * 隐藏输入法
     */
    protected void hideInput(View view) {
        if (view == null)
            return;
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0); // 隐藏
    }

    /**
     * 显示输入法
     */
    protected void showInput(View view) {
        if (view == null)
            return;
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }

}
