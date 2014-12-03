package com.tgz.foosball.entity.player;

import com.tgz.foosball.ashish.Team;
import com.tgz.foosball.entity.Ball;
import com.tgz.foosball.main.Game;

/**
 * Created by priyanshu on 3/12/14.
 */
public class GoalKeeper extends PlayerRole implements PlayerBehaviour {

    public GoalKeeper(Team team, Ball ball) {
        super(team, ball);
    }

    @Override
    public Player getNextPlayer() {
        int nextIndex = RANDOM.nextInt(team.defenderCount) + 1;
        return team.players[nextIndex];
    }

    @Override
    public double getplayerX() {
        if(team.oppositeTeamGoalPost.getX() < Game.WIDTH/2){
            return Game.WIDTH - team.oppositeTeamGoalPost.getX() - (double)team.oppositeTeamGoalPost.getWidth()/2;
        }else {
            return Game.WIDTH - team.oppositeTeamGoalPost.getX() + (double)team.oppositeTeamGoalPost.getWidth()/2;
        }
    }

    @Override
    public void performAction() {
        pass(getNextPlayer());
    }

    @Override
    public double getMeanY(int index) {
     //   System.out.println(team.oppositeTeamGoalPost.getY()+"jj");
        return team.oppositeTeamGoalPost.getY();
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public int getStartingIndex() {
        return 0;
    }

    @Override
    public int getSpeed() {
        return 0;
    }
}
