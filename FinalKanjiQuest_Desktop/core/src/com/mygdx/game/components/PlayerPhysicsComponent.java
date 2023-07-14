package com.mygdx.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.tools.Entity;
import com.mygdx.game.maps.Map;
import com.mygdx.game.maps.MapFactory;
import com.mygdx.game.maps.MapManager;

public class PlayerPhysicsComponent extends PhysicsComponent {

    private static final String TAG = PlayerPhysicsComponent.class.getSimpleName();

    private Entity.State state;
    private Vector3 mouseSelectCoordinates;
    private boolean isMouseSelectEnabled = false;
    private Ray selectionRay;
    private float selectRayMaximumDistance = 30.0f;
    private String previousEnemySpawn;

    public PlayerPhysicsComponent(){
        boundingBoxLocation = BoundingBoxLocation.BOTTOM_CENTER;
        initBoundingBox(0.6f, 0.4f);
        super.velocity.set(15f,15f);
        previousEnemySpawn = "0";

        mouseSelectCoordinates = new Vector3(0,0,0);
        selectionRay = new Ray(new Vector3(), new Vector3());
    }

    @Override
    public void dispose(){
    }

    @Override
    public void receiveMessage(String message) {
        //Gdx.app.debug(TAG, "Got message " + message);
        String[] string = message.split(Component.MESSAGE_TOKEN);

        if( string.length == 0 ) return;

        //Specifically for messages with 1 object payload
        if( string.length == 2 ) {
            if (string[0].equalsIgnoreCase(MESSAGE.INIT_START_POSITION.toString())) {
                currentEntityPosition = json.fromJson(Vector2.class, string[1]);
                nextEntityPosition.set(currentEntityPosition.x, currentEntityPosition.y);
                previousEnemySpawn = "0";
                notify(previousEnemySpawn, ComponentObserver.ComponentEvent.ENEMY_SPAWN_LOCATION_CHANGED);
            } else if (string[0].equalsIgnoreCase(MESSAGE.CURRENT_STATE.toString())) {
                state = json.fromJson(Entity.State.class, string[1]);
            } else if (string[0].equalsIgnoreCase(MESSAGE.CURRENT_DIRECTION.toString())) {
                currentDirection = json.fromJson(Entity.Direction.class, string[1]);
            } else if (string[0].equalsIgnoreCase(MESSAGE.INIT_SELECT_ENTITY.toString())) {
                mouseSelectCoordinates = json.fromJson(Vector3.class, string[1]);
                isMouseSelectEnabled = true;
            }
        }
    }

    @Override
    public void update(Entity entity, MapManager mapMgr, float delta) {
        //We want the hitbox to be at the feet for a better feel
        updateBoundingBoxPosition(nextEntityPosition);
        updatePortalLayerActivation(mapMgr);
        updateEnemySpawnLayerActivation(mapMgr);

        if(isMouseSelectEnabled){
            selectMapEntityCandidate(mapMgr);
            isMouseSelectEnabled = false;
        }

        if (!isCollisionWithMapLayer(entity, mapMgr) &&
                !isCollisionWithMapEntities(entity, mapMgr) &&
                state == Entity.State.WALKING){
            setNextPositionToCurrent(entity);

            Camera camera = mapMgr.getCamera();
            camera.position.set(currentEntityPosition.x, currentEntityPosition.y, 0f);
            camera.update();
        }else{
            updateBoundingBoxPosition(currentEntityPosition);
        }

        calculateNextPosition(delta);
    }

    private void selectMapEntityCandidate(MapManager mapMgr){
        Array<Entity> currentEntities = mapMgr.getCurrentMapEntities();

        //Convert screen coordinates to world coordinates, then to unit scale coordinates
        mapMgr.getCamera().unproject(mouseSelectCoordinates);
        mouseSelectCoordinates.x /= Map.UNIT_SCALE;
        mouseSelectCoordinates.y /= Map.UNIT_SCALE;

        //Gdx.app.debug(TAG, "Mouse Coordinates " + "(" + mouseSelectCoordinates.x + "," + mouseSelectCoordinates.y + ")");

        for( Entity mapEntity : currentEntities ) {
            //Don't break, reset all entities
            mapEntity.sendMessage(MESSAGE.ENTITY_DESELECTED);
            Rectangle mapEntityBoundingBox = mapEntity.getCurrentBoundingBox();
            //Gdx.app.debug(TAG, "Entity Candidate Location " + "(" + mapEntityBoundingBox.x + "," + mapEntityBoundingBox.y + ")");
            if (mapEntity.getCurrentBoundingBox().contains(mouseSelectCoordinates.x, mouseSelectCoordinates.y)) {
                //Check distance
                selectionRay.set(boundingBox.x, boundingBox.y, 0.0f, mapEntityBoundingBox.x, mapEntityBoundingBox.y, 0.0f);
                float distance =  selectionRay.origin.dst(selectionRay.direction);

                if( distance <= selectRayMaximumDistance){
                    //We have a valid tools selection
                    //Picked/Selected
                    Gdx.app.debug(TAG, "Selected Entity! " + mapEntity.getEntityConfig().getEntityID());
                    mapEntity.sendMessage(MESSAGE.ENTITY_SELECTED);
                }
            }
        }
    }

