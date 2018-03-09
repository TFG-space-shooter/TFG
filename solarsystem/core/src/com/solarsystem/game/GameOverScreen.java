package com.solarsystem.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.solarsystem.game.actor.FondoActor;

public class GameOverScreen extends AbstractScreen{
	
	private final class InputTouchToStartListener extends InputListener {
		@Override
		public boolean touchDown(InputEvent event, float x, float y,
				int pointer, int button) {
			game.setScreen(game.gameplayScreen);
			musicaGameOver.stop();

			game.lanzamiento.play();
			return true;
		}
	}
	
	private Stage stage;
	private FondoActor fondo;
	private Image gameover;
	private Image retry;
	
    private Music musicaGameOver;	

	public GameOverScreen(final Solarsystem game) {
		super(game);
		stage = new Stage(new ScreenViewport());
		gameover = new Image(new Texture("gameover.png"));
		retry = new Image(new Texture("retry.png"));
		fondo = new FondoActor();
		stage.addActor(fondo);
		
		gameover.setPosition(stage.getWidth()/2 - gameover.getWidth()/2,
				stage.getHeight()/2 + 100);
		retry.setPosition(stage.getWidth()/2 - retry.getWidth()/2,
				stage.getHeight()/2 - 200);
		
		retry.addListener(new InputTouchToStartListener());
		
		stage.addActor(gameover);
		stage.addActor(retry);
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);

		initSons();
	}
	
	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act();
		stage.draw();
	}
	
	@Override
	public void dispose() {
		stage.dispose();
	}
	
	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}
	
	private void initSons() {
	        musicaGameOver = Gdx.audio.newMusic(Gdx.files.internal("sounds/gameover.mp3"));
	        musicaGameOver.setLooping(false);
	        musicaGameOver.play();
	}
}
