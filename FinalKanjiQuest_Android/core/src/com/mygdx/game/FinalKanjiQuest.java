package com.mygdx.game;

import com.mygdx.game.screens.MainGameScreen;
import com.badlogic.gdx.Game;

public class FinalKanjiQuest extends Game {

	public static final int V_WIDTH = 370;
	public static final int V_HEIGHT = 238;

	public static final MainGameScreen mainGameScreen = new MainGameScreen();

	@Override
	public void create () {
		setScreen(mainGameScreen);
	}

	@Override
	public void dispose () {
		mainGameScreen.dispose();
	}
}
