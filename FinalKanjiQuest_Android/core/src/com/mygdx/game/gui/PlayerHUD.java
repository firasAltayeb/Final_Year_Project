package com.mygdx.game.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.FinalKanjiQuest;
import com.mygdx.game.audio.AudioManager;
import com.mygdx.game.audio.AudioObserver;
import com.mygdx.game.audio.AudioSubject;
import com.mygdx.game.battle.BattleObserver;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.ComponentObserver;
import com.mygdx.game.inventory.InventoryItem;
import com.mygdx.game.inventory.InventoryItem.ItemNameID;
import com.mygdx.game.inventory.InventoryItemLocation;
import com.mygdx.game.japanese.KanaLetter;
import com.mygdx.game.japanese.KanaLettersFactory;
import com.mygdx.game.japanese.KanjiLetter;
import com.mygdx.game.japanese.KanjiLettersFactory;
import com.mygdx.game.japanese.LetterLvlCounter;
import com.mygdx.game.maps.MapManager;
import com.mygdx.game.profile.ProfileManager;
import com.mygdx.game.profile.ProfileObserver;
import com.mygdx.game.screens.MainGameScreen;
import com.mygdx.game.tools.Entity;
import com.mygdx.game.tools.Utility;

import java.util.ArrayList;

public class PlayerHUD implements Screen, AudioSubject, ProfileObserver, ComponentObserver, InventoryObserver, BattleObserver {

    private final static String TAG = PlayerHUD.class.getSimpleName();

    private Stage stage;
    private Viewport viewport;
    private Camera camera;
    private Entity player;
    private Json json;
    private FinalKanjiQuest game;

    private MenuListUI menuListUI;
    private ProgressUI progressUI;
    private InventoryUI inventoryUI;
    private KanaUI hiraganaUI;
    private KanaUI katakanaUI;
    private KanjiUI kanjiUI;
    private MnemonicsUI mnemonicsUI;
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

    private int maxNumberOfHearts = -1;
    private int numberOfHearts = -1;
    private MapManager mapManager;

    private Array<AudioObserver> observers;

    public PlayerHUD(Camera camera, final Entity player, final InputMultiplexer multiplexer, MapManager mapMgr, FinalKanjiQuest fkq) {
        this.camera = camera;
        this.player = player;
        viewport = new ScreenViewport(this.camera);
        stage = new Stage(viewport);
        json = new Json();
        mapManager = mapMgr;
        this.game = fkq;

        observers = new Array<AudioObserver>();

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
            health_heart.setPosition(health_heart.getWidth() * all_health_heart.size + i, stage.getHeight() - health_heart.getHeight());
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
        this.addObserver(AudioManager.getInstance());
        player.registerObserver(this);
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

        //Music/Sound loading
        notify(AudioObserver.AudioCommand.MUSIC_LOAD, AudioObserver.AudioTypeEvent.MUSIC_BATTLE);
        notify(AudioObserver.AudioCommand.SOUND_LOAD, AudioObserver.AudioTypeEvent.SOUND_PLAYER_PAIN);
        notify(AudioObserver.AudioCommand.SOUND_LOAD, AudioObserver.AudioTypeEvent.SOUND_EATING);
        notify(AudioObserver.AudioCommand.SOUND_LOAD, AudioObserver.AudioTypeEvent.SOUND_DRINKING);
    }

