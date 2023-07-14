package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.FinalKanjiQuest;
import com.mygdx.game.FinalKanjiQuest.ScreenType;
import com.mygdx.game.Utility;

public class MainMenuScreen implements Screen {

	private Stage stage;
	private FinalKanjiQuest game;

	public MainMenuScreen(FinalKanjiQuest game){
		this.game = game;

		//creation
		stage = new Stage();
		Table table = new Table();
		table.setFillParent(true);

		Label title = new Label("FKQ", Utility.GUI_SKINS);
		TextButton newGameButton = new TextButton("New Game", Utility.GUI_SKINS);
		TextButton loadGameButton = new TextButton("Load Game", Utility.GUI_SKINS);
		TextButton exitButton = new TextButton("Exit",Utility.GUI_SKINS);


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
										  MainMenuScreen.this.game.setScreen(MainMenuScreen.this.game.getScreenType(ScreenType.NewGame));
										  return true;
									  }
								  }
		);

		loadGameButton.addListener(new InputListener() {

									   @Override
									   public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
										   MainMenuScreen.this.game.setScreen(MainMenuScreen.this.game.getScreenType(ScreenType.LoadGame));
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


	}
	
	@Override
	public void render(float delta) {
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



