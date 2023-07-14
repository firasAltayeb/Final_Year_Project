package com.mygdx.game.maps;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.tools.Entity;

public class InnSecondFloorMap extends Map {
    private static String mapPath = "tilemaps/inn_second_floor.tmx";
    private static String inn_clark = "json_scripts/chara/inn_clark.json";

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

    @Override
    public void unloadMusic() {

    }

    @Override
    public void loadMusic() {

    }

}
