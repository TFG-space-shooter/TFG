package com.spaceshooter.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.spaceshooter.game.scenebox2d.Box2DScreen;
import com.spaceshooter.game.scenebox2d.GameScreen;

public class SpaceShooter extends Game {
	
	private AssetManager manager;
	
	public AssetManager getManager(){
		return manager;
	}
	
	public GameplayScreen gameplayScreen;
	public GameOverScreen gameoverScreen;
	public StartScreen startScreen;
	public Box2DScreen box2DScreen;
	public GameScreen gameScreen;
	public SpriteBatch batch;
	public Sound laserSound, hitSound, explosionSound, pillSound, ufoSound;
	
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
		explosionSound = Gdx.audio.newSound(Gdx.files.internal("phaserDown1.mp3"));
		pillSound = Gdx.audio.newSound(Gdx.files.internal("phaseJump3.mp3"));
		ufoSound = Gdx.audio.newSound(Gdx.files.internal("pepSound3.mp3"));
		gameplayScreen = new GameplayScreen(this);
		gameoverScreen = new GameOverScreen(this);
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
