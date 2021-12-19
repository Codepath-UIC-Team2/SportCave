package com.example.sportcaveapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestHeaders;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.sportcaveapp.fragments.ProfileFragment;
import com.example.sportcaveapp.fragments.SocialFragment;
import com.example.sportcaveapp.fragments.SportsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import models.Match;
import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {

    public static final String API_URL= " https://v3.football.api-sports.io/fixtures?live=all";
    public static final String TAG = "MainActivity";
    private BottomNavigationView bottomNavigationView;
    List <Match> matches;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        RequestHeaders requestHeaders = new RequestHeaders();

        matches = new ArrayList<>();

       requestHeaders.put("x-rapidapi-key", "dd27d337f8178a55f9009641fd988ee0");

        client.get(API_URL,requestHeaders,params,  new JsonHttpResponseHandler() {

                    @Override
                    public void onSuccess(int i, Headers headers, JSON json) {
                        Log.d(TAG,"Good to go");
                        Toast.makeText(MainActivity.this,"Success!", Toast.LENGTH_SHORT).show();
                        JSONObject jsonObject = json.jsonObject;

                        try {


                            JSONArray results = jsonObject.getJSONArray("response");

                            //Storing the information in arraylists
                            for (int j = 0; j < results.length(); j++)
                            {
                                // Creating Json objects and strings (used for Matches class)
                                JSONObject output = results.getJSONObject(j);
                                JSONObject gaols_obj = output.getJSONObject("goals");
                                JSONObject info = output.getJSONObject("teams");
                                JSONObject teams_home = info.getJSONObject("home");
                                JSONObject teams_away = info.getJSONObject("away");
                               // Saving the objects as type Match
                                Match m = new Match(teams_home,teams_away,gaols_obj);
                                matches.add(m);


                            }


                            Log.i(TAG,"Results " + results.length());
                            Log.i(TAG,"Results " + results.toString());
                            Log.i(TAG,"Matches all  " + matches.size());

                        } catch (JSONException e) {
                            Log.e(TAG,"Json issue");
                            e.printStackTrace();
                        }


                    }

                    @Override
                    public void onFailure(int i, Headers headers, String s, Throwable throwable) {
                        Log.d(TAG,"Not good at all");
                        Toast.makeText(MainActivity.this,"Bad!", Toast.LENGTH_SHORT).show();
                    }
                });

         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        // define your fragments here
//        final Fragment fragment1 = new FirstFragment();
//        final Fragment fragment2 = new SecondFragment();
//        final Fragment fragment3 = new ThirdFragment();

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment;

            switch (item.getItemId()){
                case R.id.action_home:
                    fragment = new SportsFragment();
                    break;
                case R.id.action_social:
                    fragment = new SocialFragment();
                    break;
                case R.id.action_profile:
                default:
                    fragment = new ProfileFragment();
                    break;
            }
            fragmentManager.beginTransaction().replace(R.id.flcontainer, fragment).commit();
            return true;
        });
        bottomNavigationView.setSelectedItemId(R.id.action_home);

    }

}