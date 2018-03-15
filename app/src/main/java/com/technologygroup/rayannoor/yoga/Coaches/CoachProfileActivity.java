package com.technologygroup.rayannoor.yoga.Coaches;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.technologygroup.rayannoor.yoga.Classes.App;
import com.technologygroup.rayannoor.yoga.Classes.ClassLevels;
import com.technologygroup.rayannoor.yoga.CommentsActivity;
import com.technologygroup.rayannoor.yoga.Models.CoachModel;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.RoundedImageView;
import com.technologygroup.rayannoor.yoga.Services.WebService;

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
    private RatingBar rating;


    private SharedPreferences prefs;
    private int idCoach;
    private CoachModel coachModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_edit_profile);

        initView();

        //todo: get idCoach from shared preferences
        prefs = getSharedPreferences("MyPrefs", 0);
//        idCoach = prefs.getInt("IdCoach", -1);
        idCoach = 1;

        if (idCoach > 0) {

            WebServiceCoachInfo webServiceCoachInfo = new WebServiceCoachInfo();
            webServiceCoachInfo.execute();
        } else {
            Toast.makeText(this, "مربی مورد نظر یافت نشد", Toast.LENGTH_LONG).show();
            finish();
        }


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imgEditCoachDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CoachProfileActivity.this, CoachEditDetialsActivity.class);

                intent.putExtra("CoachId", coachModel.id);
                intent.putExtra("CoachFName", coachModel.fName);
                intent.putExtra("CoachLName", coachModel.lName);
                intent.putExtra("CoachImg", coachModel.Img);
                intent.putExtra("CoachNatCode", coachModel.natCode);
                intent.putExtra("CoachEmail", coachModel.Email);
                intent.putExtra("CoachMobile", coachModel.Mobile);
                intent.putExtra("CoachIdTelegram", coachModel.Telegram);
                intent.putExtra("CoachIdInstagram", coachModel.Instagram);

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
                Intent intent = new Intent(CoachProfileActivity.this, CoachServicesActivity.class);
                intent.putExtra("SelectedTabIndex", 0);
                startActivity(intent);
            }
        });

        lytGyms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachProfileActivity.this, CoachServicesActivity.class);
                intent.putExtra("SelectedTabIndex", 2);
                startActivity(intent);
            }
        });

        lytResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachProfileActivity.this, CoachServicesActivity.class);
                intent.putExtra("SelectedTabIndex", 1);
                startActivity(intent);
            }
        });


        lytCertificates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoachProfileActivity.this, CoachServicesActivity.class);
                intent.putExtra("SelectedTabIndex", 3);
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
        rating = (RatingBar) findViewById(R.id.rating);
    }

    private class WebServiceCoachInfo extends AsyncTask<Object, Void, Void> {

        private WebService webService;
        Dialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            webService = new WebService();
            coachModel = new CoachModel();


            dialog = new Dialog(CoachProfileActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_wait);
            ImageView logo = dialog.findViewById(R.id.logo);

            //logo 360 rotate
            ObjectAnimator rotation = ObjectAnimator.ofFloat(logo, "rotationY", 0, 360);
            rotation.setDuration(3000);
            rotation.setRepeatCount(Animation.INFINITE);
            rotation.start();

            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            dialog.show();


        }

        @Override
        protected Void doInBackground(Object... params) {

            coachModel = webService.getCoachInfo(App.isInternetOn(), idCoach);

            return null;
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            dialog.dismiss();

            if (coachModel != null) {

                if (coachModel.Img != null)
                    if (!coachModel.Img.equals("") && !coachModel.Img.equals("null"))
                        Glide.with(CoachProfileActivity.this).load(App.imgAddr + coachModel.Img).asBitmap().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imgCoach);
                txtCoachName.setText(coachModel.fName + " " + coachModel.lName);
                ClassLevels classLevels = new ClassLevels();
                txtCoachLevel.setText(classLevels.getCoachLevelName(coachModel.idCurrentPlan));
                txtCoachRate.setText(coachModel.Rate + "");
                txtLikeCount.setText(coachModel.like + "");
                rating.setRating((float) coachModel.Rate);

            } else {

                Toast.makeText(CoachProfileActivity.this, "مربی مورد نظر یافت نشد", Toast.LENGTH_LONG).show();
                finish();

            }

        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        //todo: get idCoach from shared preferences
        prefs = getSharedPreferences("MyPrefs", 0);
//        idCoach = prefs.getInt("IdCoach", -1);
        idCoach = 1;

        if (idCoach > 0) {

            WebServiceCoachInfo webServiceCoachInfo = new WebServiceCoachInfo();
            webServiceCoachInfo.execute();
        } else {
            Toast.makeText(this, "مربی مورد نظر یافت نشد", Toast.LENGTH_LONG).show();
            finish();
        }


    }
}
