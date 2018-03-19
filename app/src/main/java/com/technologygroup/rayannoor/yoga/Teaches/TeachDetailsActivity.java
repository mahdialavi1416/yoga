package com.technologygroup.rayannoor.yoga.Teaches;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.technologygroup.rayannoor.yoga.R;

public class TeachDetailsActivity extends AppCompatActivity {

    TextView teachDetailsTitle;
    TextView teachDetailsText;
    ImageView teachDetailsImg;
    private String onvan;
    private String matn;
    private String tasvir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teach_details);
        initView();

        String imgResource = ("mipmap/".concat(tasvir)).trim();

//        Toast.makeText(getApplicationContext(), imgResource, Toast.LENGTH_LONG).show();
        teachDetailsTitle.setText(onvan);
        teachDetailsText.setText(matn);
        teachDetailsImg.setImageResource(getResources().getIdentifier(imgResource, "drawable", getPackageName()));


    }

    private void initView(){

        teachDetailsText = (TextView) findViewById(R.id.teach_details_text);
        teachDetailsTitle = (TextView) findViewById(R.id.txtTitle);
        teachDetailsImg =(ImageView) findViewById(R.id.teach_details_image);



        onvan = getIntent().getStringExtra("onvan");
        matn = getIntent().getStringExtra("matn");
        tasvir = getIntent().getStringExtra("tasvir").trim();

    }
}
