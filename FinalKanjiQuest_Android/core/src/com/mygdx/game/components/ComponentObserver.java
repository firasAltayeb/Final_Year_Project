package com.mygdx.game.components;

public interface ComponentObserver {
    public static enum ComponentEvent {
        ENEMY_SPAWN_LOCATION_CHANGED,
        PLAYER_HAS_MOVED
    }

    void onNotify(final String value, ComponentEvent event);
}
