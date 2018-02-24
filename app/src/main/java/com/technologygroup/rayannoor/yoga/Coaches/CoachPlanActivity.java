package com.technologygroup.rayannoor.yoga.Coaches;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.RelativeLayout;

import com.technologygroup.rayannoor.yoga.R;

import net.cachapa.expandablelayout.ExpandableLayout;

public class CoachPlanActivity extends AppCompatActivity {

    private RelativeLayout btnBack;
    private ExpandableLayout expanableLayout1;
    private CardView card1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_plan);
        initView();

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expanableLayout1.isExpanded())
                    expanableLayout1.setExpanded(false);
                else
                    expanableLayout1.setExpanded(true);
            }
        });
    }

    private void initView() {
        btnBack = (RelativeLayout) findViewById(R.id.btnBack);
        expanableLayout1 = (ExpandableLayout) findViewById(R.id.expanableLayout1);
        card1 = (CardView) findViewById(R.id.card1);
    }
}
