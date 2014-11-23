package ap.foosball.main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import ap.foosball.entity.Ball;
import ap.foosball.entity.IntImage;
import ap.foosball.gamestate.GameStateManager;
import ap.foosball.gamestate.State;
import ap.foosball.gfx.Screen;
import ap.foosball.gfx.SpriteStore;

public class Game extends Canvas implements Runnable{
	
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int HEIGHT = 240;
	public static final int WIDTH = 320;
	public static final int SCALE = 2;
	private static final String NAME = "FOOSBALL";
	
	private BufferedImage image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	private boolean running = false;
	private Screen screen;
	
	
	
	private GameInput input = new GameInput(this);
	
	private GameStateManager gameStateManager;

	private IntImage background;
	
	
	public void init() {
		screen = new Screen(WIDTH, HEIGHT);
		background = SpriteStore.BACKGROUND;
		gameStateManager = GameStateManager.getInstance();
		gameStateManager.setInput(input);
		
		gameStateManager.setState(State.PLAYSTATE);
		screen.setBackGroundColour(0xffff00ff);
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double unprocessed = 0;
		double nsPerTick = 1000000000.0 /300;
		int frames = 0;
		int ticks = 0;
		long lastTimer1 = System.currentTimeMillis();

		init();
		//Ball.image.test();

		while(running){
			long now = System.nanoTime();
			unprocessed += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;
			while (unprocessed >= 1) {
				ticks++;
				tick();
				unprocessed -= 1;
				shouldRender = true;
			}

			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (shouldRender) {
				frames++;
				render();
			}

			if (System.currentTimeMillis() - lastTimer1 > 1000) {
				lastTimer1 += 1000;
				System.out.println(ticks + " ticks, " + frames + " fps");
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	public void start(){
		running = true;
		new Thread(this).start();
	}

	public void stop(){
		running = false;
	}

	public void tick() {	
		input.tick();
		gameStateManager.tick();
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			requestFocus();
			return;
		}
		screen.setBackGround(background);
		gameStateManager.render(screen);
		
		if(gameStateManager.getCurrentState() == State.PAUSESTATE){
			screen.makeImageGray();
		}
		//screen.setBackGroundColour(0xffffffff);
		//gameStateManager.render(screen);
		// Render 
		
		for (int y = 0; y < screen.h; y++) {
			for (int x = 0; x < screen.w; x++) {
				pixels[x + y * WIDTH] = screen.pixels[x + y * screen.w];
			}
		}

			
		Graphics g = bs.getDrawGraphics();
		
		g.fillRect(0, 0, getWidth(), getHeight());
		
		int ww = WIDTH ;
		int hh = HEIGHT;
		//int xo = (getWidth() - ww) / 2;
		//System.out.println(getWidth());
		//int yo = (getHeight() - hh) / 2;
		//	System.out.println(image.getRGB(0, 0));
		//g.drawImage(image, xo, yo, ww, hh, null);
		g.drawImage(image, 0, 0,getWidth(), getHeight(),null);
		g.dispose();
		bs.show();

	}
	
	public static void main(String[] args){
		Game game = new Game();
		game.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		//game.setMaximumSize(new Dimension(WIDTH*SCALE , HEIGHT*SCALE ));
		game.setPreferredSize(new Dimension(WIDTH *SCALE, HEIGHT*SCALE ));

		JFrame frame = new JFrame(Game.NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(game, BorderLayout.CENTER);
		frame.pack();
		//frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		game.start();
	}
}
