package com.example.sportcaveapp.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
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

import java.io.File;

public class ProfileFragment extends Fragment {

    ParseUser currentUser;
    ImageView ivProfile;
    Button btnImage;
    private File photoFile;
    public String photoFileName = "photo.jpg";
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
        btnImage = view.findViewById(R.id.btnImage);
        etName = view.findViewById(R.id.etName);
        tvUsername = view.findViewById(R.id.tvUsername);
        etEmail = view.findViewById(R.id.etEmail);
        etMySports = view.findViewById(R.id.etMySports);
        btnUpdate = view.findViewById(R.id.btnUpdate);
        btnLogout = view.findViewById(R.id.btnLogout);

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCamera();
            }
        });

        if (currentUser.getParseFile("profilePicture") != null) {
            Glide.with(getContext()).load(currentUser.getParseFile("profilePicture").getUrl()).into(ivProfile); }
        else {
            Glide.with(getContext()).load(R.drawable.profile).into(ivProfile); }
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
                if (photoFile != null) {
                    currentUser.put("profilePicture", new ParseFile(photoFile));
                }
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

    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    // check if user took photo
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // by this point we have the camera photo on disk
                        Bitmap takenImage = BitmapFactory.decodeFile(photoFile.getAbsolutePath());
                        // Load the taken image into a preview
                        ivProfile.setImageBitmap(takenImage);
                    } else { // Result was a failure
                        Toast.makeText(getContext(), "Picture wasn't taken!", Toast.LENGTH_SHORT).show();
                    }
                }
            });


    private void launchCamera() {
        // create Intent to take a picture and return control to the calling application
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Create a File reference for future access
        photoFile = getPhotoFileUri(photoFileName);

        // wrap File object into a content provider
        // Where to save taken image
        Uri fileProvider = FileProvider.getUriForFile(getContext(), "com.codepath.fileprovider.sportcaveapp", photoFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider);

        // Almost all phones have camera so will always be null
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            // Start the image capture intent to take photo
            someActivityResultLauncher.launch(intent);
        }
    }


    // Returns the File for a photo stored on disk given the fileName
    public File getPhotoFileUri(String fileName) {
        File mediaStorageDir = new File(getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES), TAG);

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()){
            Log.d(TAG, "failed to create directory"); }

        return new File(mediaStorageDir.getPath() + File.separator + fileName);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}