package com.mygdx.game.audio;

public interface AudioObserver {
    public static enum AudioTypeEvent{
        MUSIC_TITLE("audio/main_music.ogg"),
        MUSIC_TOPWORLD("audio/topworld_music.ogg"),
        MUSIC_TOWN("audio/town_music.mp3"),
        MUSIC_BATTLE("audio/random_battle.mp3"),
        MUSIC_FOREST("audio/forest.mp3"),
        MUSIC_CAVE("audio/cave_music.mp3"),
        MUSIC_COAST("audio/coast_music.mp3"),
        MUSIC_ICE_FOREST("audio/ice_forest_music.mp3"),
        MUSIC_DESERT_TEMPLE("audio/desert_temple_music.mp3"),
        MUSIC_LAVA("audio/lava_music.mp3"),
        SOUND_PLAYER_PAIN("audio/player_hit.wav"),
        SOUND_EATING("audio/eating_sound.wav"),
        SOUND_DRINKING("audio/liquid_drinking.wav"),
        SOUND_SUCCESS("audio/success.wav"),
        SOUND_LVL_UP("audio/level_up.wav"),
        SOUND_LVL_DOWN("audio/level_down.wav"),
        NONE("");

        private String audioFullFilePath;

        AudioTypeEvent(String audioFullFilePath){
            this.audioFullFilePath = audioFullFilePath;
        }

        public String getValue(){
            return audioFullFilePath;
        }
    }

    public static enum AudioCommand {
        MUSIC_LOAD,
        MUSIC_PLAY_ONCE,
        MUSIC_PLAY_LOOP,
        MUSIC_STOP,
        MUSIC_STOP_ALL,
        SOUND_LOAD,
        SOUND_PLAY_ONCE,
        SOUND_PLAY_LOOP,
        SOUND_STOP
    }

    void onNotify(AudioCommand command, AudioTypeEvent event);
}
