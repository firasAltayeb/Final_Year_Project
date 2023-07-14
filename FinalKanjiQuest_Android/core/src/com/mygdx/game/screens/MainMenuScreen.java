package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.FinalKanjiQuest;
import com.mygdx.game.FinalKanjiQuest.ScreenType;
import com.mygdx.game.audio.AudioObserver;
import com.mygdx.game.tools.Utility;

public class MainMenuScreen extends GameScreen {

	private Stage stage;
	private final FinalKanjiQuest game;

    private Texture texture;
    private Sprite backgroundSprite;

	public MainMenuScreen(FinalKanjiQuest fkq){
		this.game = fkq;

		//creation
		stage = new Stage();
		Table table = new Table();
		table.setFillParent(true);

        texture = new Texture(Gdx.files.internal("sprites/maps/topworld.png"));
        backgroundSprite = new Sprite(texture);


		Label title = new Label("FKQ", Utility.GUI_SKINS, "title_text");
		TextButton newGameButton = new TextButton("New Game", Utility.GUI_SKINS);
		TextButton loadGameButton = new TextButton("Load Game", Utility.GUI_SKINS);
		TextButton exitButton = new TextButton("Exit", Utility.GUI_SKINS);

		//Layout
		table.add(title).spaceBottom(75).row();
		table.add(newGameButton).spaceBottom(10).row();
		table.add(loadGameButton).spaceBottom(10).row();
		table.add(exitButton).spaceBottom(10).row();

		stage.addActor(table);

		//Listeners
		newGameButton.addListener(new InputListener() {
									  @Override
									  public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
										  game.setScreen(game.getScreenType(ScreenType.NewGame));
										  return true;
									  }
								  }
		);

		loadGameButton.addListener(new InputListener() {

									   @Override
									   public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
										   game.setScreen(game.getScreenType(ScreenType.LoadGame));
										   return true;
									   }
								   }
		);

		exitButton.addListener(new InputListener() {

								   @Override
								   public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
									   Gdx.app.exit();
									   return true;
								   }

							   }
		);


		notify(AudioObserver.AudioCommand.MUSIC_LOAD, AudioObserver.AudioTypeEvent.MUSIC_TITLE);

	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.getBatch().begin();
        stage.getBatch().draw(backgroundSprite, 0, 0, stage.getWidth(), stage.getHeight());
        stage.getBatch().end();

		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().setScreenSize(width, height);
	}

	@Override
	public void show() {
		notify(AudioObserver.AudioCommand.MUSIC_PLAY_LOOP, AudioObserver.AudioTypeEvent.MUSIC_TITLE);
		Gdx.input.setInputProcessor(stage);
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
		stage.dispose();
	}
	
}



