package com.mygdx.game.inventory;

public class InventoryItemLocation {
    private int locationIndex;
    private String itemNameAtLocation;

    public InventoryItemLocation(){
    }

    public InventoryItemLocation( int locationIndex, String itemNameAtLocation){
        this.locationIndex = locationIndex;
        this.itemNameAtLocation = itemNameAtLocation;
    }

    public String getItemNameAtLocation() {
        return itemNameAtLocation;
    }

    public void setItemNameAtLocation(String itemNameAtLocation) {
        this.itemNameAtLocation = itemNameAtLocation;
    }

    public int getLocationIndex() {
        return locationIndex;
    }

    public void setLocationIndex(int locationIndex) {
        this.locationIndex = locationIndex;
    }
}