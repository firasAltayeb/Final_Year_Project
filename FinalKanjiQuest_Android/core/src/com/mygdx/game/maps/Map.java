package com.mygdx.game.maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.components.Component;
import com.mygdx.game.tools.Entity;
import com.mygdx.game.tools.EntityConfig;
import com.mygdx.game.tools.EntityFactory;
import com.mygdx.game.tools.Utility;

import java.util.Hashtable;

public abstract class Map {
    private static final String TAG = Map.class.getSimpleName();

    public final static float UNIT_SCALE  = 1/16f;
    public static String specificPortal;

    //Map layers
    protected final static String COLLISION_LAYER = "MAP_COLLISION_LAYER";
    protected final static String SPAWNS_LAYER = "MAP_SPAWNS_LAYER";
    protected final static String PORTAL_LAYER = "MAP_PORTAL_LAYER";

    //Starting locations
    protected final static String PLAYER_START = "PLAYER_START";
    protected final static String NPC_START = "NPC_START";

    protected Json json;

    protected Vector2 playerStartPositionRect;
    protected Vector2 closestPlayerStartPosition;
    protected Vector2 convertedUnits;
    protected TiledMap currentMap = null;
    protected Vector2 playerStart;
    protected Array<Vector2> npcStartPositions;
    protected Hashtable<String, Vector2> specialNPCStartPositions;

    protected MapLayer collisionLayer = null;
    protected MapLayer portalLayer = null;
    protected MapLayer spawnsLayer = null;

    protected MapFactory.MapType currentMapType;
    protected Array<Entity> mapEntities;

    public Map(MapFactory.MapType mapType, String fullMapPath){
        json = new Json();
        mapEntities = new Array<Entity>(10);
        currentMapType = mapType;
        playerStart = new Vector2(0,0);
        playerStartPositionRect = new Vector2(0,0);
        closestPlayerStartPosition = new Vector2(0,0);
        convertedUnits = new Vector2(0,0);

        if( fullMapPath == null || fullMapPath.isEmpty() ) {
            Gdx.app.debug(TAG, "Map is invalid");
            return;
        }

        Utility.loadMapAsset(fullMapPath);
        if( Utility.isAssetLoaded(fullMapPath) ) {
            currentMap = Utility.getMapAsset(fullMapPath);
        }else{
            Gdx.app.debug(TAG, "Map not loaded");
            return;
        }

        collisionLayer = currentMap.getLayers().get(COLLISION_LAYER);
        if( collisionLayer == null ){
            Gdx.app.debug(TAG, "No collision layer!");
        }

        portalLayer = currentMap.getLayers().get(PORTAL_LAYER);
        if( portalLayer == null ){
            Gdx.app.debug(TAG, "No portal layer!");
        }

        spawnsLayer = currentMap.getLayers().get(SPAWNS_LAYER);
        if( spawnsLayer == null ){
            Gdx.app.debug(TAG, "No spawn layer!");
        }else{
            setClosestStartPosition(playerStart);
        }

        npcStartPositions = getNPCStartPositions();
        specialNPCStartPositions = getSpecialNPCStartPositions();
    }

    public abstract void updateMapEntities(MapManager mapMgr, Batch batch, float delta);

    private Array<Vector2> getNPCStartPositions(){
        Array<Vector2> npcStartPositions = new Array<Vector2>();

        for( MapObject object: spawnsLayer.getObjects()){
            String objectName = object.getName();

            if( objectName == null || objectName.isEmpty() ){
                continue;
            }

            if( objectName.equalsIgnoreCase(NPC_START) ){
                //Get center of rectangle
                float x = ((RectangleMapObject)object).getRectangle().getX();
                float y = ((RectangleMapObject)object).getRectangle().getY();

                //scale by the unit to convert from map coordinates
                x *= UNIT_SCALE;
                y *= UNIT_SCALE;

                npcStartPositions.add(new Vector2(x,y));
            }
        }
        return npcStartPositions;
    }

