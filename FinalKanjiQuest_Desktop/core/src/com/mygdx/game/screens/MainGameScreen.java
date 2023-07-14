package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.Entity;
import com.mygdx.game.MapManager;
import com.mygdx.game.PlayerController;

public class MainGameScreen implements Screen {
    private static final String TAG = MainGameScreen.class.getSimpleName();

    public static class VIEWPORT{
        static float viewportWidth;
        static float viewportHeight;
        static float virtualWidth;
        static float virtualHeight;
        static float physicalWidth;
        static float physicalHeight;
        static float aspectRaito;
    }

    private Playercontroller controller;
    private TextureRegion currentPlayerFrame;
    private Sprite currentPlayerSprite;

    private OrthogonalTiledMapRenderer mapRenderer = null;
    private OrthographicCamera camera = null;
    private static MapManger mapManger;

    private static Entity player;

    public MainGameScreen(){
        mapManger = new MapManger();
    }

    @Override
    public void show() {
        //camera setup
        setupViewport(10, 10);

        //get the current size
        camera = new OrthographicCamera();
        // set to false so we have positive y facing up
        camera.setToOrtho(false, VIEWPORT.viewportWidth, VIEWPORT.viewportHeight);
        mapRenderer = new OrthogonalTiledMapRenderer(mapManger.getCurrentMap(), mapManger.UNIT_SACLE);
        mapRenderer.setView(camera);

        Gdx.app.debug(TAG, "UniteScale value is: " + mapRenderer.getUnitScale());

        player = new Entity();
        player.init(mapManger.getPlayerStartUnitScaled().x,
            mapManger.getPlayerStartUnitScaled(),y);

        currentPlayerSprite = player.getFrameSprite();
        controller = new PlayerController(player);
        Gdx.input.setInputProcessor(controller);
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
