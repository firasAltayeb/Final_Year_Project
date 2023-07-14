package com.mygdx.game.maps;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Component;
import com.mygdx.game.Entity;
import com.mygdx.game.EntityConfig;
import com.mygdx.game.EntityFactory;

public class ArmorerMap extends Map {
    private static String mapPath = "tile_maps/armorer.tmx";
    private static String blacksmith = "json_scripts/blacksmith.json";

    public ArmorerMap(){
        super(MapFactory.MapType.ARMORER, mapPath);
        mapEntities.add(initSpecialEntity(Entity.getEntityConfig(blacksmith)));
    }

    @Override
    public void updateMapEntities(MapManager mapMgr, Batch batch, float delta){
        for( Entity entity : mapEntities){
            entity.update(mapMgr, batch, delta);
        }
    }

}
