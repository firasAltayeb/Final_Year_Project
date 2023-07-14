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
        ITEM_INCREASE_HIRAGANA_LVL(4),
        ITEM_INCREASE_KATAKANA_LVL(8),
        ITEM_DECREASE_HIRAGANA_LVL(16),
        ITEM_DECREASE_KATAKANA_LVL(32);


        private int itemUseType;

        ItemUseType(int itemUseType){
            this.itemUseType = itemUseType;
        }

        public int getValue(){
            return itemUseType;
        }
    }

    public enum ItemNameID {
        ARROW_DOWN,ARROW_DOWN_SMALL,ARROW_UP,
        ARROW_UP_SMALL,DIAMOND,EGG,EMERALD,
        GOLDEN_SKULL,H_RUNESTONE,NEGATIVE_H_RUNESTONE,HEALTH_HEART,
        HEART,K_RUNESTONE,NEGATIVE_K_RUNESTONE,LARGE_POTION_BLUE,
        MEDIUM_POTION_BLUE,POTION_BLUE,
        PYRAMID, NONE;
    }

    private int itemAttributes;
    private int itemUseType;
    private ItemNameID itemNameID;
    private String itemShortDescription;
    private int itemUseValue;

    public InventoryItem(TextureRegion textureRegion, int itemAttributes, ItemNameID itemNameID, int itemUseType, int itemUseValue){
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

    public static boolean doesIncreaseHiraganaLvl(int itemUseType){
        return ((itemUseType & ItemUseType.ITEM_INCREASE_HIRAGANA_LVL.getValue()) == ItemUseType.ITEM_INCREASE_HIRAGANA_LVL.getValue());
    }

    public static boolean doesDecreaseHiraganaLvl(int itemUseType){
        return ((itemUseType & ItemUseType.ITEM_DECREASE_HIRAGANA_LVL.getValue()) == ItemUseType.ITEM_DECREASE_HIRAGANA_LVL.getValue());
    }


    public boolean isSameItem(InventoryItem candidateInventoryItem){
        return itemNameID == candidateInventoryItem.getItemNameID();
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

    public ItemNameID getItemNameID() {
        return itemNameID;
    }

    public void setItemNameID(ItemNameID itemNameID) {
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

}
