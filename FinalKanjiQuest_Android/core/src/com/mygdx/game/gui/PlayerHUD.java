package com.mygdx.game.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Component;
import com.mygdx.game.Entity;
import com.mygdx.game.Utility;
import com.mygdx.game.inventory.InventoryItem;
import com.mygdx.game.inventory.InventoryItem.ItemTypeID;
import com.mygdx.game.inventory.InventoryItemLocation;
import com.mygdx.game.profile.ProfileManager;
import com.mygdx.game.profile.ProfileObserver;
import com.mygdx.game.screens.MainGameScreen;

public class PlayerHUD implements Screen, InventoryObserver, ProfileObserver, ProgressObserver {

    private final static String TAG = PlayerHUD.class.getSimpleName();

    private Stage stage;
    private Viewport viewport;
    private Camera camera;
    private Entity player;

    private ProgressUI progressUI;
    private MenuListUI menuListUI;

    private TextButton menuButton;
    private TextButton progressButton;
    private TextButton inventoryButton;

    private Array<ImageButton> all_health_heart;
    private ImageButton health_heart;


    private float menuItemsXaxis;
    private float menuItemsYaxis;
    private float menuItemWindowWidth;
    private float menuItemWindowHeight;

    private InventoryUI inventoryUI;

    public PlayerHUD(Camera camera, final Entity player, final InputMultiplexer multiplexer) {
        this.camera = camera;
        this.player = player;
        viewport = new ScreenViewport(this.camera);
        stage = new Stage(viewport);

        multiplexer.addProcessor(this.getStage());
        multiplexer.addProcessor(player.getInputProcessor());
        Gdx.input.setInputProcessor(multiplexer);

        menuItemsXaxis = stage.getWidth()/40;
        menuItemsYaxis = stage.getHeight()/40;
        menuItemWindowWidth = stage.getWidth()/1.35f;
        menuItemWindowHeight = stage.getHeight()/1.05f;

        all_health_heart = new Array<ImageButton>();

        for (int i = 0; i<10; i++) {
            health_heart = new ImageButton(Utility.ITEMS_SKINS, "health_heart");
            health_heart.setVisible(false);
            health_heart.setPosition(stage.getWidth() / 60f + i * 20, stage.getHeight() / 1.1f);
            health_heart.scaleBy(2,2);
            all_health_heart.add(health_heart);
        }

        menuButton = new TextButton("menu", Utility.GUI_SKINS);
        menuButton.setVisible(true);
        menuButton.setSize(stage.getWidth()/10f,  stage.getHeight()/20f);
        menuButton.setPosition(stage.getWidth()/1.2f,  stage.getHeight()/6);

        menuListUI = new MenuListUI();
        menuListUI.setMovable(false);
        menuListUI.setVisible(false);
        menuListUI.setSize(stage.getWidth()/5f,  stage.getHeight()/2.5f);
        menuListUI.setPosition(stage.getWidth()/1.27f, stage.getHeight()/2);

        progressUI = new ProgressUI(menuItemWindowWidth, menuItemWindowHeight);
        progressUI.setVisible(false);
        progressUI.setMovable(false);
        progressUI.setPosition(menuItemsXaxis, menuItemsYaxis);

        inventoryUI = new InventoryUI(menuItemWindowWidth, menuItemWindowHeight);
        inventoryUI.setMovable(false);
        inventoryUI.setVisible(false);
        inventoryUI.setPosition(menuItemsXaxis, menuItemsYaxis);

        Gdx.app.log(TAG, "all_health_heart.size is: " + all_health_heart.size);

        for (int i = 0; i<all_health_heart.size; i++) {
            stage.addActor(all_health_heart.get(i));
        }

        stage.addActor(menuButton);
        stage.addActor(menuListUI);
        stage.addActor(progressUI);
        stage.addActor(inventoryUI);

        //Observers
        ProfileManager.getInstance().addObserver(this);
        progressUI.addObserver(this);
        inventoryUI.addObserver(this);

        menuButton.addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                //menuListUI.setVisible(menuListUI.isVisible() ? false : true);
                //MainGameScreen.setGameState(MainGameScreen.GameState.PAUSED);
                if (menuListUI.isVisible()) {
                    menuListUI.setVisible(false);
                    multiplexer.addProcessor(player.getInputProcessor());
                }
                else {
                    menuListUI.setVisible(true);
                    multiplexer.removeProcessor(player.getInputProcessor());
                }
                progressUI.setVisible(false);
                inventoryUI.setVisible(false);
            }
        });

        progressButton =  menuListUI.getStatusButton();
        progressButton.addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                progressUI.setVisible(progressUI.isVisible()?false:true);
                inventoryUI.setVisible(false);
            }
        });

        inventoryButton = menuListUI.getInventoryButton();
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
                //int hpMaxVal = profileManager.getProperty("currentPlayerHPMax", Integer.class);
                //int hpVal = profileManager.getProperty("currentPlayerHP", Integer.class);
                //boolean firstTime = hpVal<0?true:false;
                int hpVal = 3;
                int hpMaxVal = 10;
                boolean firstTime = progressUI.getHPValue()<0?true:false;

                if( firstTime ){
                    //int hpVal = 3;
                    //int hpMaxVal = 10;
                    progressUI.setHPValueMax(hpMaxVal);
                    progressUI.setHPValue(hpVal);
                }else{
                    progressUI.setHPValueMax(hpMaxVal);
                    progressUI.setHPValue(hpVal);
                }

                showHearts(hpVal);

                if( firstTime ){
                    //add default items if first time
                    Array<ItemTypeID> items = player.getEntityConfig().getInventory();
                    Array<InventoryItemLocation> itemLocations = new Array<InventoryItemLocation>();
                    for( int i = 0; i < items.size; i++){
                        itemLocations.add(new InventoryItemLocation(i, items.get(i).toString()));
                    }
                    InventoryUI.populateInventory(inventoryUI.getInventorySlotTable(), itemLocations);
                    //profileManager.setProperty("playerInventory", InventoryUI.getInventory(inventoryUI.getInventorySlotTable()));
                }

                //Array<InventoryItemLocation> inventory = profileManager.getProperty("playerInventory", Array.class);
                //InventoryUI.populateInventory(inventoryUI.getInventorySlotTable(), inventory);

                break;
            case SAVING_PROFILE:
                //profileManager.setProperty("playerInventory",  inventoryUI.getInventory(inventoryUI.getInventorySlotTable()));
                //profileManager.setProperty("currentPlayerHPMax", progressUI.getHPValueMax() );
                //profileManager.setProperty("currentPlayerHP", progressUI.getHPValue() );
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

        for (int i = 0; i<all_health_heart.size; i++) {
            all_health_heart.get(i).setPosition(width/ 60f + i * 25, height / 1.1f);
        }

        menuButton.setPosition(width/1.2f,  height/6);
        menuButton.setSize(width/10f,  height/20f);

        menuListUI.setPosition(width/1.27f, height/2);
        menuListUI.updateSize(width/5f, height/2.5f);

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
                //ProfileManager.getInstance().setProperty("currentPlayerHP", progressUI.getHPValue());
                break;
            case UPDATED_MAX_HP:
                //ProfileManager.getInstance().setProperty("currentPlayerHPMax", progressUI.getHPValueMax());
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

                Gdx.app.log(TAG, "typeValue is: " + typeValue);

                if( InventoryItem.doesRestoreHP(type) ){
                    progressUI.addHPValue(typeValue);
                }

                showHearts(progressUI.getHPValue());

                break;
            default:
                break;
        }
    }

    public void showHearts(int hpVal){
        Gdx.app.log(TAG, "hpVal is: " + hpVal);

        for (int i = 0; i<hpVal; i++) {
            all_health_heart.get(i).setVisible(true);
        }
    }

}
