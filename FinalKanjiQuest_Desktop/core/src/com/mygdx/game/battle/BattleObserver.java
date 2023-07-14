package com.mygdx.game.battle;

import com.mygdx.game.tools.Entity;

public interface BattleObserver {
    public static enum BattleEvent{
        KANJI_ADDED,
        HIRAGANA_ADDED,
        KATAKANA_ADDED,
        LETTER_ANSWERED_CORRECTLY,
        LETTER_ANSWERED_INCORRECTLY,
        PLAYER_HIT_DAMAGE,
        PLAYER_RUNNING,
        NONE
    }

    void onNotify(final String answeredLetter, BattleEvent event);
}
