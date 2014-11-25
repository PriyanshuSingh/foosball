package com.tgz.foosball.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tgz.foosball.entity.IntImage;

public class SpriteStore {

    private final static SpriteStore SPRITE_STORE = new SpriteStore();
    public static IntImage PLAYER2;
    public static IntImage PLAYER;
    public static IntImage BAR;
    public static IntImage BALL;
    public static IntImage BACKGROUND;

    private SpriteStore() {
        BufferedImage im;
        BufferedImage im2;
        try {
            im = ImageIO.read(this.getClass().getResource("/spritee.png"));
            //im2 = ImageIO.read(this.getClass().getResource("/sprite.jpg"));
            PLAYER = new IntImage(im.getSubimage(0, 0, 21, 36), 0xff000000);
            PLAYER2 = new IntImage(im.getSubimage(0, 36, 21, 36));
            BAR = new IntImage(im.getSubimage(66, 0, 6, 360));
            BALL = new IntImage(im.getSubimage(0, 72, 16, 16), 0xff000000);
            BACKGROUND = new IntImage(ImageIO.read(this.getClass().getResource("/sp1.png")));


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public SpriteStore getInstance() {
        return SPRITE_STORE;
    }


    public static void main(String[] args) {
        PLAYER.test();
    }
}
