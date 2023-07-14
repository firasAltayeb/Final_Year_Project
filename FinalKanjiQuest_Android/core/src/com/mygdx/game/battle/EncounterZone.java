package com.mygdx.game.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

import java.util.ArrayList;
import java.util.Hashtable;

public class EncounterZone {
    private String zoneID;
    private String monsters;

    public String getZoneID() {
        return zoneID;
    }

    public void setZoneID(String zoneID) {
        this.zoneID = zoneID;
    }

    public String getMonsters() {
        return monsters;
    }

    public void setMonsters(String monsters) {
        this.monsters = monsters;
    }

    static public Hashtable<String, Array<String>> getMonsterZones(String configFilePath){
        Json json = new Json();
        Hashtable<String, Array<String>> monsterZones = new Hashtable<String, Array<String>>();

        //TODO talk about this,
        ArrayList<JsonValue> list = json.fromJson(ArrayList.class, Gdx.files.internal(configFilePath));

        String temp;
        String split;
        int indexOfFullStop;
        Array<String> monster;

        for (JsonValue jsonVal : list) {
            EncounterZone zone = json.readValue(EncounterZone.class, jsonVal);

            temp = zone.getMonsters();
            monster = new Array<>();

            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '.') {
                    try {
                        indexOfFullStop = temp.indexOf('.', j + 1);
                        split = temp.substring(j + 1, indexOfFullStop);
                        monster.add(split);
                    } catch (Exception e) {
                    }

                }
            }

            monsterZones.put(zone.getZoneID(), monster);
        }

        return monsterZones;
    }
}
