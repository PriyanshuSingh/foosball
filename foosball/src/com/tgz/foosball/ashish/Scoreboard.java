package com.tgz.foosball.ashish;


import com.tgz.foosball.entity.GoalEvent;
import com.tgz.foosball.entity.GoalPost;
import com.tgz.foosball.gamestate.GoalEventListener;
import com.tgz.foosball.main.Game;

/**
 * Created by subodhyadav on 21/11/14.
 */
public class Scoreboard implements GoalEventListener {


    int team1Score = 0;
    int team2Score = 0;

    private void UpdateScore() {

    }

    @Override
    public void goalEventOccured(GoalEvent e) {
        if(((GoalPost)e.getSource()).getX() < Game.WIDTH/2){
            System.out.println("TEAM 2 goal");
            team2Score++;
        }else {
            System.out.println("TEAM 1 goal");
            team1Score++;
        }
    }
}
