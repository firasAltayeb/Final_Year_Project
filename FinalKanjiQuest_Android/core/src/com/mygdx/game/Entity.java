package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.mygdx.game.maps.MapManager;

import java.util.ArrayList;

public class Entity {
    private static final String TAG = Entity.class.getSimpleName();
    private Json json;
    private EntityConfig entityConfig;

    public static enum Direction {
        UP,
        UP_LEFT,
        UP_RIGHT,
        RIGHT,
        DOWN,
        DOWN_LEFT,
        DOWN_RIGHT,
        LEFT;

        static public Direction getRandomNext() {
            return Direction.values()[MathUtils.random(Direction.values().length - 1)];
        }

        public Direction getOpposite() {
            if( this == LEFT){
                return RIGHT;
            }else if( this == RIGHT){
                return LEFT;
            }else if( this == UP){
                return DOWN;
            }else if( this == UP_LEFT){
                return DOWN_RIGHT;
            }
            else if( this == UP_RIGHT){
                return DOWN_LEFT;
            }
            else if( this == DOWN_LEFT){
                return UP_RIGHT;
            }
            else if( this == DOWN_RIGHT){
                return UP_LEFT;
            }
            else {
                return UP;
            }
        }
    }

    public static enum State {
        IDLE,
        WALKING,

        IMMOBILE;//This should always be last

        static public State getRandomNext() {
            //Ignore IMMOBILE which should be last state
            return State.values()[MathUtils.random(State.values().length - 2)];
        }
    }

    public static enum AnimationType {
        WALK_LEFT,
        WALK_RIGHT,
        WALK_UP,
        WALK_UP_LEFT,
        WALK_UP_RIGHT,
        WALK_DOWN,
        WALK_DOWN_LEFT,
        WALK_DOWN_RIGHT,
        IDLE,
        IMMOBILE
    }

    public static int FRAME_WIDTH = 23;
    public static int FRAME_HEIGHT = 34;

    private static final int MAX_COMPONENTS = 5;
    private Array<Component> components;

    private InputComponent inputComponent;
    private GraphicsComponent graphicsComponent;
    private PhysicsComponent physicsComponent;

    public Entity(InputComponent inputComponent, PhysicsComponent physicsComponent, GraphicsComponent graphicsComponent){
        entityConfig = new EntityConfig();
        json = new Json();

        components = new Array<Component>(MAX_COMPONENTS);

        this.inputComponent = inputComponent;
        this.physicsComponent = physicsComponent;
        this.graphicsComponent = graphicsComponent;

        components.add(this.inputComponent);
        components.add(this.physicsComponent);
        components.add(this.graphicsComponent);
    }

    public EntityConfig getEntityConfig() {
        return entityConfig;
    }

    //(String ...) means you can add as much String param as you want
    public void sendMessage(Component.MESSAGE messageType, String ... args){
        String fullMessage = messageType.toString();

        for (String string : args) {
            fullMessage += Component.MESSAGE_TOKEN + string;
        }

        for(Component component: components){
            component.receiveMessage(fullMessage);
        }
    }

    public void update(MapManager mapMgr, Batch batch, float delta){
        inputComponent.update(this, delta);
        physicsComponent.update(this, mapMgr, delta);
        graphicsComponent.update(this, mapMgr, batch, delta);
    }

    public void dispose(){
        for(Component component: components){
            component.dispose();
        }
    }

    public Rectangle getCurrentBoundingBox(){
        return physicsComponent.boundingBox;
    }

    public void setEntityConfig(EntityConfig entityConfig){
        this.entityConfig = entityConfig;
    }

    public static EntityConfig getEntityConfig(String configFilePath){
        Json json = new Json();
        return json.fromJson(EntityConfig.class, Gdx.files.internal(configFilePath));
    }

    static public Array<EntityConfig> getEntityConfigs(String configFilePath){
        Json json = new Json();
        Array<EntityConfig> configs = new Array<EntityConfig>();

        ArrayList<JsonValue> list = json.fromJson(ArrayList.class, Gdx.files.internal(configFilePath));

        for (JsonValue jsonVal : list) {
            configs.add(json.readValue(EntityConfig.class, jsonVal));
        }

        return configs;
    }

}
