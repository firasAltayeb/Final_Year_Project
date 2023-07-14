package com.mygdx.game.japanese;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.Scaling;
import com.mygdx.game.tools.Utility;

import java.util.ArrayList;
import java.util.Hashtable;

public class KanaLettersFactory {

    private Json json = new Json();
    private final String kanaJsonFilePath = "json_scripts/kana.json";
    private static KanaLettersFactory instance = null;
    private Hashtable<String, KanaLetter> hiraganaLettersTable;
    private Hashtable<String, KanaLetter> katakanaLettersTable;
    private ArrayList<KanaLetter> kanaLettersList;

    public static KanaLettersFactory getInstance() {
        if (instance == null) {
            instance = new KanaLettersFactory();
        }

        return instance;
    }

    private KanaLettersFactory(){
        ArrayList<JsonValue> list = json.fromJson(ArrayList.class, Gdx.files.internal(kanaJsonFilePath));
        hiraganaLettersTable = new Hashtable<String , KanaLetter>();
        katakanaLettersTable = new Hashtable<String , KanaLetter>();
        kanaLettersList = new ArrayList<KanaLetter>();

        for (JsonValue jsonVal : list) {
            KanaLetter kanaLetter = json.readValue(KanaLetter.class, jsonVal);
            hiraganaLettersTable.put(kanaLetter.getHiraganaEquivalent(), kanaLetter);
            katakanaLettersTable.put(kanaLetter.getKatakanaEquivalent(), kanaLetter);
            kanaLettersList.add(kanaLetter);
        }
    }

    public KanaLetter getHiraganaLetter(String hiraganaNameID){
        KanaLetter kanaLetter = new KanaLetter(hiraganaLettersTable.get(hiraganaNameID));
        kanaLetter.setDrawable(new TextureRegionDrawable(Utility.LARGE_HIRAGANA_TEXTUREATLAS.
                findRegion(kanaLetter.getHiraganaEquivalent())));
        kanaLetter.setScaling(Scaling.none);
        return kanaLetter;
    }

    public KanaLetter getKatakanaLetter(String katakanaNameID){
        KanaLetter kanaLetter = new KanaLetter(katakanaLettersTable.get(katakanaNameID));
        kanaLetter.setDrawable(new TextureRegionDrawable(Utility.LARGE_KATAKANA_TEXTUREATLAS.
                findRegion(kanaLetter.getKatakanaEquivalent())));
        kanaLetter.setScaling(Scaling.none);
        return kanaLetter;
    }

    public ArrayList<KanaLetter> getKanaLettersList() {
        return kanaLettersList;
    }
}
