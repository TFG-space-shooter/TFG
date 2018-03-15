package com.solarsystem.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.solarsystem.game.actor.FondoActor;
import com.solarsystem.game.actor.PuntuacionActor;
import com.solarsystem.game.util.Format;
import com.solarsystem.game.util.Preferencias;

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
	private PuntuacionActor mayorPuntuacion;
	
    private Music musicaGameOver;	

    private BitmapFont fontBotoes;
    private Label lbPuntuacion;

    
	public GameOverScreen(final Solarsystem game) {
		super(game);
		stage = new Stage(new ScreenViewport());
		gameover = new Image(new Texture("gameover.png"));
		retry = new Image(new Texture("retry.png"));
		fondo = new FondoActor();
		stage.addActor(fondo);
		mayorPuntuacion = new PuntuacionActor(new BitmapFont());
		

		
		gameover.setPosition(stage.getWidth()/2 - gameover.getWidth()/2,
				stage.getHeight()/2 + 100);
		retry.setPosition(stage.getWidth()/2 - retry.getWidth()/2,
				stage.getHeight()/2 - 150);
	
		retry.addListener(new InputTouchToStartListener());
		
		stage.addActor(gameover);
		stage.addActor(retry);
		stage.addActor(mayorPuntuacion);
	}
    private void initLabels() {
    	if(lbPuntuacion != null){
    		stage.getActors().removeValue(lbPuntuacion, false);
    	}
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle = new Label.LabelStyle();
        labelStyle.font = fontBotoes;
        lbPuntuacion = new Label("High Score: " + Format.format(Preferencias.getMayorPuntuacion()), labelStyle);
        lbPuntuacion.setPosition(stage.getWidth()/2-lbPuntuacion.getWidth()/2, 200);
        stage.addActor(lbPuntuacion);
    }
    private void initFonts() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/roboto.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();
        params.size = MathUtils.roundPositive(32 * Gdx.graphics.getDensity());
        params.color = Color.WHITE;
        fontBotoes = generator.generateFont(params);

        generator.dispose();
    }
  
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
		mayorPuntuacion.setPuntuacion(Preferencias.getMayorPuntuacion());


        initFonts();
        initLabels();

  //      atualizarBotones();
  
		
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
	

//    private void atualizarBotones() {
// 
//
//        lbPuntuacion.setPosition(stage.getWidth()/3 - mayorPuntuacion.getWidth()/2,
//				stage.getHeight()/2 - 350);
//
//    }
}
