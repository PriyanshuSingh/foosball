package ap.foosball.gfx;

import ap.foosball.entity.IntImage;

public class Screen {

	public int w;
	public int h;
	public int[] pixels;
	public int[] background;
	public void setBackGroundColour(int color){
		for(int i = 0; i<w*h; i++){
			pixels[i] = color;
		}
	}
	
	
	public Screen(int w,int h){
		this.h = h;
		this.w = w;
		
		pixels = new int[w*h];
	}

	public void setBackGround(IntImage background) {
		background.render(background.getWIDTH()/2, background.getHEIGHT()/2, this);
		//System.out.println("Background\n");
	}
	
	public void makeImageGray(){
		for(int i = 0; i<w*h; i++){
			int r = (pixels[i]>>16)&0xFF;
			int g = (pixels[i]>>8)&0xFF;
			int b = (pixels[i]>>0)&0xFF;
			r =  (r+g+b)/3;
			pixels[i] = r<<16 + g<<8 + b<<0;
		}
	}
	
}
