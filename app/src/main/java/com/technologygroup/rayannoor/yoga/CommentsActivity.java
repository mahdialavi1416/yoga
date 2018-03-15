package com.technologygroup.rayannoor.yoga;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.technologygroup.rayannoor.yoga.Classes.App;
import com.technologygroup.rayannoor.yoga.Classes.ClassLevels;
import com.technologygroup.rayannoor.yoga.Coaches.CoachProfileActivity;
import com.technologygroup.rayannoor.yoga.Gyms.GymsListActivity;
import com.technologygroup.rayannoor.yoga.Models.CoachModel;
import com.technologygroup.rayannoor.yoga.Models.CommentModel;
import com.technologygroup.rayannoor.yoga.Services.WebService;
import com.technologygroup.rayannoor.yoga.adapters.GymListAdapter;
import com.technologygroup.rayannoor.yoga.adapters.commentsAdapter;

import java.util.ArrayList;
import java.util.List;

public class CommentsActivity extends AppCompatActivity {

    private RelativeLayout btnBack;
    private LinearLayout lytMain;
    private RecyclerView Recycler;
    private LinearLayout lytSubmitComment;
    private LinearLayout lytSendComments;
    private EditText edtComment;
    private LinearLayout lytDisconnect;
    private LinearLayout lytEmpty;

    List<CommentModel> commentList;

    private int idCoachOrGym;
    private boolean isGym;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        initView();

        idCoachOrGym = getIntent().getIntExtra("IdCoachOrGym", -1);
        isGym = getIntent().getBooleanExtra("IsGym", false);

        if (idCoachOrGym > 0) {

            WebServiceComment webServiceComment = new WebServiceComment();
            webServiceComment.execute();
        } else {
            Toast.makeText(this, "مربی مورد نظر یافت نشد", Toast.LENGTH_LONG).show();
            finish();
        }

    }

    private void initView() {
        btnBack = (RelativeLayout) findViewById(R.id.btnBack);
        lytMain = (LinearLayout) findViewById(R.id.lytMain);
        Recycler = (RecyclerView) findViewById(R.id.Recycler);
        lytSubmitComment = (LinearLayout) findViewById(R.id.lytSubmitComment);
        lytSendComments = (LinearLayout) findViewById(R.id.lytSendComments);
        edtComment = (EditText) findViewById(R.id.edtComment);
        lytDisconnect = (LinearLayout) findViewById(R.id.lytDisconnect);
        lytEmpty = (LinearLayout) findViewById(R.id.lytEmpty);
    }

    private void setUpRecyclerView(List<CommentModel> list) {
        commentsAdapter adapter = new commentsAdapter(CommentsActivity.this, list);
        Recycler.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(getApplicationContext());
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        Recycler.setLayoutManager(mLinearLayoutManagerVertical);
    }

    private class WebServiceComment extends AsyncTask<Object, Void, Void> {

        private WebService webService;
        Dialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            webService = new WebService();
            commentList = new ArrayList<>();


            dialog = new Dialog(CommentsActivity.this);
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

            commentList = webService.getComments(App.isInternetOn(), isGym, idCoachOrGym);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            dialog.dismiss();

            if (commentList != null) {

                if (commentList.size() > 0){

                    lytDisconnect.setVisibility(View.GONE);
                    lytEmpty.setVisibility(View.GONE);
                    lytMain.setVisibility(View.VISIBLE);

                    setUpRecyclerView(commentList);

                } else {
                    lytDisconnect.setVisibility(View.GONE);
                    lytMain.setVisibility(View.GONE);
                    lytEmpty.setVisibility(View.VISIBLE);
                }

            } else {
                lytMain.setVisibility(View.GONE);
                lytEmpty.setVisibility(View.GONE);
                lytDisconnect.setVisibility(View.VISIBLE);
            }

        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (idCoachOrGym > 0) {
            WebServiceComment webServiceComment = new WebServiceComment();
            webServiceComment.execute();
        } else {
            Toast.makeText(this, "مربی مورد نظر یافت نشد", Toast.LENGTH_LONG).show();
            finish();
        }


    }

}
