package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.game.FinalKanjiQuest;
import com.mygdx.game.FinalKanjiQuest.ScreenType;
import com.mygdx.game.audio.AudioObserver;
import com.mygdx.game.tools.Utility;
import com.mygdx.game.profile.ProfileManager;

public class NewGameScreen extends GameScreen {

	private Stage stage;
	private final FinalKanjiQuest game;

	private Texture texture;
	private Sprite backgroundSprite;
	private final TextField profileText;
	private final Table middleTable;

	public NewGameScreen(FinalKanjiQuest fkq){
		this.game = fkq;
		stage = new Stage();

		//TopTable
		texture = new Texture(Gdx.files.internal("sprites/maps/topworld.png"));
		backgroundSprite = new Sprite(texture);

		Label profileName = new Label("Enter Profile Name: ", Utility.GUI_SKINS);
		profileText = new TextField("", Utility.GUI_SKINS);
		profileText.setMaxLength(20);

		Table topTable = new Table();
		topTable.padBottom(stage.getHeight()/2);
		topTable.setFillParent(true);
		topTable.add(profileName).center();
		topTable.row();
		topTable.add(profileText).fill();

		//MiddleTable
		Label overwriteLabel = new Label("Overwrite existing profile name?", Utility.GUI_SKINS);
		TextButton cancelButton = new TextButton("Cancel", Utility.GUI_SKINS, "inventory");
		TextButton overwriteButton = new TextButton("Overwrite", Utility.GUI_SKINS, "inventory");

		middleTable = new Dialog("Overwrite?", Utility.GUI_SKINS);
		middleTable.setWidth(Gdx.graphics.getWidth()/1.05f);
		middleTable.setHeight(Gdx.graphics.getHeight()/4);
		middleTable.setPosition(Gdx.graphics.getWidth()/40f, Gdx.graphics.getHeight()/4);

		middleTable.row();
		middleTable.add(overwriteLabel).left();
		middleTable.row();
		middleTable.add(overwriteButton).bottom().left();
		middleTable.add(cancelButton).bottom().right();
		middleTable.setVisible(false);

		//bottomTable
		TextButton startButton = new TextButton("Start", Utility.GUI_SKINS);
		TextButton backButton = new TextButton("Back", Utility.GUI_SKINS);

		Table bottomTable = new Table();
		bottomTable.setHeight(startButton.getHeight());
		bottomTable.setWidth(Gdx.graphics.getWidth());
		bottomTable.center();
		bottomTable.add(startButton).padRight(50);
		bottomTable.add(backButton);

		stage.addActor(topTable);
		stage.addActor(middleTable);
		stage.addActor(bottomTable);

		//Listeners
		cancelButton.addListener(new InputListener() {

									 @Override
									 public boolean touchDown(InputEvent event, float x, float y, int pointer, int button ){
										 middleTable.setVisible(false);
										 return true;
									 }
								 }
		);

		overwriteButton.addListener(new InputListener() {

										@Override
										public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
											String messageText = profileText.getText();
											ProfileManager.getInstance().writeProfileToStorage(messageText, "", true);
											ProfileManager.getInstance().setCurrentProfile(messageText);
											ProfileManager.getInstance().setIsNewProfile(true);
											middleTable.setVisible(false);
											NewGameScreen.this.notify(AudioObserver.AudioCommand.MUSIC_STOP, AudioObserver.AudioTypeEvent.MUSIC_TITLE);
											game.setScreen(game.getScreenType(ScreenType.MainGame));
											return true;
										}
									}
		);

		startButton.addListener(new InputListener() {

									@Override
									public boolean touchDown(InputEvent event, float x, float y, int pointer, int button ){
										String messageText = profileText.getText();

										if(messageText.length() < 1){
											return true;
										}

										//check to see if the current profile matches one that already exists
										boolean exists = false;

										exists = ProfileManager.getInstance().doesProfileExist(messageText);

										if( exists ){
											//Pop up dialog for Overwrite
											middleTable.setVisible(true);
										}else{
											ProfileManager.getInstance().writeProfileToStorage(messageText,"",false);
											ProfileManager.getInstance().setCurrentProfile(messageText);
											ProfileManager.getInstance().setIsNewProfile(true);
											NewGameScreen.this.notify(AudioObserver.AudioCommand.MUSIC_STOP, AudioObserver.AudioTypeEvent.MUSIC_TITLE);
											game.setScreen(game.getScreenType(ScreenType.MainGame));
										}

										return true;
									}
								}
		);

		backButton.addListener(new InputListener() {

								   @Override
								   public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
									   game.setScreen(game.getScreenType(ScreenType.MainMenu));
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
		middleTable.setVisible(false);
		profileText.setText("");
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void hide() {
		middleTable.setVisible(false);
		profileText.setText("");
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
