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
    private final static String TOWN_OF_BEGINNINGS = "TOWN_OF_BEGINNINGS";
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

        mapTable.put(TOWN_OF_BEGINNINGS, "maps/town_of_beginnings.tmx" );
        mapTable.put(ARMORER, "maps/armorer.tmx" );
        mapTable.put(LIBRARY, "maps/library.tmx" );
        mapTable.put(HERBALIST, "maps/herbalist.tmx" );
        mapTable.put(HOUSE_ONE, "maps/house_one.tmx" );
        mapTable.put(INN_FIRST_FLOOR, "maps/inn_first_floor.tmx" );
        mapTable.put(INN_SECOND_FLOOR, "maps/inn_second_floor.tmx" );

        playerStartLocationTable = new Hashtable<>();
        playerStartLocationTable.put(TOWN_OF_BEGINNINGS, playerStart.cpy());
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
    

}
