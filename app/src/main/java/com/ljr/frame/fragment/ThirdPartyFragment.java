package com.ljr.frame.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.ljr.frame.BaseFragment;
import com.ljr.frame.R;
import com.ljr.frame.adapter.CommonFragmentAdapter;

/**
 * Created by LinJiaRong on 2017/4/8.
 * TODO：第三方
 */

public class ThirdPartyFragment extends BaseFragment {
    private static final String TAG = ThirdPartyFragment.class.getSimpleName();
    private String[] mDatas;
    private ListView mListview;

    @Override
    protected View initView() {
        Log.d(TAG, "initView: 第三方Fragment页面被初始化了...");
        View view = View.inflate(mContext, R.layout.fragment_thirdparty, null);
        return view;
    }
    
    @Override
    protected void initData() {
        super.initData();
        Log.d(TAG, "initData: 第三方Fragment数据被初始化了...");
    }
}
