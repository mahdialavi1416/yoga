package com.technologygroup.rayannoor.yoga.YogaIntroduce;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.technologygroup.rayannoor.yoga.R;

public class IntroDetailsActivity extends AppCompatActivity {

    private ImageView btnBack;
    private TextView txtTitle;
    private TextView txtBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_details);
        initView();
    }

    private void initView() {
        btnBack = (ImageView) findViewById(R.id.btnBack);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtBody = (TextView) findViewById(R.id.txtBody);
    }
}
