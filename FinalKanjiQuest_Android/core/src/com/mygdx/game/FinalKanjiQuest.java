package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mygdx.game.screens.GameOverScreen;
import com.mygdx.game.screens.LoadGameScreen;
import com.mygdx.game.screens.MainGameScreen;
import com.mygdx.game.screens.MainMenuScreen;
import com.mygdx.game.screens.NewGameScreen;

public class FinalKanjiQuest extends Game {

	private static MainGameScreen mainGameScreen;
	private static MainMenuScreen mainMenuScreen;
	private static LoadGameScreen loadGameScreen;
	private static NewGameScreen newGameScreen;
	private static GameOverScreen gameOverScreen;

	public static enum ScreenType{
		MainMenu,
		MainGame,
		LoadGame,
		NewGame,
		GameOver
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
			case GameOver:
				return gameOverScreen;
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
		gameOverScreen = new GameOverScreen(this);
		setScreen(mainMenuScreen);
	}

	@Override
	public void dispose(){
		mainGameScreen.dispose();
		mainMenuScreen.dispose();
		loadGameScreen.dispose();
		newGameScreen.dispose();
		gameOverScreen.dispose();
	}

}
