package com.tgz.foosball.gamestate;

import com.tgz.foosball.ashish.Scoreboard;
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
    public Scoreboard scoreboard;

    public final static int GOAL_POST_OFFSET_TEAM1 = GoalPost.WIDTH/2;
    public final static int GOAL_POST_OFFSET_TEAM2 = Game.WIDTH - GOAL_POST_OFFSET_TEAM1;
    // dont touch as every where self goal is computed using this formula
    public PlayState(GameStateManager gsm) {
        super(gsm);
        teams = new Team[2];
        scoreboard = new Scoreboard();
        goalPosts = new GoalPost[2];

        goalPosts[0] = new GoalPost(GOAL_POST_OFFSET_TEAM1);
        goalPosts[0].addGoalEventListener(scoreboard);
        goalPosts[0].addGoalEventListener(this);

        goalPosts[1] = new GoalPost(GOAL_POST_OFFSET_TEAM2);
        goalPosts[1].addGoalEventListener(scoreboard);
        goalPosts[1].addGoalEventListener(this);

        // team keep track of goalpost of opposite team
        teams[0] = new Team(gsm.getInput(),goalPosts[1]);
        teams[1] = new Team(gsm.getInput(),goalPosts[0]);
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
        if(((GoalPost)e.getSource()).getX() < Game.WIDTH/2 ){
            ball.setPosition(320,180);
            ball.setVelX(8);
            ball.setVelY(0);
        }else {

        }
    }
}
