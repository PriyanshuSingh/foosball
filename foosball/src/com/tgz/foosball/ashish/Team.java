package com.tgz.foosball.ashish;

import com.tgz.foosball.entity.Ball;
import com.tgz.foosball.entity.GoalPost;
import com.tgz.foosball.entity.Observable;
import com.tgz.foosball.entity.player.*;
import com.tgz.foosball.main.Game;
import com.tgz.foosball.main.GameInput;

/**
 * Created by subodhyadav on 21/11/14.
 */
public class Team implements BallObserver{

    public Player[] players;

    public int defenderCount;
    public int midfielderCount;
    public int attackerCount;
    public boolean AI;
    public GameInput input;
    public Direction directionAI;
    public GoalPost oppositeTeamGoalPost;

    public Team(GameInput input,GoalPost oppositeTeamGoalPost){
        players = new Player[11];
        this.input =  input;
        System.out.println("team input "+input+"hello");
        this.oppositeTeamGoalPost = oppositeTeamGoalPost;
        this.directionAI = Direction.NONE;
    }

    public void init(boolean AI,int defenderCount, int midfielderCount, int attackerCount){
        //intitialize all players here

        this.defenderCount = defenderCount;
        this.midfielderCount = midfielderCount;
        this.attackerCount = attackerCount;
        this.AI = AI;
        if(AI){
            startObserving(Ball.getBall());
        }

        players[0] = new Player(new GoalKeeper(this,Ball.getBall()),this,0);

        // Goalkeeper is special
        players[0].setMinY((int) (oppositeTeamGoalPost.getY() - ((double)oppositeTeamGoalPost.getHeight())/2));
        players[0].setMaxY((int) (oppositeTeamGoalPost.getY() + ((double)oppositeTeamGoalPost.getHeight())/2));


        PlayerBehaviour playerBehaviour = new Defender(this,Ball.getBall());

        for(int i=1;i<=defenderCount;i++){
            players[i] = new Player(playerBehaviour,this,i);
        }
        playerBehaviour = new MidFielder(this,Ball.getBall());
        for(int i=defenderCount+1;i<=defenderCount+midfielderCount;i++){
            players[i] = new Player(playerBehaviour,this,i);
        }
        playerBehaviour = new Attacker(this,Ball.getBall());
        for(int i=defenderCount+midfielderCount+1;i<=defenderCount+midfielderCount+attackerCount;i++){
            players[i] = new Player(playerBehaviour,this,i);
        }
    }


    @Override
    public void update() {
        double xs[] = new double[4];
        Ball ball = Ball.getBall();
        int count = 0;  // should not be zero
        int startingIndex = 0;
        double diff;
        double minX;
        double expectedY;
        double expectedTime;
        int epsilon = ball.getHeight();
        xs[0] = players[0].getX();
        xs[1] = players[1].getX();
        xs[2] = players[this.defenderCount+1].getX();
        xs[3] = players[this.defenderCount+this.midfielderCount+1].getX();

        if(AI){
            for(int i=0; i<xs.length;i++) {
                xs[i] = Game.WIDTH - xs[i];
            }
        }

        minX = 1000000;
        for (Player player: players) {
            diff = player.getX() - ball.getX();
            if (ball.getVelX() < 0) {
                diff = -diff;
            }
            if (diff > 0) {
                if (minX >= diff) {
                    minX = diff;
                    count = player.playerBehaviour.getCount();
                    startingIndex = player.playerBehaviour.getStartingIndex();
                }
            }
        }


        expectedTime = minX/Math.abs(ball.getVelX());
        expectedY = ball.getY() + ball.getVelX()*expectedTime;
        int yPos = ((int)expectedY)%Game.HEIGHT;
        if(yPos > 0){
            yPos = Game.HEIGHT - yPos;
        }else {
            yPos = -yPos;
        }


        int spacingY = Game.HEIGHT/(count+1);
        int partition = yPos/spacingY;

        if(partition == 0 ){
            if(yPos - players[startingIndex+partition].getY() < -epsilon/2) {
                directionAI = Direction.UP;
            }else if(yPos - players[startingIndex+partition].getY() > epsilon/2){
                directionAI = Direction.DOWN;
            }else {
                directionAI = Direction.NONE;
            }
        }else if(partition == count){
            if(yPos - players[startingIndex+partition-1].getY() < -epsilon/2) {
                directionAI = Direction.UP;
            }else if(yPos - players[startingIndex+partition-1].getY() > epsilon/2){
                directionAI = Direction.DOWN;
            }else {
                directionAI = Direction.NONE;
            }
        }else {
            double pos1 = players[startingIndex+partition-1].getX();
            double pos2 = players[startingIndex+partition].getX();

            if(Math.abs(pos1 - ball.getY()) > Math.abs(pos2 - ball.getY())) {
                if(yPos - pos2 < -epsilon/2){
                    directionAI = Direction.UP;
                }else if(yPos - pos2 > epsilon/2){
                    directionAI = Direction.DOWN;
                }else {
                    directionAI = Direction.DOWN;
                }
            }else {
                if(yPos - pos1 < -epsilon/2){
                    directionAI = Direction.UP;
                }else if(yPos - pos1 > epsilon/2){
                    directionAI = Direction.DOWN;
                }else {
                    directionAI = Direction.DOWN;
                }
            }
        }

    }

    private void startObserving(Observable observable){
        observable.addObserver(this);
    }

}
