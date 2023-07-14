package com.mygdx.game.gui;

import com.badlogic.gdx.Gdx;
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
import com.mygdx.game.tools.Utility;

import java.util.ArrayList;

public class KanjiUI extends Window{

    private final static String TAG = ProgressUI.class.getSimpleName();

    Table table;
    Table innerTable;
    float menuItemWindowWidth;
    float menuItemWindowHeight;

    public KanjiUI(float width, float height){
        super("Progress", Utility.GUI_SKINS);
        this.getTitleLabel().setAlignment(Align.center);

        menuItemWindowWidth = width;
        menuItemWindowHeight = height;

        this.pad(this.getPadTop() + menuItemWindowHeight / 30, 10,
                menuItemWindowHeight / 30, 10);

        Label text;
        String temp;
        String split;
        int indexOfFullStop;
        Image equivalent;
        innerTable = new Table();
        table = new Table();


        ArrayList<KanjiLetter> kanjiLettersList = KanjiLettersFactory.getInstance().getKanjiLettersList();

        //TODO speak about this,
        for(int i = 0; i < kanjiLettersList.size(); i++){

            if(i == 0){
                text = new Label("Forest Map", Utility.GUI_SKINS);
                table.add(text).align(Align.left);
                table.row();
            }
            else if(i == 5){
                table.add(innerTable);
                table.row();

                text = new Label("Cave Map", Utility.GUI_SKINS);
                table.add(text).align(Align.left);
                table.row();

                innerTable = new Table();
            }

            KanjiLetter kanjiLetter = kanjiLettersList.get(i);
            equivalent = new Image(Utility.MEDIUM_KANJI_TEXTUREATLAS.findRegion(kanjiLetter.getKanjiNameID()));
            innerTable.add(equivalent).left();
            text = new Label("Kanji meaning: " + kanjiLetter.getKanjiMeaning() + "\n" + "hiragana Equivalent: ", Utility.GUI_SKINS, "list_text");
            innerTable.add(text);

            //TODO speak about this,
            temp = kanjiLetter.getHiraganaEquivalent();

            for(int j = 0; j < temp.length(); j++){
                if (temp.charAt(j) == '.')
                {
                    try {
                        Gdx.app.log(TAG, "j is: " + j);
                        indexOfFullStop = temp.indexOf('.', j + 1);
                        split = temp.substring(j + 1, indexOfFullStop);
                        equivalent = new Image(Utility.SMALL_HIRAGANA_TEXTUREATLAS.findRegion(split));
                        innerTable.add(equivalent).left();
                    } catch (Exception e){}

                }

            }

            innerTable.row();
        }

        ScrollPane scrollPane = new ScrollPane(table);
        this.add(scrollPane).fill().expand();

        this.setSize(menuItemWindowWidth, menuItemWindowHeight);
        //this.debug();
    }

    public void updateSize(float width, float height){
        float newMenuItemWindowWidth = width;
        float newMenuItemWindowHeight = height;

        //if(newMenuItemWindowWidth > menuItemWindowWidth &&
        //        newMenuItemWindowHeight > menuItemWindowHeight){
        //    for(int i = 0; i <= table.getCells().size-1; i++){
        //
        //    }
        //}

        this.setSize(newMenuItemWindowWidth, newMenuItemWindowHeight);
    }


}
