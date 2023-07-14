package com.mygdx.game.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.battle.BattleObserver;
import com.mygdx.game.battle.BattleState;
import com.mygdx.game.japanese.KanaLetter;
import com.mygdx.game.japanese.KanaLettersFactory;
import com.mygdx.game.japanese.KanjiLetter;
import com.mygdx.game.japanese.KanjiLettersFactory;
import com.mygdx.game.tools.Utility;

import java.util.ArrayList;

public class BattleUI extends Window implements BattleObserver {

    //TODO speak about this,
    private final static String TAG = BattleUI.class.getSimpleName();

    private KanjiLetter kanjiToAnswer;
    private KanaLetter kanaToAnswer;
    private ArrayList<KanaLetter> kanaLettersList;
    private ArrayList<KanjiLetter> kanjiLettersList;
    
    private BattleState battleState = null;
    private final float checkTimer = 5;
    private float battleTimer = 0;

    private Image hiro;
    private Texture texture;

    private Table topTable;
    private Table bottomTable;
    private Image imageToAnswer;
    private Table innerTableOne;

    private float padBetweenInnerTables;
    private Table innerTableTwo;
    private Table innerTableThree;
    private Table innerTableFour;

    private String firstInnerTableEquivalent;
    private String secondInnerTableEquivalent;
    private String thirdInnerTableEquivalent;
    private String fourthInnerTableEquivalent;
    
    private Image equivalentOptionOne;
    private Image equivalentOptionTwo;
    private Image equivalentOptionThere;
    private Image equivalentOptionFour;

    private TextButton runButton = null;

