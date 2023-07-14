package com.mygdx.game.tools;

/**
 * Created by Firas on 19/02/2017.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.MusicLoader;
import com.badlogic.gdx.assets.loaders.SoundLoader;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public final class Utility {

    public static final AssetManager assetManager = new AssetManager();

    private static final String TAG = Utility.class.getSimpleName();
    // a nice convenience class for  managing file handles when resolving paths
    private static InternalFileHandleResolver filePathResolver = new InternalFileHandleResolver();

    private final static String GUI_SHEET_PATH = "gui/gui_sheet.atlas";
    private final static String GUI_SKINS_PATH = "gui/gui_skins.json";
    private final static String ITEMS_SHEET_PATH = "items/small_items_sheet.txt";
    private final static String HIRO_SHEET_PATH = "sprites/chara/large_hiro_sheet.txt";

    private final static String LARGE_HIRAGANA_SHEET_PATH = "japanese/hiragana/large_hiragana_sheet.txt";
    private final static String LARGE_KATAKANA_SHEET_PATH = "japanese/katakana/large_katakana_sheet.txt";
    private final static String LARGE_ROMAJI_SHEET_PATH = "japanese/romaji/large_romaji_sheet.txt";
    private final static String MEDIUM_HIRAGANA_SHEET_PATH = "japanese/hiragana/medium_hiragana_sheet.txt";
    private final static String MEDIUM_KATAKANA_SHEET_PATH = "japanese/katakana/medium_katakana_sheet.txt";
    private final static String MEDIUM_ROMAJI_SHEET_PATH = "japanese/romaji/medium_romaji_sheet.txt";
    private final static String SMALL_HIRAGANA_SHEET_PATH = "japanese/hiragana/small_hiragana_sheet.txt";
    private final static String SMALL_KATAKANA_SHEET_PATH = "japanese/katakana/small_katakana_sheet.txt";
    private final static String SMALL_ROMAJI_SHEET_PATH = "japanese/romaji/small_romaji_sheet.txt";

    private final static String SMALL_KANJI_SHEET_PATH = "japanese/kanji/small_kanji_sheet.txt";
    private final static String MEDIUM_KANJI_SHEET_PATH = "japanese/kanji/medium_kanji_sheet.txt";
    private final static String LARGE_KANJI_SHEET_PATH = "japanese/kanji/large_kanji_sheet.txt";

    public static TextureAtlas GUI_TEXTUREATLAS = new TextureAtlas(GUI_SHEET_PATH);
    public static TextureAtlas ITEMS_TEXTUREATLAS = new TextureAtlas(ITEMS_SHEET_PATH);
    public static TextureAtlas HIRO_TEXTUREATLAS = new TextureAtlas(HIRO_SHEET_PATH);

    public static TextureAtlas LARGE_HIRAGANA_TEXTUREATLAS = new TextureAtlas(LARGE_HIRAGANA_SHEET_PATH);
    public static TextureAtlas LARGE_KATAKANA_TEXTUREATLAS = new TextureAtlas(LARGE_KATAKANA_SHEET_PATH);
    public static TextureAtlas LARGE_ROMAJI_TEXTUREATLAS = new TextureAtlas(LARGE_ROMAJI_SHEET_PATH);
    public static TextureAtlas MEDIUM_HIRAGANA_TEXTUREATLAS = new TextureAtlas(MEDIUM_HIRAGANA_SHEET_PATH);
    public static TextureAtlas MEDIUM_KATAKANA_TEXTUREATLAS = new TextureAtlas(MEDIUM_KATAKANA_SHEET_PATH);
    public static TextureAtlas MEDIUM_ROMAJI_TEXTUREATLAS = new TextureAtlas(MEDIUM_ROMAJI_SHEET_PATH);
    public static TextureAtlas SMALL_HIRAGANA_TEXTUREATLAS = new TextureAtlas(SMALL_HIRAGANA_SHEET_PATH);
    public static TextureAtlas SMALL_KATAKANA_TEXTUREATLAS = new TextureAtlas(SMALL_KATAKANA_SHEET_PATH);
    public static TextureAtlas SMALL_ROMAJI_TEXTUREATLAS = new TextureAtlas(SMALL_ROMAJI_SHEET_PATH);

    public static TextureAtlas SMALL_KANJI_TEXTUREATLAS = new TextureAtlas(SMALL_KANJI_SHEET_PATH);
    public static TextureAtlas MEDIUM_KANJI_TEXTUREATLAS = new TextureAtlas(MEDIUM_KANJI_SHEET_PATH);
    public static TextureAtlas LARGE_KANJI_TEXTUREATLAS = new TextureAtlas(LARGE_KANJI_SHEET_PATH);

    public static Skin GUI_SKINS = new Skin(Gdx.files.internal(GUI_SKINS_PATH), GUI_TEXTUREATLAS);

    public static boolean isAssetLoaded(String fileName){
        return assetManager.isLoaded(fileName);
    }

    public static void loadMusicAsset(String musicFilenamePath){
        if( musicFilenamePath == null || musicFilenamePath.isEmpty() ){
            return;
        }

        if( assetManager.isLoaded(musicFilenamePath) ){
            return;
        }

        //load asset
        if( filePathResolver.resolve(musicFilenamePath).exists() ){
            assetManager.setLoader(Music.class, new MusicLoader(filePathResolver));
            assetManager.load(musicFilenamePath, Music.class);
            //Until we add loading screen, just block until we load the map
            assetManager.finishLoadingAsset(musicFilenamePath);
            Gdx.app.debug(TAG, "Music loaded!: " + musicFilenamePath);
        }
        else{
            Gdx.app.debug(TAG, "Music doesn't exist!: " + musicFilenamePath );
        }
    }

    public static void loadSoundAsset(String soundFilenamePath){
        if( soundFilenamePath == null || soundFilenamePath.isEmpty() ){
            return;
        }

        if( assetManager.isLoaded(soundFilenamePath) ){
            return;
        }

        //load asset
        if( filePathResolver.resolve(soundFilenamePath).exists() ){
            assetManager.setLoader(Sound.class, new SoundLoader(filePathResolver));
            assetManager.load(soundFilenamePath, Sound.class);
            //Until we add loading screen, just block until we load the map
            assetManager.finishLoadingAsset(soundFilenamePath);
            Gdx.app.debug(TAG, "Sound loaded!: " + soundFilenamePath);
        }
        else{
            Gdx.app.debug(TAG, "Sound doesn't exist!: " + soundFilenamePath );
        }
    }

    public static Music getMusicAsset(String musicFilenamePath){
        Music music = null;

        // once the asset manager is done loading
        if( assetManager.isLoaded(musicFilenamePath) ){
            music = assetManager.get(musicFilenamePath,Music.class);
        } else {
            Gdx.app.debug(TAG, "Music is not loaded: " + musicFilenamePath );
        }

        return music;
    }

    public static Sound getSoundAsset(String soundFilenamePath){
        Sound sound = null;

        // once the asset manager is done loading
        if( assetManager.isLoaded(soundFilenamePath) ){
            sound = assetManager.get(soundFilenamePath,Sound.class);
        } else {
            Gdx.app.debug(TAG, "Sound is not loaded: " + soundFilenamePath );
        }

        return sound;
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
        if (filePathResolver.resolve(mapFilenamePath).exists()) {
            assetManager.setLoader(TiledMap.class, new TmxMapLoader(filePathResolver));
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
        if(filePathResolver.resolve(textureFilenamePath).exists()){
            assetManager.setLoader(Texture.class, new TextureLoader(filePathResolver));
            assetManager.load(textureFilenamePath, Texture.class);
            //until loading screen is added, block
            assetManager.finishLoadingAsset(textureFilenamePath);
            //Gdx.app.debug(TAG, "Texture loaded: " + textureFilenamePath);
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
