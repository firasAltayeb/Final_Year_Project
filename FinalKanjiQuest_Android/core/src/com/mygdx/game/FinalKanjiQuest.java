package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mygdx.game.screens.LoadGameScreen;
import com.mygdx.game.screens.MainGameScreen;
import com.mygdx.game.screens.MainMenuScreen;
import com.mygdx.game.screens.NewGameScreen;

public class FinalKanjiQuest extends Game {

	private static MainGameScreen mainGameScreen;
	private static MainMenuScreen mainMenuScreen;
	private static LoadGameScreen loadGameScreen;
	private static NewGameScreen newGameScreen;

	public static enum ScreenType{
		MainMenu,
		MainGame,
		LoadGame,
		NewGame
	}

	public Screen getScreenType(ScreenType screenType){
		switch(screenType){
			case MainMenu:
				return mainMenuScreen;
			case MainGame:
				return mainGameScreen;
			case LoadGame:
				return loadGameScreen;
			case NewGame:
				return newGameScreen;
			default:
				return mainMenuScreen;
		}

	}

	@Override
	public void create(){
		mainGameScreen = new MainGameScreen(this);
		mainMenuScreen = new MainMenuScreen(this);
		loadGameScreen = new LoadGameScreen(this);
		newGameScreen = new NewGameScreen(this);
		setScreen(mainMenuScreen);
	}

	@Override
	public void dispose(){
		mainGameScreen.dispose();
		mainMenuScreen.dispose();
		loadGameScreen.dispose();
		newGameScreen.dispose();
	}

}
