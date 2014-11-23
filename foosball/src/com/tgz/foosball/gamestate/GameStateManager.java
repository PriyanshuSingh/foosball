package com.tgz.foosball.gamestate;

import java.util.EnumMap;
import java.util.Map;

import com.tgz.foosball.entity.Ball;
import com.tgz.foosball.gfx.Screen;
import com.tgz.foosball.main.GameInput;

public class GameStateManager {

	private static final GameStateManager gameStateManager = new GameStateManager();
	public static GameInput input;
	
	private Map<State,GameState> gameStates;
	private State currentState;
	
	
	public State getCurrentState() {
		return currentState;
	}

	private GameStateManager(){
		gameStates = new EnumMap<State, GameState>(State.class);
		gameStates.put(State.MENUSTATE,new MenuState(this));
		gameStates.put(State.PLAYSTATE,new PlayState(this));
		gameStates.put(State.PAUSESTATE,new PauseState(this));
	}

	public static GameStateManager getInstance(){
		return gameStateManager;
	}
	
	public void render(Screen screen) {
		gameStates.get(currentState).render(screen);
	}

	public void tick() {
		if(input.esc.clicked){
			if(currentState == State.PLAYSTATE){
				currentState = State.PAUSESTATE;
			}
			else if(currentState == State.PAUSESTATE){
				
			}
		}
		gameStates.get(currentState).tick();
	}

	public void setInput(GameInput input) {
		this.input = input;		
	}
	
	public void setState(State currentState){
		this.currentState = currentState;
		gameStates.get(currentState).init();
	}

	

}
