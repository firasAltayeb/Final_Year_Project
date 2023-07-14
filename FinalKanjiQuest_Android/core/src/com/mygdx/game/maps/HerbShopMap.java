package com.mygdx.game.maps;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.tools.Entity;

public class HerbShopMap extends Map {
    private static String mapPath = "tilemaps/herb_shop.tmx";
    private static String herbalist = "json_scripts/herbalist.json";

    HerbShopMap(){
        super(MapFactory.MapType.HERB_SHOP, mapPath);
        mapEntities.add(initSpecialEntity(Entity.getEntityConfig(herbalist)));
    }

    @Override
    public void updateMapEntities(MapManager mapMgr, Batch batch, float delta){
        for( Entity entity : mapEntities){
            entity.update(mapMgr, batch, delta);
        }
    }

}
