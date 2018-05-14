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
			
			game.lanzamiento.play();
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
	
	private Stage stage;
	private FondoActor fondo;
	private Image setting;
	private Image retry;
	private Image on;
	private Image off;
	private Boolean musica;
	

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



	
	
		
		retry.addListener(new InputTouchToStartListener());
		


		
		stage.addActor(retry);

		stage.addActor(setting);
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
		musica =Preferencias.getMusic();
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		
		stage.act();
		stage.draw();



		if (!musica){

			off = new Image(new Texture("off.png"));
			off.setPosition(stage.getWidth() - off.getWidth() - 100,
					stage.getHeight()/2-off.getHeight());
			
			off.addListener(new InputMusicListener());
			
			stage.addActor(off);
			

        	game.musicaPrincipal.setVolume((float) 0);
		    
			if (stage.getActors().contains(on, false)){
				stage.getActors().removeValue(on, false);
			}
			
		}else{

			on = new Image(new Texture("on.png"));
			on.setPosition(stage.getWidth() - on.getWidth() - 100,
					stage.getHeight()/2-on.getHeight());
		
			on.addListener(new InputMusicListener());
			
			stage.addActor(on);


        	game.musicaPrincipal.setVolume((float) 1);
			if (stage.getActors().contains(off, false)){
				stage.getActors().removeValue(off, false);
				
			}
			
		}	

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
