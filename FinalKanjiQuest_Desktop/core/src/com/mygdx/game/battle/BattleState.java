package com.mygdx.game.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.japanese.KanaLettersFactory;
import com.mygdx.game.japanese.LetterLvlCounter;

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
        if(LetterLvlCounter.areAllHiraganaMemorised() == false){
            int randomVal = MathUtils.random(0,106);
            String letterToAnswer = KanaLettersFactory.getInstance().getKanaLettersList().get(randomVal).getHiraganaEquivalent();
            if (letterToAnswer == null) return;
            this.currentOpponent = letterToAnswer;
            notify(letterToAnswer, BattleObserver.BattleEvent.HIRAGANA_ADDED);
        } else {
            String letterToAnswer = EncounterFactory.getInstance().getRandomMonster(currentZoneLevel);
            if (letterToAnswer == null) return;
            this.currentOpponent = letterToAnswer;
            notify(letterToAnswer, BattleObserver.BattleEvent.KANJI_ADDED);
        }
    }

    public void playerRuns(){
        int randomVal = MathUtils.random(1,100);
        if( chanceOfEscape > randomVal  ) {
            notify(currentOpponent, BattleObserver.BattleEvent.PLAYER_RUNNING);
        }else{
            playerHit();
            return;
        }
    }

    public void playerHit(){
        if( currentOpponent == null ){
            return;
        }

        notify(currentOpponent, BattleObserver.BattleEvent.PLAYER_HIT_DAMAGE);

        Gdx.app.debug(TAG, "PLayer lost health");
    }

    public void answeredCorrectly(String answeredLetter){
        notify(answeredLetter, BattleObserver.BattleEvent.LETTER_ANSWERED_CORRECTLY);
    }


    public void answeredIncorrectly(String answeredLetter){
        if( currentOpponent == null ){
            return;
        }

        notify(currentOpponent, BattleObserver.BattleEvent.LETTER_ANSWERED_INCORRECTLY);

        Gdx.app.debug(TAG, "PLayer lost health");
    }
}
