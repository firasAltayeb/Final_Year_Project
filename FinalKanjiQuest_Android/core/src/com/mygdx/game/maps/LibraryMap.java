package com.mygdx.game.maps;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Component;
import com.mygdx.game.Entity;
import com.mygdx.game.EntityConfig;
import com.mygdx.game.EntityFactory;

public class LibraryMap extends Map {
    private static String mapPath = "tile_maps/library.tmx";
    private static String librarian = "json_scripts/librarian.json";

    LibraryMap(){
        super(MapFactory.MapType.LIBRARY, mapPath);
        mapEntities.add(initSpecialEntity(Entity.getEntityConfig(librarian)));
    }

    @Override
    public void updateMapEntities(MapManager mapMgr, Batch batch, float delta){
        for( Entity entity : mapEntities){
            entity.update(mapMgr, batch, delta);
        }
    }

}
