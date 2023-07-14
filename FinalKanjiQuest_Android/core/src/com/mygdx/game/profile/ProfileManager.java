package com.mygdx.game.profile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.ObjectMap;

import java.util.Enumeration;
import java.util.Hashtable;

public class ProfileManager extends ProfileSubject {
    private Json json;
    private static ProfileManager profileManager;
    private Hashtable<String,FileHandle> profiles = null;
    private ObjectMap<String, Object> profileProperties = new ObjectMap<String, Object>();
    private String _profileName;

    private static final String SAVEGAME_SUFFIX = ".sav";
    public static final String DEFAULT_PROFILE = "default";

    private ProfileManager(){
        json = new Json();
        profiles = new Hashtable<String,FileHandle>();
        profiles.clear();
        _profileName = DEFAULT_PROFILE;
        storeAllProfiles();
    }

    public static final ProfileManager getInstance(){
        if( profileManager == null){
            profileManager = new ProfileManager();
        }
        return profileManager;
    }

    public Array<String> getProfileList(){
        Array<String> profiles = new Array<String>();
        for (Enumeration<String> e = this.profiles.keys(); e.hasMoreElements();){
            profiles.add(e.nextElement());
        }
        return profiles;
    }

    public FileHandle getProfileFile(String profile){
        if( !doesProfileExist(profile) ){
            return null;
        }
        return profiles.get(profile);
    }

    public void storeAllProfiles(){
        if( Gdx.files.isLocalStorageAvailable() ){
            FileHandle[] files = Gdx.files.local(".").list(SAVEGAME_SUFFIX);

            for(FileHandle file: files) {
                profiles.put(file.nameWithoutExtension(), file);
            }
        }else{
            //TODO: try external directory here
            return;
        }
    }

    public boolean doesProfileExist(String profileName){
        return profiles.containsKey(profileName);
    }

    public void writeProfileToStorage(String profileName, String fileData, boolean overwrite){
        String fullFilename = profileName+SAVEGAME_SUFFIX;

        boolean localFileExists = Gdx.files.internal(fullFilename).exists();

        //If we cannot overwrite and the file exists, exit
        if( localFileExists && !overwrite ){
            return;
        }

        FileHandle file =  null;

        if( Gdx.files.isLocalStorageAvailable() ) {
            file = Gdx.files.local(fullFilename);
            file.writeString(fileData, !overwrite);
        }

        profiles.put(profileName, file);
    }

    public void setProperty(String key, Object object){
        profileProperties.put(key, object);
    }

    public <T extends Object> T getProperty(String key, Class<T> type){
        T property = null;
        if( !profileProperties.containsKey(key) ){
            return property;
        }
        property = (T) profileProperties.get(key);
        return property;
    }

    public void saveProfile(){
        notify(this, ProfileObserver.ProfileEvent.SAVING_PROFILE);
        String text = json.prettyPrint(json.toJson(profileProperties));
        writeProfileToStorage(_profileName, text, true);
    }

    public void loadProfile(){
        String fullProfileFileName = _profileName+SAVEGAME_SUFFIX;
        boolean doesProfileFileExist = Gdx.files.internal(fullProfileFileName).exists();

        if( !doesProfileFileExist ){
            System.out.println("File doesn't exist!");
            return;
        }

        profileProperties = json.fromJson(ObjectMap.class, profiles.get(_profileName));
        notify(this, ProfileObserver.ProfileEvent.PROFILE_LOADED);
    }

    public void setCurrentProfile(String profileName){
        if( doesProfileExist(profileName) ){
            _profileName = profileName;
        }else{
            _profileName = DEFAULT_PROFILE;
        }
    }

}
