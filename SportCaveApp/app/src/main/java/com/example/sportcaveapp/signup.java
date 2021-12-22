package com.example.sportcaveapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;
import com.parse.SignUpCallback;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class signup extends AppCompatActivity {

    TextView titleTV;
    EditText username;
    EditText email;
    EditText name;
    EditText password;
    Button cancel;
    Button signUp;

    public static final String TAG = "SignUP";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        titleTV = (TextView) findViewById(R.id.signupTextview);
        name = (EditText) findViewById(R.id.fullname);
        username = (EditText) findViewById(R.id.SignUPusername);
        password = (EditText) findViewById(R.id.SignUPpassword);
        email = (EditText) findViewById(R.id.SignUPemail);
        signUp = (Button) findViewById(R.id.btnSignup);
        cancel = (Button) findViewById(R.id.btnCancel);


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the ParseUser
                ParseUser user = new ParseUser();
                String userName = username.getText().toString();
                String pass = password.getText().toString();
                String userEmail = email.getText().toString();
                String userFullname = name.getText().toString();

                if (userName.isEmpty() || pass.isEmpty() || userFullname.isEmpty() || userEmail.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill all fields!", Toast.LENGTH_SHORT).show();
                }

                user.setUsername(userName);
                user.setPassword(pass);
                user.setEmail(userEmail);
                user.put("profileName", userFullname);
                user.put("favSports", "Add your favorite sports here!");

                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            // Hooray! Let them use the app now.
                            goMainActivity();

                        } else {
                            // Sign up didn't succeed. Look at the ParseException to figure out what went wrong
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Unable to sign up!", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
            }
        });
    }

    private void goMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        // finish login activity after navigating away, unavailable in backstack
        finish();
    }
}

