package com.tgz.foosball.entity.player;

import com.tgz.foosball.ashish.Team;

/**
 * Created by priyanshu on 1/12/14.
 */
public interface PlayerBehaviour {


    Player getNextPlayer(Team team);

    double getplayerX();

    public void performAction();

    void shoot();

    void pass();

    double getMeanY(int index, Team team);

    int getCount();

    int getStartingIndex();
}
