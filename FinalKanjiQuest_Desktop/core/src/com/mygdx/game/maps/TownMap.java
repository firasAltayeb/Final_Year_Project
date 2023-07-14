package com.mygdx.game.maps;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Component;
import com.mygdx.game.Entity;
import com.mygdx.game.EntityConfig;
import com.mygdx.game.EntityFactory;
import com.mygdx.game.PlayerPhysicsComponent;
import com.mygdx.game.maps.Map;
import com.mygdx.game.maps.MapFactory;
import com.mygdx.game.maps.MapManager;

public class TownMap extends Map {
    private static final String TAG = PlayerPhysicsComponent.class.getSimpleName();

    private static String mapPath = "tile_maps/town.tmx";
    private static String walkaround_one = "json_scripts/walkaround_one.json";
    private static String walkaround_two = "json_scripts/walkaround_two.json";
    private static String walkaround_three = "json_scripts/walkaround_three.json";
    private static String walkaround_four = "json_scripts/walkaround_four.json";
    private static String inn_clark = "json_scripts/inn_clark.json";

    public TownMap(){
        super(MapFactory.MapType.TOWN, mapPath);

        for( Vector2 position: npcStartPositions){
            mapEntities.add(initEntity(Entity.getEntityConfig(walkaround_one), position));
        }

        //Special cases
        mapEntities.add(initSpecialEntity(Entity.getEntityConfig(walkaround_two)));
        mapEntities.add(initSpecialEntity(Entity.getEntityConfig(walkaround_three)));
        mapEntities.add(initSpecialEntity(Entity.getEntityConfig(walkaround_four)));
        mapEntities.add(initSpecialEntity(Entity.getEntityConfig(inn_clark)));

        //When we have multiple configs in one file
        //Array<EntityConfig> configs = Entity.getEntityConfigs(walkaround_one);
        //for(EntityConfig config: configs){
        //    mapEntities.add(initSpecialEntity(config));
        //}
    }

    @Override
    public void updateMapEntities(MapManager mapMgr, Batch batch, float delta){
        for(int i = 0; i < mapEntities.size; i++){
            mapEntities.get(i).update(mapMgr, batch, delta);
        }
    }

    private Entity initEntity(EntityConfig entityConfig, Vector2 position){
        Entity entity = EntityFactory.getEntity(EntityFactory.EntityType.NPC);
        entity.setEntityConfig(entityConfig);

        entity.sendMessage(Component.MESSAGE.LOAD_ANIMATIONS, json.toJson(entity.getEntityConfig()));
        entity.sendMessage(Component.MESSAGE.INIT_START_POSITION, json.toJson(position));
        entity.sendMessage(Component.MESSAGE.INIT_STATE, json.toJson(entity.getEntityConfig().getState()));
        entity.sendMessage(Component.MESSAGE.INIT_DIRECTION, json.toJson(entity.getEntityConfig().getDirection()));

        return entity;
    }

    private Entity initSpecialEntity(EntityConfig entityConfig){
        Vector2 position = new Vector2(0,0);

        if( specialNPCStartPositions.containsKey(entityConfig.getEntityID()) ) {
             position = specialNPCStartPositions.get(entityConfig.getEntityID());
        }
        return initEntity(entityConfig, position);
    }
}
