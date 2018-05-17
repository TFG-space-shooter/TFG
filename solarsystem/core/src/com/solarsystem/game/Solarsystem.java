package com.solarsystem.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.solarsystem.game.scenebox2d.Box2DScreen;
import com.solarsystem.game.scenebox2d.GameScreen;

public class Solarsystem extends Game {
	
	private AssetManager manager;
	
	public AssetManager getManager(){
		return manager;
	}

	public GameplayScreenEasy gameplayScreenEasy;
	public GameplayScreenMedium gameplayScreenMedium;
	public GameplayScreenHard gameplayScreenHard;
	public GameOverScreen gameoverScreen;
	public GameSelectScreen gameselectScreen;
	public StartScreen startScreen;
	public Box2DScreen box2DScreen;
	public GameScreen gameScreen;
	public SpriteBatch batch;
	public Sound laserSound, hitSound, explosionSound, pillSound, ufoSound, explosion, lanzamiento;

    public Music musicaPrincipal;	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		manager = new AssetManager();
//		manager.load("floor.png", Texture.class);
//		manager.load("overfloor.png", Texture.class);
		manager.load("pinchos.png", Texture.class);
		manager.load("player.png", Texture.class);
		manager.finishLoading();
//		manager.load("blue.png", Texture.class);
//		manager.load("enemyblack1.png", Texture.class);
//		manager.load("laserblue07.png", Texture.class);
//		manager.load("playership3blue.png", Texture.class);
//		manager.load("flatDark23.png", Texture.class);
//		manager.load("flatDark24.png", Texture.class);
//		manager.load("flatDark47.png", Texture.class);
//		manager.load("shield2.png", Texture.class);
//		while(!manager.update()){
//			// Mostrar pantalla de carga
//		}
		laserSound = Gdx.audio.newSound(Gdx.files.internal("laser4.mp3"));
		hitSound = Gdx.audio.newSound(Gdx.files.internal("twoTone1.mp3"));
		explosion = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion.mp3"));
		lanzamiento = Gdx.audio.newSound(Gdx.files.internal("sounds/lanzamiento.mp3"));
		explosionSound = Gdx.audio.newSound(Gdx.files.internal("phaserUp4.mp3"));
		pillSound = Gdx.audio.newSound(Gdx.files.internal("phaseJump3.mp3"));
		ufoSound = Gdx.audio.newSound(Gdx.files.internal("pepSound3.mp3"));
		

        musicaPrincipal = Gdx.audio.newMusic(Gdx.files.internal("sounds/xeon6.ogg"));

		gameplayScreenEasy = new GameplayScreenEasy(this);
		gameplayScreenMedium = new GameplayScreenMedium(this);
		gameplayScreenHard = new GameplayScreenHard(this);
		gameoverScreen = new GameOverScreen(this);
		gameselectScreen = new GameSelectScreen(this);
		startScreen = new StartScreen(this);
		box2DScreen = new Box2DScreen(this);
		gameScreen = new GameScreen(this);
		setScreen(startScreen);
	}
	
	@Override
	public void dispose () {
		laserSound.dispose();
		hitSound.dispose();
		explosionSound.dispose();
		pillSound.dispose();
		ufoSound.dispose();
	}
}
