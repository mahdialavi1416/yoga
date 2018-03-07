package com.technologygroup.rayannoor.yoga.Coaches;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.like.LikeButton;
import com.technologygroup.rayannoor.yoga.CommentsActivity;
import com.technologygroup.rayannoor.yoga.Models.CoachModel;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.RoundedImageView;

public class CoachDetailsActivity extends AppCompatActivity {


    private RoundedImageView imgCoach;
    private TextView txtCoachName;
    private TextView txtCoachCity;
    private ImageView imgTelegram;
    private ImageView imgInstagram;
    private ImageView imgEmail;
    private ImageView imgCall;
    private LinearLayout lytCoachRating;
    private RatingBar RatingBarCoach;
    private TextView txtCoachRate;
    private LikeButton btnLike;
    private TextView txtLikeCount;
    private ImageView imgLockEducation;
    private LinearLayout lytEducation;
    private ImageView imgLockResume;
    private LinearLayout lytResume;
    private ImageView imgLockGyms;
    private LinearLayout lytGyms;
    private ImageView imgLockCertificates;
    private LinearLayout lytCertificates;
    private FloatingActionButton floatAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_profile);
        CoachModel coachModel = initView();

        txtCoachName.setText(coachModel.fName + " " + coachModel.lName);
        txtLikeCount.setText(coachModel.like + "");
        txtCoachRate.setText(coachModel.Rate + "");
        RatingBarCoach.setRating((float)coachModel.Rate);


        lytGyms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachDetailsActivity.this , CoachServicesActivity.class);
                startActivity(intent);
            }
        });

        lytCertificates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachDetailsActivity.this , CoachServicesActivity.class);
                startActivity(intent);
            }
        });

        lytEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachDetailsActivity.this , CoachServicesActivity.class);
                startActivity(intent);
            }
        });

        lytResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachDetailsActivity.this , CoachServicesActivity.class);
                startActivity(intent);
            }
        });


        floatAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachDetailsActivity.this , CommentsActivity.class);
                startActivity(intent);
            }
        });
    }

    private CoachModel initView() {
        CoachModel coachModel = new CoachModel();
        coachModel.fName = getIntent().getStringExtra("fName");
        coachModel.Email = getIntent().getStringExtra("Email");
        coachModel.Instagram = getIntent().getStringExtra("Instagram");
        coachModel.lName = getIntent().getStringExtra("lName");
        coachModel.Telegram = getIntent().getStringExtra("Telegram");
        coachModel.Img = getIntent().getStringExtra("Img");
        coachModel.id = getIntent().getIntExtra("id", 1);
        coachModel.idCity = getIntent().getIntExtra("idCity", 1);
//        getIntent().getIntExtra("idState", 1);
        coachModel.idCurrentPlan = getIntent().getIntExtra("idCurrentPlan", 1);
        coachModel.like = getIntent().getIntExtra("like", 0);
        coachModel.lastUpdate = getIntent().getStringExtra("lastUpdate");
        coachModel.Mobile = getIntent().getStringExtra("Mobile");
        coachModel.natCode = getIntent().getStringExtra("natCode");
        coachModel.Rate = getIntent().getDoubleExtra("Rate", 0);




        imgCoach = (RoundedImageView) findViewById(R.id.imgCoach);

        txtCoachName = (TextView) findViewById(R.id.txtCoachName);


        txtCoachCity = (TextView) findViewById(R.id.txtCoachCity);
        imgTelegram = (ImageView) findViewById(R.id.imgTelegram);


        imgInstagram = (ImageView) findViewById(R.id.imgInstagram);
        imgEmail = (ImageView) findViewById(R.id.imgEmail);
        imgCall = (ImageView) findViewById(R.id.imgCall);
        lytCoachRating = (LinearLayout) findViewById(R.id.lytCoachRating);
        RatingBarCoach = (RatingBar) findViewById(R.id.RatingBarCoach);
        RatingBarCoach.setRating((float)coachModel.Rate);

        txtCoachRate = (TextView) findViewById(R.id.txtCoachRate);
//        txtCoachRate.setText(coachModel.Rate + "");

        btnLike = (LikeButton) findViewById(R.id.btnLike);
        txtLikeCount = (TextView) findViewById(R.id.txtLikeCount);
//        txtLikeCount.setText(coachModel.like);

        imgLockEducation = (ImageView) findViewById(R.id.imgLockEducation);
        lytEducation = (LinearLayout) findViewById(R.id.lytEducation);
        imgLockResume = (ImageView) findViewById(R.id.imgLockResume);
        lytResume = (LinearLayout) findViewById(R.id.lytResume);
        imgLockGyms = (ImageView) findViewById(R.id.imgLockGyms);
        lytGyms = (LinearLayout) findViewById(R.id.lytGyms);
        imgLockCertificates = (ImageView) findViewById(R.id.imgLockCertificates);
        lytCertificates = (LinearLayout) findViewById(R.id.lytCertificates);
        floatAction = (FloatingActionButton) findViewById(R.id.floatAction);

        return coachModel;
    }
}

