package com.technologygroup.rayannoor.yoga.Gyms;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.technologygroup.rayannoor.yoga.R;

public class GymDetailsActivity extends AppCompatActivity {

    private ImageView imgGym;
    private ImageView imgEditGymDetails;
    private ImageView imgBack;
    private TextView txtGymName;
    private TextView txtCoachLevel;
    private RatingBar rating;
    private TextView txtCoachRate;
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
    private LinearLayout lytComments;
    private RelativeLayout lytGymProfileUpgrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_details);
        initView();



        //set image darker
        imgGym.setColorFilter(Color.rgb(123, 123, 123), PorterDuff.Mode.MULTIPLY);

        //از این قسمت برای ست کردن عکس پروفایل باشگاه استفاده شود
        //set test image
        Glide.with(this).load(R.drawable.gym).into(imgGym);


        imgEditGymDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GymDetailsActivity.this , GymEditProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        imgGym = (ImageView) findViewById(R.id.imgGym);
        imgEditGymDetails = (ImageView) findViewById(R.id.imgEditGymDetails);
        imgBack = (ImageView) findViewById(R.id.imgBack);
        txtGymName = (TextView) findViewById(R.id.txtGymName);
        txtCoachLevel = (TextView) findViewById(R.id.txtCoachLevel);
        rating = (RatingBar) findViewById(R.id.rating);
        txtCoachRate = (TextView) findViewById(R.id.txtCoachRate);
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
        lytComments = (LinearLayout) findViewById(R.id.lytComments);
        lytGymProfileUpgrade = (RelativeLayout) findViewById(R.id.lytGymProfileUpgrade);
    }
}
