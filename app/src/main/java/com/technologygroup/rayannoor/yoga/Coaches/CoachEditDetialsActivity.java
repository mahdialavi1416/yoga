package com.technologygroup.rayannoor.yoga.Coaches;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.RoundedImageView;

public class CoachEditDetialsActivity extends AppCompatActivity {

    private LinearLayout header;
    private RelativeLayout relativeBack;
    private ImageView imgBack;
    private LinearLayout lytChangePassword;
    private LinearLayout lytLogOut;
    private EditText edtFName;
    private EditText edtLName;
    private EditText edtNatCode;
    private LinearLayout lytMobile;
    private EditText edtMobile;
    private LinearLayout lytTelegram;
    private EditText edtTelegram;
    private LinearLayout lytInstagram;
    private EditText edtInstagram;
    private LinearLayout lytEmail;
    private EditText edtEmail;
    private RoundedImageView imgProfile;
    private LinearLayout lytEditInformation;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_edit_detials);
        initView();

        lytChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    private void initView() {
        header = (LinearLayout) findViewById(R.id.header);
        relativeBack = (RelativeLayout) findViewById(R.id.relative_back);
        imgBack = (ImageView) findViewById(R.id.imgBack);
        lytChangePassword = (LinearLayout) findViewById(R.id.lytChangePassword);
        lytLogOut = (LinearLayout) findViewById(R.id.lytLogOut);
        edtFName = (EditText) findViewById(R.id.edtFName);
        edtLName = (EditText) findViewById(R.id.edtLName);
        edtNatCode = (EditText) findViewById(R.id.edtNatCode);
        lytMobile = (LinearLayout) findViewById(R.id.lytMobile);
        edtMobile = (EditText) findViewById(R.id.edtMobile);
        lytTelegram = (LinearLayout) findViewById(R.id.lytTelegram);
        edtTelegram = (EditText) findViewById(R.id.edtTelegram);
        lytInstagram = (LinearLayout) findViewById(R.id.lytInstagram);
        edtInstagram = (EditText) findViewById(R.id.edtInstagram);
        lytEmail = (LinearLayout) findViewById(R.id.lytEmail);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        imgProfile = (RoundedImageView) findViewById(R.id.imgProfile);
        lytEditInformation = (LinearLayout) findViewById(R.id.lytEditInformation);
    }

    private void showDialog() {
        dialog = new Dialog(CoachEditDetialsActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_change_password);
        Button btn_cancel = (Button) dialog.findViewById(R.id.btn_cancel);
        Button btnPassSend = (Button) dialog.findViewById(R.id.btnPassSend);
        EditText edtNewPass = (EditText) dialog.findViewById(R.id.edtNewPass);
        EditText edtLastPass = (EditText) dialog.findViewById(R.id.edtLastPass);

        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }
}
