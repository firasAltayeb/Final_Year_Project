package com.mygdx.game.maps;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Component;
import com.mygdx.game.Entity;
import com.mygdx.game.EntityConfig;
import com.mygdx.game.EntityFactory;

public class InnSecondFloorMap extends Map {
    private static String mapPath = "tile_maps/inn_second_floor.tmx";
    private static String inn_clark = "json_scripts/inn_clark.json";

    InnSecondFloorMap(){
        super(MapFactory.MapType.INN_SECOND_FLOOR, mapPath);
        mapEntities.add(initSpecialEntity(Entity.getEntityConfig(inn_clark)));
    }

    @Override
    public void updateMapEntities(MapManager mapMgr, Batch batch, float delta){
        for(int i = 0; i < mapEntities.size; i++){
            mapEntities.get(i).update(mapMgr, batch, delta);
        }
    }

}
