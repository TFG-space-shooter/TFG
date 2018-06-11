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

			if(Preferencias.getEasy()){
				game.setScreen(game.gameplayScreenEasy);
			}
			if(Preferencias.getMedium()){
				game.setScreen(game.gameplayScreenMedium);
			}
			if(Preferencias.getHard()){
				game.setScreen(game.gameplayScreenHard);
			}

			musicaGameOver.stop();

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
			game.setScreen(game.startScreen);

			if(Preferencias.getSoundEffects()){
				game.lanzamiento.play();
			}
			if(Preferencias.getMusic()){
				game.musicaPrincipal.play();
				game.musicaPrincipal.setVolume(1);
			}else{
				game.musicaPrincipal.play();
				game.musicaPrincipal.setVolume(0);	
			}
			return true;
		}
	}
	
	private Stage stage;
	private FondoActor fondo;
	private Image gameover;
	private Image retry;
	private PuntuacionActor mayorPuntuacion;
	private Image select;
	
    private Music musicaGameOver;	

    private BitmapFont fontBotoes;
    private Label lbPuntuacion;

    
	public GameOverScreen(final Solarsystem game) {
		super(game);
		stage = new Stage(new ScreenViewport());
		fondo = new FondoActor();
		stage.addActor(fondo);
		mayorPuntuacion = new PuntuacionActor(new BitmapFont());
		

		

		stage.addActor(mayorPuntuacion);
	}
    private void initLabels() {
    	
		if(Preferencias.getEspanol()){
	    		if (stage.getActors().contains(select, false)){
	    			stage.getActors().removeValue(select, false); 	
	    		}
	    		if (stage.getActors().contains(retry, false)){
	    			stage.getActors().removeValue(retry, false); 	
	    		}
	    		if (stage.getActors().contains(gameover, false)){
	    			stage.getActors().removeValue(gameover, false); 	
	    		}
	    		
	    		select = new Image(new Texture("main_es.png"));
	    		retry = new Image(new Texture("retry_es.png"));
	    		gameover = new Image(new Texture("gameover_es.png"));
		}else{
    		if (stage.getActors().contains(select, false)){
    			stage.getActors().removeValue(select, false); 	
    		}
    		if (stage.getActors().contains(retry, false)){
    			stage.getActors().removeValue(retry, false); 	
    		}
    		if (stage.getActors().contains(gameover, false)){
    			stage.getActors().removeValue(gameover, false); 	
    		}   		
    		select = new Image(new Texture("main.png"));
    		retry = new Image(new Texture("retry.png"));
    		gameover = new Image(new Texture("gameover.png"));
			}
    	
		select.setPosition(stage.getWidth()/2 - select.getWidth()/2,
				stage.getHeight()/2-100);


		retry.setPosition(stage.getWidth()/2 - retry.getWidth()/2,
				stage.getHeight()/2 - 200);
		gameover.setPosition(stage.getWidth()/2 - gameover.getWidth()/2,
				stage.getHeight()/2 + 100);
	

		select.addListener(new InputTouchToSelectListener());
		retry.addListener(new InputTouchToStartListener());

		stage.addActor(select);
		stage.addActor(retry);
		stage.addActor(gameover);    	
    	
    	
    	if(lbPuntuacion != null){
    		stage.getActors().removeValue(lbPuntuacion, false);
    	}
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle = new Label.LabelStyle();
        labelStyle.font = fontBotoes;
        
        if(Preferencias.getEspanol()){
    		if (stage.getActors().contains(lbPuntuacion, false)){
    			stage.getActors().removeValue(lbPuntuacion, false); 			
    		}
        lbPuntuacion = new Label("Máxima Puntuación: " +  Format.format(Preferencias.getMayorPuntuacion()), labelStyle);

        }else{
    		if (stage.getActors().contains(lbPuntuacion, false)){
    			stage.getActors().removeValue(lbPuntuacion, false); 			
    		}
            lbPuntuacion = new Label("High Score: " +  Format.format(Preferencias.getMayorPuntuacion()), labelStyle);
        	
        }
        
      lbPuntuacion.setPosition(stage.getWidth()/2-lbPuntuacion.getWidth()/2, 200);
        stage.addActor(lbPuntuacion);
    }
    private void initFonts() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/roboto.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();
        params.size = MathUtils.roundPositive(25 * Gdx.graphics.getDensity());
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
	        if (Preferencias.getMusic()){
	        	musicaGameOver.setVolume((float) 1);
	            }else{
	            	musicaGameOver.setVolume((float) 0);
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
