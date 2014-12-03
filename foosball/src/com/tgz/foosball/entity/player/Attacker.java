package com.tgz.foosball.entity.player;

import com.tgz.foosball.ashish.Team;
import com.tgz.foosball.entity.Ball;
import com.tgz.foosball.main.Game;

/**
 * Created by priyanshu on 1/12/14.
 */
public class Attacker extends PlayerRole  implements PlayerBehaviour {



    public Attacker(Team team, Ball ball) {
        super(team, ball);
    }

    @Override
    public Player getNextPlayer() {
        return null;
    }

    @Override
    public double getplayerX() {
        double x1 = team.oppositeTeamGoalPost.getX();
        double x2 = Game.WIDTH - x1;
        double barPos = 0;
        double totalSpace = Math.abs(x2-x1);
        barPos = totalSpace/(NO_POS_PLAYER*2 +1);
        if(team.AI){
            barPos = x2 - 5*barPos; // 3 define postion;
        }else {
            barPos = x2 + 5*barPos;
        }
        return barPos;
    }

    @Override
    public void performAction() {
        shoot();
    }

    @Override
    public double getMeanY(int index) {
        index = index - team.defenderCount - team.midfielderCount;
        return index*(Game.HEIGHT/(team.attackerCount+1));
    }

    @Override
    public int getCount() {
        return team.attackerCount;
    }

    @Override
    public int getStartingIndex() {
        return team.midfielderCount+team.defenderCount+1;
    }

    @Override
    public int getSpeed() {
        return 0;
    }
}
