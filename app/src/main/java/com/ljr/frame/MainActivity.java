package com.ljr.frame;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.ljr.frame.fragment.CommonFragment;
import com.ljr.frame.fragment.CustomFragment;
import com.ljr.frame.fragment.OtherFragment;
import com.ljr.frame.fragment.ThirdPartyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RadioGroup mRgMain;
    private List<BaseFragment> mBaseFragment;
    //Fragment的对应位置数字
    private int mPosition;
    //当前选中的Fragment
    private Fragment mContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRgMain = (RadioGroup) findViewById(R.id.rg_main);
        initFragment();
        setListener();
    }

    //初始化Fragment
    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new CommonFragment());
        mBaseFragment.add(new CustomFragment());
        mBaseFragment.add(new ThirdPartyFragment());
        mBaseFragment.add(new OtherFragment());
    }

    /**
     * 设置RadioGroup的监听
     */
    private void setListener() {
        mRgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                switch (checkedId) {
                    case R.id.rb_common:
                        mPosition = 0;
                        break;
                    case R.id.rb_thirdparty:
                        mPosition = 1;
                        break;
                    case R.id.rb_custom:
                        mPosition = 2;
                        break;
                    case R.id.rb_other:
                        mPosition = 3;
                        break;
                    default:
                        mPosition = 0;
                        break;
                }
                //根据位置得到对应的fragment
                BaseFragment toFragment = getFragment();
                //切换fragment
              //  switchFragment(toFragment); 会导致每次切换fragment切换都重新初始化
                switchContent(mContent,toFragment);
            }
        });
        //设置默认选中常用框架
        mRgMain.check(R.id.rb_common);
    }

    //根据位置得到对应的fragment
    private BaseFragment getFragment() {
        BaseFragment fragment = mBaseFragment.get(mPosition);
        return fragment;
    }

    /**
     *
     * @param fromFragment 当前显示的Fragment，准备被隐藏
     * @param toFragment 马上要切换的Fragment，准备显示
     */
    public void switchContent(Fragment fromFragment, Fragment toFragment) {
        if(fromFragment != toFragment){
            mContent = toFragment;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if(!toFragment.isAdded()){
                //toFragment没有被添加
                //1.先隐藏fromFragment
                if(fromFragment != null){
                    ft.hide(fromFragment);
                }
                //2.再添加toFragment
                if(toFragment != null){
                    ft.add(R.id.fl_content,toFragment).commit();
                }
            }else{
                //toFragment已被添加
                //1.先隐藏fromFragment
                if(fromFragment != null){
                    ft.hide(fromFragment);
                }
                //2.再显示toFragment
                if(toFragment != null){
                    ft.show(toFragment).commit();
                }
            }
        }
    }



    /**
     * 以下方法会导致Fragment每次切换都重新初始化
     */
/*
    //切换fragment
    private void switchFragment(BaseFragment fragment) {
        //获取FragmentManger
        FragmentManager fragmentManager = getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //替换
        transaction.replace(R.id.fl_content,fragment);
        //提交事务
        transaction.commit();
    }*/


}
