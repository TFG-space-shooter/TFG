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
import com.solarsystem.game.util.Format;
import com.solarsystem.game.util.Preferencias;

public class GameSelectScreen extends AbstractScreen{

	private final class InputTouchToStartListener extends InputListener {
		@Override
		public boolean touchDown(InputEvent event, float x, float y,
				int pointer, int button) {
			game.setScreen(game.startScreen);

			if(Preferencias.getSoundEffects()){
				game.lanzamiento.play();
			}
			return true;
		}
	}

	private final class InputMusicListener extends InputListener {
		@Override
		public boolean touchDown(InputEvent event, float x, float y,
				int pointer, int button) {
			
			if (musica){
				Preferencias.setMusic(false);
				musica = Preferencias.getMusic();
				
				
			}else{
				Preferencias.setMusic(true);
				musica = Preferencias.getMusic();
			}
			
			

			return true;
		}
	}

	private final class InputEffectListener extends InputListener {
		@Override
		public boolean touchDown(InputEvent event, float x, float y,
				int pointer, int button) {
			
			if (efectos){
				Preferencias.setSoundEffects(false);
				efectos = Preferencias.getSoundEffects();
				
				
			}else{
				Preferencias.setSoundEffects(true);
				efectos = Preferencias.getSoundEffects();
			}
			
			

			return true;
		}
	}
	
	private final class InputEasyListener extends InputListener {
		@Override
		public boolean touchDown(InputEvent event, float x, float y,
				int pointer, int button) {
			
			//TODO Hacer bien
			easy = !easy;

			return true;
		}

	}
	
	private Stage stage;
	private FondoActor fondo;
	private Image setting;
	private Image retry;
	private Image onMusic;
	private Image offMusic;
	private Image onEffect;
	private Image offEffect;
	private Boolean musica;
	private Boolean efectos;
	
	private boolean easy;
	private boolean medium;
	private boolean hard;
	private Image easysi;
	private Image easyno;
	private Image mediumsi;
	private Image mediumno;
	private Image hardsi;
	private Image hardno;
	
	private Label musicText;
	private Label effectsText;
	private Label levelText;

    private BitmapFont fontBotoes;
    private Label lbPuntuacion;

    
	public GameSelectScreen(final Solarsystem game) {
		super(game);
		stage = new Stage(new ScreenViewport());
		setting = new Image(new Texture("setting2.png"));
		retry = new Image(new Texture("save.png"));
		fondo = new FondoActor();
		stage.addActor(fondo);


		
		retry.setPosition(stage.getWidth()/2 - retry.getWidth()/2,
				50);
		setting.setPosition(stage.getWidth()/2 - retry.getWidth()/2,
				stage.getHeight()-setting.getHeight()-30);


		// TODO Quitar esto cuando se haga
		easy = false;
		medium = false;
		hard = false;
	
	
		
		retry.addListener(new InputTouchToStartListener());
		


		
		stage.addActor(retry);

		stage.addActor(setting);
	}
	
    private void initLabels() {
    	if(lbPuntuacion != null){
    		stage.getActors().removeValue(lbPuntuacion, false);
    	}
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = fontBotoes;
        lbPuntuacion = new Label("High Score: " + Format.format(Preferencias.getMayorPuntuacion()), labelStyle);
        lbPuntuacion.setPosition(stage.getWidth()/2-lbPuntuacion.getWidth()/2, 200);

        musicText = new Label("Music", labelStyle);
        musicText.setPosition(stage.getWidth()-240, stage.getHeight()-435);
        stage.addActor(musicText);
        
        effectsText = new Label("Sound effects", labelStyle);
        effectsText.setPosition(stage.getWidth()-270, stage.getHeight()-335);
        stage.addActor(effectsText);
        
        levelText = new Label("Game difficulty", labelStyle);
        levelText.setPosition(150, stage.getHeight()-335);
        stage.addActor(levelText);
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

		initFonts();
		initLabels();

		//      atualizarBotones();

		
	//	initSons();
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

		musica =Preferencias.getMusic();
		efectos =Preferencias.getSoundEffects();

		if (!musica){

			offMusic = new Image(new Texture("off.png"));
			offMusic.setPosition(stage.getWidth() - offMusic.getWidth() - 100,
					stage.getHeight()/2-offMusic.getHeight());
			
			offMusic.addListener(new InputMusicListener());
			
			stage.addActor(offMusic);
			

        	game.musicaPrincipal.setVolume((float) 0);
		    
			if (stage.getActors().contains(onMusic, false)){
				stage.getActors().removeValue(onMusic, false);
			}
			
		}else{

			onMusic = new Image(new Texture("on.png"));
			onMusic.setPosition(stage.getWidth() - onMusic.getWidth() - 100,
					stage.getHeight()/2-onMusic.getHeight());
		
			onMusic.addListener(new InputMusicListener());
			
			stage.addActor(onMusic);


        	game.musicaPrincipal.setVolume((float) 1);
			if (stage.getActors().contains(offMusic, false)){
				stage.getActors().removeValue(offMusic, false);
				
			}
			
		}	
		
		if (!efectos){

			offEffect = new Image(new Texture("off.png"));
			offEffect.setPosition(stage.getWidth() - offEffect.getWidth() - 100,
					stage.getHeight()/2-offEffect.getHeight()+100);
			
			offEffect.addListener(new InputEffectListener());
			
			stage.addActor(offEffect);
			
		    
			if (stage.getActors().contains(onEffect, false)){
				stage.getActors().removeValue(onEffect, false);
			}
			
		}else{

			onEffect = new Image(new Texture("on.png"));
			onEffect.setPosition(stage.getWidth() - onEffect.getWidth() - 100,
					stage.getHeight()/2-onEffect.getHeight()+100);
		
			onEffect.addListener(new InputEffectListener());
			
			stage.addActor(onEffect);

			if (stage.getActors().contains(offEffect, false)){
				stage.getActors().removeValue(offEffect, false);
				
			}
			
		}	
		
		
		if (!easy){

			easyno = new Image(new Texture("easyno.png"));
			easyno.setPosition(100, stage.getHeight()/2+100-easyno.getHeight());
			
			easyno.addListener(new InputEasyListener());
			
			stage.addActor(easyno);
			
		    
			if (stage.getActors().contains(easysi, false)){
				stage.getActors().removeValue(easysi, false);
			}
			
		}else{

			easysi = new Image(new Texture("easysi.png"));
			easysi.setPosition(100, stage.getHeight()/2+100-easysi.getHeight());
		
			easysi.addListener(new InputEasyListener());
			
			stage.addActor(easysi);

			if (stage.getActors().contains(easyno, false)){
				stage.getActors().removeValue(easyno, false);
				
			}
			
		}	
		
		
		
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
	

	

}
