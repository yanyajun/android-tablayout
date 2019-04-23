package com.newstablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by zq on 2017/1/12.
 */

public class TabLessActivity extends AppCompatActivity {

    private TabLayout tabLayout = null;

    private ViewPager viewPager;

    private Fragment[] mFragmentArrays = new Fragment[2];

    private String[] mTabTitles = new String[2];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tab_layout);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.tab_viewpager);
        initView();
    }

    private void initView() {
        mTabTitles[0] = "推荐";
        mTabTitles[1] = "热点";
//        mTabTitles[2] = "科技";
//        mTabTitles[3] = "体育";
//        mTabTitles[4] = "健康";
//        mTabTitles[5] = "健康1";
//        mTabTitles[6] = "健康2";
//        mTabTitles[7] = "健康3";
//        mTabTitles[8] = "健康4";
//        mTabTitles[9] = "健康5";
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //设置tablayout距离上下左右的距离
        //tab_title.setPadding(20,20,20,20);
        mFragmentArrays[0] = new TabFragment(0);
        mFragmentArrays[1] = new TabFragment(1);
//        mFragmentArrays[2] = new TabFragment(2);
//        mFragmentArrays[3] = new TabFragment(3);
//        mFragmentArrays[4] = new TabFragment(4);
//        mFragmentArrays[5] = new TabFragment(5);
//        mFragmentArrays[6] = new TabFragment(6);
//        mFragmentArrays[7] = new TabFragment(7);
//        mFragmentArrays[8] = new TabFragment(8);
//        mFragmentArrays[9] = new TabFragment(9);
        PagerAdapter pagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        //将ViewPager和TabLayout绑定
        tabLayout.setupWithViewPager(viewPager);
    }

    final class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentArrays[position];
        }


        @Override
        public int getCount() {
            return mFragmentArrays.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabTitles[position];

        }
    }
}
