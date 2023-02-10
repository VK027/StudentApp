package com.vk.studentapp.presentation.homeservices.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vk.studentapp.R;
import com.vk.studentapp.adapters.StudentLifeAdapter;
import com.vk.studentapp.models.StudentLifeModel;
import com.vk.studentapp.presentation.BaseActivity;
import com.vk.studentapp.util.GlobalMethods;

import java.util.ArrayList;
import java.util.List;

public class StudentLifeActivity extends BaseActivity {

    private Context mContext;
    private AppCompatTextView header_text;
    private RecyclerView rv_student_life;

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_student_life;
    }

    @Override
    protected void initGUI(Bundle savedInstanceState) {
        mContext=this;
        header_text=findViewById(R.id.heading_text);
        rv_student_life=findViewById(R.id.rv_student_life);
        header_text.setText(R.string.student_life_campus);
        //set data to adapter
        setDataToAdapter();
    }

    @Override
    protected void initData() {
        findViewById(R.id.toolbar_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalMethods.callFinishForBackWordActivity(mContext,true);
            }
        });

    }

    private void setDataToAdapter() {
        List<StudentLifeModel> studentLifeModels=new ArrayList<>();
        studentLifeModels.add(new StudentLifeModel(getResources().getString(R.string.dialog_title),getResources().getString(R.string.dummy_text),""));
        studentLifeModels.add(new StudentLifeModel(getResources().getString(R.string.dialog_title),getResources().getString(R.string.dummy_text),""));
        studentLifeModels.add(new StudentLifeModel(getResources().getString(R.string.dialog_title),getResources().getString(R.string.dummy_text),""));
        studentLifeModels.add(new StudentLifeModel(getResources().getString(R.string.dialog_title),getResources().getString(R.string.dummy_text),""));
        studentLifeModels.add(new StudentLifeModel(getResources().getString(R.string.dialog_title),getResources().getString(R.string.dummy_text),""));
        studentLifeModels.add(new StudentLifeModel(getResources().getString(R.string.dialog_title),getResources().getString(R.string.dummy_text),""));

        StudentLifeAdapter studentLifeAdapter=new StudentLifeAdapter(mContext, studentLifeModels, new StudentLifeAdapter.onItemSelecteListener() {
            @Override
            public void onItemSelected(StudentLifeModel studentLifeModel) {
                GlobalMethods.showDefaultFullScreenDialog(StudentLifeActivity.this,studentLifeModel.getTitle(),studentLifeModel.getImageURL(),studentLifeModel.getDescription());
            }
        });
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mContext,RecyclerView.VERTICAL,false);
        rv_student_life.setLayoutManager(linearLayoutManager);
        rv_student_life.setAdapter(studentLifeAdapter);

    }


}
