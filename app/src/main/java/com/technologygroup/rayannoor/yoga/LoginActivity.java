package com.technologygroup.rayannoor.yoga;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class LoginActivity extends AppCompatActivity {


    private GradientBackgroundPainter gradientBackgroundPainter;
    private LinearLayout lytLogin;
    private Spinner LoginSpinner;
    private EditText edtUserName;
    private EditText edtPass;
    private CircularProgressButton btnLogin;
    private TextView txtForgetPass;
    private TextView txtRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        //background color change
        final int[] drawables = new int[4];
        drawables[0] = R.drawable.gradient_1;
        drawables[1] = R.drawable.gradient_2;
        drawables[2] = R.drawable.gradient_3;
        drawables[3] = R.drawable.gradient_4;
        gradientBackgroundPainter = new GradientBackgroundPainter(lytLogin, drawables);
        gradientBackgroundPainter.start();


        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this , RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }

    private void initView() {
        lytLogin = (LinearLayout) findViewById(R.id.lytLogin);
        LoginSpinner = (Spinner) findViewById(R.id.LoginSpinner);
        edtUserName = (EditText) findViewById(R.id.edtUserName);
        edtPass = (EditText) findViewById(R.id.edtPass);
        btnLogin = (CircularProgressButton) findViewById(R.id.btnLogin);
        txtForgetPass = (TextView) findViewById(R.id.txtForgetPass);
        txtRegister = (TextView) findViewById(R.id.txtRegister);
    }
}
