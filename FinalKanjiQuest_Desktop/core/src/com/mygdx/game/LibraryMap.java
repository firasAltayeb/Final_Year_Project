package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;

public class LibraryMap extends Map{
    private static String mapPath = "tile_maps/library.tmx";

    LibraryMap(){
        super(MapFactory.MapType.ARMORER, mapPath);
    }

    @Override
    public void updateMapEntities(MapManager mapMgr, Batch batch, float delta){
        for( Entity entity : mapEntities){
            entity.update(mapMgr, batch, delta);
        }
    }
}
