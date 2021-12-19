package com.example.sportcaveapp.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sportcaveapp.Basketball;
import com.example.sportcaveapp.Football;
import com.example.sportcaveapp.LoginActivity;
import com.example.sportcaveapp.MainActivity;
import com.example.sportcaveapp.R;

import org.jetbrains.annotations.NotNull;

public class SportsFragment extends Fragment {

    ImageView ivSport1;
    ImageView ivSport2;
    ImageView ivSport3;
    ImageView ivSport4;
    ImageView ivSport5;
    ImageView ivSport6;


    public SportsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivSport1 = view.findViewById(R.id.ivSport1);
        ivSport2 = view.findViewById(R.id.ivSport2);
        ivSport3 = view.findViewById(R.id.ivSport3);
        ivSport4 = view.findViewById(R.id.ivSport4);
        ivSport5 = view.findViewById(R.id.ivSport5);
        ivSport6 = view.findViewById(R.id.ivSport6);

        ivSport1.setImageResource(R.drawable.basketball);
        ivSport2.setImageResource(R.drawable.baseball);
        ivSport3.setImageResource(R.drawable.soccer);
        ivSport4.setImageResource(R.drawable.cricket);
        ivSport5.setImageResource(R.drawable.football);
        ivSport6.setImageResource(R.drawable.golf);


        ivSport3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int color = Color.parseColor("#ff0000"); //The color u want
                ivSport3.setBackgroundColor(color);
                gotoFootball();

            }
        });

        ivSport1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int color = Color.parseColor("#ff0000"); //The color u want
                ivSport1.setBackgroundColor(color);
                gotoBasketball();

            }
        });
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sports, container, false);



    }

    private void gotoFootball() {
        Intent intent = new Intent(getContext(), Football.class);
        startActivity(intent);
    }
    private void gotoBasketball() {
        Intent intent = new Intent(getContext(), Basketball.class);
        startActivity(intent);
    }


}