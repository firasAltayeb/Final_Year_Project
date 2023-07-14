package com.mygdx.game.gui;


public interface ProgressObserver {
    public static enum StatusEvent {
        UPDATED_LEVEL,
        UPDATED_HP,
        UPDATED_MAX_HP,
    }

    void onNotify(final int value, StatusEvent event);
}
