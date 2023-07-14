package com.mygdx.game.maps;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapProperties;
import com.mygdx.game.tools.Entity;

public class ArmorerMap extends Map {
    private static String mapPath = "tilemaps/armorer.tmx";
    private static String blacksmith = "json_scripts/chara/blacksmith.json";

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
