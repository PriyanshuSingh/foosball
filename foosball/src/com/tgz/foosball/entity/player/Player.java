package com.tgz.foosball.entity.player;

import com.tgz.foosball.ashish.Team;
import com.tgz.foosball.entity.Ball;
import com.tgz.foosball.entity.GameObject;
import com.tgz.foosball.gfx.SpriteStore;
import com.tgz.foosball.main.GameInput;

public class Player extends GameObject implements BallObserver {

    // constrained in different bars
    private double maxY, minY;
    private boolean AI;
    private PlayerBehaviour playerBehaviour;
    private Team team;

    public Player(PlayerBehaviour playerBehaviour, GameInput gameInput, Team team) {
        //System.out.printf("initialize everything or u dead\n");
        image = SpriteStore.PLAYER;
        if(AI){

        }
        this.setVelX(0);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.AI == false) {

        }

        if (this.intersects(Ball.getBall())) {
            playerBehaviour.performAction();
        }

    }

    public double getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public double getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public void setInput(GameInput input) {
        this.input = input;
    }

    public boolean isAI() {
        return AI;
    }

    public void setAI(boolean aI) {
        AI = aI;
    }
}