    @Override
    public void onNotify(ProfileManager ProfileManager, ProfileEvent event) {
        switch(event){
            case PROFILE_LOADED:
                //boolean firstTime = ProfileManager.getIsNewProfile();
                boolean firstTime = true;
                if(firstTime){

                    Gdx.app.log(TAG, "PROFILE LOADED First Time");
                    maxNumberOfHearts = 5;
                    numberOfHearts = 3;
                    showHearts();

                    InventoryUI.clearInventoryItems(inventoryUI.getInventorySlotTable());

                    //add default items if first time
                    Array<ItemNameID> items = player.getEntityConfig().getInventory();
                    Array<InventoryItemLocation> itemLocations = new Array<InventoryItemLocation>();
                    for( int i = 0; i < items.size; i++){
                        itemLocations.add(new InventoryItemLocation(i, items.get(i).toString()));
                    }
                    InventoryUI.populateInventory(inventoryUI.getInventorySlotTable(), itemLocations);
                    //ProfileManager.setProperty("playerInventory", InventoryUI.getInventory(inventoryUI.getInventorySlotTable()));

                } else {
                   //int hpMaxVal = ProfileManager.getProperty("currentPlayerHPMax", Integer.class);
                   //int hpVal = ProfileManager.getProperty("currentPlayerHP", Integer.class);
                   //
                   //maxNumberOfHearts = hpMaxVal;
                   //numberOfHearts = hpVal;
                   //showHearts();
                   //
                   //
                   //ArrayList<KanaLetter> kanaLettersList = KanaLettersFactory.getInstance().getKanaLettersList();
                   //ArrayList<KanjiLetter> kanjiLettersList = KanjiLettersFactory.getInstance().getKanjiLettersList();
                   //Array<Integer> hiraganaProgress = ProfileManager.getProperty("hiraganaList", Array.class);
                   //for(int i = 0; i <= hiraganaProgress.size-1; i++){
                   //    LetterLvlCounter.adjustLvl(kanaLettersList.get(i).getHiraganaEquivalent(),
                   //            hiraganaProgress.get(i));
                   //}
                   //Array<Integer> katakanaProgress = ProfileManager.getProperty("katakanaList", Array.class);
                   //for(int i = 0; i <= katakanaProgress.size-1; i++){
                   //    LetterLvlCounter.adjustLvl(kanaLettersList.get(i).getKatakanaEquivalent(),
                   //            katakanaProgress.get(i));
                   //}
                   //Array<Integer> kanjiProgress = ProfileManager.getProperty("kanjiList", Array.class);
                   //for(int i = 0; i <= kanjiProgress.size-1; i++){
                   //    LetterLvlCounter.adjustLvl(kanjiLettersList.get(i).getKanjiNameID(),
                   //            kanjiProgress.get(i));
                   //}
                   //
                   //progressUI.updateTable();
                   //
                   //LetterLvlCounter.setAllHiraganaMemorised(ProfileManager.getProperty("allHiraganaMemorised", boolean.class));
                   //LetterLvlCounter.setAllKatakanaMemorised(ProfileManager.getProperty("allKatakanaMemorised", boolean.class));
                   //LetterLvlCounter.setAllKanjiMemorised(ProfileManager.getProperty("allKanjiMemorised", boolean.class));
                   //
                   //Array<InventoryItemLocation> inventory = ProfileManager.getProperty("playerInventory", Array.class);
                   //InventoryUI.populateInventory(inventoryUI.getInventorySlotTable(), inventory);
                }

                break;
            case SAVING_PROFILE:
                Gdx.app.log(TAG, "PROFILE Saved");
                //ProfileManager.setProperty("playerInventory",  inventoryUI.getInventory(inventoryUI.getInventorySlotTable()));
                //ProfileManager.setProperty("currentPlayerHPMax", maxNumberOfHearts );
                //ProfileManager.setProperty("currentPlayerHP", numberOfHearts);
                //ProfileManager.setProperty("hiraganaList", LetterLvlCounter.getHiraganaList());
                //ProfileManager.setProperty("katakanaList", LetterLvlCounter.getKatakanaList());
                //ProfileManager.setProperty("kanjiList", LetterLvlCounter.getKanjiList());
                //ProfileManager.setProperty("allHiraganaMemorised", LetterLvlCounter.isAllHiraganaMemorised());
                //ProfileManager.setProperty("allKatakanaMemorised", LetterLvlCounter.isAllKatakanaMemorised());
                //ProfileManager.setProperty("allKanjiMemorised", LetterLvlCounter.isAllKanjiMemorised());
                break;
            case CLEAR_CURRENT_PROFILE:
                //ProfileManager.setProperty("playerInventory", new Array<InventoryItemLocation>());
                //ProfileManager.setProperty("currentPlayerHPMax", 5 );
                //ProfileManager.setProperty("currentPlayerHP", 3 );
                //ProfileManager.setProperty("hiraganaList", 1);
                //ProfileManager.setProperty("katakanaList", 1);
                //ProfileManager.setProperty("kanjiList", 1);
                //ProfileManager.setProperty("allHiraganaMemorised", false);
                //ProfileManager.setProperty("allKatakanaMemorised", false);
                //ProfileManager.setProperty("allKanjiMemorised", false);

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
        //menuItemsXaxis = 0;
        //menuItemsYaxis = height/40;
        //menuItemWindowWidth = width/1.4f;
        //menuItemWindowHeight = height/1.05f;
        //
        //for (int i = 0; i<10; i++) {
        //    all_health_heart.get(i).setPosition(health_heart.getWidth() * i, height - health_heart.getHeight());
        //}
        //
        //menuButton.setPosition(width/1.2f,  height/12);
        //
        //menuListUI.setPosition(width/1.27f, height/2);
        //menuListUI.updateSize(width/3.4f, height/1.4f);
        //
        //progressUI.setPosition(menuItemsXaxis, menuItemsYaxis);
        //progressUI.updateSize(menuItemWindowWidth, menuItemWindowHeight);
        //
        //inventoryUI.setPosition(menuItemsXaxis, menuItemsYaxis);
        //inventoryUI.updateSize(menuItemWindowWidth, menuItemWindowHeight);
        //
        //hiraganaUI.setPosition(menuItemsXaxis, menuItemsYaxis);
        //hiraganaUI.updateSize(menuItemWindowWidth, menuItemWindowHeight);
        //
        //katakanaUI.setPosition(menuItemsXaxis, menuItemsYaxis);
        //katakanaUI.updateSize(menuItemWindowWidth, menuItemWindowHeight);
        //
        //kanjiUI.setPosition(menuItemsXaxis, menuItemsYaxis);
        //kanjiUI.updateSize(menuItemWindowWidth, menuItemWindowHeight);
        //
        //mnemonicsUI.setPosition(menuItemsXaxis, menuItemsYaxis);
        //mnemonicsUI.updateSize(menuItemWindowWidth, menuItemWindowHeight);
        //
        //if(width > 1280 && height > 720){
        //    MainGameScreen.setGameState(MainGameScreen.GameState.LOADING);
        //}
        //
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
        if( player != null ){
            player.unregisterObservers();
            player.dispose();
        }
        if( stage != null ){
            stage.dispose();
        }


    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        if( player != null ){
            player.unregisterObservers();
            player.dispose();
        }
        if( stage != null ){
            stage.clear();
            stage.dispose();
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
                    notify(AudioObserver.AudioCommand.SOUND_PLAY_ONCE, AudioObserver.AudioTypeEvent.SOUND_DRINKING);
                    numberOfHearts = MathUtils.clamp(numberOfHearts + value, 0, maxNumberOfHearts);
                    //ProfileManager.getInstance().setProperty("currentPlayerHP", numberOfHearts);
                    showHearts();
                }
                else if( InventoryItem.doesIncreaseMaxHP(type) ){
                    notify(AudioObserver.AudioCommand.SOUND_PLAY_ONCE, AudioObserver.AudioTypeEvent.SOUND_EATING);
                    maxNumberOfHearts++;
                    numberOfHearts++;
                    showHearts();
                    //ProfileManager.getInstance().setProperty("currentPlayerHP", numberOfHearts);
                    //ProfileManager.getInstance().setProperty("currentPlayerHPMax", maxNumberOfHearts);
                }
                else if(InventoryItem.doesIncreaseHiraganaLvl(type)){
                    notify(AudioObserver.AudioCommand.SOUND_PLAY_ONCE, AudioObserver.AudioTypeEvent.SOUND_LVL_UP);
                    LetterLvlCounter.setAllHiraganaMemorised(true);
                    progressUI.updateTable();
                }
                else if(InventoryItem.doesDecreaseHiraganaLvl(type)){
                    notify(AudioObserver.AudioCommand.SOUND_PLAY_ONCE, AudioObserver.AudioTypeEvent.SOUND_LVL_DOWN);
                    LetterLvlCounter.setAllHiraganaMemorised(false);
                    progressUI.updateTable();
                }
                else if(InventoryItem.doesIncreaseKatakanaLvl(type)){
                    notify(AudioObserver.AudioCommand.SOUND_PLAY_ONCE, AudioObserver.AudioTypeEvent.SOUND_LVL_UP);

                    LetterLvlCounter.setAllKatakanaMemorised(true);
                    progressUI.updateTable();
                }
                else if(InventoryItem.doesDecreaseKatakanaLvl(type)){
                    notify(AudioObserver.AudioCommand.SOUND_PLAY_ONCE, AudioObserver.AudioTypeEvent.SOUND_LVL_DOWN);
                    LetterLvlCounter.setAllKatakanaMemorised(false);
                    progressUI.updateTable();
                }

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
                    //mapManager.disableCurrentmapMusic();
                    //notify(AudioObserver.AudioCommand.MUSIC_PLAY_LOOP, AudioObserver.AudioTypeEvent.MUSIC_BATTLE);
                    battleUI.toBack();
                    battleUI.setVisible(true);
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
                notify(AudioObserver.AudioCommand.SOUND_PLAY_ONCE, AudioObserver.AudioTypeEvent.SOUND_SUCCESS);
                LetterLvlCounter.increaseLvl(answeredLetter, 1);
                progressUI.updateTable();

                MainGameScreen.setGameState(MainGameScreen.GameState.RUNNING);
                //notify(AudioObserver.AudioCommand.MUSIC_STOP, AudioObserver.AudioTypeEvent.MUSIC_BATTLE);
                //mapManager.enableCurrentmapMusic();
                battleUI.setVisible(false);
                break;
            case LETTER_ANSWERED_INCORRECTLY:
                notify(AudioObserver.AudioCommand.SOUND_PLAY_ONCE, AudioObserver.AudioTypeEvent.SOUND_PLAYER_PAIN);
                LetterLvlCounter.decreaseLvl(answeredLetter, 1);
                progressUI.updateTable();
                numberOfHearts--;
                showHearts();
                ProfileManager.getInstance().setProperty("currentPlayerHP", numberOfHearts);
                if( numberOfHearts <= 0 ){
                    //notify(AudioObserver.AudioCommand.MUSIC_STOP, AudioObserver.AudioTypeEvent.MUSIC_BATTLE);
                    battleUI.setVisible(false);
                    MainGameScreen.setGameState(MainGameScreen.GameState.GAME_OVER);
                }
                break;
            case PLAYER_RUNNING:
                MainGameScreen.setGameState(MainGameScreen.GameState.RUNNING);
                //mapManager.enableCurrentmapMusic();
                battleUI.setVisible(false);
                break;
            case PLAYER_HIT_DAMAGE:
                notify(AudioObserver.AudioCommand.SOUND_PLAY_ONCE, AudioObserver.AudioTypeEvent.SOUND_PLAYER_PAIN);
                numberOfHearts--;
                showHearts();
                ProfileManager.getInstance().setProperty("currentPlayerHP", numberOfHearts);
                if( numberOfHearts <= 0 ){
                    battleUI.setVisible(false);
                    MainGameScreen.setGameState(MainGameScreen.GameState.GAME_OVER);
                }
                break;
            default:
                break;
        }
    }

    public void showHearts(){
        for (int i = 0; i<all_health_heart.size; i++) {
            all_health_heart.get(i).setVisible(false);
        }
        for (int j = 0; j < numberOfHearts; j++) {
            all_health_heart.get(j).setVisible(true);
        }
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public void addObserver(AudioObserver audioObserver) {
        observers.add(audioObserver);
    }

    @Override
    public void removeObserver(AudioObserver audioObserver) {
        observers.removeValue(audioObserver, true);
    }

    @Override
    public void removeAllObservers() {
        observers.removeAll(observers, true);
    }

    @Override
    public void notify(AudioObserver.AudioCommand command, AudioObserver.AudioTypeEvent event) {
        for(AudioObserver observer: observers){
            observer.onNotify(command, event);
        }
    }
}
