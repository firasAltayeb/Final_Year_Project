package com.mygdx.game.maps;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Component;
import com.mygdx.game.Entity;
import com.mygdx.game.EntityConfig;
import com.mygdx.game.EntityFactory;

public class HouseOneMap extends Map {
    private static String mapPath = "tile_maps/house_one.tmx";
    private static String librarian = "json_scripts/librarian.json";
    private static String walkaround_four = "json_scripts/walkaround_four.json";

    HouseOneMap(){
        super(MapFactory.MapType.HOUSE_ONE, mapPath);
        mapEntities.add(initSpecialEntity(Entity.getEntityConfig(librarian)));
        mapEntities.add(initSpecialEntity(Entity.getEntityConfig(walkaround_four)));
    }

    @Override
    public void updateMapEntities(MapManager mapMgr, Batch batch, float delta){
        for(int i = 0; i < mapEntities.size; i++){
            mapEntities.get(i).update(mapMgr, batch, delta);
        }
    }

}
