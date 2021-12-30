package models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Soccer_Game {
    String team1;
    String team2;
    String logo1;
    String logo2;
    String goals1;
    String goals2;
   // String match_location;
    public Soccer_Game(JSONObject jsonObject_home, JSONObject jsonObject_away , JSONObject jsonObject_goals) throws JSONException {
        team1 = jsonObject_home.getString("name");
        logo1 = jsonObject_home.getString("logo");
        team2 = jsonObject_away.getString("name");
        logo2 = jsonObject_away.getString("logo");
        goals1 = jsonObject_goals.getString("home");
        goals2 = jsonObject_goals.getString("away");



    }

    public String getLogo1() {
        return logo1;
    }

    public String getLogo2() {
        return logo2;
    }

    public String getGoals1() {
        return goals1;
    }

    public String getGoals2() {
        return goals2;
    }

    public String getTeam2() {
        return team2;
    }

    public String getTeam1() {
        return team1;
    }
}
