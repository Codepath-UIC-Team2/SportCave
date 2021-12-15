package com.example.sportcaveapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.sportcaveapp.LoginActivity;
import com.example.sportcaveapp.R;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.jetbrains.annotations.NotNull;

public class ProfileFragment extends Fragment {

    ParseUser currentUser;
    ImageView ivProfile;
    EditText etName;
    TextView tvUsername;
    EditText etEmail;
    EditText etMySports;
    Button btnUpdate;
    Button btnLogout;

    public static final String TAG = "ProfileFragment";

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        currentUser = ParseUser.getCurrentUser();
        ivProfile = view.findViewById(R.id.ivProfile);
        etName = view.findViewById(R.id.etName);
        tvUsername = view.findViewById(R.id.tvUsername);
        etEmail = view.findViewById(R.id.etEmail);
        etMySports = view.findViewById(R.id.etMySports);
        btnUpdate = view.findViewById(R.id.btnUpdate);
        btnLogout = view.findViewById(R.id.btnLogout);


//        Glide.with(getContext()).load(currentUser.getParseFile("profilePicture").getUrl()).into(ivProfile);
        etName.setText(currentUser.get("profileName").toString());
        tvUsername.setText("@"+currentUser.getUsername());
        etEmail.setText(currentUser.getEmail());
        etMySports.setText(currentUser.get("favSports").toString());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = etName.getText().toString();
                String Email = etEmail.getText().toString();
                String MySports = etMySports.getText().toString();
                currentUser = ParseUser.getCurrentUser();
                currentUser.put("profileName", Name);
                currentUser.setEmail(Email);
                currentUser.put("favSports", MySports);
                currentUser.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e != null) {
                            Log.e(TAG, "Error while updating!", e);
                            Toast.makeText(getContext(), "Error while updating!", Toast.LENGTH_SHORT).show();
                        }
                        Log.i(TAG, "Profile successfully updated!");
                        Toast.makeText(getContext(), "Profile successfully updated!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btnLogout.setOnClickListener(v -> {
            ParseUser.logOut();
            currentUser = ParseUser.getCurrentUser();
            System.out.println(currentUser);
            Intent i = new Intent(getContext(), LoginActivity.class);
            startActivity(i);
        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}