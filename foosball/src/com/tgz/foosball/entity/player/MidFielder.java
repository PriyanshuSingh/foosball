package com.tgz.foosball.entity.player;

import com.tgz.foosball.ashish.Team;
import com.tgz.foosball.entity.Ball;
import com.tgz.foosball.main.Game;

/**
 * Created by priyanshu on 1/12/14.
 */
public class MidFielder extends PlayerRole implements PlayerBehaviour {


    public MidFielder(Team team, Ball ball) {
        super(team, ball);
    }

    @Override
    public Player getNextPlayer() {
        int nextIndex = RANDOM.nextInt(team.attackerCount) + team.midfielderCount + team.defenderCount + 1;
        return team.players[nextIndex];
    }

    @Override
    public double getplayerX() {
        double x1 = team.oppositeTeamGoalPost.getX();
        double x2 = Game.WIDTH - x1;
        //System.out.println(x1+" "+x2);
        double barPos = 0;
        double totalSpace = Math.abs(x2-x1);
        barPos = totalSpace/(NO_POS_PLAYER*2 +1);

        if(team.AI){
            barPos = x2 - 3*barPos; // 3 define postion;
        }else {
            barPos = x2 + 3*barPos;
        }
        return barPos;
    }

    @Override
    public void performAction() {
        if(RANDOM.nextBoolean()) {
            pass(getNextPlayer());
        }else {
            shoot();
        }
    }

    @Override
    public double getMeanY(int index) {
        index = index - team.defenderCount;
        return index*(Game.HEIGHT/(team.midfielderCount+1));
    }

    @Override
    public int getCount() {
        return team.midfielderCount;
    }

    @Override
    public int getStartingIndex() {
        return team.defenderCount+1;
    }

    @Override
    public int getSpeed() {
        return 3;
    }
}
