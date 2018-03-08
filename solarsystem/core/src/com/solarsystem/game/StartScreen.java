package com.solarsystem.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.solarsystem.game.actor.FondoActor;

public class StartScreen extends AbstractScreen{
	
	private final class InputTouchToStartListener extends InputListener {
		@Override
		public boolean touchDown(InputEvent event, float x, float y,
				int pointer, int button) {
			game.setScreen(game.gameplayScreen);
			musicaPrincipal.stop();
			return true;
		}
	}
	
	private Stage stage;
	private FondoActor fondo;
	private Image solarsystem;
	private Image start;

    private Music musicaPrincipal;	


	public StartScreen(Solarsystem game) {
		super(game);
		initSons();
		stage = new Stage(new ScreenViewport());
		solarsystem = new Image(new Texture("solarsystem2.png"));
		start = new Image(new Texture("retry.png"));
		fondo = new FondoActor();
		stage.addActor(fondo);
	
		solarsystem.setPosition(stage.getWidth()/2 - solarsystem.getWidth()/2,
				stage.getHeight()/2 + 200);
		start.setPosition(stage.getWidth()/2 - start.getWidth()/2,
				stage.getHeight()/2 - 200);
		
		start.addListener(new InputTouchToStartListener());
		
		stage.addActor(solarsystem);
		stage.addActor(start);
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
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
		musicaPrincipal.dispose();
	}
	
	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}
	
    private void initSons() {
        musicaPrincipal = Gdx.audio.newMusic(Gdx.files.internal("sounds/bonus-background.mp3"));
        musicaPrincipal.setLooping(true);
        musicaPrincipal.play();
    }

}
