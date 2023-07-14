package com.mygdx.game.maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Entity;
import com.mygdx.game.profile.ProfileManager;
import com.mygdx.game.profile.ProfileObserver;

public class MapManager implements ProfileObserver {
    private static final String TAG = MapManager.class.getSimpleName();

    private Camera camera;
    private boolean mapChanged = false;
    private Map currentMap;
    private Entity player;

    public MapManager(){
    }

    @Override
    public void onNotify(ProfileManager profileManager, ProfileEvent event) {
        switch(event){
            case PROFILE_LOADED:
                String currentMap = profileManager.getProperty("currentMapType", String.class);
                MapFactory.MapType mapType;
                if( currentMap == null || currentMap.isEmpty() ){
                    mapType = MapFactory.MapType.TOWN;
                }else{
                    mapType = MapFactory.MapType.valueOf(currentMap);
                }
                loadMap(mapType);

                Vector2 townMapStartPosition = profileManager.getProperty("townMapStartPosition", Vector2.class);
                if( townMapStartPosition != null ){
                    MapFactory.getMap(MapFactory.MapType.TOWN).setPlayerStart(townMapStartPosition);
                }

                Vector2 armorerMapStartPosition = profileManager.getProperty("armorerMapStartPosition", Vector2.class);
                if( armorerMapStartPosition != null ){
                    MapFactory.getMap(MapFactory.MapType.ARMORER).setPlayerStart(armorerMapStartPosition);
                }

                Vector2 libraryMapStartPosition = profileManager.getProperty("libraryMapStartPosition", Vector2.class);
                if( libraryMapStartPosition != null ){
                    MapFactory.getMap(MapFactory.MapType.LIBRARY).setPlayerStart(libraryMapStartPosition);
                }

                Vector2 herbShopMapStartPosition = profileManager.getProperty("herbShopMapStartPosition", Vector2.class);
                if( herbShopMapStartPosition != null ){
                    MapFactory.getMap(MapFactory.MapType.HERB_SHOP).setPlayerStart(herbShopMapStartPosition);
                }

                Vector2 houseOneStartPosition = profileManager.getProperty("houseOneStartPosition", Vector2.class);
                if( houseOneStartPosition != null ){
                    MapFactory.getMap(MapFactory.MapType.HOUSE_ONE).setPlayerStart(houseOneStartPosition);
                }

                Vector2 innFirstFloorMapStartPosition = profileManager.getProperty("innFirstFloorMapStartPosition", Vector2.class);
                if( innFirstFloorMapStartPosition != null ){
                    MapFactory.getMap(MapFactory.MapType.INN_FIRST_FLOOR).setPlayerStart(innFirstFloorMapStartPosition);
                }

                Vector2 innSecondFloorMapStartPosition = profileManager.getProperty("innSecondFloorMapStartPosition", Vector2.class);
                if( innFirstFloorMapStartPosition != null ){
                    MapFactory.getMap(MapFactory.MapType.INN_SECOND_FLOOR).setPlayerStart(innSecondFloorMapStartPosition);
                }

                break;
            case SAVING_PROFILE:
                profileManager.setProperty("currentMapType", this.currentMap.currentMapType.toString());
                profileManager.setProperty("townMapStartPosition", MapFactory.getMap(MapFactory.MapType.TOWN).getPlayerStart() );
                profileManager.setProperty("armorerMapStartPosition", MapFactory.getMap(MapFactory.MapType.ARMORER).getPlayerStart() );
                profileManager.setProperty("libraryMapStartPosition", MapFactory.getMap(MapFactory.MapType.LIBRARY).getPlayerStart() );
                profileManager.setProperty("herbShopMapStartPosition", MapFactory.getMap(MapFactory.MapType.HERB_SHOP).getPlayerStart() );
                profileManager.setProperty("houseOneStartPosition", MapFactory.getMap(MapFactory.MapType.HOUSE_ONE).getPlayerStart() );
                profileManager.setProperty("innFirstFloorMapStartPosition", MapFactory.getMap(MapFactory.MapType.INN_FIRST_FLOOR).getPlayerStart() );
                profileManager.setProperty("innSecondFloorMapStartPosition", MapFactory.getMap(MapFactory.MapType.INN_SECOND_FLOOR).getPlayerStart() );
                break;
            default:
                break;
        }
    }

    public void loadMap(MapFactory.MapType mapType){
        Map map = MapFactory.getMap(mapType);

        if( map == null ){
            Gdx.app.debug(TAG, "Map does not exist!  ");
            return;
        }

        currentMap = map;
        mapChanged = true;
        Gdx.app.debug(TAG, "Player Start: (" + currentMap.getPlayerStart().x + "," + currentMap.getPlayerStart().y + ")");
    }

    public MapLayer getCollisionLayer(){
        return currentMap.getCollisionLayer();
    }

    public MapLayer getPortalLayer(){
        return currentMap.getPortalLayer();
    }

    public Vector2 getPlayerStartUnitScaled() {
        return currentMap.getPlayerStartUnitScaled();
    }

    public void setClosestStartPositionFromScaledUnits(Vector2 position) {
        currentMap.setClosestStartPositionFromScaledUnits(position);
    }


    public TiledMap getCurrentTiledMap(){
        if( currentMap == null ) {
            loadMap(MapFactory.MapType.TOWN);
        }
        return currentMap.getCurrentTiledMap();
    }

    public void updateCurrentMapEntities(MapManager mapMgr, Batch batch, float delta){
        currentMap.updateMapEntities(mapMgr, batch, delta);
    }

    public final Array<Entity> getCurrentMapEntities(){
        return currentMap.getMapEntities();
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
}
