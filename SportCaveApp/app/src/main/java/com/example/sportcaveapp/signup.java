package com.example.sportcaveapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class signup extends AppCompatActivity {

    TextView titleTV;
    EditText username;
    EditText email;
    EditText name;
    EditText password;
    Button cancel;
    Button signUp;

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
    }
}

