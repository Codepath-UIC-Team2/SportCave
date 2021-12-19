package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sportcaveapp.R;

import java.util.List;

import models.BasketBall_Game;


public class BasketBallAdapter extends RecyclerView.Adapter<BasketBallAdapter.ViewHolder> {

        Context context;
        List<BasketBall_Game> matches;

public BasketBallAdapter(Context context, List<BasketBall_Game> matches) {
        this.context = context;
        this.matches = matches;
        }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View matchview = LayoutInflater.from(context).inflate(R.layout.item_basketball,viewGroup,false);
        return new ViewHolder(matchview);
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        BasketBall_Game match = matches.get(i);

        viewHolder.bind(match);

        }

@Override
public int getItemCount() {
        return matches.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder{
    TextView tv_location;
    ImageView iv_location;
    ImageView iv_team1;
    ImageView iv_team2;
    TextView tv_team1;
    TextView tv_team2;
    TextView tv_goals1_q1;
    TextView tv_goals1_q2;
    TextView tv_goals1_q3;
    TextView tv_goals1_q4;
    TextView tv_goals2_q1;
    TextView tv_goals2_q2;
    TextView tv_goals2_q3;
    TextView tv_goals2_q4;





    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_location = itemView.findViewById(R.id.tv_location);
        iv_location = itemView.findViewById(R.id.iv_location);
        iv_team1 = itemView.findViewById(R.id.iv_team1);
        iv_team2 = itemView.findViewById(R.id.iv_team2);
        tv_team1 = itemView.findViewById(R.id.tv_team1);
        tv_team2 = itemView.findViewById(R.id.tv_team2);

        tv_goals1_q1 = itemView.findViewById(R.id.tv_goals1_q1);
        tv_goals1_q2 = itemView.findViewById(R.id.tv_goals1_q2);
        tv_goals1_q3 = itemView.findViewById(R.id.tv_goals1_q3);
        tv_goals1_q4 = itemView.findViewById(R.id.tv_goals1_q4);

        tv_goals2_q1 = itemView.findViewById(R.id.tv_goals2_q1);
        tv_goals2_q2 = itemView.findViewById(R.id.tv_goals2_q2);
        tv_goals2_q3 = itemView.findViewById(R.id.tv_goals2_q3);
        tv_goals2_q4 = itemView.findViewById(R.id.tv_goals2_q4);



    }

    public void bind(BasketBall_Game match) {
        tv_team1.setText(match.getTeam1());
        tv_team2.setText(match.getTeam2());

        tv_goals1_q1.setText(match.getGoals1_q1());
        tv_goals1_q2.setText(match.getGoals1_q2());
        tv_goals1_q3.setText(match.getGoals1_q3());
        tv_goals1_q4.setText(match.getGoals1_q4());

        tv_goals2_q1.setText(match.getGoals2_q1());
        tv_goals2_q2.setText(match.getGoals2_q2());
        tv_goals2_q3.setText(match.getGoals2_q3());
        tv_goals2_q4.setText(match.getGoals2_q4());
        tv_location.setText(match.getLocation());




        Glide.with(context).load(match.getLogo1()).into(iv_team1);
        Glide.with(context).load(match.getLogo2()).into(iv_team2);
        Glide.with(context).load(match.getFlag()).into(iv_location);

    }
}
}

