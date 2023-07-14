package com.mygdx.game;

/**
 * Created by firasAltayeb on 25/02/2017.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.*;

import java.util.Hashtable;

public class MapManger {

    private static final  String TAG = MapManger.class.getName();

    //all maps for the game
    private Hashtable<String, String> mapTable;
    private Hashtable<String, Vector2> playerStartLocationTable;

    //maps
    private final static String TOWN = "TOWN";
    private final static String ARMORER = "ARMORER";
    private final static String LIBRARY = "LIBRARY";
    private final static String HERBALIST = "HERBALIST";
    private final static String HOUSE_ONE = "HOUSE_ONE";
    private final static String INN_FIRST_FLOOR = "INN_FIRST_FLOOR";
    private final static String INN_SECOND_FLOOR = "INN_SECOND_FLOOR";

    //map layers
    private final static String MAP_COLLISION_LAYER = "MAP_COLLISION_LAYER";
    private final static String MAP_SPAWNS_LAYER = "MAP_SPAWNS_LAYER";
    private final static String MAP_PORTAL_LAYER = "MAP_PORTAL_LAYER";

    private final static String PLAYER_START = "PLAYER_START";

    private Vector2 playerStartPositionRect;
    private Vector2 closestPlayerStartPosition;
    private Vector2 convertedUnits;

    private Vector2 playerStart;
    private TiledMap currentMap = null;
    private String currentMapName;
    private MapLayer collisionLayer = null;
    private MapLayer portalLayer = null;
    private MapLayer spawnsLayer = null;

    public final static float UNIT_SCALE  = 1/16f;

    public MapManger(){
        playerStart = new Vector2(0,0);
        mapTable = new Hashtable();

        mapTable.put(TOWN, "maps/town.tmx" );
        mapTable.put(ARMORER, "maps/armorer.tmx" );
        mapTable.put(LIBRARY, "maps/library.tmx" );
        mapTable.put(HERBALIST, "maps/herbalist.tmx" );
        mapTable.put(HOUSE_ONE, "maps/house_one.tmx" );
        mapTable.put(INN_FIRST_FLOOR, "maps/inn_first_floor.tmx" );
        mapTable.put(INN_SECOND_FLOOR, "maps/inn_second_floor.tmx" );

        playerStartLocationTable = new Hashtable<>();
        playerStartLocationTable.put(TOWN, playerStart.cpy());
        playerStartLocationTable.put(ARMORER, playerStart.cpy());
        playerStartLocationTable.put(LIBRARY, playerStart.cpy());
        playerStartLocationTable.put(HERBALIST, playerStart.cpy());
        playerStartLocationTable.put(HOUSE_ONE, playerStart.cpy());
        playerStartLocationTable.put(INN_FIRST_FLOOR, playerStart.cpy());
        playerStartLocationTable.put(INN_SECOND_FLOOR, playerStart.cpy());

        playerStartPositionRect = new Vector2(0, 0);
        closestPlayerStartPosition = new Vector2(0, 0);
        convertedUnits = new Vector2(0, 0);
    }

    public void loadMap(String mapName){
        playerStart.set(0, 0);

        String mapFullPath = mapTable.get(mapName);

        if (mapFullPath == null || mapFullPath.isEmpty()){
            Gdx.app.debug(TAG, "Map is invalid");
            return;
        }

        if (currentMap != null){
            currentMap.dispose();
        }

        Utility.loadMapAsset(mapFullPath);
        if (Utility.isAssetLoaded(mapFullPath)){
            currentMap = Utility.getMapAsset(mapFullPath);
            currentMapName = mapName;
        } else {
            Gdx.app.debug(TAG, "Map not loaded");
            return;
        }

        collisionLayer = currentMap.getLayers().get(MAP_COLLISION_LAYER);
        if(collisionLayer == null){
            Gdx.app.debug(TAG, "No collision layer!");
        }

        portalLayer = currentMap.getLayers().get(MAP_PORTAL_LAYER);
        if(portalLayer == null){
            Gdx.app.debug(TAG, "No portal layer!");
        }

        spawnsLayer = currentMap.getLayers().get(MAP_SPAWNS_LAYER);
        if(spawnsLayer == null){
            Gdx.app.debug(TAG, "No spawns layer!");
        } else {
            Vector2 start = playerStartLocationTable.get(currentMapName);
            // If yes = player location not cached yet = first time map loaded
            if (start.isZero()){
                //cache player closest location
                setClosestStartPosition(playerStart);
                start = playerStartLocationTable.get(currentMapName);
            }
            playerStart.set(start.x, start.y);
        }

        Gdx.app.debug(TAG, "Player Start: (" + playerStart.x +
                ", "  + playerStart.y + ")");

    }

    public TiledMap getCurrentMap(){
        if (currentMap == null){
            currentMapName = TOWN;
            loadMap(currentMapName);
        }
        return  currentMap;
    }

    public MapLayer getCollisionLayer(){
        return collisionLayer;
    }

    public MapLayer getPortalLayer() {
        return portalLayer;
    }

    public Vector2 getPlayerStartUnitScaled(){
        Vector2 scaledPlayerStart = playerStart.cpy();
        scaledPlayerStart.set(playerStart.x * UNIT_SCALE,
                playerStart.y * UNIT_SCALE);
        return  scaledPlayerStart;
    }

    private void setClosestStartPosition(final  Vector2 position) {
        Gdx.app.debug(TAG, "setClosestStartPosition INPUT: (" + position.x + "," + position.y + ") " + currentMapName);

        //Get last known position on this map
        playerStartPositionRect.set(0,0);
        closestPlayerStartPosition.set(0,0);
        float shortestDistance = 0f;

        //Go through all player start positions and choose closest to last known position
        for( MapObject object: spawnsLayer.getObjects()){
            if( object.getName().equalsIgnoreCase(PLAYER_START) ){
                ((RectangleMapObject)object).getRectangle().getPosition(playerStartPositionRect);
                float distance = position.dst2(playerStartPositionRect);

                Gdx.app.debug(TAG, "distance: " + distance + " for " + currentMapName);

                if( distance < shortestDistance || shortestDistance == 0 ){
                    closestPlayerStartPosition.set(playerStartPositionRect);
                    shortestDistance = distance;
                    Gdx.app.debug(TAG, "closest START is: (" + closestPlayerStartPosition.x + ","
                            + closestPlayerStartPosition.y + ") " +  currentMapName);
                }
            }
        }
        playerStartLocationTable.put(currentMapName, closestPlayerStartPosition.cpy());
    }

    //scaled unit coordinate back to pixel coordinate
    public void setClosestPlayerStartPositionFromScaledUnits(Vector2 position){
        if (UNIT_SCALE <= 0)
            return;

        convertedUnits.set(position.x/UNIT_SCALE,
                position.y/UNIT_SCALE);
        setClosestStartPosition(convertedUnits);
    }




}
