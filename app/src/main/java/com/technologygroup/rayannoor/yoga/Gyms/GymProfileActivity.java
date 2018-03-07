package com.technologygroup.rayannoor.yoga.Gyms;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.like.LikeButton;
import com.technologygroup.rayannoor.yoga.R;

public class GymProfileActivity extends AppCompatActivity {

    private ImageView gymImage;
    private TextView txtCoachName;
    private ImageView imgTelegram;
    private ImageView imgInstagram;
    private ImageView imgEmail;
    private ImageView imgCall;
    private LinearLayout lytCoachRating;
    private RatingBar RatingBarCoach;
    private TextView txtCoachRate;
    private LikeButton btnLike;
    private TextView txtLikeCount;
    private ImageView imgLockHonours;
    private LinearLayout lytGymHonours;
    private ImageView imgLockPhotos;
    private LinearLayout lytPhotos;
    private ImageView imgLockCoaches;
    private LinearLayout lytCoaches;
    private ImageView imgLockCourse;
    private LinearLayout lytCourses;
    private ImageView imgLockInfo;
    private LinearLayout lytInfo;
    private ImageView imgLockNotifs;
    private LinearLayout lytNotifs;
    private FloatingActionButton floatAction;
    private ImageView imgNavigate;
    private TextView txtAddress;
    private TextView txtGymName;
    private LinearLayout lytGymRating;
    private RatingBar RatingBarGym;
    private TextView txtGymRate;
    private RelativeLayout btnBack;
    private ImageView imgLockGyms;
    private LinearLayout lytGyms;
    private LinearLayout lytGymAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_profile);
        initView();

        //set image dark
        gymImage.setColorFilter(Color.rgb(123, 123, 123), PorterDuff.Mode.MULTIPLY);


        //set test image
        Glide.with(this).load(R.drawable.gym).into(gymImage);


        lytCoaches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GymProfileActivity.this, GymServiceActivity.class);
                startActivity(intent);
            }
        });

        lytCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GymProfileActivity.this, GymServiceActivity.class);
                startActivity(intent);
            }
        });

        lytGymHonours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GymProfileActivity.this, GymServiceActivity.class);
                startActivity(intent);
            }
        });

        lytInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GymProfileActivity.this, GymServiceActivity.class);
                startActivity(intent);
            }
        });

        lytNotifs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GymProfileActivity.this, GymServiceActivity.class);
                startActivity(intent);
            }
        });


        lytPhotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GymProfileActivity.this, GymServiceActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        gymImage = (ImageView) findViewById(R.id.gymImage);
        txtCoachName = (TextView) findViewById(R.id.txtCoachName);
        imgTelegram = (ImageView) findViewById(R.id.imgTelegram);
        imgInstagram = (ImageView) findViewById(R.id.imgInstagram);
        imgEmail = (ImageView) findViewById(R.id.imgEmail);
        imgCall = (ImageView) findViewById(R.id.imgCall);
        lytCoachRating = (LinearLayout) findViewById(R.id.lytCoachRating);
        RatingBarCoach = (RatingBar) findViewById(R.id.RatingBarCoach);
        txtCoachRate = (TextView) findViewById(R.id.txtCoachRate);
        btnLike = (LikeButton) findViewById(R.id.btnLike);
        txtLikeCount = (TextView) findViewById(R.id.txtLikeCount);
        imgLockHonours = (ImageView) findViewById(R.id.imgLockHonours);
        lytGymHonours = (LinearLayout) findViewById(R.id.lytGymHonours);
        imgLockPhotos = (ImageView) findViewById(R.id.imgLockPhotos);
        lytPhotos = (LinearLayout) findViewById(R.id.lytPhotos);
        imgLockCoaches = (ImageView) findViewById(R.id.imgLockCoaches);
        lytCoaches = (LinearLayout) findViewById(R.id.lytCoaches);
        imgLockCourse = (ImageView) findViewById(R.id.imgLockCourse);
        lytCourses = (LinearLayout) findViewById(R.id.lytCourses);
        imgLockInfo = (ImageView) findViewById(R.id.imgLockInfo);
        lytInfo = (LinearLayout) findViewById(R.id.lytInfo);
        imgLockNotifs = (ImageView) findViewById(R.id.imgLockNotifs);
        lytNotifs = (LinearLayout) findViewById(R.id.lytNotifs);
        floatAction = (FloatingActionButton) findViewById(R.id.floatAction);
        imgNavigate = (ImageView) findViewById(R.id.imgNavigate);
        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtGymName = (TextView) findViewById(R.id.txtGymName);
        lytGymRating = (LinearLayout) findViewById(R.id.lytGymRating);
        RatingBarGym = (RatingBar) findViewById(R.id.RatingBarGym);
        txtGymRate = (TextView) findViewById(R.id.txtGymRate);
        btnBack = (RelativeLayout) findViewById(R.id.btnBack);
        imgLockGyms = (ImageView) findViewById(R.id.imgLockGyms);
        lytGyms = (LinearLayout) findViewById(R.id.lytGyms);
        lytGymAddress = (LinearLayout) findViewById(R.id.lytGymAddress);

        int id = getIntent().getIntExtra("id", 1);
        String Img = getIntent().getStringExtra("Img");
        int like = getIntent().getIntExtra("like",0);
        double Rate = getIntent().getDoubleExtra("Rate", 0);
    }
}
