package com.technologygroup.rayannoor.yoga.Gyms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.technologygroup.rayannoor.yoga.R;

public class GymProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_profile);

        int id = getIntent().getIntExtra("id", 1);
        String Img = getIntent().getStringExtra("Img");
        int like = getIntent().getIntExtra("like",0);
        double Rate = getIntent().getDoubleExtra("Rate", 0);
    }
}
