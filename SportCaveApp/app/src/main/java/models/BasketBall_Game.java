package models;

import org.json.JSONException;
import org.json.JSONObject;

public class BasketBall_Game {

    String team1;
    String team2;
    String logo1;
    String logo2;
    String goals1_q1;
    String goals2_q1;
    String goals1_q2;
    String goals2_q2;
    String goals1_q3;
    String goals2_q3;
    String goals1_q4;
    String goals2_q4;
    String goals1_total;
    String goals2_total;
    String location;
    String flag;


    // String match_location;
    public BasketBall_Game(JSONObject jsonObject_home, JSONObject jsonObject_away , JSONObject goalsHome,JSONObject goalsAway,JSONObject JSON_location) throws JSONException {
        team1 = jsonObject_home.getString("name");
        logo1 = jsonObject_home.getString("logo");
        team2 = jsonObject_away.getString("name");
        logo2 = jsonObject_away.getString("logo");
        location = JSON_location.getString("name");
        flag = JSON_location.getString("flag");
        goals1_q1 = goalsHome.getString("quarter_1");
        goals2_q1 = goalsAway.getString("quarter_1");
        goals1_q2 = goalsHome.getString("quarter_2");
        goals2_q2 = goalsAway.getString("quarter_2");
        goals1_q3 = goalsHome.getString("quarter_3");
        goals2_q3 = goalsAway.getString("quarter_3");
        goals1_q4 = goalsHome.getString("quarter_4");
        goals2_q4 = goalsAway.getString("quarter_4");
        goals1_total = goalsHome.getString("total");
        goals2_total = goalsAway.getString("total");




    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getLogo1() {
        return logo1;
    }

    public String getLogo2() {
        return logo2;
    }

    public String getGoals1_q1() {
        return goals1_q1;
    }

    public String getGoals2_q1() {
        return goals2_q1;
    }

    public String getGoals1_q2() {
        return goals1_q2;
    }

    public String getGoals2_q2() {
        return goals2_q2;
    }

    public String getGoals1_q3() {
        return goals1_q3;
    }

    public String getGoals2_q3() {
        return goals2_q3;
    }

    public String getGoals1_q4() {
        return goals1_q4;
    }

    public String getGoals2_q4() {
        return goals2_q4;
    }

    public String getGoals1_total() {
        return goals1_total;
    }

    public String getGoals2_total() {
        return goals2_total;
    }

    public String getLocation() {
        return location;
    }

    public String getFlag() {
        return flag;
    }

}
