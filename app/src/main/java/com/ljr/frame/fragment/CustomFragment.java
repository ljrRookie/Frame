package com.ljr.frame.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.ljr.frame.BaseFragment;
import com.ljr.frame.R;

/**
 * Created by LinJiaRong on 2017/4/8.
 * TODO：自定义控件
 */

public class CustomFragment extends BaseFragment {
    private static final String TAG = CustomFragment.class.getSimpleName();
    private String[] mDatas;
    private ListView mListview;

    @Override
    protected View initView() {
        Log.d(TAG, "initView: 自定义控件Fragment页面被初始化了...");
        View view = View.inflate(mContext, R.layout.fragment_custom, null);
        return view;
    }
    
    @Override
    protected void initData() {
        super.initData();
        Log.d(TAG, "initData: 自定义控件Fragment数据被初始化了...");
    }
}
