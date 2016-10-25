package com.bobo.fragmenttest;

import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by bjmaoqisheng on 2016/7/25.
 */
public abstract class BaseFragment extends Fragment {
    public String title;
    protected abstract void initWindow(View view);

    protected abstract void preInitView();

    protected abstract void initView(View view);

    protected abstract void afterInitView();
}
