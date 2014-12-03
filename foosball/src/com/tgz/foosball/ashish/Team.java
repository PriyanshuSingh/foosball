package com.tgz.foosball.ashish;

import com.tgz.foosball.entity.player.Player;
import com.tgz.foosball.main.GameInput;

/**
 * Created by subodhyadav on 21/11/14.
 */
public class Team {

    public Player[] players;

    public int defenderCount;
    public int midfielderCount;
    public int AttackerCount;
    public boolean AI;
    public GameInput input;

    public Team(GameInput input){
        players = new Player[11];
        this.input =  input;
    }

    public void init(boolean AI,int defenderCount, int midfielderCount, int attackerCount){
        //intitialize all players here

    }



}
