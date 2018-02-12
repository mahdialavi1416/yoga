package com.technologygroup.rayannoor.yoga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.technologygroup.rayannoor.yoga.Coaches.CoachListActivity;
import com.technologygroup.rayannoor.yoga.Coaches.CoachProfileActivity;

public class NavigationDrawerActivity extends AppCompatActivity {

    private LinearLayout lytLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        initView();

        lytLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NavigationDrawerActivity.this , CoachProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        lytLogin = (LinearLayout) findViewById(R.id.lytLogin);
    }
}
