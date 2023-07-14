package com.mygdx.game.inventory;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class InventoryItem extends Image {

    public enum ItemAttribute{
        CONSUMABLE(1),
        STACKABLE(2);

        private int attribute;

        ItemAttribute(int attribute){
            this.attribute = attribute;
        }

        public int getValue(){
            return attribute;
        }

    }

    public enum ItemUseType{
        ITEM_RESTORE_HEALTH(1),
        ITEM_INCREASE_MAX_HP(2),
        ITEM_INCREASE_KATAKANA_LVL(4),
        ITEM_INCREASE_HIRAGANA_LVL(8);

        private int itemUseType;

        ItemUseType(int itemUseType){
            this.itemUseType = itemUseType;
        }

        public int getValue(){
            return itemUseType;
        }
    }

    public enum ItemTypeID {
        ARROW_DOWN,ARROW_DOWN_SMALL,ARROW_UP,
        ARROW_UP_SMALL,DIAMOND,EGG,EMERALD,
        GOLDEN_SKULL,H_RUNESTONE,HEALTH_HEART,
        HEART,K_RUNESTONE,LARGE_POTION_BLUE,
        MEDIUM_POTION_BLUE,POTION_BLUE,
        PYRAMID, NONE;
    }

    private int itemAttributes;
    private int itemUseType;
    private int itemUseTypeValue;
    private ItemTypeID itemTypeID;
    private String itemShortDescription;
    private int itemValue;

    public InventoryItem(TextureRegion textureRegion, int itemAttributes, ItemTypeID itemTypeID, int itemUseType, int itemUseTypeValue, int itemValue){
        super(textureRegion);

        this.itemTypeID = itemTypeID;
        this.itemAttributes = itemAttributes;
        this.itemUseType = itemUseType;
        this.itemUseTypeValue = itemUseTypeValue;
        this.itemValue = itemValue;
    }

    public InventoryItem(){
        super();
    }

    public InventoryItem(InventoryItem inventoryItem){
        super();
        this.itemTypeID = inventoryItem.getItemTypeID();
        this.itemAttributes = inventoryItem.getItemAttributes();
        this.itemUseType = inventoryItem.getItemUseType();
        this.itemUseTypeValue = inventoryItem.getItemUseTypeValue();
        this.itemShortDescription = inventoryItem.getItemShortDescription();
        this.itemValue = inventoryItem.getItemValue();
    }

    public boolean isConsumable(){
        return ((itemAttributes & ItemAttribute.CONSUMABLE.getValue()) == ItemAttribute.CONSUMABLE.getValue());
    }

    public static boolean doesRestoreHP(int itemUseType){
        return ((itemUseType & ItemUseType.ITEM_RESTORE_HEALTH.getValue()) == ItemUseType.ITEM_RESTORE_HEALTH.getValue());
    }

    public int getItemUseTypeValue() {
        return itemUseTypeValue;
    }

    public void setItemUseTypeValue(int itemUseTypeValue) {
        this.itemUseTypeValue = itemUseTypeValue;
    }

    public int getItemValue() {
        return itemValue;
    }

    public void setItemValue(int itemValue) {
        this.itemValue = itemValue;
    }

    public int getItemAttributes() {
        return itemAttributes;
    }

    public void setItemAttributes(int itemAttributes) {
        this.itemAttributes = itemAttributes;
    }

    public ItemTypeID getItemTypeID() {
        return itemTypeID;
    }

    public void setItemTypeID(ItemTypeID itemTypeID) {
        this.itemTypeID = itemTypeID;
    }

    public int getItemUseType() {
        return itemUseType;
    }

    public void setItemUseType(int itemUseType) {
        this.itemUseType = itemUseType;
    }

    public String getItemShortDescription() {
        return itemShortDescription;
    }

    public void setItemShortDescription(String itemShortDescription) {
        this.itemShortDescription = itemShortDescription;
    }

    public boolean isSameItemType(InventoryItem candidateInventoryItem){
        return itemTypeID == candidateInventoryItem.getItemTypeID();
    }

}
