package com.technologygroup.rayannoor.yoga;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class imageActivity extends Activity {

    private TouchImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        img = (TouchImageView) findViewById(R.id.img);
    }

}
