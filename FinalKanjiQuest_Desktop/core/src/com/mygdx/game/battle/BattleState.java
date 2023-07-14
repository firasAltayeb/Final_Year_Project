package com.mygdx.game.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.japanese.KanaLettersFactory;
import com.mygdx.game.japanese.LetterLvlCounter;

public class BattleState extends BattleSubject {

    //TODO speak about this,
    private static final String TAG = BattleState.class.getSimpleName();


    private int currentZoneLevel = 0;
    private final int chanceOfEncounter = 100;
    private final int chanceOfEscape = 85;
    private String currentLetter = "";

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

    //TODO speak about this,
    public void setCurrentOpponent(){
        Gdx.app.debug(TAG, " Entered BATTLE ZONE: " + currentZoneLevel);
        int randomVal;
        String letterToAnswer;
        int letterToAnswersLvl;
        int cycleCounter;
        if(!LetterLvlCounter.areAllHiraganaMemorised()){
            cycleCounter = 0;
            randomVal= MathUtils.random(0,106);
            letterToAnswer = KanaLettersFactory.getInstance().getKanaLettersList().get(randomVal).getHiraganaEquivalent();
            if (letterToAnswer == null) return;

            letterToAnswersLvl = LetterLvlCounter.getHiraganaLvlTable().get(letterToAnswer);
            while(letterToAnswersLvl >= 3 || currentLetter.equalsIgnoreCase(letterToAnswer)){
                if(cycleCounter >= 106){break;} else {cycleCounter++;}

                randomVal= MathUtils.random(0,106);
                letterToAnswer = KanaLettersFactory.getInstance().getKanaLettersList().get(randomVal).getHiraganaEquivalent();
                letterToAnswersLvl = LetterLvlCounter.getHiraganaLvlTable().get(letterToAnswer);
            }

            this.currentLetter = letterToAnswer;
            notify(letterToAnswer, BattleObserver.BattleEvent.HIRAGANA_ADDED);
        }
        else if(!LetterLvlCounter.areAllKatakanaMemorised()){
            cycleCounter = 0;
            randomVal = MathUtils.random(0,106);
            letterToAnswer = KanaLettersFactory.getInstance().getKanaLettersList().get(randomVal).getKatakanaEquivalent();
            if (letterToAnswer == null) return;

            letterToAnswersLvl = LetterLvlCounter.getKatakanaLvlTable().get(letterToAnswer);
            while(letterToAnswersLvl >= 3 || currentLetter.equalsIgnoreCase(letterToAnswer)){
                if(cycleCounter >= 106){break;} else {cycleCounter++;}
                randomVal= MathUtils.random(0,106);
                letterToAnswer = KanaLettersFactory.getInstance().getKanaLettersList().get(randomVal).getKatakanaEquivalent();
                letterToAnswersLvl = LetterLvlCounter.getKatakanaLvlTable().get(letterToAnswer);
            }
            this.currentLetter = letterToAnswer;
            notify(letterToAnswer, BattleObserver.BattleEvent.KATAKANA_ADDED);
        } else {
            cycleCounter = 0;
            letterToAnswer = EncounterFactory.getInstance().getRandomLetter(currentZoneLevel);
            if (letterToAnswer == null) return;

            letterToAnswersLvl = LetterLvlCounter.getKanjiLvlTable().get(letterToAnswer);
            while(letterToAnswersLvl >= 5 || currentLetter.equalsIgnoreCase(letterToAnswer)){
                if(cycleCounter >= 5){break;} else {cycleCounter++;}
                letterToAnswer = EncounterFactory.getInstance().getRandomLetter(currentZoneLevel);
                letterToAnswersLvl = LetterLvlCounter.getKanjiLvlTable().get(letterToAnswer);
            }
            this.currentLetter = letterToAnswer;
            notify(letterToAnswer, BattleObserver.BattleEvent.KANJI_ADDED);
        }
    }

    public void playerRuns(){
        int randomVal = MathUtils.random(1,100);
        if( chanceOfEscape > randomVal  ) {
            notify(currentLetter, BattleObserver.BattleEvent.PLAYER_RUNNING);
        }else{
            playerHit();
            return;
        }
    }

    public void playerHit(){
        if( currentLetter == null ){
            return;
        }

        notify(currentLetter, BattleObserver.BattleEvent.PLAYER_HIT_DAMAGE);

        Gdx.app.debug(TAG, "PLayer lost health");
    }

    public void answeredCorrectly(String answeredLetter){
        notify(answeredLetter, BattleObserver.BattleEvent.LETTER_ANSWERED_CORRECTLY);
    }


    public void answeredIncorrectly(String answeredLetter){
        if( currentLetter == null ){
            return;
        }

        notify(currentLetter, BattleObserver.BattleEvent.LETTER_ANSWERED_INCORRECTLY);

        Gdx.app.debug(TAG, "PLayer lost health");
    }
}
