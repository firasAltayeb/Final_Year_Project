package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.FinalKanjiQuest;
import com.mygdx.game.profile.ProfileManager;
import com.mygdx.game.tools.Utility;


public class LoadGameScreen implements Screen {
    private Stage stage;
	private FinalKanjiQuest game;

	private Texture texture;
	private Sprite backgroundSprite;
	
	public LoadGameScreen(FinalKanjiQuest game){
		this.game = game;

		texture = new Texture(Gdx.files.internal("sprites/maps/topworld.png"));
		backgroundSprite = new Sprite(texture);

		//create
		stage = new Stage();
		TextButton loadButton = new TextButton("Load", Utility.GUI_SKINS);
		TextButton backButton = new TextButton("Back", Utility.GUI_SKINS);

		ProfileManager.getInstance().storeAllProfiles();
		Array<String> list = ProfileManager.getInstance().getProfileList();
		final List listItems = new List(Utility.GUI_SKINS, "inventory");
		listItems.setItems(list);
		ScrollPane scrollPane = new ScrollPane(listItems);

		scrollPane.setOverscroll(false, false);
		scrollPane.setFadeScrollBars(false);
		scrollPane.setScrollingDisabled(true, false);
		scrollPane.setScrollbarsOnTop(true);

		Table table = new Table();
		Table bottomTable = new Table();

		//Layout
		table.center();
		table.setFillParent(true);
		table.padBottom(loadButton.getHeight());
		table.add(scrollPane).center();

		bottomTable.setHeight(loadButton.getHeight());
		bottomTable.setWidth(Gdx.graphics.getWidth());
		bottomTable.center();
		bottomTable.add(loadButton).padRight(50);
		bottomTable.add(backButton);

		stage.addActor(table);
		stage.addActor(bottomTable);

		//Listeners
		backButton.addListener(new InputListener() {
								   @Override
								   public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
									   LoadGameScreen.this.game.setScreen(LoadGameScreen.this.game.getScreenType(FinalKanjiQuest.ScreenType.MainMenu));
									   return true;
								   }
							   }
		);

		loadButton.addListener(new InputListener() {
								   @Override
								   public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
									   String fileName = listItems.getSelected().toString();
									   if (fileName != null) {
										   FileHandle file = ProfileManager.getInstance().getProfileFile(fileName);
										   if (file != null) {
											   ProfileManager.getInstance().setCurrentProfile(fileName);
											   ProfileManager.getInstance().loadProfile();
											   LoadGameScreen.this.game.setScreen(LoadGameScreen.this.game.getScreenType(FinalKanjiQuest.ScreenType.MainGame));
										   }
									   }
									   return true;
								   }
							   }
		);
	}
	
	@Override
	public void render(float delta) {
		if( delta == 0){
			return;
		}
		
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
		stage.clear();
		stage.dispose();
	}

}
