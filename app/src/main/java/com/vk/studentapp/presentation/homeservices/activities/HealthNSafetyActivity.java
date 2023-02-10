package com.vk.studentapp.presentation.homeservices.activities;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vk.studentapp.R;
import com.vk.studentapp.adapters.HealthSafetyAdapter;
import com.vk.studentapp.models.HealthSafetyModel;
import com.vk.studentapp.presentation.BaseActivity;
import com.vk.studentapp.util.GlobalMethods;

import java.util.ArrayList;
import java.util.List;

public class HealthNSafetyActivity extends BaseActivity {

    private List<HealthSafetyModel> healthSafetyList;

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_health_safety;
    }

    private AppCompatTextView heading_text;
    @Override
    protected void initGUI(Bundle savedInstanceState) {
        RecyclerView rv_health_safety = findViewById(R.id.rv_health_safety);
        rv_health_safety.setLayoutManager(new LinearLayoutManager(this));
        heading_text = findViewById(R.id.heading_text);
        heading_text.setText(R.string.health_safety_measure);


        healthSafetyList = new ArrayList<>();
        healthSafetyList.add(new HealthSafetyModel("10 Tips for Staying Safe in the Era of COVID-19",
                getResources().getString(R.string.dummy_text),
                "xVu_I6WCsto", "https://www.youtube.com/watch?v=xVu_I6WCsto",
                "https://i.ytimg.com/an_webp/xVu_I6WCsto/mqdefault_6s.webp?du=3000&sqp=CL6C_4QG&rs=AOn4CLAayUC1_7HIrSrnMqJN3UT-K5NTsg"));

        healthSafetyList.add(new HealthSafetyModel("10 Tips for Staying Safe in the Era of COVID-19",
                getResources().getString(R.string.dummy_text),
                "xVu_I6WCsto", "https://www.youtube.com/watch?v=xVu_I6WCsto",
                "https://i.ytimg.com/vi/xVu_I6WCsto/hq720.jpg"));


        healthSafetyList.add(new HealthSafetyModel("COVID-19 Health and Safety measures on campus",
                getResources().getString(R.string.dummy_text),
                "obJPsCeY4E8", "https://www.youtube.com/watch?v=obJPsCeY4E8",
                "https://i.ytimg.com/vi/obJPsCeY4E8/maxresdefault.jpg"));

        healthSafetyList.add(new HealthSafetyModel("Covid-19 Health & Safety Protocol",
                getResources().getString(R.string.dummy_text),
                "Dpe8aoMtfXU", "https://www.youtube.com/watch?v=Dpe8aoMtfXU",
                "https://i.ytimg.com/vi/Dpe8aoMtfXU/hqdefault.jpg"));


        HealthSafetyAdapter healthSafetyAdapter = new HealthSafetyAdapter(this, healthSafetyList, new HealthSafetyAdapter.onItemClickListener() {
            @Override
            public void itemSelected(HealthSafetyModel healthSafetyModel) {

                Bundle b = new Bundle();
                b.putString("youtube_id", healthSafetyModel.getYoutube_id());
                GlobalMethods.callForWordActivity(HealthNSafetyActivity.this, VideosPlayActivity.class, b, false, true);
            }
        });
        rv_health_safety.setAdapter(healthSafetyAdapter);
    }

    @Override
    protected void initData() {

    }
}
