package com.tgz.foosball.entity;

import com.tgz.foosball.entity.player.BallObserver;

/**
 * Created by priyanshu on 1/12/14.
 */
public interface Observable {


    public void addObserver(BallObserver ballObserver);

    public void notifyall();
}
