package com.tgz.foosball.gamestate;

import com.tgz.foosball.gfx.Screen;


public abstract class GameState {


    protected GameStateManager gsm;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
    }

    public abstract void init();

    public abstract void tick();

    public abstract void handleInput();

    public abstract void render(Screen screen);

}
