package com.tgz.foosball.entity;

import com.tgz.foosball.gamestate.GoalEventListener;
import com.tgz.foosball.gfx.Screen;
import com.tgz.foosball.main.Game;

import javax.swing.event.EventListenerList;

/**
 * Created by priyanshu on 2/12/14.
 */
public class GoalPost extends GameObject {

    // set them
    public static final int HEIGHT = 144;
    public static final int WIDTH = 24;
    public static final int Y = 180;

    private EventListenerList goalEventListenerList;

    public GoalPost(int x){

        setWidth(WIDTH);
        setHeight(HEIGHT);
        this.x = x;

        this.y = Y;
        //System.out.println(y+"fuck");
        goalEventListenerList = new EventListenerList();

    }

    public void addGoalEventListener(GoalEventListener goalEventListener){
        goalEventListenerList.add(GoalEventListener.class,goalEventListener);
    }

    public void removeGoalEventListener(GoalEventListener goalEventListener){
        goalEventListenerList.remove(GoalEventListener.class,goalEventListener);
    }

    void fireGoalEvent(GoalEvent evt){
        Object[] listeners = goalEventListenerList.getListenerList();
        for(int i=0; i<listeners.length; i += 2){
            if(listeners[i] == GoalEvent.class){
                ((GoalEventListener) listeners[i+1]).goalEventOccured(evt);
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if(this.intersects(Ball.getBall())){
            fireGoalEvent(new GoalEvent(this));
        }

    }


    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }
}
