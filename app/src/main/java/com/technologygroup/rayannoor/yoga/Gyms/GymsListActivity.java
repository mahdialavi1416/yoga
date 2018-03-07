package com.technologygroup.rayannoor.yoga.Gyms;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.technologygroup.rayannoor.yoga.Classes.App;
import com.technologygroup.rayannoor.yoga.Coaches.CoachListActivity;
import com.technologygroup.rayannoor.yoga.Models.CoachGymsModel;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.Services.WebService;
import com.technologygroup.rayannoor.yoga.adapters.CoachListAdapter;
import com.technologygroup.rayannoor.yoga.adapters.GymListAdapter;

public class GymsListActivity extends AppCompatActivity {

    private RelativeLayout btnBack;
    private ShimmerRecyclerView RecyclerGyms;
    private CoachGymsModel[] gymModel;
    private int stateNumber = 1;
    private int cityNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyms_list);
        initView();

        fetchDataGymsList fetchDataGymsList = new fetchDataGymsList();
        fetchDataGymsList.execute();

//        setUpRecyclerView();
    }

   private void setUpRecyclerView(){
        GymListAdapter adapter = new GymListAdapter(GymsListActivity.this, gymModel);
        RecyclerGyms.setAdapter(adapter);
    }

    private void initView() {
        btnBack = (RelativeLayout) findViewById(R.id.btnBack);
        RecyclerGyms = (ShimmerRecyclerView) findViewById(R.id.RecyclerGyms);

        stateNumber = getIntent().getIntExtra("stateNumber", 1);
        cityNumber = getIntent().getIntExtra("cityNumber", 1);
    }


    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    public class fetchDataGymsList extends AsyncTask<Object, Void, Void> {
        private WebService webService;

        @Override
        protected void onPreExecute() {
            webService = new WebService();
            super.onPreExecute();
            RecyclerGyms.showShimmerAdapter();
        }

        @Override
        protected Void doInBackground(Object... params) {
            gymModel = webService.getGyms(App.isInternetOn());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            RecyclerGyms.clearAnimation();

            if (gymModel != null) {

               Toast.makeText(getApplicationContext(), gymModel[0].id +"", Toast.LENGTH_LONG).show();

                RecyclerGyms = findViewById(R.id.RecyclerGyms);
                LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(getApplicationContext());
                mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
                RecyclerGyms.setLayoutManager(mLinearLayoutManagerVertical);

                setUpRecyclerView();

//                if (coachModel.Img != null)
//                    if (!coachModel.Img.equals("") && !coachModel.Img.equals("null"))
//                        //Glide.with(CoachProfileActivity.this).load(App.imgAddr + coachModel.Img).asBitmap().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imgCoach);
////                txtCoachName.setText(coachModel.fName + " " + coachModel.lName);
////                ClassLevels classLevels = new ClassLevels();
////                txtCoachLevel.setText(classLevels.getCoachLevelName(coachModel.idCurrentPlan));
////                txtCoachRate.setText(coachModel.Rate + "");
////                txtLikeCount.setText(coachModel.like + "");
////                rating.setRating((float) coachModel.Rate);
//
            } else {
            }

        }

    }

}
