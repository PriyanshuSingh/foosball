package com.tgz.foosball.entity;

import java.awt.Rectangle;
import java.util.Random;

import com.tgz.foosball.gfx.Screen;
import com.tgz.foosball.main.GameInput;

public abstract class GameObject {

    protected final Random random = new Random();

    public boolean removed;

    public IntImage image;

    //position
    protected double x;
    protected double y;

    //speed
    protected double velX;
    protected double velY;
    protected double speed;

    //collision box
    protected int width;
    protected int height;

    //input
    protected GameInput input;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = (double)x;
    }

    public void setY(int y) {
        this.y = (double)y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getVelX() {
        return velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelX(int velX) {
        this.velX = (double)velX;
    }

    public void setVelY(int velY) {
        this.velY = (double)velY;
    }

    public void tick() {
    }

    public void setPosition(int x, int y) {
        this.x = (double)x;
        this.y = (double)y;
    }

    //check if necessary or not
    public void remove() {
        removed = true;
    }

    // check if the gameObject are intersecting or not
    public boolean intersects(GameObject gameObject) {
        return getRectangle().intersects(gameObject.getRectangle());
    }

    public void render(double x, double y, Screen screen) {
        if (image != null) {
            image.render((int)x, (int)y, screen);
        }
    }

    public void render(Screen screen){
        if(image != null){
            image.render((int)this.x,(int)this.y,screen);
        }
    }

    private Rectangle getRectangle() {
        return new Rectangle(
                (int) x - width / 2,
                (int) y - height / 2,
                width,
                height
        );
    }
}
