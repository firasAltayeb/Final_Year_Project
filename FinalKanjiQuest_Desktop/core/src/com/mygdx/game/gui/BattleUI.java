package com.mygdx.game.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.battle.BattleObserver;
import com.mygdx.game.battle.BattleState;
import com.mygdx.game.japanese.KanaLetter;
import com.mygdx.game.japanese.KanaLettersFactory;
import com.mygdx.game.tools.Utility;

import java.util.ArrayList;

public class BattleUI extends Window implements BattleObserver {

    private final static String TAG = BattleUI.class.getSimpleName();

    private ArrayList<KanaLetter> kanaLettersList;
    private BattleState battleState = null;
    private TextButton attackButton = null;
    private TextButton runButton = null;

    private Image equivalent;
    private float battleTimer = 0;
    private final float checkTimer = 5;

    public BattleUI(){
        super("", Utility.GUI_SKINS, "solid_background");

        battleTimer = 0;
        battleState = new BattleState();
        battleState.addObserver(this);


        kanaLettersList = KanaLettersFactory.getInstance().getKanaLettersList();

        equivalent = new Image(Utility.MEDIUM_HIRAGANA_TEXTUREATLAS.findRegion(
                KanaLettersFactory.getInstance().getHiraganaLetter("hiraganaHa").getHiraganaEquivalent()));
        equivalent.setTouchable(Touchable.disabled);

        Table table = new Table();
        attackButton = new TextButton("Attack", Utility.GUI_SKINS, "inventory");
        runButton = new TextButton("Run", Utility.GUI_SKINS);
        table.add(attackButton).pad(20, 20, 20, 20);
        table.row();
        table.add(runButton).pad(20, 20, 20, 20);

        this.add(equivalent);
        this.add(table);

        //this.pack();


        attackButton.addListener(
                new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        battleState.playerAttacks();
                    }
                }
        );

        runButton.addListener(
                new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        battleState.playerRuns();
                    }
                }
        );
    }

    public void battleZoneTriggered(int battleZoneValue){
        battleState.setCurrentZoneLevel(battleZoneValue);
    }

    public boolean isBattleReady(){
        if( battleTimer > checkTimer){
            Gdx.app.log(TAG, "battle is ready");
            battleTimer = 0;
            return battleState.isOpponentReady();
        }else{
            return false;
        }
    }

    public BattleState getCurrentState(){
        return battleState;
    }

    @Override
    public void onNotify(String enemy, BattleEvent event) {
        switch(event){
            case PLAYER_TURN_START:
                attackButton.setDisabled(true);
                attackButton.setTouchable(Touchable.disabled);
                break;
            case OPPONENT_ADDED:
                Gdx.app.log(TAG, "enemy is" + enemy);
                equivalent.setDrawable(new TextureRegionDrawable(Utility.LARGE_HIRAGANA_TEXTUREATLAS.findRegion(
                        KanaLettersFactory.getInstance().getHiraganaLetter(enemy).getHiraganaEquivalent())));
                break;
            case OPPONENT_HIT_DAMAGE:
                break;
            case OPPONENT_DEFEATED:
                break;
            case OPPONENT_TURN_DONE:
                 attackButton.setDisabled(false);
                 attackButton.setTouchable(Touchable.enabled);
                break;
            case PLAYER_TURN_DONE:
                battleState.opponentAttacks();
                break;
            default:
                break;
        }
    }

    @Override
    public void act(float delta){
        battleTimer = (battleTimer + delta)%60;
        //Gdx.app.log(TAG, "battleTimer is " + battleTimer);
        super.act(delta);
    }

}
