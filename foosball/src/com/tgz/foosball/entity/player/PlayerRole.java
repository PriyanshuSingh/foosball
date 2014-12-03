package com.tgz.foosball.entity.player;

import com.tgz.foosball.ashish.Team;
import com.tgz.foosball.entity.Ball;

import java.util.Random;


/**
 * Created by priyanshu on 3/12/14.
 */
public abstract class PlayerRole {

    protected Team team;
    protected Ball ball;
    public static final int NO_POS_PLAYER = 3;
    public static final Random RANDOM = new Random();

    public PlayerRole(Team team, Ball ball){
        this.team = team;
        this.ball = ball;
    }

    void shoot(){
        double xDiff = team.oppositeTeamGoalPost.getX() - ball.getX();
        double yDiff = team.oppositeTeamGoalPost.getY() - ball.getY();
        double speed = ball.getSpeed();
        double theta = Math.atan2(yDiff,xDiff);

        ball.setVelX(speed*Math.cos(theta));
        ball.setVelY(speed*Math.sin(theta));
    }

    void pass(Player player){
        double xDiff = player.getX() - ball.getX();
        double yDiff = player.getY() - ball.getY();
        double speed = ball.getSpeed();
        double theta = Math.atan2(yDiff,xDiff);

        ball.setVelX(speed*Math.cos(theta));
        ball.setVelY(speed*Math.sin(theta));
    }

}
