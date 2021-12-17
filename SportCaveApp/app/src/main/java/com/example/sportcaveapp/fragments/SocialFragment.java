package com.example.sportcaveapp.fragments;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.sportcaveapp.MainActivity;
import com.example.sportcaveapp.R;
import com.example.sportcaveapp.Reaction;
import com.example.sportcaveapp.ReactionsAdapter;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SocialFragment extends Fragment {

    ParseUser currentUser;
    EditText etCompose;
    Button btnPost;
    ReactionsAdapter reactionsAdapter;

    public static final String TAG = "SocialFragment";
    private RecyclerView rvReactions;
    protected ReactionsAdapter adapter;
    protected List<Reaction> allReactions;

    public SocialFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_social, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        currentUser = ParseUser.getCurrentUser();
        etCompose = view.findViewById(R.id.etCompose);
        btnPost = view.findViewById(R.id.btnPost);
        rvReactions = view.findViewById(R.id.rvReactions);

        allReactions = new ArrayList<>();
        adapter = new ReactionsAdapter(getContext(), allReactions);
        rvReactions.setAdapter(adapter);
        rvReactions.setLayoutManager(new LinearLayoutManager(getContext()));
        queryReactions();

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String comment = etCompose.getText().toString();

                if (comment.isEmpty()) {
                    Toast.makeText(getContext(), "Comment is blank!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Reaction reaction = new Reaction();
                reaction.setComment(comment);
                reaction.setUser(currentUser);
                reaction.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e != null) {
                            Log.e(TAG, "Error while posting!", e);
                            Toast.makeText(getContext(), "Error while posting!", Toast.LENGTH_SHORT).show();
                        } else {
                        Log.i(TAG, "Reaction posted successfully!");
                        Toast.makeText(getContext(), "Reaction posted successfully!", Toast.LENGTH_SHORT).show(); }
                        etCompose.setText("");
                    }
                });
            }
        });
    }

    protected void queryReactions() {
        ParseQuery<Reaction> query = ParseQuery.getQuery(Reaction.class);
        query.include(Reaction.KEY_USER);
        query.addDescendingOrder(Reaction.KEY_CREATED_KEY);
        query.findInBackground(new FindCallback<Reaction>() {
            @Override
            public void done(List<Reaction> reactions, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Error retrieving comments!", e);
                    return;
                }
                for (Reaction reaction : reactions) {
                    Log.i(TAG, "Reaction: " + reaction.getComment() + ", username: " + reaction.getUser().getUsername());
                }
                allReactions.addAll(reactions);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.options_menu, menu);
    }

}