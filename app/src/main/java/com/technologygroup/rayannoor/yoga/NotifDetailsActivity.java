package com.technologygroup.rayannoor.yoga;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class NotifDetailsActivity extends AppCompatActivity {

    private ImageView imgShare;
    private ImageView imgBack;
    private TextView txtNotifDate;
    private TextView txtNotifSender;
    private TextView txtNotifTitle;
    private ImageView imgNotifDetails;
    private TextView txtNotifBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif_details);
        initView();
    }

    private void initView() {
        imgShare = (ImageView) findViewById(R.id.imgShare);
        imgBack = (ImageView) findViewById(R.id.imgBack);
        txtNotifDate = (TextView) findViewById(R.id.txtNotifDate);
        txtNotifSender = (TextView) findViewById(R.id.txtNotifSender);
        txtNotifTitle = (TextView) findViewById(R.id.txtNotifTitle);
        imgNotifDetails = (ImageView) findViewById(R.id.imgNotifDetails);
        txtNotifBody = (TextView) findViewById(R.id.txtNotifBody);
    }
}
