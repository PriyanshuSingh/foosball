package com.tgz.foosball.gamestate;

import com.tgz.foosball.entity.Ball;
import com.tgz.foosball.entity.TeamConfig;
import com.tgz.foosball.entity.player.Player;
import com.tgz.foosball.gfx.Screen;

public class PlayState extends GameState {

    private Player[][] teamGrid1;
    private Player[][] teamGrid2;

    public PlayState(GameStateManager gsm) {
        super(gsm);
    }

    public static Ball ball = Ball.getBall();

    @Override
    public void init() {

        init(Ball.getBall(), true);
        teamGrid1 = new Player[4][];
        teamGrid2 = new Player[4][];


    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Screen screen) {

    }

    @Override
    public void handleInput() {

    }

    public void init(Ball b, boolean t) {
        b.setX(100);
        b.setY(100);
        b.setMaxVelX(5);
        b.setMinVelX(1);
        b.setMaxVelY(5);
        b.setMinVelY(1);
        b.setVelX(1);
        if (t) {
            b.setVelY(1);
        } else {
            b.setVelY(-1);
        }
    }

    public void init(Player[][] t, TeamConfig teamConfig, boolean AI) {
        for (int i = 0; i < t.length; i++) {
        }
    }
}
