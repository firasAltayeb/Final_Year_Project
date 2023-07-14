package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.Component;
import com.mygdx.game.Entity;
import com.mygdx.game.EntityFactory;
import com.mygdx.game.FinalKanjiQuest;
import com.mygdx.game.gui.PlayerHUD;
import com.mygdx.game.maps.Map;
import com.mygdx.game.maps.MapManager;
import com.mygdx.game.profile.ProfileManager;

public class MainGameScreen implements Screen {

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
		RUNNING,
		PAUSED
	}
	private static GameState gameState;

	private OrthogonalTiledMapRenderer mapRenderer = null;
	private OrthographicCamera camera = null;
	private OrthographicCamera hudCamera = null;
	private static MapManager mapMgr;
	private Json json;
	private FinalKanjiQuest game;
	private InputMultiplexer multiplexer;

	private static Entity player;
	private static PlayerHUD playerHUD;

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

		mapRenderer = new OrthogonalTiledMapRenderer(mapMgr.getCurrentTiledMap(), Map.UNIT_SCALE);
		mapRenderer.setView(camera);
		mapMgr.setCamera(camera);

		Gdx.app.debug(TAG, "UnitScale value is: " + mapRenderer.getUnitScale());

		player = EntityFactory.getEntity(EntityFactory.EntityType.PLAYER);
		mapMgr.setPlayer(player);

		hudCamera = new OrthographicCamera();
		hudCamera.setToOrtho(false, VIEWPORT.physicalWidth, VIEWPORT.physicalHeight);

		playerHUD = new PlayerHUD(hudCamera, player);

		multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(playerHUD.getStage());
		multiplexer.addProcessor(player.getInputProcessor());
		Gdx.input.setInputProcessor(multiplexer);

		ProfileManager.getInstance().addObserver(playerHUD);
		ProfileManager.getInstance().addObserver(mapMgr);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(multiplexer);
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		mapRenderer.setView(camera);

		//mapRenderer.getBatch().enableBlending();
		//mapRenderer.getBatch().setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

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
		gameState = GameState.PAUSED;
		ProfileManager.getInstance().saveProfile();
	}

	@Override
	public void resume() {
		gameState = GameState.RUNNING;
		ProfileManager.getInstance().loadProfile();
	}

	@Override
	public void dispose() {
		player.dispose();
		mapRenderer.dispose();
	}

	public static void setGameState(GameState state){
		switch(state){
			case RUNNING:
				gameState = GameState.RUNNING;
				break;
			case PAUSED:
				if( gameState == GameState.PAUSED ){
					gameState = GameState.RUNNING;
					ProfileManager.getInstance().loadProfile();
				}else if( gameState == GameState.RUNNING ){
					gameState = GameState.PAUSED;
					ProfileManager.getInstance().saveProfile();
				}
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