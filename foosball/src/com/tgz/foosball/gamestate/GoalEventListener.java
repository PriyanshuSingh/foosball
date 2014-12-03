package com.tgz.foosball.gamestate;

import com.tgz.foosball.entity.GoalEvent;

import java.util.EventListener;

/**
 * Created by priyanshu on 2/12/14.
 */
public interface GoalEventListener extends EventListener{

    public void goalEventOccured(GoalEvent e);
}
