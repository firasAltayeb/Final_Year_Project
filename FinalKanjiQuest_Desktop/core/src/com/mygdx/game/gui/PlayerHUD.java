package com.mygdx.game.gui;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Component;
import com.mygdx.game.Entity;
import com.mygdx.game.Utility;
import com.mygdx.game.inventory.InventoryItem;
import com.mygdx.game.inventory.InventoryItemLocation;
import com.mygdx.game.profile.ProfileManager;
import com.mygdx.game.profile.ProfileObserver;
import com.mygdx.game.screens.MainGameScreen;
import com.mygdx.game.inventory.InventoryItem.ItemTypeID;

public class PlayerHUD implements Screen, ProfileObserver, InventoryObserver, ProgressObserver {
    private Stage stage;
    private Viewport viewport;
    private Camera camera;
    private Entity player;

    private ProgressUI progressUI;
    private MenuList menuList;

    private TextButton menuButton;
    private TextButton statusButton;
    private TextButton inventoryButton;
    private float menuItemsXaxis;
    private float menuItemsYaxis;
    private float menuItemWindowWidth;
    private float menuItemWindowHeight;

    private InventoryUI inventoryUI;
    private Array<InventoryItemLocation> inventory;

    public PlayerHUD(Camera camera, Entity player) {
        this.camera = camera;
        this.player = player;
        viewport = new ScreenViewport(this.camera);
        stage = new Stage(viewport);
        menuItemsXaxis = stage.getWidth()/40;
        menuItemsYaxis = stage.getHeight()/40;
        menuItemWindowWidth = stage.getWidth()/1.35f;
        menuItemWindowHeight = stage.getHeight()/1.05f;

        menuButton = new TextButton("menu", Utility.GUI_SKINS);
        menuButton.setVisible(true);
        menuButton.setSize(stage.getWidth()/10f,  stage.getHeight()/20f);
        menuButton.setPosition(stage.getWidth()/1.2f,  stage.getHeight()/6);

        menuList = new MenuList();
        menuList.setMovable(false);
        menuList.setVisible(false);
        menuList.setSize(stage.getWidth()/5f,  stage.getHeight()/2.5f);
        menuList.setPosition(stage.getWidth()/1.27f, stage.getHeight()/2);

        progressUI = new ProgressUI(menuItemWindowWidth, menuItemWindowHeight);
        progressUI.setVisible(false);
        progressUI.setMovable(false);
        progressUI.setPosition(menuItemsXaxis, menuItemsYaxis);

        inventoryUI = new InventoryUI(menuItemWindowWidth, menuItemWindowHeight);
        inventoryUI.setMovable(false);
        inventoryUI.setVisible(false);
        inventoryUI.setPosition(menuItemsXaxis, menuItemsYaxis);

        stage.addActor(menuButton);
        stage.addActor(menuList);
        stage.addActor(progressUI);
        stage.addActor(inventoryUI);

        //add tooltips to the stage
        Array<Actor> actors = inventoryUI.getInventoryActors();
        for(Actor actor : actors){
            stage.addActor(actor);
        }

        //Observers
        ProfileManager.getInstance().addObserver(this);
        progressUI.addObserver(this);
        inventoryUI.addObserver(this);

        menuButton.addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                menuList.setVisible(menuList.isVisible()?false:true);
                progressUI.setVisible(false);
                inventoryUI.setVisible(false);
            }
        });

        statusButton =  menuList.getStatusButton();
        statusButton.addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                progressUI.setVisible(progressUI.isVisible()?false:true);
                inventoryUI.setVisible(false);
            }
        });

        inventoryButton = menuList.getInventoryButton();
        inventoryButton.addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                progressUI.setVisible(false);
                inventoryUI.setVisible(inventoryUI.isVisible()?false:true);
            }
        });

        //stage.setDebugAll(true);
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public void onNotify(ProfileManager profileManager, ProfileEvent event) {
        switch(event){
            case PROFILE_LOADED:
                int lifePoints = profileManager.getProperty("currentPlayerHP", Integer.class);
                boolean firstTime = lifePoints<0?true:false;

                if( firstTime ){
                    //add default items if first time
                    Array<ItemTypeID> items = player.getEntityConfig().getInventory();
                    Array<InventoryItemLocation> itemLocations = new Array<InventoryItemLocation>();
                    for( int i = 0; i < items.size; i++){
                        itemLocations.add(new InventoryItemLocation(i, items.get(i).toString()));
                    }
                    InventoryUI.populateInventory(inventoryUI.getInventorySlotTable(), itemLocations);
                    profileManager.setProperty("playerInventory", InventoryUI.getInventory(inventoryUI.getInventorySlotTable()));
                }

                Array<InventoryItemLocation> inventory = profileManager.getProperty("playerInventory", Array.class);
                InventoryUI.populateInventory(inventoryUI.getInventorySlotTable(), inventory);

                int hpVal = profileManager.getProperty("currentPlayerHP", Integer.class);

                if( firstTime ){
                    lifePoints = 3;
                    progressUI.setHPValue(lifePoints);
                }else{
                    progressUI.setHPValue(hpVal);
                }
                break;
            case SAVING_PROFILE:
                profileManager.setProperty("playerInventory",  inventoryUI.getInventory(inventoryUI.getInventorySlotTable()));
                profileManager.setProperty("currentPlayerHP", progressUI.getHPValue() );
                break;
            default:
                break;
        }
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    //TODO speak about this in the report
    @Override
    public void resize(int width, int height) {
        menuButton.setPosition(width/1.2f,  height/6);
        menuButton.setSize(width/10f,  height/20f);

        menuList.setPosition(width/1.27f, height/2);
        menuList.updateSize(width/5f, height/2.5f);

        progressUI.setPosition(width/40, height/40);
        progressUI.updateSize(width/1.35f, height/1.05f);

        inventoryUI.setPosition(width/40, height/40);
        inventoryUI.updateSize(width/1.35f, height/1.05f);

        MainGameScreen.setGameState(MainGameScreen.GameState.PAUSED);
        MainGameScreen.setGameState(MainGameScreen.GameState.PAUSED);
        stage.getViewport().update(width, height, true);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public void onNotify(int value, StatusEvent event) {
        switch(event) {
            case UPDATED_HP:
                ProfileManager.getInstance().setProperty("currentPlayerHP", progressUI.getHPValue());
                break;
            default:
                break;
        }
    }

    @Override
    public void onNotify(String value, InventoryEvent event) {
        switch(event){
            case ITEM_CONSUMED:
                String[] strings = value.split(Component.MESSAGE_TOKEN);
                if( strings.length != 2) return;

                int type = Integer.parseInt(strings[0]);
                int typeValue = Integer.parseInt(strings[1]);

                if( InventoryItem.doesRestoreHP(type) ){
                    progressUI.addHPValue(typeValue);
                }
                break;
            default:
                break;
        }
    }


}
