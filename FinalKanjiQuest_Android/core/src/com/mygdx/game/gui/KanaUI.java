package com.mygdx.game.gui;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.japanese.KanaLetter;
import com.mygdx.game.japanese.KanaLettersFactory;
import com.mygdx.game.tools.Utility;

import java.util.ArrayList;

public class KanaUI extends Window{

    private final static String TAG = ProgressUI.class.getSimpleName();

    Table table;
    String kanaType;
    float menuItemWindowWidth;
    float menuItemWindowHeight;

    public KanaUI(float width, float height, String temp){
        super(temp, Utility.GUI_SKINS);
        this.getTitleLabel().setAlignment(Align.center);

        menuItemWindowWidth = width;
        menuItemWindowHeight = height;
        kanaType = temp;

        this.pad(this.getPadTop() + menuItemWindowHeight / 15, 10,
                menuItemWindowHeight / 30, 10);

        Label text;
        Image equivalent;
        table = new Table();

        ArrayList<KanaLetter> kanaLettersList = KanaLettersFactory.getInstance().getKanaLettersList();
        //Gdx.app.log(TAG, "kanaLettersList size is " + kanaLettersList.size() );

        for(int i = 0; i < kanaLettersList.size(); i++){

            if(this.kanaType.equalsIgnoreCase("hiragana")) {
                KanaLetter kanaLetter = kanaLettersList.get(i);
                equivalent = new Image(Utility.LARGE_HIRAGANA_TEXTUREATLAS.findRegion(kanaLetter.getHiraganaEquivalent()));
                table.add(equivalent).left();
                text = new Label("romaji" + "\n" + "Equivalent: ", Utility.GUI_SKINS, "list_text");
                table.add(text).left();
                equivalent = new Image(Utility.MEDIUM_ROMAJI_TEXTUREATLAS.findRegion(kanaLetter.getRomajiEquivalent()));
                table.add(equivalent).left();
                text = new Label("katakana" + "\n" + "Equivalent: ", Utility.GUI_SKINS, "list_text");
                table.add(text);
                equivalent = new Image(Utility.MEDIUM_KATAKANA_TEXTUREATLAS.findRegion(kanaLetter.getKatakanaEquivalent()));
                table.add(equivalent).left();
            }
            else {
                KanaLetter kanaLetter = kanaLettersList.get(i);
                equivalent = new Image(Utility.LARGE_KATAKANA_TEXTUREATLAS.findRegion(kanaLetter.getKatakanaEquivalent()));
                table.add(equivalent).left();
                text = new Label("romaji" + "\n" + "Equivalent: ", Utility.GUI_SKINS, "list_text");
                table.add(text).left();
                equivalent = new Image(Utility.MEDIUM_ROMAJI_TEXTUREATLAS.findRegion(kanaLetter.getRomajiEquivalent()));
                table.add(equivalent).left();
                text = new Label("hiragana" + "\n" + "Equivalent: ", Utility.GUI_SKINS, "list_text");
                table.add(text);
                equivalent = new Image(Utility.MEDIUM_HIRAGANA_TEXTUREATLAS.findRegion(kanaLetter.getHiraganaEquivalent()));
                table.add(equivalent).left();
            }

            table.row();
        }

        ScrollPane scrollPane = new ScrollPane(table);
        this.add(scrollPane).fill().expand();

        this.setSize(menuItemWindowWidth, menuItemWindowHeight);
        //this.debug();
    }

    public void updateSize(float width, float height){
        float newMenuItemWindowWidth = width;
        float newMenuItemWindowHeight = height;

        this.setSize(newMenuItemWindowWidth, newMenuItemWindowHeight);
    }


}
