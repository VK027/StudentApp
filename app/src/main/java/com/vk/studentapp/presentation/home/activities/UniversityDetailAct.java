package com.vk.studentapp.presentation.home.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.vk.studentapp.R;
import com.vk.studentapp.adapters.HomeViewPagerAdapter;
import com.vk.studentapp.presentation.BaseActivity;
import com.vk.studentapp.custom.NonSwipeableViewPager;
import com.vk.studentapp.presentation.home.fragments.childfragment.CoursesFragment;
import com.vk.studentapp.presentation.home.fragments.childfragment.KnowMoreFragment;
import com.vk.studentapp.util.GlobalMethods;

public class UniversityDetailAct extends BaseActivity {

    private NonSwipeableViewPager viewPager;
    private TabLayout tabLayout;
    private Context mContext;

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_home_university_details;
    }

    @Override
    protected void initGUI(Bundle savedInstanceState) {
        mContext = this;
        viewPager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText(mContext.getResources().getString(R.string.know_more)));
        tabLayout.addTab(tabLayout.newTab().setText(mContext.getResources().getString(R.string.courses)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setSelectedTabIndicatorHeight(0);


        //Creating our pager adapter
//        final FragmentAdapter adapter = new FragmentAdapter(mContext, getSupportFragmentManager(), tabLayout.getTabCount());
//        viewPager.setAdapter(adapter);

        HomeViewPagerAdapter homeViewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager());
        homeViewPagerAdapter.addFrag(new KnowMoreFragment(), getString(R.string.know_more));
        homeViewPagerAdapter.addFrag(new CoursesFragment(), getString(R.string.courses));
        viewPager.setAdapter(homeViewPagerAdapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(), true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void initData() {
        findViewById(R.id.toolbar_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalMethods.callFinishForBackWordActivity(UniversityDetailAct.this, false);
            }
        });
    }

}