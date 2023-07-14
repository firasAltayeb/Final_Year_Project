package com.mygdx.game.japanese;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

import java.util.ArrayList;
import java.util.Hashtable;

public class KanjiLettersFactory {

    private Json json = new Json();
    private final String kanjiJsonFilePath = "json_scripts/kanji.json";
    private static KanjiLettersFactory instance = null;
    private Hashtable<String, KanjiLetter> kanjiLettersTable;
    private ArrayList<KanjiLetter> kanjiLettersList;

    public static KanjiLettersFactory getInstance() {
        if (instance == null) {
            instance = new KanjiLettersFactory();
        }

        return instance;
    }

    private KanjiLettersFactory(){
        ArrayList<JsonValue> list = json.fromJson(ArrayList.class, Gdx.files.internal(kanjiJsonFilePath));
        kanjiLettersTable = new Hashtable<String , KanjiLetter>();
        kanjiLettersList = new ArrayList<KanjiLetter>();

        for (JsonValue jsonVal : list) {
            KanjiLetter kanjiLetter = json.readValue(KanjiLetter.class, jsonVal);
            kanjiLettersTable.put(kanjiLetter.getKanjiNameID(), kanjiLetter);
            kanjiLettersList.add(kanjiLetter);
        }
    }

    public KanjiLetter getKanjiLetter(String kanjiNameID){
        KanjiLetter kanjiLetter = new KanjiLetter(kanjiLettersTable.get(kanjiNameID));
        return kanjiLetter;
    }


    public ArrayList<KanjiLetter> getKanjiLettersList() {
        return kanjiLettersList;
    }
}
