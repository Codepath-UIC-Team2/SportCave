package com.example.sportcaveapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sportcaveapp.LoginActivity;
import com.example.sportcaveapp.R;
import com.parse.ParseUser;

import org.jetbrains.annotations.NotNull;

public class ProfileFragment extends Fragment {

    Button btnlogout;
    ParseUser currentUser;
    ImageView ivProfile;

    EditText fullname;
    TextView username;
    EditText email;
    Button btnUpdate;


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
        btnlogout = view.findViewById(R.id.btnLogout);
        ivProfile = view.findViewById(R.id.ivProfile);

        fullname = view.findViewById(R.id.tvName);
        username = view.findViewById(R.id.tvUsername);
        email = view.findViewById(R.id.tvEmail);
        btnUpdate = view.findViewById(R.id.btnUpdate);


        btnlogout.setOnClickListener(v -> {
            ParseUser.logOut();
            currentUser = ParseUser.getCurrentUser();
            System.out.println(currentUser);
            Intent i = new Intent(getContext(), LoginActivity.class);
            startActivity(i);
        });

        currentUser = ParseUser.getCurrentUser();

        fullname.setText(currentUser.get("profileName").toString());
//        System.out.println();
        username.setText("@"+currentUser.getUsername());
        email.setText(currentUser.getEmail());
//        Glide.with(getContext()).load(currentUser.getParseFile("profilePicture").getUrl()).into(ivProfile);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }




}