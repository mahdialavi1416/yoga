package com.technologygroup.rayannoor.yoga.Gyms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.technologygroup.rayannoor.yoga.Coaches.CoachListActivity;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.adapters.CoachListAdapter;
import com.technologygroup.rayannoor.yoga.adapters.GymListAdapter;

public class GymsListActivity extends AppCompatActivity {

    private RelativeLayout btnBack;
    private RecyclerView RecyclerGyms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyms_list);
        initView();

        setUpRecyclerView();
    }

    private void setUpRecyclerView(){
        GymListAdapter adapter = new GymListAdapter(GymsListActivity.this);
        RecyclerGyms.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(getApplicationContext());
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerGyms.setLayoutManager(mLinearLayoutManagerVertical);
    }

    private void initView() {
        btnBack = (RelativeLayout) findViewById(R.id.btnBack);
        RecyclerGyms = (RecyclerView) findViewById(R.id.RecyclerGyms);
    }
}
