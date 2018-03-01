package com.technologygroup.rayannoor.yoga;

import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.technologygroup.rayannoor.yoga.IntroPage.IntroFragment;

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

public class fetchDataCity extends AsyncTask<Integer, Void, String[]> {

    private String json_pure_cities = "";
    private String[] cities;
    ArrayAdapter<String> spinnerArrayAdapter2;

    int stateCode = 0;//default

    public fetchDataCity(int stateCode) {
        this.stateCode = stateCode;
    }

    @Override

    protected String[] doInBackground(Integer... integers) {
        try{
            URL json_url_city = new URL("http://yuga.gsharing.ir/api/city/select/" + stateCode);
            HttpURLConnection httpURLConnection = (HttpURLConnection) json_url_city.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                json_pure_cities += line;
            }

        }catch (Exception ex){ex.printStackTrace();}
        return cities;
    }

    @Override
    protected void onPostExecute(String[] strings) {
        try {
            JSONArray jsonArray = new JSONArray(json_pure_cities);
            cities = new String[jsonArray.length()];//probably 31 home
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject provinceObject = (JSONObject) jsonArray.get(i);
                cities[i] = provinceObject.get("Name") + "";//index from 0 to 30
            }
            spinnerArrayAdapter2 = new ArrayAdapter<>
                    (IntroFragment.dialog.getContext(), android.R.layout.preference_category,
                            cities); //selected item will look like a spinner set from XML
            spinnerArrayAdapter2.setDropDownViewResource(android.R.layout
                    .simple_spinner_dropdown_item);

            IntroFragment.CitySpinner.setAdapter(spinnerArrayAdapter2);
//                done = true;
            IntroFragment.StateSpinner = IntroFragment.dialog.findViewById(R.id.CitySpinner);

        }catch(Exception ex){ex.printStackTrace();}
        super.onPostExecute(strings);
    }
}
