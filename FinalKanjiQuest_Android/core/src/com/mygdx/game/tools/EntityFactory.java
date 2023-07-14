package com.mygdx.game.tools;


import com.badlogic.gdx.utils.Json;
import com.mygdx.game.components.NPCGraphicsComponent;
import com.mygdx.game.components.NPCInputComponent;
import com.mygdx.game.components.NPCPhysicsComponent;
import com.mygdx.game.components.PlayerGraphicsComponent;
import com.mygdx.game.components.PlayerInputComponent;

public class EntityFactory {

    private static Json json = new Json();

    public static enum EntityType{
        PLAYER,
        DEMO_PLAYER,
        NPC
    }

    public static String PLAYER_CONFIG = "json_scripts/hiro.json";

    public static Entity getEntity(EntityType entityType){
        Entity entity = null;
        switch(entityType){
            case PLAYER:
                entity = new Entity(new PlayerInputComponent(), new com.mygdx.game.components.PlayerPhysicsComponent(), new PlayerGraphicsComponent());
                entity.setEntityConfig(Entity.getEntityConfig(EntityFactory.PLAYER_CONFIG));
                entity.sendMessage(com.mygdx.game.components.Component.MESSAGE.LOAD_ANIMATIONS, json.toJson(entity.getEntityConfig()));
                return entity;
            case NPC:
                entity = new Entity(new NPCInputComponent(), new NPCPhysicsComponent(), new NPCGraphicsComponent());
                return entity;
            default:
                return null;
        }
    }
}
