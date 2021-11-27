package com.example.sportcaveapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("JcHo1ixhXeij62mWqJVwuABZn5lO3J2EZnVfscLe")
                .clientKey("BVSpBGomWrYeUri5qtS5av9UQXIamG8tKBf9mUCo")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
