package com.mygdx.game.gui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.components.Component;
import com.mygdx.game.tools.Utility;
import com.mygdx.game.inventory.InventoryItem;
import com.mygdx.game.inventory.InventoryItemFactory;
import com.mygdx.game.inventory.InventoryItemLocation;
import com.mygdx.game.inventory.InventoryItem.ItemTypeID;
import com.mygdx.game.inventory.InventorySlot;

public class InventoryUI extends Window implements InventorySubject {

    private final static String TAG = InventoryUI.class.getSimpleName();

    private int numSlots = 35;
    private int lengthSlotRow = 7;
    private Table inventorySlotTable;

    private InventorySlot pressedSlot;
    private InventorySlot slotToRemove;
    private Label itemDescription;
    private String description;

    private float slotWidth;
    private float slotHeight;

    float menuItemWindowWidth;
    float menuItemWindowHeight;

    private Array<InventoryObserver> _observers;

    public InventoryUI(float width, float height) {
        super("Inventory", Utility.GUI_SKINS);
        this.getTitleLabel().setAlignment(Align.center);

        _observers = new Array<InventoryObserver>();

        menuItemWindowWidth = width;
        menuItemWindowHeight = height;

        this.pad(this.getPadTop() + menuItemWindowHeight / 30, 10,
                menuItemWindowHeight / 30, 10);


        slotWidth = menuItemWindowWidth / 8;
        slotHeight = menuItemWindowHeight / 7.5f;

        description = "";
        itemDescription = new Label("", Utility.GUI_SKINS, "list_text");
        pressedSlot = new InventorySlot();
        inventorySlotTable = new Table();
        inventorySlotTable.setName("Inventory_Slot_Table");
        //inventorySlotTable.setPosition(menuItemWindowWidth/1.5f,menuItemWindowHeight/2.6f);

        for (int i = 1; i <= numSlots; i++) {
            InventorySlot inventorySlot = new InventorySlot();

            inventorySlotTable.add(inventorySlot).size(slotWidth, slotHeight);

            inventorySlot.addListener(new ClickListener() {
                                          @Override
                                          public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                                              super.touchUp(event, x, y, pointer, button);

                                              if (getTapCount() == 2) {
                                                  slotToRemove = (InventorySlot) event.getListenerActor();
                                                  if (slotToRemove.hasItem()) {
                                                      InventoryItem item = slotToRemove.getTopInventoryItem();
                                                      InventoryItem item2 = InventoryItemFactory.getInstance()
                                                              .getInventoryItem(item.getItemTypeID());

                                                      pressedSlot.addActor(item2);
                                                      slotToRemove.addActor(item);

                                                      //Gdx.app.debug(TAG, "item.getItemTypeID is: " + item.getItemTypeID().toString());

                                                      description = item.getItemShortDescription();

                                                      int mid;
                                                      int spaceAfterMid;
                                                      mid = description.length()/2;
                                                      spaceAfterMid = description.indexOf(" ", mid);
                                                      itemDescription.setText(description.substring(0, spaceAfterMid) + "\n" +
                                                              description.substring(spaceAfterMid));

                                                      //if(description.length() - description.replace(" ", "").length()> 4){}

                                                  }
                                              }


                                          }
                                      }
            );

            if (i % lengthSlotRow == 0) {
                inventorySlotTable.row();
            }
        }

