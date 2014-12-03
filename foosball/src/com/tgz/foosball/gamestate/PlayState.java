package com.tgz.foosball.gamestate;

import com.tgz.foosball.ashish.Team;
import com.tgz.foosball.entity.Ball;
import com.tgz.foosball.entity.GoalEvent;
import com.tgz.foosball.entity.GoalPost;
import com.tgz.foosball.entity.player.Player;
import com.tgz.foosball.gfx.Screen;
import com.tgz.foosball.main.Game;

public class PlayState extends GameState implements GoalEventListener {


    public Team teams[];
    public GoalPost goalPosts[];
    public final static int GOAL_POST_OFFSET = 0;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        teams = new Team[2];
        goalPosts = new GoalPost[2];
        teams[0] = new Team(gsm.getInput());
        teams[1] = new Team(gsm.getInput());
        goalPosts[0] = new GoalPost(GOAL_POST_OFFSET);
        goalPosts[1] = new GoalPost(Game.WIDTH - GOAL_POST_OFFSET);
    }

    public static Ball ball = Ball.getBall();

    @Override
    public void init() {

        //init ball here
        //gsm.getInfo(From MenuState)
        teams[0].init(false, 2, 2, 2);
        teams[1].init(true, 2, 2, 2);

    }

    @Override
    public void tick() {
        ball.tick();
        for(Team team: teams){
            for(Player player: team.players){
                player.tick();
            }
        }

    }

    @Override
    public void render(Screen screen) {
        ball.render(screen);
        for(Team team: teams){
            for(Player player: team.players){
                player.render(screen);
            }
        }

    }

    @Override
    public void handleInput() {

    }

    @Override
    public void goalEventOccured(GoalEvent e) {

    }
}
