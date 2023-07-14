package com.mygdx.game.gui;


public interface StatusObserver {
    public static enum StatusEvent {
        UPDATED_GP,
        UPDATED_LEVEL,
        UPDATED_HP,
        UPDATED_MP,
        UPDATED_XP
    }

    void onNotify(final int value, StatusEvent event);
}
