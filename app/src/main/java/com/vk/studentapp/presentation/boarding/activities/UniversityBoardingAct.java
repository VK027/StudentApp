package com.vk.studentapp.presentation.boarding.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vk.studentapp.R;
import com.vk.studentapp.adapters.HomeViewPagerAdapter;
import com.vk.studentapp.custom.stepper.StepView;
import com.vk.studentapp.presentation.BaseActivity;
import com.vk.studentapp.presentation.boarding.fragments.PersonalInfoFragment;
import com.vk.studentapp.presentation.boarding.fragments.ProgramInfoFragment;
import com.vk.studentapp.presentation.boarding.fragments.ReviewFragment;
import com.vk.studentapp.presentation.boarding.fragments.SubmitFragment;
import com.vk.studentapp.presentation.boarding.fragments.TravelFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniversityBoardingAct extends BaseActivity {

    private int currentStep = 0;
    private ViewPager viewPager;
    private StepView stepView;
    public FloatingActionButton fab_next;

    private final String[] stepTextArray = {"Personal Information", "Program Information", "Travel", "Review", "Submit"};

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_university_boarding;
    }
    AppCompatTextView heading_text;
    @Override
    protected void initGUI(Bundle savedInstanceState) {
        heading_text = findViewById(R.id.heading_text);
        fab_next = findViewById(R.id.fab_next);
        viewPager = findViewById(R.id.on_boarding_viewpager);
        stepView = findViewById(R.id.step_view);
        heading_text.setText(R.string.text_on_boarding);
        List<String> stepList = new ArrayList<>(Arrays.asList(stepTextArray));
        stepView.setSteps(stepList);

        stepView.setOnStepClickListener(new StepView.OnStepClickListener() {
            @Override
            public void onStepClick(int step) {
                //Toast.makeText(UniversityBoardingAct.this, "Step " + step, Toast.LENGTH_SHORT).show();
               /* switch (step){
                }*/
                currentStep = step;
                viewPager.setCurrentItem(step);
                stepView.done(false);
                stepView.go(step, true);
            }
        });

        fab_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentStep < stepView.getStepCount() - 1) {
                    currentStep++;
                    stepView.go(currentStep, true);
                    viewPager.setCurrentItem(currentStep);
                } else {
                    stepView.done(true);
                }
            }
        });
    }

    @Override
    protected void initData() {

        HomeViewPagerAdapter homeViewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager());
        homeViewPagerAdapter.addFrag(new PersonalInfoFragment(fab_next), getString(R.string.text_personal));
        homeViewPagerAdapter.addFrag(new ProgramInfoFragment(fab_next), getString(R.string.text_program));
        homeViewPagerAdapter.addFrag(new TravelFragment(fab_next), getString(R.string.text_travel));
        homeViewPagerAdapter.addFrag(new ReviewFragment(fab_next), getString(R.string.text_review));
        homeViewPagerAdapter.addFrag(new SubmitFragment(fab_next), getString(R.string.text_submit));
        viewPager.setAdapter(homeViewPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // stepView.go(position, true);
            }

            @Override
            public void onPageSelected(int position) {
                currentStep = position;
                stepView.go(position, true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
