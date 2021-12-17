package com.example.sportcaveapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.sportcaveapp.fragments.ProfileFragment;
import com.example.sportcaveapp.fragments.SocialFragment;
import com.example.sportcaveapp.fragments.SportsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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