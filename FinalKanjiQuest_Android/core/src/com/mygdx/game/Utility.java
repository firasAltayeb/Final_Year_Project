package com.mygdx.game;

/**
 * Created by Firas on 19/02/2017.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;


public final class Utility {

    public static final AssetManager assetManger = new AssetManager();
    private static final String TAG = Utility.class.getSimpleName();
    // a nice convenience class for  managing file handles when resolving paths
    private static InternalFileHandleResolver filepathResolver = new InternalFileHandleResolver();

    public static void unloadAsset (String assetFileNamePath){
        // once the asset manger is done loading
        if(assetManger.isLoaded(assetFileNamePath)){
            assetManger.unload(assetFileNamePath);
        } else {
            Gdx.app.debug(TAG, "Asset is not loaded; Nothing to unload " + assetFileNamePath);
        }
    }

    //wraps the progress of AssetManager as a percentage of completion
    public static float loadCompleted(){
        return assetManger.getProgress();
    }

    //wraps the number of assets left to load from the AssetManager queue
    public static int numberAssetsQueued(){
        return assetManger.getQueuedAssets();
    }

    public static boolean updateAssetLoading(){
        return assetManger.update();
    }

    public static boolean isAssetLoaded(String fileName){
        return assetManger.isLoaded(fileName);
    }

    public static void loadMapAsset(String mapFilenamePath) {
        if (mapFilenamePath == null || mapFilenamePath.isEmpty()) {
            //checks if null so to avoid exception in nxt statement
            return;
        }
        //load asset
        if (filepathResolver.resolve(mapFilenamePath).exists()) {
            assetManger.setLoader(TiledMap.class, new TmxMapLoader(filepathResolver));
            assetManger.load(mapFilenamePath, TiledMap.class);
            //until loading screen is added, block
            assetManger.finishLoadingAsset(mapFilenamePath);
            Gdx.app.debug(TAG, "Map loaded: " + mapFilenamePath);
        } else{
            Gdx.app.debug(TAG, "Map doesn't exist: " + mapFilenamePath);
        }
    }

    public static TiledMap getMapAsset(String mapFilenamePath){
        TiledMap map = null;
        //checks null or not so to avoid exception in nxt statement
        if(assetManger.isLoaded(mapFilenamePath)) {
            map = assetManger.get(mapFilenamePath, TiledMap.class);
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
            assetManger.setLoader(Texture.class, new TextureLoader(filepathResolver));
            assetManger.load(textureFilenamePath, Texture.class);
            //until loading screen is added, block
            assetManger.finishLoadingAsset(textureFilenamePath);
            Gdx.app.debug(TAG, "Texture loaded: " + textureFilenamePath);
        } else{
            Gdx.app.debug(TAG, "Texture doesn't exist: " + textureFilenamePath);
        }
    }

    public static Texture getTextureAsset(String textureFilenamePath){
        Texture texture = null;

        //once asset manger is done loading
        if(assetManger.isLoaded(textureFilenamePath)){
            texture = assetManger.get(textureFilenamePath, Texture.class);
        } else {
            Gdx.app.debug(TAG, "Texture is not loaded: " + textureFilenamePath);
        }
        return texture;
    }


}
