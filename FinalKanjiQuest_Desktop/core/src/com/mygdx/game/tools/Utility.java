package com.mygdx.game.tools;

/**
 * Created by Firas on 19/02/2017.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public final class Utility {

    public static final AssetManager assetManager = new AssetManager();

    private static final String TAG = Utility.class.getSimpleName();
    // a nice convenience class for  managing file handles when resolving paths
    private static InternalFileHandleResolver filepathResolver = new InternalFileHandleResolver();

    private final static String GUI_SHEET_PATH = "gui/gui_sheet.atlas";
    private final static String GUI_SKINS_PATH = "gui/gui_skins.json";
    private final static String ITEMS_SHEET_PATH = "items/items_sheet.txt";

    private final static String LARGE_HIRAGANA_SHEET_PATH = "japanese/large_hiragana_sheet.txt";
    private final static String LARGE_KATAKANA_SHEET_PATH = "japanese/large_katakana_sheet.txt";
    private final static String LARGE_ROMAJI_SHEET_PATH = "japanese/large_romaji_sheet.txt";
    private final static String MEDIUM_HIRAGANA_SHEET_PATH = "japanese/medium_hiragana_sheet.txt";
    private final static String MEDIUM_KATAKANA_SHEET_PATH = "japanese/medium_katakana_sheet.txt";
    private final static String MEDIUM_ROMAJI_SHEET_PATH = "japanese/medium_romaji_sheet.txt";
    private final static String SMALL_HIRAGANA_SHEET_PATH = "japanese/small_hiragana_sheet.txt";
    private final static String SMALL_KATAKANA_SHEET_PATH = "japanese/small_katakana_sheet.txt";
    private final static String SMALL_ROMAJI_SHEET_PATH = "japanese/small_romaji_sheet.txt";

    public static TextureAtlas GUI_TEXTUREATLAS = new TextureAtlas(GUI_SHEET_PATH);
    public static TextureAtlas ITEMS_TEXTUREATLAS = new TextureAtlas(ITEMS_SHEET_PATH);

    public static TextureAtlas LARGE_HIRAGANA_TEXTUREATLAS = new TextureAtlas(LARGE_HIRAGANA_SHEET_PATH);
    public static TextureAtlas LARGE_KATAKANA_TEXTUREATLAS = new TextureAtlas(LARGE_KATAKANA_SHEET_PATH);
    public static TextureAtlas LARGE_ROMAJI_TEXTUREATLAS = new TextureAtlas(LARGE_ROMAJI_SHEET_PATH);
    public static TextureAtlas MEDIUM_HIRAGANA_TEXTUREATLAS = new TextureAtlas(MEDIUM_HIRAGANA_SHEET_PATH);
    public static TextureAtlas MEDIUM_KATAKANA_TEXTUREATLAS = new TextureAtlas(MEDIUM_KATAKANA_SHEET_PATH);
    public static TextureAtlas MEDIUM_ROMAJI_TEXTUREATLAS = new TextureAtlas(MEDIUM_ROMAJI_SHEET_PATH);
    public static TextureAtlas SMALL_HIRAGANA_SHEET_TEXTUREATLAS = new TextureAtlas(SMALL_HIRAGANA_SHEET_PATH);
    public static TextureAtlas SMALL_KATAKANA_SHEET_TEXTUREATLAS = new TextureAtlas(SMALL_KATAKANA_SHEET_PATH);
    public static TextureAtlas SMALL_ROMAJI_SHEET_TEXTUREATLAS = new TextureAtlas(SMALL_ROMAJI_SHEET_PATH);

    public static Skin GUI_SKINS = new Skin(Gdx.files.internal(GUI_SKINS_PATH), GUI_TEXTUREATLAS);

    public static void unloadAsset (String assetFileNamePath){
        // once the asset manger is done loading
        if(assetManager.isLoaded(assetFileNamePath)){
            assetManager.unload(assetFileNamePath);
        } else {
            Gdx.app.debug(TAG, "Asset is not loaded; Nothing to unload " + assetFileNamePath);
        }
    }

    //wraps the progress of AssetManager as a percentage of completion
    public static float loadCompleted(){
        return assetManager.getProgress();
    }

    //wraps the number of assets left to load from the AssetManager queue
    public static int numberAssetsQueued(){
        return assetManager.getQueuedAssets();
    }

    public static boolean updateAssetLoading(){
        return assetManager.update();
    }

    public static boolean isAssetLoaded(String fileName){
        return assetManager.isLoaded(fileName);
    }

    public static void loadMapAsset(String mapFilenamePath) {
        if (mapFilenamePath == null || mapFilenamePath.isEmpty()) {
            //checks if null so to avoid exception in nxt statement
            return;
        }

        if( assetManager.isLoaded(mapFilenamePath) ){
            return;
        }

        //load asset
        if (filepathResolver.resolve(mapFilenamePath).exists()) {
            assetManager.setLoader(TiledMap.class, new TmxMapLoader(filepathResolver));
            assetManager.load(mapFilenamePath, TiledMap.class);
            //until loading screen is added, block
            assetManager.finishLoadingAsset(mapFilenamePath);
            Gdx.app.debug(TAG, "Map loaded: " + mapFilenamePath);
        } else{
            Gdx.app.debug(TAG, "Map doesn't exist: " + mapFilenamePath);
        }
    }

    public static TiledMap getMapAsset(String mapFilenamePath){
        TiledMap map = null;
        //checks null or not so to avoid exception in nxt statement
        if(assetManager.isLoaded(mapFilenamePath)) {
            map = assetManager.get(mapFilenamePath, TiledMap.class);
        } else {
            Gdx.app.debug(TAG, "Map is not loaded: " + mapFilenamePath);
        }
        return map;
    }

    public static void loadTextureAsset(String textureFilenamePath){
        if(textureFilenamePath == null || textureFilenamePath.isEmpty()){
            //checks if null so to avoid exception in nxt statement
            return;
        }
        //load asset
        if(filepathResolver.resolve(textureFilenamePath).exists()){
            assetManager.setLoader(Texture.class, new TextureLoader(filepathResolver));
            assetManager.load(textureFilenamePath, Texture.class);
            //until loading screen is added, block
            assetManager.finishLoadingAsset(textureFilenamePath);
            Gdx.app.debug(TAG, "Texture loaded: " + textureFilenamePath);
        } else{
            Gdx.app.debug(TAG, "Texture doesn't exist: " + textureFilenamePath);
        }
    }

    public static Texture getTextureAsset(String textureFilenamePath){
        Texture texture = null;

        //once asset manger is done loading
        if(assetManager.isLoaded(textureFilenamePath)){
            texture = assetManager.get(textureFilenamePath, Texture.class);
        } else {
            Gdx.app.debug(TAG, "Texture is not loaded: " + textureFilenamePath);
        }
        return texture;
    }


}
