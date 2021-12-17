package com.example.sportcaveapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;
import com.parse.ParseUser;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ReactionsAdapter extends RecyclerView.Adapter<ReactionsAdapter.ViewHolder> {

    private Context context;
    private List<Reaction> reactions;

    public ReactionsAdapter(Context context, List<Reaction> reactions) {
        this.context = context;
        this.reactions = reactions;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_reaction, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Reaction reaction = reactions.get(position);
        holder.bind(reaction);
    }

    @Override
    public int getItemCount() {
        return reactions.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivProfileImage;
        private TextView tvUser;
        private TextView tvName;
        private TextView tvComment;
        private TextView tvCreatedAt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvUser = itemView.findViewById(R.id.tvUser);
            tvName = itemView.findViewById(R.id.tvName);
            tvComment = itemView.findViewById(R.id.tvComment);
            tvCreatedAt = itemView.findViewById(R.id.tvCreatedAt);
        }

        public void bind(Reaction reaction) {
            tvUser.setText("@"+reaction.getUser().getUsername());
            tvName.setText(reaction.getUser().get("profileName").toString());
            tvComment.setText(reaction.getComment());
            tvCreatedAt.setText(TimeFormatter.getTimeDifference(reaction.getCreatedAt().toString()));
            if (reaction.getUser().getParseFile("profilePicture") != null) {
                Glide.with(context).load(reaction.getUser().getParseFile("profilePicture").getUrl()).into(ivProfileImage); }
            else {
                Glide.with(context).load(R.drawable.profile).into(ivProfileImage); }
        }
    }
}
