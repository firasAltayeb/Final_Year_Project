package com.mygdx.game.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.battle.BattleObserver;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.ComponentObserver;
import com.mygdx.game.japanese.LetterLvlCounter;
import com.mygdx.game.tools.Entity;
import com.mygdx.game.tools.OnScreenController;
import com.mygdx.game.tools.Utility;
import com.mygdx.game.inventory.InventoryItem;
import com.mygdx.game.inventory.InventoryItemLocation;
import com.mygdx.game.profile.ProfileManager;
import com.mygdx.game.profile.ProfileObserver;
import com.mygdx.game.screens.MainGameScreen;
import com.mygdx.game.inventory.InventoryItem.ItemNameID;

public class PlayerHUD implements Screen, ProfileObserver, ComponentObserver, InventoryObserver, ProgressObserver, BattleObserver {

    private final static String TAG = PlayerHUD.class.getSimpleName();

    private Stage stage;
    private Viewport viewport;
    private Camera camera;
    private Entity player;
    private Json json;

    private MenuListUI menuListUI;
    private ProgressUI progressUI;
    private InventoryUI inventoryUI;
    private KanaUI hiraganaUI;
    private KanaUI katakanaUI;
    private KanjiUI kanjiUI;
    private MnemonicsUI mnemonicsUI;
    private OnScreenController controllerUI;
    private BattleUI battleUI;

    private TextButton menuButton;
    private TextButton progressButton;
    private TextButton inventoryButton;
    private TextButton hiraganaButton;
    private TextButton katakanaButton;
    private TextButton kanjiButton;
    private TextButton mnemonicsButton;
    private TextButton controllerButton;

    private Array<Image> all_health_heart;
    private Image health_heart;

    private float menuItemsXaxis;
    private float menuItemsYaxis;
    private float menuItemWindowWidth;
    private float menuItemWindowHeight;

