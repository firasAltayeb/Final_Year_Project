package com.mygdx.game.maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.profile.ProfileManager;
import com.mygdx.game.profile.ProfileObserver;
import com.mygdx.game.tools.Entity;

public class MapManager implements ProfileObserver {

    private static final String TAG = MapManager.class.getSimpleName();
    private boolean mapChanged = false;
    private Camera camera;
    private Map currentMap;
    private Entity player;

    public MapManager(){
        ProfileManager.getInstance().addObserver(this);
    }

    @Override //TODO speak about this
    public void onNotify(ProfileManager profileManager, ProfileEvent event) {
        switch(event){
            case PROFILE_LOADED:
                //String currentMap = profileManager.getProperty("currentMapType", String.class);
                //MapFactory.MapType mapType;
                //if( currentMap == null || currentMap.isEmpty() ){
                //    mapType = MapFactory.MapType.TOWN;
                //}else{
                //    mapType = MapFactory.MapType.valueOf(currentMap);
                //}
                //loadMap(mapType);
                //
                //Vector2 currentMapStartPoistion = profileManager.getProperty("currentMapStartPoistion", Vector2.class);
                //if( currentMapStartPoistion != null ){
                //    MapFactory.getMap(mapType).setPlayerStart(currentMapStartPoistion);
                //}

                break;
            case SAVING_PROFILE:
                //if( this.currentMap != null ){
                //    profileManager.setProperty("currentMapType", this.currentMap.currentMapType.toString());
                //}
                //profileManager.setProperty("currentMapStartPoistion", this.currentMap.getPlayerStart());
                //break;
            default:
                break;
        }
    }

    public TiledMap getCurrentTiledMap(){
        if( currentMap == null ) {
            loadMap(MapFactory.MapType.TOWN);
        }
        return currentMap.getCurrentTiledMap();
    }

    public MapLayer getCollisionLayer(){
        return currentMap.getCollisionLayer();
    }

    public MapLayer getPortalLayer(){
        return currentMap.getPortalLayer();
    }

    public void loadMap(MapFactory.MapType mapType){
        Map map = MapFactory.getMap(mapType);
        map.setClosestStartPosition(map.playerStart);

        if( map == null ){
            Gdx.app.debug(TAG, "Map does not exist!  ");
            return;
        }

        currentMap = map;
        mapChanged = true;
        Gdx.app.debug(TAG, "Player Start: (" + currentMap.getPlayerStart().x + "," + currentMap.getPlayerStart().y + ")");
    }

    public Vector2 getPlayerStartUnitScaled() {
        return currentMap.getPlayerStartUnitScaled();
    }

    public void updateCurrentMapEntities(MapManager mapMgr, Batch batch, float delta){
        currentMap.updateMapEntities(mapMgr, batch, delta);
    }

    public final Array<Entity> getCurrentMapEntities(){
        return currentMap.getMapEntities();
    }

    public MapLayer getEnemySpawnLayer(){
        return currentMap.getEnemySpawnLayer();
    }

    public void setPlayer(Entity entity){
        this.player = entity;
    }

    public Entity getPlayer(){
        return this.player;
    }

    public void setCamera(Camera camera){
        this.camera = camera;
    }

    public Camera getCamera(){
        return camera;
    }

    public boolean hasMapChanged(){
        return mapChanged;
    }

    public void setMapChanged(boolean hasMapChanged){
        this.mapChanged = hasMapChanged;
    }

    public void setSpecificPortal(String specificPortal) {
        //Gdx.app.debug(TAG, "portalProperties are not null");
        currentMap.setSpecificPortal(specificPortal);
    }

}
