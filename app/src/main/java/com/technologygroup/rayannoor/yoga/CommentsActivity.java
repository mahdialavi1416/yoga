package com.technologygroup.rayannoor.yoga;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.technologygroup.rayannoor.yoga.Gyms.GymsListActivity;
import com.technologygroup.rayannoor.yoga.Models.CoachModel;
import com.technologygroup.rayannoor.yoga.adapters.GymListAdapter;
import com.technologygroup.rayannoor.yoga.adapters.commentsAdapter;

public class CommentsActivity extends AppCompatActivity {

    private RelativeLayout btnBack;
    private LinearLayout lytMain;
    private RecyclerView Recycler;
    private LinearLayout lytSubmitComment;
    private LinearLayout lytSendComments;
    private EditText edtComment;
    private LinearLayout lytDisconnect;
    private LinearLayout lytEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        initView();
        setUpRecyclerView();
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

    private void setUpRecyclerView(){
        commentsAdapter adapter = new commentsAdapter(CommentsActivity.this);
        Recycler.setAdapter(adapter);
        
        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(getApplicationContext());
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        Recycler.setLayoutManager(mLinearLayoutManagerVertical);
    }
}
