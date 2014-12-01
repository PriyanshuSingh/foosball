package com.tgz.foosball.gamestate;

import com.tgz.foosball.ashish.Team;
import com.tgz.foosball.entity.Ball;
import com.tgz.foosball.entity.player.Player;
import com.tgz.foosball.gfx.Screen;

public class PlayState extends GameState {


    public Team team1;
    public Team team2;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        team1 = new Team();
        team2 = new Team();
    }

    public static Ball ball = Ball.getBall();

    @Override
    public void init() {

        init(Ball.getBall(), true);
        //gsm.getInfo(From MenuState)
        team1.init(false,2,2,2);
        team2.init(true,2,2,2);

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
        b.setVelX(1);
        if (t) {
            b.setVelY(1);
        } else {
            b.setVelY(-1);
        }
    }

}
