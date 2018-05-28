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
			if(!Preferencias.getEasy() & !Preferencias.getMedium() & !Preferencias.getHard()){
				Preferencias.setEasy(true);

				game.setScreen(game.gameplayScreenEasy);

			}else{
				if(Preferencias.getEasy()){
					game.setScreen(game.gameplayScreenEasy);
				}
				if(Preferencias.getMedium()){
					game.setScreen(game.gameplayScreenMedium);
				}
				if(Preferencias.getHard()){
					game.setScreen(game.gameplayScreenHard);
				}
			}
			game.musicaPrincipal.stop();

			if(Preferencias.getSoundEffects()){
				game.lanzamiento.play();
			}
			return true;
		}
	}

	private final class InputTouchToSelectListener extends InputListener {
		@Override
		public boolean touchDown(InputEvent event, float x, float y,
				int pointer, int button) {
			game.setScreen(game.gameselectScreen);

			if(Preferencias.getSoundEffects()){
				game.lanzamiento.play();
			}
			return true;
		}
	}

	
	private Stage stage;
	private FondoActor fondo;
	private Image solarsystem;
	private Image start;
	private Image select;

	private PuntuacionActor mayorPuntuacion;
	

    private BitmapFont fontBotoes;
    private Label lbPuntuacion;
   


	public StartScreen(Solarsystem game) {
		super(game);
		initSons();
		stage = new Stage(new ScreenViewport());
		solarsystem = new Image(new Texture("solarsystem2.png"));
		if(Preferencias.getEspañol()){
		start = new Image(new Texture("retry.png"));
		select = new Image(new Texture("setting.png"));
		}else{
		start = new Image(new Texture("retry.png"));
		select = new Image(new Texture("setting.png"));
		}
		fondo = new FondoActor();
		stage.addActor(fondo);

		mayorPuntuacion = new PuntuacionActor(new BitmapFont());	
		solarsystem.setPosition(stage.getWidth()/2 - solarsystem.getWidth()/2,
				stage.getHeight()/2 + 200);
		start.setPosition(stage.getWidth()/2 - start.getWidth()/2,
				stage.getHeight()/2 - 200);	
		
		select.setPosition(stage.getWidth()/2 - select.getWidth()/2,
						stage.getHeight()/2-100);

		start.addListener(new InputTouchToStartListener());
		select.addListener(new InputTouchToSelectListener());
		
		stage.addActor(solarsystem);
		stage.addActor(start);
		stage.addActor(select);
		

	}
	   
    private void initLabels() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle = new Label.LabelStyle();
        labelStyle.font = fontBotoes;
        String prueba = Format.format(Preferencias.getMayorPuntuacion());
        if(Preferencias.getEspañol()){
    		if (stage.getActors().contains(lbPuntuacion, false)){
    			stage.getActors().removeValue(lbPuntuacion, false); 			
    		}
        lbPuntuacion = new Label("Máxima Puntuación: " + prueba, labelStyle);

        }else{
    		if (stage.getActors().contains(lbPuntuacion, false)){
    			stage.getActors().removeValue(lbPuntuacion, false); 			
    		}
            lbPuntuacion = new Label("High Score: " + prueba, labelStyle);
        	
        }
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
		
        if (Preferencias.getMusic()){
        	game.musicaPrincipal.setVolume((float) 1);
        }else{
        	game.musicaPrincipal.setVolume((float) 0);
        }

	}
	
	@Override
	public void dispose() {
		stage.dispose();
		game.musicaPrincipal.dispose();
	}
	
	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}
	
    private void initSons() {
    	

        if (Preferencias.getMusic()){
        game.musicaPrincipal.setLooping(true);

        game.musicaPrincipal.play();
        	game.musicaPrincipal.setVolume((float) 1);
        }else{
        	game.musicaPrincipal.setVolume((float) 0);

            game.musicaPrincipal.setLooping(true);

            game.musicaPrincipal.play();
        }

    }

    
//    private void atualizarBotones() {
//    	 
//
//        lbPuntuacion.setPosition(stage.getWidth()/3 - mayorPuntuacion.getWidth()/2,
//				stage.getHeight()/2 - 350);
//
//    }

}
