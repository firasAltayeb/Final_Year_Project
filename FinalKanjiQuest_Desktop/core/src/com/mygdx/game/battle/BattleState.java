package com.mygdx.game.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.tools.Entity;

public class BattleState extends BattleSubject {

    private static final String TAG = BattleState.class.getSimpleName();

    private Entity currentOpponent;
    private int currentZoneLevel = 0;
    private int currentPlayerAP;
    private int currentPlayerDP;
    private int currentPlayerWandAPPoints = 0;
    private final int chanceOfAttack = 25;
    private final int chanceOfEscape = 40;
    private final int criticalChance = 90;

    public void setCurrentZoneLevel(int zoneLevel){
        currentZoneLevel = zoneLevel;
    }

    public int getCurrentZoneLevel(){
        return currentZoneLevel;
    }

    public boolean isOpponentReady(){
        if( currentZoneLevel == 0 ) return false;
        int randomVal = MathUtils.random(1,100);

        if( chanceOfAttack > randomVal  ){
            setCurrentOpponent();
            return true;
        }else{
            return false;
        }
    }

    public void setCurrentOpponent(){
        System.out.print("Entered BATTLE ZONE: " + currentZoneLevel);
        Entity entity = MonsterFactory.getInstance().getRandomMonster(currentZoneLevel);
        if( entity == null ) return;
        this.currentOpponent = entity;
        notify(entity, BattleObserver.BattleEvent.OPPONENT_ADDED);
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
