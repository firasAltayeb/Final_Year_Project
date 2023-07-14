package com.mygdx.game;

/**
 * Created by Firas on 19/02/2017.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.assets.AssetManager;

public final class Utility {

    public static final AssetManager assetManager = new AssetManager();

    private static final String TAG = Utility.class.getSimpleName();
    // a nice convenience class for  managing file handles when resolving paths
    private static InternalFileHandleResolver filepathResolver = new InternalFileHandleResolver();

    public static void unloadAsset (java.lang.String assetFileNamePath){
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
