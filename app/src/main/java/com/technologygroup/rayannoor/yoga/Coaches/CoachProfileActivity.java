package com.technologygroup.rayannoor.yoga.Coaches;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.RoundedImageView;

public class CoachProfileActivity extends AppCompatActivity {

    private RoundedImageView imgCoach;
    private TextView txtCoachName;
    private LinearLayout lytEditCoachDetails;
    private TextView txtCoachRate;
    private TextView txtLikeCount;
    private ImageView imgLockEducation;
    private LinearLayout lytEducation;
    private ImageView imgLockResume;
    private LinearLayout lytResume;
    private ImageView imgLockGyms;
    private LinearLayout lytGyms;
    private ImageView imgLockCertificates;
    private LinearLayout lytCertificates;
    private RelativeLayout lytCoachProfileUpgrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_edit_profile);
        initView();

        lytEditCoachDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachProfileActivity.this , CoachEditDetialsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        imgCoach = (RoundedImageView) findViewById(R.id.imgCoach);
        txtCoachName = (TextView) findViewById(R.id.txtCoachName);
        lytEditCoachDetails = (LinearLayout) findViewById(R.id.lytEditCoachDetails);
        txtCoachRate = (TextView) findViewById(R.id.txtCoachRate);
        txtLikeCount = (TextView) findViewById(R.id.txtLikeCount);
        imgLockEducation = (ImageView) findViewById(R.id.imgLockEducation);
        lytEducation = (LinearLayout) findViewById(R.id.lytEducation);
        imgLockResume = (ImageView) findViewById(R.id.imgLockResume);
        lytResume = (LinearLayout) findViewById(R.id.lytResume);
        imgLockGyms = (ImageView) findViewById(R.id.imgLockGyms);
        lytGyms = (LinearLayout) findViewById(R.id.lytGyms);
        imgLockCertificates = (ImageView) findViewById(R.id.imgLockCertificates);
        lytCertificates = (LinearLayout) findViewById(R.id.lytCertificates);
        lytCoachProfileUpgrade = (RelativeLayout) findViewById(R.id.lytCoachProfileUpgrade);
    }
}
