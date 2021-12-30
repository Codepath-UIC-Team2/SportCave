package com.example.sportcaveapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.sportcaveapp.fragments.ProfileFragment;
import com.example.sportcaveapp.fragments.SocialFragment;
import com.example.sportcaveapp.fragments.SportsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import models.Soccer_Game;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private BottomNavigationView bottomNavigationView;
    List <Soccer_Game> soccerGames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        final FragmentManager fragmentManager = getSupportFragmentManager();

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