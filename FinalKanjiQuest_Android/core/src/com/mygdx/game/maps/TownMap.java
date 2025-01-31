package com.mygdx.game.maps;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.audio.AudioObserver;
import com.mygdx.game.components.PlayerPhysicsComponent;
import com.mygdx.game.tools.Entity;

public class TownMap extends Map {
    private static final String TAG = PlayerPhysicsComponent.class.getSimpleName();

    private static String mapPath = "tilemaps/town.tmx";
    private static String walkaround_one = "json_scripts/chara/walkaround_one.json";
    private static String walkaround_two = "json_scripts/chara/walkaround_two.json";
    private static String walkaround_three = "json_scripts/chara/walkaround_three.json";
    private static String walkaround_four = "json_scripts/chara/walkaround_four.json";
    private static String inn_clark = "json_scripts/chara/inn_clark.json";

    public TownMap(){
        super(MapFactory.MapType.TOWN, mapPath);

        for( Vector2 position: npcStartPositions){
            mapEntities.add(initEntity(Entity.getEntityConfig(walkaround_one), position));
        }

        //Special cases
        mapEntities.add(initSpecialEntity(Entity.getEntityConfig(walkaround_two)));
        mapEntities.add(initSpecialEntity(Entity.getEntityConfig(walkaround_three)));
        mapEntities.add(initSpecialEntity(Entity.getEntityConfig(walkaround_four)));
        mapEntities.add(initSpecialEntity(Entity.getEntityConfig(inn_clark)));
    }

    @Override
    public void updateMapEntities(MapManager mapMgr, Batch batch, float delta){
        for(int i = 0; i < mapEntities.size; i++){
            mapEntities.get(i).update(mapMgr, batch, delta);
        }
    }

    @Override
    public void unloadMusic() {
        notify(AudioObserver.AudioCommand.MUSIC_STOP, AudioObserver.AudioTypeEvent.MUSIC_TOWN);
    }

    @Override
    public void loadMusic() {
        notify(AudioObserver.AudioCommand.MUSIC_LOAD, AudioObserver.AudioTypeEvent.MUSIC_TOWN);
        notify(AudioObserver.AudioCommand.MUSIC_PLAY_LOOP, AudioObserver.AudioTypeEvent.MUSIC_TOWN);
    }

}
