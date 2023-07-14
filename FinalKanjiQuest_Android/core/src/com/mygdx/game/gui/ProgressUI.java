package com.mygdx.game.gui;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.japanese.KanaLetter;
import com.mygdx.game.japanese.KanaLettersFactory;
import com.mygdx.game.tools.Utility;

import java.util.ArrayList;

public class ProgressUI extends Window implements ProgressSubject {

    private final static String TAG = ProgressUI.class.getSimpleName();

    Table table;
    float menuItemWindowWidth;
    float menuItemWindowHeight;
    private Array<ProgressObserver> observers;

    private int hpCurrentMax = -1;
    private int hpVal = -1;

    public ProgressUI(float width, float height){
        super("Status", Utility.GUI_SKINS);
        this.getTitleLabel().setAlignment(Align.center);

        menuItemWindowWidth = width;
        menuItemWindowHeight = height;
        observers = new Array<ProgressObserver>();

        this.pad(this.getPadTop() + menuItemWindowHeight / 30, 10,
                menuItemWindowHeight / 30, 10);

        Label text;
        Image equivalent;
        table = new Table();
        ArrayList<KanaLetter> kanaLettersList = KanaLettersFactory.getInstance().getKanaLettersList();
        //Gdx.app.log(TAG, "kanaLettersList size is " + kanaLettersList.size() );

        for(int i = 0; i < kanaLettersList.size()-1; i++){

            KanaLetter kanaLetter = kanaLettersList.get(i);
            equivalent = new Image(Utility.LARGE_HIRAGANA_TEXTUREATLAS.findRegion(kanaLetter.getHiraganaEquivalent()));
            table.add(equivalent).left();
            text = new Label("romaji Equivalent: ", Utility.GUI_SKINS, "progress_list_text");
            table.add(text).left();
            equivalent = new Image(Utility.SMALL_ROMAJI_SHEET_TEXTUREATLAS.findRegion(kanaLetter.getRomajiEquivalent()));
            table.add(equivalent).left();
            text = new Label("katakana Equivalent: ", Utility.GUI_SKINS, "progress_list_text");
            table.add(text);
            equivalent = new Image(Utility.SMALL_KATAKANA_SHEET_TEXTUREATLAS.findRegion(kanaLetter.getKatakanaEquivalent()));
            table.add(equivalent).left();

            table.row();
        }

        //Gdx.app.debug(TAG, "scrollTable size " +  table.getCells().size);
        ScrollPane scrollPane = new ScrollPane(table);
        //scrollPane.setFillParent(true);
        this.add(scrollPane).fill().expand();

        this.setSize(menuItemWindowWidth, menuItemWindowHeight);
        //this.debug();
    }

    public void updateSize(float width, float height){
        float newMenuItemWindowWidth = width;
        float newMenuItemWindowHeight = height;

        this.setSize(newMenuItemWindowWidth, newMenuItemWindowHeight);
    }


    //HP
    public int getHPValue(){
        return hpVal;
    }

    public void removeHPValue(int hpValue){
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
