package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.audio.AudioManager;
import com.mygdx.game.audio.AudioObserver;
import com.mygdx.game.components.Component;
import com.mygdx.game.tools.Entity;
import com.mygdx.game.tools.EntityFactory;
import com.mygdx.game.FinalKanjiQuest;
import com.mygdx.game.gui.PlayerHUD;
import com.mygdx.game.maps.Map;
import com.mygdx.game.maps.MapManager;
import com.mygdx.game.profile.ProfileManager;

public class MainGameScreen extends GameScreen {

	private static final String TAG = MainGameScreen.class.getSimpleName();

	private static class VIEWPORT {
		static float viewportWidth;
		static float viewportHeight;
		static float virtualWidth;
		static float virtualHeight;
		static float physicalWidth;
		static float physicalHeight;
		static float aspectRatio;
	}

	public static enum GameState {
		SAVING,
		LOADING,
		RUNNING,
		PAUSED,
		GAME_OVER,

	}
	private static GameState gameState;

	protected OrthogonalTiledMapRenderer mapRenderer = null;
	protected OrthographicCamera camera = null;
	protected OrthographicCamera hudCamera = null;
	protected MapManager mapMgr;


	private Json json;
	private FinalKanjiQuest game;
	private InputMultiplexer multiplexer;

	private Entity player;
	private PlayerHUD playerHUD;

	public MainGameScreen(FinalKanjiQuest game){
		this.game = game;
		mapMgr = new MapManager();
		json = new Json();

		gameState = GameState.RUNNING;
		//_camera setup
		setupViewport(15, 15);

		//get the current size
		camera = new OrthographicCamera();
		camera.setToOrtho(false, VIEWPORT.viewportWidth, VIEWPORT.viewportHeight);

		player = EntityFactory.getEntity(EntityFactory.EntityType.PLAYER);
		mapMgr.setPlayer(player);
		mapMgr.setCamera(camera);

		hudCamera = new OrthographicCamera();
		hudCamera.setToOrtho(false, VIEWPORT.physicalWidth, VIEWPORT.physicalHeight);


		multiplexer = new InputMultiplexer();
		playerHUD = new PlayerHUD(hudCamera, player, multiplexer, mapMgr);
	}

	@Override
	public void show() {
		ProfileManager.getInstance().addObserver(mapMgr);
		ProfileManager.getInstance().addObserver(playerHUD);

		setGameState(GameState.LOADING);
		Gdx.input.setInputProcessor(multiplexer);

		if( mapRenderer == null ){
			mapRenderer = new OrthogonalTiledMapRenderer(mapMgr.getCurrentTiledMap(), Map.UNIT_SCALE);
		}
	}

	@Override
	public void hide() {
		if( gameState != GameState.GAME_OVER ){
			setGameState(GameState.SAVING);
		}

		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void render(float delta) {
		if( gameState == GameState.GAME_OVER ){
			game.setScreen(game.getScreenType(FinalKanjiQuest.ScreenType.GameOver));
		}

		if( gameState == GameState.PAUSED ){
			player.updateInput(delta);
			playerHUD.render(delta);
			//mapMgr.disableCurrentmapMusic();
			return;
		}

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		mapRenderer.setView(camera);

		if( mapMgr.hasMapChanged() ){
			mapRenderer.setMap(mapMgr.getCurrentTiledMap());
			player.sendMessage(Component.MESSAGE.INIT_START_POSITION, json.toJson(mapMgr.getPlayerStartUnitScaled()));

			camera.position.set(mapMgr.getPlayerStartUnitScaled().x, mapMgr.getPlayerStartUnitScaled().y, 0f);
			camera.update();

			mapMgr.setMapChanged(false);
		}

		mapRenderer.render();

		mapMgr.updateCurrentMapEntities(mapMgr, mapRenderer.getBatch(), delta );

		player.update(mapMgr, mapRenderer.getBatch(), delta);
		playerHUD.render(delta);
	}

	@Override
	public void resize(int width, int height) {
		setupViewport(15, 15);
		camera.setToOrtho(false, VIEWPORT.viewportWidth, VIEWPORT.viewportHeight);
		playerHUD.resize((int) VIEWPORT.physicalWidth, (int) VIEWPORT.physicalHeight);
	}

	@Override
	public void pause() {
		setGameState(GameState.SAVING);
	}

	@Override
	public void resume() {
		setGameState(GameState.LOADING);
	}

	@Override
	public void dispose() {
		if( player != null ){
			player.unregisterObservers();
			player.dispose();
		}

		if( mapRenderer != null ){
			mapRenderer.dispose();
		}

		AudioManager.getInstance().dispose();
	}

	public static void setGameState(GameState state){
		switch(state){
			case RUNNING:
				gameState = GameState.RUNNING;
				break;
			case LOADING:
				gameState = GameState.RUNNING;
				ProfileManager.getInstance().loadProfile();
				break;
			case SAVING:
				ProfileManager.getInstance().saveProfile();
				gameState = GameState.PAUSED;
				break;
			case PAUSED:
				if( gameState == GameState.PAUSED ){
					gameState = GameState.RUNNING;
				}else if( gameState == GameState.RUNNING ){
					gameState = GameState.PAUSED;
				}
				break;
			case GAME_OVER:
				gameState = GameState.GAME_OVER;
				break;
			default:
				gameState = GameState.RUNNING;
				break;
		}

	}

	private void setupViewport(int width, int height){
		//Make the viewport a percentage of the total display area
		VIEWPORT.virtualWidth = width;
		VIEWPORT.virtualHeight = height;

		//Current viewport dimensions
		VIEWPORT.viewportWidth = VIEWPORT.virtualWidth;
		VIEWPORT.viewportHeight = VIEWPORT.virtualHeight;

		//pixel dimensions of display
		VIEWPORT.physicalWidth = Gdx.graphics.getWidth();
		VIEWPORT.physicalHeight = Gdx.graphics.getHeight();

		//aspect ratio for current viewport
		VIEWPORT.aspectRatio = (VIEWPORT.virtualWidth / VIEWPORT.virtualHeight);

		//update viewport if there could be skewing
		if( VIEWPORT.physicalWidth / VIEWPORT.physicalHeight >= VIEWPORT.aspectRatio){
			//Letterbox left and right
			VIEWPORT.viewportWidth = VIEWPORT.viewportHeight * (VIEWPORT.physicalWidth/ VIEWPORT.physicalHeight);
			VIEWPORT.viewportHeight = VIEWPORT.virtualHeight;
		}else{
			//letterbox above and below
			VIEWPORT.viewportWidth = VIEWPORT.virtualWidth;
			VIEWPORT.viewportHeight = VIEWPORT.viewportWidth * (VIEWPORT.physicalHeight/ VIEWPORT.physicalWidth);
		}

		Gdx.app.debug(TAG, "WorldRenderer: virtual: (" + VIEWPORT.virtualWidth + "," + VIEWPORT.virtualHeight + ")" );
		Gdx.app.debug(TAG, "WorldRenderer: viewport: (" + VIEWPORT.viewportWidth + "," + VIEWPORT.viewportHeight + ")" );
		Gdx.app.debug(TAG, "WorldRenderer: physical: (" + VIEWPORT.physicalWidth + "," + VIEWPORT.physicalHeight + ")" );
	}

}