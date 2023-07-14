package com.mygdx.game.maps;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.tools.Entity;

public class ForestMap extends Map {
    private static String mapPath = "tilemaps/forest.tmx";

    public ForestMap(){
        super(MapFactory.MapType.FOREST, mapPath);
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
