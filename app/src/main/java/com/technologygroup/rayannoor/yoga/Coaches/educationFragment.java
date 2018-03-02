package com.technologygroup.rayannoor.yoga.Coaches;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.technologygroup.rayannoor.yoga.Classes.App;
import com.technologygroup.rayannoor.yoga.Models.CoachEduModel;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.Services.WebService;
import com.technologygroup.rayannoor.yoga.adapters.CoachCertificateAdapter;
import com.technologygroup.rayannoor.yoga.adapters.CoachEducationAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class educationFragment extends Fragment {


    private RecyclerView Recycler;
    private FloatingActionButton floatAction;
    private Dialog dialog;

    private SharedPreferences prefs;
    private int idCoach;

    List<CoachEduModel> list;

    public educationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_education, container, false);
        Recycler = view.findViewById(R.id.Recycler);
        floatAction = view.findViewById(R.id.floatAction);

        //todo: get idCoach from shared preferences
        prefs = getContext().getSharedPreferences("MyPrefs", 0);
//        idCoach = prefs.getInt("IdCoach", -1);
        idCoach = 1;

        if (idCoach > 0) {

            WebServiceCoachInfo webServiceCoachInfo = new WebServiceCoachInfo();
            webServiceCoachInfo.execute();
        } else {
            Toast.makeText(getContext(), "مربی مورد نظر یافت نشد", Toast.LENGTH_LONG).show();
        }


        floatAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        //setUpRecyclerView();
        return view;
    }

    private void setUpRecyclerView(List<CoachEduModel> list){
        CoachEducationAdapter adapter = new CoachEducationAdapter(getActivity(), list);
        Recycler.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(getContext());
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        Recycler.setLayoutManager(mLinearLayoutManagerVertical);
    }

    private void showDialog() {
        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add_education);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }


    private class WebServiceCoachInfo extends AsyncTask<Object, Void, Void> {

        private WebService webService;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            webService = new WebService();
            list = new ArrayList<>();

        }

        @Override
        protected Void doInBackground(Object... params) {

            list = webService.getCoachEdu(App.isInternetOn(), idCoach);

            return null;
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            if (list != null) {

                if (list.size() > 0){

                    setUpRecyclerView(list);

                } else {

                }

            } else {
                //Toast.makeText(getApplicationContext(), "اتصال با سرور برقرار نشد", Toast.LENGTH_LONG).show();

//                lytMain.setVisibility(View.GONE);
//                lytDisconnect.setVisibility(View.VISIBLE);
//                lytEmpty.setVisibility(View.GONE);

            }

        }

    }

}
