package com.technologygroup.rayannoor.yoga;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUserName;
    private EditText edtPass;
    private Button btnLogin;
    private Spinner LoginSpinner;
    private GradientBackgroundPainter gradientBackgroundPainter;
    private LinearLayout lytLogin;

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
    }

    private void initView() {
        edtUserName = (EditText) findViewById(R.id.edtUserName);
        edtPass = (EditText) findViewById(R.id.edtPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        LoginSpinner = findViewById(R.id.LoginSpinner);
        lytLogin = (LinearLayout) findViewById(R.id.lytLogin);
    }
}
