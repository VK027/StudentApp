package com.vk.studentapp.presentation.homeservices.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vk.studentapp.R;
import com.vk.studentapp.adapters.StudentServiceAdapter;
import com.vk.studentapp.models.StudentServiceUpdateModel;
import com.vk.studentapp.presentation.BaseActivity;
import com.vk.studentapp.util.GlobalMethods;

import java.util.ArrayList;
import java.util.List;

public class StudentUpdateActivity extends BaseActivity {

    private Context mContext;
    private AppCompatTextView tv_student_describe;
    private RecyclerView rv_service_updates;
    private AppCompatTextView heading_text;

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_studentservice_update;
    }

    @Override
    protected void initGUI(Bundle savedInstanceState) {
        mContext = this;
        tv_student_describe = findViewById(R.id.tv_student_describe);
        rv_service_updates = findViewById(R.id.rv_service_updates);
        heading_text = findViewById(R.id.heading_text);
        heading_text.setText(R.string.student_service_update);

        //set data to adapter
        setDataToAdapter();

    }

    @Override
    protected void initData() {
        findViewById(R.id.toolbar_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalMethods.callFinishForBackWordActivity(mContext, true);
            }
        });
    }


    private void setDataToAdapter() {
        List<StudentServiceUpdateModel> studentServiceUpdateModels = new ArrayList<>();
        studentServiceUpdateModels.add(new StudentServiceUpdateModel(mContext.getResources().getString(R.string.question), mContext.getResources().getString(R.string.answer)));
        studentServiceUpdateModels.add(new StudentServiceUpdateModel(mContext.getResources().getString(R.string.question), mContext.getResources().getString(R.string.answer)));
        studentServiceUpdateModels.add(new StudentServiceUpdateModel(mContext.getResources().getString(R.string.question), mContext.getResources().getString(R.string.answer)));
        studentServiceUpdateModels.add(new StudentServiceUpdateModel(mContext.getResources().getString(R.string.question), mContext.getResources().getString(R.string.answer)));
        studentServiceUpdateModels.add(new StudentServiceUpdateModel(mContext.getResources().getString(R.string.question), mContext.getResources().getString(R.string.answer)));
        studentServiceUpdateModels.add(new StudentServiceUpdateModel(mContext.getResources().getString(R.string.question), mContext.getResources().getString(R.string.answer)));

        StudentServiceAdapter studentServiceAdapter = new StudentServiceAdapter(mContext, studentServiceUpdateModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
        rv_service_updates.setLayoutManager(linearLayoutManager);
        rv_service_updates.setAdapter(studentServiceAdapter);
        studentServiceAdapter.notifyDataSetChanged();

    }
}
