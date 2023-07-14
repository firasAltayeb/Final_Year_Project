package com.mygdx.game.battle;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.tools.Entity;

public class BattleSubject {
    private Array<BattleObserver> observers;

    public BattleSubject(){
        observers = new Array<BattleObserver>();
    }

    public void addObserver(BattleObserver battleObserver){
        observers.add(battleObserver);
    }

    public void removeObserver(BattleObserver battleObserver){
        observers.removeValue(battleObserver, true);
    }

    protected void notify(final String monster, BattleObserver.BattleEvent event){
        for(BattleObserver observer: observers){
            observer.onNotify(monster, event);
        }
    }
}
