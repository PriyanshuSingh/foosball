package com.tgz.foosball.entity.player;

import com.tgz.foosball.ashish.Team;

/**
 * Created by priyanshu on 1/12/14.
 */
public class Attacker implements PlayerBehaviour {

    @Override
    public Player getNextPlayer(Team team) {
        return null;
    }

    @Override
    public double getplayerX() {
        return 0;
    }

    @Override
    public void performAction() {

    }

    @Override
    public void shoot() {

    }

    @Override
    public void pass() {

    }

    @Override
    public double getMeanY(int index, Team team) {
        return 0;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public int getStartingIndex() {
        return 0;
    }
}
