package com.ljr.frame.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ljr.frame.BaseFragment;
import com.ljr.frame.R;
import com.ljr.frame.activity.OkHttpActivity;
import com.ljr.frame.adapter.CommonFragmentAdapter;

import static android.content.ContentValues.TAG;

/**
 * Created by LinJiaRong on 2017/4/8.
 * TODO：常用框架
 */

public class CommonFragment extends BaseFragment {
    private static final String TAG = CommonFragment.class.getSimpleName();
    private String[] mDatas;
    private ListView mListview;

    @Override
    protected View initView() {
        Log.d(TAG, "initView: 常用框架Fragment页面被初始化了...");
        View view = View.inflate(mContext, R.layout.fragment_common, null);
        mListview = (ListView) view.findViewById(R.id.listview);
mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String data = mDatas[position];
        if(data.toLowerCase().equals("okhttp")){
            mContext.startActivity(new Intent(mContext, OkHttpActivity.class));
        }
    }
});
        return view;
    }
    
    @Override
    protected void initData() {
        super.initData();
        Log.d(TAG, "initData: 常用框架Fragment数据被初始化了...");
        mDatas = new String[]{"OKHttp", "xUtils3", "Retrofit2", "Fresco", "Glide", "greenDao"
                , "RxJava", "volley", "Gson", "FastJson", "picasso", "evenBus", "jcvideoplayer"
                , "pulltorefresh", "Expandablelistview", "UniversalVideoView", "~~~~"};
        CommonFragmentAdapter adapter = new CommonFragmentAdapter(mContext, mDatas);
        mListview.setAdapter(adapter);

    }
}
