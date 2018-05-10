package com.solarsystem.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.solarsystem.game.Solarsystem;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Space Shooter";
		config.width = 720;
		config.height = 960;
		new LwjglApplication(new Solarsystem(), config);
	}
}
