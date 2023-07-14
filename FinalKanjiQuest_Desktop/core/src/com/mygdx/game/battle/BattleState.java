package com.mygdx.game.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class BattleState extends BattleSubject {

    private static final String TAG = BattleState.class.getSimpleName();

    private String currentOpponent;
    private int currentZoneLevel = 0;
    private final int chanceOfEncounter = 75;
    private final int chanceOfEscape = 25;


    public void setCurrentZoneLevel(int zoneLevel){
        currentZoneLevel = zoneLevel;
    }

    public int getCurrentZoneLevel(){
        return currentZoneLevel;
    }

    public boolean isOpponentReady(){
        if( currentZoneLevel == 0 ) return false;
        int randomVal = MathUtils.random(1,100);

        if( chanceOfEncounter > randomVal  ){
            setCurrentOpponent();
            return true;
        }else{
            return false;
        }
    }

    public void setCurrentOpponent(){
        Gdx.app.debug(TAG, " Entered BATTLE ZONE: " + currentZoneLevel);
        String monster = MonsterFactory.getInstance().getRandomMonster(currentZoneLevel);
        if( monster == null ) return;
        this.currentOpponent = monster;
        notify(monster, BattleObserver.BattleEvent.OPPONENT_ADDED);
    }

    public void playerAttacks(){
        if( currentOpponent == null ){
            return;
        }

        notify(currentOpponent, BattleObserver.BattleEvent.PLAYER_TURN_START);

        Gdx.app.debug(TAG, "PLAYER ATTACK");

        notify(currentOpponent, BattleObserver.BattleEvent.PLAYER_TURN_DONE);
    }

    public void playerRuns(){
        int randomVal = MathUtils.random(1,100);
        if( chanceOfEscape > randomVal  ) {
            notify(currentOpponent, BattleObserver.BattleEvent.PLAYER_RUNNING);
        }else{
            opponentAttacks();
            return;
        }
    }

    public void opponentAttacks(){
        if( currentOpponent == null ){
            return;
        }

        notify(currentOpponent, BattleObserver.BattleEvent.PLAYER_HIT_DAMAGE);

        Gdx.app.debug(TAG, "PLayer lost health");

        notify(currentOpponent, BattleObserver.BattleEvent.OPPONENT_TURN_DONE);
    }
}
