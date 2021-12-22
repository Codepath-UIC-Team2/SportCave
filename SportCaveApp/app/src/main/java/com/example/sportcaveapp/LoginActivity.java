package com.example.sportcaveapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    TextView titleTV;
    EditText username;
    EditText password;
    Button signIn;
    TextView signUp;

    String usernameID;
    String userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

      //  goMainActivity();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        // if signed in, don't show login screen on app restart
        if (ParseUser.getCurrentUser() != null) {
            goMainActivity();
        }

        titleTV = (TextView) findViewById(R.id.signinTextview);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        signIn = (Button) findViewById(R.id.btnSignin);
        signUp = (TextView) findViewById(R.id.btnSignup);

        signUp.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), signup.class);
            startActivity(intent);
        });

        signIn.setOnClickListener(v -> {
            usernameID = username.getText().toString();
            userPassword = password.getText().toString();

            if (usernameID.isEmpty() || userPassword.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please fill all fields!", Toast.LENGTH_SHORT).show();
            }

            loginUser(usernameID, userPassword);
        });

    }

    private void loginUser(String usernameID, String userPassword) {

        ParseUser.logInInBackground(usernameID, userPassword, new LogInCallback(){
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e != null){
                    System.out.println("error");
                    Toast.makeText(getApplicationContext(), "Unable to sign in!", Toast.LENGTH_SHORT).show();
                    return;
                }
                goMainActivity();
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
