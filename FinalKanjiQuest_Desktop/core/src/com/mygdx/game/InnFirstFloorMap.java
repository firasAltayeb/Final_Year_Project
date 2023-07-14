package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;

public class InnFirstFloorMap extends Map{
    private static String mapPath = "tile_maps/inn_first_floor.tmx";

    InnFirstFloorMap(){
        super(MapFactory.MapType.ARMORER, mapPath);
    }

    @Override
    public void updateMapEntities(MapManager mapMgr, Batch batch, float delta){
        for( Entity entity : mapEntities){
            entity.update(mapMgr, batch, delta);
        }
    }
}