    public BattleUI(){
        super("", Utility.GUI_SKINS, "solid_background");
        
        battleTimer = 0;
        battleState = new BattleState();
        battleState.addObserver(this);

        hiro = new Image(Utility.HIRO_TEXTUREATLAS.findRegion("hiro_left"));
        kanaLettersList = KanaLettersFactory.getInstance().getKanaLettersList();
        kanjiLettersList = KanjiLettersFactory.getInstance().getKanjiLettersList();

        padBetweenInnerTables = this.getWidth()/5;
        innerTableOne = new Table();
        innerTableTwo = new Table();
        innerTableThree = new Table();
        innerTableFour = new Table();

        imageToAnswer = new Image();
        equivalentOptionOne = new Image();
        equivalentOptionTwo = new Image();
        equivalentOptionThere = new Image();
        equivalentOptionFour = new Image();

        topTable = new Table();
        topTable.add(imageToAnswer).padRight(this.getWidth()/2);
        topTable.add(hiro).padLeft(this.getWidth()/2);

        bottomTable = new Table();
        bottomTable.add(equivalentOptionOne);
        bottomTable.add(equivalentOptionTwo);
        bottomTable.add(equivalentOptionThere);
        bottomTable.add(equivalentOptionFour);

        runButton = new TextButton("Run", Utility.GUI_SKINS);

        this.add(topTable).expand().fill().padTop(this.getHeight()/1.5f);;
        this.row();
        this.add(bottomTable).padBottom(this.getHeight()/4);;
        this.row();
        this.add(runButton).left().padBottom(this.getHeight()/3).padLeft(this.getWidth()/8);

        runButton.addListener(
                new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        battleState.playerRuns();
                    }
                }
        );
    }

    public void battleZoneTriggered(int battleZoneValue){
        battleState.setCurrentZoneLevel(battleZoneValue);

        switch (battleZoneValue){
            case 1:
                texture = new Texture(Gdx.files.internal("sprites/maps/forest.png"));
                this.background(new TextureRegionDrawable(new TextureRegion(texture)));
                break;
            default: break;
        }

    }

    public boolean isBattleReady(){
        if( battleTimer > checkTimer){
            Gdx.app.log(TAG, "battle is ready");
            battleTimer = 0;
            return battleState.isOpponentReady();
        }else{
            return false;
        }
    }

    public BattleState getCurrentState(){
        return battleState;
    }

    @Override
    public void onNotify(String stringToAnswer, BattleEvent event) {
        switch(event){
            case KANJI_ADDED:
                //question
                Gdx.app.log(TAG, "imageToAnswer is " + stringToAnswer);
                kanjiToAnswer = KanjiLettersFactory.getInstance().getKanjiLetter(stringToAnswer);
                this.imageToAnswer.setDrawable(new TextureRegionDrawable(Utility.LARGE_KANJI_TEXTUREATLAS.findRegion(kanjiToAnswer.getKanjiNameID())));

                bottomTable.clear();
                innerTableOne.clear();
                innerTableTwo.clear();
                innerTableThree.clear();
                innerTableFour.clear();

                //answer options
                int randomVal;
                KanjiLetter tempKanji;
                Image equivalent;
                String splitPortion;
                int indexOfFullStop;

                firstInnerTableEquivalent = kanjiToAnswer.getHiraganaEquivalent();
                for (int j = 0; j < firstInnerTableEquivalent.length(); j++) {
                    if (firstInnerTableEquivalent.charAt(j) == '.') {
                        try {
                            indexOfFullStop = firstInnerTableEquivalent.indexOf('.', j + 1);
                            splitPortion = firstInnerTableEquivalent.substring(j + 1, indexOfFullStop);
                            equivalent = new Image(Utility.SMALL_HIRAGANA_TEXTUREATLAS.findRegion(splitPortion));
                            innerTableOne.add(equivalent).left();
                        } catch (Exception e) {
                        }

                    }
                }

                randomVal = MathUtils.random(0,29);
                tempKanji = kanjiLettersList.get(randomVal);

                secondInnerTableEquivalent = tempKanji.getHiraganaEquivalent();
                for (int j = 0; j < secondInnerTableEquivalent.length(); j++) {
                    if (secondInnerTableEquivalent.charAt(j) == '.') {
                        try {
                            indexOfFullStop = secondInnerTableEquivalent.indexOf('.', j + 1);
                            splitPortion = secondInnerTableEquivalent.substring(j + 1, indexOfFullStop);
                            equivalent = new Image(Utility.SMALL_HIRAGANA_TEXTUREATLAS.findRegion(splitPortion));
                            innerTableTwo.add(equivalent).left();
                        } catch (Exception e) {
                        }

                    }
                }

                randomVal = MathUtils.random(0,29);
                tempKanji = kanjiLettersList.get(randomVal);

                thirdInnerTableEquivalent = tempKanji.getHiraganaEquivalent();
                for (int j = 0; j < thirdInnerTableEquivalent.length(); j++) {
                    if (thirdInnerTableEquivalent.charAt(j) == '.') {
                        try {
                            indexOfFullStop = thirdInnerTableEquivalent.indexOf('.', j + 1);
                            splitPortion = thirdInnerTableEquivalent.substring(j + 1, indexOfFullStop);
                            equivalent = new Image(Utility.SMALL_HIRAGANA_TEXTUREATLAS.findRegion(splitPortion));
                            innerTableThree.add(equivalent).left();
                        } catch (Exception e) {
                        }

                    }
                }

                randomVal = MathUtils.random(0,29);
                tempKanji = kanjiLettersList.get(randomVal);

                fourthInnerTableEquivalent = tempKanji.getHiraganaEquivalent();
                for (int j = 0; j < fourthInnerTableEquivalent.length(); j++) {
                    if (fourthInnerTableEquivalent.charAt(j) == '.') {
                        try {
                            indexOfFullStop = fourthInnerTableEquivalent.indexOf('.', j + 1);
                            splitPortion = fourthInnerTableEquivalent.substring(j + 1, indexOfFullStop);
                            equivalent = new Image(Utility.SMALL_HIRAGANA_TEXTUREATLAS.findRegion(splitPortion));
                            innerTableFour.add(equivalent).left();
                        } catch (Exception e) {
                        }

                    }
                }

                randomizeOrder();
                addInnerTableListeners();

                break;
            default:
                break;
        }
    }

    @Override
    public void act(float delta){
        battleTimer = (battleTimer + delta)%60;
        //Gdx.app.log(TAG, "battleTimer is " + battleTimer);
        super.act(delta);
    }

    public void randomizeOrder(){
        int randomVal = MathUtils.random(0,3);
        switch (randomVal){
            case 0:
                bottomTable.add(innerTableOne).padLeft(padBetweenInnerTables).padRight(padBetweenInnerTables);
                bottomTable.add(innerTableTwo).padLeft(padBetweenInnerTables);
                bottomTable.add(innerTableThree).padLeft(padBetweenInnerTables);
                bottomTable.add(innerTableFour).padLeft(padBetweenInnerTables).padRight(padBetweenInnerTables);
                break;
            case 1:
                bottomTable.add(innerTableTwo).padLeft(padBetweenInnerTables).padRight(padBetweenInnerTables);
                bottomTable.add(innerTableOne).padLeft(padBetweenInnerTables);
                bottomTable.add(innerTableThree).padLeft(padBetweenInnerTables);
                bottomTable.add(innerTableFour).padLeft(padBetweenInnerTables).padRight(padBetweenInnerTables);
                break;
            case 2:
                bottomTable.add(innerTableTwo).padLeft(padBetweenInnerTables).padRight(padBetweenInnerTables);
                bottomTable.add(innerTableThree).padLeft(padBetweenInnerTables);
                bottomTable.add(innerTableOne).padLeft(padBetweenInnerTables);
                bottomTable.add(innerTableFour).padLeft(padBetweenInnerTables).padRight(padBetweenInnerTables);
                break;
            case 3:
                bottomTable.add(innerTableTwo).padLeft(padBetweenInnerTables).padRight(padBetweenInnerTables);
                bottomTable.add(innerTableThree).padLeft(padBetweenInnerTables);
                bottomTable.add(innerTableFour).padLeft(padBetweenInnerTables);
                bottomTable.add(innerTableOne).padLeft(padBetweenInnerTables).padRight(padBetweenInnerTables);
                break;
            default: break;
        }

    }

    public void addInnerTableListeners(){
        innerTableOne.addListener(
                new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        Gdx.app.log(TAG, firstInnerTableEquivalent);
                        if(firstInnerTableEquivalent.equalsIgnoreCase(kanjiToAnswer.getHiraganaEquivalent()))
                            battleState.answeredCorrectly();
                        else {
                            battleState.answeredIncorrectly();
                        }

                    }
                }
        );
        innerTableTwo.addListener(
                new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        Gdx.app.log(TAG, secondInnerTableEquivalent);
                        if(secondInnerTableEquivalent.equalsIgnoreCase(kanjiToAnswer.getHiraganaEquivalent()))
                            battleState.answeredCorrectly();
                        else {
                            battleState.answeredIncorrectly();
                        }
                    }
                }
        );
        innerTableThree.addListener(
                new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        Gdx.app.log(TAG, thirdInnerTableEquivalent);
                        if(thirdInnerTableEquivalent.equalsIgnoreCase(kanjiToAnswer.getHiraganaEquivalent()))
                            battleState.answeredCorrectly();
                        else {
                            battleState.answeredIncorrectly();
                        }
                    }
                }
        );
        innerTableFour.addListener(
                new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        Gdx.app.log(TAG, fourthInnerTableEquivalent);
                        if(fourthInnerTableEquivalent.equalsIgnoreCase(kanjiToAnswer.getHiraganaEquivalent()))
                            battleState.answeredCorrectly();
                        else {
                            battleState.answeredIncorrectly();
                        }
                    }
                }
        );

    }

}
