package com.mygdx.game.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.ComponentObserver;
import com.mygdx.game.components.GraphicsComponent;
import com.mygdx.game.components.InputComponent;
import com.mygdx.game.components.PhysicsComponent;
import com.mygdx.game.maps.MapManager;
import com.mygdx.game.profile.ProfileManager;

import java.util.ArrayList;
import java.util.Hashtable;

public class Entity {
	private static final String TAG = Entity.class.getSimpleName();

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

	private Json json;
	private EntityConfig _entityConfig;
	private Array<Component> components;
	private InputComponent inputComponent;
	private GraphicsComponent graphicsComponent;
	private PhysicsComponent physicsComponent;

	public Entity(Entity entity){
		set(entity);
	}

	private Entity set(Entity entity) {
		inputComponent = entity.inputComponent;
		graphicsComponent = entity.graphicsComponent;
		physicsComponent = entity.physicsComponent;
		components = entity.components;
		json = entity.json;

		_entityConfig = new EntityConfig(entity._entityConfig);
		return this;
	}

	public Entity(InputComponent inputComponent, PhysicsComponent physicsComponent, GraphicsComponent graphicsComponent){
		_entityConfig = new EntityConfig();
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
		return _entityConfig;
	}

	public void sendMessage(Component.MESSAGE messageType, String ... args){
		String fullMessage = messageType.toString();

		for (String string : args) {
			fullMessage += Component.MESSAGE_TOKEN + string;
		}

		for(Component component: components){
			component.receiveMessage(fullMessage);
		}
	}

	public void registerObserver(ComponentObserver observer){
		inputComponent.addObserver(observer);
		physicsComponent.addObserver(observer);
		graphicsComponent.addObserver(observer);
	}

	public void unregisterObservers(){
		inputComponent.removeAllObservers();
		physicsComponent.removeAllObservers();
		graphicsComponent.removeAllObservers();
	}

	public void update(MapManager mapMgr, Batch batch, float delta){
		inputComponent.update(this, delta);
		physicsComponent.update(this, mapMgr, delta);
		graphicsComponent.update(this, mapMgr, batch, delta);
	}

	public void updateInput(float delta){
		inputComponent.update(this, delta);
	}

	public void dispose(){
		for(Component component: components){
			component.dispose();
		}
	}

	public Rectangle getCurrentBoundingBox(){
		return physicsComponent.boundingBox;
	}

	public Vector2 getCurrentPosition(){
		return graphicsComponent.currentPosition;
	}

	public InputProcessor getInputProcessor(){
		return inputComponent;
	}

	public void setEntityConfig(EntityConfig entityConfig){
		this._entityConfig = entityConfig;
	}

	public Animation getAnimation(Entity.AnimationType type){
		return graphicsComponent.getAnimation(type);
	}

	static public EntityConfig getEntityConfig(String configFilePath){
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

	public static EntityConfig loadEntityConfigByPath(String entityConfigPath){
		EntityConfig entityConfig = Entity.getEntityConfig(entityConfigPath);
		EntityConfig serializedConfig = ProfileManager.getInstance().getProperty(entityConfig.getEntityID(), EntityConfig.class);

		if( serializedConfig == null ){
			return entityConfig;
		}else{
			return serializedConfig;
		}
	}

	public static EntityConfig loadEntityConfig(EntityConfig entityConfig){
		EntityConfig serializedConfig = ProfileManager.getInstance().getProperty(entityConfig.getEntityID(), EntityConfig.class);

		if( serializedConfig == null ){
			return entityConfig;
		}else{
			return serializedConfig;
		}
	}

	public static Entity initEntity(EntityConfig entityConfig, Vector2 position){
		Json json = new Json();
		Entity entity = EntityFactory.getEntity(EntityFactory.EntityType.NPC);
		entity.setEntityConfig(entityConfig);

		entity.sendMessage(Component.MESSAGE.LOAD_ANIMATIONS, json.toJson(entity.getEntityConfig()));
		entity.sendMessage(Component.MESSAGE.INIT_START_POSITION, json.toJson(position));
		entity.sendMessage(Component.MESSAGE.INIT_STATE, json.toJson(entity.getEntityConfig().getState()));
		entity.sendMessage(Component.MESSAGE.INIT_DIRECTION, json.toJson(entity.getEntityConfig().getDirection()));

		return entity;
	}

	public static Hashtable<String, Entity> initEntities(Array<EntityConfig> configs){
		Json json = new Json();
		Hashtable<String, Entity> entities = new Hashtable<String, Entity>();
		for( EntityConfig config: configs ){
			Entity entity = EntityFactory.getEntity(EntityFactory.EntityType.NPC);

			entity.setEntityConfig(config);
			entity.sendMessage(Component.MESSAGE.LOAD_ANIMATIONS, json.toJson(entity.getEntityConfig()));
			entity.sendMessage(Component.MESSAGE.INIT_START_POSITION, json.toJson(new Vector2(0,0)));
			entity.sendMessage(Component.MESSAGE.INIT_STATE, json.toJson(entity.getEntityConfig().getState()));
			entity.sendMessage(Component.MESSAGE.INIT_DIRECTION, json.toJson(entity.getEntityConfig().getDirection()));

			entities.put(entity.getEntityConfig().getEntityID(), entity);
		}

		return entities;
	}


}
