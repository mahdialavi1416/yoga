package com.technologygroup.rayannoor.yoga.Services;

import android.util.Log;

import com.technologygroup.rayannoor.yoga.Classes.App;
import com.technologygroup.rayannoor.yoga.Models.CoachEduModel;
import com.technologygroup.rayannoor.yoga.Models.CoachGymsModel;
import com.technologygroup.rayannoor.yoga.Models.CoachHonorModel;
import com.technologygroup.rayannoor.yoga.Models.CoachModel;
import com.technologygroup.rayannoor.yoga.Models.CoachResumeModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by EHSAN on 3/1/2018.
 */

public class WebService {

    private String connectToServer(String address, String RequestMethod) {
        try {
            URL url = new URL(address);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod(RequestMethod);
            return inputStreamToString(urlConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String connectToServerByJson(String address, String requestMethod, String JsonDATA) {

        String JsonResponse = null;

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(address);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            // is output buffer writter
            urlConnection.setRequestMethod(requestMethod);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Accept", "application/json");
//set headers and method
            Writer writer = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
            writer.write(JsonDATA);
// json data
            writer.close();
            InputStream inputStream = urlConnection.getInputStream();
//input stream
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String inputLine;
            while ((inputLine = reader.readLine()) != null)
                buffer.append(inputLine);
            if (buffer.length() == 0) {
                // Stream was empty. No point in parsing.
                return null;
            }
            JsonResponse = buffer.toString();
//response data
            Log.i(TAG, JsonResponse);
            //send to post execute
            return JsonResponse;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e(TAG, "Error closing stream", e);
                }
            }
        }
        return null;

    }

