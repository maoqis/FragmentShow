package com.bobo.fragmenttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.content.ContentValues.TAG;

/**
 * Created by bjmaoqisheng on 2016/7/25.
 */
public abstract class CacheFragment extends BaseFragment {
    private View mViewContent;
    public boolean isCreated = false;
    public boolean isShow = false;
    /**
     * 显示过第一次true
     */
    public boolean isFirstUserVisibleHintTrue = true;
    /**
     * 最后一次的值
     */
    boolean lastVisibleToUser = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, title +" onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        if (mViewContent == null) {
            mViewContent = inflater.inflate(getLayoutId(), container, false);
            initWindow(mViewContent);
            preInitView();
            initView(mViewContent);
            afterInitView();

        }
        // 缓存View判断是否含有parent, 如果有需要从parent删除, 否则发生已有parent的错误.
        ViewGroup parent = (ViewGroup) mViewContent.getParent();
        if (parent != null) {
            parent.removeView(mViewContent);
        }

        if (!isFirstUserVisibleHintTrue && lastVisibleToUser){
            onShowFragment();
        }

        isCreated =true;
        return mViewContent;
    }

    @Override
    public void onResume() {
//        Log.d(TAG, "onResume() called" +title);
        super.onResume();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        lastVisibleToUser = isVisibleToUser;
        if (isVisibleToUser){
            if (isFirstUserVisibleHintTrue){
                isFirstUserVisibleHintTrue = false;
            }
        }
        if (isVisibleToUser == true) isFirstUserVisibleHintTrue = false;
//        Log.d(TAG, title +" setUserVisibleHint() called with: isVisibleToUser = [" + isVisibleToUser + "]");
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isCreated) {
            onShowFragment();
        }
        if (!isVisibleToUser && isCreated) {
            onHideFragment();
        }
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView() called "+title);
        isCreated =false;
        super.onDestroyView();
    }

    protected void onShowFragment() {
        Log.d(TAG, "onShowFragment() called "+title);
    }

    protected void onHideFragment() {
        Log.d(TAG, "onHideFragment() called" +title);
    }

    protected abstract int getLayoutId();


}
