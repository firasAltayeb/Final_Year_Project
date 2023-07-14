package com.mygdx.game.maps;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.tools.Entity;

public class LibraryMap extends Map {
    private static String mapPath = "tilemaps/library.tmx";
    private static String librarian = "json_scripts/chara/librarian.json";

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
