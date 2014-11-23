package ap.foosball.entity;

import java.awt.Rectangle;
import java.util.Random;

import ap.foosball.gfx.Screen;
import ap.foosball.main.GameInput;

public abstract class GameObject {

	protected final Random random = new Random();
	
	public boolean removed;
	
	public IntImage image;
	
	//position
	protected int x;
	protected int y;
	
	//speed
	protected int velX;
	protected int velY;
	
	//collision box
	protected int width;
	protected int height;
	
	//input 
	protected GameInput input;
	
	public int getX(){ 
		return x; 
	}
	public int getY(){ 
		return y;
	}
	public int getWidth(){ 
		return width; 
	} 
	public int getHeight(){
		return height;
	}
	
	public void setX(int x){ 
		this.x = x; 
	}
	public void setY(int y){ 
		this.y = y;
	}
	public void setWidth(int width){ 
		this.width = width; 
	} 
	public void setHeight(int height){
		this.height = height;
	}
	
	
	public void tick(){
	}
	
	public void setPosition(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setSpeed(int velX,int velY){
		this.velX = velX;
		this.velY = velY;
	}
	
	//check if necessary or not 
	public void remove() {
		removed = true;
	}

	// check if the gameObject are intersecting or not
	public boolean intersects(GameObject gameObject) {
		return getRectangle().intersects(gameObject.getRectangle());
	}
	
	public void render(int x,int y,Screen screen){
		if(image != null){
			//System.out.println(image +" "+ image.getHEIGHT()+ " "+ image.getWIDTH()+" "+ x + " "+ y);
			//image.test();
			image.render(x,y,screen);
		}
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	public int getVelX() {
		return velX;
	}
	public int getVelY() {
		return velY;
	}
	public Rectangle getRectangle() {
		return new Rectangle(
				(int)x - width / 2,
				(int)y - height / 2,
				width,
				height
		);
	}
}