    private Hashtable<String, Vector2> getSpecialNPCStartPositions(){
        Hashtable<String, Vector2> specialNPCStartPositions = new Hashtable<String, Vector2>();

        for( MapObject object: spawnsLayer.getObjects()){
            String objectName = object.getName();

            if( objectName == null || objectName.isEmpty() ){
                continue;
            }

            //This is meant for all the special spawn locations, a catch all, so ignore known ones
            if( objectName.equalsIgnoreCase(NPC_START) ||
                    objectName.equalsIgnoreCase(PLAYER_START) ){
                continue;
            }

            //Get center of rectangle
            float x = ((RectangleMapObject)object).getRectangle().getX();
            float y = ((RectangleMapObject)object).getRectangle().getY();

            //scale by the unit to convert from map coordinates
            x *= UNIT_SCALE;
            y *= UNIT_SCALE;

            specialNPCStartPositions.put(objectName, new Vector2(x,y));
        }
        return specialNPCStartPositions;
    }

    public Vector2 getPlayerStartUnitScaled(){
        Vector2 playerStart = this.playerStart.cpy();
        playerStart.set(this.playerStart.x * UNIT_SCALE, this.playerStart.y * UNIT_SCALE);
        return playerStart;
    }

    //TODO speak about this
    public void setClosestStartPosition(final Vector2 position) {
        Gdx.app.debug(TAG, "setClosestStartPosition INPUT: (" + position.x + "," + position.y + ") " + currentMapType.toString());

        //Get last known position on this map
        playerStartPositionRect.set(0, 0);
        closestPlayerStartPosition.set(0, 0);
        float shortestDistance = 0f;

        //Go through all player start positions and choose closest to last known position
        for (MapObject object : spawnsLayer.getObjects()) {
            String objectName = object.getName();

            if (objectName == null || objectName.isEmpty()) {
                continue;
            }

            ((RectangleMapObject) object).getRectangle().getPosition(playerStartPositionRect);

            if (objectName.equalsIgnoreCase(PLAYER_START)) {
                closestPlayerStartPosition.set(playerStartPositionRect);
                playerStart = closestPlayerStartPosition.cpy();
            }
            else if (specificPortal != null) {
                //Gdx.app.debug(TAG, "specificPortal is not null");
                if (specificPortal.equalsIgnoreCase(objectName)) {
                    Gdx.app.debug(TAG, "specificPortal " + specificPortal + " activated");
                    closestPlayerStartPosition.set(playerStartPositionRect);
                    playerStart = closestPlayerStartPosition.cpy();
                    return;
                }
            }
        }


    }

    public Entity initEntity(EntityConfig entityConfig, Vector2 position){
        Entity entity = EntityFactory.getEntity(EntityFactory.EntityType.NPC);
        entity.setEntityConfig(entityConfig);

        entity.sendMessage(Component.MESSAGE.LOAD_ANIMATIONS, json.toJson(entity.getEntityConfig()));
        entity.sendMessage(Component.MESSAGE.INIT_START_POSITION, json.toJson(position));
        entity.sendMessage(Component.MESSAGE.INIT_STATE, json.toJson(entity.getEntityConfig().getState()));
        entity.sendMessage(Component.MESSAGE.INIT_DIRECTION, json.toJson(entity.getEntityConfig().getDirection()));

        return entity;
    }

    public Entity initSpecialEntity(EntityConfig entityConfig){
        Vector2 position = new Vector2(0,0);

        if( specialNPCStartPositions.containsKey(entityConfig.getEntityID()) ) {
            position = specialNPCStartPositions.get(entityConfig.getEntityID());
        }
        return initEntity(entityConfig, position);
    }

    public void setSpecificPortal(String  specificPortal){
        //Gdx.app.debug(TAG, "portalProperties are not null");
        this.specificPortal = specificPortal;
    }

    public Array<Entity> getMapEntities(){
        return mapEntities;
    }

    public Vector2 getPlayerStart() {
        return playerStart;
    }

    public void setPlayerStart(Vector2 playerStart) {
        this.playerStart = playerStart;
    }

    public MapLayer getCollisionLayer(){
        return collisionLayer;
    }

    public MapLayer getPortalLayer(){
        return portalLayer;
    }

    public TiledMap getCurrentTiledMap() {
        return currentMap;
    }

}
