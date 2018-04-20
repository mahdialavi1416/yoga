package com.technologygroup.rayannoor.yoga;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.technologygroup.rayannoor.yoga.Coaches.CoachListActivity;
import com.technologygroup.rayannoor.yoga.Coaches.CoachProfileActivity;
import com.technologygroup.rayannoor.yoga.Gyms.GymDetailsActivity;
import com.technologygroup.rayannoor.yoga.Gyms.GymsListActivity;
import com.technologygroup.rayannoor.yoga.Services.fetchDataCity;
import com.technologygroup.rayannoor.yoga.Services.fetchDataState;
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
    private SharedPreferences prefs;
    public static Dialog dialog;

    public static TextView textView;
    public static TextView textView2;
    public static Spinner StateSpinner;
    public static Spinner CitySpinner;
    private int stateNumber = 1;
    private int cityNumber = 1;
    ArrayAdapter<String> spinnerArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences("MyPrefs", 0);

        if (prefs.getBoolean("isFirstRun", true)) {
            showStateDialog();
        }
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("isFirstRun", false);
        editor.apply();


        initView();


        //set image darker
        drawerHeaderImage.setColorFilter(Color.rgb(150, 150, 150), PorterDuff.Mode.MULTIPLY);
        Glide.with(this).load(R.drawable.drawer).into(drawerHeaderImage);


        lytCoaches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CoachListActivity.class);
                startActivity(intent);
            }
        });

        lytGyms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GymsListActivity.class);
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
                intent.putExtra("tab_number", 0);
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

    private void showStateDialog() {
        dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_state_city);

        CitySpinner = (Spinner) dialog.findViewById(R.id.CitySpinner);
        final Button btnSendStateCity = (Button) dialog.findViewById(R.id.btnSendState_city);
        btnSendStateCity.setEnabled(false);
        btnSendStateCity.setAlpha(0.25f);

        StateSpinner = dialog.findViewById(R.id.StateSpinner);
        fetchDataState url_read_process = new fetchDataState();
        url_read_process.execute();//change the province to the expected value

        textView = dialog.findViewById(R.id.use_province_help);


        //Toast.makeText(dialog.getContext(), "salaam", Toast.LENGTH_LONG).show();


        StateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//               Toast.makeText(dialog.getContext(), (position+1) + "", Toast.LENGTH_LONG).show();

                stateNumber = position + 1;
                //get the city information
                fetchDataCity fetchDataCity = new fetchDataCity(stateNumber);
                fetchDataCity.execute();
                btnSendStateCity.setEnabled(true);
                btnSendStateCity.setAlpha(1.0f);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnSendStateCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cityNumber > 0 && stateNumber > 0) {

                    prefs = getSharedPreferences("MyPrefs", 0);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("stateNumber", stateNumber);
                    editor.putInt("cityNumber", cityNumber);
                    editor.apply();

                    dialog.dismiss();

                }

            }
        });

        dialog.show();
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
