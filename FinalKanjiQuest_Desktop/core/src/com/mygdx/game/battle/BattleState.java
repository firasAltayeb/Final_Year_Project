package com.mygdx.game.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class BattleState extends BattleSubject {

    private static final String TAG = BattleState.class.getSimpleName();

    private String currentOpponent;
    private int currentZoneLevel = 0;
    private final int chanceOfEncounter = 50;


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
        System.out.print("Entered BATTLE ZONE: " + currentZoneLevel);
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




}
