package com.tgz.foosball.entity.player;

import com.tgz.foosball.ashish.Team;
import com.tgz.foosball.entity.Ball;
import com.tgz.foosball.entity.GameObject;
import com.tgz.foosball.gfx.SpriteStore;
import com.tgz.foosball.main.Game;

public class Player extends GameObject {

    // constrained in different bars
    protected double maxY, minY;
    protected boolean AI;
    public PlayerBehaviour playerBehaviour;
    private Team team;
    protected int index;

    public Player(PlayerBehaviour playerBehaviour, Team team, int index) {
        // set speed
        AI = team.AI;
        image = isAI() ? SpriteStore.PLAYER2 : SpriteStore.PLAYER;
        this.team = team;
        this.playerBehaviour = playerBehaviour;
        double spacing = Game.HEIGHT/(playerBehaviour.getCount()+1);
        velX = 0;
        x = playerBehaviour.getplayerX();
        y = playerBehaviour.getMeanY(index);
        //System.out.println(y);
        this.index = index;
        setMaxY((int)Math.abs(y+spacing));
        setMinY((int)Math.abs(y-spacing));

        if(!isAI()){
          //  System.out.println(AI);
            input = team.input;
        }

        setHeight(image.getHEIGHT());
        setWidth(image.getWIDTH());
    }



    @Override
    public void tick() {
        super.tick();
        if (!isAI()) {
            //System.out.println(input+" "+AI);
            if (input.up.down && !input.down.down) {
                velY = -playerBehaviour.getSpeed();
            } else if (input.down.down && !input.up.down) {
                velY = +playerBehaviour.getSpeed();
            }else{
                velY = 0;
            }
        } else {
            if (team.directionAI == Direction.UP) {
                velY = -playerBehaviour.getSpeed();

            } else if (team.directionAI == Direction.DOWN) {
                velY = +playerBehaviour.getSpeed();

            } else {
                velY = 0;
            }

        }
        if(y+velY - getHeight()/2>=minY && y+velY + getHeight()/2 <= maxY){
            y += velY;
        }

        if (this.intersects(Ball.getBall())) {
            playerBehaviour.performAction();
            //System.out.println(playerBehaviour+" AI "+AI);
        }

    }


    public double getX(){
        return x;
    }

    public double getY(){
        return y;
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


}
