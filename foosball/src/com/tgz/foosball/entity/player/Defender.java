package com.tgz.foosball.entity.player;

import com.tgz.foosball.ashish.Team;

/**
 * Created by priyanshu on 1/12/14.
 */
public class Defender implements PlayerBehaviour {

    @Override
    public Player getNextPlayer(Team team) {
        return null;
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
}
