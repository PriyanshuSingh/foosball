package com.tgz.foosball.entity.player;

import com.tgz.foosball.ashish.Team;
import com.tgz.foosball.entity.Ball;
import com.tgz.foosball.main.Game;

import java.util.Random;

/**
 * Created by priyanshu on 1/12/14.
 */
public class Defender extends PlayerRole implements PlayerBehaviour {


    public Defender(Team team, Ball ball) {
        super(team, ball);
    }

    @Override
    public Player getNextPlayer() {
        int nextIndex = RANDOM.nextInt(team.midfielderCount) + team.defenderCount +1;
        return team.players[nextIndex];
    }

    @Override
    public double getplayerX() {
        double x1 = team.oppositeTeamGoalPost.getX();
        double x2 = Game.WIDTH - x1;
        double barPos = 0;
        double totalSpace = Math.abs(x2-x1);
        barPos = totalSpace/(NO_POS_PLAYER*2 +1);
        barPos = 1*barPos + x2;
        if(team.AI){
            barPos = Game.WIDTH - barPos;
        }
        return barPos;
    }

    @Override
    public void performAction() {
        System.out.println("defe");
        pass(getNextPlayer());
    }

    @Override
    public double getMeanY(int index) {
        return index*(Game.HEIGHT/(team.defenderCount+1));
    }

    @Override
    public int getCount() {
        return team.defenderCount;
    }

    @Override
    public int getStartingIndex() {
        return 1;
    }
}
