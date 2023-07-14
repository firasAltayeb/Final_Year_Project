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
    private final float checkTimer = 2.5f;
    private float battleTimer = 0;

    private Image hiro;
    private Texture texture;

    private Table topTable;
    private Table bottomTable;
    private Image imageToAnswer;

    private Table innerTableOne;
    private Table innerTableTwo;
    private Table innerTableThree;
    private Table innerTableFour;
    private float padBetweenTables;

    private String firstInnerTableEquivalent;
    private String secondInnerTableEquivalent;
    private String thirdInnerTableEquivalent;
    private String fourthInnerTableEquivalent;
    
    private KanaLetter equivalentImageOptionOne;
    private KanaLetter equivalentImageOptionTwo;
    private KanaLetter equivalentImageOptionThree;
    private KanaLetter equivalentImageOptionFour;
    private float padBetweenImages;

    private TextButton runButton = null;

    public BattleUI(){
        super("", Utility.GUI_SKINS, "solid_background");
        
        battleTimer = 0;
        battleState = new BattleState();
        battleState.addObserver(this);

        hiro = new Image(Utility.HIRO_TEXTUREATLAS.findRegion("hiro_left"));
        kanaLettersList = KanaLettersFactory.getInstance().getKanaLettersList();
        kanjiLettersList = KanjiLettersFactory.getInstance().getKanjiLettersList();

        imageToAnswer = new Image();

        padBetweenTables = this.getWidth()/2;
        innerTableOne = new Table();
        innerTableTwo = new Table();
        innerTableThree = new Table();
        innerTableFour = new Table();


        padBetweenImages = this.getWidth();
        equivalentImageOptionOne = new KanaLetter();
        equivalentImageOptionTwo = new KanaLetter();
        equivalentImageOptionThree = new KanaLetter();
        equivalentImageOptionFour = new KanaLetter();

        topTable = new Table();
        topTable.add(imageToAnswer).padRight(this.getWidth()/2);
        topTable.add(hiro).padLeft(this.getWidth()/2);

        bottomTable = new Table();
        runButton = new TextButton("Run", Utility.GUI_SKINS);

        this.add(topTable).expand().fill().padTop(this.getHeight()/1.5f);;
        this.row();
        this.add(bottomTable).padBottom(this.getHeight()/2);;
        this.row();
        this.add(runButton).left().padBottom(this.getHeight()/1.6f).padLeft(this.getWidth()/8);

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
            case 2:
                texture = new Texture(Gdx.files.internal("sprites/maps/cave.png"));
                this.background(new TextureRegionDrawable(new TextureRegion(texture)));
                break;
            case 3:
                texture = new Texture(Gdx.files.internal("sprites/maps/coast.png"));
                this.background(new TextureRegionDrawable(new TextureRegion(texture)));
                break;
            case 4:
                texture = new Texture(Gdx.files.internal("sprites/maps/ice_forest.png"));
                this.background(new TextureRegionDrawable(new TextureRegion(texture)));
                break;
            case 5:
                texture = new Texture(Gdx.files.internal("sprites/maps/desert_temple.png"));
                this.background(new TextureRegionDrawable(new TextureRegion(texture)));
                break;
            case 6:
                texture = new Texture(Gdx.files.internal("sprites/maps/lava.png"));
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
    public void onNotify(String letterToAnswer, BattleEvent event) {
        int randomVal;
        int randomChoice;
        KanjiLetter tempKanji;
        switch(event){
            case KANJI_ADDED:
                //question
                Gdx.app.log(TAG, "Kanji ToAnswer is " + letterToAnswer);
                kanjiToAnswer = KanjiLettersFactory.getInstance().getKanjiLetter(letterToAnswer);
                this.imageToAnswer.setDrawable(new TextureRegionDrawable(Utility.LARGE_KANJI_TEXTUREATLAS.findRegion(kanjiToAnswer.getKanjiNameID())));

                bottomTable.clear();
                innerTableOne.clear();
                innerTableTwo.clear();
                innerTableThree.clear();
                innerTableFour.clear();

                //answer options
                Image equivalent;
                String splitPortion;
                int indexOfFullStop;
                randomChoice = MathUtils.random(1,2);



                firstInnerTableEquivalent = kanjiToAnswer.getHiraganaEquivalent();
                for (int j = 0; j < firstInnerTableEquivalent.length(); j++) {
                    if (firstInnerTableEquivalent.charAt(j) == '.') {
                        try {
                            indexOfFullStop = firstInnerTableEquivalent.indexOf('.', j + 1);
                            splitPortion = firstInnerTableEquivalent.substring(j + 1, indexOfFullStop);
                            if(randomChoice == 1) {
                                equivalent = new Image(Utility.LARGE_HIRAGANA_TEXTUREATLAS.findRegion(splitPortion));
                            } else {
                                kanaToAnswer = KanaLettersFactory.getInstance().getHiraganaLetter(splitPortion);
                                equivalent = new Image(Utility.LARGE_KATAKANA_TEXTUREATLAS.
                                        findRegion(kanaToAnswer.getKatakanaEquivalent()));
                            }
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
                            if(randomChoice == 1) {
                                equivalent = new Image(Utility.LARGE_HIRAGANA_TEXTUREATLAS.findRegion(splitPortion));
                            } else {
                                kanaToAnswer = KanaLettersFactory.getInstance().getHiraganaLetter(splitPortion);
                                equivalent = new Image(Utility.LARGE_KATAKANA_TEXTUREATLAS.
                                        findRegion(kanaToAnswer.getKatakanaEquivalent()));
                            }
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
                            if(randomChoice == 1) {
                                equivalent = new Image(Utility.LARGE_HIRAGANA_TEXTUREATLAS.findRegion(splitPortion));
                            } else {
                                kanaToAnswer = KanaLettersFactory.getInstance().getHiraganaLetter(splitPortion);
                                equivalent = new Image(Utility.LARGE_KATAKANA_TEXTUREATLAS.
                                        findRegion(kanaToAnswer.getKatakanaEquivalent()));
                            }
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
                            if(randomChoice == 1) {
                                equivalent = new Image(Utility.LARGE_HIRAGANA_TEXTUREATLAS.findRegion(splitPortion));
                            } else {
                                kanaToAnswer = KanaLettersFactory.getInstance().getHiraganaLetter(splitPortion);
                                equivalent = new Image(Utility.LARGE_KATAKANA_TEXTUREATLAS.
                                        findRegion(kanaToAnswer.getKatakanaEquivalent()));
                            }
                            innerTableFour.add(equivalent).left();
                        } catch (Exception e) {
                        }

                    }
                }

                randomizeOrder(true);
                addTableListeners();

                break;
            case HIRAGANA_ADDED:
                bottomTable.clear();
                equivalentImageOptionOne.clear();
                equivalentImageOptionTwo.clear();
                equivalentImageOptionThree.clear();
                equivalentImageOptionFour.clear();

                Gdx.app.log(TAG, "Kana ToAnswer is " + letterToAnswer);
                kanaToAnswer = KanaLettersFactory.getInstance().getHiraganaLetter(letterToAnswer);
                imageToAnswer.setDrawable(new TextureRegionDrawable(Utility.LARGE_HIRAGANA_TEXTUREATLAS.findRegion(kanaToAnswer.getHiraganaEquivalent())));

                equivalentImageOptionOne = kanaToAnswer;
                equivalentImageOptionOne.setDrawable(new TextureRegionDrawable(Utility.LARGE_ROMAJI_TEXTUREATLAS.findRegion(equivalentImageOptionOne.getRomajiEquivalent())));
                Gdx.app.log(TAG, "equivalentImageOptionOne is " + equivalentImageOptionOne.getRomajiEquivalent());

                randomVal = MathUtils.random(0,106);
                equivalentImageOptionTwo = kanaLettersList.get(randomVal);
                equivalentImageOptionTwo.setDrawable(new TextureRegionDrawable(Utility.LARGE_ROMAJI_TEXTUREATLAS.findRegion(equivalentImageOptionTwo.getRomajiEquivalent())));
                Gdx.app.log(TAG, "equivalentImageOptionTwo is " + equivalentImageOptionTwo.getRomajiEquivalent());

                randomVal = MathUtils.random(0,106);
                equivalentImageOptionThree = kanaLettersList.get(randomVal);
                equivalentImageOptionThree.setDrawable(new TextureRegionDrawable(Utility.LARGE_ROMAJI_TEXTUREATLAS.findRegion(equivalentImageOptionThree.getRomajiEquivalent())));
                Gdx.app.log(TAG, "equivalentImageOptionThree is " + equivalentImageOptionThree.getRomajiEquivalent());

                randomVal = MathUtils.random(0,106);
                equivalentImageOptionFour = kanaLettersList.get(randomVal);
                equivalentImageOptionFour.setDrawable(new TextureRegionDrawable(Utility.LARGE_ROMAJI_TEXTUREATLAS.findRegion(equivalentImageOptionFour.getRomajiEquivalent())));
                Gdx.app.log(TAG, "equivalentImageOptionFour is " + equivalentImageOptionFour.getRomajiEquivalent());

                randomizeOrder(false);
                addKanaImageListeners();

                break;
            case KATAKANA_ADDED:
                bottomTable.clear();
                equivalentImageOptionOne.clear();
                equivalentImageOptionTwo.clear();
                equivalentImageOptionThree.clear();
                equivalentImageOptionFour.clear();

                Gdx.app.log(TAG, "Kana ToAnswer is " + letterToAnswer);
                kanaToAnswer = KanaLettersFactory.getInstance().getKatakanaLetter(letterToAnswer);
                imageToAnswer.setDrawable(new TextureRegionDrawable(Utility.LARGE_KATAKANA_TEXTUREATLAS.findRegion(kanaToAnswer.getKatakanaEquivalent())));

                equivalentImageOptionOne = kanaToAnswer;
                equivalentImageOptionOne.setDrawable(new TextureRegionDrawable(Utility.LARGE_HIRAGANA_TEXTUREATLAS.findRegion(equivalentImageOptionOne.getHiraganaEquivalent())));
                Gdx.app.log(TAG, "equivalentImageOptionOne is " + equivalentImageOptionOne.getHiraganaEquivalent());

                randomVal = MathUtils.random(0,106);
                equivalentImageOptionTwo = kanaLettersList.get(randomVal);
                equivalentImageOptionTwo.setDrawable(new TextureRegionDrawable(Utility.LARGE_HIRAGANA_TEXTUREATLAS.findRegion(equivalentImageOptionTwo.getHiraganaEquivalent())));
                Gdx.app.log(TAG, "equivalentImageOptionTwo is " + equivalentImageOptionTwo.getHiraganaEquivalent());

                randomVal = MathUtils.random(0,106);
                equivalentImageOptionThree = kanaLettersList.get(randomVal);
                equivalentImageOptionThree.setDrawable(new TextureRegionDrawable(Utility.LARGE_HIRAGANA_TEXTUREATLAS.findRegion(equivalentImageOptionThree.getHiraganaEquivalent())));
                Gdx.app.log(TAG, "equivalentImageOptionThree is " + equivalentImageOptionThree.getHiraganaEquivalent());

                randomVal = MathUtils.random(0,106);
                equivalentImageOptionFour = kanaLettersList.get(randomVal);
                equivalentImageOptionFour.setDrawable(new TextureRegionDrawable(Utility.LARGE_HIRAGANA_TEXTUREATLAS.findRegion(equivalentImageOptionFour.getHiraganaEquivalent())));
                Gdx.app.log(TAG, "equivalentImageOptionFour is " + equivalentImageOptionFour.getHiraganaEquivalent());

                randomizeOrder(false);
                addKanaImageListeners();

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

    public void randomizeOrder(boolean tables){
        int randomVal = MathUtils.random(0,3);
        switch (randomVal){
            case 0:
                if(tables) {
                    bottomTable.add(innerTableOne);
                    bottomTable.add(innerTableTwo).padLeft(padBetweenTables);
                    bottomTable.add(innerTableThree).padLeft(padBetweenTables);
                    bottomTable.add(innerTableFour).padLeft(padBetweenTables);
                } else {
                    bottomTable.add(equivalentImageOptionOne);
                    bottomTable.add(equivalentImageOptionTwo).padLeft(padBetweenImages);
                    bottomTable.add(equivalentImageOptionThree).padLeft(padBetweenImages);
                    bottomTable.add(equivalentImageOptionFour).padLeft(padBetweenImages);
                }
                break;
            case 1:
                if(tables) {
                    bottomTable.add(innerTableTwo);
                    bottomTable.add(innerTableOne).padLeft(padBetweenTables);
                    bottomTable.add(innerTableThree).padLeft(padBetweenTables);
                    bottomTable.add(innerTableFour).padLeft(padBetweenTables).padRight(padBetweenTables);
                } else {
                    bottomTable.add(equivalentImageOptionTwo);
                    bottomTable.add(equivalentImageOptionOne).padLeft(padBetweenImages);
                    bottomTable.add(equivalentImageOptionThree).padLeft(padBetweenImages);
                    bottomTable.add(equivalentImageOptionFour).padLeft(padBetweenImages);
                }
                break;
            case 2:
                if(tables) {
                    bottomTable.add(innerTableTwo);
                    bottomTable.add(innerTableThree).padLeft(padBetweenTables);
                    bottomTable.add(innerTableOne).padLeft(padBetweenTables);
                    bottomTable.add(innerTableFour).padLeft(padBetweenTables);
                } else {
                    bottomTable.add(equivalentImageOptionTwo);
                    bottomTable.add(equivalentImageOptionThree).padLeft(padBetweenImages);
                    bottomTable.add(equivalentImageOptionOne).padLeft(padBetweenImages);
                    bottomTable.add(equivalentImageOptionFour).padLeft(padBetweenImages);
                }
                break;
            case 3:
                if(tables) {
                    bottomTable.add(innerTableTwo);
                    bottomTable.add(innerTableThree).padLeft(padBetweenTables);
                    bottomTable.add(innerTableFour).padLeft(padBetweenTables);
                    bottomTable.add(innerTableOne).padLeft(padBetweenTables);
                }else {
                    bottomTable.add(equivalentImageOptionTwo);
                    bottomTable.add(equivalentImageOptionThree).padLeft(padBetweenImages);
                    bottomTable.add(equivalentImageOptionFour).padLeft(padBetweenImages);
                    bottomTable.add(equivalentImageOptionOne).padLeft(padBetweenImages);
                }
                break;
            default: break;
        }

    }

    public void addTableListeners(){
        innerTableOne.addListener(
                new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        Gdx.app.log(TAG, firstInnerTableEquivalent);
                        if(firstInnerTableEquivalent.equalsIgnoreCase(kanjiToAnswer.getHiraganaEquivalent()))
                            battleState.answeredCorrectly(kanjiToAnswer.getKanjiNameID());
                        else {
                            battleState.answeredIncorrectly(kanjiToAnswer.getKanjiNameID());
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
                            battleState.answeredCorrectly(kanjiToAnswer.getKanjiNameID());
                        else {
                            battleState.answeredIncorrectly(kanjiToAnswer.getKanjiNameID());
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
                            battleState.answeredCorrectly(kanjiToAnswer.getKanjiNameID());
                        else {
                            battleState.answeredIncorrectly(kanjiToAnswer.getKanjiNameID());
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
                            battleState.answeredCorrectly(kanjiToAnswer.getKanjiNameID());
                        else {
                            battleState.answeredIncorrectly(kanjiToAnswer.getKanjiNameID());
                        }
                    }
                }
        );

    }

    public void addKanaImageListeners(){
        equivalentImageOptionOne.addListener(
                new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        if(equivalentImageOptionOne.getHiraganaEquivalent().equalsIgnoreCase(kanaToAnswer.getHiraganaEquivalent()))
                            battleState.answeredCorrectly(kanaToAnswer.getHiraganaEquivalent());
                        else {
                            battleState.answeredIncorrectly(kanaToAnswer.getHiraganaEquivalent());
                        }

                    }
                }
        );
        equivalentImageOptionTwo.addListener(
                new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {;
                        if(equivalentImageOptionTwo.getHiraganaEquivalent().equalsIgnoreCase(kanaToAnswer.getHiraganaEquivalent()))
                            battleState.answeredCorrectly(kanaToAnswer.getHiraganaEquivalent());
                        else {
                            battleState.answeredIncorrectly(kanaToAnswer.getHiraganaEquivalent());
                        }
                    }
                }
        );
        equivalentImageOptionThree.addListener(
                new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        if(equivalentImageOptionThree.getHiraganaEquivalent().equalsIgnoreCase(kanaToAnswer.getHiraganaEquivalent()))
                            battleState.answeredCorrectly(kanaToAnswer.getHiraganaEquivalent());
                        else {
                            battleState.answeredIncorrectly(kanaToAnswer.getHiraganaEquivalent());
                        }
                    }
                }
        );
        equivalentImageOptionFour.addListener(
                new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        if(equivalentImageOptionFour.getHiraganaEquivalent().equalsIgnoreCase(kanaToAnswer.getHiraganaEquivalent()))
                            battleState.answeredCorrectly(kanaToAnswer.getHiraganaEquivalent());
                        else {
                            battleState.answeredIncorrectly(kanaToAnswer.getHiraganaEquivalent());
                        }
                    }
                }
        );

    }

}
