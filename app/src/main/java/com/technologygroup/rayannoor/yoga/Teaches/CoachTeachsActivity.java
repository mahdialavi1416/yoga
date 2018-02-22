package com.technologygroup.rayannoor.yoga.Teaches;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.technologygroup.rayannoor.yoga.Coaches.CoachListActivity;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.adapters.CoachListAdapter;
import com.technologygroup.rayannoor.yoga.adapters.TeachCoachesAdapter;

public class CoachTeachsActivity extends AppCompatActivity {

    private RelativeLayout btnBack;
    private RecyclerView Recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_teachs);
        initView();
        setUpRecyclerView();
    }

    private void initView() {
        btnBack = (RelativeLayout) findViewById(R.id.btnBack);
        Recycler = (RecyclerView) findViewById(R.id.Recycler);
    }

    private void setUpRecyclerView(){
        TeachCoachesAdapter adapter = new TeachCoachesAdapter(CoachTeachsActivity.this);
        Recycler.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(getApplicationContext());
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        Recycler.setLayoutManager(mLinearLayoutManagerVertical);
    }
}
