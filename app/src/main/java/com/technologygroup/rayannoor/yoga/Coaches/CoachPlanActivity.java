package com.technologygroup.rayannoor.yoga.Coaches;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.technologygroup.rayannoor.yoga.Classes.App;
import com.technologygroup.rayannoor.yoga.Classes.ClassLevels;
import com.technologygroup.rayannoor.yoga.Models.CoachModel;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.Services.WebService;
import com.technologygroup.rayannoor.yoga.WebActivity;

import net.cachapa.expandablelayout.ExpandableLayout;

public class CoachPlanActivity extends AppCompatActivity {

    private RelativeLayout btnBack;
    private ExpandableLayout expanableLayout1;
    private CardView card1;
    private TextView txtDetails;
    private CardView card2;
    private TextView txtDetails2;
    private ExpandableLayout expanableLayout2;
    TextView txtBuy;
    String result;
    private int idCoach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_plan);
        initView();

        idCoach = getIntent().getIntExtra("idCoach", idCoach);

        txtDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expanableLayout1.isExpanded())
                    expanableLayout1.setExpanded(false);
                else
                    expanableLayout1.setExpanded(true);
            }
        });

        txtDetails2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expanableLayout2.isExpanded())
                    expanableLayout2.setExpanded(false);
                else
                    expanableLayout2.setExpanded(true);
            }
        });

        txtBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WebServicePlan webServicePlan = new WebServicePlan();
                webServicePlan.execute();

            }
        });

    }

    private void initView() {

        txtBuy = findViewById(R.id.txtBuy);
        btnBack = (RelativeLayout) findViewById(R.id.btnBack);
        expanableLayout1 = (ExpandableLayout) findViewById(R.id.expanableLayout1);
        card1 = (CardView) findViewById(R.id.card1);
        txtDetails = (TextView) findViewById(R.id.txtDetails);
        card2 = (CardView) findViewById(R.id.card2);
        txtDetails2 = (TextView) findViewById(R.id.txtDetails2);
        expanableLayout2 = (ExpandableLayout) findViewById(R.id.expanableLayout2);
    }


    private class WebServicePlan extends AsyncTask<Object, Void, Void> {

        private WebService webService;
        Dialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            webService = new WebService();

            dialog = new Dialog(CoachPlanActivity.this);
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

            result = webService.postPlanId(App.isInternetOn(), 1, idCoach);

            return null;
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            dialog.dismiss();

            if (result != null) {

                if (!result.startsWith("https://www.zarinpal.com/pg/")) {

                    if (Integer.parseInt(result) == -1) {
                        Toast.makeText(CoachPlanActivity.this, "خطای پایگاه داده", Toast.LENGTH_LONG).show();

                    } else if (Integer.parseInt(result) == -2) {
                        Toast.makeText(CoachPlanActivity.this, "ارتباط با درگاه برقرار نشد", Toast.LENGTH_LONG).show();
                    } else if (Integer.parseInt(result) == -3) {
                        Toast.makeText(CoachPlanActivity.this, "عدم وجود کاربر یا طرح موردنظر", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(CoachPlanActivity.this, "ناموفق", Toast.LENGTH_LONG).show();

                    }

                } else {

//                    Toast.makeText(CoachPlanActivity.this, "موفق", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(CoachPlanActivity.this, WebActivity.class);
                    intent.putExtra("payUrl", result);
                    startActivity(intent);


                }
            } else {

                Toast.makeText(CoachPlanActivity.this, "ارتباط با سرور برقرار نشد", Toast.LENGTH_LONG).show();

            }

        }

    }

}
