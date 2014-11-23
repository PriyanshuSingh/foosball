package com.tgz.foosball.entity.player;

import com.tgz.foosball.entity.Ball;
import com.tgz.foosball.entity.GameObject;
import com.tgz.foosball.gfx.SpriteStore;
import com.tgz.foosball.main.GameInput;

public class Player extends GameObject{
	
	// constrained in different bars
	private int maxY,minY;
	private int speedY; 
	private boolean AI;
	public Player(){
		System.out.printf("initialize everything or u dead\n");
		image = SpriteStore.PLAYER;
	}
	
	public Player(int x,int minY,int maxY,int speedY,GameInput input) {
		setX(x);
		image = SpriteStore.PLAYER;
		this.setHeight(image.getHEIGHT());
		this.setWidth(image.getWIDTH());
		image = null;
		this.minY = minY;
		this.maxY = maxY;
		this.input = input;
		this.speedY = speedY;
	}
	

	@Override
	public void tick() {
		super.tick();		
		if(input.up.clicked && !input.down.clicked){
			velY = -speedY;
		//	System.out.println(velY);
		}else if(!input.up.clicked && input.down.clicked){
			velY = +speedY;
			//System.out.println(velY);
		}else{
			velY = 0;
		}
		
		if(y + velY + getHeight()/2 <= maxY && y + velY - getHeight()/2 >= minY){
			y += velY;
		}		

		if(this.intersects(Ball.getBall())){
			System.out.println("collide");
			if(this.x > Ball.getBall().getX())
			{
				Ball.getBall().setVelX(Ball.getBall().getVelX()+random.nextInt(10)-1);
			}
			else
			{
				Ball.getBall().setVelX(-1*Ball.getBall().getVelX()+random.nextInt(10)-1);
			}
			if(this.y > Ball.getBall().getY())
			{
				Ball.getBall().setVelY(-1*Ball.getBall().getVelY()+random.nextInt(10)-1);
			} else{
				Ball.getBall().setVelX(Ball.getBall().getVelX()+random.nextInt(10)-1);
			}
		}
		
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public int getMinY() {
		return minY;
	}

	public void setMinY(int minY) {
		this.minY = minY;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	
	public void setInput(GameInput input){
		this.input = input;
	}

	public boolean isAI() {
		return AI;
	}

	public void setAI(boolean aI) {
		AI = aI;
	}
}
