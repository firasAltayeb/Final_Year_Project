package com.mygdx.game.gui;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.Utility;
import com.badlogic.gdx.utils.Array;

public class StatusUI extends Window implements StatusSubject{

    private final static String TAG = StatusUI.class.getSimpleName();

    Table table;
    float menuItemWindowWidth;
    float menuItemWindowHeight;
    private Array<StatusObserver> observers;

    private int hpCurrentMax = -1;
    private int hpVal = -1;

    public StatusUI(float width, float height){
        super("Status", Utility.GUI_SKINS);

        menuItemWindowWidth = width;
        menuItemWindowHeight = height;

        this.pad(this.getPadTop() + menuItemWindowHeight / 20, menuItemWindowWidth / 20,
                menuItemWindowHeight / 20, menuItemWindowWidth / 20);

        Label text;
        table = new Table();

        observers = new Array<StatusObserver>();

        for(int i = 0; i <= 41; i++){
            text = new Label("firstText " + i, Utility.GUI_SKINS);
            table.add(text).align(Align.left);
            //table.add(text).size(menuItemWindowWidth/4, menuItemWindowHeight/30).align(Align.left);
            text = new Label("secondText " + i, Utility.GUI_SKINS);
            table.add(text).align(Align.left);;

            text = new Label("thirdText " + i, Utility.GUI_SKINS);
            table.add(text).align(Align.left);;

            text = new Label("fourthText " + i, Utility.GUI_SKINS);
            table.add(text).align(Align.left);;

            table.row();
        }

        //Gdx.app.debug(TAG, "scrollTable size " +  table.getCells().size);
        ScrollPane scrollPane = new ScrollPane(table);
        //scrollPane.setFillParent(true);
        this.add(scrollPane).fill().expand();

        this.setSize(menuItemWindowWidth, menuItemWindowHeight);
        this.debug();
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


    //HP
    public int getHPValue(){
        return hpVal;
    }

    public void removeHPValue(int hpValue){
        hpVal = MathUtils.clamp(hpVal - hpValue, 0, hpCurrentMax);
        notify(hpVal, StatusObserver.StatusEvent.UPDATED_HP);
    }

    public void addHPValue(int hpValue){
        hpVal = MathUtils.clamp(hpVal + hpValue, 0, hpCurrentMax);
        notify(hpVal, StatusObserver.StatusEvent.UPDATED_HP);
    }

    public void setHPValue(int hpValue){
        this.hpVal = hpValue;
        notify(hpVal, StatusObserver.StatusEvent.UPDATED_HP);
    }

    public void setHPValueMax(int maxHPValue){
        this.hpCurrentMax = maxHPValue;
    }

    public int getHPValueMax(){
        return hpCurrentMax;
    }


    //Implement
    @Override
    public void addObserver(StatusObserver statusObserver) {
        observers.add(statusObserver);
    }

    @Override
    public void removeObserver(StatusObserver statusObserver) {
        observers.removeValue(statusObserver, true);
    }

    @Override
    public void removeAllObservers() {
        for(StatusObserver observer: observers){
            observers.removeValue(observer, true);
        }
    }

    @Override
    public void notify(int value, StatusObserver.StatusEvent event) {
        for(StatusObserver observer: observers){
            observer.onNotify(value, event);
        }
    }


}
