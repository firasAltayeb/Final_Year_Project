package com.mygdx.game.inventory;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class InventoryItem extends Image {

    public enum ItemAttribute{
        CONSUMABLE(1),
        STACKABLE(2);

        private int _attribute;

        ItemAttribute(int attribute){
            this._attribute = attribute;
        }

        public int getValue(){
            return _attribute;
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
    private ItemTypeID itemNameID;
    private String itemShortDescription;
    private int itemUseValue;

    public InventoryItem(TextureRegion textureRegion, int itemAttributes, ItemTypeID itemNameID, int itemUseType, int itemUseValue){
        super(textureRegion);

        this.itemNameID = itemNameID;
        this.itemAttributes = itemAttributes;
        this.itemUseType = itemUseType;
        this.itemUseValue = itemUseValue;
    }

    public InventoryItem(){
        super();
    }

    public InventoryItem(InventoryItem inventoryItem){
        super();
        this.itemNameID = inventoryItem.getItemNameID();
        this.itemAttributes = inventoryItem.getItemAttributes();
        this.itemUseType = inventoryItem.getItemUseType();
        this.itemShortDescription = inventoryItem.getItemShortDescription();
        this.itemUseValue = inventoryItem.getItemUseValue();
    }

    public boolean isConsumable(){
        return ((itemAttributes & ItemAttribute.CONSUMABLE.getValue()) == ItemAttribute.CONSUMABLE.getValue());
    }

    public static boolean doesRestoreHP(int itemUseType){
        return ((itemUseType & ItemUseType.ITEM_RESTORE_HEALTH.getValue()) == ItemUseType.ITEM_RESTORE_HEALTH.getValue());
    }

    public int getItemUseValue() {
        return itemUseValue;
    }

    public void setItemUseValue(int itemUseValue) {
        this.itemUseValue = itemUseValue;
    }

    public int getItemAttributes() {
        return itemAttributes;
    }

    public void setItemAttributes(int itemAttributes) {
        this.itemAttributes = itemAttributes;
    }

    public ItemTypeID getItemNameID() {
        return itemNameID;
    }

    public void setItemNameID(ItemTypeID itemNameID) {
        this.itemNameID = itemNameID;
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
        return itemNameID == candidateInventoryItem.getItemNameID();
    }

}