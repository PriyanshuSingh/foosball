package com.tgz.foosball.entity;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import com.tgz.foosball.gfx.Screen;

public class IntImage {

	
	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	private int WIDTH;
	private int HEIGHT;
	private int[] pixels;
	private int backGround;
	private boolean isBackGround;
	
	public IntImage(BufferedImage image){
		pixels = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
		WIDTH = image.getWidth();
		HEIGHT = image.getHeight();
		backGround = 0x00ffffff;
		isBackGround = false;
	}
	
	public IntImage(BufferedImage image,int backGround){
		pixels = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
		this.backGround = backGround;
		WIDTH = image.getWidth();
		HEIGHT = image.getHeight();
		isBackGround = false;
	}
	
	public IntImage(BufferedImage image,int backGround,boolean isBackGround){
		pixels = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
		this.backGround = backGround;
		WIDTH = image.getWidth();
		HEIGHT = image.getHeight();
		this.isBackGround = isBackGround;
	}
	
	public void render(int X,int Y,Screen screen){
		X = X - WIDTH/2;
		Y = Y - HEIGHT/2;
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				
				if(backGround != pixels[x + y * WIDTH]){
				//	System.out.println(x+" "+y+" w-"+WIDTH+" h-"+HEIGHT+" x-"+X+" y-"+Y);
					screen.pixels[x+X + (y+Y) * screen.w] = pixels[x + y * WIDTH];
				}
			}
		}

	}
	
	public void test(){
		for(int i =0 ; i<WIDTH*HEIGHT ; i++){
			System.out.printf("%x ",pixels[i]);
		}
	}

}
