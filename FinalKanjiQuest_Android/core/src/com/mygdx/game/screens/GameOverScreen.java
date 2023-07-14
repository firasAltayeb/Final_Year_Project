package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.FinalKanjiQuest;
import com.mygdx.game.audio.AudioObserver;
import com.mygdx.game.tools.Utility;

public class GameOverScreen extends GameScreen {

    private Stage stage;
    private final FinalKanjiQuest game;
    //private static final String DEATH_MESSAGE = "You have fought bravely, but alas, you have fallen during your epic struggle.";
    private static final String GAMEOVER = "Game Over";

    public GameOverScreen(FinalKanjiQuest fkq){
        this.game = fkq;

        //create
        stage = new Stage();
        TextButton continueButton = new TextButton("Continue", Utility.GUI_SKINS);
        TextButton mainMenuButton = new TextButton("Main Menu", Utility.GUI_SKINS);
        //Label messageLabel = new Label(DEATH_MESSAGE, Utility.GUI_SKINS);
        //messageLabel.setWrap(true);

        Label gameOverLabel = new Label(GAMEOVER, Utility.GUI_SKINS);
        gameOverLabel.setAlignment(Align.center);

        Table table = new Table();

        //Layout
        table.setFillParent(true);
        //table.add(messageLabel).pad(50, 50,50,50).expandX().fillX().row();
        table.add(gameOverLabel);
        table.row();
        table.add(continueButton).pad(50,50,10,50);
        table.row();
        table.add(mainMenuButton).pad(10,50,50,50);

        stage.addActor(table);

        //Listeners
        continueButton.addListener(new InputListener() {
                                       @Override
                                       public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                                           game.setScreen(game.getScreenType(FinalKanjiQuest.ScreenType.LoadGame));
                                           return true;
                                       }
                                   }
        );

        mainMenuButton.addListener(new InputListener() {

                                       @Override
                                       public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                                           game.setScreen(game.getScreenType(FinalKanjiQuest.ScreenType.MainMenu));
                                           return true;
                                       }
                                   }
        );

        notify(AudioObserver.AudioCommand.MUSIC_LOAD, AudioObserver.AudioTypeEvent.MUSIC_TITLE);

    }

    @Override
    public void render(float delta) {
        if( delta == 0){
            return;
        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().setScreenSize(width, height);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        notify(AudioObserver.AudioCommand.MUSIC_PLAY_LOOP, AudioObserver.AudioTypeEvent.MUSIC_TITLE);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        stage.clear();
        stage.dispose();
    }
}
