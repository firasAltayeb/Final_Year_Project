package com.mygdx.game.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class BattleState extends BattleSubject {

    //TODO speak about this,
    private static final String TAG = BattleState.class.getSimpleName();

    private String currentOpponent;
    private int currentZoneLevel = 0;
    private final int chanceOfEncounter = 85;
    private final int chanceOfEscape = 85;

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
        String letterToAnswer = MonsterFactory.getInstance().getRandomMonster(currentZoneLevel);
        if (letterToAnswer == null) return;
        this.currentOpponent = letterToAnswer;
        notify(letterToAnswer, BattleObserver.BattleEvent.KANJI_ADDED);
    }

    public void playerRuns(){
        int randomVal = MathUtils.random(1,100);
        if( chanceOfEscape > randomVal  ) {
            notify(currentOpponent, BattleObserver.BattleEvent.PLAYER_RUNNING);
        }else{
            answeredIncorrectly();
            return;
        }
    }

    public void answeredCorrectly(){
        if( currentOpponent == null ){
            return;
        }

        notify(currentOpponent, BattleObserver.BattleEvent.OPPONENT_DEFEATED);

    }

    public void answeredIncorrectly(){
        if( currentOpponent == null ){
            return;
        }

        notify(currentOpponent, BattleObserver.BattleEvent.PLAYER_HIT_DAMAGE);

        Gdx.app.debug(TAG, "PLayer lost health");
    }
}
