package com.tgz.foosball.entity;



import com.tgz.foosball.gfx.Screen;
import com.tgz.foosball.gfx.SpriteStore;
import com.tgz.foosball.main.Game;


// Singleton class
public class Ball extends GameObject{

	@Override
	public void setVelX(int velX) {
		// TODO Auto-generated method stub
		super.setVelX(velX);
		if(getVelX() < getMinVelX())setVelX(getMinVelX());
		if(getVelX() > getMaxVelX())setVelX(getMaxVelX());
		if(getVelY() < getMinVelY())setVelY(getMinVelY());
		if(getVelY() > getMaxVelY())setVelY(getMinVelY());
	}



	@Override
	public void setVelY(int velY) {
		// TODO Auto-generated method stub
		super.setVelY(velY);
	}



	private static final Ball instance = new Ball();
	private static Game game;
	
	private int maxVelX;
	private int minVelX;
	private int maxVelY;
	private int minVelY;
	
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		super.tick();
	//	System.out.println(x+" "+y+" ");
		if(x + velX + image.getWIDTH()/2 < game.WIDTH && x + velX - image.getWIDTH()/2 > 0){
			x = x + velX;
		}
		else{
			velX = -velX;
			x = x + velX;
		}
		if(y +  velY + image.getHEIGHT()/2 < game.HEIGHT && y + velY - image.getHEIGHT()/2 > 0){
			y = y + velY;
		}
		else{
			velY = -velY;
			y = y + velY;
		}
	
	}
	

	
	public void render(Screen screen) {
		super.render(x, y, screen);
	}


	private Ball(){
		image = SpriteStore.BALL;
		this.setHeight(image.getHEIGHT());
		this.setWidth(image.getWIDTH());
	}
	
	public static Ball getBall(){
		return instance;
	}


	public static void setGame(Game game) {
		Ball.game = game;
	}



	public int getMaxVelX() {
		return maxVelX;
	}



	public void setMaxVelX(int maxVelX) {
		this.maxVelX = maxVelX;
	}



	public int getMinVelX() {
		return minVelX;
	}



	public void setMinVelX(int minVelX) {
		this.minVelX = minVelX;
	}



	public int getMaxVelY() {
		return maxVelY;
	}



	public void setMaxVelY(int maxVelY) {
		this.maxVelY = maxVelY;
	}



	public int getMinVelY() {
		return minVelY;
	}



	public void setMinVelY(int minVelY) {
		this.minVelY = minVelY;
	}
	
}
