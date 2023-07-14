package com.mygdx.game.battle;

import com.mygdx.game.tools.Entity;

public interface BattleObserver {
    public static enum BattleEvent{
        KANJI_ADDED,
        KANA_ADDED,
        OPPONENT_HIT_DAMAGE,
        OPPONENT_DEFEATED,
        PLAYER_HIT_DAMAGE,
        PLAYER_RUNNING,
        NONE
    }

    void onNotify(final String enemyMonster, BattleEvent event);
}
