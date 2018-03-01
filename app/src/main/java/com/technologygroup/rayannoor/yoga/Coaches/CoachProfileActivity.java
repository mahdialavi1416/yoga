package com.technologygroup.rayannoor.yoga.Coaches;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.technologygroup.rayannoor.yoga.CommentsActivity;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.RoundedImageView;

public class CoachProfileActivity extends AppCompatActivity {

    private RoundedImageView imgCoach;
    private TextView txtCoachName;
    private ImageView imgEditCoachDetails;
    private ImageView imgBack;
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
    private TextView txtCoachLevel;
    private ImageView imgLockTeachs;
    private LinearLayout lytTeachs;
    private LinearLayout lytComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_edit_profile);
        initView();

        imgEditCoachDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachProfileActivity.this, CoachEditDetialsActivity.class);
                startActivity(intent);
            }
        });

        lytCoachProfileUpgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachProfileActivity.this, CoachPlanActivity.class);
                startActivity(intent);
            }
        });


        lytComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachProfileActivity.this, CommentsActivity.class);
                startActivity(intent);
            }
        });


        lytEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachProfileActivity.this , CoachServicesActivity.class);
                startActivity(intent);
            }
        });

        lytGyms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachProfileActivity.this , CoachServicesActivity.class);
                startActivity(intent);
            }
        });

        lytResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachProfileActivity.this , CoachServicesActivity.class);
                startActivity(intent);
            }
        });


        lytCertificates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachProfileActivity.this , CoachServicesActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        imgCoach = (RoundedImageView) findViewById(R.id.imgCoach);
        txtCoachName = (TextView) findViewById(R.id.txtCoachName);
        imgBack = (ImageView) findViewById(R.id.imgBack);
        imgEditCoachDetails = (ImageView) findViewById(R.id.imgEditCoachDetails);
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
        txtCoachLevel = (TextView) findViewById(R.id.txtCoachLevel);
        imgLockTeachs = (ImageView) findViewById(R.id.imgLockTeachs);
        lytTeachs = (LinearLayout) findViewById(R.id.lytTeachs);
        lytComments = (LinearLayout) findViewById(R.id.lytComments);
    }
}
