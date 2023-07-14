package com.mygdx.game.battle;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

import java.util.Hashtable;

public class EncounterFactory {

    private static EncounterFactory _instance = null;
    private Hashtable<String,Array<String> > encounterZones;

    public static EncounterFactory getInstance() {
        if (_instance == null) {
            _instance = new EncounterFactory();
        }

        return _instance;
    }

    private EncounterFactory(){
        encounterZones = EncounterZone.getMonsterZones("json_scripts/encounter_zones.json");
    }


    public String getRandomLetter(int monsterZoneID){
        Array<String> letters = encounterZones.get(String.valueOf(monsterZoneID));
        int size = letters.size;
        if( size == 0 ){
            return null;
        }
        int randomIndex = MathUtils.random(size - 1);

        return letters.get(randomIndex);
    }


}