        pressedSlot.addListener(new ClickListener() {
                                    @Override
                                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                                        super.touchUp(event, x, y, pointer, button);

                                        if (getTapCount() == 2) {
                                            InventorySlot slot = (InventorySlot) event.getListenerActor();
                                            if (slot.hasItem()) {
                                                InventoryItem item = slot.getTopInventoryItem();
                                                if (item.isConsumable()) {
                                                    String itemInfo = item.getItemUseType() + Component.MESSAGE_TOKEN + item.getItemValue();
                                                    InventoryUI.this.notify(itemInfo, InventoryObserver.InventoryEvent.ITEM_CONSUMED);
                                                    slot.remove(item);
                                                    pressedSlot.clearAllInventoryItems(false);
                                                    slotToRemove.clearAllInventoryItems(false  );
                                                    itemDescription.setText("");
                                                }
                                            }
                                        }


                                    }


                                }
        );

        pressedSlot.setPosition(menuItemWindowWidth / 16f, menuItemWindowHeight / 1.35f);
        pressedSlot.setSize(menuItemWindowWidth / 6, menuItemWindowHeight /7f);
        itemDescription.setPosition(menuItemWindowWidth / 4f, menuItemWindowHeight / 1.25f);
        inventorySlotTable.setPosition(menuItemWindowWidth / 2f, menuItemWindowHeight / 2.6f);

        this.addActor(pressedSlot);
        this.addActor(itemDescription);
        this.addActor(inventorySlotTable);

        this.setSize(menuItemWindowWidth, menuItemWindowHeight);
        //this.debug();
    }

    public void updateSize(float width, float height) {
        float newMenuItemWindowWidth = width;
        float newMenuItemWindowHeight = height;

        pressedSlot.setPosition(newMenuItemWindowWidth / 16f, newMenuItemWindowHeight / 1.35f);
        pressedSlot.setSize(newMenuItemWindowWidth / 6, newMenuItemWindowHeight /7f);
        itemDescription.setPosition(newMenuItemWindowWidth / 4f, newMenuItemWindowHeight / 1.25f);
        inventorySlotTable.setPosition(newMenuItemWindowWidth / 2f, newMenuItemWindowHeight / 2.6f);

        for (int i = 0; i <= inventorySlotTable.getCells().size - 1; i++) {
            //Gdx.app.debug(TAG, " menuItemWindowWidth: " + menuItemWindowWidth );
            //Gdx.app.debug(TAG, " menuItemWindowHeight: " + menuItemWindowHeight );
            inventorySlotTable.getCells().get(i).size(newMenuItemWindowWidth / 8, newMenuItemWindowHeight / 7.5f);
        }

        this.setSize(newMenuItemWindowWidth, newMenuItemWindowHeight);
    }


    public Table getInventorySlotTable() {
        return inventorySlotTable;
    }

    public static Array<InventoryItemLocation> getInventory(Table targetTable) {
        Array<Cell> cells = targetTable.getCells();
        Array<InventoryItemLocation> items = new Array<InventoryItemLocation>();
        for (int i = 0; i < cells.size; i++) {
            InventorySlot inventorySlot = ((InventorySlot) cells.get(i).getActor());
            if (inventorySlot == null) continue;
            int numItems = inventorySlot.getNumItems();
            if (numItems > 0) {
                items.add(new InventoryItemLocation(
                        i,
                        inventorySlot.getTopInventoryItem().getItemTypeID().toString()));
            }
        }
        return items;
    }

    public static void populateInventory(Table targetTable, Array<InventoryItemLocation> inventoryItems) {
        clearInventoryItems(targetTable);

        Array<Cell> cells = targetTable.getCells();
        for(int i = 0; i < inventoryItems.size; i++){
            InventoryItemLocation itemLocation = inventoryItems.get(i);
            ItemTypeID itemTypeID = ItemTypeID.valueOf(itemLocation.getItemTypeAtLocation());
            InventorySlot inventorySlot =  ((InventorySlot)cells.get(itemLocation.getLocationIndex()).getActor());
            InventoryItem item = InventoryItemFactory.getInstance().getInventoryItem(itemTypeID);
            inventorySlot.add(item);

        }
    }

    public static void clearInventoryItems(Table targetTable){
        Array<Cell> cells = targetTable.getCells();
        for( int i = 0; i < cells.size; i++){
            InventorySlot inventorySlot = (InventorySlot)cells.get(i).getActor();
            if( inventorySlot == null ) continue;
            inventorySlot.clearAllInventoryItems(false);
        }
    }


    @Override
    public void addObserver(InventoryObserver inventoryObserver) {
        _observers.add(inventoryObserver);
    }

    @Override
    public void removeObserver(InventoryObserver inventoryObserver) {
        _observers.removeValue(inventoryObserver, true);
    }

    @Override
    public void removeAllObservers() {
        for (InventoryObserver observer : _observers) {
            _observers.removeValue(observer, true);
        }
    }

    @Override
    public void notify(String value, InventoryObserver.InventoryEvent event) {
        for (InventoryObserver observer : _observers) {
            observer.onNotify(value, event);
        }
    }
}
