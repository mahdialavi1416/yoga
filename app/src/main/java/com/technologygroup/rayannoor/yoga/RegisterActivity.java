package com.technologygroup.rayannoor.yoga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class RegisterActivity extends AppCompatActivity {


    private GradientBackgroundPainter gradientBackgroundPainter;
    private LinearLayout lytRegister;
    private EditText edtFName;
    private EditText edtLName;
    private EditText edtMobile;
    private EditText edtEmail;
    private EditText edtUserName;
    private EditText edtUserPass;
    private CircularProgressButton btnRegister;
    private TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

        //background color change
        final int[] drawables = new int[4];
        drawables[0] = R.drawable.gradient_1;
        drawables[1] = R.drawable.gradient_2;
        drawables[2] = R.drawable.gradient_3;
        drawables[3] = R.drawable.gradient_4;
        gradientBackgroundPainter = new GradientBackgroundPainter(lytRegister, drawables);
        gradientBackgroundPainter.start();


        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this , LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    private void initView() {
        lytRegister = (LinearLayout) findViewById(R.id.lytRegister);
        edtFName = (EditText) findViewById(R.id.edtFName);
        edtLName = (EditText) findViewById(R.id.edtLName);
        edtMobile = (EditText) findViewById(R.id.edtMobile);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtUserName = (EditText) findViewById(R.id.edtUserName);
        edtUserPass = (EditText) findViewById(R.id.edtUserPass);
        btnRegister = (CircularProgressButton) findViewById(R.id.btnRegister);
        txtLogin = (TextView) findViewById(R.id.txtLogin);
    }
}
