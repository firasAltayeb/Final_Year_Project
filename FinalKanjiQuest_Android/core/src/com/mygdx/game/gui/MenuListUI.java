package com.mygdx.game.gui;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.tools.Utility;

public class MenuListUI extends Window {

    private TextButton progressButton;
    private TextButton inventoryButton;
    private TextButton hiraganaButton;
    private TextButton katakanaButton;
    private TextButton kanjiButton;
    private TextButton mnemonicsButton;

    public MenuListUI(){
        super("Menu", Utility.GUI_SKINS);
        this.getTitleLabel().setAlignment(Align.center);

        progressButton = new TextButton("progress", Utility.GUI_SKINS);
        inventoryButton = new TextButton("inventory", Utility.GUI_SKINS);
        hiraganaButton = new TextButton("hiragana", Utility.GUI_SKINS);
        katakanaButton = new TextButton("katakana", Utility.GUI_SKINS);
        kanjiButton = new TextButton("kanji", Utility.GUI_SKINS);
        mnemonicsButton = new TextButton("mnemonics", Utility.GUI_SKINS);

        //Add to layout
        defaults().expand().fill();

        //account for the title padding
        this.pad(this.getPadTop() + 40, 10, 10, 10);

        this.add(progressButton);
        this.row();

        this.add(inventoryButton);
        this.row();

        this.add(hiraganaButton);
        this.row();

        this.add(katakanaButton);
        this.row();

        this.add(kanjiButton);
        this.row();

        this.add(mnemonicsButton);

        //this.debug();
        //this.pack();
    }

    public void updateSize(float width, float height){
        float newMenuItemWindowWidth = width;
        float newMenuItemWindowHeight = height;

        //this.pad(this.getPadTop() + newMenuItemWindowHeight/20, newMenuItemWindowWidth/20,
        //        newMenuItemWindowHeight/20, newMenuItemWindowWidth/20);

        this.setSize(newMenuItemWindowWidth, newMenuItemWindowHeight);
    }

    public TextButton getProgressButton() {
        return progressButton;
    }

    public TextButton getInventoryButton() {
        return inventoryButton;
    }

    public TextButton getHiraganaButton() {
        return hiraganaButton;
    }

    public TextButton getKatakanaButton() {
        return katakanaButton;
    }

    public TextButton getKanjiButton() {
        return kanjiButton;
    }

    public TextButton getMnemonicsButton() {
        return mnemonicsButton;
    }
}
