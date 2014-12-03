package com.tgz.foosball.entity.player;

import com.tgz.foosball.ashish.Team;
import com.tgz.foosball.entity.Ball;
import com.tgz.foosball.entity.GameObject;
import com.tgz.foosball.entity.Observable;
import com.tgz.foosball.gfx.SpriteStore;
import com.tgz.foosball.main.Game;
import com.tgz.foosball.main.GameApplet;
import com.tgz.foosball.main.GameInput;

public class Player extends GameObject implements BallObserver {

    // constrained in different bars
    protected double maxY, minY;
    protected boolean AI;
    private PlayerBehaviour playerBehaviour;
    private Team team;
    protected int index;


    public Player(PlayerBehaviour playerBehaviour, Team team, int index) {

        image = SpriteStore.PLAYER;



        double spacing = Game.HEIGHT/(playerBehaviour.getCount()+1);
        velX = 0;
        AI = team.AI;
        x = playerBehaviour.getplayerX();
        y = playerBehaviour.getMeanY(index, team);
        this.index = index;
        setMaxY((int)Math.abs(y+spacing));
        setMinY((int)Math.abs(y-spacing));

        if(isAI()){
            startObserving(Ball.getBall());
            x = Game.WIDTH - x;
        }else {
            input = team.input;
        }

        setHeight(image.getHEIGHT());
        setWidth(image.getWIDTH());

    }



    @Override
    public void tick() {
        super.tick();
        if(!isAI()) {
            if(input.up.down && !input.down.down){

            }else if(input.down.down && !input.up.down){

            }
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

    public boolean isAI() {
        return AI;
    }

    public void setAI(boolean aI) {
        AI = aI;
    }

    @Override
    public void update() {

        Ball ball = Ball.getBall();
        if(isAI()){

        }
    }

    private void startObserving(Observable observable){
        observable.addObserver(this);
    }
}
