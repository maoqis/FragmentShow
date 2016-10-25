package com.bobo.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager viewpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        viewpage = (ViewPager) findViewById(R.id.viewpage);
        viewpage.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position ==0){
                    return  new OneFragment();
                }else if (position ==1){
                    return  new TwoFragment();
                }else if (position ==2){
                    return  new ThreeFragment();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });

    }

    @Override
    public void onClick(View view) {
        viewpage.setCurrentItem(2,true);
    }
}
