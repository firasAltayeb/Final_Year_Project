package com.mygdx.game.gui;

public interface InventoryObserver {
    public static enum InventoryEvent {
        ITEM_CONSUMED,
        ADD_WAND_AP,
        NONE
    }

    void onNotify(final String value, InventoryEvent event);
}
