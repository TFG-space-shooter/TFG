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
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.solarsystem.game.actor.FondoActor;
import com.solarsystem.game.actor.PuntuacionActor;
import com.solarsystem.game.util.Format;
import com.solarsystem.game.util.Preferencias;

public class StartScreen extends AbstractScreen{
	
	private final class InputTouchToStartListener extends InputListener {
		@Override
		public boolean touchDown(InputEvent event, float x, float y,
				int pointer, int button) {
			game.setScreen(game.gameplayScreen);
			musicaPrincipal.stop();

			game.lanzamiento.play();
			return true;
		}
	}
	
	private Stage stage;
	private FondoActor fondo;
	private Image solarsystem;
	private Image start;

    private Music musicaPrincipal;	
	private PuntuacionActor mayorPuntuacion;
	

    private BitmapFont fontBotoes;
    private Label lbPuntuacion;


	public StartScreen(Solarsystem game) {
		super(game);
		initSons();
		stage = new Stage(new ScreenViewport());
		solarsystem = new Image(new Texture("solarsystem2.png"));
		start = new Image(new Texture("retry.png"));
		fondo = new FondoActor();
		stage.addActor(fondo);

		mayorPuntuacion = new PuntuacionActor(new BitmapFont());	
		solarsystem.setPosition(stage.getWidth()/2 - solarsystem.getWidth()/2,
				stage.getHeight()/2 + 200);
		start.setPosition(stage.getWidth()/2 - start.getWidth()/2,
				stage.getHeight()/2 - 200);
		
		start.addListener(new InputTouchToStartListener());
		
		stage.addActor(solarsystem);
		stage.addActor(start);
	}
	   
    private void initLabels() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle = new Label.LabelStyle();
        labelStyle.font = fontBotoes;
        String prueba = Format.format(Preferencias.getMayorPuntuacion());
        
        lbPuntuacion = new Label("High Score: " + prueba, labelStyle);
        lbPuntuacion.setPosition(stage.getWidth()/2-lbPuntuacion.getWidth()/2, 150);
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
	//	Preferencias.setMayorPuntuacion(0);
		mayorPuntuacion.setPuntuacion(Preferencias.getMayorPuntuacion());		
        initFonts();
        initLabels();

	}
	
	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        atualizarBotones();
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

    
//    private void atualizarBotones() {
//    	 
//
//        lbPuntuacion.setPosition(stage.getWidth()/3 - mayorPuntuacion.getWidth()/2,
//				stage.getHeight()/2 - 350);
//
//    }

}
