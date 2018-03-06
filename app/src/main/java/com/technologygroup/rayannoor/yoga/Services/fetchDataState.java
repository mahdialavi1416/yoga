package com.technologygroup.rayannoor.yoga.Services;

import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.technologygroup.rayannoor.yoga.IntroPage.IntroFragment;
import com.technologygroup.rayannoor.yoga.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Samen-Pc on 2/28/2018.
 */

public class fetchDataState extends AsyncTask<Void, Void, Void>{
    private String json_pure_provinces = "";
//    String json_provinces = "";
    private String[] provinces;
//    boolean done = false;
//    Dialog dialog;
    ArrayAdapter<String> spinnerArrayAdapter;
    @Override
    protected Void doInBackground(Void... voids) {

//        if (!done) {
            try {
                URL json_url = new URL("http://yuga.gsharing.ir/api/State/select");
                HttpURLConnection httpURLConnection = (HttpURLConnection) json_url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while (line != null) {
                    line = bufferedReader.readLine();
                    json_pure_provinces += line;
                }


            } catch (Exception ex) {
//            IntroFragment.provinces = ex.toString();
                ex.printStackTrace();
            }
//        }
        return null;
    }

    @Override
    protected void onPostExecute(final Void aVoid) {
        super.onPostExecute(aVoid);
        try {
                JSONArray jsonArray = new JSONArray(json_pure_provinces);
                provinces = new String[jsonArray.length()];//probably 31 home
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject provinceObject = (JSONObject) jsonArray.get(i);
                    provinces[i] = provinceObject.get("Name") + "";//index from 0 to 30
                }
                spinnerArrayAdapter = new ArrayAdapter<>
                        (IntroFragment.dialog.getContext(), android.R.layout.preference_category,
                                provinces); //selected item will look like a spinner set from XML
                spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                        .simple_spinner_dropdown_item);

            IntroFragment.StateSpinner.setAdapter(spinnerArrayAdapter);
//                done = true;
            IntroFragment.StateSpinner = IntroFragment.dialog.findViewById(R.id.StateSpinner);

        }catch(Exception ex){ex.printStackTrace();}
//        IntroFragment.textView2.setText(this.json_provinces);
//        IntroFragment.provinces = "Example Data";

    }

}
