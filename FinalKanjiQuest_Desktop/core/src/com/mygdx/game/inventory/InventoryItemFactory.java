package com.mygdx.game.inventory;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.Scaling;
import java.util.ArrayList;
import java.util.Hashtable;
import com.mygdx.game.tools.Utility;
import com.mygdx.game.inventory.InventoryItem.ItemNameID;

public class InventoryItemFactory {

    private Json json = new Json();
    private final String INVENTORY_ITEM = "json_scripts/inventory_items.json";
    private static InventoryItemFactory instance = null;
    private Hashtable<ItemNameID,InventoryItem> inventoryItemList;

    public static InventoryItemFactory getInstance() {
        if (instance == null) {
            instance = new InventoryItemFactory();
        }

        return instance;
    }

    private InventoryItemFactory(){
        ArrayList<JsonValue> list = json.fromJson(ArrayList.class, Gdx.files.internal(INVENTORY_ITEM));
        inventoryItemList = new Hashtable<ItemNameID, InventoryItem>();

        for (JsonValue jsonVal : list) {
            InventoryItem inventoryItem = json.readValue(InventoryItem.class, jsonVal);
            inventoryItemList.put(inventoryItem.getItemNameID(), inventoryItem);
        }
    }

    public InventoryItem getInventoryItem(ItemNameID inventoryItemName){
        InventoryItem item = new InventoryItem(inventoryItemList.get(inventoryItemName));
        item.setDrawable(new TextureRegionDrawable(Utility.ITEMS_TEXTUREATLAS.findRegion(item.getItemNameID().toString())));
        item.setScaling(Scaling.none);
        return item;
    }

}
