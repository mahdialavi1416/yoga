package com.technologygroup.rayannoor.yoga.Coaches;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.technologygroup.rayannoor.yoga.Classes.App;
import com.technologygroup.rayannoor.yoga.Classes.ClassDate;
import com.technologygroup.rayannoor.yoga.Models.CoachHonorModel;
import com.technologygroup.rayannoor.yoga.Models.TeachesModel;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.Services.FilePath;
import com.technologygroup.rayannoor.yoga.Services.WebService;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

public class addTeachActivity extends AppCompatActivity {

    private TextView txtTitle;
    private RelativeLayout btnBack;
    private EditText edtTitle;
    private LinearLayout[] lytTeach = new LinearLayout[11];
    private TextView[] txtNoImage = new TextView[11];
    private ImageView[] imgTeach = new ImageView[11];
    private ImageView[] imgSelectPicture = new ImageView[11];
    private EditText[] edtBody = new EditText[11];
    private TextView lytAddLesson, lytDeleteLesson;
    private RelativeLayout lytSend;

    private int visibleLyts = 1;
    public boolean flagPermission = false;
    private int idCoach;
    private static int PICK_FILE_REQUEST = 1;
    private String[] selectedFilePath = new String[11];
    private String[] selectedImgName = new String[11];
    private String[] bodyList = new String[11];
    private String resultAdd;
    Dialog dialog2;
    private int numberOfImages, numberOfDes, numberOfFilledLyts;
    private boolean calledToAdd;
    private int id;
    private String Title, Images, Body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teach);
        initView();

        for (int j = 1; j < 11; j++) {
            selectedFilePath[j] = "";
            selectedImgName[j] = "";
            bodyList[j] = "";
        }


        calledToAdd = getIntent().getBooleanExtra("calledToAdd", true);
        idCoach = getIntent().getIntExtra("idRow", -1);

        if (!calledToAdd) {
            id = getIntent().getIntExtra("id", -1);
            Title = getIntent().getStringExtra("Title");
            Body = getIntent().getStringExtra("Body");
            Images = getIntent().getStringExtra("Images");

            edtTitle.setText(Title);

            selectedImgName = Images.split("~");
            numberOfImages = selectedImgName.length;
            bodyList = Body.split("~");
            numberOfDes = bodyList.length;

            if (numberOfDes > numberOfImages) {
                visibleLyts = numberOfDes;
            } else {

                visibleLyts = numberOfImages;
            }

            for (int j = 1; j < visibleLyts; j++) {

                lytTeach[j].setVisibility(View.VISIBLE);

            }

        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
            } else {
                flagPermission = true;
            }
        } else {
            flagPermission = true;
        }


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        lytAddLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (visibleLyts < 10) {

                    visibleLyts++;
                    lytTeach[visibleLyts].setVisibility(View.VISIBLE);
                }

            }
        });

        lytDeleteLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (visibleLyts > 1) {

                    lytTeach[visibleLyts].setVisibility(View.GONE);
                    imgTeach[visibleLyts].setVisibility(View.GONE);
                    txtNoImage[visibleLyts].setVisibility(View.VISIBLE);
                    edtBody[visibleLyts].setText("");
                    selectedFilePath[visibleLyts] = "";
                    selectedImgName[visibleLyts] = "";
                    visibleLyts--;
                }

            }
        });

        for (int j = 1; j < 11; j++) {
            setOnClick(imgSelectPicture[j], j);
        }

        lytSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numberOfDes = 0;
                numberOfImages = 0;
                numberOfFilledLyts = 0;

                for (int j = 1; j < visibleLyts + 1; j++) {

                    if (!edtBody[j].getText().toString().equals("") || !selectedImgName[j].equals("")) {
                        numberOfFilledLyts++;
                    }
                    if (!selectedImgName[j].equals("")) {
                        numberOfImages++;
                    }
                }

                if (!edtTitle.getText().toString().equals("")) {

                    if (numberOfFilledLyts == 0) {
                        Toast.makeText(addTeachActivity.this, "حرکتی اضافه نشده است", Toast.LENGTH_LONG).show();
                    } else {
                        WebServiceAdd webServiceAdd = new WebServiceAdd();
                        webServiceAdd.execute();
                    }
                } else {
                    Toast.makeText(addTeachActivity.this, "عنوان وارد نشده است", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    private void initView() {
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        btnBack = (RelativeLayout) findViewById(R.id.btnBack);
        edtTitle = (EditText) findViewById(R.id.edtTitle);
        lytTeach[1] = (LinearLayout) findViewById(R.id.lytTeach1);
        txtNoImage[1] = (TextView) findViewById(R.id.txtNoImage1);
        imgTeach[1] = (ImageView) findViewById(R.id.imgTeach1);
        imgSelectPicture[1] = (ImageView) findViewById(R.id.imgSelectPicture1);
        edtBody[1] = (EditText) findViewById(R.id.edtBody1);
        lytTeach[2] = (LinearLayout) findViewById(R.id.lytTeach2);
        txtNoImage[2] = (TextView) findViewById(R.id.txtNoImage2);
        imgTeach[2] = (ImageView) findViewById(R.id.imgTeach2);
        imgSelectPicture[2] = (ImageView) findViewById(R.id.imgSelectPicture2);
        edtBody[2] = (EditText) findViewById(R.id.edtBody2);
        lytTeach[3] = (LinearLayout) findViewById(R.id.lytTeach3);
        txtNoImage[3] = (TextView) findViewById(R.id.txtNoImage3);
        imgTeach[3] = (ImageView) findViewById(R.id.imgTeach3);
        imgSelectPicture[3] = (ImageView) findViewById(R.id.imgSelectPicture3);
        edtBody[3] = (EditText) findViewById(R.id.edtBody3);
        lytTeach[4] = (LinearLayout) findViewById(R.id.lytTeach4);
        txtNoImage[4] = (TextView) findViewById(R.id.txtNoImage4);
        imgTeach[4] = (ImageView) findViewById(R.id.imgTeach4);
        imgSelectPicture[4] = (ImageView) findViewById(R.id.imgSelectPictur4);
        edtBody[4] = (EditText) findViewById(R.id.edtBody4);
        lytTeach[5] = (LinearLayout) findViewById(R.id.lytTeach5);
        txtNoImage[5] = (TextView) findViewById(R.id.txtNoImage5);
        imgTeach[5] = (ImageView) findViewById(R.id.imgTeach5);
        imgSelectPicture[5] = (ImageView) findViewById(R.id.imgSelectPicture5);
        edtBody[5] = (EditText) findViewById(R.id.edtBody5);
        lytTeach[6] = (LinearLayout) findViewById(R.id.lytTeach6);
        txtNoImage[6] = (TextView) findViewById(R.id.txtNoImage6);
        imgTeach[6] = (ImageView) findViewById(R.id.imgTeach6);
        imgSelectPicture[6] = (ImageView) findViewById(R.id.imgSelectPicture6);
        edtBody[6] = (EditText) findViewById(R.id.edtBody6);
        lytTeach[7] = (LinearLayout) findViewById(R.id.lytTeach7);
        txtNoImage[7] = (TextView) findViewById(R.id.txtNoImage7);
        imgTeach[7] = (ImageView) findViewById(R.id.imgTeach7);
        imgSelectPicture[7] = (ImageView) findViewById(R.id.imgSelectPicture7);
        edtBody[7] = (EditText) findViewById(R.id.edtBody7);
        lytTeach[8] = (LinearLayout) findViewById(R.id.lytTeach8);
        txtNoImage[8] = (TextView) findViewById(R.id.txtNoImage8);
        imgTeach[8] = (ImageView) findViewById(R.id.imgTeach8);
        imgSelectPicture[8] = (ImageView) findViewById(R.id.imgSelectPicture8);
        edtBody[8] = (EditText) findViewById(R.id.edtBody8);
        lytTeach[9] = (LinearLayout) findViewById(R.id.lytTeach9);
        txtNoImage[9] = (TextView) findViewById(R.id.txtNoImage9);
        imgTeach[9] = (ImageView) findViewById(R.id.imgTeach9);
        imgSelectPicture[9] = (ImageView) findViewById(R.id.imgSelectPicture9);
        edtBody[9] = (EditText) findViewById(R.id.edtBody9);
        lytTeach[10] = (LinearLayout) findViewById(R.id.lytTeach10);
        txtNoImage[10] = (TextView) findViewById(R.id.txtNoImage10);
        imgTeach[10] = (ImageView) findViewById(R.id.imgTeach10);
        imgSelectPicture[10] = (ImageView) findViewById(R.id.imgSelectPicture10);
        edtBody[10] = (EditText) findViewById(R.id.edtBody10);
        lytAddLesson = (TextView) findViewById(R.id.lytAddLesson);
        lytDeleteLesson = (TextView) findViewById(R.id.lytDeleteLesson);
        lytSend = (RelativeLayout) findViewById(R.id.lytSend);
    }


    private void setOnClick(final ImageView img, final int i) {
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flagPermission) {

                    if (App.isInternetOn()) {

                        if (idCoach > 0) {

                            PICK_FILE_REQUEST = i;
                            showFileChooser(i);

                        }
                    } else {
                        Toast.makeText(addTeachActivity.this, "به اینترنت متصل نیستید", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }

    private void showFileChooser(int i) {
        Intent intent = new Intent();
        //sets the select file to all types of files
        intent.setType("*/*");
        //allows to select data and return it
        intent.setAction(Intent.ACTION_GET_CONTENT);
        //starts new activity to select file and return data
        startActivityForResult(Intent.createChooser(intent, "انتخاب فایل"), i);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == PICK_FILE_REQUEST) {
                if (data == null) {
                    //no data present
                    return;
                }


                Uri selectedFileUri = data.getData();

                imgTeach[requestCode].setVisibility(View.VISIBLE);
                txtNoImage[requestCode].setVisibility(View.GONE);

                if (selectedFileUri != null)
                    if (!selectedFileUri.equals("") && !selectedFileUri.equals("null"))
                        Glide.with(this).loadFromMediaStore(selectedFileUri).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imgTeach[requestCode]);

                selectedFilePath[requestCode] = FilePath.getPath(this, selectedFileUri);
                Log.i(TAG, "Selected File Path:" + selectedFilePath);

                if (selectedFilePath[requestCode] != null && !selectedFilePath[requestCode].equals("")) {

                    String extension = selectedFilePath[requestCode].substring(selectedFilePath[requestCode].lastIndexOf(".") + 1, selectedFilePath[requestCode].length());
                    ClassDate classDate = new ClassDate();
                    selectedImgName[requestCode] = classDate.getDateTime() + "_" + "t_" + idCoach + "." + extension;

                }
            } else {
                Toast.makeText(this, "خطا در انتخاب فایل", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.v(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);
            //resume tasks needing this permission
            flagPermission = true;
        } else
            flagPermission = false;
    }

    private class WebServiceAdd extends AsyncTask<Object, Void, Void> {

        private WebService webService;
        TeachesModel model;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog2 = new Dialog(addTeachActivity.this);
            dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog2.setContentView(R.layout.dialog_wait);
            dialog2.setCancelable(true);
            dialog2.setCanceledOnTouchOutside(true);
            dialog2.show();


            webService = new WebService();
            model = new TeachesModel();
            ClassDate classDate = new ClassDate();

            model.id = -1;
            model.idRow = idCoach;
            model.Title = edtTitle.getText().toString();
            model.Date = Integer.parseInt(classDate.getDate());
            model.isGym = false;
            model.Body = "";
            model.Images = "";

            for (int j = 1; j < visibleLyts + 1; j++) {

                model.Body += edtBody[j].getText().toString();
                if (j != visibleLyts) {
                    model.Body += "~";
                }
            }
            for (int j = 1; j < visibleLyts + 1; j++) {

                model.Images += selectedImgName[j];
                if (j != visibleLyts) {
                    model.Images += "~";
                }
            }

        }

        @Override
        protected Void doInBackground(Object... params) {

            resultAdd = webService.AddTeaches(App.isInternetOn(), model);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            if (resultAdd != null) {

                if (Integer.parseInt(resultAdd) > 0) {

                    CallBackFile callBackFile = new CallBackFile();
                    callBackFile.execute();

                    //model.id = Integer.parseInt(resultAdd);

                } else if (Integer.parseInt(resultAdd) == 0) {

                    Toast.makeText(addTeachActivity.this, "ارسال آموزش ناموفق است", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(addTeachActivity.this, "خطا در برقراری ارتباط", Toast.LENGTH_LONG).show();

                }
            } else {

                Toast.makeText(addTeachActivity.this, "خطا در برقراری ارتباط", Toast.LENGTH_LONG).show();

            }
        }
    }

    private class CallBackFile extends AsyncTask<Object, Void, Void> {

        private WebService webService;
        int fileResult;
        String lastUpdate;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            webService = new WebService();

//            dialog2 = new Dialog(getContext());
//            dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
//            dialog2.setContentView(R.layout.dialog_waiting);
//            dialog2.setCancelable(true);
//            dialog2.setCanceledOnTouchOutside(true);
//            dialog2.show();

            ClassDate classDate = new ClassDate();
            lastUpdate = classDate.getDateTime();
        }

        @Override
        protected Void doInBackground(Object... params) {

            for (int j = 1; j < numberOfImages + 1; j++) {

                fileResult = webService.uploadFile(App.isInternetOn(), selectedFilePath[j], selectedImgName[j]);

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            dialog2.dismiss();


            if (resultAdd != null) {

                if (Integer.parseInt(resultAdd) > 0) {

                    Toast.makeText(addTeachActivity.this, "آموزش با موفقیت ارسال شد", Toast.LENGTH_LONG).show();
                    finish();

                } else if (Integer.parseInt(resultAdd) == 0) {

                    Toast.makeText(addTeachActivity.this, "ارسال آموزش ناموفق است", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(addTeachActivity.this, "خطا در برقراری ارتباط", Toast.LENGTH_LONG).show();

                }
            } else {

                Toast.makeText(addTeachActivity.this, "خطا در برقراری ارتباط", Toast.LENGTH_LONG).show();

            }


            if (fileResult == 200) {
//                Toast.makeText(addTeachActivity.this, "تصویر با موفقیت آپلود شد", Toast.LENGTH_SHORT).show();

            } else if (fileResult == 0) {
//                Toast.makeText(addTeachActivity.this, "متاسفانه تصویر آپلود نشد", Toast.LENGTH_SHORT).show();
//                CallBackFileDelete callBackFileDelete = new CallBackFileDelete();
//                callBackFileDelete.execute();
            } else {
//                Toast.makeText(addTeachActivity.this, "متاسفانه تصویر آپلود نشد", Toast.LENGTH_SHORT).show();
//                CallBackFileDelete callBackFileDelete = new CallBackFileDelete();
//                callBackFileDelete.execute();
            }
        }
    }


}