    public PlayerHUD(Camera camera, final Entity player, final InputMultiplexer multiplexer) {
        this.camera = camera;
        this.player = player;
        viewport = new ScreenViewport(this.camera);
        stage = new Stage(viewport);
        json = new Json();

        multiplexer.addProcessor(this.getStage());
        multiplexer.addProcessor(player.getInputProcessor());
        Gdx.input.setInputProcessor(multiplexer);

        menuItemsXaxis = 0;
        menuItemsYaxis = stage.getHeight()/40;
        menuItemWindowWidth = stage.getWidth()/1.4f;
        menuItemWindowHeight = stage.getHeight()/1.05f;

        all_health_heart = new Array<Image>();

        //TODO speak about this
        for (int i = 0; i<10; i++) {
            health_heart = new Image(Utility.ITEMS_TEXTUREATLAS.findRegion("HEALTH_HEART"));
            health_heart.setPosition(health_heart.getWidth() * i, stage.getHeight() - health_heart.getHeight());
            health_heart.setVisible(false);
            all_health_heart.add(health_heart);
        }

        menuButton = new TextButton("menu", Utility.GUI_SKINS);
        menuButton.setPosition(stage.getWidth()/1.2f,  stage.getHeight()/12);
        menuButton.setVisible(true);

        menuListUI = new MenuListUI();
        menuListUI.setSize(stage.getWidth()/3.4f,  stage.getHeight()/1.4f);
        menuListUI.setPosition(stage.getWidth()/1.27f, stage.getHeight()/2);
        menuListUI.setMovable(false);
        menuListUI.setVisible(false);

        progressUI = new ProgressUI(menuItemWindowWidth, menuItemWindowHeight);
        progressUI.setPosition(menuItemsXaxis, menuItemsYaxis);
        progressUI.setVisible(false);
        progressUI.setMovable(false);
        progressUI.updateTable();

        //Gdx.app.debug(TAG, "All hiragana memorised is " + LetterLvlCounter.areAllHiraganaMemorised());

        inventoryUI = new InventoryUI(menuItemWindowWidth, menuItemWindowHeight);
        inventoryUI.setPosition(menuItemsXaxis, menuItemsYaxis);
        inventoryUI.setMovable(false);
        inventoryUI.setVisible(false);

        hiraganaUI = new KanaUI(menuItemWindowWidth, menuItemWindowHeight, "Hiragana");
        hiraganaUI.setPosition(menuItemsXaxis, menuItemsYaxis);
        hiraganaUI.setMovable(false);
        hiraganaUI.setVisible(false);

        katakanaUI = new KanaUI(menuItemWindowWidth, menuItemWindowHeight, "Katakana");
        katakanaUI.setPosition(menuItemsXaxis, menuItemsYaxis);
        katakanaUI.setMovable(false);
        katakanaUI.setVisible(false);

        kanjiUI = new KanjiUI(menuItemWindowWidth, menuItemWindowHeight);
        kanjiUI.setPosition(menuItemsXaxis, menuItemsYaxis);
        kanjiUI.setMovable(false);
        kanjiUI.setVisible(false);

        mnemonicsUI = new MnemonicsUI(menuItemWindowWidth, menuItemWindowHeight);
        mnemonicsUI.setPosition(menuItemsXaxis, menuItemsYaxis);
        mnemonicsUI.setMovable(false);
        mnemonicsUI.setVisible(false);


        Gdx.app.log(TAG, "all_health_heart.size is: " + all_health_heart.size);

        for (int i = 0; i<all_health_heart.size; i++) {
            stage.addActor(all_health_heart.get(i));
        }

        battleUI = new BattleUI();
        battleUI.setFillParent(true);
        battleUI.setVisible(false);
        battleUI.setMovable(false);
        //removes all listeners including ones that handle focus
        battleUI.clearListeners();

        stage.addActor(battleUI);
        stage.addActor(menuButton);
        stage.addActor(menuListUI);
        stage.addActor(progressUI);
        stage.addActor(inventoryUI);
        stage.addActor(hiraganaUI);
        stage.addActor(katakanaUI);
        stage.addActor(kanjiUI);
        stage.addActor(mnemonicsUI);

        //Observers
        ProfileManager.getInstance().addObserver(this);
        player.registerObserver(this);
        progressUI.addObserver(this);
        inventoryUI.addObserver(this);
        battleUI.getCurrentState().addObserver(this);

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
                katakanaUI.setVisible(false);
                hiraganaUI.setVisible(false);
                mnemonicsUI.setVisible(false);
                kanjiUI.setVisible(false);
            }
        });

        progressButton =  menuListUI.getProgressButton();
        progressButton.addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                inventoryUI.setVisible(false);
                katakanaUI.setVisible(false);
                hiraganaUI.setVisible(false);
                kanjiUI.setVisible(false);
                mnemonicsUI.setVisible(false);
                progressUI.setVisible(progressUI.isVisible()?false:true);
            }
        });

        inventoryButton = menuListUI.getInventoryButton();
        inventoryButton.addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                progressUI.setVisible(false);
                katakanaUI.setVisible(false);
                hiraganaUI.setVisible(false);
                kanjiUI.setVisible(false);
                mnemonicsUI.setVisible(false);
                inventoryUI.setVisible(inventoryUI.isVisible()?false:true);
            }
        });

        hiraganaButton = menuListUI.getHiraganaButton();
        hiraganaButton.addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                progressUI.setVisible(false);
                inventoryUI.setVisible(false);
                katakanaUI.setVisible(false);
                kanjiUI.setVisible(false);
                mnemonicsUI.setVisible(false);
                hiraganaUI.setVisible(hiraganaUI.isVisible()?false:true);

            }
        });

        katakanaButton = menuListUI.getKatakanaButton();
        katakanaButton.addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                progressUI.setVisible(false);
                inventoryUI.setVisible(false);
                hiraganaUI.setVisible(false);
                kanjiUI.setVisible(false);
                mnemonicsUI.setVisible(false);
                katakanaUI.setVisible(katakanaUI.isVisible()?false:true);
            }
        });

        kanjiButton = menuListUI.getKanjiButton();
        kanjiButton.addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                progressUI.setVisible(false);
                inventoryUI.setVisible(false);
                hiraganaUI.setVisible(false);
                katakanaUI.setVisible(false);
                mnemonicsUI.setVisible(false);
                kanjiUI.setVisible(kanjiUI.isVisible()?false:true);
            }
        });

        mnemonicsButton = menuListUI.getMnemonicsButton();
        mnemonicsButton.addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                progressUI.setVisible(false);
                inventoryUI.setVisible(false);
                hiraganaUI.setVisible(false);
                katakanaUI.setVisible(false);
                kanjiUI.setVisible(false);
                mnemonicsUI.setVisible(mnemonicsUI.isVisible()?false:true);
            }
        });
    }

    @Override
    public void onNotify(ProfileManager profileManager, ProfileObserver.ProfileEvent event) {
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
                    Array<InventoryItem.ItemNameID> items = player.getEntityConfig().getInventory();
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
    public void onNotify(String value, ComponentEvent event) {
        switch(event) {
            case ENEMY_SPAWN_LOCATION_CHANGED:
                String enemyZoneID = value;
                Gdx.app.debug(TAG, "ENEMY_SPAWN_LOCATION_CHANGED " + enemyZoneID);
                battleUI.battleZoneTriggered(Integer.parseInt(enemyZoneID));
                break;
            case PLAYER_HAS_MOVED:
                //Gdx.app.debug(TAG, "PLAYER_HAS_MOVED ");
                if (battleUI.isBattleReady()) {
                    MainGameScreen.setGameState(MainGameScreen.GameState.SAVING);
                    battleUI.toBack();
                    battleUI.setVisible(true);
                }
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

    @Override //TODO speak about this in the report
    public void resize(int width, int height) {
        menuItemsXaxis = 0;
        menuItemsYaxis = height/40;
        menuItemWindowWidth = width/1.4f;
        menuItemWindowHeight = height/1.05f;

        Gdx.app.log(TAG, "resize height is: " + height);

        for (int i = 0; i<10; i++) {
            all_health_heart.get(i).setPosition(health_heart.getWidth() * i, height - health_heart.getHeight());
        }

        menuButton.setPosition(width/1.2f,  height/12);

        menuListUI.setPosition(width/1.27f, height/2);
        menuListUI.updateSize(width/3.4f, height/1.4f);

        progressUI.setPosition(menuItemsXaxis, menuItemsYaxis);
        progressUI.updateSize(menuItemWindowWidth, menuItemWindowHeight);

        inventoryUI.setPosition(menuItemsXaxis, menuItemsYaxis);
        inventoryUI.updateSize(menuItemWindowWidth, menuItemWindowHeight);

        hiraganaUI.setPosition(menuItemsXaxis, menuItemsYaxis);
        hiraganaUI.updateSize(menuItemWindowWidth, menuItemWindowHeight);

        katakanaUI.setPosition(menuItemsXaxis, menuItemsYaxis);
        katakanaUI.updateSize(menuItemWindowWidth, menuItemWindowHeight);

        kanjiUI.setPosition(menuItemsXaxis, menuItemsYaxis);
        kanjiUI.updateSize(menuItemWindowWidth, menuItemWindowHeight);

        mnemonicsUI.setPosition(menuItemsXaxis, menuItemsYaxis);
        mnemonicsUI.updateSize(menuItemWindowWidth, menuItemWindowHeight);


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
        player.dispose();
    }

    @Override
    public void onNotify(int value, StatusEvent event) {
        switch(event) {
            case UPDATED_HP:
                ProfileManager.getInstance().setProperty("currentPlayerHP", progressUI.getHPValue());
                break;
            case UPDATED_MAX_HP:
                ProfileManager.getInstance().setProperty("currentPlayerHPMax", progressUI.getHPValueMax());
                break;
            default:
                break;
        }
    }

    @Override
    public void onNotify(String itemInfo, InventoryEvent event) {
        switch(event){
            case ITEM_CONSUMED:
                String[] strings = itemInfo.split(Component.MESSAGE_TOKEN);
                if( strings.length != 2) return;

                int type = Integer.parseInt(strings[0]);
                int value = Integer.parseInt(strings[1]);

                //Gdx.app.log(TAG, "typeValue is: " + typeValue);

                if( InventoryItem.doesRestoreHP(type) ){
                    progressUI.addHPValue(value);
                    showHearts(progressUI.getHPValue());
                }
                else if(InventoryItem.doesIncreaseHiraganaLvl(type)){
                    LetterLvlCounter.allHiraganaMemorised();
                    progressUI.updateTable();
                }
                else if(InventoryItem.doesDecreaseHiraganaLvl(type)){
                    LetterLvlCounter.allHiraganaNotMemorised();
                    progressUI.updateTable();
                }


                break;
            default:
                break;
        }
    }

    @Override
    public void onNotify(String answeredLetter, BattleEvent event) {
        int hpVal;
        switch (event) {
            case LETTER_ANSWERED_CORRECTLY:
                Gdx.app.debug(TAG, "areAllHiraganaMemorised: " + LetterLvlCounter.areAllHiraganaMemorised());
                LetterLvlCounter.increaseLvl(answeredLetter, 1);
                progressUI.updateTable();

                MainGameScreen.setGameState(MainGameScreen.GameState.RUNNING);
                battleUI.setVisible(false);
                break;
            case LETTER_ANSWERED_INCORRECTLY:
                LetterLvlCounter.decreaseLvl(answeredLetter, 1);
                progressUI.updateTable();

                hpVal = progressUI.getHPValue() - 1;
                progressUI.setHPValue(hpVal);
                showHearts(hpVal);
                if( hpVal <= 0 ){
                    battleUI.setVisible(false);
                    MainGameScreen.setGameState(MainGameScreen.GameState.GAME_OVER);
                }
                break;
            case PLAYER_RUNNING:
                MainGameScreen.setGameState(MainGameScreen.GameState.RUNNING);
                battleUI.setVisible(false);
                break;
            case PLAYER_HIT_DAMAGE:
                hpVal = progressUI.getHPValue() - 1;
                progressUI.setHPValue(hpVal);
                showHearts(hpVal);
                if( hpVal <= 0 ){
                    battleUI.setVisible(false);
                    MainGameScreen.setGameState(MainGameScreen.GameState.GAME_OVER);
                }
                break;
            default:
                break;
        }
    }

    public void showHearts(int hpVal){
        //Gdx.app.log(TAG, "hpVal is: " + hpVal);
        for (int i = 0; i<all_health_heart.size; i++) {
            all_health_heart.get(i).setVisible(false);
        }
        for (int j = 0; j <hpVal; j++) {
            all_health_heart.get(j).setVisible(true);
        }
    }

    public Stage getStage() {
        return stage;
    }

}
