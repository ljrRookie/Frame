package com.ljr.frame;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by LinJiaRong on 2017/4/7.
 * TODO：
 */

public abstract class BaseFragment extends Fragment {
    //上下文
    protected Context mContext;
    //判断该Fragment是否被初始化过
    private boolean isInit = false;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        return initView();
    }

    /**
     * 由子类实现该方法，创建自己的视图
     * @return
     */
    protected abstract View initView();

    /**
     * 确保与碎片相关联的活动一定已经创建完毕的时候调用
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 子类，需要初始化数据，联网请求数据，绑定数据等可重写该方法
     */
    protected  void initData(){

    };
}