    private String inputStreamToString(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String nextLine;
        try {
            while ((nextLine = reader.readLine()) != null) {
                stringBuilder.append(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    public CoachModel getCoachInfo(boolean isInternetAvailable, int id) {

        if (isInternetAvailable) {

            String response = connectToServer(App.apiAddr + "coach/select/" + id, "GET");
            Log.i("LOG", response + "");

            if (response != null) {

                CoachModel model = new CoachModel();

                try {

                    JSONArray Arrey = new JSONArray(response);

                    JSONObject Object = Arrey.getJSONObject(0);

                    model.Email = Object.getString("Email");
                    model.fName = Object.getString("fName");
                    model.Instagram = Object.getString("Instagram");
                    model.lName = Object.getString("lName");
                    model.Telegram = Object.getString("Telegram");
                    model.Img = Object.getString("Img");
                    model.id = Object.getInt("id");
                    model.idCity = Object.getInt("idCity");
                    model.idCurrentPlan = Object.getInt("idCurrentPlan");
                    model.like = Object.getInt("like");
                    model.lastUpdate = Object.getString("lastUpdate");
                    model.Mobile = Object.getString("Mobile");
                    model.natCode = Object.getString("natCode");
                    model.Rate = Object.getDouble("Rate");


                    return model;
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            return null;

        } else
            return null;
    }

    public List<CoachEduModel> getCoachEdu(boolean isInternetAvailable, int id) {

        if (isInternetAvailable) {

            String response = connectToServer(App.apiAddr + "EducationalRecord/select/" + id, "GET");
            Log.i("LOG", response + "");

            if (response != null) {

                List<CoachEduModel> list = new ArrayList<>();

                try {

                    JSONArray Arrey = new JSONArray(response);
                    for (int i = 0; i < Arrey.length(); i++) {
                        JSONObject Object = Arrey.getJSONObject(i);
                        CoachEduModel model = new CoachEduModel();

                        model.id = Object.getInt("id");
                        model.Date = Object.getString("Date");
                        model.lastUpdate = Object.getString("lastUpdate");
                        model.idCoach = Object.getInt("idCoach");
                        model.Name = Object.getString("Name");
                        model.CoachName = Object.getString("CoachName");
                        model.Img = Object.getString("Img");

                        list.add(model);

                    }
                    return list;
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            return null;

        } else
            return null;
    }

    public List<CoachHonorModel> getCoachHonor(boolean isInternetAvailable, int id) {

        if (isInternetAvailable) {

            String response = connectToServer(App.apiAddr + "honor/SelectCoachHonorrs/" + id, "GET");
            Log.i("LOG", response + "");

            if (response != null) {

                List<CoachHonorModel> list = new ArrayList<>();

                try {

                    JSONArray Arrey = new JSONArray(response);
                    for (int i = 0; i < Arrey.length(); i++) {
                        JSONObject Object = Arrey.getJSONObject(i);
                        CoachHonorModel model = new CoachHonorModel();

                        model.id = Object.getInt("id");
                        model.Date = Object.getString("Date");
                        model.lastUpdate = Object.getString("lastUpdate");
                        model.idRow = Object.getInt("idRow");
                        model.Name = Object.getString("Name");
                        model.Title = Object.getString("Title");
                        model.Img = Object.getString("Img");
                        model.Des = Object.getString("Des");
                        model.isGym = Object.getBoolean("isGym");

                        list.add(model);

                    }
                    return list;
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            return null;

        } else
            return null;
    }

    public List<CoachResumeModel> getCoachResume(boolean isInternetAvailable, int id) {

        if (isInternetAvailable) {

            String response = connectToServer(App.apiAddr + "resume/select/" + id, "GET");
            Log.i("LOG", response + "");

            if (response != null) {

                List<CoachResumeModel> list = new ArrayList<>();

                try {

                    JSONArray Arrey = new JSONArray(response);
                    for (int i = 0; i < Arrey.length(); i++) {
                        JSONObject Object = Arrey.getJSONObject(i);
                        CoachResumeModel model = new CoachResumeModel();

                        model.id = Object.getInt("id");
                        model.endDate = Object.getString("endDate");
                        model.lastUpdate = Object.getString("lastUpdate");
                        model.idCoach = Object.getInt("idCoach");
                        model.Name = Object.getString("Name");
                        model.startDate = Object.getString("startDate");
                        model.Title = Object.getString("Title");

                        list.add(model);

                    }
                    return list;
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            return null;

        } else
            return null;
    }

    public CoachModel[] getCoaches(boolean isInternetAvailable) {

        if (isInternetAvailable) {

            String response = connectToServer(App.apiAddr + "Coach/SelectList", "GET");
            Log.i("LOG", response + "");

            if (response != null) {

                //List<CoachModel> list = new ArrayList<>();
                CoachModel model[];

                try {

                    JSONArray Array = new JSONArray(response);
                    model = new CoachModel[Array.length()];

                    for (int i = 0; i < Array.length(); i++) {

                        JSONObject Object = Array.getJSONObject(i);
                        //CoachModel model = new CoachModel();
                        model[i] = new CoachModel();
                        model[i].Email         = Object.getString("Email");
                        model[i].id            = Object.getInt("id");
                        model[i].fName         = Object.getString("fName");
                        model[i].idCity        = Object.getInt("idCity");
                        model[i].idCurrentPlan = Object.getInt("idCurrentPlan");
                        model[i].Instagram     = Object.getString("Instagram");
                        model[i].lastUpdate    = Object.getString("lastUpdate");
                        model[i].like          = Object.getInt("like");
                        model[i].lName         = Object.getString("lName");
                        model[i].Mobile        = Object.getString("Mobile");
                        model[i].natCode       = Object.getString("natCode");
                        model[i].Rate          = Object.getDouble("Rate");
                        model[i].Telegram      = Object.getString("Telegram");
                        model[i].Img           = Object.getString("Img");
                        //list.add(model);

                    }
                    return model;
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            return null;
        } else
            return null;
    }

    public CoachGymsModel[] getGyms(boolean isInternetAvailable) {

        if (isInternetAvailable) {

            String response = connectToServer(App.apiAddr + "gym/selectlist", "GET");
            Log.i("LOG", response + "");

            if (response != null) {

                //List<CoachModel> list = new ArrayList<>();
                CoachGymsModel model[];

                try {

                    JSONArray Array = new JSONArray(response);
                    model = new CoachGymsModel[Array.length()];

                    for (int i = 0; i < Array.length(); i++) {

                        JSONObject Object = Array.getJSONObject(i);
                        model[i] = new CoachGymsModel();

                        model[i].id            = Object.getInt("id");
                        model[i].like          = Object.getInt("like");
                        model[i].Rate          = Object.getDouble("Rate");
//                        model[i].Img           = Object.getString("Img");
                        model[i].Name = "default";
                    }
                    return model;
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            return null;
        } else
            return null;
    }
}