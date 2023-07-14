package com.mygdx.game;

import android.os.Bundle;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.mygdx.game.screens.MainGameScreen;


public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		initialize(new FinalKanjiQuest(), config);

		Gdx.app.setLogLevel(Application.LOG_DEBUG);
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onResume() {
		super.onResume();
		//MainGameScreen.setGameState(MainGameScreen.GameState.PAUSED);
	}

	@Override
	protected void onPause() {
		super.onPause();
		//MainGameScreen.setGameState(MainGameScreen.GameState.PAUSED);
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
