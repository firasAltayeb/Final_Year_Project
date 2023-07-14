package com.mygdx.game.maps;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.tools.Entity;

public class HouseOneMap extends Map {
    private static String mapPath = "tilemaps/house_one.tmx";
    private static String librarian = "json_scripts/chara/librarian.json";
    private static String walkaround_four = "json_scripts/chara/walkaround_four.json";

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
