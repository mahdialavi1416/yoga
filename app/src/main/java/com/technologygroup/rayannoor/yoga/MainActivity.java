package com.technologygroup.rayannoor.yoga;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.technologygroup.rayannoor.yoga.Coaches.CoachListActivity;
import com.technologygroup.rayannoor.yoga.Gyms.GymsListActivity;
import com.technologygroup.rayannoor.yoga.Teaches.teachsListActivity;
import com.technologygroup.rayannoor.yoga.YogaIntroduce.YogaIntroduceActivity;

public class MainActivity extends AppCompatActivity {

    private AppBarLayout mainAppBar;
    private Toolbar toolbar;
    private CoordinatorLayout relativeMsg;
    private TextView txtNewMessageCount;
    private TextView txtTitle;
    private RelativeLayout relativeMenu;
    private LinearLayout lytTeachs;
    private LinearLayout lytYogaIntroduce;
    private LinearLayout lytGyms;
    private LinearLayout lytCoaches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        lytCoaches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CoachListActivity.class);
                startActivity(intent);
            }
        });

        lytGyms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GymsListActivity.class);
                startActivity(intent);
            }
        });

        lytTeachs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, teachsListActivity.class);
                startActivity(intent);
            }
        });

        lytYogaIntroduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, YogaIntroduceActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mainAppBar = (AppBarLayout) findViewById(R.id.mainAppBar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        relativeMsg = (CoordinatorLayout) findViewById(R.id.relative_Msg);
        txtNewMessageCount = (TextView) findViewById(R.id.txt_newMessageCount);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        relativeMenu = (RelativeLayout) findViewById(R.id.relative_Menu);
        lytTeachs = (LinearLayout) findViewById(R.id.lytTeachs);
        lytYogaIntroduce = (LinearLayout) findViewById(R.id.lytYogaIntroduce);
        lytGyms = (LinearLayout) findViewById(R.id.lytGyms);
        lytCoaches = (LinearLayout) findViewById(R.id.lytCoaches);
    }
}
