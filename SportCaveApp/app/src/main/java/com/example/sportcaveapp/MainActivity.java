package com.example.sportcaveapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_profile);
        ImageView ivProfile = findViewById(R.id.ivProfile);
        ivProfile.setImageResource(R.drawable.profile);

//        setContentView(R.layout.fragment_sports);
//
//        ImageView ivSport1 = findViewById(R.id.ivSport1);
//        ivSport1.setImageResource(R.drawable.basketball);
//        ImageView ivSport2 = findViewById(R.id.ivSport2);
//        ivSport2.setImageResource(R.drawable.baseball);
//        ImageView ivSport3 = findViewById(R.id.ivSport3);
//        ivSport3.setImageResource(R.drawable.soccer);
//        ImageView ivSport4 = findViewById(R.id.ivSport4);
//        ivSport4.setImageResource(R.drawable.cricket);
//        ImageView ivSport5 = findViewById(R.id.ivSport5);
//        ivSport5.setImageResource(R.drawable.football);
//        ImageView ivSport6 = findViewById(R.id.ivSport6);
//        ivSport6.setImageResource(R.drawable.golf);

    }

}