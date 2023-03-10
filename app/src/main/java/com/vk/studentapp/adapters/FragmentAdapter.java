package com.vk.studentapp.adapters;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.vk.studentapp.presentation.home.fragments.childfragment.CoursesFragment;
import com.vk.studentapp.presentation.home.fragments.childfragment.KnowMoreFragment;

public class FragmentAdapter extends FragmentStatePagerAdapter {

    private Context myContext;
    int totalTabs;

    public FragmentAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new KnowMoreFragment();
               // ((BaseActivity)myContext).replaceFragment(KnowMoreFragment.class, R.id.pager,null);
            case 1:
                return new CoursesFragment();
            default:
                return null;
        }
    }

    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}