package com.mygdx.game.inventory;

import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.SnapshotArray;
import com.mygdx.game.Utility;
import com.mygdx.game.inventory.InventoryItem;

public class InventorySlot extends Stack {

    //All slots have this default image
    private Stack defaultBackground;
    private Label numItemsLabel;

    public InventorySlot(){
        defaultBackground = new Stack();
        Image image = new Image(new NinePatch(Utility.GUI_TEXTUREATLAS.createPatch("dialog")));

        numItemsLabel = new Label("", Utility.GUI_SKINS);

        defaultBackground.add(image);

        defaultBackground.setName("background");

        this.add(defaultBackground);
        this.add(numItemsLabel);
    }

    @Override
    public void add(Actor actor) {
        super.add(actor);

        //if( numItemsLabel == null ){
        //    return;
        //}
        //
        //if( !actor.equals(defaultBackground) && !actor.equals(numItemsLabel) ) {
        //    incrementItemCount(true);
        //}
    }

    public void remove(Actor actor) {
        super.removeActor(actor);

        //if( numItemsLabel == null ){
        //    return;
        //}
        //
        //if( !actor.equals(defaultBackground) && !actor.equals(numItemsLabel) ) {
        //    decrementItemCount(true);
        //}
    }

    public void add(Array<Actor> array) {
        for( Actor actor : array){
            super.add(actor);

            //if( numItemsLabel == null ){
            //    return;
            //}
            //if( !actor.equals(defaultBackground) && !actor.equals(numItemsLabel) ) {
            //    incrementItemCount(true);
            //}
        }
    }

    public void clearAllInventoryItems(boolean sendRemoveNotifications) {
        if( hasItem() ){
            SnapshotArray<Actor> arrayChildren = this.getChildren();
            int numInventoryItems =  getNumItems();

            for(int i = 0; i < numInventoryItems; i++) {
                //decrementItemCount(sendRemoveNotifications);
                arrayChildren.pop();
            }
        }
    }

    public boolean hasItem(){
        if( hasChildren() ){
            SnapshotArray<Actor> items = this.getChildren();
            if( items.size > 2 ){
                return true;
            }
        }
        return false;
    }

    public int getNumItems(){
        if( hasChildren() ){
            SnapshotArray<Actor> items = this.getChildren();
            return items.size - 2;
        }
        return 0;
    }

    public InventoryItem getTopInventoryItem(){
        InventoryItem actor = null;
        if( hasChildren() ){
            SnapshotArray<Actor> items = this.getChildren();
            if( items.size > 2 ){
                actor = (InventoryItem) items.peek();
            }
        }
        return actor;
    }

}
