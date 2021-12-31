package com.example.sportcaveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

import models.Soccer_Game;

public class F1 extends AppCompatActivity {
    public static final String TAG = "F1";
    public static final String API_URL= "https://v1.formula-1.api-sports.io/";
    List<Soccer_Game> Drivers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f1);



    }
}