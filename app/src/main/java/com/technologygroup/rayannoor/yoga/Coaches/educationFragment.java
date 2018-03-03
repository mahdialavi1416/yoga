package com.technologygroup.rayannoor.yoga.Coaches;


import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.technologygroup.rayannoor.yoga.Classes.App;
import com.technologygroup.rayannoor.yoga.Classes.ClassDate;
import com.technologygroup.rayannoor.yoga.Models.CoachEduModel;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.Services.FilePath;
import com.technologygroup.rayannoor.yoga.Services.WebService;
import com.technologygroup.rayannoor.yoga.adapters.CoachCertificateAdapter;
import com.technologygroup.rayannoor.yoga.adapters.CoachEducationAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class educationFragment extends Fragment {


    LinearLayout lytMain, lytDisconnect, lytEmpty;
    private RecyclerView Recycler;
    private FloatingActionButton floatAction;
    private Dialog dialog;

    private SharedPreferences prefs;
    private int idCoach;
    List<CoachEduModel> list;
    public boolean flagPermission = false;
    private static final int PICK_FILE_REQUEST = 1;
    private String selectedFilePath, selectedImgName = "";

    // dialog add content
    EditText edtTitle, edtUniversity;
    TextView txtNoImage;
    ImageView imgCertificate, imgSelectPicture;
    Button btn_cancel, btnOk;

    public educationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_education, container, false);

        lytEmpty = view.findViewById(R.id.lytEmpty);
        lytMain = view.findViewById(R.id.lytMain);
        lytDisconnect = view.findViewById(R.id.lytDisconnect);
        Recycler = view.findViewById(R.id.Recycler);
        floatAction = view.findViewById(R.id.floatAction);

        //todo: get idCoach from shared preferences
        prefs = getContext().getSharedPreferences("MyPrefs", 0);
//        idCoach = prefs.getInt("IdCoach", -1);
        idCoach = 1;


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (getActivity().checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
            } else {
                flagPermission = true;
            }
        } else {
            flagPermission = true;
        }

        if (idCoach > 0) {

            WebServiceCoachInfo webServiceCoachInfo = new WebServiceCoachInfo();
            webServiceCoachInfo.execute();
        } else {
            Toast.makeText(getContext(), "مربی مورد نظر یافت نشد", Toast.LENGTH_LONG).show();
        }


        floatAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        //setUpRecyclerView();
        return view;
    }

    private void setUpRecyclerView(List<CoachEduModel> list) {
        CoachEducationAdapter adapter = new CoachEducationAdapter(getActivity(), list);
        Recycler.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(getContext());
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        Recycler.setLayoutManager(mLinearLayoutManagerVertical);
    }

    private void showDialog() {
        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add_education);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();

        edtTitle = dialog.findViewById(R.id.edtTitle);
        edtUniversity = dialog.findViewById(R.id.edtUniversity);
        txtNoImage = dialog.findViewById(R.id.txtNoImage);
        imgCertificate = dialog.findViewById(R.id.imgCertificate);
        imgSelectPicture = dialog.findViewById(R.id.imgSelectPicture);
        btnOk = dialog.findViewById(R.id.btnOk);
        btn_cancel = dialog.findViewById(R.id.btn_cancel);

        imgSelectPicture.setOnClickListener(imgSelectPicture_click);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!edtTitle.getText().equals("") && !edtUniversity.getText().equals("")) {

                    if (!selectedImgName.equals("")) {

//                        CallBackFileDetails callBackFileDetails = new CallBackFileDetails();
//                        callBackFileDetails.execute();

                    } else {
                        Toast.makeText(getContext(), "لطفا تصویر مدرک را انتخاب کنید", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(getContext(), "لطفا فیلد ها را کامل کنید", Toast.LENGTH_LONG).show();
                }

            }
        });

    }


    View.OnClickListener imgSelectPicture_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (flagPermission) {

                if (App.isInternetOn()) {

                    if (idCoach > 0) {

                        showFileChooser();

                    }
                } else {
                    Snackbar.make(getView(), "به اینترنت متصل نیستید", Snackbar.LENGTH_LONG).show();
                }
            }

        }
    };

    private void showFileChooser() {
        Intent intent = new Intent();
        //sets the select file to all types of files
        intent.setType("*/*");
        //allows to select data and return it
        intent.setAction(Intent.ACTION_GET_CONTENT);
        //starts new activity to select file and return data
        startActivityForResult(Intent.createChooser(intent, "انتخاب فایل"), PICK_FILE_REQUEST);
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

                imgCertificate.setVisibility(View.VISIBLE);
                txtNoImage.setVisibility(View.GONE);

                if (selectedFileUri != null)
                    if (!selectedFileUri.equals("") && !selectedFileUri.equals("null"))
                        Glide.with(getContext()).loadFromMediaStore(selectedFileUri).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imgCertificate);

                selectedFilePath = FilePath.getPath(this.getActivity(), selectedFileUri);
                Log.i(TAG, "Selected File Path:" + selectedFilePath);

                if (selectedFilePath != null && !selectedFilePath.equals("")) {

                    String extension = selectedFilePath.substring(selectedFilePath.lastIndexOf(".") + 1, selectedFilePath.length());
                    ClassDate classDate = new ClassDate();
                    selectedImgName = classDate.getDateTime() + "_" + "c_" + idCoach + "." + extension;

                }
            } else {
                Toast.makeText(getContext(), "خطا در انتخاب فایل", Toast.LENGTH_SHORT).show();
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


    private class WebServiceCoachInfo extends AsyncTask<Object, Void, Void> {

        private WebService webService;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            webService = new WebService();
            list = new ArrayList<>();

        }

        @Override
        protected Void doInBackground(Object... params) {

            list = webService.getCoachEdu(App.isInternetOn(), idCoach);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            if (list != null) {

                if (list.size() > 0) {

                    lytDisconnect.setVisibility(View.GONE);
                    lytEmpty.setVisibility(View.GONE);
                    lytMain.setVisibility(View.VISIBLE);

                    setUpRecyclerView(list);

                } else {

                    lytDisconnect.setVisibility(View.GONE);
                    lytMain.setVisibility(View.GONE);
                    lytEmpty.setVisibility(View.VISIBLE);


                }

            } else {

                lytMain.setVisibility(View.GONE);
                lytEmpty.setVisibility(View.GONE);
                lytDisconnect.setVisibility(View.VISIBLE);

            }

        }

    }


    @Override
    public void onResume() {
        super.onResume();
        //todo: get idCoach from shared preferences
        prefs = getContext().getSharedPreferences("MyPrefs", 0);
//        idCoach = prefs.getInt("IdCoach", -1);
        idCoach = 1;
    }

}
