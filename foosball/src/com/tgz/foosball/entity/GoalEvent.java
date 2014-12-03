package com.tgz.foosball.entity;

import java.util.EventObject;

/**
 * Created by priyanshu on 2/12/14.
 */
public class GoalEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public GoalEvent(Object source) {
        super(source);
    }


}
