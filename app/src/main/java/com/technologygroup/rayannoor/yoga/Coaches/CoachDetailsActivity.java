package com.technologygroup.rayannoor.yoga.Coaches;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.like.LikeButton;
import com.technologygroup.rayannoor.yoga.Classes.App;
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
    private ImageView lytBack;
    private LinearLayout lytResume;
    private ImageView imgLockGyms;
    private LinearLayout lytGyms;
    private ImageView imgLockCertificates;
    private LinearLayout lytCertificates;
    private FloatingActionButton floatAction;

    CoachModel coachModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_profile);

        initView();
        getInfo();
        setViews();



        lytEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachDetailsActivity.this, CoachServicesActivity.class);
                intent.putExtra("calledFromPanel", false);
                intent.putExtra("SelectedTabIndex", 0);
                intent.putExtra("idCoach", coachModel.id);
                startActivity(intent);
            }
        });

        lytResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachDetailsActivity.this, CoachServicesActivity.class);
                intent.putExtra("calledFromPanel", false);
                intent.putExtra("SelectedTabIndex", 1);
                intent.putExtra("idCoach", coachModel.id);
                startActivity(intent);
            }
        });

        lytGyms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachDetailsActivity.this, CoachServicesActivity.class);
                intent.putExtra("calledFromPanel", false);
                intent.putExtra("SelectedTabIndex", 2);
                intent.putExtra("idCoach", coachModel.id);
                startActivity(intent);
            }
        });

        lytCertificates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachDetailsActivity.this, CoachServicesActivity.class);
                intent.putExtra("calledFromPanel", false);
                intent.putExtra("SelectedTabIndex", 3);
                intent.putExtra("idCoach", coachModel.id);
                startActivity(intent);
            }
        });


        floatAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachDetailsActivity.this, CommentsActivity.class);
                intent.putExtra("IdCoachOrGym", coachModel.id);
                intent.putExtra("IsGym", false);
                startActivity(intent);
            }
        });


        imgTelegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (coachModel.Telegram != null) {
                    if (!coachModel.Telegram.equals("") && !coachModel.Telegram.equals("null")) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://telegram.me/" + coachModel.Telegram));
                        startActivity(intent);
                    } else {
                        Toast.makeText(CoachDetailsActivity.this, "آی دی تلگرام موجود نیست", Toast.LENGTH_LONG).show();
                    }
                } else
                    Toast.makeText(CoachDetailsActivity.this, "آی دی تلگرام موجود نیست", Toast.LENGTH_LONG).show();

            }
        });

        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (coachModel.Mobile != null) {
                    if (!coachModel.Mobile.equals("") && !coachModel.Mobile.equals("null")) {
                        Intent intentCall = new Intent(Intent.ACTION_DIAL);
                        intentCall.setData(Uri.fromParts("tel", "0" + coachModel.Mobile, null));
                        startActivity(intentCall);
                    } else {
                        Toast.makeText(CoachDetailsActivity.this, "شماره تلفن موجود نیست", Toast.LENGTH_LONG).show();
                    }
                } else
                    Toast.makeText(CoachDetailsActivity.this, "شماره تلفن موجود نیست", Toast.LENGTH_LONG).show();
            }
        });

        imgEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (coachModel.Email != null) {
                    if (!coachModel.Email.equals("") && !coachModel.Email.equals("null")) {

                        Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_SUBJECT, "نرم افزار یوگا");
//                        intent.putExtra(Intent.EXTRA_TEXT, txtEmailBody.getText().toString());
                        intent.setData(Uri.parse("mailto:" + coachModel.Email)); // or just "mailto:" for blank
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                        try {
                            startActivity(Intent.createChooser(intent, "ارسال ایمیل از طریق"));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(getApplicationContext(), "در دستگاه شما هیچ برنامه ای برای ارسال ایمیل وجود ندارد", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(CoachDetailsActivity.this, "ایمیل موجود نیست", Toast.LENGTH_LONG).show();
                    }
                } else
                    Toast.makeText(CoachDetailsActivity.this, "ایمیل موجود نیست", Toast.LENGTH_LONG).show();

            }
        });

        imgInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (coachModel.Instagram != null) {
                    if (!coachModel.Instagram.equals("") && !coachModel.Instagram.equals("null")) {

                        Uri uri = Uri.parse("http://instagram.com/_u/" + coachModel.Instagram);
                        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                        likeIng.setPackage("com.instagram.android");

                        try {
                            startActivity(likeIng);
                        } catch (ActivityNotFoundException e) {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("http://instagram.com/" + coachModel.Instagram)));
                        }

                    } else {
                        Toast.makeText(CoachDetailsActivity.this, "شماره تلفن موجود نیست", Toast.LENGTH_LONG).show();
                    }
                } else
                    Toast.makeText(CoachDetailsActivity.this, "شماره تلفن موجود نیست", Toast.LENGTH_LONG).show();

            }
        });

    }

    private void initView() {

        imgCoach = (RoundedImageView) findViewById(R.id.imgCoach);
        txtCoachName = (TextView) findViewById(R.id.txtCoachName);
        txtCoachCity = (TextView) findViewById(R.id.txtCoachCity);
        imgTelegram = (ImageView) findViewById(R.id.imgTelegram);
        imgInstagram = (ImageView) findViewById(R.id.imgInstagram);
        lytBack = (ImageView) findViewById(R.id.lytBack);
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
        floatAction = (FloatingActionButton) findViewById(R.id.floatAction);

    }

    public void getInfo() {

        coachModel = new CoachModel();
        coachModel.fName = getIntent().getStringExtra("fName");
        coachModel.Email = getIntent().getStringExtra("Email");
        coachModel.Instagram = getIntent().getStringExtra("Instagram");
        coachModel.lName = getIntent().getStringExtra("lName");
        coachModel.Telegram = getIntent().getStringExtra("Telegram");
        coachModel.Img = getIntent().getStringExtra("Img");
        coachModel.id = getIntent().getIntExtra("id", -1);
        coachModel.idCity = getIntent().getIntExtra("idCity", -1);
//        getIntent().getIntExtra("idState", 1);
        coachModel.idCurrentPlan = getIntent().getIntExtra("idCurrentPlan", -1);
        coachModel.like = getIntent().getIntExtra("like", 0);
        coachModel.lastUpdate = getIntent().getStringExtra("lastUpdate");
        coachModel.Mobile = getIntent().getStringExtra("Mobile");
        coachModel.natCode = getIntent().getStringExtra("natCode");
        coachModel.Rate = getIntent().getDoubleExtra("Rate", 0);
        coachModel.City = getIntent().getStringExtra("City");
        coachModel.State = getIntent().getStringExtra("State");


    }

    private void setViews() {

        if (coachModel.Img != null)
            if (!coachModel.Img.equals("") && !coachModel.Img.equals("null"))
                Glide.with(CoachDetailsActivity.this).load(App.imgAddr + coachModel.Img).asBitmap().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imgCoach);


        txtCoachName.setText(coachModel.fName + " " + coachModel.lName);
        txtLikeCount.setText(coachModel.like + "");
        txtCoachCity.setText(coachModel.State + "\n" + coachModel.City);
        txtCoachRate.setText((float) coachModel.Rate + "");
        RatingBarCoach.setRating((float) coachModel.Rate);

    }
}

