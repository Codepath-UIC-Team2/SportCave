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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sportcaveapp.Basketball;
import com.example.sportcaveapp.Football;
import com.example.sportcaveapp.LoginActivity;
import com.example.sportcaveapp.MainActivity;
import com.example.sportcaveapp.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SportsFragment extends Fragment {

    ImageView ivSport1;
    ImageView ivSport2;
    ImageView ivSport3;
    ImageView ivSport4;
    ImageView ivSport5;
    ImageView ivSport6;
    int color;
    ParseUser currentUser;
    Button favBasketball;
    Button favF1;
    Button favSoccer;
    Button favCricket;
    Button favFootball;
    Button favGolf;

    public static final String TAG = "SportsFragment";

    public SportsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        currentUser = ParseUser.getCurrentUser();

        ivSport1 = view.findViewById(R.id.ivSport1);
        ivSport2 = view.findViewById(R.id.ivSport2);
        ivSport3 = view.findViewById(R.id.ivSport3);
        ivSport4 = view.findViewById(R.id.ivSport4);
        ivSport5 = view.findViewById(R.id.ivSport5);
        ivSport6 = view.findViewById(R.id.ivSport6);

        ivSport1.setImageResource(R.drawable.basketball);
        ivSport2.setImageResource(R.drawable.f1_pic);
        ivSport3.setImageResource(R.drawable.soccer);
        ivSport4.setImageResource(R.drawable.cricket);
        ivSport5.setImageResource(R.drawable.football);
        ivSport6.setImageResource(R.drawable.golf);

        ivSport3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoFootball();
            }
        });

        ivSport1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoBasketball();
            }
        });

        favBasketball = view.findViewById(R.id.favBasketball);
        favF1 = view.findViewById(R.id.favF1);
        favSoccer = view.findViewById(R.id.favSoccer);
        favCricket = view.findViewById(R.id.favCricket);
        favFootball = view.findViewById(R.id.favFootball);
        favGolf = view.findViewById(R.id.favGolf);

        favBasketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fav = "Basketball";
                favSport(fav);
            }
        });

        favF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fav = "F1";
                favSport(fav);
            }
        });

        favSoccer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fav = "Soccer";
                favSport(fav);
            }
        });

        favCricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fav = "Cricket";
                favSport(fav);
            }
        });

        favFootball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fav = "Football";
                favSport(fav);
            }
        });

        favGolf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fav = "Golf";
                favSport(fav);
            }
        });

    }

    private void favSport(String fav) {
        if (!currentUser.getList("mySports").contains(fav)) {
            currentUser.add("mySports", fav);
            currentUser.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e != null) {
                        Log.e(TAG, "Error while adding to favorite sports!", e);
                        Toast.makeText(getContext(), "Error while adding to favorite sports!", Toast.LENGTH_SHORT).show();
                    }
                    Log.i(TAG, "Added to favorite sports!");
                    Toast.makeText(getContext(), "Added to favorite sports!", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            List lstMySports = currentUser.getList("mySports");
            lstMySports.remove(fav);
            currentUser.put("mySports", lstMySports);
            currentUser.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e != null) {
                        Log.e(TAG, "Error while removing from favorite sports!", e);
                        Toast.makeText(getContext(), "Error while removing from favorite sports!", Toast.LENGTH_SHORT).show();
                    }
                    Log.i(TAG, "Removed from favorite sports!");
                    Toast.makeText(getContext(), "Removed from favorite sports!", Toast.LENGTH_SHORT).show();
                }
            });
        }
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