package com.example.sportcaveapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestHeaders;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import Adapters.BasketBallAdapter;
import models.BasketBall_Game;
import okhttp3.Headers;

public class Basketball extends AppCompatActivity {
    public static final String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

    public static final String API_URL= " https://v1.basketball.api-sports.io/games?date="+ date;
    List<BasketBall_Game> games;

    public static final String TAG = "Basketball";
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball);
        Log.i(TAG,"Date today is "+date);

        RecyclerView Rec = findViewById(R.id.rv);
        games = new ArrayList<>();
        BasketBallAdapter matchAdapter =  new BasketBallAdapter(this,games);
        Rec.setAdapter(matchAdapter);
        Rec.setLayoutManager(new LinearLayoutManager(this));

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        RequestHeaders requestHeaders = new RequestHeaders();

        requestHeaders.put("x-rapidapi-key", "dd27d337f8178a55f9009641fd988ee0");

        client.get(API_URL,requestHeaders,params,  new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int i, Headers headers, JSON json) {
                Log.d(TAG,"Good to go");
                JSONObject jsonObject = json.jsonObject;

                try {
                    JSONArray results = jsonObject.getJSONArray("response");

                    //Storing the information in arraylists
                    for (int j = 0; j < results.length(); j++)
                    {
                         //Creating Json objects and strings (used for Matches class)
                        JSONObject output = results.getJSONObject(j);
                        JSONObject location = output.getJSONObject("country");
                        JSONObject gaols_obj = output.getJSONObject("scores");
                        JSONObject goals_home = gaols_obj.getJSONObject("home");
                        JSONObject goals_away = gaols_obj.getJSONObject("away");
                        JSONObject info = output.getJSONObject("teams");
                        JSONObject teams_home = info.getJSONObject("home");
                        JSONObject teams_away = info.getJSONObject("away");
                        // Saving the objects as type Soccer_Game
                        BasketBall_Game m = new BasketBall_Game(teams_home,teams_away,goals_home,goals_away,location);
                        games.add(m);
                    }

                    matchAdapter.notifyDataSetChanged();

                    Log.i(TAG,"Results " + results.length());
                    Log.i(TAG,"Results " + results.toString());
                    Log.i(TAG,"Matches all  " + games.get(0));

                } catch (JSONException e) {
                    Log.e(TAG,"Json issue");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int i, Headers headers, String s, Throwable throwable) {
                Log.d(TAG,"Not good at all");
                Toast.makeText(Basketball.this,"Bad!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}