package com.vk.studentapp.presentation.home.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.vk.studentapp.R;
import com.vk.studentapp.adapters.HomeGridAdapter;
import com.vk.studentapp.adapters.ImagesViewPagerAdapter;
import com.vk.studentapp.custom.recyclerviewitemspace.SpacesItemDecoration;
import com.vk.studentapp.models.HomeGrid;
import com.vk.studentapp.presentation.home.activities.UniversityDetailAct;
import com.vk.studentapp.presentation.homeservices.activities.HealthNSafetyActivity;
import com.vk.studentapp.presentation.homeservices.activities.LatestNewsActivity;
import com.vk.studentapp.presentation.homeservices.activities.StudentLifeActivity;
import com.vk.studentapp.presentation.homeservices.activities.StudentUpdateActivity;
import com.vk.studentapp.util.GlobalMethods;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    // private Context mContext;
    private int dotscount;
    private ImageView[] dots;
    private Context context;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        context=getActivity();
        readBundle();
        initGUI(view);
        initData();
        actionEvents(view);
        return view;
        // return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void actionEvents(View view) {
        view.findViewById(R.id.text_know_more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(new Intent(getActivity(), UniversityDetailAct.class));
                GlobalMethods.callForWordActivity(getActivity(), UniversityDetailAct.class, null, false, true);

            }
        });
    }

    private void initData() {

    }

    private void initGUI(View view) {
        ViewPager viewPager = view.findViewById(R.id.viewpager);
        LinearLayout sliderDots = view.findViewById(R.id.sliderDots);

        ImagesViewPagerAdapter viewPagerAdapter = new ImagesViewPagerAdapter(getActivity());
        viewPagerAdapter.notifyDataSetChanged();
        viewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {
            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.non_active_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDots.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.non_active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        RecyclerView home_grid_list = view.findViewById(R.id.home_grid_list);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        home_grid_list.setLayoutManager(layoutManager);
        home_grid_list.setNestedScrollingEnabled(true);
//        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.padding_5dp);
        home_grid_list.setHasFixedSize(true);
        home_grid_list.addItemDecoration(new SpacesItemDecoration(0));

        List<HomeGrid> homeGridList = new ArrayList<>();
        homeGridList.add(new HomeGrid(getResources().getDrawable(R.drawable.ic_student_services), getResources().getString(R.string.student_service_update)));
        homeGridList.add(new HomeGrid(getResources().getDrawable(R.drawable.ic_health_safety), getResources().getString(R.string.health_safety_measure)));
        homeGridList.add(new HomeGrid(getResources().getDrawable(R.drawable.ic_latest_update), getResources().getString(R.string.latest_news_update)));
        homeGridList.add(new HomeGrid(getResources().getDrawable(R.drawable.ic_student_life), getResources().getString(R.string.student_life_campus)));

        HomeGridAdapter homeGridAdapter = new HomeGridAdapter(getActivity(), homeGridList, new HomeGridAdapter.OnItemViewListener() {
            @Override
            public void selectedItem(int homeGrid) {
                switch (homeGrid){
                    case 0:
                        GlobalMethods.callForWordActivity(context, StudentUpdateActivity.class,null,false,true);
                        break;
                    case 1:
                        GlobalMethods.callForWordActivity(context, HealthNSafetyActivity.class,null,false,true);
                        break;
                    case 2:
                        GlobalMethods.callForWordActivity(context, LatestNewsActivity.class,null,false,true);
                        break;
                    case 3:
                        GlobalMethods.callForWordActivity(context, StudentLifeActivity.class,null,false,true);
                        break;
                }
            }
        });
        home_grid_list.setAdapter(homeGridAdapter);

    }

    private void readBundle() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {

        }
    }
}
