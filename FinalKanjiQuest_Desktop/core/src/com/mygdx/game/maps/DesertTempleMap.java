package com.mygdx.game.maps;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.tools.Entity;

public class DesertTempleMap extends Map {
    private static String mapPath = "tilemaps/desert_temple.tmx";

    public DesertTempleMap(){
        super(MapFactory.MapType.DESERT_TEMPLE, mapPath);
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
