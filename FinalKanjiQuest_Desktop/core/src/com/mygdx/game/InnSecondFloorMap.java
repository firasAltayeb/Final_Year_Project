package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;

public class InnSecondFloorMap extends Map{
    private static String mapPath = "tile_maps/inn_second_floor.tmx";

    InnSecondFloorMap(){
        super(MapFactory.MapType.ARMORER, mapPath);
    }

    @Override
    public void updateMapEntities(MapManager mapMgr, Batch batch, float delta){
        for( Entity entity : mapEntities){
            entity.update(mapMgr, batch, delta);
        }
    }
}
