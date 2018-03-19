package com.technologygroup.rayannoor.yoga;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.technologygroup.rayannoor.yoga.Classes.App;
import com.technologygroup.rayannoor.yoga.Services.WebService;
import com.technologygroup.rayannoor.yoga.Services.fetchDataCity;
import com.technologygroup.rayannoor.yoga.Services.fetchDataState;

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

    Dialog dialog;
    public static Spinner StateSpinner;
    public static Spinner CitySpinner;
    private int stateNumber = 1;
    private int cityNumber = 1;
    public static TextView textView;
    private SharedPreferences prefs;

    int idUser = -1;

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

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtFName.getText().toString().equals("") || !edtLName.getText().toString().equals("") || !edtMobile.getText().toString().equals("") || !edtEmail.getText().toString().equals("") || !edtUserName.getText().toString().equals("") || !edtUserPass.getText().toString().equals("")){

                    if (edtMobile.getText().toString().length() == 11){

                        if (edtEmail.getText().toString().contains(".") && edtEmail.getText().toString().contains("@")){

                            WebServiceCallReg callReg = new WebServiceCallReg();
                            callReg.execute();

                        } else {
                            Toast.makeText(RegisterActivity.this, "ایمیل نامعتبر است", Toast.LENGTH_LONG).show();
                        }

                    } else {
                        Toast.makeText(RegisterActivity.this, "شماره تلفن صحیح نیست", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(RegisterActivity.this, "لطفا فیلد ها را کامل کنید", Toast.LENGTH_LONG).show();
                }
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

    private void showStateDialog() {
        dialog = new Dialog(RegisterActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_state_city);

        CitySpinner = (Spinner) dialog.findViewById(R.id.CitySpinner);
        final Button btnSendStateCity = (Button) dialog.findViewById(R.id.btnSendState_city);
        btnSendStateCity.setEnabled(false);
        btnSendStateCity.setAlpha(0.25f);

        StateSpinner = dialog.findViewById(R.id.StateSpinner);
        fetchDataState url_read_process = new fetchDataState();
        url_read_process.execute();//change the province to the expected value

        textView = dialog.findViewById(R.id.use_province_help);


        //Toast.makeText(dialog.getContext(), "salaam", Toast.LENGTH_LONG).show();


        StateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//               Toast.makeText(dialog.getContext(), (position+1) + "", Toast.LENGTH_LONG).show();

                stateNumber = position + 1;
                //get the city information
                fetchDataCity fetchDataCity = new fetchDataCity(stateNumber);
                fetchDataCity.execute();
                btnSendStateCity.setEnabled(true);
                btnSendStateCity.setAlpha(1.0f);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnSendStateCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cityNumber > 0 && stateNumber > 0) {

                    prefs = getSharedPreferences("MyPrefs", 0);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("isFirstRun", false);
                    editor.putInt("idUser", idUser);
                    // 1 means normal users
                    editor.putInt("userType", 1);
                    editor.apply();

                    Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                    i.putExtra("stateNumber", stateNumber);
                    i.putExtra("cityNumber", cityNumber);

                    startActivity(i);
                    finish();
                }

            }
        });

        dialog.show();
    }

    private class WebServiceCallReg extends AsyncTask<Object, Void, Void> {

        private WebService webService;
        String result;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            btnRegister.startAnimation();
            webService = new WebService();

        }

        @Override
        protected Void doInBackground(Object... params) {

            // id is for place
            //result = webService.postRate(App.isInternetOn(), coachModel.id, idUser, "coach", (float) rate);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (result != null) {

                if (Integer.parseInt(result) > 0) {

                    idUser = Integer.parseInt(result);

                    // بعد از اتمام عملیات کدهای زیر اجرا شوند
                    Bitmap icon = BitmapFactory.decodeResource(getResources(),
                            R.drawable.ic_ok);
                    btnRegister.doneLoadingAnimation(R.color.green, icon); // finish loading

                    // بستن دیالوگ حتما با تاخیر انجام شود
                    Handler handler1 = new Handler();
                    handler1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            showStateDialog();
                        }
                    }, 1000);


                } else {

                    btnRegister.revertAnimation();
                    Toast.makeText(RegisterActivity.this, "ثبت نام نا موفق", Toast.LENGTH_LONG).show();
                }

            } else {

                btnRegister.revertAnimation();
                Toast.makeText(RegisterActivity.this, "اتصال با سرور برقرار نشد", Toast.LENGTH_LONG).show();
            }

        }

    }

}
