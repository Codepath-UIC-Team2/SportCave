package com.example.sportcaveapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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


}