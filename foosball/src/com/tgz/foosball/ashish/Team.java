package com.tgz.foosball.ashish;

import com.tgz.foosball.entity.player.Player;

/**
 * Created by subodhyadav on 21/11/14.
 */
public class Team {

    public Player[] players;

    public int defenderCount;
    public int midfielderCount;
    public int AttackerCount;
    public boolean AI;

    public Team(){
        players = new Player[11];
    }

    public void init(boolean AI,int defenderCount, int midfielderCount, int attackerCount){
        //intitialize all players here
    }



}
