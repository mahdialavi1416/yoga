package com.technologygroup.rayannoor.yoga.Coaches;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.technologygroup.rayannoor.yoga.R;

import net.cachapa.expandablelayout.ExpandableLayout;

public class CoachPlanActivity extends AppCompatActivity {

    private RelativeLayout btnBack;
    private ExpandableLayout expanableLayout1;
    private CardView card1;
    private TextView txtDetails;
    private CardView card2;
    private TextView txtDetails2;
    private ExpandableLayout expanableLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_plan);
        initView();

        txtDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expanableLayout1.isExpanded())
                    expanableLayout1.setExpanded(false);
                else
                    expanableLayout1.setExpanded(true);
            }
        });

        txtDetails2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expanableLayout2.isExpanded())
                    expanableLayout2.setExpanded(false);
                else
                    expanableLayout2.setExpanded(true);
            }
        });
    }

    private void initView() {
        btnBack = (RelativeLayout) findViewById(R.id.btnBack);
        expanableLayout1 = (ExpandableLayout) findViewById(R.id.expanableLayout1);
        card1 = (CardView) findViewById(R.id.card1);
        txtDetails = (TextView) findViewById(R.id.txtDetails);
        card2 = (CardView) findViewById(R.id.card2);
        txtDetails2 = (TextView) findViewById(R.id.txtDetails2);
        expanableLayout2 = (ExpandableLayout) findViewById(R.id.expanableLayout2);
    }
}
