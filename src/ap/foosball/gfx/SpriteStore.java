package ap.foosball.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import ap.foosball.entity.IntImage;

public class SpriteStore {
	
	private final static SpriteStore SPRITE_STORE = new SpriteStore();

	private SpriteStore(){
		BufferedImage im;
		BufferedImage im2;
		try {
			im = ImageIO.read(this.getClass().getResource("/sprite5.png"));
			//im2 = ImageIO.read(this.getClass().getResource("/sprite.jpg"));
			PLAYER = new IntImage(im.getSubimage(0, 16, 12, 16), 0xff000000);
			BAR = new IntImage(im.getSubimage(235, 0, 5, 240));
			BALL = new IntImage(im.getSubimage(0, 64, 6, 6),0xffffffff);
			BACKGROUND = new IntImage(ImageIO.read(this.getClass().getResource("/Football_Pitch.png")));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public SpriteStore getInstance(){
		return SPRITE_STORE;	
	}
	
	public static IntImage PLAYER;
	public static IntImage BAR;
	public static IntImage BALL;
	public static IntImage BACKGROUND;
	
	public static void main(String[] args){
		PLAYER.test();
	}
}
