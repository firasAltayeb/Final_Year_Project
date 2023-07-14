package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.FinalKanjiQuest;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "FinalKanjiQuest";
		// set to false so that we use the much more stable and  mature implementation of OpenGL ES
		config.useGL30 = false;
		config.width = 800;
		config.height = 600;

		Application app = new LwjglApplication(new FinalKanjiQuest(),config);

		Gdx.app = app;
		// logging level that displays  all messages
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		//Gdx.app.setLogLevel(Application.LOG_INFO);
		// Gdx.app.setLogLevel(Application.LOG_ERROR);
		// Gdx.app.setLogLevel(Application.LOG_NONE);

	}
}
