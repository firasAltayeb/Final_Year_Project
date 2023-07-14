package com.mygdx.game.japanese;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import java.lang.String;

public class KanjiLetter extends Image {

    private String kanjiNameID;
    private String kanjiMeaning;
    private String kanjiMnemonic;
    private String hiraganaEquivalent;

    public KanjiLetter(){
        super();
    }

    public KanjiLetter(KanjiLetter kanaLetter){
        super();
        this.kanjiNameID = kanaLetter.getKanjiNameID();
        this.kanjiMeaning = kanaLetter.getKanjiMeaning();
        this.kanjiMnemonic = kanaLetter.getKanjiMnemonic();
        this.hiraganaEquivalent = kanaLetter.getHiraganaEquivalent();
    }

    public String getKanjiNameID() {
        return kanjiNameID;
    }

    public void setKanjiNameID(String kanjiNameID) {
        this.kanjiNameID = kanjiNameID;
    }

    public String getKanjiMeaning() {
        return kanjiMeaning;
    }

    public void setKanjiMeaning(String kanjiMeaning) {
        this.kanjiMeaning = kanjiMeaning;
    }

    public String getKanjiMnemonic() {
        return kanjiMnemonic;
    }

    public void setKanjiMnemonic(String kanjiMnemonic) {
        this.kanjiMnemonic = kanjiMnemonic;
    }

    public String getHiraganaEquivalent() {
        return hiraganaEquivalent;
    }

    public void setHiraganaEquivalent(String hiraganaEquivalent) {
        this.hiraganaEquivalent = hiraganaEquivalent;
    }
}
