package com.technologygroup.rayannoor.yoga.YogaIntroduce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.technologygroup.rayannoor.yoga.R;

public class IntroduceDetailsActivity extends AppCompatActivity {

    private TextView teachDetailsTitle;
    private TextView teachDetailsText;
    private ImageView teachDetailsImg;
    private String onvan;
    private String matn;
    private String tasvir;
    private ImageView teachDetailsSharing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teach_details);
        initView();


        String imgResource = ("mipmap/".concat(tasvir)).trim();

//        Toast.makeText(getApplicationContext(), imgResource, Toast.LENGTH_LONG).show();
        teachDetailsTitle.setText(onvan);
        teachDetailsText.setText(matn);
        try {
            teachDetailsImg.setImageResource(getResources().getIdentifier(imgResource, "drawable", getPackageName()));
        }catch (Exception ex){
            Toast.makeText(IntroduceDetailsActivity.this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }

        teachDetailsSharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, R.string.app_name);
                intent.putExtra(Intent.EXTRA_TEXT,"#" +
                        onvan.replace(" ", "_") + "\n"+ matn.toString()
                        + "\nhttp://www.example.com\n" +"#نرم_افزار");
                Intent mailer = Intent.createChooser(intent, null);
                startActivity(mailer);
            }
        });

    }

    private void initView(){

        teachDetailsText = (TextView) findViewById(R.id.teach_details_text);
        teachDetailsTitle = (TextView) findViewById(R.id.txtTitle);
        teachDetailsImg =(ImageView) findViewById(R.id.teach_details_image);
        teachDetailsSharing=(ImageView)findViewById(R.id.teach_details_sharing);


        onvan = getIntent().getStringExtra("onvan");
        matn = getIntent().getStringExtra("matn");
        tasvir = getIntent().getStringExtra("tasvir").trim();

    }
}
