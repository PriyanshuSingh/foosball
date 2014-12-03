package com.tgz.foosball.entity;


import com.tgz.foosball.entity.player.BallObserver;
import com.tgz.foosball.gfx.Screen;
import com.tgz.foosball.gfx.SpriteStore;
import com.tgz.foosball.main.Game;

import java.util.ArrayList;
import java.util.List;


// Singleton class

public class Ball extends GameObject implements Observable {


    private static final Ball instance = new Ball();

    private static Game game;
    private static List<BallObserver> ballObserverList;


    @Override
    public void tick() {
        super.tick();
        checkCorners();
        notifyall();
    }

    private void checkCorners() {

        if (x + velX + image.getWIDTH() / 2 < game.WIDTH && x + velX - image.getWIDTH() / 2 > 0) {
            x = x + velX;
        } else {
            velX = -velX;
            x = x + velX;
        }
        if (y + velY + image.getHEIGHT() / 2 < game.HEIGHT && y + velY - image.getHEIGHT() / 2 > 0) {
            y = y + velY;
        } else {
            velY = -velY;
            y = y + velY;
        }


    }


    private Ball() {
        image = SpriteStore.BALL;
        setHeight(image.getHEIGHT());
        setWidth(image.getWIDTH());
        ballObserverList = new ArrayList<BallObserver>();
    }

    public static Ball getBall() {
        return instance;
    }

    public static void setGame(Game game) {

        Ball.game = game;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getVelX(){
        return velX;
    }

    public double getVelY(){
        return velY;
    }

    public double getSpeed(){
        return speed;
    }
    public void setVelX(double vel){
        velX = vel;
        speed = Math.sqrt(velX*velX + velY*velY);
    }

    public void setVelY(double vel){
        velY = vel;
        speed = Math.sqrt(velX*velX + velY*velY);
    }

    public void setSpeed(double changedSpeed){
        velX = (velX/this.speed)*changedSpeed;
        velY = (velY/this.speed)*changedSpeed;
        this.speed = changedSpeed;

    }

    @Override
    public void addObserver(BallObserver ballObserver) {
        ballObserverList.add(ballObserver);
    }

    @Override
    public void notifyall() {
        for (BallObserver ballObserver : ballObserverList) {
            ballObserver.update();
        }
    }


}
