package com.mygdx.game.japanese;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class KanaLetter extends Image {

    private String hiraganaEquivalent;
    private String katakanaEquivalent;
    private String romajiEquivalent;

    public KanaLetter(){
        super();
    }

    public KanaLetter(KanaLetter kanaLetter){
        super();
        this.hiraganaEquivalent = kanaLetter.getHiraganaEquivalent();
        this.katakanaEquivalent = kanaLetter.getKatakanaEquivalent();
        this.romajiEquivalent = kanaLetter.getRomajiEquivalent();
    }

    public String getHiraganaEquivalent() {
        return hiraganaEquivalent;
    }

    public void setHiraganaNameID(String hiraganaNameID) {
        this.hiraganaEquivalent = hiraganaNameID;
    }

    public String getKatakanaEquivalent() {
        return katakanaEquivalent;
    }

    public void setKatakanaEquivalent(String katakanaEquivalent) {
        this.katakanaEquivalent = katakanaEquivalent;
    }

    public String getRomajiEquivalent() {
        return romajiEquivalent;
    }

    public void setRomajiEquivalent(String romajiEquivalent) {
        this.romajiEquivalent = romajiEquivalent;
    }


}
