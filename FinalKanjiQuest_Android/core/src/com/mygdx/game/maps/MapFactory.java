package com.mygdx.game.maps;

import java.util.Hashtable;

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
            default:
                break;
        }
        return map;
    }
}
