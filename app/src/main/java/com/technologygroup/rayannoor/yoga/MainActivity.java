package com.technologygroup.rayannoor.yoga;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.technologygroup.rayannoor.yoga.Coaches.CoachListActivity;
import com.technologygroup.rayannoor.yoga.Coaches.CoachProfileActivity;
import com.technologygroup.rayannoor.yoga.Gyms.GymsListActivity;
import com.technologygroup.rayannoor.yoga.Teaches.teachsActivity;
import com.technologygroup.rayannoor.yoga.YogaIntroduce.YogaIntroduceActivity;

public class MainActivity extends AppCompatActivity {

    private AppBarLayout mainAppBar;
    private Toolbar toolbar;
    private CoordinatorLayout relativeMsg;
    private TextView txtNewMessageCount;
    private TextView txtTitle;
    private RelativeLayout lytMenu;
    private LinearLayout lytTeachs;
    private LinearLayout lytYogaIntroduce;
    private LinearLayout lytGyms;
    private LinearLayout lytCoaches;
    private int stateNumber;
    private int cityNumber;
    private NavigationView navigationView;
    private DrawerLayout drawer_layout;
    private ImageView drawerHeaderImage;
    private TextView txtUserName;
    private RoundedImageView imgUser;
    private LinearLayout lytLogin;
    private LinearLayout lytChart;
    private LinearLayout lytAboutApp;
    private LinearLayout lytAboutUs;
    private LinearLayout lytRate;
    private View headerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


        //set image darker
        drawerHeaderImage.setColorFilter(Color.rgb(150, 150, 150), PorterDuff.Mode.MULTIPLY);
        Glide.with(this).load(R.drawable.drawer).into(drawerHeaderImage);


        try {
            stateNumber = getIntent().getIntExtra("stateNumber", 1);
            cityNumber = getIntent().getIntExtra("cityNumber", 1);
        }catch (Exception ex){ex.printStackTrace();}


        lytCoaches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CoachListActivity.class);
                intent.putExtra("stateNumber", stateNumber);
                intent.putExtra("cityNumber", cityNumber);
                startActivity(intent);
            }
        });

        lytGyms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GymsListActivity.class);
                intent.putExtra("stateNumber", stateNumber);
                intent.putExtra("cityNumber", cityNumber);
                startActivity(intent);
            }
        });

        lytTeachs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, teachsActivity.class);
                startActivity(intent);
            }
        });

        lytYogaIntroduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, YogaIntroduceActivity.class);
                startActivity(intent);
            }
        });


        lytMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawer_layout.isDrawerOpen(Gravity.RIGHT)) {
                    drawer_layout.closeDrawer(Gravity.RIGHT);
                } else {
                    drawer_layout.openDrawer(Gravity.RIGHT);
                }
            }
        });

        lytRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        lytLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CoachProfileActivity.class);
                startActivity(intent);
                drawer_layout.closeDrawer(GravityCompat.END);
            }
        });

        relativeMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, notificationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mainAppBar = (AppBarLayout) findViewById(R.id.mainAppBar);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        headerview = navigationView.getHeaderView(0);
        drawerHeaderImage = (ImageView) headerview.findViewById(R.id.drawerHeaderImage);
        imgUser = (RoundedImageView) headerview.findViewById(R.id.imgUser);
        txtUserName = (TextView) headerview.findViewById(R.id.txtUserName);
        lytLogin = (LinearLayout) headerview.findViewById(R.id.lytLogin);
        lytChart = (LinearLayout) headerview.findViewById(R.id.lytChart);
        lytAboutApp = (LinearLayout) headerview.findViewById(R.id.lytAboutApp);
        lytAboutUs = (LinearLayout) headerview.findViewById(R.id.lytAboutUs);
        lytRate = (LinearLayout) headerview.findViewById(R.id.lytRate);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        relativeMsg = (CoordinatorLayout) findViewById(R.id.relative_Msg);
        txtNewMessageCount = (TextView) findViewById(R.id.txt_newMessageCount);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        lytMenu = (RelativeLayout) findViewById(R.id.lytMenu);
        lytTeachs = (LinearLayout) findViewById(R.id.lytTeachs);
        lytYogaIntroduce = (LinearLayout) findViewById(R.id.lytYogaIntroduce);
        lytGyms = (LinearLayout) findViewById(R.id.lytGyms);
        lytCoaches = (LinearLayout) findViewById(R.id.lytCoaches);
    }

    @Override
    public void onBackPressed() {
       if (drawer_layout.isDrawerOpen(GravityCompat.END)) {
            drawer_layout.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

}
