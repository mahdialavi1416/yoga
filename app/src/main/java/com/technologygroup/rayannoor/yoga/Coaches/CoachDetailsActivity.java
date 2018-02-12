package com.technologygroup.rayannoor.yoga.Coaches;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.like.LikeButton;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_profile);
        initView();

        lytGyms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachDetailsActivity.this , CoachServicesActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        imgCoach = (RoundedImageView) findViewById(R.id.imgCoach);
        txtCoachName = (TextView) findViewById(R.id.txtCoachName);
        txtCoachCity = (TextView) findViewById(R.id.txtCoachCity);
        imgTelegram = (ImageView) findViewById(R.id.imgTelegram);
        imgInstagram = (ImageView) findViewById(R.id.imgInstagram);
        imgEmail = (ImageView) findViewById(R.id.imgEmail);
        imgCall = (ImageView) findViewById(R.id.imgCall);
        lytCoachRating = (LinearLayout) findViewById(R.id.lytCoachRating);
        RatingBarCoach = (RatingBar) findViewById(R.id.RatingBarCoach);
        txtCoachRate = (TextView) findViewById(R.id.txtCoachRate);
        btnLike = (LikeButton) findViewById(R.id.btnLike);
        txtLikeCount = (TextView) findViewById(R.id.txtLikeCount);
        imgLockEducation = (ImageView) findViewById(R.id.imgLockEducation);
        lytEducation = (LinearLayout) findViewById(R.id.lytEducation);
        imgLockResume = (ImageView) findViewById(R.id.imgLockResume);
        lytResume = (LinearLayout) findViewById(R.id.lytResume);
        imgLockGyms = (ImageView) findViewById(R.id.imgLockGyms);
        lytGyms = (LinearLayout) findViewById(R.id.lytGyms);
        imgLockCertificates = (ImageView) findViewById(R.id.imgLockCertificates);
        lytCertificates = (LinearLayout) findViewById(R.id.lytCertificates);
    }
}

