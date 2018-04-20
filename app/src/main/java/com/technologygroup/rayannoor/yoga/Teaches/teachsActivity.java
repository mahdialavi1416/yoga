package com.technologygroup.rayannoor.yoga.Teaches;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.technologygroup.rayannoor.yoga.R;

public class teachsActivity extends AppCompatActivity {

    private RelativeLayout btnBack;
    private ImageView img1;
    private ImageView img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teach);
        initView();

        //set image dark
//        img1.setColorFilter(Color.rgb(180, 180, 180), PorterDuff.Mode.MULTIPLY);
//        img2.setColorFilter(Color.rgb(180, 180, 180), PorterDuff.Mode.MULTIPLY);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(teachsActivity.this, teachsListActivity.class);
                intent.putExtra("tab_number", 0);
                startActivity(intent);
            }
        });


        img2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(teachsActivity.this, CoachTeachsActivity.class);
                        startActivity(intent);
                    }
                });

    }

    private void initView() {
        btnBack = (RelativeLayout) findViewById(R.id.btnBack);
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
    }
}
