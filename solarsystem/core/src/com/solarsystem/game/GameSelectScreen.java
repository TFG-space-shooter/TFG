package com.solarsystem.game;

import com.badlogic.gdx.Gdx;
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
			
				Preferencias.setEasy(true);
				easy = Preferencias.getEasy();
				Preferencias.setMedium(false);
				medium = Preferencias.getMedium();
				Preferencias.setHard(false);
				hard = Preferencias.getHard();
							
			return true;
		}

	}	
	
	private final class InputMediumListener extends InputListener {
		@Override
		public boolean touchDown(InputEvent event, float x, float y,
				int pointer, int button) {
			
				Preferencias.setEasy(false);
				easy = Preferencias.getEasy();
				Preferencias.setMedium(true);
				medium = Preferencias.getMedium();
				Preferencias.setHard(false);
				hard = Preferencias.getHard();
				
			
			return true;
		}

	}
	
	
	private final class InputHardListener extends InputListener {
		@Override
		public boolean touchDown(InputEvent event, float x, float y,
				int pointer, int button) {
			
				Preferencias.setEasy(false);
				easy = Preferencias.getEasy();
				Preferencias.setMedium(false);
				medium = Preferencias.getMedium();
				Preferencias.setHard(true);
				hard = Preferencias.getHard();
				
			
			return true;
		}
		
	}

	private final class InputIdiomaListener extends InputListener {
		@Override
		public boolean touchDown(InputEvent event, float x, float y,
				int pointer, int button) {

			if(Preferencias.getEspañol()){
				Preferencias.setEspañol(false);

				game.setScreen(game.gameselectScreen);
			}else{
				Preferencias.setEspañol(true);		

				game.setScreen(game.gameselectScreen);
			}
							
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
	private Boolean musicaOnPintado;
	private Boolean musicaOffPintado;
	private Boolean efectoOnPintado;
	private Boolean efectoOffPintado;

	private Boolean easyOffPintado;
	private Boolean easyOnPintado;
	private Boolean mediumOffPintado;
	private Boolean mediumOnPintado;
	private Boolean hardOffPintado;
	private Boolean hardOnPintado;
	
	private Image español;
	private Image ingles;
	
	
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
	private Label languageText;

    private BitmapFont fontBotoes;
    private Label lbPuntuacion;

    
	public GameSelectScreen(final Solarsystem game) {
		super(game);
		stage = new Stage(new ScreenViewport());
		setting = new Image(new Texture("setting2.png"));
		retry = new Image(new Texture("save.png"));
		fondo = new FondoActor();
		stage.addActor(fondo);

		musicaOffPintado = false;
		musicaOnPintado = false;
		efectoOffPintado = false;
		efectoOnPintado = false;
		easyOffPintado = false;;
		easyOnPintado = false;;
		mediumOffPintado = false;;
		mediumOnPintado = false;;
		hardOffPintado = false;;
		hardOnPintado = false;;


		
		retry.setPosition(stage.getWidth()/2 - retry.getWidth()/2,
				50);
		setting.setPosition(stage.getWidth()/2 - retry.getWidth()/2,
				stage.getHeight()-setting.getHeight()-30);


	
	
		
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
      
        if(Preferencias.getEspañol()){
    		if (stage.getActors().contains(musicText, false)){
    			stage.getActors().removeValue(musicText, false); 	
    		}
        	musicText = new Label("Música", labelStyle);
        }else{

    		if (stage.getActors().contains(musicText, false)){
    			stage.getActors().removeValue(musicText, false); 	
    		}
            musicText = new Label("Music", labelStyle);
        }
        musicText.setPosition(stage.getWidth()/2-musicText.getWidth()/2, stage.getHeight()-150);
        stage.addActor(musicText);
        

        if(Preferencias.getEspañol()){

    		if (stage.getActors().contains(effectsText, false)){
    			stage.getActors().removeValue(effectsText, false); 	
    		}
        	effectsText = new Label("Efectos de sonido", labelStyle);
        }else{

    		if (stage.getActors().contains(effectsText, false)){
    			stage.getActors().removeValue(effectsText, false); 	
    		}
        	effectsText = new Label("Sound effects", labelStyle);
        }
        effectsText.setPosition(stage.getWidth()/2-effectsText.getWidth()/2, stage.getHeight()-300);
        stage.addActor(effectsText);
        

        if(Preferencias.getEspañol()){

    		if (stage.getActors().contains(levelText, false)){
    			stage.getActors().removeValue(levelText, false); 	
    		}
        	levelText = new Label("Dificultad del juego", labelStyle);
        }else{

    		if (stage.getActors().contains(levelText, false)){
    			stage.getActors().removeValue(levelText, false); 	
    		}
        	levelText = new Label("Game difficulty", labelStyle);        	
        }
        levelText.setPosition(stage.getWidth()/2-levelText.getWidth()/2, stage.getHeight()-600);
        stage.addActor(levelText);
        
        if(Preferencias.getEspañol()){

    		if (stage.getActors().contains(languageText, false)){
    			stage.getActors().removeValue(languageText, false); 
    		}
        	languageText = new Label("Idioma", labelStyle);
        }else{

    		if (stage.getActors().contains(languageText, false)){
    			stage.getActors().removeValue(languageText, false); 	
    		}
        	languageText = new Label("Language", labelStyle);        	
        }
        languageText.setPosition(stage.getWidth()/2-languageText.getWidth()/2, stage.getHeight()-450);
        stage.addActor(languageText);
        
    }
    private void initFonts() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/roboto.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();
        params.size = MathUtils.roundPositive(18 * Gdx.graphics.getDensity());
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
		if(!easy & !medium & !hard){
			Preferencias.setEasy(true);
			easy = Preferencias.getEasy();
		}else{
			if(easy){
				Preferencias.setMedium(false);
				medium = Preferencias.getMedium();
				Preferencias.setHard(false);
				hard = Preferencias.getHard();
			}
			if(medium){
				Preferencias.setEasy(false);
				easy = Preferencias.getEasy();
				Preferencias.setHard(false);
				hard = Preferencias.getHard();
			}
			if(hard){
				Preferencias.setEasy(false);
				easy = Preferencias.getEasy();
				Preferencias.setMedium(false);
				medium = Preferencias.getMedium();
			}
		}
	

		if (!musica & !musicaOffPintado){

			offMusic = new Image(new Texture("off.png"));
			offMusic.setPosition(stage.getWidth()/2 - offMusic.getWidth()/2,
					stage.getHeight()-200);
			offMusic.addListener(new InputMusicListener());
			
			stage.addActor(offMusic);
			

        	game.musicaPrincipal.setVolume((float) 0);
		    
			if (stage.getActors().contains(onMusic, false)){
				stage.getActors().removeValue(onMusic, false);
			}
			musicaOffPintado = true;
			musicaOnPintado = false;
			
		}
		if(musica & !musicaOnPintado){

			onMusic = new Image(new Texture("on.png"));
			onMusic.setPosition(stage.getWidth()/2 - onMusic.getWidth()/2,
					stage.getHeight()-200);
		
			onMusic.addListener(new InputMusicListener());
			
			stage.addActor(onMusic);


        	game.musicaPrincipal.setVolume((float) 1);
			if (stage.getActors().contains(offMusic, false)){
				stage.getActors().removeValue(offMusic, false);
				
			}
			musicaOffPintado = false;
			musicaOnPintado = true;
			
		}	
		
		if (!efectos & !efectoOffPintado){

			offEffect = new Image(new Texture("off.png"));
			offEffect.setPosition(stage.getWidth()/2 - offEffect.getWidth()/2,
					stage.getHeight()-350);
			
			offEffect.addListener(new InputEffectListener());
			
			stage.addActor(offEffect);
			
		    
			if (stage.getActors().contains(onEffect, false)){
				stage.getActors().removeValue(onEffect, false);
			}
			efectoOffPintado = true;
			efectoOnPintado = false;
		}
		if (efectos & !efectoOnPintado){

			onEffect = new Image(new Texture("on.png"));
			onEffect.setPosition(stage.getWidth()/2 - onEffect.getWidth()/2,
					stage.getHeight()-350);
		
			onEffect.addListener(new InputEffectListener());
			
			stage.addActor(onEffect);

			if (stage.getActors().contains(offEffect, false)){
				stage.getActors().removeValue(offEffect, false);
				
			}

			efectoOffPintado = false;
			efectoOnPintado = true;
			
		}	
		
		
		if (!easy & !easyOffPintado){

			easyno = new Image(new Texture("easyno.png"));
			easyno.setPosition(stage.getWidth()/2 - easyno.getWidth()/2,
					stage.getHeight()-650);
			
			easyno.addListener(new InputEasyListener());
			
			stage.addActor(easyno);
			
		    
			if (stage.getActors().contains(easysi, false)){
				stage.getActors().removeValue(easysi, false);
			}
			easyOffPintado = true;
			easyOnPintado = false;
		}
		if (easy & !easyOnPintado){

			easysi = new Image(new Texture("easysi.png"));
			easysi.setPosition(stage.getWidth()/2 - easysi.getWidth()/2,
					stage.getHeight()-650);
		
			
			stage.addActor(easysi);

			if (stage.getActors().contains(easyno, false)){
				stage.getActors().removeValue(easyno, false);
							}

			easyOffPintado = false;
			easyOnPintado = true;
		}	
		
		if (!medium & !mediumOffPintado){

			mediumno = new Image(new Texture("mediumno.png"));
			mediumno.setPosition(stage.getWidth()/2 - mediumno.getWidth()/2,
					stage.getHeight()-700);
			
			mediumno.addListener(new InputMediumListener());
			
			stage.addActor(mediumno);
			
		    
			if (stage.getActors().contains(mediumsi, false)){
				stage.getActors().removeValue(mediumsi, false);
			}
			mediumOffPintado = true;
			mediumOnPintado = false;
		}
		if (medium & !mediumOnPintado){

			mediumsi = new Image(new Texture("mediumsi.png"));
			mediumsi.setPosition(stage.getWidth()/2 - mediumsi.getWidth()/2,
					stage.getHeight()-700);
		
			
			stage.addActor(mediumsi);

			if (stage.getActors().contains(mediumno, false)){
				stage.getActors().removeValue(mediumno, false);
				
			}
			mediumOffPintado = false;
			mediumOnPintado = true;
		}		

		if (!hard & !hardOffPintado){

			hardno = new Image(new Texture("hardno.png"));
			hardno.setPosition(stage.getWidth()/2 - hardno.getWidth()/2,
					stage.getHeight()-750);
			
			hardno.addListener(new InputHardListener());
			
			stage.addActor(hardno);
			
		    
			if (stage.getActors().contains(hardsi, false)){
				stage.getActors().removeValue(hardsi, false);
			}
			hardOffPintado = true;
			hardOnPintado = false;
		}
		if (hard & !hardOnPintado){

			hardsi = new Image(new Texture("hardsi.png"));
			hardsi.setPosition(stage.getWidth()/2 - hardsi.getWidth()/2,
					stage.getHeight()-750);
		
			
			stage.addActor(hardsi);

			if (stage.getActors().contains(hardno, false)){
				stage.getActors().removeValue(hardno, false);
				
			}

			hardOffPintado = false;
			hardOnPintado = true;
		}		
		
		if (Preferencias.getEspañol()){

			español = new Image(new Texture("español.png"));
			
			español.setPosition(stage.getWidth()/2 - español.getWidth()/2,
					stage.getHeight()-500);		
			español.addListener(new InputIdiomaListener());
			
			stage.addActor(español);
		
		}else{

			ingles = new Image(new Texture("ingles.png"));
			
			ingles.setPosition(stage.getWidth()/2 - ingles.getWidth()/2,
					stage.getHeight()-500);		
			ingles.addListener(new InputIdiomaListener());
			
			stage.addActor(ingles);
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
