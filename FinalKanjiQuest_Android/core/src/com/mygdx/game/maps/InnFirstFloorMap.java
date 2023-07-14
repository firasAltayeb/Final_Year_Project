package com.mygdx.game.maps;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.tools.Entity;

public class InnFirstFloorMap extends Map {
    private static String mapPath = "tilemaps/inn_first_floor.tmx";
    private static String herbalist = "json_scripts/chara/herbalist.json";

    InnFirstFloorMap(){
        super(MapFactory.MapType.INN_FIRST_FLOOR, mapPath);
        mapEntities.add(initSpecialEntity(Entity.getEntityConfig(herbalist)));
    }

    @Override
    public void updateMapEntities(MapManager mapMgr, Batch batch, float delta){
        for( Entity entity : mapEntities){
            entity.update(mapMgr, batch, delta);
        }
    }

    @Override
    public void unloadMusic() {

    }

    @Override
    public void loadMusic() {

    }

}
