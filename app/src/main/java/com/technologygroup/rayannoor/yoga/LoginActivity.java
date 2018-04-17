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
import com.technologygroup.rayannoor.yoga.Models.UserModel;
import com.technologygroup.rayannoor.yoga.Services.WebService;
import com.technologygroup.rayannoor.yoga.Services.fetchDataCity;
import com.technologygroup.rayannoor.yoga.Services.fetchDataState;

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
    private SharedPreferences prefs;
    Dialog dialog;
    public static Spinner StateSpinner;
    public static Spinner CitySpinner;
    private int stateNumber = 1;
    private int cityNumber = 1;
    public static TextView textView;


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

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtUserName.getText().toString().equals("") || !edtPass.getText().toString().equals("")){

                    if (edtUserName.getText().toString().length() == 11 && edtUserName.getText().toString().startsWith("0")){

                            WebServiceCall call = new WebServiceCall();
                            call.execute();

                    } else {
                        Toast.makeText(LoginActivity.this, "شماره تلفن صحیح نیست", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(LoginActivity.this, "لطفا فیلد ها را کامل کنید", Toast.LENGTH_LONG).show();
                }
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

    private void showStateDialog() {
        dialog = new Dialog(LoginActivity.this);
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
                    editor.putInt("stateNumber", stateNumber);
                    editor.putInt("cityNumber", cityNumber);
                    editor.apply();

                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        });

        dialog.show();
    }

    private class WebServiceCall extends AsyncTask<Object, Void, Void> {

        private WebService webService;
        UserModel userModel;

        String userName, pass;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            btnLogin.startAnimation();
            webService = new WebService();

            userName = edtUserName.getText().toString().substring(1);
            pass = edtPass.getText().toString();
        }

        @Override
        protected Void doInBackground(Object... params) {

            userModel = webService.userLogin(App.isInternetOn(), userName, pass);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (userModel != null) {

                if (userModel.id > 0) {

                    prefs = getSharedPreferences("MyPrefs", 0);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("idUser", userModel.id);
                    editor.putInt("userType", userModel.Type);
                    editor.putString("Name", userModel.Name);
                    editor.putString("lName", userModel.lName);
                    editor.putString("Mobile", userModel.Mobile);
                    editor.putString("Email", userModel.Email);
                    editor.putString("Password", userModel.Password);
                    editor.apply();

                    // بعد از اتمام عملیات کدهای زیر اجرا شوند
                    Bitmap icon = BitmapFactory.decodeResource(getResources(),
                            R.drawable.ic_ok);
                    btnLogin.doneLoadingAnimation(R.color.green, icon); // finish loading

                    // بستن دیالوگ حتما با تاخیر انجام شود
                    Handler handler1 = new Handler();
                    handler1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //showStateDialog();

                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(i);
                            finish();
                        }
                    }, 1000);


                } else {

                    btnLogin.revertAnimation();
                    Toast.makeText(LoginActivity.this, "رمز یا نام کاربری اشتباه است", Toast.LENGTH_LONG).show();
                }

            } else {

                btnLogin.revertAnimation();
                Toast.makeText(LoginActivity.this, "اتصال با سرور برقرار نشد", Toast.LENGTH_LONG).show();
            }

        }

    }

}
