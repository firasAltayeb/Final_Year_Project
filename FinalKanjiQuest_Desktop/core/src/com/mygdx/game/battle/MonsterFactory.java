package com.mygdx.game.battle;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.tools.Entity;
import com.mygdx.game.tools.EntityConfig;

import java.util.Hashtable;

public class MonsterFactory {

    private static MonsterFactory _instance = null;
    private Hashtable<String,Array<String> > monsterZones;

    public static MonsterFactory getInstance() {
        if (_instance == null) {
            _instance = new MonsterFactory();
        }

        return _instance;
    }

    private MonsterFactory(){
        monsterZones = MonsterZone.getMonsterZones("scripts/monster_zones.json");
    }


    public String getRandomMonster(int monsterZoneID){
        Array<String> monsters = monsterZones.get(String.valueOf(monsterZoneID));
        int size = monsters.size;
        if( size == 0 ){
            return null;
        }
        int randomIndex = MathUtils.random(size - 1);

        return monsters.get(randomIndex);
    }


}
