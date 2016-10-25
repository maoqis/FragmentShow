package com.bobo.fragmenttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;


public class OneFragment extends CacheFragment{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        title = this.getClass().getSimpleName();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    protected void initWindow(View view) {
        TextView tv = (TextView) view.findViewById(R.id.tv_title);

        tv.setText(title);
    }

    @Override
    protected void preInitView() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void afterInitView() {
    }
}
