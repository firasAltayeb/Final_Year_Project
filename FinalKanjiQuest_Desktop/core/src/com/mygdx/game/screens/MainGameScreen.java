package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Entity;
import com.mygdx.game.MapManger;
import com.mygdx.game.PlayerController;

public class MainGameScreen implements Screen {

    private static final String TAG = MainGameScreen.class.getSimpleName();

    public static class VIEWPORT {
        static float viewportWidth;
        static float viewportHeight;
        static float virtualWidth;
        static float virtualHeight;
        static float physicalWidth;
        static float physicalHeight;
        static float aspectRatio;
    }

    private PlayerController controller;
    private TextureRegion currentPlayerFrame;
    private Sprite currentPlayerSprite;
    private OrthogonalTiledMapRenderer mapRenderer = null;
    private OrthographicCamera camera = null;
    private static MapManger mapManger;

    public MainGameScreen() {
        mapManger = new MapManger();
    }

    private static Entity player;

    @Override
    public void show() {
        //camera setup
        setupViewport(15, 15);

        //get the current size
        camera = new OrthographicCamera();
        // set to false so we have positive y facing up
        camera.setToOrtho(false, VIEWPORT.viewportWidth, VIEWPORT.viewportHeight);

        mapRenderer = new OrthogonalTiledMapRenderer(mapManger.getCurrentMap(), MapManger.UNIT_SCALE);
        mapRenderer.setView(camera);

        Gdx.app.debug(TAG, "UniteScale value is: " + mapRenderer.getUnitScale());

        player = new Entity();
        player.init(mapManger.getPlayerStartUnitScaled().x,
                mapManger.getPlayerStartUnitScaled().y);

        currentPlayerSprite = player.getFrameSprite();

        //Gdx.app.debug(TAG, "currentSprite.y: "  + _currentPlayerSprite.getRegionHeight());

        controller = new PlayerController(player);
        Gdx.input.setInputProcessor(controller);
    }

    @Override
    public void hide() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //preferable to lock and center the camera to the player position
        camera.position.set(currentPlayerSprite.getX(),
                currentPlayerSprite.getY(), 0f);
        camera.update();

        player.update(delta);
        currentPlayerFrame = player.getFrame();

        //check if player activated a portal
        updatePortalLayerActivation(player.boundingBox);

        //if no collisions, will not update the player’s position
        if (!isCollisionWithMapLayer(player.boundingBox)) {
            player.setNextPositionToCurrent();
        }

        controller.update(delta);

        //_mapRenderer.getBatch().enableBlending();
        //_mapRenderer.getBatch().setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        mapRenderer.setView(camera);
        mapRenderer.render();

        mapRenderer.getBatch().begin();
        //frame, x & y position, width size * 1, height size * 2
        mapRenderer.getBatch().draw(currentPlayerFrame, currentPlayerSprite.getX(), currentPlayerSprite.getY(), 1, 2);
        mapRenderer.getBatch().end();
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
    public void dispose() {
        player.dispose();
        //controller.dispose();
        Gdx.input.setInputProcessor(null);
        mapRenderer.dispose();
    }

    private void setupViewport(int width, int height) {
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
            VIEWPORT.viewportWidth = VIEWPORT.viewportHeight * (VIEWPORT.physicalWidth/VIEWPORT.physicalHeight);
            VIEWPORT.viewportHeight = VIEWPORT.virtualHeight;
        }else{
            //letterbox above and below
            VIEWPORT.viewportWidth = VIEWPORT.virtualWidth;
            VIEWPORT.viewportHeight = VIEWPORT.viewportWidth * (VIEWPORT.physicalHeight/VIEWPORT.physicalWidth);
        }

        Gdx.app.debug(TAG, "WorldRenderer: virtual: (" + VIEWPORT.virtualWidth + ","
                + VIEWPORT.virtualHeight + ")" );
        Gdx.app.debug(TAG, "WorldRenderer: viewport: (" + VIEWPORT.viewportWidth + ","
                + VIEWPORT.viewportHeight + ")" );
        Gdx.app.debug(TAG, "WorldRenderer: physical: (" + VIEWPORT.physicalWidth + ","
                + VIEWPORT.physicalHeight + ")" );
    }

    private boolean isCollisionWithMapLayer(Rectangle boundingBox){
        MapLayer mapCollisionLayer = mapManger.getCollisionLayer();

        if (mapCollisionLayer == null){
            return false;
        }

        Rectangle rectangle = null;

        for (MapObject object : mapCollisionLayer.getObjects()){
            rectangle = ((RectangleMapObject) object).getRectangle();
            //Gdx.app.debug(TAG, "Collision Rect (" + rectangle.x + "," + rectangle.y + ")");
            //Gdx.app.debug(TAG, "Player Rect (" + boundingBox.x + "," + boundingBox.y + ")")
            if (boundingBox.overlaps(rectangle)){
                //Gdx.app.debug(TAG, "Map Collision!");
                return true;
            }
        }

        return false;
    }

    private boolean updatePortalLayerActivation(Rectangle boundingBox){
        MapLayer mapPortalLayer = mapManger.getPortalLayer();

        if (mapPortalLayer == null){
            return false;
        }

        Rectangle rectangle = null;

        for (MapObject object : mapPortalLayer.getObjects()){
            if(object instanceof RectangleMapObject){
                rectangle = ((RectangleMapObject)object).getRectangle();
                //Gdx.app.debug(TAG, "Collision Rect (" + rectangle.x + "," + rectangle.y + ")");
                //Gdx.app.debug(TAG, "Player Rect (" + boundingBox.x + "," + boundingBox.y + ")");
                if(boundingBox.overlaps(rectangle)){
                    String mapName = object.getName();
                    if(mapName == null){
                        return false;
                    }
                    mapManger.setClosestPlayerStartPositionFromScaledUnits
                            (player.getCurrentPosition());
                    mapManger.loadMap(mapName);
                    player.init(mapManger.getPlayerStartUnitScaled().x,
                            mapManger.getPlayerStartUnitScaled().y);
                    mapRenderer.setMap(mapManger.getCurrentMap());

                    Gdx.app.debug(TAG, "Portal Activated");
                    return true;
                }
            }
        }

        return false;
    }



}
