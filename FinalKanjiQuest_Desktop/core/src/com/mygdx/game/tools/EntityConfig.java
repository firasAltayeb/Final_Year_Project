package com.mygdx.game.tools;

import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.mygdx.game.tools.Entity.AnimationType;
import com.mygdx.game.inventory.InventoryItem.ItemNameID;


public class EntityConfig {
    private Array<AnimationConfig> animationConfig;
    private Array<ItemNameID> inventory;
    private Entity.State state = Entity.State.IDLE;
    private Entity.Direction direction = Entity.Direction.DOWN;
    private String entityID;
    private String conversationConfigPath;
    private String questConfigPath;
    private String currentQuestID;
    private String itemNameID;
    private ObjectMap<String, String> entityProperties;

    public static enum EntityProperties{
        ENTITY_HEALTH_POINTS,
        ENTITY_ATTACK_POINTS,
        ENTITY_DEFENSE_POINTS,
        ENTITY_HIT_DAMAGE_TOTAL,
        ENTITY_XP_REWARD,
        ENTITY_GP_REWARD,
        NONE
    }

    public EntityConfig(){
        animationConfig = new Array<AnimationConfig>();
        inventory = new Array<ItemNameID>();
    }

    EntityConfig(EntityConfig config){
        state = config.getState();
        direction = config.getDirection();
        entityID = config.getEntityID();
        itemNameID = config.getItemNameID();

        animationConfig = new Array<AnimationConfig>();
        animationConfig.addAll(config.getAnimationConfig());

        inventory = new Array<ItemNameID>();
        inventory.addAll(config.getInventory());

        entityProperties = new ObjectMap<String, String>();
        entityProperties.putAll(config.entityProperties);
    }

    public ObjectMap<String, String> getEntityProperties() {
        return entityProperties;
    }

    public void setEntityProperties(ObjectMap<String, String> entityProperties) {
        this.entityProperties = entityProperties;
    }

    public void setPropertyValue(String key, String value){
        entityProperties.put(key, value);
    }

    public String getPropertyValue(String key){
        Object propertyVal = entityProperties.get(key);
        if( propertyVal == null ) return new String();
        return propertyVal.toString();
    }

    public String getEntityID() {
        return entityID;
    }

    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

    public Entity.Direction getDirection() {
        return direction;
    }

    public void setDirection(Entity.Direction direction) {
        this.direction = direction;
    }

    public Entity.State getState() {
        return state;
    }

    public void setState(Entity.State state) {
        this.state = state;
    }

    public String getItemNameID() {
        return itemNameID;
    }

    public void setItemNameID(String itemNameID) {
        this.itemNameID = itemNameID;
    }

    public Array<ItemNameID> getInventory() {
        return inventory;
    }

    public void setInventory(Array<ItemNameID> inventory) {
        this.inventory = inventory;
    }

    public Array<AnimationConfig> getAnimationConfig() {
        return animationConfig;
    }

    public void addAnimationConfig(AnimationConfig animationConfig) {
        this.animationConfig.add(animationConfig);
    }

    public static class AnimationConfig{
        private float frameDuration = 1.0f;
        private AnimationType animationType;
        private Array<String> texturePaths;
        private Array<GridPoint2> gridPoints;

        public AnimationConfig(){
            animationType = AnimationType.IDLE;
            texturePaths = new Array<String>();
            gridPoints = new Array<GridPoint2>();
        }

        public float getFrameDuration() {
            return frameDuration;
        }

        public void setFrameDuration(float frameDuration) {
            this.frameDuration = frameDuration;
        }

        public Array<String> getTexturePaths() {
            return texturePaths;
        }

        public void setTexturePaths(Array<String> texturePaths) {
            this.texturePaths = texturePaths;
        }

        public Array<GridPoint2> getGridPoints() {
            return gridPoints;
        }

        public void setGridPoints(Array<GridPoint2> gridPoints) {
            this.gridPoints = gridPoints;
        }

        public AnimationType getAnimationType() {
            return animationType;
        }

        public void setAnimationType(AnimationType animationType) {
            this.animationType = animationType;
        }
    }

}
