package com.tgz.foosball.entity.player;

import com.tgz.foosball.ashish.Team;
import com.tgz.foosball.entity.Ball;


/**
 * Created by priyanshu on 1/12/14.
 */
public interface PlayerBehaviour {

    Player getNextPlayer();

    double getplayerX();

    public void performAction();

    double getMeanY(int index);

    int getCount();

    int getStartingIndex();
}
