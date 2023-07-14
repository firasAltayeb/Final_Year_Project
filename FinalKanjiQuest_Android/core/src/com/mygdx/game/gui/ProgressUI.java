package com.mygdx.game.gui;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.japanese.KanaLetter;
import com.mygdx.game.japanese.KanaLettersFactory;
import com.mygdx.game.japanese.KanjiLetter;
import com.mygdx.game.japanese.KanjiLettersFactory;
import com.mygdx.game.japanese.LetterLvlCounter;
import com.mygdx.game.tools.Utility;

import java.util.ArrayList;

public class ProgressUI extends Window{

    private final static String TAG = ProgressUI.class.getSimpleName();

    private Label text;
    private int tempInt;
    private String tempString;

    private Table table;
    private Table hiraganaTable;
    private Table katakanaTable;
    private Table kanjiTable;

    private KanaLetter kanaLetter;
    private KanjiLetter kanjiLetter;
    private ArrayList<KanaLetter> kanaLettersList;
    private ArrayList<KanjiLetter> kanjiLettersList;

    private Image equivalent;
    private float menuItemWindowWidth;
    private float menuItemWindowHeight;

    public ProgressUI(float width, float height){
        super("Progress", Utility.GUI_SKINS);
        this.getTitleLabel().setAlignment(Align.center);

        menuItemWindowWidth = width;
        menuItemWindowHeight = height;

        this.pad(this.getPadTop() + menuItemWindowHeight / 15, 10,
                menuItemWindowHeight / 75, 10);


        table = new Table();
        hiraganaTable = new Table();
        katakanaTable = new Table();
        kanjiTable = new Table();

        kanaLettersList = KanaLettersFactory.getInstance().getKanaLettersList();
        kanjiLettersList = KanjiLettersFactory.getInstance().getKanjiLettersList();

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
        kanjiTable.clear();
        table.clear();
        this.clear();

        text = new Label("Hiragana", Utility.GUI_SKINS);
        table.add(text).left();
        table.row();

        for(int i = 0; i < kanaLettersList.size(); i++) {

            if(i % 4 == 0 ){
                hiraganaTable.row();
            }

            int counter = 0;
            kanaLetter = kanaLettersList.get(i);
            tempString = kanaLetter.getHiraganaEquivalent();
            tempInt = LetterLvlCounter.getHiraganaLvlTable().get(tempString);
            equivalent = new Image(Utility.MEDIUM_HIRAGANA_TEXTUREATLAS.findRegion(tempString));

            if(LetterLvlCounter.isAllHiraganaMemorised()) {
                tempString = "memorised";
                text = new Label(tempString, Utility.GUI_SKINS, "progress_list_text");
            }
            else {
                counter += tempInt;
                if (counter >= 428) {
                    LetterLvlCounter.setAllHiraganaMemorised(true);
                }
                if (tempInt >= 3) {
                    tempString = "memorised";
                    text = new Label(tempString + "", Utility.GUI_SKINS, "progress_list_text");
                } else {
                    tempString = "Lvl: " + LetterLvlCounter.getHiraganaLvlTable().get(tempString);
                    text = new Label(tempString, Utility.GUI_SKINS, "list_text");
                }
                //Gdx.app.debug(TAG, "hiraganaLvlCounter is " + hiraganaLvlCounter);
            }

            hiraganaTable.add(equivalent).left();
            hiraganaTable.add(text).left().padRight(this.getWidth()/75);
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

            int counter = 0;
            kanaLetter = kanaLettersList.get(i);
            tempString = kanaLetter.getKatakanaEquivalent();
            tempInt = LetterLvlCounter.getKatakanaLvlTable().get(tempString);
            equivalent = new Image(Utility.MEDIUM_KATAKANA_TEXTUREATLAS.findRegion(tempString));

            if(LetterLvlCounter.isAllKatakanaMemorised()) {
                tempString = "memorised";
                text = new Label(tempString, Utility.GUI_SKINS, "progress_list_text");
            }
            else {
                counter += tempInt;
                if (counter >= 428) {
                    LetterLvlCounter.setAllKatakanaMemorised(true);
                }
                if (tempInt >= 3) {
                    tempString = "memorised";
                    text = new Label(tempString + "", Utility.GUI_SKINS, "progress_list_text");
                } else {
                    tempString = "Lvl: " + LetterLvlCounter.getKatakanaLvlTable().get(tempString);
                    text = new Label(tempString, Utility.GUI_SKINS, "list_text");
                }
            }

            katakanaTable.add(equivalent).left();
            katakanaTable.add(text).left().padRight(this.getWidth()/75);
        }

        table.add(katakanaTable);
        table.row();

        text = new Label("Kanji", Utility.GUI_SKINS);
        table.add(text).left();
        table.row();

        for(int i = 0; i < kanjiLettersList.size()-1; i++) {

            if(i % 4 == 0 ){
                kanjiTable.row();
            }

            int counter = 0;
            kanjiLetter = kanjiLettersList.get(i);
            tempString = kanjiLetter.getKanjiNameID();
            tempInt = LetterLvlCounter.getKanjiLvlTable().get(tempString);
            equivalent = new Image(Utility.MEDIUM_KANJI_TEXTUREATLAS.findRegion(tempString));

            if(LetterLvlCounter.isAllKanjiMemorised()) {
                tempString = "memorised";
                text = new Label(tempString, Utility.GUI_SKINS, "progress_list_text");
            }
            else {
                counter += tempInt;
                if (counter >= 175) {
                    LetterLvlCounter.setAllKanjiMemorised(true);
                }
                if (tempInt >= 5) {
                    tempString = "memorised";
                    text = new Label(tempString, Utility.GUI_SKINS, "progress_list_text");
                } else {
                    tempString = "Lvl: " + LetterLvlCounter.getKanjiLvlTable().get(tempString);
                    text = new Label(tempString, Utility.GUI_SKINS, "list_text");
                }
            }

            kanjiTable.add(equivalent).left();
            kanjiTable.add(text).left().padRight(this.getWidth()/75);
        }

        table.add(kanjiTable).left();
        table.add();

        ScrollPane scrollPane = new ScrollPane(table);
        this.add(scrollPane).fill().expand();
        this.setSize(menuItemWindowWidth, menuItemWindowHeight);
    }


}
