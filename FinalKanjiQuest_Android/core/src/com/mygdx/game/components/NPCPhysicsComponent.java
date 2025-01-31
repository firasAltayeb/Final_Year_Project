package com.mygdx.game.components;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.maps.MapManager;

public class NPCPhysicsComponent extends PhysicsComponent {

    private static final String TAG = NPCPhysicsComponent.class.getSimpleName();

    private com.mygdx.game.tools.Entity.State state;

    public NPCPhysicsComponent(){
        boundingBoxLocation = BoundingBoxLocation.CENTER;
        initBoundingBox(0.6f, 0.4f);
        super.velocity.set(3f,3f);
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
            } else if (string[0].equalsIgnoreCase(MESSAGE.CURRENT_STATE.toString())) {
                state = json.fromJson(com.mygdx.game.tools.Entity.State.class, string[1]);
            } else if (string[0].equalsIgnoreCase(MESSAGE.CURRENT_DIRECTION.toString())) {
                currentDirection = json.fromJson(com.mygdx.game.tools.Entity.Direction.class, string[1]);
            }
        }
    }

    @Override
    public void update(com.mygdx.game.tools.Entity entity, MapManager mapMgr, float delta) {
        updateBoundingBoxPosition(nextEntityPosition);

        if( state == com.mygdx.game.tools.Entity.State.IMMOBILE ) return;

        if (!isCollisionWithMapLayer(entity, mapMgr) &&
                !isCollisionWithMapEntities(entity, mapMgr) &&
                state == com.mygdx.game.tools.Entity.State.WALKING){
            setNextPositionToCurrent(entity);
        } else {
            updateBoundingBoxPosition(currentEntityPosition);
        }
        calculateNextPosition(delta);
    }

    @Override
    protected boolean isCollisionWithMapEntities(com.mygdx.game.tools.Entity entity, MapManager mapMgr){
        //Test against player
        if(isCollision(entity, mapMgr.getPlayer()) ) {
            return true;
        }

        if(super.isCollisionWithMapEntities(entity, mapMgr) ){
            return true;
        }

        return false;

    }
}
