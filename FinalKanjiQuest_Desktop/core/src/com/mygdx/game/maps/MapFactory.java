package com.mygdx.game.maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapProperties;

import java.util.Hashtable;

public class MapFactory {

    private static final String TAG = MapFactory.class.getSimpleName();

    //All maps for the game
    private static Hashtable<MapType,Map> mapTable = new Hashtable<MapType, Map>();

    public static enum MapType{
        TOWN,
        ARMORER,
        LIBRARY,
        HERB_SHOP,
        HOUSE_ONE,
        INN_FIRST_FLOOR,
        INN_SECOND_FLOOR,
        TOP_WORLD,
        FOREST,
        CAVE
    }

    public static Map getMap(MapType mapType){
        Map map = null;
        switch(mapType){
            case TOWN:
                //Gdx.app.log(TAG, "mapType is: " + mapType.toString());
                map = mapTable.get(MapType.TOWN);
                if( map == null ){
                    map = new TownMap();
                    mapTable.put(MapType.TOWN, map);
                }
                break;
            case ARMORER:
                map = mapTable.get(MapType.ARMORER);
                if( map == null ){
                    map = new ArmorerMap();
                    mapTable.put(MapType.ARMORER, map);
                }
                break;
            case LIBRARY:
                map = mapTable.get(MapType.LIBRARY);
                if( map == null ){
                    map = new LibraryMap();
                    mapTable.put(MapType.LIBRARY, map);
                }
                break;
            case HERB_SHOP:
                map = mapTable.get(MapType.HERB_SHOP);
                if( map == null ){
                    map = new HerbShopMap();
                    mapTable.put(MapType.HERB_SHOP, map);
                }
                break;
            case HOUSE_ONE:
                map = mapTable.get(MapType.HOUSE_ONE);
                if( map == null ){
                    map = new HouseOneMap();
                    mapTable.put(MapType.HOUSE_ONE, map);
                }
                break;
            case INN_FIRST_FLOOR:
                map = mapTable.get(MapType.INN_FIRST_FLOOR);
                if( map == null ){
                    map = new InnFirstFloorMap();
                    mapTable.put(MapType.INN_FIRST_FLOOR, map);
                }
                break;
            case INN_SECOND_FLOOR:
                map = mapTable.get(MapType.INN_SECOND_FLOOR);
                if( map == null ){
                    map = new InnSecondFloorMap();
                    mapTable.put(MapType.INN_SECOND_FLOOR, map);
                }
                break;
            case TOP_WORLD:
                map = mapTable.get(MapType.TOP_WORLD);
                if( map == null ){
                    map = new TopworldMap();
                    mapTable.put(MapType.TOP_WORLD, map);
                }
                break;
            case FOREST:
                map = mapTable.get(MapType.FOREST);
                if( map == null ){
                    map = new ForestMap();
                    mapTable.put(MapType.FOREST, map);
                }
                break;
            case CAVE:
                map = mapTable.get(MapType.CAVE);
                if( map == null ){
                    map = new CaveMap();
                    mapTable.put(MapType.CAVE, map);
                }
                break;
            default:
                break;

        }
        return map;
    }


}
