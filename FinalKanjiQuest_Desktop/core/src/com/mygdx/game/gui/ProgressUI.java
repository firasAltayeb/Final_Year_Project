package com.mygdx.game.gui;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.japanese.KanaLetter;
import com.mygdx.game.japanese.KanaLettersFactory;
import com.mygdx.game.japanese.LetterLvlCounter;
import com.mygdx.game.tools.Utility;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class ProgressUI extends Window implements ProgressSubject {

    private final static String TAG = ProgressUI.class.getSimpleName();

    private Label text;
    private String tempString;
    private int tempInt;
    private int hiraganaLvlCounter;
    private int katakanaLvlCounter;
    private Table table;
    private Table hiraganaTable;
    private Table katakanaTable;
    private KanaLetter kanaLetter;
    private ArrayList<KanaLetter> kanaLettersList;
    private Image equivalent;
    private float menuItemWindowWidth;
    private float menuItemWindowHeight;
    private Array<ProgressObserver> observers;

    private int hpCurrentMax = -1;
    private int hpVal = -1;

    public ProgressUI(float width, float height){
        super("Progress", Utility.GUI_SKINS);
        this.getTitleLabel().setAlignment(Align.center);

        menuItemWindowWidth = width;
        menuItemWindowHeight = height;
        observers = new Array<ProgressObserver>();

        this.pad(this.getPadTop() + menuItemWindowHeight / 15, 10,
                menuItemWindowHeight / 30, 10);


        table = new Table();
        hiraganaTable = new Table();
        katakanaTable = new Table();


        kanaLettersList = KanaLettersFactory.getInstance().getKanaLettersList();

        text = new Label("Hiragana", Utility.GUI_SKINS);
        table.add(text).left();
        table.row();

        for(int i = 0; i < kanaLettersList.size(); i++) {

            if(i % 4 == 0 ){
                hiraganaTable.row();
            }

            kanaLetter = kanaLettersList.get(i);
            tempString = kanaLetter.getHiraganaEquivalent();
            tempInt = LetterLvlCounter.getHiraganaLvlTable().get(tempString);
            equivalent = new Image(Utility.SMALL_HIRAGANA_TEXTUREATLAS.findRegion(tempString));

            //Gdx.app.debug(TAG, "tempString is " + tempString);

            if(tempInt >= 3){
                tempString = "memorised";
                text = new Label(tempString, Utility.GUI_SKINS, "progress_list_text");
            } else {
                tempString = "Lvl: " + LetterLvlCounter.getHiraganaLvlTable().get(tempString);
                text = new Label(tempString, Utility.GUI_SKINS, "list_text");
            }

            if(!LetterLvlCounter.areAllHiraganaMemorised()) {
                hiraganaLvlCounter += tempInt;
                if (hiraganaLvlCounter >= 321) {
                    LetterLvlCounter.setAllHiraganaMemorisedToTrue();
                }
                //Gdx.app.debug(TAG, "hiraganaLvlCounter is " + hiraganaLvlCounter);
            }

            hiraganaTable.add(equivalent).left();
            hiraganaTable.add(text).left().padRight(this.getWidth()/10);
        }

        table.add(hiraganaTable);
        table.row();

        text = new Label("Katakana", Utility.GUI_SKINS);
        table.add(text).left();
        table.row();

        for(int i = 0; i < kanaLettersList.size(); i++) {

            if(i % 4 == 0 ){
                katakanaTable.row();
            }

            kanaLetter = kanaLettersList.get(i);
            tempString = kanaLetter.getKatakanaEquivalent();
            tempInt = LetterLvlCounter.getKatakanaLvlTable().get(tempString);
            equivalent = new Image(Utility.SMALL_KATAKANA_TEXTUREATLAS.findRegion(tempString));

            //Gdx.app.debug(TAG, "tempString is " + tempString);

            if(tempInt >= 3){
                tempString = "memorised";
                text = new Label(tempString, Utility.GUI_SKINS, "progress_list_text");
            } else {
                tempString = "Lvl: " + LetterLvlCounter.getKatakanaLvlTable().get(tempString);
                text = new Label(tempString, Utility.GUI_SKINS, "list_text");
            }

            if(!LetterLvlCounter.areAllKatakanaMemorised()) {
                katakanaLvlCounter += tempInt;
                if (katakanaLvlCounter >= 321) {
                    LetterLvlCounter.setAllHiraganaMemorisedToTrue();
                }
                //Gdx.app.debug(TAG, "katakanaLvlCounter is " + katakanaLvlCounter);
            }

            katakanaTable.add(equivalent).left();
            katakanaTable.add(text).left().padRight(this.getWidth()/10);
        }

        table.add(katakanaTable);

        ScrollPane scrollPane = new ScrollPane(table);
        this.add(scrollPane).fill().expand();

        this.setSize(menuItemWindowWidth, menuItemWindowHeight);
        //this.debug();
    }

    public void updateSize(float width, float height){
        menuItemWindowWidth = width;
        menuItemWindowHeight = height;

        this.setSize(menuItemWindowWidth, menuItemWindowHeight);
    }

    //TODO speak about this
    public void updateTable(){
        hiraganaTable.clear();
        katakanaTable.clear();
        table.clear();
        this.clear();

        table = new Table();
        hiraganaTable = new Table();

        text = new Label("Hiragana", Utility.GUI_SKINS);
        table.add(text).left();
        table.row();

        for(int i = 0; i < kanaLettersList.size(); i++) {

            if(i % 4 == 0 ){
                hiraganaTable.row();
            }


            kanaLetter = kanaLettersList.get(i);
            tempString = kanaLetter.getHiraganaEquivalent();
            equivalent = new Image(Utility.SMALL_HIRAGANA_TEXTUREATLAS.findRegion(tempString));

            tempInt = LetterLvlCounter.getHiraganaLvlTable().get(tempString);

            if(tempInt >= 3){
                tempString = "memorised";
                text = new Label(tempString, Utility.GUI_SKINS, "progress_list_text");
            } else {
                tempString = "Lvl: " + LetterLvlCounter.getHiraganaLvlTable().get(tempString);
                text = new Label(tempString, Utility.GUI_SKINS, "list_text");
            }

            if(!LetterLvlCounter.areAllHiraganaMemorised()) {
                hiraganaLvlCounter += tempInt;
                if (hiraganaLvlCounter >= 321) {
                    LetterLvlCounter.setAllHiraganaMemorisedToTrue();
                }
            }

            hiraganaTable.add(equivalent).left();
            hiraganaTable.add(text).left().padRight(this.getWidth()/10);
        }

        table.add(hiraganaTable);
        table.row();

        text = new Label("Katakana", Utility.GUI_SKINS);
        table.add(text).left();
        table.row();

        for(int i = 0; i < kanaLettersList.size(); i++) {

            if(i % 4 == 0 ){
                katakanaTable.row();
            }

            kanaLetter = kanaLettersList.get(i);
            tempString = kanaLetter.getKatakanaEquivalent();
            tempInt = LetterLvlCounter.getKatakanaLvlTable().get(tempString);
            equivalent = new Image(Utility.SMALL_KATAKANA_TEXTUREATLAS.findRegion(tempString));

            //Gdx.app.debug(TAG, "tempString is " + tempString);

            if(tempInt >= 3){
                tempString = "memorised";
                text = new Label(tempString, Utility.GUI_SKINS, "progress_list_text");
            } else {
                tempString = "Lvl: " + LetterLvlCounter.getKatakanaLvlTable().get(tempString);
                text = new Label(tempString, Utility.GUI_SKINS, "list_text");
            }

            if(!LetterLvlCounter.areAllKatakanaMemorised()) {
                katakanaLvlCounter += tempInt;
                if (katakanaLvlCounter >= 321) {
                    LetterLvlCounter.setAllHiraganaMemorisedToTrue();
                }
                //Gdx.app.debug(TAG, "katakanaLvlCounter is " + katakanaLvlCounter);
            }

            katakanaTable.add(equivalent).left();
            katakanaTable.add(text).left().padRight(this.getWidth()/10);
        }

        table.add(katakanaTable);

        ScrollPane scrollPane = new ScrollPane(table);
        this.add(scrollPane).fill().expand();
        this.setSize(menuItemWindowWidth, menuItemWindowHeight);
    }

    //HP
    public int getHPValue(){
        return hpVal;
    }

    public void subtractHPValue(int hpValue){
        hpVal = MathUtils.clamp(hpVal - hpValue, 0, hpCurrentMax);
        notify(hpVal, ProgressObserver.StatusEvent.UPDATED_HP);
    }

    public void addHPValue(int hpValue){
        hpVal = MathUtils.clamp(hpVal + hpValue, 0, hpCurrentMax);
        notify(hpVal, ProgressObserver.StatusEvent.UPDATED_HP);
    }

    public void setHPValue(int hpValue){
        this.hpVal = hpValue;
        notify(hpVal, ProgressObserver.StatusEvent.UPDATED_HP);
    }

    public void setHPValueMax(int maxHPValue){
        this.hpCurrentMax = maxHPValue;
        notify(hpCurrentMax, ProgressObserver.StatusEvent.UPDATED_MAX_HP);
    }

    public int getHPValueMax(){
        return hpCurrentMax;
    }


    //Implement
    @Override
    public void addObserver(ProgressObserver progressObserver) {
        observers.add(progressObserver);
    }

    @Override
    public void removeObserver(ProgressObserver progressObserver) {
        observers.removeValue(progressObserver, true);
    }

    @Override
    public void removeAllObservers() {
        for(ProgressObserver observer: observers){
            observers.removeValue(observer, true);
        }
    }

    @Override
    public void notify(int value, ProgressObserver.StatusEvent event) {
        for(ProgressObserver observer: observers){
            observer.onNotify(value, event);
        }
    }


}
