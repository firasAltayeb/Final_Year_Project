package com.mygdx.game;

import java.util.Hashtable;
/*
public class MapFactory {
    //All maps for the game
    private static Hashtable<MapType,Map> mapTable = new Hashtable<MapType, Map>();

    public static enum MapType{
        TOWN,
        ARMORER,
        LIBRARY,
        HERB_SHOP,
        HOUSE_ONE,
        INN_FIRST_FLOOR,
        INN_SECOND_FLOOR
    }

    public static Map getMap(MapType mapType){
        Map map = null;
        switch(mapType){
            case TOWN:
                map = mapTable.get(MapType.TOWN);
                if( map == null ){
                    map = new Town();
                    mapTable.put(MapType.TOWN, map);
                }
                break;
            case ARMORER:
                map = mapTable.get(MapType.ARMORER);
                if( map == null ){
                    map = new Armorer();
                    mapTable.put(MapType.ARMORER, map);
                }
                break;
            case LIBRARY:
                map = mapTable.get(MapType.LIBRARY);
                if( map == null ){
                    map = new Library();
                    mapTable.put(MapType.LIBRARY, map);
                }
                break;
            case HERB_SHOP:
                map = mapTable.get(MapType.HERB_SHOP);
                if( map == null ){
                    map = new HerbShop();
                    mapTable.put(MapType.HERB_SHOP, map);
                }
                break;
            case HOUSE_ONE:
                map = mapTable.get(MapType.HOUSE_ONE);
                if( map == null ){
                    map = new HouseOne();
                    mapTable.put(MapType.HOUSE_ONE, map);
                }
                break;
            case INN_FIRST_FLOOR:
                map = mapTable.get(MapType.INN_FIRST_FLOOR);
                if( map == null ){
                    map = new InnFirstFloor();
                    mapTable.put(MapType.INN_FIRST_FLOOR, map);
                }
                break;
            case INN_SECOND_FLOOR:
                map = mapTable.get(MapType.INN_SECOND_FLOOR);
                if( map == null ){
                    map = new InnSecondFloor();
                    mapTable.put(MapType.INN_SECOND_FLOOR, map);
                }
                break;
                break;
            default:
                break;
        }
        return map;
    }
}
*/