    private boolean updateEnemySpawnLayerActivation(MapManager mapMgr){
        MapLayer mapEnemySpawnLayer =  mapMgr.getEnemySpawnLayer();

        if( mapEnemySpawnLayer == null ){
            return false;
        }

        Rectangle rectangle = null;

        for( MapObject object: mapEnemySpawnLayer.getObjects()){
            if(object instanceof RectangleMapObject) {
                rectangle = ((RectangleMapObject)object).getRectangle();

                if (boundingBox.overlaps(rectangle) ){
                    String enemySpawnID = object.getName();

                    if( enemySpawnID == null ) {
                        return false;
                    }

                    if( previousEnemySpawn.equalsIgnoreCase(enemySpawnID) ){
                        //Gdx.app.debug(TAG, "Enemy Spawn Area already activated " + enemySpawnID);
                        return true;
                    }else{
                        Gdx.app.debug(TAG, "Enemy Spawn Area " + enemySpawnID + " Activated with previous Spawn value: " + previousEnemySpawn);
                        previousEnemySpawn = enemySpawnID;
                    }

                    notify(enemySpawnID, ComponentObserver.ComponentEvent.ENEMY_SPAWN_LOCATION_CHANGED);
                    return true;
                }
            }
        }

        //If no collision, reset the value
        if( !previousEnemySpawn.equalsIgnoreCase(String.valueOf(0)) ){
            Gdx.app.debug(TAG, "Enemy Spawn Area RESET with previous value " + previousEnemySpawn);
            previousEnemySpawn = String.valueOf(0);
            notify(previousEnemySpawn, ComponentObserver.ComponentEvent.ENEMY_SPAWN_LOCATION_CHANGED);
        }

        return false;
    }

    private boolean updatePortalLayerActivation(MapManager mapMgr){
        MapLayer mapPortalLayer =  mapMgr.getPortalLayer();

        if( mapPortalLayer == null ){
            Gdx.app.debug(TAG, "Portal Layer doesn't exist!");
            return false;
        }

        Rectangle rectangle = null;

        for( MapObject object: mapPortalLayer.getObjects()){

            if(object instanceof RectangleMapObject) {
                rectangle = ((RectangleMapObject)object).getRectangle();

                if (boundingBox.overlaps(rectangle) ){

                    //TODO speak about this,
                    String mapName;
                    String specificPortal;
                    String temp = object.getName();
                    if( temp == null) {
                        return false;
                    }

                    if(temp.contains(".")) {
                        mapName = temp.substring(0, temp.indexOf('.'));
                        specificPortal = temp.substring(temp.indexOf('.')+1);
                        Gdx.app.log(TAG, "mapName is " + mapName);
                        Gdx.app.log(TAG, "specificPortal is " + specificPortal);
                    }
                    else {
                        specificPortal = "PLAYER_STAR";
                        mapName = temp;
                    }

                    mapMgr.setSpecificPortal(specificPortal);
                    mapMgr.loadMap(MapFactory.MapType.valueOf(mapName));


                    currentEntityPosition.x = mapMgr.getPlayerStartUnitScaled().x;
                    currentEntityPosition.y = mapMgr.getPlayerStartUnitScaled().y;
                    nextEntityPosition.x = mapMgr.getPlayerStartUnitScaled().x;
                    nextEntityPosition.y = mapMgr.getPlayerStartUnitScaled().y;

                    //mapMgr.setClosestStartPositionFromScaledUnits(currentEntityPosition);

                    Gdx.app.debug(TAG, "Portal Activated");
                    return true;
                }
            }
        }
        return false;
    }

}
