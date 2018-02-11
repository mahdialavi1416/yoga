package com.technologygroup.rayannoor.yoga.Coaches;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.adapters.CoachListAdapter;

public class CoachListActivity extends AppCompatActivity {

    private TextView txtTitle;
    private RelativeLayout btnBack;
    private RecyclerView RecyclerCoach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_list);
        initView();

        setUpRecyclerView();
    }

    private void setUpRecyclerView(){
        CoachListAdapter adapter = new CoachListAdapter(CoachListActivity.this);
        RecyclerCoach.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(getApplicationContext());
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerCoach.setLayoutManager(mLinearLayoutManagerVertical);
    }

    private void initView() {
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        btnBack = (RelativeLayout) findViewById(R.id.btnBack);
        RecyclerCoach = (RecyclerView) findViewById(R.id.RecyclerCoach);
    }
}
