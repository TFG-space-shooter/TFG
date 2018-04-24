package com.solarsystem.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.solarsystem.game.actor.BoomActor;
import com.solarsystem.game.actor.EnemigoActor;
import com.solarsystem.game.actor.EnergiaActor;
import com.solarsystem.game.actor.EnergiaTextoActor;
import com.solarsystem.game.actor.EscudoActor;
import com.solarsystem.game.actor.FondoActor;
import com.solarsystem.game.actor.LaserActor;
import com.solarsystem.game.actor.LaserEnemigoActor;
import com.solarsystem.game.actor.LaserUfoActor;
import com.solarsystem.game.actor.MeteoritoActor;
import com.solarsystem.game.actor.MunicionActor;
import com.solarsystem.game.actor.NaveActor;
import com.solarsystem.game.actor.PuntuacionActor;
import com.solarsystem.game.actor.PuntuacionTextoActor;
import com.solarsystem.game.actor.ShieldActor;
import com.solarsystem.game.actor.UfoActor;
import com.solarsystem.game.inputhandler.ControladorVirtual;
import com.solarsystem.game.util.Preferencias;

public class GameplayScreen extends AbstractScreen{


	private final class InputDesktopAndroidListener extends InputListener {
		@Override
		public boolean touchDown(InputEvent event, float x, float y,
				int pointer, int button) {
			controlador.obedeceRaton = true;
			controlador.objetivoX = (int) x;
			controlador.objetivoY = (int) y;
			return true;
		}
		
		@Override
		public void touchUp(InputEvent event, float x, float y, int pointer,
				int button) {
			controlador.obedeceRaton = false;
		}
		
	}
	

	
	public NaveActor getNave() {
		return nave;
	}

	public void setNave(NaveActor nave) {
		this.nave = nave;
	}

	
	private boolean paused;

    private Music musicaFundo;	
    
	private ControladorVirtual controlador;
	private Stage stage;
	public NaveActor nave;
	private float timerMusicaFondo;
	
	private float timer;
	private float timer2;
	private float timerYellow;
	private float timer3;
	private float timer4;
	private float timerIzq;
	private float timerDer;
	private float timerEnemigo;
	private float timerMeteor;
	private float timerUfo;
	private float timerLaserUfo;
	private float timerDisparar;
	private float timerStage1;
	private float timerStage2;
	private float timerStage3;
	private float timerStage4;
	private float timerStage5;
	private float timerStage6;
	private float timerStage7;
	private float timerStage8;
	private float timerFase4;
	private float timerFin;
	private float timerFin2;
	private float timerFin3;
	private float timerFin4;
	private float timerFin5;
	private float timerFin7;
	private float timerBlue;
	private float timerBlue2;
	private float timerBlue3;
	private float timerBlue4;
	private float timerEnemigoBlue;
	private float timerEnemigoYellow;
	private float timerEnemigoStage6;
	private float timerEnemigoStage62;
	private float timerEnemigoStage63;
	private float timerEnemigoStage64;
	private float timerEnemigoStage65;
	private float timerEnemigoStage7;
	private float timerFinStage6;
	private float timerEnemigoRed;
	private float timerDisparoEnemigoStage7;
	private float timerGameOver;
	private float timerGreen;
	private float timerRed;
	private float greenDead;
	
	private float timerClear6;
	
	private float redDead;
	private List<EnemigoActor> enemigos;
	private List<EnemigoActor> enemigosBlue;
	private List<EnemigoActor> enemigosGreen;
	private List<EnemigoActor> enemigosYellow;
	private List<EnemigoActor> enemigosRed;
	private List<EnemigoActor> enemigosStage6;
	private List<EnemigoActor> enemigosStage7;
	private List<LaserActor> lasers;
	private List<LaserEnemigoActor> laserEnemigos;
	private List<MeteoritoActor> meteoritos;
	private List<LaserUfoActor> laserUfos;
	private List<MunicionActor> municiones;
	private List<EscudoActor> escudos;
	private List<Boolean> booleans;
	private List<Boolean> booleans2;
	private PuntuacionTextoActor puntuacionTexto;
	private PuntuacionActor puntuacion;
	private EnergiaTextoActor energiaTexto;
	private EnergiaActor energia;
	private FondoActor fondo;
	private MeteoritoActor meteorito;
	private UfoActor ufo;
	private int k;
	private Texture textureEnemigo1;
	private Texture textureEnemigo2;
	private Texture textureEnemigo3;
	private Texture textureEnemigo4;
	private Texture textureEnemigo5;
	
	private Texture textureEnemigoBlue2;
	private Texture textureEnemigoBlue3;
	private Texture textureEnemigoBlue4;
	private Texture textureEnemigoBlue5;
	
	private Texture textureMeteorito1;
	private Texture textureMeteorito2;
	private Texture textureMeteorito3;
	private Texture textureMeteorito4;
	private Texture textureMeteorito5;
	private Texture municion1;
	private Texture municion2;
	private Texture municion3;
	private Texture municion4;
	private Texture municion5;
	private Texture municion6;
	private EnemigoActor enemigo1;
	private EnemigoActor enemigo2;
	private EnemigoActor enemigo3;
	private EnemigoActor enemigo4;
	private EnemigoActor enemigo5;
	private EnemigoActor enemigo6;
	private EnemigoActor enemigo7;
	private EnemigoActor enemigo8;
	private EnemigoActor enemigo9;
	private EnemigoActor enemigo10;
	private EnemigoActor enemigo11;
	private EnemigoActor enemigo12;
	private EnemigoActor enemigo13;
	private EnemigoActor enemigo14;
	private EnemigoActor enemigo15;
	private EnemigoActor enemigo16;
	private EnemigoActor enemigo17;
	private EnemigoActor enemigo18;
	private EnemigoActor enemigo19;
	private EnemigoActor enemigo20;
	private EnemigoActor enemigo21;
	private EnemigoActor enemigo22;
	private EnemigoActor enemigo23;
	private EnemigoActor enemigo24;
	private EnemigoActor enemigo25;
	
	private EnemigoActor enemigoBlue1;
	private EnemigoActor enemigoBlue2;
	private EnemigoActor enemigoBlue3;
	private EnemigoActor enemigoBlue4;
	private EnemigoActor enemigoBlue5;
	private EnemigoActor enemigoBlue6;
	private EnemigoActor enemigoBlue7;
	private EnemigoActor enemigoBlue8;
	private EnemigoActor enemigoBlue9;
	private EnemigoActor enemigoBlue10;
	private EnemigoActor enemigoBlue11;
	private EnemigoActor enemigoBlue12;
	private EnemigoActor enemigoBlue13;
	private EnemigoActor enemigoBlue14;
	private EnemigoActor enemigoBlue15;
	private EnemigoActor enemigoBlue16;
	private EnemigoActor enemigoBlue17;
	private EnemigoActor enemigoBlue18;
	private EnemigoActor enemigoBlue19;
	private EnemigoActor enemigoBlue20;
	
	
	
	private Image planeta1;
	
	private Image stage1;
	private Image stage2;
	private Image stage3;
	private Image stage4;
	private Image stage5;
	private Image stage6;
	private Image stage7;
	private Image stage8;
	private Image clear;
	private boolean disparo1;
	private boolean disparo2;
	private boolean disparo3;
	private boolean disparo4;
	private boolean disparo5;
	private boolean disparo6;
	private boolean drop;
	private ShieldActor shield;
	private boolean dropShield;
	
	private Image pause;
	private Image resume;
	private Image pauseText;
	
	private float contadorFinFase7;
	
	public GameplayScreen(Solarsystem game) {
		super(game);		

	}
	
	@Override
	public void show() {	    

		controlador = new ControladorVirtual();
		timer = 5;
		timerMusicaFondo =5;
		timer2 = 5.5f;
		timer3 = 6;
		timer4 = 6.5f;
		timerIzq = 7;
		timerDer = 9;
		timerMeteor = 15;
		timerUfo = 20;
		timerDisparar = 0.1f;
		timerEnemigo = 10;
		timerStage1 = 2;
		timerFin = 5;
		timerFin2 = 5;
		timerFin3 = 5;
		timerFin4 = 5;
		timerFin5 = 5;
		timerFin7 = 5;
		timerGameOver = 10000;
		timerFase4 = 35;
		greenDead = 0;
		redDead = 0;
		disparo1 = true;
		disparo2 = false;
		disparo3 = false;
		disparo4 = false;
		disparo5 = false;
		disparo6 = false;
		drop = true;
		dropShield = true;
		enemigos = new ArrayList<EnemigoActor>();
		enemigosBlue = new ArrayList<EnemigoActor>();
		enemigosGreen = new ArrayList<EnemigoActor>();
		enemigosYellow = new ArrayList<EnemigoActor>();
		enemigosRed = new ArrayList<EnemigoActor>();
		enemigosStage6 = new ArrayList<EnemigoActor>();
		enemigosStage7 = new ArrayList<EnemigoActor>();
		lasers = new ArrayList<LaserActor>();
		laserEnemigos = new ArrayList<LaserEnemigoActor>();
		meteoritos = new ArrayList<MeteoritoActor>();
//		ufos = new ArrayList<UfoActor>();
		laserUfos = new ArrayList<LaserUfoActor>();
		municiones = new ArrayList<MunicionActor>();
		escudos = new ArrayList<EscudoActor>();
		booleans = new ArrayList<Boolean>();
		booleans2 = new ArrayList<Boolean>();
		booleans.add(false);
		booleans.add(false);
		booleans.add(false);
		booleans.add(false);
		booleans.add(false);
		booleans.add(false);
		booleans.add(false);
		booleans.add(false);
		booleans.add(false);
		booleans.add(false);
		booleans.add(false);
		booleans.add(false);
		booleans.add(false);
		booleans.add(false);
		booleans.add(false);
		booleans.add(false);
		booleans.add(false);
		booleans.add(false);
		booleans.add(true);
		
		booleans2.add(false);
		booleans2.add(false);
		booleans2.add(false);
		booleans2.add(false);
		booleans2.add(false);
		booleans2.add(false);
		booleans2.add(false);
		booleans2.add(false);
		booleans2.add(false);
		booleans2.add(false);
		booleans2.add(false);
		booleans2.add(false);
		booleans2.add(false);
		booleans2.add(false);
		booleans2.add(false);
		booleans2.add(false);
		booleans2.add(false);
		booleans2.add(true);
		
		contadorFinFase7 = 10000;
		
		stage = new Stage(new ScreenViewport());
		nave = new NaveActor();
		puntuacion = new PuntuacionActor(new BitmapFont());
		puntuacionTexto = new PuntuacionTextoActor(new BitmapFont());
		energia = new EnergiaActor(new BitmapFont());
		energiaTexto = new EnergiaTextoActor(new BitmapFont());
		Gdx.input.setInputProcessor(stage);
		
		fondo = new FondoActor();
		stage.addActor(fondo);
		
//		planeta1 = new Image(new Texture("p1.png"));
//		planeta1.setPosition(stage.getWidth()/2 - planeta1.getWidth()/2, stage.getHeight());
//		planeta1.setOrigin(planeta1.getOriginX()+planeta1.getWidth()/2, 
//				planeta1.getOriginY()+planeta1.getHeight()/2);
//		stage.addActor(planeta1);
//		planeta1.addAction(Actions.forever(Actions.parallel(Actions.moveBy(0, -3),
//				Actions.rotateBy(1))));
		
		stage1 = new Image(new Texture("stage1.png"));
		stage1.setPosition(stage.getWidth()/2 - stage1.getWidth()/2,
				stage.getHeight()/2 - stage1.getHeight()/2);
		stage.addActor(stage1);
		
		nave.setPosition(stage.getWidth()/2-nave.getWidth()/2, 70);
		nave.getBb().setX(nave.getX());
		nave.getBb().setY(nave.getY());
		stage.addActor(nave);
		
		pause = new Image(new Texture("shadedLight14.png"));
		pause.setPosition(stage.getWidth()-pause.getWidth()-20, 
				stage.getHeight()-pause.getTop()-20);
		stage.addActor(pause);
//		pause.addListener(new InputPauseListener());
		
		ufo = new UfoActor();
		
		if(Gdx.app.getType() == ApplicationType.Desktop){
			stage.setKeyboardFocus(nave);
			nave.addListener(new InputDesktopAndroidListener());
		}else if(Gdx.app.getType() == ApplicationType.Android){
			nave.addListener(new InputDesktopAndroidListener());
		}
		
		puntuacion.setPosition(puntuacion.getWidth() + 120, stage.getHeight() - 20);
		puntuacion.setPuntuacion(0);
		puntuacionTexto.setPosition(puntuacion.getX() - puntuacionTexto.getWidth() - 100, 
				stage.getHeight() - 20);
		energia.setPosition(energia.getWidth() + 100, stage.getHeight() - 50);
		energiaTexto.setPosition(energia.getX() - energiaTexto.getWidth() - 80,
				stage.getHeight() - 50);
		energia.setEnergia(0);
		stage.addActor(puntuacion);
		stage.addActor(puntuacionTexto);
		stage.addActor(energia);
		stage.addActor(energiaTexto);
		
		
		textureEnemigo1 = new Texture("enemyblack1.png");
		textureEnemigo2 = new Texture("enemyBlack2.png");
		textureEnemigo3 = new Texture("enemyBlack3.png");
		textureEnemigo4 = new Texture("enemyBlack4.png");
		textureEnemigo5 = new Texture("enemyBlack5.png");
		
		textureEnemigoBlue2 = new Texture("enemyBlue2.png");
		textureEnemigoBlue3 = new Texture("enemyBlue3.png");
		textureEnemigoBlue4 = new Texture("enemyBlue4.png");
		textureEnemigoBlue5 = new Texture("enemyBlue5.png");
		
		municion1 = new Texture("bolt_silver.png");
		municion2 = new Texture("bolt_bronze.png");
		municion3 = new Texture("bolt_bronze.png");
		municion4 = new Texture("bolt_gold.png");
		municion5 = new Texture("bolt_gold.png");
		municion6 = new Texture("bolt_gold.png");
		enemigo1 = new EnemigoActor(textureEnemigo1);
		enemigo2 = new EnemigoActor(textureEnemigo2);
		enemigo3 = new EnemigoActor(textureEnemigo3);
		enemigo4 = new EnemigoActor(textureEnemigo4);
		enemigo5 = new EnemigoActor(textureEnemigo5);
		enemigo6 = new EnemigoActor(textureEnemigo1);
		enemigo7 = new EnemigoActor(textureEnemigo2);
		enemigo8 = new EnemigoActor(textureEnemigo3);
		enemigo9 = new EnemigoActor(textureEnemigo4);
		enemigo10 = new EnemigoActor(textureEnemigo5);
		enemigo11 = new EnemigoActor(textureEnemigo1);
		enemigo12 = new EnemigoActor(textureEnemigo2);
		enemigo13 = new EnemigoActor(textureEnemigo3);
		enemigo14 = new EnemigoActor(textureEnemigo4);
		enemigo15 = new EnemigoActor(textureEnemigo5);
		enemigo16 = new EnemigoActor(textureEnemigo1);
		enemigo17 = new EnemigoActor(textureEnemigo2);
		enemigo18 = new EnemigoActor(textureEnemigo3);
		enemigo19 = new EnemigoActor(textureEnemigo4);
		enemigo20 = new EnemigoActor(textureEnemigo5);
		enemigo21 = new EnemigoActor(textureEnemigo1);
		enemigo22 = new EnemigoActor(textureEnemigo2);
		enemigo23 = new EnemigoActor(textureEnemigo3);
		enemigo24 = new EnemigoActor(textureEnemigo4);
		enemigo25 = new EnemigoActor(textureEnemigo5);
		
		enemigoBlue1 = new EnemigoActor(textureEnemigoBlue2);
		enemigoBlue2 = new EnemigoActor(textureEnemigoBlue3);
		enemigoBlue3 = new EnemigoActor(textureEnemigoBlue4);
		enemigoBlue4 = new EnemigoActor(textureEnemigoBlue5);
		enemigoBlue5 = new EnemigoActor(textureEnemigoBlue2);
		enemigoBlue6 = new EnemigoActor(textureEnemigoBlue3);
		enemigoBlue7 = new EnemigoActor(textureEnemigoBlue4);
		enemigoBlue8 = new EnemigoActor(textureEnemigoBlue5);
		enemigoBlue9 = new EnemigoActor(textureEnemigoBlue2);
		enemigoBlue10 = new EnemigoActor(textureEnemigoBlue3);
		enemigoBlue11 = new EnemigoActor(textureEnemigoBlue4);
		enemigoBlue12 = new EnemigoActor(textureEnemigoBlue5);
		enemigoBlue13 = new EnemigoActor(textureEnemigoBlue2);
		enemigoBlue14 = new EnemigoActor(textureEnemigoBlue3);
		enemigoBlue15 = new EnemigoActor(textureEnemigoBlue4);
		enemigoBlue16 = new EnemigoActor(textureEnemigoBlue5);
		enemigoBlue17 = new EnemigoActor(textureEnemigoBlue2);
		enemigoBlue18 = new EnemigoActor(textureEnemigoBlue3);
		enemigoBlue19 = new EnemigoActor(textureEnemigoBlue4);
		enemigoBlue20 = new EnemigoActor(textureEnemigoBlue5);
		
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act();

		//Codigo solo para probar el juego
		if(Gdx.input.isKeyPressed(Input.Keys.NUMPAD_1)){
			for(int i = 0; i<enemigos.size(); i++){
				enemigos.get(i).setContador(4);
				enemigos.get(i).remove();
				enemigos.remove(i);
			}
			stage.getActors().removeValue(ufo, false);
			timerFin = 3;
			timerUfo = 10000;
			timerBlue = 8;
			timerBlue2 = 8.5f;
			timerBlue3 = 9;
			timerBlue4 = 9.5f;
			timerEnemigoBlue = 10;
			timerStage2 = 5;
		}if(Gdx.input.isKeyPressed(Input.Keys.NUMPAD_2)){
			for(int i = 0; i<enemigosBlue.size(); i++){
				enemigosBlue.get(i).setContador(8);
				enemigosBlue.get(i).remove();
				enemigosBlue.remove(i);
			}
			stage.getActors().removeValue(ufo, false);
			timerFin = 3;
			timerFin2 = 0;
			timerUfo = 10000;
			timerGreen = 8;
			timerStage3 = 5;
		}if(Gdx.input.isKeyPressed(Input.Keys.NUMPAD_3)){
			greenDead = 39;
			timerGreen = 10000;
			timerFin = 3;
			timerFin2 = 0;
			timerFin3 = 0;
			timerUfo = 10000;
			timerYellow = 8;
			timerStage4 = 5;
			timerEnemigoYellow = 7;
		}if(Gdx.input.isKeyPressed(Input.Keys.NUMPAD_4)){
			for(int i = 0; i<enemigosYellow.size(); i++){
				enemigosYellow.get(i).setContador(15);
				enemigosYellow.get(i).remove();
				enemigosYellow.remove(i);
			}
			timerFin = 3;
			timerFin2 = 0;
			timerFin3 = 0;
			timerFin4 = 0;
			timerUfo = 10000;
			timerStage5 = 5;
			timerFase4 = 10000;
			timerRed = 8;
			timerEnemigoRed = 7;
			
		}if(Gdx.input.isKeyPressed(Input.Keys.NUMPAD_5)|Gdx.input.isKeyPressed(Input.Keys.VOLUME_DOWN)){
			for(int i = 0; i<enemigos.size(); i++){
				enemigos.get(i).setContador(4);
				enemigos.get(i).remove();
				enemigos.remove(i);
			}

			timerFin = 3;
			timerFin2 = 0;	
			timerFin3 = 0;	
			timerFin4 = 0;	
			timerFin5 = 0;	
			timerStage6 = 5;
			timerEnemigoStage6 = 7;
			timerEnemigoStage62 = 11;
			timerEnemigoStage63 = 14;
			timerEnemigoStage64 = 16.5f;
			timerEnemigoStage65 = 18.5f;
			timerFinStage6 = 25;
			timerStage7=29;
			timerClear6 = 23;
			timerEnemigoStage7 = 32;
			timerUfo = 10000;
			
			timerEnemigoRed = 10000;
			timerRed = 10000;
			timerStage5=10000;
			timerEnemigoRed=10000;
			timerBlue = 10000;
			timerBlue2 = 10000;
			timerBlue3 = 10000;
			timerBlue4 = 10000;
			timerGreen = 10000;
			timerYellow = 10000; 
			timerFase4 = 10000;
			
		}if(Gdx.input.isKeyPressed(Input.Keys.NUMPAD_6)|Gdx.input.isKeyPressed(Input.Keys.VOLUME_UP)){
			for(int i = 0; i<enemigos.size(); i++){
				enemigos.get(i).setContador(4);
				enemigos.get(i).remove();
				enemigos.remove(i);
			}

			timerFin = 3;
			timerFin2 = 0;	
			timerFin3 = 0;	
			timerFin4 = 0;	
			timerFin5 = 0;	
			timerStage6 = 5;
			timerEnemigoStage6 = 10000;
			timerEnemigoStage62 = 10000;
			timerEnemigoStage63 = 10000;
			timerEnemigoStage64 = 10000;
			timerEnemigoStage65 = 10000;
			timerFinStage6 = 0;
			timerStage7=0;
			timerClear6 = 0;
			timerEnemigoStage7 = 0;
			
			timerUfo = 10000;
			
			timerEnemigoRed = 10000;
			timerRed = 10000;
			timerStage5=10000;
			timerEnemigoRed=10000;
			timerBlue = 10000;
			timerBlue2 = 10000;
			timerBlue3 = 10000;
			timerBlue4 = 10000;
			timerGreen = 10000;
			timerYellow = 10000; 
			timerFase4 = 10000;
			
		}
	
		
		puntuacion.toFront();
		puntuacionTexto.toFront();
		energia.toFront();
		energiaTexto.toFront();
		nave.toFront();
		
//		if(planeta1.getTop()<0){
//			planeta1.setPosition(planeta1.getX(), stage.getHeight());
//		}

		timer -= delta;
		timerMusicaFondo -= delta;
		timer2 -= delta;
		timer3 -= delta;
		timer4 -= delta;
		timerIzq -= delta;
		timerDer -= delta;
		timerMeteor -= delta;
		timerUfo -= delta;
		timerLaserUfo -= delta;
		timerDisparar -= delta;
		timerEnemigo -= delta;
		timerStage1 -= delta;
		timerStage2 -= delta;
		timerStage3 -= delta;
		timerStage4 -= delta;
		timerStage5 -= delta;
		timerStage6 -= delta;
		timerStage7 -= delta;
		timerStage8 -= delta;
		timerBlue -= delta;
		timerBlue2 -= delta;
		timerBlue3 -= delta;
		timerBlue4 -= delta;
		timerEnemigoBlue -= delta;
		timerEnemigoYellow -= delta;
		timerEnemigoStage6 -= delta;
		timerEnemigoStage62 -= delta;
		timerEnemigoStage63 -= delta;
		timerEnemigoStage64 -= delta;
		timerEnemigoStage65 -= delta;
		timerEnemigoStage7 -= delta;
		timerFinStage6 -= delta;
		timerEnemigoRed -= delta;
		timerDisparoEnemigoStage7 -=  delta;
		timerGameOver -= delta;
		timerGreen -= delta;
		timerYellow -= delta;
		timerRed -= delta;
		
		timerClear6 -= delta;
		contadorFinFase7 -= delta;
		
	
		if(timerFin<=4){
			timerFin -= delta;
			if(timerFin<0){
				stage.getActors().removeValue(clear, false);
				if(timerStage2<2){
					stage2();
				}
				if(timerBlue<0){
					spawnEnemigosBlue();
				}
				if(timerBlue2<0){
					spawnEnemigosBlue2();
				}
				if(timerBlue3<0){
					spawnEnemigosBlue3();
				}
				if(timerBlue4<0){
					spawnEnemigosBlue4();
				}
				if(timerEnemigoBlue < 0 && !enemigosBlue.isEmpty()){
					dispararLaserEnemigoBlue();
				}
				if(timerStage2<0){
					stage.getActors().removeValue(stage2, false);
				}
				if(timerGameOver < 0){
					game.setScreen(game.gameoverScreen);
				}

				if(timerFin2<=4){
					timerFin2 -= delta;
					if(timerFin2<0){
						stage.getActors().removeValue(clear, false);
						if(timerStage3<2){
							stage3();
						}
						if(timerGreen < 0){
							spawnEnemigosGreen();
						}

						if(timerFin3<=4){
							timerFin3 -= delta;
							timerFase4 -= delta;
							if(timerFase4<0){
								stage.getActors().removeValue(ufo, false);
								clear = new Image(new Texture("clear.png"));
								clear.setPosition(stage.getWidth()/2 - clear.getWidth()/2,
										stage.getHeight()/2 - clear.getHeight()/2);
								stage.addActor(clear);
								timerFin = 3;
								timerFin2 = 0;
								timerFin3 = 0;
								timerFin4 = 0;
								timerUfo = 10000;
								timerStage5 = 5;
								timerFase4 = 10000;
								timerRed = 8;
								timerEnemigoRed = 7;

							}

							if(timerFin3<0){
								stage.getActors().removeValue(clear, false);
								if(timerStage4 < 2){
									stage4();
								}
								if(timerYellow < 0){
									spawnEnemigosYellow();
								}
								if(timerEnemigoYellow < 0 && !enemigosYellow.isEmpty()){
									dispararLaserEnemigoYellow();
								}
								if(timerFin4<=4){
									timerFin4 -= delta;
									if(timerFin4<0){
										stage.getActors().removeValue(clear, false);
										if(timerEnemigoRed < 0 && !enemigosRed.isEmpty()){
											dispararLaserEnemigoRed();
										}
										if(timerStage5 < 2){
											stage5();
										}
										if(timerRed < 0){
											spawnEnemigosRed();
										}

										if(timerFin5<=4){
											timerFin5 -= delta;
											if(timerFin5<0){
												stage.getActors().removeValue(clear, false);
												if(timerStage6 < 2){
													stage6();
													noDisparar();
													musicaFundo.setVolume((float) 0.1);;
												}
												if(timerEnemigoStage6 < 0){
													spawnEnemigosStage6();
													game.lanzamiento.play();
												}
												if(timerEnemigoStage62 < 0){
													spawnEnemigosStage62();
													game.lanzamiento.play();
												}
												if(timerEnemigoStage63 < 0){
													spawnEnemigosStage63();
													game.lanzamiento.play();
												}
												if(timerEnemigoStage64 < 0){
													spawnEnemigosStage64();
													game.lanzamiento.play();
												}
												if(timerEnemigoStage65 < 0){
													spawnEnemigosStage65();
													game.lanzamiento.play();
												}

											
												if(timerClear6 < 0){
													
													clear();
												}
												
												if(timerFinStage6 < 0){

													stage.getActors().removeValue(clear, false);

													if(timerStage7 < 4){

														stage7();
														musicaFundo.setVolume((float) 0.3);
														if(energia.getEnergia()==0){
															disparar();
														}
														else if(energia.getEnergia()==1){
															disparar2();
														}
														else if(energia.getEnergia()==2){
															disparar3();
														}	
														else if(energia.getEnergia()==3){
															disparar4();
														}
														else if(energia.getEnergia()==4){
															disparar5();
														}
														else if(energia.getEnergia()==5){
															disparar6();
														}

														
													}
														


												}
												if(timerDisparoEnemigoStage7 < 0 & !enemigosStage7.isEmpty()){
													dispararLaserEnemigoStage7();
													}
												if(timerEnemigoStage7 < 0){
													spawnEnemigosStage7();
													
												}

												if(timerFin7<=4){
													timerFin7 -= delta;
													stage.getActors().removeValue(clear, false);
												
													if(timerStage8 < 2){
														stage8();
														
													}
												}
												
											}}

									}
								}

							}
						}
					}
				}
			}
		}
		
		if(timerStage1<0){
			stage.getActors().removeValue(stage1, false);
		}
		

		if(timer<0){
			spawnEnemigos();
		}
		

    	if(timerMusicaFondo<3){
    		initSons();
    	}
    	
		if(timer2<0){
			spawnEnemigos2();
		}
		if(timer3<0){
			spawnEnemigos3();
		}
		if(timer4<0){
			spawnEnemigos4();
		}

		if(controlador.obedeceRaton){
			ir();
		}
		if(stage.getActors().contains(shield, false)){
			irEscudo();
		}
		
		if(timerDisparar < 0 && disparo1){
			disparar();
		}
		if(timerDisparar < 0 && disparo2){
			disparar2();
		}
		if(timerDisparar < 0 && disparo3){
			disparar3();
		}
		if(timerDisparar < 0 && disparo4){
			disparar4();
		}
		if(timerDisparar < 0 && disparo5){
			disparar5();
		}	
		if(timerDisparar < 0 && disparo6){
			disparar6();
		}
		if(timerEnemigo < 0 && !enemigos.isEmpty()){
			dispararLaserEnemigo();
		}
		if(timerMeteor < 0){
			spawnMeteorito();
		}
		if(timerUfo < 0){
			spawnUfo();
		}
		if(timerLaserUfo < 0 && stage.getActors().contains(ufo, true)){
			dispararLaserUfo();
		}
		if(timerGameOver < 0){
			game.setScreen(game.gameoverScreen);
			musicaFundo.stop();
		}
		
		if(!enemigosStage7.isEmpty()&contadorFinFase7<3){
			for(EnemigoActor e:enemigosStage7){
				for(Action a:e.getActions()){
					e.removeAction(a);
				}
				e.addAction(Actions.sequence(Actions.moveTo(nave.getRight()/2, nave.getTop()/2, 0.75f),
						Actions.forever(Actions.moveBy(0, -10))));
			}
		}
		
		comprobarListas();
		if(timerGameOver > 2){
			comprobarColisiones();
		}
		stage.draw();
			
	}
	
	private void comprobarListas() {
		
		for(int i = 0; i < lasers.size(); i++){
			if(stage.getActors().contains(lasers.get(i), false) && 
					lasers.get(i).getY() > lasers.get(i).getStage().getHeight()){
				lasers.get(i).remove();
				lasers.remove(i);
			}
		}
		
		for(int i = 0; i < laserEnemigos.size(); i++){
			if(laserEnemigos.get(i).getY() < -laserEnemigos.get(i).getHeight()){
				laserEnemigos.get(i).remove();
				laserEnemigos.remove(i);
			}
		}
		
		
		for(int i = 0; i < meteoritos.size(); i++){
			if(meteoritos.get(i).getY() < -meteoritos.get(i).getHeight()){
				meteoritos.get(i).remove();
				meteoritos.remove(i);
			}
		}
		
//		for(int i = 0; i < ufos.size(); i++){
		if(stage.getActors().contains(ufo, false)){
			if(ufo.getX() < -ufo.getWidth()){
				ufo.remove();
//				ufos.remove(i);
				game.ufoSound.stop();
			}
		}
//		}
		
		for(int i = 0; i < laserUfos.size(); i++){
			if(laserUfos.get(i).getY() < -laserUfos.get(i).getHeight()){
				laserUfos.get(i).remove();
				laserUfos.remove(i);
			}
		}
		
		for(int i = 0; i < municiones.size(); i++){
			if(municiones.get(i).getY() < -municiones.get(i).getHeight()){
				municiones.get(i).remove();
				municiones.remove(i);
			}
		}
		
		for(int i = 0; i < escudos.size(); i++){
			if(escudos.get(i).getY() < -escudos.get(i).getHeight()){
				escudos.get(i).remove();
				escudos.remove(i);
			}
		}
		
		for(int i = 0; i < enemigosGreen.size(); i++){
			if(enemigosGreen.get(i).getY() < -enemigosGreen.get(i).getHeight()){
				enemigosGreen.get(i).remove();
				enemigosGreen.remove(i);
				puntuacion.setPuntuacion(puntuacion.getPuntuacion()-100);
			}
		}
		
		for(int i = 0; i < enemigosYellow.size(); i++){
			if(enemigosYellow.get(i).getY() < -enemigosYellow.get(i).getHeight()){
				enemigosYellow.get(i).setContador(15);
				enemigosYellow.get(i).remove();
				enemigosYellow.remove(i);
				puntuacion.setPuntuacion(puntuacion.getPuntuacion()-100);
			}
		}
		
		for(int i = 0; i < enemigosRed.size(); i++){
			if(enemigosRed.get(i).getY() < -enemigosRed.get(i).getHeight()){
				enemigosRed.get(i).setContador(15);
				enemigosRed.get(i).remove();
				enemigosRed.remove(i);
				puntuacion.setPuntuacion(puntuacion.getPuntuacion()-100);
			}
		}
		
		for(int i = 0; i < enemigosStage6.size(); i++){
			if(enemigosStage6.get(i).getY() < -enemigosStage6.get(i).getHeight()){
				enemigosStage6.get(i).remove();
				enemigosStage6.remove(i);
				puntuacion.setPuntuacion(puntuacion.getPuntuacion()+200);
			}
		}
		
		for(int i = 0; i < enemigosStage7.size(); i++){
			if(enemigosStage7.get(i).getY() < -enemigosStage7.get(i).getHeight()){
				enemigosStage7.get(i).setContador(20);
				enemigosStage7.get(i).remove();
				enemigosStage7.remove(i);
				puntuacion.setPuntuacion(puntuacion.getPuntuacion()-100);
			}
		}

	}

	private void comprobarColisiones() {
		EnemigoActor enemigo;
		EnemigoActor enemigoBlue;
		EnemigoActor enemigoGreen;
		EnemigoActor enemigoYellow;
		EnemigoActor enemigoRed;
		EnemigoActor enemigoStage6;
		EnemigoActor enemigoStage7;
		LaserActor laser;
		LaserEnemigoActor laserEnemigo;
		MeteoritoActor meteorito;
//		UfoActor ufo;
		LaserUfoActor laserUfo;
		MunicionActor municion;
		EscudoActor escudo;

		for(int i = 0; i < enemigos.size(); i++){
			enemigo = enemigos.get(i);
			if(enemigo.getBb().overlaps(nave.getBb())&&
					!stage.getActors().contains(shield, false)){
				// Colisión enemigo-nave
				
				enemigos.get(i).remove();
				enemigos.remove(i);
				
				game.explosion.play();
				game.ufoSound.stop();
				
				
				BoomActor boom = new BoomActor();
				boom.setPosition(nave.getX()+nave.getWidth()/2-boom.getWidth()/2,
						nave.getY()+nave.getHeight()/2-boom.getHeight()/2);
				nave.remove();
				stage.addActor(boom);
				timerGameOver = 0.4f;
				int prueba =  Preferencias.getMayorPuntuacion();
				if (puntuacion.getPuntuacion() > prueba){
					Preferencias.setMayorPuntuacion(puntuacion.getPuntuacion());					
				}
			}else if(stage.getActors().contains(shield, false)&&
					enemigo.getBb().overlaps(nave.getBb())&&
					shield.getTipo()==2){
				enemigos.get(i).remove();
				enemigos.remove(i);
				BoomActor boom = new BoomActor();
				boom.setPosition(enemigo.getX()+enemigo.getWidth()/2-boom.getWidth()/2,
						enemigo.getY()+enemigo.getHeight()/2-boom.getHeight()/2);
				stage.addActor(boom);
				stage.getActors().removeValue(shield, false);
				shield = new ShieldActor(new Texture("shield1.png"), 1);
				stage.addActor(shield);
				game.hitSound.play();
			}else if(stage.getActors().contains(shield, false)&&
					enemigo.getBb().overlaps(nave.getBb())&&
					shield.getTipo()==1){
				enemigos.get(i).remove();
				enemigos.remove(i);
				BoomActor boom = new BoomActor();
				boom.setPosition(enemigo.getX()+enemigo.getWidth()/2-boom.getWidth()/2,
						enemigo.getY()+enemigo.getHeight()/2-boom.getHeight()/2);
				stage.addActor(boom);
				stage.getActors().removeValue(shield, false);
				game.hitSound.play();
				dropShield = true;
			}
				for(int j = 0; j < lasers.size(); j++){
					laser = lasers.get(j);
					if(laser.getBb().overlaps(enemigo.getBb())){
						// Colisión enemigo-láser
						lasers.get(j).remove();
						lasers.remove(j);
						game.explosionSound.play();
						enemigo.setContador(enemigo.getContador()+1);
						if(enemigo.getContador()==4){
							Random random = new Random();
						    int index = random.nextInt(booleans.size());
						    Boolean m = booleans.get(index);
						    if(m){
						    	if(energia.getEnergia()==0 && drop){
						    		dropMunicion(enemigo, municion1, 1);
						    	}else if(energia.getEnergia()==1 && drop){
						    		dropMunicion(enemigo, municion2, 2);
						    	}else if(energia.getEnergia()==2 && drop){
						    		dropMunicion(enemigo, municion3, 3);
						    	}else if(energia.getEnergia()==3 && drop){
						    		dropMunicion(enemigo, municion4, 4);
						    	}else if(energia.getEnergia()==4 && drop){
						    		dropMunicion(enemigo, municion5, 5);
						    	}else if(energia.getEnergia()==5 && drop){
						    		dropMunicion(enemigo, municion6, 6);
						    	}
						    }
						    Random random2 = new Random();
						    int index2 = random2.nextInt(booleans2.size());
						    Boolean e = booleans2.get(index2);
						    if(e&&dropShield){
						    	dropEscudo(enemigo);
						    	dropShield = false;
						    }
						    
							enemigos.get(i).remove();
							enemigos.remove(i);
							BoomActor boom = new BoomActor();
							boom.setPosition(enemigo.getX()+enemigo.getWidth()/2-boom.getWidth()/2,
									enemigo.getY()+enemigo.getHeight()/2-boom.getHeight()/2);
							stage.addActor(boom);
							puntuacion.setPuntuacion(puntuacion.getPuntuacion()+100);
							if(enemigos.isEmpty()){
								stage.getActors().removeValue(ufo, false);
								clear = new Image(new Texture("clear.png"));
								clear.setPosition(stage.getWidth()/2 - clear.getWidth()/2,
										stage.getHeight()/2 - clear.getHeight()/2);
								stage.addActor(clear);
								timerFin = 3;
								timerUfo = 10000;
								timerBlue = 8;
								timerBlue2 = 8.5f;
								timerBlue3 = 9;
								timerBlue4 = 9.5f;
								timerEnemigoBlue = 10;
								timerStage2 = 5;
							}
						}
					}
				}
			}
		
		for(int k = 0; k < laserEnemigos.size(); k++){
			laserEnemigo = laserEnemigos.get(k);
			if(laserEnemigo.getBb().overlaps(nave.getBb())&&
					!stage.getActors().contains(shield, false)){
				// Colisión nave-láser enemigo
				laserEnemigos.get(k).remove();
				laserEnemigos.remove(k);
				game.explosion.play();
				game.ufoSound.stop();
				BoomActor boom = new BoomActor();
				boom.setPosition(nave.getX()+nave.getWidth()/2-boom.getWidth()/2,
						nave.getY()+nave.getHeight()/2-boom.getHeight()/2);
				nave.remove();
				stage.addActor(boom);
				timerGameOver = 0.4f;
				if (puntuacion.getPuntuacion() > Preferencias.getMayorPuntuacion()){
					Preferencias.setMayorPuntuacion(puntuacion.getPuntuacion());					
				}
			}else if(stage.getActors().contains(shield, false)&&
					laserEnemigo.getBb().overlaps(nave.getBb())&&
					shield.getTipo()==2){
				laserEnemigos.get(k).remove();
				laserEnemigos.remove(k);
				stage.getActors().removeValue(shield, false);
				shield = new ShieldActor(new Texture("shield1.png"), 1);
				stage.addActor(shield);
				game.hitSound.play();
			}else if(stage.getActors().contains(shield, false)&&
					laserEnemigo.getBb().overlaps(nave.getBb())&&
					shield.getTipo()==1){
				laserEnemigos.get(k).remove();
				laserEnemigos.remove(k);
				stage.getActors().removeValue(shield, false);
				game.hitSound.play();
				dropShield = true;
			}
		}

		
		for(int k = 0; k < meteoritos.size(); k++){
			meteorito = meteoritos.get(k);
			if(meteorito.getBb().overlaps(nave.getBb())&&
					!stage.getActors().contains(shield, false)){
				// Colisión nave-meteorito
				meteoritos.get(k).remove();
				meteoritos.remove(k);
				game.explosion.play();
				game.ufoSound.stop();
				BoomActor boom = new BoomActor();
				boom.setPosition(nave.getX()+nave.getWidth()/2-boom.getWidth()/2,
						nave.getY()+nave.getHeight()/2-boom.getHeight()/2);
				nave.remove();
				stage.addActor(boom);
				
				timerGameOver = 0.4f;
				if (puntuacion.getPuntuacion() > Preferencias.getMayorPuntuacion()){
					Preferencias.setMayorPuntuacion(puntuacion.getPuntuacion());					
				}
			}else if(stage.getActors().contains(shield, false)&&
					meteorito.getBb().overlaps(nave.getBb())&&
					shield.getTipo()==2){
				meteoritos.get(k).remove();
				meteoritos.remove(k);
				BoomActor boom = new BoomActor();
				boom.setPosition(meteorito.getX()+meteorito.getWidth()/2-boom.getWidth()/2,
						meteorito.getY()+meteorito.getHeight()/2-boom.getHeight()/2);
				stage.addActor(boom);
				stage.getActors().removeValue(shield, false);
				shield = new ShieldActor(new Texture("shield1.png"), 1);
				stage.addActor(shield);
				game.hitSound.play();
			}else if(stage.getActors().contains(shield, false)&&
					meteorito.getBb().overlaps(nave.getBb())&&
					shield.getTipo()==1){
				meteoritos.get(k).remove();
				meteoritos.remove(k);
				BoomActor boom = new BoomActor();
				boom.setPosition(meteorito.getX()+meteorito.getWidth()/2-boom.getWidth()/2,
						meteorito.getY()+meteorito.getHeight()/2-boom.getHeight()/2);
				stage.addActor(boom);
				stage.getActors().removeValue(shield, false);
				game.hitSound.play();
				dropShield = true;
			}
			for(int j = 0; j < lasers.size(); j++){
				if(meteorito.getBb().overlaps(lasers.get(j).getBb())){
					lasers.get(j).remove();
					lasers.remove(j);
					game.explosionSound.play();
					meteorito.setContador(meteorito.getContador()+1);
					if(meteorito.getWidth()>=89&&meteorito.getContador()==40){
						this.rompeMeteoritoGrande(meteorito);
						meteoritos.get(k).remove();
						meteoritos.remove(k);
						BoomActor boom = new BoomActor();
						boom.setPosition(meteorito.getX()+meteorito.getWidth()/2-boom.getWidth()/2,
								meteorito.getY()+meteorito.getHeight()/2-boom.getHeight()/2);
						stage.addActor(boom);
						puntuacion.setPuntuacion(puntuacion.getPuntuacion()+500);
					}else if(meteorito.getWidth()==43&&meteorito.getContador()==20){
						meteoritos.get(k).remove();
						meteoritos.remove(k);
						BoomActor boom = new BoomActor();
						boom.setPosition(meteorito.getX()+meteorito.getWidth()/2-boom.getWidth()/2,
								meteorito.getY()+meteorito.getHeight()/2-boom.getHeight()/2);
						stage.addActor(boom);
						puntuacion.setPuntuacion(puntuacion.getPuntuacion()+250);
					}else if(meteorito.getWidth()==29&&meteorito.getContador()==10){
						meteoritos.get(k).remove();
						meteoritos.remove(k);
						BoomActor boom = new BoomActor();
						boom.setPosition(meteorito.getX()+meteorito.getWidth()/2-boom.getWidth()/2,
								meteorito.getY()+meteorito.getHeight()/2-boom.getHeight()/2);
						stage.addActor(boom);
						puntuacion.setPuntuacion(puntuacion.getPuntuacion()+100);
					}
				}
			}
		}
//		for(int k = 0; k < ufos.size(); k++){
//			ufo = ufos.get(k);
			for(int j = 0; j < lasers.size(); j++){
				laser = lasers.get(j);
				if(stage.getActors().contains(ufo, false)){
					if(ufo.getBb().overlaps(laser.getBb())){
						// Colisión láser-ufo
						ufo.remove();
						//					ufos.remove(k);
						lasers.get(j).remove();
						lasers.remove(j);
						puntuacion.setPuntuacion(puntuacion.getPuntuacion()+500);
						game.ufoSound.stop();
						game.explosionSound.play();
					}
				}
			}
			//		}
		for(int k = 0; k < laserUfos.size(); k++){
			laserUfo = laserUfos.get(k);
			if(laserUfo.getBb().overlaps(nave.getBb())&&
					!stage.getActors().contains(shield, false)){
				// Colisión nave-láser ufo
				laserUfos.get(k).remove();
				laserUfos.remove(k);
				game.explosion.play();
				game.ufoSound.stop();
				BoomActor boom = new BoomActor();
				boom.setPosition(nave.getX()+nave.getWidth()/2-boom.getWidth()/2,
						nave.getY()+nave.getHeight()/2-boom.getHeight()/2);
				nave.remove();
				stage.addActor(boom);
				timerGameOver = 0.4f;
				if (puntuacion.getPuntuacion() > Preferencias.getMayorPuntuacion()){
					Preferencias.setMayorPuntuacion(puntuacion.getPuntuacion());					
				}
			}else if(stage.getActors().contains(shield, false)&&
					laserUfo.getBb().overlaps(nave.getBb())&&
					shield.getTipo()==2){
				laserUfos.get(k).remove();
				laserUfos.remove(k);
				stage.getActors().removeValue(shield, false);
				shield = new ShieldActor(new Texture("shield1.png"), 1);
				stage.addActor(shield);
				game.hitSound.play();
			}else if(stage.getActors().contains(shield, false)&&
					laserUfo.getBb().overlaps(nave.getBb())&&
					shield.getTipo()==1){
				laserUfos.get(k).remove();
				laserUfos.remove(k);
				stage.getActors().removeValue(shield, false);
				game.hitSound.play();
				dropShield = true;
			}
		}
		for(int k = 0; k < municiones.size(); k++){
			municion = municiones.get(k);
			if(municion.getBb().overlaps(nave.getBb())){
				// Colisión nave-municion
				municiones.get(k).remove();
				municiones.remove(k);
				if(energia.getEnergia()==0 && municion.getTipo()==1){
					disparo1 = false;
					disparo2 = true;
					energia.setEnergia(1);
				}else if(energia.getEnergia()==1 && municion.getTipo()==2){
					disparo2 = false;
					disparo3 = true;
					energia.setEnergia(2);
				}else if(energia.getEnergia()==2 && municion.getTipo()==3){
					disparo3 = false;
					disparo4 = true;
					energia.setEnergia(3);
				}else if(energia.getEnergia()==3 && municion.getTipo()==4){
					disparo4 = false;
					disparo5 = true;
					energia.setEnergia(4);
				}
				else if(energia.getEnergia()==4 && municion.getTipo()==5){
					disparo5 = false;
					disparo6 = true;
					energia.setEnergia(5);
					drop = false;
				}
//				}else if(energia.getEnergia()==2){
//					disparo3 = false;
//					disparo4 = true;
//					energia.setEnergia(3);
//				}
				game.pillSound.play();
			}
		}
		
		for(int k = 0; k < escudos.size(); k++){
			escudo = escudos.get(k);
			if(escudo.getBb().overlaps(nave.getBb())){
				// Colisión nave-escudo
				escudos.get(k).remove();
				escudos.remove(k);
				shield = new ShieldActor(new Texture("shield2.png"), 2);
				stage.addActor(shield);
				game.pillSound.play();
			}
		}
		
		
		for(int i = 0; i < enemigosBlue.size(); i++){
			enemigoBlue = enemigosBlue.get(i);
			if(enemigoBlue.getBb().overlaps(nave.getBb())&&
					!stage.getActors().contains(shield, false)){
				// Colisión enemigo-nave
				enemigosBlue.get(i).remove();
				enemigosBlue.remove(i);
				game.explosion.play();
				game.ufoSound.stop();
				BoomActor boom = new BoomActor();
				boom.setPosition(nave.getX()+nave.getWidth()/2-boom.getWidth()/2,
						nave.getY()+nave.getHeight()/2-boom.getHeight()/2);
				nave.remove();
				stage.addActor(boom);
				timerGameOver = 0.4f;
				if (puntuacion.getPuntuacion() > Preferencias.getMayorPuntuacion()){
					Preferencias.setMayorPuntuacion(puntuacion.getPuntuacion());					
				}
			}else if(stage.getActors().contains(shield, false)&&
					enemigoBlue.getBb().overlaps(nave.getBb())&&
					shield.getTipo()==2){
				enemigosBlue.get(i).remove();
				enemigosBlue.remove(i);
				BoomActor boom = new BoomActor();
				boom.setPosition(enemigoBlue.getX()+enemigoBlue.getWidth()/2-boom.getWidth()/2,
						enemigoBlue.getY()+enemigoBlue.getHeight()/2-boom.getHeight()/2);
				stage.addActor(boom);
				stage.getActors().removeValue(shield, false);
				shield = new ShieldActor(new Texture("shield1.png"), 1);
				stage.addActor(shield);
				game.hitSound.play();
			}else if(stage.getActors().contains(shield, false)&&
					enemigoBlue.getBb().overlaps(nave.getBb())&&
					shield.getTipo()==1){
				enemigosBlue.get(i).remove();
				enemigosBlue.remove(i);
				BoomActor boom = new BoomActor();
				boom.setPosition(enemigoBlue.getX()+enemigoBlue.getWidth()/2-boom.getWidth()/2,
						enemigoBlue.getY()+enemigoBlue.getHeight()/2-boom.getHeight()/2);
				stage.addActor(boom);
				stage.getActors().removeValue(shield, false);
				game.hitSound.play();
				dropShield = true;
			
	
			}
				for(int j = 0; j < lasers.size(); j++){
					laser = lasers.get(j);
					if(laser.getBb().overlaps(enemigoBlue.getBb())){
						// Colisión enemigo-láser
						lasers.get(j).remove();
						lasers.remove(j);
						game.explosionSound.play();
						enemigoBlue.setContador(enemigoBlue.getContador()+1);
						if(enemigoBlue.getContador()==8){
							Random random = new Random();
						    int index = random.nextInt(booleans.size());
						    Boolean m = booleans.get(index);
						    if(m){
						    	if(energia.getEnergia()==0 && drop){
						    		dropMunicion(enemigoBlue, municion1, 1);
						    	}else if(energia.getEnergia()==1 && drop){
						    		dropMunicion(enemigoBlue, municion2, 2);
						    	}else if(energia.getEnergia()==2 && drop){
						    		dropMunicion(enemigoBlue, municion3, 3);
						    	}else if(energia.getEnergia()==3 && drop){
						    		dropMunicion(enemigoBlue, municion4, 4);
						    	}else if(energia.getEnergia()==4 && drop){
						    		dropMunicion(enemigoBlue, municion5, 5);
						    	}else if(energia.getEnergia()==5 && drop){
						    		dropMunicion(enemigoBlue, municion6, 6);
						    	}
						    }
						    Random random2 = new Random();
						    int index2 = random2.nextInt(booleans2.size());
						    Boolean e = booleans2.get(index2);
						    if(e&&dropShield){
						    	dropEscudo(enemigoBlue);
						    	dropShield = false;
						    }
						    
							enemigosBlue.get(i).remove();
							enemigosBlue.remove(i);
							BoomActor boom = new BoomActor();
							boom.setPosition(enemigoBlue.getX()+
									enemigoBlue.getWidth()/2-boom.getWidth()/2,
									enemigoBlue.getY()+enemigoBlue.getHeight()/2-boom.getHeight()/2);
							stage.addActor(boom);
							puntuacion.setPuntuacion(puntuacion.getPuntuacion()+100);
							if(enemigosBlue.isEmpty()){
								stage.getActors().removeValue(ufo, false);
								clear = new Image(new Texture("clear.png"));
								clear.setPosition(stage.getWidth()/2 - clear.getWidth()/2,
										stage.getHeight()/2 - clear.getHeight()/2);
								stage.addActor(clear);
								timerFin = 3;
								timerFin2 = 0;
								timerUfo = 10000;
								timerGreen = 8;
								timerStage3 = 5;
								
							}
						}
					}
				}
			}
		
		for(int i = 0; i < enemigosGreen.size(); i++){
			enemigoGreen = enemigosGreen.get(i);
			if(enemigoGreen.getBb().overlaps(nave.getBb())&&
					!stage.getActors().contains(shield, false)){
				// Colisión enemigo-nave
				enemigosGreen.get(i).remove();
				enemigosGreen.remove(i);
				game.explosion.play();
				game.ufoSound.stop();
				BoomActor boom = new BoomActor();
				boom.setPosition(nave.getX()+nave.getWidth()/2-boom.getWidth()/2,
						nave.getY()+nave.getHeight()/2-boom.getHeight()/2);
				nave.remove();
				stage.addActor(boom);
				timerGameOver = 0.4f;
				if (puntuacion.getPuntuacion() > Preferencias.getMayorPuntuacion()){
					Preferencias.setMayorPuntuacion(puntuacion.getPuntuacion());					
				}
			}else if(stage.getActors().contains(shield, false)&&
					enemigoGreen.getBb().overlaps(nave.getBb())&&
					shield.getTipo()==2){
				enemigosGreen.get(i).remove();
				enemigosGreen.remove(i);
				BoomActor boom = new BoomActor();
				boom.setPosition(enemigoGreen.getX()+enemigoGreen.getWidth()/2-boom.getWidth()/2,
						enemigoGreen.getY()+enemigoGreen.getHeight()/2-boom.getHeight()/2);
				stage.addActor(boom);
				stage.getActors().removeValue(shield, false);
				shield = new ShieldActor(new Texture("shield1.png"), 1);
				stage.addActor(shield);
				game.hitSound.play();
			}else if(stage.getActors().contains(shield, false)&&
					enemigoGreen.getBb().overlaps(nave.getBb())&&
					shield.getTipo()==1){
				enemigosGreen.get(i).remove();
				enemigosGreen.remove(i);
				BoomActor boom = new BoomActor();
				boom.setPosition(enemigoGreen.getX()+enemigoGreen.getWidth()/2-boom.getWidth()/2,
						enemigoGreen.getY()+enemigoGreen.getHeight()/2-boom.getHeight()/2);
				stage.addActor(boom);
				stage.getActors().removeValue(shield, false);
				game.hitSound.play();
				dropShield = true;
			
	
			}
	
				for(int j = 0; j < lasers.size(); j++){
					laser = lasers.get(j);
					if(laser.getBb().overlaps(enemigoGreen.getBb())){
						// Colisión enemigo-láser
						lasers.get(j).remove();
						lasers.remove(j);
						game.explosionSound.play();
						enemigoGreen.setContador(enemigoGreen.getContador()+1);
						if(enemigoGreen.getContador()==10){
							Random random = new Random();
						    int index = random.nextInt(booleans.size());
						    Boolean m = booleans.get(index);
						    if(m){
						    	if(energia.getEnergia()==0 && drop){
						    		dropMunicion(enemigoGreen, municion1, 1);
						    	}else if(energia.getEnergia()==1 && drop){
						    		dropMunicion(enemigoGreen, municion2, 2);
						    	}else if(energia.getEnergia()==2 && drop){
						    		dropMunicion(enemigoGreen, municion3, 3);
						    	}else if(energia.getEnergia()==3 && drop){
						    		dropMunicion(enemigoGreen, municion4, 4);
						    	}else if(energia.getEnergia()==4 && drop){
						    		dropMunicion(enemigoGreen, municion5, 5);
						    	}else if(energia.getEnergia()==5 && drop){
						    		dropMunicion(enemigoGreen, municion6, 6);
						    	}
						    }
						    Random random2 = new Random();
						    int index2 = random2.nextInt(booleans2.size());
						    Boolean e = booleans2.get(index2);
						    if(e&&dropShield){
						    	dropEscudo(enemigoGreen);
						    	dropShield = false;
						    }
							
							enemigosGreen.get(i).remove();
							enemigosGreen.remove(i);
							BoomActor boom = new BoomActor();
							boom.setPosition(enemigoGreen.getX()+
									enemigoGreen.getWidth()/2-boom.getWidth()/2,
									enemigoGreen.getY()+enemigoGreen.getHeight()/2-boom.getHeight()/2);
							stage.addActor(boom);
							puntuacion.setPuntuacion(puntuacion.getPuntuacion()+100);
							greenDead++;
							if(greenDead == 39 ){
								timerGreen = 10000;
								for(int g = 0; g<enemigosGreen.size(); g++){
									BoomActor boomGreen = new BoomActor();
									boomGreen.setPosition(enemigosGreen.get(g).getX()+
											enemigosGreen.get(g).getWidth()/2-boomGreen.getWidth()/2,
											enemigosGreen.get(g).getY()+
											enemigosGreen.get(g).getHeight()/2-boomGreen.getHeight()/2);
									enemigosGreen.get(g).remove();
									enemigosGreen.remove(g);
									stage.addActor(boomGreen);
								}
								stage.getActors().removeValue(ufo, false);
								clear = new Image(new Texture("clear.png"));
								clear.setPosition(stage.getWidth()/2 - clear.getWidth()/2,
										stage.getHeight()/2 - clear.getHeight()/2);
								stage.addActor(clear);
								timerFin = 3;
								timerFin2 = 0;
								timerFin3 = 0;
								timerUfo = 10000;
								timerYellow = 8;
								timerStage4 = 5;
								timerEnemigoYellow = 7;
								
							}
						}
					}
				}
			}
		
		
	
		
			for(int i = 0; i < enemigosYellow.size(); i++){
				enemigoYellow = enemigosYellow.get(i);
				if(enemigoYellow.getBb().overlaps(nave.getBb())&&
						!stage.getActors().contains(shield, false)){
					// Colisión enemigo-nave
					enemigosYellow.get(i).remove();
					enemigosYellow.remove(i);
					game.explosion.play();
					game.ufoSound.stop();
					BoomActor boom = new BoomActor();
					boom.setPosition(nave.getX()+nave.getWidth()/2-boom.getWidth()/2,
							nave.getY()+nave.getHeight()/2-boom.getHeight()/2);
					nave.remove();
					stage.addActor(boom);
					timerGameOver = 0.4f;
					if (puntuacion.getPuntuacion() > Preferencias.getMayorPuntuacion()){
						Preferencias.setMayorPuntuacion(puntuacion.getPuntuacion());					
					}
				}else if(stage.getActors().contains(shield, false)&&
						enemigoYellow.getBb().overlaps(nave.getBb())&&
						shield.getTipo()==2){
					enemigosYellow.get(i).remove();
					enemigosYellow.remove(i);
					BoomActor boom = new BoomActor();
					boom.setPosition(enemigoYellow.getX()+enemigoYellow.getWidth()/2-boom.getWidth()/2,
							enemigoYellow.getY()+enemigoYellow.getHeight()/2-boom.getHeight()/2);
					stage.addActor(boom);
					stage.getActors().removeValue(shield, false);
					shield = new ShieldActor(new Texture("shield1.png"), 1);
					stage.addActor(shield);
					game.hitSound.play();
				}else if(stage.getActors().contains(shield, false)&&
						enemigoYellow.getBb().overlaps(nave.getBb())&&
						shield.getTipo()==1){
					enemigosYellow.get(i).remove();
					enemigosYellow.remove(i);
					BoomActor boom = new BoomActor();
					boom.setPosition(enemigoYellow.getX()+enemigoYellow.getWidth()/2-boom.getWidth()/2,
							enemigoYellow.getY()+enemigoYellow.getHeight()/2-boom.getHeight()/2);
					stage.addActor(boom);
					stage.getActors().removeValue(shield, false);
					game.hitSound.play();
					dropShield = true;
				
		
				}
		
					for(int j = 0; j < lasers.size(); j++){
						laser = lasers.get(j);
						if(laser.getBb().overlaps(enemigoYellow.getBb())){
							// Colisión enemigo-láser
							lasers.get(j).remove();
							lasers.remove(j);
							game.explosionSound.play();
							enemigoYellow.setContador(enemigoYellow.getContador()+1);
							if(enemigoYellow.getContador()==15){
								Random random = new Random();
							    int index = random.nextInt(booleans.size());
							    Boolean m = booleans.get(index);
							    if(m){
							    	if(energia.getEnergia()==0 && drop){
							    		dropMunicion(enemigoYellow, municion1, 1);
							    	}else if(energia.getEnergia()==1 && drop){
							    		dropMunicion(enemigoYellow, municion2, 2);
							    	}else if(energia.getEnergia()==2 && drop){
							    		dropMunicion(enemigoYellow, municion3, 3);
							    	}else if(energia.getEnergia()==3 && drop){
							    		dropMunicion(enemigoYellow, municion4, 4);
							    	}else if(energia.getEnergia()==4 && drop){
							    		dropMunicion(enemigoYellow, municion5, 5);
							    	}else if(energia.getEnergia()==5 && drop){
							    		dropMunicion(enemigoYellow, municion6, 6);
							    	}
							    }
							    Random random2 = new Random();
							    int index2 = random2.nextInt(booleans2.size());
							    Boolean e = booleans2.get(index2);
							    if(e&&dropShield){
							    	dropEscudo(enemigoYellow);
							    	dropShield = false;
							    }
								
								enemigosYellow.get(i).remove();
								enemigosYellow.remove(i);
								BoomActor boom = new BoomActor();
								boom.setPosition(enemigoYellow.getX()+
										enemigoYellow.getWidth()/2-boom.getWidth()/2,
										enemigoYellow.getY()+enemigoYellow.getHeight()/2-boom.getHeight()/2);
								stage.addActor(boom);
								puntuacion.setPuntuacion(puntuacion.getPuntuacion()+100);
								
							}
							
						}
					}
				}
			
			
			for(int i = 0; i < enemigosRed.size(); i++){
				enemigoRed = enemigosRed.get(i);
				if(enemigoRed.getBb().overlaps(nave.getBb())&&
						!stage.getActors().contains(shield, false)){
					// Colisión enemigo-nave
					enemigosRed.get(i).remove();
					enemigosRed.remove(i);
					game.explosion.play();
					game.ufoSound.stop();
					BoomActor boom = new BoomActor();
					boom.setPosition(nave.getX()+nave.getWidth()/2-boom.getWidth()/2,
							nave.getY()+nave.getHeight()/2-boom.getHeight()/2);
					nave.remove();
					stage.addActor(boom);
					timerGameOver = 0.4f;
					if (puntuacion.getPuntuacion() > Preferencias.getMayorPuntuacion()){
						Preferencias.setMayorPuntuacion(puntuacion.getPuntuacion());					
					}
				}else if(stage.getActors().contains(shield, false)&&
						enemigoRed.getBb().overlaps(nave.getBb())&&
						shield.getTipo()==2){
					enemigosRed.get(i).remove();
					enemigosRed.remove(i);
					BoomActor boom = new BoomActor();
					boom.setPosition(enemigoRed.getX()+enemigoRed.getWidth()/2-boom.getWidth()/2,
							enemigoRed.getY()+enemigoRed.getHeight()/2-boom.getHeight()/2);
					stage.addActor(boom);
					stage.getActors().removeValue(shield, false);
					shield = new ShieldActor(new Texture("shield1.png"), 1);
					stage.addActor(shield);
					game.hitSound.play();
				}else if(stage.getActors().contains(shield, false)&&
						enemigoRed.getBb().overlaps(nave.getBb())&&
						shield.getTipo()==1){
					enemigosRed.get(i).remove();
					enemigosRed.remove(i);
					BoomActor boom = new BoomActor();
					boom.setPosition(enemigoRed.getX()+enemigoRed.getWidth()/2-boom.getWidth()/2,
							enemigoRed.getY()+enemigoRed.getHeight()/2-boom.getHeight()/2);
					stage.addActor(boom);
					stage.getActors().removeValue(shield, false);
					game.hitSound.play();
					dropShield = true;
				

				}

					for(int j = 0; j < lasers.size(); j++){
						laser = lasers.get(j);
						if(laser.getBb().overlaps(enemigoRed.getBb())){
							// Colisión enemigo-láser
							lasers.get(j).remove();
							lasers.remove(j);
							game.explosionSound.play();
							enemigoRed.setContador(enemigoRed.getContador()+1);
							if(enemigoRed.getContador()==10){
								Random random = new Random();
							    int index = random.nextInt(booleans.size());
							    Boolean m = booleans.get(index);
							    if(m){
							    	if(energia.getEnergia()==0 && drop){
							    		dropMunicion(enemigoRed, municion1, 1);
							    	}else if(energia.getEnergia()==1 && drop){
							    		dropMunicion(enemigoRed, municion2, 2);
							    	}else if(energia.getEnergia()==2 && drop){
							    		dropMunicion(enemigoRed, municion3, 3);
							    	}else if(energia.getEnergia()==3 && drop){
							    		dropMunicion(enemigoRed, municion4, 4);
							    	}else if(energia.getEnergia()==4 && drop){
							    		dropMunicion(enemigoRed, municion5, 5);
							    	}else if(energia.getEnergia()==5 && drop){
							    		dropMunicion(enemigoRed, municion6, 6);
							    	}
							    }
							    Random random2 = new Random();
							    int index2 = random2.nextInt(booleans2.size());
							    Boolean e = booleans2.get(index2);
							    if(e&&dropShield){
							    	dropEscudo(enemigoRed);
							    	dropShield = false;
							    }
								
								enemigosRed.get(i).remove();
								enemigosRed.remove(i);
								BoomActor boom = new BoomActor();
								boom.setPosition(enemigoRed.getX()+
										enemigoRed.getWidth()/2-boom.getWidth()/2,
										enemigoRed.getY()+enemigoRed.getHeight()/2-boom.getHeight()/2);
								stage.addActor(boom);
								puntuacion.setPuntuacion(puntuacion.getPuntuacion()+100);
								redDead++;
								if(redDead == 10 ){
									for(int g = 0; g<enemigosRed.size(); g++){
										BoomActor boomRed = new BoomActor();
										boomRed.setPosition(enemigosRed.get(g).getX()+
												enemigosRed.get(g).getWidth()/2-boomRed.getWidth()/2,
												enemigosRed.get(g).getY()+
												enemigosRed.get(g).getHeight()/2-boomRed.getHeight()/2);
										enemigosRed.get(g).remove();
										enemigosRed.remove(g);
										stage.addActor(boomRed);
									}
									stage.getActors().removeValue(ufo, false);
									clear = new Image(new Texture("clear.png"));
									clear.setPosition(stage.getWidth()/2 - clear.getWidth()/2,
											stage.getHeight()/2 - clear.getHeight()/2);
									stage.addActor(clear);
									timerFin = 3;
									timerFin2 = 0;
									timerFin3 = 0;
									timerFin4 = 0;
									timerFin5 = 0;
									timerUfo = 10000;
									timerRed = 10000;
									timerStage6 = 5;
									timerEnemigoStage6 = 7;
									timerEnemigoStage62 = 11;
									timerEnemigoStage63 = 14;
									timerEnemigoStage64 = 16.5f;
									timerEnemigoStage65 = 18.5f;
									timerFinStage6 =25;
									timerStage7=29;
									timerClear6 = 23;
									timerEnemigoStage7 = 32;
									
								}
							}
						}
					}
				}
			
			
			

			for(int i = 0; i < enemigosStage6.size(); i++){
				enemigoStage6 = enemigosStage6.get(i);
				if(enemigoStage6.getBb().overlaps(nave.getBb())&&
						!stage.getActors().contains(shield, false)){
					// Colisión enemigo-nave
					enemigosStage6.get(i).remove();
					enemigosStage6.remove(i);
					game.explosion.play();
					game.ufoSound.stop();
					BoomActor boom = new BoomActor();
					boom.setPosition(nave.getX()+nave.getWidth()/2-boom.getWidth()/2,
							nave.getY()+nave.getHeight()/2-boom.getHeight()/2);
					nave.remove();
					stage.addActor(boom);
					timerGameOver = 0.4f;
					if (puntuacion.getPuntuacion() > Preferencias.getMayorPuntuacion()){
						Preferencias.setMayorPuntuacion(puntuacion.getPuntuacion());					
					}
				}else if(stage.getActors().contains(shield, false)&&
						enemigoStage6.getBb().overlaps(nave.getBb())&&
						shield.getTipo()==2){
					enemigosStage6.get(i).remove();
					enemigosStage6.remove(i);
					BoomActor boom = new BoomActor();
					boom.setPosition(enemigoStage6.getX()+enemigoStage6.getWidth()/2-boom.getWidth()/2,
							enemigoStage6.getY()+enemigoStage6.getHeight()/2-boom.getHeight()/2);
					stage.addActor(boom);
					stage.getActors().removeValue(shield, false);
					shield = new ShieldActor(new Texture("shield1.png"), 1);
					stage.addActor(shield);
					game.hitSound.play();
				}else if(stage.getActors().contains(shield, false)&&
						enemigoStage6.getBb().overlaps(nave.getBb())&&
						shield.getTipo()==1){
					enemigosStage6.get(i).remove();
					enemigosStage6.remove(i);
					BoomActor boom = new BoomActor();
					boom.setPosition(enemigoStage6.getX()+enemigoStage6.getWidth()/2-boom.getWidth()/2,
							enemigoStage6.getY()+enemigoStage6.getHeight()/2-boom.getHeight()/2);
					stage.addActor(boom);
					stage.getActors().removeValue(shield, false);
					game.hitSound.play();
					dropShield = true;
				

				}
				

							
				}
			
			
//		if(timerFinStage6 < 0){
//				
//				clear = new Image(new Texture("clear.png"));
//				clear.setPosition(stage.getWidth()/2 - clear.getWidth()/2,
//						stage.getHeight()/2 - clear.getHeight()/2);
//				stage.addActor(clear);
//				
//			timerFin = 3;
//			timerFin2 = 0;
//			timerFin3 = 0;
//			timerFin4 = 0;
//			timerFin5 = 0;
//			timerFin6 = 0;
//
//			
//		}
			

			
			for(int i = 0; i < enemigosStage7.size(); i++){
				enemigoStage7 = enemigosStage7.get(i);
				
				if(contadorFinFase7<0){
					stage.getActors().removeValue(ufo, false);
					clear = new Image(new Texture("clear.png"));
					clear.setPosition(stage.getWidth()/2 - clear.getWidth()/2,
							stage.getHeight()/2 - clear.getHeight()/2);
					stage.addActor(clear);
					timerFin = 3;
					timerFin2 = 0;
					timerFin3 = 0;
					timerFin4 = 0;
					timerFin5 = 0;
					timerFin7 = 0;
					timerStage8=0;
					timerFinStage6 =10000;
					timerEnemigoStage7 = 10000;
					contadorFinFase7 = 10000;
					timerDisparoEnemigoStage7 = 3;
				}
				if(enemigoStage7.getBb().overlaps(nave.getBb())&&
						!stage.getActors().contains(shield, false)){
					// Colisión enemigo-nave
					
					enemigosStage7.get(i).remove();
					enemigosStage7.remove(i);
					
					game.explosion.play();
					game.ufoSound.stop();
					
					
					BoomActor boom = new BoomActor();
					boom.setPosition(nave.getX()+nave.getWidth()/2-boom.getWidth()/2,
							nave.getY()+nave.getHeight()/2-boom.getHeight()/2);
					nave.remove();
					stage.addActor(boom);
					timerGameOver = 0.4f;
					int prueba =  Preferencias.getMayorPuntuacion();
					if (puntuacion.getPuntuacion() > prueba){
						Preferencias.setMayorPuntuacion(puntuacion.getPuntuacion());					
					}
				}else if(stage.getActors().contains(shield, false)&&
						enemigoStage7.getBb().overlaps(nave.getBb())&&
						shield.getTipo()==2){
					enemigosStage7.get(i).remove();
					enemigosStage7.remove(i);
					BoomActor boom = new BoomActor();
					boom.setPosition(enemigoStage7.getX()+enemigoStage7.getWidth()/2-boom.getWidth()/2,
							enemigoStage7.getY()+enemigoStage7.getHeight()/2-boom.getHeight()/2);
					stage.addActor(boom);
					stage.getActors().removeValue(shield, false);
					shield = new ShieldActor(new Texture("shield1.png"), 1);
					stage.addActor(shield);
					game.hitSound.play();
				}else if(stage.getActors().contains(shield, false)&&
						enemigoStage7.getBb().overlaps(nave.getBb())&&
						shield.getTipo()==1){
					enemigosStage7.get(i).remove();
					enemigosStage7.remove(i);
					BoomActor boom = new BoomActor();
					boom.setPosition(enemigoStage7.getX()+enemigoStage7.getWidth()/2-boom.getWidth()/2,
							enemigoStage7.getY()+enemigoStage7.getHeight()/2-boom.getHeight()/2);
					stage.addActor(boom);
					stage.getActors().removeValue(shield, false);
					game.hitSound.play();
					dropShield = true;
				}
					for(int j = 0; j < lasers.size(); j++){
						laser = lasers.get(j);
						if(laser.getBb().overlaps(enemigoStage7.getBb())){
							// Colisión enemigoStage7-láser
							lasers.get(j).remove();
							lasers.remove(j);
							game.explosionSound.play();
							enemigoStage7.setContador(enemigoStage7.getContador()+1);
							if(enemigoStage7.getContador()==20){
								Random random = new Random();
							    int index = random.nextInt(booleans.size());
							    Boolean m = booleans.get(index);
							    if(m){
							    	if(energia.getEnergia()==0 && drop){
							    		dropMunicion(enemigoStage7, municion1, 1);
							    	}else if(energia.getEnergia()==1 && drop){
							    		dropMunicion(enemigoStage7, municion2, 2);
							    	}else if(energia.getEnergia()==2 && drop){
							    		dropMunicion(enemigoStage7, municion3, 3);
							    	}else if(energia.getEnergia()==3 && drop){
							    		dropMunicion(enemigoStage7, municion4, 4);
							    	}else if(energia.getEnergia()==4 && drop){
							    		dropMunicion(enemigoStage7, municion5, 5);
							    	}else if(energia.getEnergia()==5 && drop){
							    		dropMunicion(enemigoStage7, municion6, 6);
							    	}
							    }
							    Random random2 = new Random();
							    
							    int index2 = random2.nextInt(booleans2.size());
							    Boolean e = booleans2.get(index2);
							    if(e&&dropShield){
							    	dropEscudo(enemigoStage7);
							    	dropShield = false;
							    }
							    
								enemigosStage7.get(i).remove();
								enemigosStage7.remove(i);
								BoomActor boom = new BoomActor();
								boom.setPosition(enemigoStage7.getX()+enemigoStage7.getWidth()/2-boom.getWidth()/2,
										enemigoStage7.getY()+enemigoStage7.getHeight()/2-boom.getHeight()/2);
								stage.addActor(boom);
								puntuacion.setPuntuacion(puntuacion.getPuntuacion()+100);
		
							}
							
					
						}		

						
						
					}
				}
	
	
			}
		




	public void ir(){
		float x1 = Gdx.input.getX() - nave.getWidth()*0.5f;
		float y1 = Gdx.graphics.getHeight() - Gdx.input.getY() - nave.getHeight()*0.5f;
		nave.setPosition(x1, y1);
	}

	public void irEscudo(){
		float x2 = nave.getX() - nave.getWidth()*0.20f;
		float y2 = nave.getY() - nave.getHeight()*0.20f;
		shield.setPosition(x2, y2);
	}

	
	
	private void spawnEnemigos(){
	    enemigo2.setPosition(stage.getWidth(), stage.getHeight()-462);
		enemigo2.getBb().setX(enemigo2.getX());
		enemigo2.getBb().setY(enemigo2.getY());
		enemigo7.setPosition(enemigo2.getX()+enemigo2.getWidth()+20, stage.getHeight()-462);
		enemigo7.getBb().setX(enemigo7.getX());
		enemigo7.getBb().setY(enemigo7.getY());
		enemigo12.setPosition(enemigo7.getX()+enemigo7.getWidth()+20, stage.getHeight()-462);
		enemigo12.getBb().setX(enemigo12.getX());
		enemigo12.getBb().setY(enemigo12.getY());
		enemigo17.setPosition(enemigo12.getX()+enemigo12.getWidth()+20, stage.getHeight()-462);
		enemigo17.getBb().setX(enemigo17.getX());
		enemigo17.getBb().setY(enemigo17.getY());
		enemigo22.setPosition(enemigo17.getX()+enemigo17.getWidth()+20, stage.getHeight()-462);
		enemigo22.getBb().setX(enemigo22.getX());
		enemigo22.getBb().setY(enemigo22.getY());
		
		
		
		stage.addActor(enemigo2);
		enemigos.add(enemigo2);
		stage.addActor(enemigo7);
		enemigos.add(enemigo7);
		stage.addActor(enemigo12);
		enemigos.add(enemigo12);
		stage.addActor(enemigo17);
		enemigos.add(enemigo17);
		stage.addActor(enemigo22);
		enemigos.add(enemigo22);
		
		enemigo2.addAction(Actions.sequence(Actions.moveBy(-720+75, 0, 1.5f), Actions.delay(2.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));
		enemigo7.addAction(Actions.sequence(Actions.moveBy(-720+75, 0, 1.5f), Actions.delay(2.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));
		enemigo12.addAction(Actions.sequence(Actions.moveBy(-720+75, 0, 1.5f), Actions.delay(2.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));
		enemigo17.addAction(Actions.sequence(Actions.moveBy(-720+75, 0, 1.5f), Actions.delay(2.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));
		enemigo22.addAction(Actions.sequence(Actions.moveBy(-720+75, 0, 1.5f), Actions.delay(2.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));
		
		

		timer = 10000;
	}
	
	private void spawnEnemigos2(){
		enemigo4.setPosition(-enemigo4.getWidth(), stage.getHeight()-358);
		enemigo4.getBb().setX(enemigo4.getX());
		enemigo4.getBb().setY(enemigo4.getY());
		enemigo9.setPosition(enemigo4.getX()-enemigo9.getWidth()-20, stage.getHeight()-358);
		enemigo9.getBb().setX(enemigo9.getX());
		enemigo9.getBb().setY(enemigo9.getY());
		enemigo14.setPosition(enemigo9.getX()-enemigo14.getWidth()-20, stage.getHeight()-358);
		enemigo14.getBb().setX(enemigo14.getX());
		enemigo14.getBb().setY(enemigo14.getY());
		enemigo19.setPosition(enemigo14.getX()-enemigo19.getWidth()-20, stage.getHeight()-358);
		enemigo19.getBb().setX(enemigo19.getX());
		enemigo19.getBb().setY(enemigo19.getY());
		enemigo24.setPosition(enemigo19.getX()-enemigo24.getWidth()-20, stage.getHeight()-358);
		enemigo24.getBb().setX(enemigo24.getX());
		enemigo24.getBb().setY(enemigo24.getY());
		
		stage.addActor(enemigo4);
		enemigos.add(enemigo4);
		stage.addActor(enemigo9);
		enemigos.add(enemigo9);
		stage.addActor(enemigo14);
		enemigos.add(enemigo14);
		stage.addActor(enemigo19);
		enemigos.add(enemigo19);
		stage.addActor(enemigo24);
		enemigos.add(enemigo24);
		
		enemigo4.addAction(Actions.sequence(Actions.moveBy(720-75, 0, 1.5f), Actions.delay(2), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));
		enemigo9.addAction(Actions.sequence(Actions.moveBy(720-75, 0, 1.5f), Actions.delay(2), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));
		enemigo14.addAction(Actions.sequence(Actions.moveBy(720-75, 0, 1.5f), Actions.delay(2), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));
		enemigo19.addAction(Actions.sequence(Actions.moveBy(720-75, 0, 1.5f), Actions.delay(2), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));
		enemigo24.addAction(Actions.sequence(Actions.moveBy(720-75, 0, 1.5f), Actions.delay(2), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));

		timer2 = 10000;
	}
	
	private void spawnEnemigos3(){
		enemigo1.setPosition(stage.getWidth(), stage.getHeight()-254);
		enemigo1.getBb().setX(enemigo1.getX());
		enemigo1.getBb().setY(enemigo1.getY());
		enemigo6.setPosition(enemigo1.getX()+enemigo1.getWidth()+20, stage.getHeight()-254);
		enemigo6.getBb().setX(enemigo6.getX());
		enemigo6.getBb().setY(enemigo6.getY());
		enemigo11.setPosition(enemigo6.getX()+enemigo6.getWidth()+20, stage.getHeight()-254);
		enemigo11.getBb().setX(enemigo11.getX());
		enemigo11.getBb().setY(enemigo11.getY());
		enemigo16.setPosition(enemigo11.getX()+enemigo11.getWidth()+20, stage.getHeight()-254);
		enemigo16.getBb().setX(enemigo16.getX());
		enemigo16.getBb().setY(enemigo16.getY());
		enemigo21.setPosition(enemigo16.getX()+enemigo16.getWidth()+20, stage.getHeight()-254);
		enemigo21.getBb().setX(enemigo21.getX());
		enemigo21.getBb().setY(enemigo21.getY());
		
		stage.addActor(enemigo1);
		enemigos.add(enemigo1);
		stage.addActor(enemigo6);
		enemigos.add(enemigo6);
		stage.addActor(enemigo11);
		enemigos.add(enemigo11);
		stage.addActor(enemigo16);
		enemigos.add(enemigo16);
		stage.addActor(enemigo21);
		enemigos.add(enemigo21);
		
		enemigo1.addAction(Actions.sequence(Actions.moveBy(-720+75, 0, 1.5f), Actions.delay(1.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));
		enemigo6.addAction(Actions.sequence(Actions.moveBy(-720+75, 0, 1.5f), Actions.delay(1.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));
		enemigo11.addAction(Actions.sequence(Actions.moveBy(-720+75, 0, 1.5f), Actions.delay(1.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));
		enemigo16.addAction(Actions.sequence(Actions.moveBy(-720+75, 0, 1.5f), Actions.delay(1.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));
		enemigo21.addAction(Actions.sequence(Actions.moveBy(-720+75, 0, 1.5f), Actions.delay(1.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));

		timer3 = 10000;
	}
	
	private void spawnEnemigos4(){
		enemigo5.setPosition(-enemigo5.getWidth(), stage.getHeight()-150);
		enemigo5.getBb().setX(enemigo5.getX());
		enemigo5.getBb().setY(enemigo5.getY());
		enemigo10.setPosition(enemigo5.getX()-enemigo10.getWidth()-20, stage.getHeight()-150);
		enemigo10.getBb().setX(enemigo10.getX());
		enemigo10.getBb().setY(enemigo10.getY());
		enemigo15.setPosition(enemigo10.getX()-enemigo15.getWidth()-20, stage.getHeight()-150);
		enemigo15.getBb().setX(enemigo15.getX());
		enemigo15.getBb().setY(enemigo15.getY());
		enemigo20.setPosition(enemigo15.getX()-enemigo20.getWidth()-20, stage.getHeight()-150);
		enemigo20.getBb().setX(enemigo20.getX());
		enemigo20.getBb().setY(enemigo20.getY());
		enemigo25.setPosition(enemigo20.getX()-enemigo25.getWidth()-20, stage.getHeight()-150);
		enemigo25.getBb().setX(enemigo25.getX());
		enemigo25.getBb().setY(enemigo25.getY());
		
		stage.addActor(enemigo5);
		enemigos.add(enemigo5);
		stage.addActor(enemigo10);
		enemigos.add(enemigo10);
		stage.addActor(enemigo15);
		enemigos.add(enemigo15);
		stage.addActor(enemigo20);
		enemigos.add(enemigo20);
		stage.addActor(enemigo25);
		enemigos.add(enemigo25);
		
		enemigo5.addAction(Actions.sequence(Actions.moveBy(720-75, 0, 1.5f), Actions.delay(1), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));
		enemigo10.addAction(Actions.sequence(Actions.moveBy(720-75, 0, 1.5f), Actions.delay(1), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));
		enemigo15.addAction(Actions.sequence(Actions.moveBy(720-75, 0, 1.5f), Actions.delay(1), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));
		enemigo20.addAction(Actions.sequence(Actions.moveBy(720-75, 0, 1.5f), Actions.delay(1), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));
		enemigo25.addAction(Actions.sequence(Actions.moveBy(720-75, 0, 1.5f), Actions.delay(1), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(1), Actions.moveBy(50, 0, 1), Actions.delay(1)))));

		timer4 = 10000;
	}
	
	private void spawnEnemigosBlue(){
		enemigoBlue1.setPosition(75, stage.getHeight());
		enemigoBlue1.getBb().setX(enemigoBlue1.getX());
		enemigoBlue1.getBb().setY(enemigoBlue1.getY());
		enemigoBlue5.setPosition(enemigoBlue1.getX()+enemigoBlue5.getWidth()+20, stage.getHeight());
		enemigoBlue5.getBb().setX(enemigoBlue5.getX());
		enemigoBlue5.getBb().setY(enemigoBlue5.getY());
		enemigoBlue9.setPosition(enemigoBlue5.getX()+enemigoBlue9.getWidth()+20, stage.getHeight());
		enemigoBlue9.getBb().setX(enemigoBlue9.getX());
		enemigoBlue9.getBb().setY(enemigoBlue9.getY());
		enemigoBlue13.setPosition(enemigoBlue9.getX()+enemigoBlue13.getWidth()+20, stage.getHeight());
		enemigoBlue13.getBb().setX(enemigoBlue13.getX());
		enemigoBlue13.getBb().setY(enemigoBlue13.getY());
		enemigoBlue17.setPosition(enemigoBlue13.getX()+enemigoBlue17.getWidth()+20, stage.getHeight());
		enemigoBlue17.getBb().setX(enemigoBlue17.getX());
		enemigoBlue17.getBb().setY(enemigoBlue17.getY());
		
		
		
		stage.addActor(enemigoBlue1);
		enemigosBlue.add(enemigoBlue1);
		stage.addActor(enemigoBlue5);
		enemigosBlue.add(enemigoBlue5);
		stage.addActor(enemigoBlue9);
		enemigosBlue.add(enemigoBlue9);
		stage.addActor(enemigoBlue13);
		enemigosBlue.add(enemigoBlue13);
		stage.addActor(enemigoBlue17);
		enemigosBlue.add(enemigoBlue17);
		
		enemigoBlue1.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(2.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						 Actions.moveBy(0, -50, 1),
						Actions.moveBy(50, 0, 1), 
						Actions.moveBy(0, 50, 1)))));
		enemigoBlue5.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(2.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.moveBy(0, -50, 1),
						Actions.moveBy(50, 0, 1), 
						Actions.moveBy(0, 50, 1)))));
		enemigoBlue9.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(2.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						 Actions.moveBy(0, -50, 1), 
						Actions.moveBy(50, 0, 1), 
						Actions.moveBy(0, 50, 1)))));
		enemigoBlue13.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(2.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.moveBy(0, -50, 1),
						Actions.moveBy(50, 0, 1), 
						Actions.moveBy(0, 50, 1)))));
		enemigoBlue17.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(2.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.moveBy(0, -50, 1),
						Actions.moveBy(50, 0, 1), 
						Actions.moveBy(0, 50, 1)))));
		
		timerBlue = 10000;
		timerUfo = 15;
		
	}
	
	private void spawnEnemigosBlue2(){
		enemigoBlue2.setPosition(75, stage.getHeight() + 84 + 20);
		enemigoBlue2.getBb().setX(enemigoBlue2.getX());
		enemigoBlue2.getBb().setY(enemigoBlue2.getY());
		enemigoBlue6.setPosition(enemigoBlue2.getX()+enemigoBlue6.getWidth()+20, stage.getHeight()
				+ 84 + 20);
		enemigoBlue6.getBb().setX(enemigoBlue6.getX());
		enemigoBlue6.getBb().setY(enemigoBlue6.getY());
		enemigoBlue10.setPosition(enemigoBlue6.getX()+enemigoBlue10.getWidth()+20, stage.getHeight()
				+ 84 + 20);
		enemigoBlue10.getBb().setX(enemigoBlue10.getX());
		enemigoBlue10.getBb().setY(enemigoBlue10.getY());
		enemigoBlue14.setPosition(enemigoBlue10.getX()+enemigoBlue14.getWidth()+20, stage.getHeight()
				+ 84 + 20);
		enemigoBlue14.getBb().setX(enemigoBlue14.getX());
		enemigoBlue14.getBb().setY(enemigoBlue14.getY());
		enemigoBlue18.setPosition(enemigoBlue14.getX()+enemigoBlue18.getWidth()+20, stage.getHeight()
				+ 84 + 20);
		enemigoBlue18.getBb().setX(enemigoBlue18.getX());
		enemigoBlue18.getBb().setY(enemigoBlue18.getY());
		
		
		
		stage.addActor(enemigoBlue2);
		enemigosBlue.add(enemigoBlue2);
		stage.addActor(enemigoBlue6);
		enemigosBlue.add(enemigoBlue6);
		stage.addActor(enemigoBlue10);
		enemigosBlue.add(enemigoBlue10);
		stage.addActor(enemigoBlue14);
		enemigosBlue.add(enemigoBlue14);
		stage.addActor(enemigoBlue18);
		enemigosBlue.add(enemigoBlue18);
		
		enemigoBlue2.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(2), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.moveBy(0, -50, 1),
						Actions.moveBy(50, 0, 1), 
						Actions.moveBy(0, 50, 1)))));
		enemigoBlue6.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(2), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.moveBy(0, -50, 1),
						Actions.moveBy(50, 0, 1), 
						Actions.moveBy(0, 50, 1)))));
		enemigoBlue10.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(2), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.moveBy(0, -50, 1), 
						Actions.moveBy(50, 0, 1),  
						Actions.moveBy(0, 50, 1)))));
		enemigoBlue14.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(2), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.moveBy(0, -50, 1),
						Actions.moveBy(50, 0, 1), 
						Actions.moveBy(0, 50, 1)))));
		enemigoBlue18.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(2), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.moveBy(0, -50, 1),
						Actions.moveBy(50, 0, 1), 
						Actions.moveBy(0, 50, 1)))));
		
		timerBlue2 = 10000;
	}
	
	private void spawnEnemigosBlue3(){
		enemigoBlue3.setPosition(85, stage.getHeight() + 84 + 20 + 84 + 20);
		enemigoBlue3.getBb().setX(enemigoBlue3.getX());
		enemigoBlue3.getBb().setY(enemigoBlue3.getY());
		enemigoBlue7.setPosition(enemigoBlue3.getX()+enemigoBlue7.getWidth()+20, stage.getHeight()
				+ 84 + 20 + 84 + 20);
		enemigoBlue7.getBb().setX(enemigoBlue7.getX());
		enemigoBlue7.getBb().setY(enemigoBlue7.getY());
		enemigoBlue11.setPosition(enemigoBlue7.getX()+enemigoBlue11.getWidth()+20, stage.getHeight()
				+ 84 + 20 + 84 + 20);
		enemigoBlue11.getBb().setX(enemigoBlue11.getX());
		enemigoBlue11.getBb().setY(enemigoBlue11.getY());
		enemigoBlue15.setPosition(enemigoBlue11.getX()+enemigoBlue15.getWidth()+20, stage.getHeight()
				+ 84 + 20 + 84 + 20);
		enemigoBlue15.getBb().setX(enemigoBlue15.getX());
		enemigoBlue15.getBb().setY(enemigoBlue15.getY());
		enemigoBlue19.setPosition(enemigoBlue15.getX()+enemigoBlue19.getWidth()+20, stage.getHeight()
				+ 84 + 20 + 84 + 20);
		enemigoBlue19.getBb().setX(enemigoBlue19.getX());
		enemigoBlue19.getBb().setY(enemigoBlue19.getY());
		
		
		
		stage.addActor(enemigoBlue3);
		enemigosBlue.add(enemigoBlue3);
		stage.addActor(enemigoBlue7);
		enemigosBlue.add(enemigoBlue7);
		stage.addActor(enemigoBlue11);
		enemigosBlue.add(enemigoBlue11);
		stage.addActor(enemigoBlue15);
		enemigosBlue.add(enemigoBlue15);
		stage.addActor(enemigoBlue19);
		enemigosBlue.add(enemigoBlue19);
		
		enemigoBlue3.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(1.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.moveBy(0, -50, 1),
						Actions.moveBy(50, 0, 1), 
						Actions.moveBy(0, 50, 1)))));
		enemigoBlue7.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(1.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.moveBy(0, -50, 1),
						Actions.moveBy(50, 0, 1), 
						Actions.moveBy(0, 50, 1)))));
		enemigoBlue11.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(1.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.moveBy(0, -50, 1),
						Actions.moveBy(50, 0, 1), 
						Actions.moveBy(0, 50, 1)))));
		enemigoBlue15.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(1.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.moveBy(0, -50, 1), 
						Actions.moveBy(50, 0, 1), 
						Actions.moveBy(0, 50, 1)))));
		enemigoBlue19.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(1.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.moveBy(0, -50, 1), 
						Actions.moveBy(50, 0, 1),  
						Actions.moveBy(0, 50, 1)))));
		
		timerBlue3 = 10000;
	}
	
	private void spawnEnemigosBlue4(){
		enemigoBlue4.setPosition(75, stage.getHeight() + 84 + 20 + 84 + 20 + 84 + 20);
		enemigoBlue4.getBb().setX(enemigoBlue4.getX());
		enemigoBlue4.getBb().setY(enemigoBlue4.getY());
		enemigoBlue8.setPosition(enemigoBlue4.getX()+enemigoBlue8.getWidth()+20, stage.getHeight()
				+ 84 + 20 + 84 + 20 + 84 + 20);
		enemigoBlue8.getBb().setX(enemigoBlue8.getX());
		enemigoBlue8.getBb().setY(enemigoBlue8.getY());
		enemigoBlue12.setPosition(enemigoBlue8.getX()+enemigoBlue12.getWidth()+20, stage.getHeight()
				+ 84 + 20 + 84 + 20 + 84 + 20);
		enemigoBlue12.getBb().setX(enemigoBlue12.getX());
		enemigoBlue12.getBb().setY(enemigoBlue12.getY());
		enemigoBlue16.setPosition(enemigoBlue12.getX()+enemigoBlue16.getWidth()+20, stage.getHeight()
				+ 84 + 20 + 84 + 20 + 84 + 20);
		enemigoBlue16.getBb().setX(enemigoBlue16.getX());
		enemigoBlue16.getBb().setY(enemigoBlue16.getY());
		enemigoBlue20.setPosition(enemigoBlue16.getX()+enemigoBlue20.getWidth()+20, stage.getHeight()
				+ 84 + 20 + 84 + 20 + 84 + 20);
		enemigoBlue20.getBb().setX(enemigoBlue20.getX());
		enemigoBlue20.getBb().setY(enemigoBlue20.getY());
		
		
		
		stage.addActor(enemigoBlue4);
		enemigosBlue.add(enemigoBlue4);
		stage.addActor(enemigoBlue8);
		enemigosBlue.add(enemigoBlue8);
		stage.addActor(enemigoBlue12);
		enemigosBlue.add(enemigoBlue12);
		stage.addActor(enemigoBlue16);
		enemigosBlue.add(enemigoBlue16);
		stage.addActor(enemigoBlue20);
		enemigosBlue.add(enemigoBlue20);
		
		enemigoBlue4.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(1), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.moveBy(0, -50, 1),
						Actions.moveBy(50, 0, 1),  
						Actions.moveBy(0, 50, 1)))));
		enemigoBlue8.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(1), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.moveBy(0, -50, 1), 
						Actions.moveBy(50, 0, 1),  
						Actions.moveBy(0, 50, 1)))));
		enemigoBlue12.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(1), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.moveBy(0, -50, 1),
						Actions.moveBy(50, 0, 1), 
						Actions.moveBy(0, 50, 1)))));
		enemigoBlue16.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(1), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.moveBy(0, -50, 1),
						Actions.moveBy(50, 0, 1), 
						Actions.moveBy(0, 50, 1)))));
		enemigoBlue20.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(1), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.moveBy(0, -50, 1),
						Actions.moveBy(50, 0, 1), 
						Actions.moveBy(0, 50, 1)))));
		
		timerBlue4 = 10000;
	}
	
	private void spawnEnemigosGreen(){
		EnemigoActor enemigoGreen1 = new EnemigoActor(new Texture("enemyGreen1.png"));
		EnemigoActor enemigoGreen2 = new EnemigoActor(new Texture("enemyGreen2.png"));
		EnemigoActor enemigoGreen3 = new EnemigoActor(new Texture("enemyGreen3.png"));
		EnemigoActor enemigoGreen4 = new EnemigoActor(new Texture("enemyGreen4.png"));
		EnemigoActor enemigoGreen5 = new EnemigoActor(new Texture("enemyGreen5.png"));
		
		List<EnemigoActor> enemigosGreen1 = new ArrayList<EnemigoActor>();
		enemigosGreen1.add(enemigoGreen1);
		enemigosGreen1.add(enemigoGreen2);
		enemigosGreen1.add(enemigoGreen3);
		enemigosGreen1.add(enemigoGreen4);
		enemigosGreen1.add(enemigoGreen5);
		
		Random random = new Random();
	    int index = random.nextInt(enemigosGreen1.size());
	    EnemigoActor e = enemigosGreen1.get(index);
	    
	    e.setPosition((float) ((stage.getWidth()-e.getWidth())*Math.random()), stage.getHeight());
	    e.getBb().setX(e.getX());
		e.getBb().setY(e.getY());
		
	    enemigosGreen.add(e);
	    
	    stage.addActor(e);
	    
	    List<Integer> velocidades = new ArrayList<Integer>();
	    velocidades.add(-3);
	    velocidades.add(-4);
	    velocidades.add(-5);
	    velocidades.add(-6);
	    Random random2 = new Random();
	    int index2 = random2.nextInt(velocidades.size());
	    Integer i = velocidades.get(index2);
	    e.addAction(Actions.forever(Actions.moveBy(0, i)));
	    
	    timerGreen = 0.8f;
		
	}
	
	private void spawnEnemigosYellow(){
		EnemigoActor enemigoYellow1 = new EnemigoActor(new Texture("enemyRed1.png"));
		EnemigoActor enemigoYellow2 = new EnemigoActor(new Texture("enemyRed1.png"));
		EnemigoActor enemigoYellow3 = new EnemigoActor(new Texture("enemyRed1.png"));
		EnemigoActor enemigoYellow4 = new EnemigoActor(new Texture("enemyRed1.png"));
		EnemigoActor enemigoYellow5 = new EnemigoActor(new Texture("enemyRed1.png"));
		

		EnemigoActor enemigoYellow6 = new EnemigoActor(new Texture("enemyRed2.png"));
		EnemigoActor enemigoYellow7 = new EnemigoActor(new Texture("enemyRed2.png"));
		EnemigoActor enemigoYellow8 = new EnemigoActor(new Texture("enemyRed2.png"));
		EnemigoActor enemigoYellow9 = new EnemigoActor(new Texture("enemyRed2.png"));
		EnemigoActor enemigoYellow10 = new EnemigoActor(new Texture("enemyRed2.png"));

		EnemigoActor enemigoYellow11 = new EnemigoActor(new Texture("enemyRed3.png"));
		EnemigoActor enemigoYellow12 = new EnemigoActor(new Texture("enemyRed3.png"));
		EnemigoActor enemigoYellow13 = new EnemigoActor(new Texture("enemyRed3.png"));
		EnemigoActor enemigoYellow14 = new EnemigoActor(new Texture("enemyRed3.png"));
		EnemigoActor enemigoYellow15 = new EnemigoActor(new Texture("enemyRed3.png"));
		

		EnemigoActor enemigoYellow16 = new EnemigoActor(new Texture("enemyRed4.png"));
		EnemigoActor enemigoYellow17 = new EnemigoActor(new Texture("enemyRed4.png"));
		EnemigoActor enemigoYellow18 = new EnemigoActor(new Texture("enemyRed4.png"));
		EnemigoActor enemigoYellow19 = new EnemigoActor(new Texture("enemyRed4.png"));
		EnemigoActor enemigoYellow20 = new EnemigoActor(new Texture("enemyRed4.png"));
		
		enemigoYellow1.setPosition(-enemigoYellow1.getWidth(), stage.getHeight()-150);
		enemigoYellow1.getBb().setX(enemigoYellow1.getX());
		enemigoYellow1.getBb().setY(enemigoYellow1.getY());
		enemigoYellow2.setPosition(-enemigoYellow2.getWidth(), stage.getHeight()-150);
		enemigoYellow2.getBb().setX(enemigoYellow2.getX());
		enemigoYellow2.getBb().setY(enemigoYellow2.getY());
		enemigoYellow3.setPosition(-enemigoYellow3.getWidth(), stage.getHeight()-150);
		enemigoYellow3.getBb().setX(enemigoYellow3.getX());
		enemigoYellow3.getBb().setY(enemigoYellow3.getY());
		enemigoYellow4.setPosition(-enemigoYellow4.getWidth(), stage.getHeight()-150);
		enemigoYellow4.getBb().setX(enemigoYellow4.getX());
		enemigoYellow4.getBb().setY(enemigoYellow4.getY());
		enemigoYellow5.setPosition(-enemigoYellow5.getWidth(), stage.getHeight()-150);
		enemigoYellow5.getBb().setX(enemigoYellow5.getX());
		enemigoYellow5.getBb().setY(enemigoYellow5.getY());
		
		enemigoYellow6.setPosition(730, stage.getHeight()-150);
		enemigoYellow6.getBb().setX(enemigoYellow6.getX());
		enemigoYellow6.getBb().setY(enemigoYellow6.getY());	

		enemigoYellow7.setPosition(730, stage.getHeight()-150);
		enemigoYellow7.getBb().setX(enemigoYellow7.getX());
		enemigoYellow7.getBb().setY(enemigoYellow7.getY());	
		
		enemigoYellow8.setPosition(730, stage.getHeight()-150);
		enemigoYellow8.getBb().setX(enemigoYellow8.getX());
		enemigoYellow8.getBb().setY(enemigoYellow8.getY());
		
		enemigoYellow9.setPosition(730, stage.getHeight()-150);
		enemigoYellow9.getBb().setX(enemigoYellow9.getX());
		enemigoYellow9.getBb().setY(enemigoYellow9.getY());
		
		enemigoYellow10.setPosition(730, stage.getHeight()-150);
		enemigoYellow10.getBb().setX(enemigoYellow10.getX());
		enemigoYellow10.getBb().setY(enemigoYellow10.getY());	

		enemigoYellow11.setPosition(-enemigoYellow11.getWidth(), stage.getHeight()-150);
		enemigoYellow11.getBb().setX(enemigoYellow11.getX());
		enemigoYellow11.getBb().setY(enemigoYellow11.getY());
		enemigoYellow12.setPosition(-enemigoYellow12.getWidth(), stage.getHeight()-150);
		enemigoYellow12.getBb().setX(enemigoYellow12.getX());
		enemigoYellow12.getBb().setY(enemigoYellow12.getY());
		enemigoYellow13.setPosition(-enemigoYellow13.getWidth(), stage.getHeight()-150);
		enemigoYellow13.getBb().setX(enemigoYellow13.getX());
		enemigoYellow13.getBb().setY(enemigoYellow13.getY());
		enemigoYellow14.setPosition(-enemigoYellow14.getWidth(), stage.getHeight()-150);
		enemigoYellow14.getBb().setX(enemigoYellow14.getX());
		enemigoYellow14.getBb().setY(enemigoYellow14.getY());
		enemigoYellow15.setPosition(-enemigoYellow15.getWidth(), stage.getHeight()-150);
		enemigoYellow15.getBb().setX(enemigoYellow15.getX());
		enemigoYellow15.getBb().setY(enemigoYellow15.getY());
		
		enemigoYellow16.setPosition(730, stage.getHeight()-150);
		enemigoYellow16.getBb().setX(enemigoYellow16.getX());
		enemigoYellow16.getBb().setY(enemigoYellow16.getY());	

		enemigoYellow17.setPosition(730, stage.getHeight()-150);
		enemigoYellow17.getBb().setX(enemigoYellow17.getX());
		enemigoYellow17.getBb().setY(enemigoYellow17.getY());	
		
		enemigoYellow18.setPosition(730, stage.getHeight()-150);
		enemigoYellow18.getBb().setX(enemigoYellow18.getX());
		enemigoYellow18.getBb().setY(enemigoYellow18.getY());
		
		enemigoYellow19.setPosition(730, stage.getHeight()-150);
		enemigoYellow19.getBb().setX(enemigoYellow19.getX());
		enemigoYellow19.getBb().setY(enemigoYellow19.getY());
		
		enemigoYellow20.setPosition(730, stage.getHeight()-150);
		enemigoYellow20.getBb().setX(enemigoYellow20.getX());
		enemigoYellow20.getBb().setY(enemigoYellow20.getY());
		
		stage.addActor(enemigoYellow1);
		stage.addActor(enemigoYellow2);
		stage.addActor(enemigoYellow3);
		stage.addActor(enemigoYellow4);
		stage.addActor(enemigoYellow5);
		stage.addActor(enemigoYellow6);
		stage.addActor(enemigoYellow7);
		stage.addActor(enemigoYellow8);
		stage.addActor(enemigoYellow9);
		stage.addActor(enemigoYellow10);
		stage.addActor(enemigoYellow11);
		stage.addActor(enemigoYellow12);
		stage.addActor(enemigoYellow13);
		stage.addActor(enemigoYellow14);
		stage.addActor(enemigoYellow15);
		stage.addActor(enemigoYellow16);
		stage.addActor(enemigoYellow17);
		stage.addActor(enemigoYellow18);
		stage.addActor(enemigoYellow19);
		stage.addActor(enemigoYellow20);

		enemigosYellow.add(enemigoYellow1);
		enemigosYellow.add(enemigoYellow2);
		enemigosYellow.add(enemigoYellow3);
		enemigosYellow.add(enemigoYellow4);
		enemigosYellow.add(enemigoYellow5);
		enemigosYellow.add(enemigoYellow6);
		enemigosYellow.add(enemigoYellow7);
		enemigosYellow.add(enemigoYellow8);
		enemigosYellow.add(enemigoYellow9);
		enemigosYellow.add(enemigoYellow10);
		enemigosYellow.add(enemigoYellow11);
		enemigosYellow.add(enemigoYellow12);
		enemigosYellow.add(enemigoYellow13);
		enemigosYellow.add(enemigoYellow14);
		enemigosYellow.add(enemigoYellow15);
		enemigosYellow.add(enemigoYellow16);
		enemigosYellow.add(enemigoYellow17);
		enemigosYellow.add(enemigoYellow18);
		enemigosYellow.add(enemigoYellow19);
		enemigosYellow.add(enemigoYellow20);		

		
		enemigoYellow1.addAction(Actions.sequence(Actions.moveBy(720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627,0,1)))));

		enemigoYellow2.addAction(Actions.sequence(Actions.delay(0.25f), Actions.moveBy(720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627,0,1)))));
	
		enemigoYellow3.addAction(Actions.sequence(Actions.delay(0.50f), Actions.moveBy(720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627,0,1)))));
	
		enemigoYellow4.addAction(Actions.sequence(Actions.delay(0.75f), Actions.moveBy(720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627,0,1)))));

		enemigoYellow5.addAction(Actions.sequence(Actions.delay(1), Actions.moveBy(720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627,0,1)))));

		enemigoYellow6.addAction(Actions.sequence(Actions.delay(6), Actions.moveBy(-720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627,0,1)))));

		enemigoYellow7.addAction(Actions.sequence(Actions.delay(6.25f), Actions.moveBy(-720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627,0,1)))));

		enemigoYellow8.addAction(Actions.sequence(Actions.delay(6.5f), Actions.moveBy(-720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627,0,1)))));

		enemigoYellow9.addAction(Actions.sequence(Actions.delay(6.75f), Actions.moveBy(-720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627,0,1)))));

		enemigoYellow10.addAction(Actions.sequence(Actions.delay(7), Actions.moveBy(-720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627,0,1)))));

		enemigoYellow11.addAction(Actions.sequence(Actions.delay(12), Actions.moveBy(720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627,0,1)))));

		enemigoYellow12.addAction(Actions.sequence(Actions.delay(12.25f), Actions.moveBy(720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627,0,1)))));
	
		enemigoYellow13.addAction(Actions.sequence(Actions.delay(12.50f), Actions.moveBy(720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627,0,1)))));
	
		enemigoYellow14.addAction(Actions.sequence(Actions.delay(12.75f), Actions.moveBy(720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627,0,1)))));

		enemigoYellow15.addAction(Actions.sequence(Actions.delay(13), Actions.moveBy(720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627,0,1)))));
			

		enemigoYellow16.addAction(Actions.sequence(Actions.delay(18), Actions.moveBy(-720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627,0,1)))));

		enemigoYellow17.addAction(Actions.sequence(Actions.delay(18.25f), Actions.moveBy(-720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627,0,1)))));

		enemigoYellow18.addAction(Actions.sequence(Actions.delay(18.5f), Actions.moveBy(-720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627,0,1)))));

		enemigoYellow19.addAction(Actions.sequence(Actions.delay(18.75f), Actions.moveBy(-720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627,0,1)))));

		enemigoYellow20.addAction(Actions.sequence(Actions.delay(19), Actions.moveBy(-720,0,1),
				Actions.forever(Actions.sequence(Actions.moveBy(0, -100, 0.2f), Actions.moveBy(627, 0, 1),
				Actions.moveBy(0, -100, 0.2f), Actions.moveBy(-627,0,1)))));

		timerYellow = 10000;
	}
	
	private void spawnEnemigosRed(){
		EnemigoActor enemigoRed1 = new EnemigoActor(new Texture("spaceShips_004.png"));
		EnemigoActor enemigoRed2 = new EnemigoActor(new Texture("spaceShips_005.png"));
		EnemigoActor enemigoRed3 = new EnemigoActor(new Texture("spaceShips_006.png"));
		EnemigoActor enemigoRed4 = new EnemigoActor(new Texture("spaceShips_007.png"));
		EnemigoActor enemigoRed5 = new EnemigoActor(new Texture("spaceShips_009.png"));
		
		List<EnemigoActor> enemigosRed1 = new ArrayList<EnemigoActor>();
		enemigosRed1.add(enemigoRed1);
		enemigosRed1.add(enemigoRed2);
		enemigosRed1.add(enemigoRed3);
		enemigosRed1.add(enemigoRed4);
		enemigosRed1.add(enemigoRed5);
		Random random = new Random();
	    int index = random.nextInt(enemigosRed1.size());
	    EnemigoActor e = enemigosRed1.get(index);
	    
	    e.setPosition((float) ((stage.getWidth()-e.getWidth())*Math.random()), stage.getHeight());
	    e.getBb().setX(e.getX());
		e.getBb().setY(e.getY());
		
	    enemigosRed.add(e);
	    
	    stage.addActor(e);
	    
	    List<Integer> velocidades = new ArrayList<Integer>();
	    velocidades.add(-3);
	    velocidades.add(-4);
	    velocidades.add(-5);
	    velocidades.add(-6);
	    Random random2 = new Random();
	    int index2 = random2.nextInt(velocidades.size());
	    Integer i = velocidades.get(index2);
	    
	    e.addAction(Actions.sequence(Actions.moveTo(nave.getRight()/2, nave.getTop()/2, 3),
	    		Actions.forever(Actions.moveBy(0, i))));
	    
	    timerRed = 1;
		
	}
	
	private void spawnEnemigosStage6(){

		EnemigoActor enemigoStage61 = new EnemigoActor(new Texture("enemyblack1.png"));
		EnemigoActor enemigoStage62 = new EnemigoActor(new Texture("enemyblack1.png"));
		EnemigoActor enemigoStage63 = new EnemigoActor(new Texture("enemyblack1.png"));
		EnemigoActor enemigoStage64 = new EnemigoActor(new Texture("enemyblack1.png"));
		EnemigoActor enemigoStage65 = new EnemigoActor(new Texture("enemyblack1.png"));
		EnemigoActor enemigoStage66 = new EnemigoActor(new Texture("enemyblack1.png"));	

		enemigoStage61.setPosition(10, stage.getHeight()+enemigoStage61.getHeight());
		enemigoStage61.getBb().setX(enemigoStage61.getX());
			enemigoStage61.getBb().setY(enemigoStage61.getY());
			
		enemigoStage62.setPosition(enemigoStage61.getWidth()+10, stage.getHeight()+enemigoStage62.getHeight());
		enemigoStage62.getBb().setX(enemigoStage62.getX());
		enemigoStage62.getBb().setY(enemigoStage62.getY());
	
		enemigoStage63.setPosition(enemigoStage62.getX()+enemigoStage62.getWidth()+nave.getWidth()+20, stage.getHeight()+enemigoStage63.getHeight());
		enemigoStage63.getBb().setX(enemigoStage63.getX());
		enemigoStage63.getBb().setY(enemigoStage63.getY());

		enemigoStage64.setPosition(enemigoStage63.getX()+enemigoStage63.getWidth()+10, stage.getHeight()+enemigoStage64.getHeight());
		enemigoStage64.getBb().setX(enemigoStage64.getX());
		enemigoStage64.getBb().setY(enemigoStage64.getY());

		enemigoStage65.setPosition(enemigoStage64.getX()+enemigoStage64.getWidth()+10, stage.getHeight()+enemigoStage65.getHeight());
		enemigoStage65.getBb().setX(enemigoStage65.getX());
		enemigoStage65.getBb().setY(enemigoStage65.getY());


		enemigoStage66.setPosition(enemigoStage65.getX()+enemigoStage65.getWidth()+10, stage.getHeight()+enemigoStage66.getHeight());
		enemigoStage66.getBb().setX(enemigoStage66.getX());
		enemigoStage66.getBb().setY(enemigoStage66.getY());

		stage.addActor(enemigoStage61);
		stage.addActor(enemigoStage62);
		stage.addActor(enemigoStage63);
		stage.addActor(enemigoStage64);
		stage.addActor(enemigoStage65);
		stage.addActor(enemigoStage66);
		enemigosStage6.add(enemigoStage61);
		enemigosStage6.add(enemigoStage62);
		enemigosStage6.add(enemigoStage63);
		enemigosStage6.add(enemigoStage64);
		enemigosStage6.add(enemigoStage65);
		enemigosStage6.add(enemigoStage66);
			
			enemigoStage61.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage62.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage63.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage64.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage65.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage66.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
								
			timerEnemigoStage6 = 10000;
			
		}
	
	private void spawnEnemigosStage62(){

		EnemigoActor enemigoStage61 = new EnemigoActor(new Texture("enemyBlue5.png"));
		EnemigoActor enemigoStage62 = new EnemigoActor(new Texture("enemyBlue5.png"));
		EnemigoActor enemigoStage63 = new EnemigoActor(new Texture("enemyBlue5.png"));
		EnemigoActor enemigoStage64 = new EnemigoActor(new Texture("enemyBlue5.png"));
		EnemigoActor enemigoStage65 = new EnemigoActor(new Texture("enemyBlue5.png"));
		EnemigoActor enemigoStage66 = new EnemigoActor(new Texture("enemyBlue5.png"));	

		enemigoStage61.setPosition(10, stage.getHeight()+enemigoStage61.getHeight());
		enemigoStage61.getBb().setX(enemigoStage61.getX());
			enemigoStage61.getBb().setY(enemigoStage61.getY());
			
		enemigoStage62.setPosition(enemigoStage61.getWidth()+10, stage.getHeight()+enemigoStage62.getHeight());
		enemigoStage62.getBb().setX(enemigoStage62.getX());
		enemigoStage62.getBb().setY(enemigoStage62.getY());
	
		enemigoStage63.setPosition(enemigoStage62.getX()+enemigoStage62.getWidth()+10, stage.getHeight()+enemigoStage63.getHeight());
		enemigoStage63.getBb().setX(enemigoStage63.getX());
		enemigoStage63.getBb().setY(enemigoStage63.getY());

		enemigoStage64.setPosition(enemigoStage63.getX()+enemigoStage63.getWidth()+10, stage.getHeight()+enemigoStage64.getHeight());
		enemigoStage64.getBb().setX(enemigoStage64.getX());
		enemigoStage64.getBb().setY(enemigoStage64.getY());

		enemigoStage65.setPosition(enemigoStage64.getX()+enemigoStage64.getWidth()+10, stage.getHeight()+enemigoStage65.getHeight());
		enemigoStage65.getBb().setX(enemigoStage65.getX());
		enemigoStage65.getBb().setY(enemigoStage65.getY());


		enemigoStage66.setPosition(enemigoStage65.getX()+enemigoStage65.getWidth()+10, stage.getHeight()+enemigoStage66.getHeight());
		enemigoStage66.getBb().setX(enemigoStage66.getX());
		enemigoStage66.getBb().setY(enemigoStage66.getY());

		stage.addActor(enemigoStage61);
		stage.addActor(enemigoStage62);
		stage.addActor(enemigoStage63);
		stage.addActor(enemigoStage64);
		stage.addActor(enemigoStage65);
		stage.addActor(enemigoStage66);
		enemigosStage6.add(enemigoStage61);
		enemigosStage6.add(enemigoStage62);
		enemigosStage6.add(enemigoStage63);
		enemigosStage6.add(enemigoStage64);
		enemigosStage6.add(enemigoStage65);
		enemigosStage6.add(enemigoStage66);
			
			enemigoStage61.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage62.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage63.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage64.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage65.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage66.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
								
			timerEnemigoStage62 = 10000;
			
		}


	private void spawnEnemigosStage63(){

		EnemigoActor enemigoStage61 = new EnemigoActor(new Texture("enemyGreen5.png"));
		EnemigoActor enemigoStage62 = new EnemigoActor(new Texture("enemyGreen5.png"));
		EnemigoActor enemigoStage63 = new EnemigoActor(new Texture("enemyGreen5.png"));
		EnemigoActor enemigoStage64 = new EnemigoActor(new Texture("enemyGreen5.png"));
		EnemigoActor enemigoStage65 = new EnemigoActor(new Texture("enemyGreen5.png"));
		EnemigoActor enemigoStage66 = new EnemigoActor(new Texture("enemyGreen5.png"));	

		enemigoStage61.setPosition(10, stage.getHeight()+enemigoStage61.getHeight());
		enemigoStage61.getBb().setX(enemigoStage61.getX());
			enemigoStage61.getBb().setY(enemigoStage61.getY());
			
		enemigoStage62.setPosition(enemigoStage61.getWidth()+10+nave.getWidth()+20, stage.getHeight()+enemigoStage62.getHeight());
		enemigoStage62.getBb().setX(enemigoStage62.getX());
		enemigoStage62.getBb().setY(enemigoStage62.getY());
	
		enemigoStage63.setPosition(enemigoStage62.getX()+enemigoStage62.getWidth(), stage.getHeight()+enemigoStage63.getHeight());
		enemigoStage63.getBb().setX(enemigoStage63.getX());
		enemigoStage63.getBb().setY(enemigoStage63.getY());

		enemigoStage64.setPosition(enemigoStage63.getX()+enemigoStage63.getWidth(), stage.getHeight()+enemigoStage64.getHeight());
		enemigoStage64.getBb().setX(enemigoStage64.getX());
		enemigoStage64.getBb().setY(enemigoStage64.getY());

		enemigoStage65.setPosition(enemigoStage64.getX()+enemigoStage64.getWidth(), stage.getHeight()+enemigoStage65.getHeight());
		enemigoStage65.getBb().setX(enemigoStage65.getX());
		enemigoStage65.getBb().setY(enemigoStage65.getY());


		enemigoStage66.setPosition(enemigoStage65.getX()+enemigoStage65.getWidth(), stage.getHeight()+enemigoStage66.getHeight());
		enemigoStage66.getBb().setX(enemigoStage66.getX());
		enemigoStage66.getBb().setY(enemigoStage66.getY());

		stage.addActor(enemigoStage61);
		stage.addActor(enemigoStage62);
		stage.addActor(enemigoStage63);
		stage.addActor(enemigoStage64);
		stage.addActor(enemigoStage65);
		stage.addActor(enemigoStage66);
		enemigosStage6.add(enemigoStage61);
		enemigosStage6.add(enemigoStage62);
		enemigosStage6.add(enemigoStage63);
		enemigosStage6.add(enemigoStage64);
		enemigosStage6.add(enemigoStage65);
		enemigosStage6.add(enemigoStage66);
			
			enemigoStage61.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage62.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage63.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage64.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage65.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage66.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
								
			timerEnemigoStage63 = 10000;
			
		}
	
	private void spawnEnemigosStage64(){

		EnemigoActor enemigoStage61 = new EnemigoActor(new Texture("enemyRed4.png"));
		EnemigoActor enemigoStage62 = new EnemigoActor(new Texture("enemyRed4.png"));
		EnemigoActor enemigoStage63 = new EnemigoActor(new Texture("enemyRed4.png"));
		EnemigoActor enemigoStage64 = new EnemigoActor(new Texture("enemyRed4.png"));
		EnemigoActor enemigoStage65 = new EnemigoActor(new Texture("enemyRed4.png"));
		EnemigoActor enemigoStage66 = new EnemigoActor(new Texture("enemyRed4.png"));	

		enemigoStage61.setPosition(10, stage.getHeight()+enemigoStage61.getHeight());
		enemigoStage61.getBb().setX(enemigoStage61.getX());
			enemigoStage61.getBb().setY(enemigoStage61.getY());
			
		enemigoStage62.setPosition(enemigoStage61.getWidth()+20, stage.getHeight()+enemigoStage62.getHeight());
		enemigoStage62.getBb().setX(enemigoStage62.getX());
		enemigoStage62.getBb().setY(enemigoStage62.getY());
	
		enemigoStage63.setPosition(enemigoStage62.getX()+enemigoStage62.getWidth()+20, stage.getHeight()+enemigoStage63.getHeight());
		enemigoStage63.getBb().setX(enemigoStage63.getX());
		enemigoStage63.getBb().setY(enemigoStage63.getY());

		enemigoStage64.setPosition(enemigoStage63.getX()+enemigoStage63.getWidth()+20, stage.getHeight()+enemigoStage64.getHeight());
		enemigoStage64.getBb().setX(enemigoStage64.getX());
		enemigoStage64.getBb().setY(enemigoStage64.getY());

		enemigoStage65.setPosition(enemigoStage64.getX()+enemigoStage64.getWidth()+20+nave.getWidth()+20, stage.getHeight()+enemigoStage65.getHeight());
		enemigoStage65.getBb().setX(enemigoStage65.getX());
		enemigoStage65.getBb().setY(enemigoStage65.getY());


		enemigoStage66.setPosition(enemigoStage65.getX()+enemigoStage65.getWidth()+20, stage.getHeight()+enemigoStage66.getHeight());
		enemigoStage66.getBb().setX(enemigoStage66.getX());
		enemigoStage66.getBb().setY(enemigoStage66.getY());

		stage.addActor(enemigoStage61);
		stage.addActor(enemigoStage62);
		stage.addActor(enemigoStage63);
		stage.addActor(enemigoStage64);
		stage.addActor(enemigoStage65);
		stage.addActor(enemigoStage66);
		enemigosStage6.add(enemigoStage61);
		enemigosStage6.add(enemigoStage62);
		enemigosStage6.add(enemigoStage63);
		enemigosStage6.add(enemigoStage64);
		enemigosStage6.add(enemigoStage65);
		enemigosStage6.add(enemigoStage66);
			
			enemigoStage61.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage62.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage63.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage64.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage65.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage66.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
								
			timerEnemigoStage64 = 10000;
			
		}
	
	private void spawnEnemigosStage65(){

		EnemigoActor enemigoStage61 = new EnemigoActor(new Texture("spaceShips_006.png"));
		EnemigoActor enemigoStage62 = new EnemigoActor(new Texture("spaceShips_006.png"));
		EnemigoActor enemigoStage63 = new EnemigoActor(new Texture("spaceShips_006.png"));
		EnemigoActor enemigoStage64 = new EnemigoActor(new Texture("spaceShips_006.png"));
		EnemigoActor enemigoStage65 = new EnemigoActor(new Texture("spaceShips_006.png"));
		EnemigoActor enemigoStage66 = new EnemigoActor(new Texture("spaceShips_006.png"));	

		enemigoStage61.setPosition(0, stage.getHeight()+enemigoStage61.getHeight());
		enemigoStage61.getBb().setX(enemigoStage61.getX());
			enemigoStage61.getBb().setY(enemigoStage61.getY());
			
		enemigoStage62.setPosition(enemigoStage61.getWidth()+5, stage.getHeight()+enemigoStage62.getHeight());
		enemigoStage62.getBb().setX(enemigoStage62.getX());
		enemigoStage62.getBb().setY(enemigoStage62.getY());
	
		enemigoStage63.setPosition(enemigoStage62.getX()+enemigoStage62.getWidth()+20+nave.getWidth()+20, stage.getHeight()+enemigoStage63.getHeight());
		enemigoStage63.getBb().setX(enemigoStage63.getX());
		enemigoStage63.getBb().setY(enemigoStage63.getY());

		enemigoStage64.setPosition(enemigoStage63.getX()+enemigoStage63.getWidth()+5, stage.getHeight()+enemigoStage64.getHeight());
		enemigoStage64.getBb().setX(enemigoStage64.getX());
		enemigoStage64.getBb().setY(enemigoStage64.getY());

		enemigoStage65.setPosition(enemigoStage64.getX()+enemigoStage64.getWidth()+5, stage.getHeight()+enemigoStage65.getHeight());
		enemigoStage65.getBb().setX(enemigoStage65.getX());
		enemigoStage65.getBb().setY(enemigoStage65.getY());


		enemigoStage66.setPosition(enemigoStage65.getX()+enemigoStage65.getWidth()+5, stage.getHeight()+enemigoStage66.getHeight());
		enemigoStage66.getBb().setX(enemigoStage66.getX());
		enemigoStage66.getBb().setY(enemigoStage66.getY());

		stage.addActor(enemigoStage61);
		stage.addActor(enemigoStage62);
		stage.addActor(enemigoStage63);
		stage.addActor(enemigoStage64);
		stage.addActor(enemigoStage65);
		stage.addActor(enemigoStage66);
		enemigosStage6.add(enemigoStage61);
		enemigosStage6.add(enemigoStage62);
		enemigosStage6.add(enemigoStage63);
		enemigosStage6.add(enemigoStage64);
		enemigosStage6.add(enemigoStage65);
		enemigosStage6.add(enemigoStage66);
			
			enemigoStage61.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage62.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage63.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage64.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage65.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
			enemigoStage66.addAction(Actions.sequence(Actions.moveBy(0, -250, 1), Actions.delay(1), 
					Actions.forever(Actions.sequence((Actions.moveBy(0, -600, 0.5f))))));
								
			timerEnemigoStage65 = 10000;
			
		}

	private void spawnEnemigosStage7(){
		contadorFinFase7 = 25;
		
		EnemigoActor enemigoStage71 = new EnemigoActor(new Texture("enemyblack1.png"));
		EnemigoActor enemigoStage72 = new EnemigoActor(new Texture("enemyBlack2.png"));
		EnemigoActor enemigoStage73 = new EnemigoActor(new Texture("enemyBlack3.png"));
		EnemigoActor enemigoStage74 = new EnemigoActor(new Texture("enemyBlack4.png"));
		EnemigoActor enemigoStage75 = new EnemigoActor(new Texture("enemyBlack5.png"));
		

		EnemigoActor enemigoStage76 = new EnemigoActor(new Texture("enemyBlue2.png"));
		EnemigoActor enemigoStage77 = new EnemigoActor(new Texture("enemyBlue4.png"));
		EnemigoActor enemigoStage78 = new EnemigoActor(new Texture("enemyBlue3.png"));
		EnemigoActor enemigoStage79 = new EnemigoActor(new Texture("enemyBlue2.png"));
		EnemigoActor enemigoStage80 = new EnemigoActor(new Texture("enemyBlue5.png"));

		EnemigoActor enemigoStage81 = new EnemigoActor(new Texture("enemyGreen1.png"));
		EnemigoActor enemigoStage82 = new EnemigoActor(new Texture("enemyGreen2.png"));
		EnemigoActor enemigoStage83 = new EnemigoActor(new Texture("enemyGreen3.png"));
		EnemigoActor enemigoStage84 = new EnemigoActor(new Texture("enemyGreen4.png"));
		EnemigoActor enemigoStage85 = new EnemigoActor(new Texture("enemyGreen5.png"));
		
		EnemigoActor enemigoStage86 = new EnemigoActor(new Texture("enemyRed5.png"));
		EnemigoActor enemigoStage87 = new EnemigoActor(new Texture("enemyRed4.png"));
		EnemigoActor enemigoStage88 = new EnemigoActor(new Texture("enemyRed3.png"));
		EnemigoActor enemigoStage89 = new EnemigoActor(new Texture("enemyRed2.png"));
		EnemigoActor enemigoStage90 = new EnemigoActor(new Texture("enemyRed1.png"));
		
		enemigoStage71.setPosition(-enemigoStage71.getWidth(), stage.getHeight());
		enemigoStage71.getBb().setX(enemigoStage71.getX());
		enemigoStage71.getBb().setY(enemigoStage71.getY());

		enemigoStage72.setPosition(-enemigoStage72.getWidth(), stage.getHeight());
		enemigoStage72.getBb().setX(enemigoStage72.getX());
		enemigoStage72.getBb().setY(enemigoStage72.getY());

		enemigoStage73.setPosition(-enemigoStage73.getWidth(), stage.getHeight());
		enemigoStage73.getBb().setX(enemigoStage73.getX());
		enemigoStage73.getBb().setY(enemigoStage73.getY());

		enemigoStage74.setPosition(-enemigoStage74.getWidth(), stage.getHeight());
		enemigoStage74.getBb().setX(enemigoStage74.getX());
		enemigoStage74.getBb().setY(enemigoStage74.getY());

		enemigoStage75.setPosition(-enemigoStage75.getWidth(), stage.getHeight());
		enemigoStage75.getBb().setX(enemigoStage75.getX());
		enemigoStage75.getBb().setY(enemigoStage75.getY());

		enemigoStage76.setPosition(stage.getWidth(), stage.getHeight()-150);
		enemigoStage76.getBb().setX(enemigoStage76.getX());
		enemigoStage76.getBb().setY(enemigoStage76.getY());
		
		enemigoStage77.setPosition(stage.getWidth(), stage.getHeight()-150);
		enemigoStage77.getBb().setX(enemigoStage77.getX());
		enemigoStage77.getBb().setY(enemigoStage77.getY());		
		
		enemigoStage78.setPosition(stage.getWidth(), stage.getHeight()-150);
		enemigoStage78.getBb().setX(enemigoStage78.getX());
		enemigoStage78.getBb().setY(enemigoStage78.getY());
		
		enemigoStage79.setPosition(stage.getWidth(), stage.getHeight()-150);
		enemigoStage79.getBb().setX(enemigoStage79.getX());
		enemigoStage79.getBb().setY(enemigoStage79.getY());
		
		enemigoStage80.setPosition(stage.getWidth(), stage.getHeight()-150);
		enemigoStage80.getBb().setX(enemigoStage80.getX());
		enemigoStage80.getBb().setY(enemigoStage80.getY());		

		enemigoStage81.setPosition(-enemigoStage81.getWidth(), -enemigoStage81.getHeight());
		enemigoStage81.getBb().setX(enemigoStage81.getX());
		enemigoStage81.getBb().setY(enemigoStage81.getY());

		enemigoStage82.setPosition(-enemigoStage82.getWidth(), -enemigoStage82.getHeight());
		enemigoStage82.getBb().setX(enemigoStage82.getX());
		enemigoStage82.getBb().setY(enemigoStage82.getY());

		enemigoStage83.setPosition(-enemigoStage83.getWidth(), -enemigoStage83.getHeight());
		enemigoStage83.getBb().setX(enemigoStage83.getX());
		enemigoStage83.getBb().setY(enemigoStage83.getY());

		enemigoStage84.setPosition(-enemigoStage84.getWidth(), -enemigoStage84.getHeight());
		enemigoStage84.getBb().setX(enemigoStage84.getX());
		enemigoStage84.getBb().setY(enemigoStage84.getY());

		enemigoStage85.setPosition(-enemigoStage85.getWidth(), -enemigoStage85.getHeight());
		enemigoStage85.getBb().setX(enemigoStage85.getX());
		enemigoStage85.getBb().setY(enemigoStage85.getY());
	
		enemigoStage86.setPosition(stage.getWidth(), -enemigoStage86.getHeight());
		enemigoStage86.getBb().setX(enemigoStage86.getX());
		enemigoStage86.getBb().setY(enemigoStage86.getY());

		enemigoStage87.setPosition(stage.getWidth(), -enemigoStage87.getHeight());
		enemigoStage87.getBb().setX(enemigoStage87.getX());
		enemigoStage87.getBb().setY(enemigoStage87.getY());

		enemigoStage88.setPosition(stage.getWidth(), -enemigoStage88.getHeight());
		enemigoStage88.getBb().setX(enemigoStage88.getX());
		enemigoStage88.getBb().setY(enemigoStage88.getY());

		enemigoStage89.setPosition(stage.getWidth(), -enemigoStage89.getHeight());
		enemigoStage89.getBb().setX(enemigoStage89.getX());
		enemigoStage89.getBb().setY(enemigoStage89.getY());
		
		enemigoStage90.setPosition(stage.getWidth(), -enemigoStage90.getHeight());
		enemigoStage90.getBb().setX(enemigoStage90.getX());
		enemigoStage90.getBb().setY(enemigoStage90.getY());
		
		stage.addActor(enemigoStage71);
		stage.addActor(enemigoStage72);

		enemigosStage7.add(enemigoStage71);
		enemigosStage7.add(enemigoStage72);
		
		stage.addActor(enemigoStage73);
		enemigosStage7.add(enemigoStage73);
		
		stage.addActor(enemigoStage74);
		enemigosStage7.add(enemigoStage74);
		
		stage.addActor(enemigoStage75);
		enemigosStage7.add(enemigoStage75);
		
		stage.addActor(enemigoStage76);
		enemigosStage7.add(enemigoStage76);
		
		stage.addActor(enemigoStage77);
		enemigosStage7.add(enemigoStage77);
		
		stage.addActor(enemigoStage78);
		enemigosStage7.add(enemigoStage78);
		
		stage.addActor(enemigoStage79);
		enemigosStage7.add(enemigoStage79);
		
		stage.addActor(enemigoStage80);
		enemigosStage7.add(enemigoStage80);

		stage.addActor(enemigoStage81);
		enemigosStage7.add(enemigoStage81);
		stage.addActor(enemigoStage82);
		enemigosStage7.add(enemigoStage82);
		stage.addActor(enemigoStage83);
		enemigosStage7.add(enemigoStage83);
		stage.addActor(enemigoStage84);
		enemigosStage7.add(enemigoStage84);
		stage.addActor(enemigoStage85);
		enemigosStage7.add(enemigoStage85);


		stage.addActor(enemigoStage86);
		enemigosStage7.add(enemigoStage86);
		stage.addActor(enemigoStage87);
		enemigosStage7.add(enemigoStage87);
		stage.addActor(enemigoStage88);
		enemigosStage7.add(enemigoStage88);
		stage.addActor(enemigoStage89);
		enemigosStage7.add(enemigoStage89);
		stage.addActor(enemigoStage90);
		enemigosStage7.add(enemigoStage90);
		
		//Negros
		
		enemigoStage71.addAction(Actions.sequence(Actions.moveTo( 
				stage.getWidth()-enemigoStage71.getWidth()-50,100,1), Actions.moveTo( 
						stage.getWidth()-enemigoStage71.getWidth()-50,stage.getHeight()-enemigoStage71.getHeight()-100,1), Actions.moveTo( 
								50,stage.getHeight()-enemigoStage71.getHeight()-100,1),Actions.delay(9),Actions.forever(
										Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))));
		
		enemigoStage72.addAction(Actions.sequence(Actions.delay(0.2f),Actions.moveTo( 
				stage.getWidth()-enemigoStage72.getWidth()-50,100,1), Actions.moveTo( 
						stage.getWidth()-enemigoStage72.getWidth()-50,stage.getHeight()-enemigoStage72.getHeight()-100,1), Actions.moveTo( 
								50 + enemigoStage71.getWidth() + 20,stage.getHeight()-enemigoStage72.getHeight()-100,0.8f),Actions.delay(9),Actions.forever(
										Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))));
		
		enemigoStage73.addAction(Actions.sequence(Actions.delay(0.4f),Actions.moveTo( 
				stage.getWidth()-enemigoStage73.getWidth()-50,100,1), Actions.moveTo( 
						stage.getWidth()-enemigoStage73.getWidth()-50,stage.getHeight()-enemigoStage73.getHeight()-100,1), Actions.moveTo( 
								50 + enemigoStage71.getWidth() + enemigoStage72.getWidth() + 40,stage.getHeight()-enemigoStage73.getHeight()-100,0.6f),Actions.delay(9),Actions.forever(
										Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))  ) );
		
		enemigoStage74.addAction(Actions.sequence(Actions.delay(0.6f),Actions.moveTo( 
				stage.getWidth()-enemigoStage74.getWidth()-50,100,1), Actions.moveTo( 
						stage.getWidth()-enemigoStage74.getWidth()-50,stage.getHeight()-enemigoStage74.getHeight()-100,1), Actions.moveTo( 
								50 + enemigoStage71.getWidth() + enemigoStage72.getWidth() + enemigoStage73.getWidth() + 60,stage.getHeight()-enemigoStage73.getHeight()-100,0.4f),Actions.delay(9),Actions.forever(
										Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))  ) );

		enemigoStage75.addAction(Actions.sequence(Actions.delay(0.8f),Actions.moveTo( 
				stage.getWidth()-enemigoStage75.getWidth()-50,100,1), Actions.moveTo( 
						stage.getWidth()-enemigoStage75.getWidth()-50,stage.getHeight()-enemigoStage75.getHeight()-100,1), Actions.moveTo( 
								50 + enemigoStage71.getWidth() + enemigoStage72.getWidth() + enemigoStage73.getWidth()  + enemigoStage74.getWidth() + 80,stage.getHeight()-enemigoStage73.getHeight()-100,0.2f),Actions.delay(9),Actions.forever(
										Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))  ) );
		
		
		//Azules
		
		enemigoStage76.addAction(Actions.sequence(Actions.delay(3),Actions.moveTo(
				50,100,1), Actions.moveTo(50,stage.getHeight()-enemigoStage76.getHeight()-200,1),
				Actions.moveTo(stage.getWidth()-enemigoStage76.getWidth()-50, stage.getHeight()-enemigoStage76.getHeight()-200,1),Actions.delay(6),Actions.forever(
						Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))));

		enemigoStage77.addAction(Actions.sequence(Actions.delay(3.2f),Actions.moveTo(
				50,100,1), Actions.moveTo(50,stage.getHeight()-enemigoStage77.getHeight()-200,1),
				Actions.moveTo(stage.getWidth()-enemigoStage77.getWidth()-enemigoStage76.getWidth()-70, stage.getHeight()-enemigoStage77.getHeight()-200,0.8f),Actions.delay(6),Actions.forever(
						Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))));

		enemigoStage78.addAction(Actions.sequence(Actions.delay(3.4f),Actions.moveTo(
				50,100,1), Actions.moveTo(50,stage.getHeight()-enemigoStage78.getHeight()-200,1),
				Actions.moveTo(stage.getWidth()-enemigoStage78.getWidth()-enemigoStage77.getWidth()-enemigoStage76.getWidth()-90, stage.getHeight()-enemigoStage78.getHeight()-200,0.6f),Actions.delay(6),Actions.forever(
						Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))));

		enemigoStage79.addAction(Actions.sequence(Actions.delay(3.6f),Actions.moveTo(
				50,100,1), Actions.moveTo(50,stage.getHeight()-enemigoStage79.getHeight()-200,1),
				Actions.moveTo(stage.getWidth()-enemigoStage79.getWidth()-enemigoStage78.getWidth()-enemigoStage77.getWidth()-enemigoStage76.getWidth()-110, stage.getHeight()-enemigoStage79.getHeight()-200,0.4f),Actions.delay(6),Actions.forever(
						Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))));

		enemigoStage80.addAction(Actions.sequence(Actions.delay(3.8f),Actions.moveTo(
				50,100,1), Actions.moveTo(50,stage.getHeight()-enemigoStage80.getHeight()-200,1),
				Actions.moveTo(stage.getWidth()-enemigoStage80.getWidth()-enemigoStage79.getWidth()-enemigoStage78.getWidth()-enemigoStage77.getWidth()-enemigoStage76.getWidth()-130, stage.getHeight()-enemigoStage80.getHeight()-200,0.2f),Actions.delay(6),Actions.forever(
						Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))));
	
		//Verdes
		
		enemigoStage81.addAction(Actions.sequence(Actions.delay(6),Actions.moveTo(
				stage.getWidth()-enemigoStage81.getWidth()-50,stage.getHeight()-385,1), Actions.moveTo(50,stage.getHeight()-385,1),Actions.delay(4),Actions.forever(
						Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))));

		enemigoStage82.addAction(Actions.sequence(Actions.delay(6.2f),Actions.moveTo(
				stage.getWidth()-enemigoStage82.getWidth()-50,stage.getHeight()-385,1), Actions.moveTo(50 + enemigoStage81.getWidth() + 20,stage.getHeight()-385,0.8f),Actions.delay(4),Actions.forever(
						Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))));

		enemigoStage83.addAction(Actions.sequence(Actions.delay(6.4f),Actions.moveTo(
				stage.getWidth()-enemigoStage83.getWidth()-50,stage.getHeight()-385,1), Actions.moveTo(50 + enemigoStage81.getWidth() + enemigoStage82.getWidth() + 40,stage.getHeight()-385,0.6f),Actions.delay(4),Actions.forever(
						Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))));

		enemigoStage84.addAction(Actions.sequence(Actions.delay(6.6f),Actions.moveTo(
				stage.getWidth()-enemigoStage84.getWidth()-50,stage.getHeight()-385,1), Actions.moveTo(50 + enemigoStage81.getWidth() + enemigoStage82.getWidth() + enemigoStage83.getWidth() + 60,stage.getHeight()-385,0.4f),Actions.delay(4),Actions.forever(
						Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))));

		enemigoStage85.addAction(Actions.sequence(Actions.delay(6.8f),Actions.moveTo(
				stage.getWidth()-enemigoStage85.getWidth()-50,stage.getHeight()-385,1), Actions.moveTo(50 + enemigoStage81.getWidth() + enemigoStage82.getWidth() + enemigoStage83.getWidth() + enemigoStage84.getWidth() + 80,stage.getHeight()-385,0.2f),Actions.delay(4),Actions.forever(
						Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))));

		//Amarillos
		
		enemigoStage86.addAction(Actions.sequence(Actions.delay(8.6f),Actions.moveTo(
				50,stage.getHeight()-485,1), Actions.moveTo(stage.getWidth()-enemigoStage86.getWidth()-50, stage.getHeight()-485,1),Actions.delay(1.5f),Actions.forever(
						Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))));
	
		enemigoStage87.addAction(Actions.sequence(Actions.delay(8.8f),Actions.moveTo(
				50,stage.getHeight()-485,1), Actions.moveTo(stage.getWidth()-enemigoStage86.getWidth()-enemigoStage87.getWidth()-70, stage.getHeight()-485,0.8f),Actions.delay(1.5f),Actions.forever(
						Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))));
		
		enemigoStage88.addAction(Actions.sequence(Actions.delay(9f),Actions.moveTo(
				50,stage.getHeight()-485,1), Actions.moveTo(stage.getWidth()-enemigoStage86.getWidth()-enemigoStage87.getWidth()-enemigoStage88.getWidth()-90, stage.getHeight()-485,0.6f),Actions.delay(1.5f),Actions.forever(
						Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))));
	
		enemigoStage89.addAction(Actions.sequence(Actions.delay(9.2f),Actions.moveTo(
				50,stage.getHeight()-485,1), Actions.moveTo(stage.getWidth()-enemigoStage86.getWidth()-enemigoStage87.getWidth()-enemigoStage88.getWidth()-enemigoStage89.getWidth()-110, stage.getHeight()-485,0.4f),Actions.delay(1.5f),Actions.forever(
						Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))));

		enemigoStage90.addAction(Actions.sequence(Actions.delay(9.4f),Actions.moveTo(
				50,stage.getHeight()-485,1), Actions.moveTo(stage.getWidth()-enemigoStage86.getWidth()-enemigoStage87.getWidth()-enemigoStage88.getWidth()-enemigoStage89.getWidth()-enemigoStage89.getWidth()-130, stage.getHeight()-485,0.2f),Actions.delay(1.5f),Actions.forever(
						Actions.sequence(Actions.moveBy(-50, 0, 0.4f),Actions.delay(0.2f),Actions.moveBy(50, 0, 0.4f),Actions.delay(0.2f)))));
	
	
		
		timerEnemigoStage7 = 10000;			

	}
	
	private void dropMunicion(EnemigoActor enemigoRandom, Texture textureMunicion, int tipo){
	    MunicionActor municion = new MunicionActor(textureMunicion, tipo);
	    municion.setPosition(enemigoRandom.getX() + enemigoRandom.getWidth()/2 -
	    		municion.getWidth()/2, enemigoRandom.getY()-municion.getHeight());
	    municion.getBb().setX(municion.getX());
	    municion.getBb().setY(municion.getY());
		stage.addActor(municion);
		municiones.add(municion);
	}
	
	private void dropEscudo(EnemigoActor enemigoRandom){
	    EscudoActor escudo = new EscudoActor();
	    escudo.setPosition(enemigoRandom.getX() + enemigoRandom.getWidth()/2 -
	    		escudo.getWidth()/2, enemigoRandom.getY()-escudo.getHeight());
	    escudo.getBb().setX(escudo.getX());
	    escudo.getBb().setY(escudo.getY());
		stage.addActor(escudo);
		escudos.add(escudo);
	}
	
	
	
	private void noDisparar(){
		LaserActor laser = new LaserActor();
		laser.setPosition(nave.getX() + nave.getWidth()/2 -
				laser.getWidth()/2, nave.getY() + nave.getHeight());
		laser.getBb().setX(laser.getX());
		laser.getBb().setY(laser.getY());
		stage.addActor(laser);
		lasers.add(laser);
		timerDisparar = 10000;
	}

	private void disparar(){
		LaserActor laser = new LaserActor();
		laser.setPosition(nave.getX() + nave.getWidth()/2 -
				laser.getWidth()/2, nave.getY() + nave.getHeight());
		laser.getBb().setX(laser.getX());
		laser.getBb().setY(laser.getY());
		stage.addActor(laser);
		lasers.add(laser);
		timerDisparar = 0.25f;
	}
	
	private void disparar2(){
		LaserActor laser = new LaserActor();
		laser.setPosition(nave.getX() + nave.getWidth()/2 -
				laser.getWidth()/2, nave.getY() + nave.getHeight());
		laser.getBb().setX(laser.getX());
		laser.getBb().setY(laser.getY());
		stage.addActor(laser);
		lasers.add(laser);
		timerDisparar = 0.15f;
	}

	private void disparar21(){
		LaserActor laser = new LaserActor();
		laser.setPosition(nave.getX() + nave.getWidth()/2 -
				laser.getWidth()/2, nave.getY() + nave.getHeight());
		laser.getBb().setX(laser.getX());
		laser.getBb().setY(laser.getY());
		stage.addActor(laser);
		lasers.add(laser);
		timerDisparar = 0.10f;
	}
	
	private void disparar3(){
		LaserActor laser1 = new LaserActor();
		LaserActor laser2 = new LaserActor();
		laser1.setPosition(nave.getX() + nave.getWidth()/2 -
				laser1.getWidth(), nave.getY() + nave.getHeight());
		laser2.setPosition(nave.getX() + nave.getWidth()/2, nave.getY() + nave.getHeight());
		laser1.getBb().setX(laser1.getX());
		laser1.getBb().setY(laser1.getY());
		laser2.getBb().setX(laser2.getX());
		laser2.getBb().setY(laser2.getY());
		stage.addActor(laser1);
		lasers.add(laser1);
		stage.addActor(laser2);
		lasers.add(laser2);
		
		laser1.addAction(Actions.parallel(Actions.forever(Actions.moveBy(-0.5f, 0)),
				Actions.forever(Actions.rotateBy(0.2f))));
		laser2.addAction(Actions.parallel(Actions.forever(Actions.moveBy(0.5f, 0)),
				Actions.forever(Actions.rotateBy(-0.2f))));
		
		timerDisparar = 0.10f;
	}
	
	private void disparar4(){
		LaserActor laser1 = new LaserActor();
		LaserActor laser2 = new LaserActor();
		LaserActor laser3 = new LaserActor();
		laser1.setPosition(nave.getX() + nave.getWidth()/2 -
				laser1.getWidth(), nave.getY() + nave.getHeight());
		laser2.setPosition(nave.getX() + nave.getWidth()/2, nave.getY() + nave.getHeight());
		laser3.setPosition(nave.getX() + nave.getWidth()/2 -
				laser3.getWidth()/2, nave.getY() + nave.getHeight());
		laser1.getBb().setX(laser1.getX());
		laser1.getBb().setY(laser1.getY());
		laser2.getBb().setX(laser2.getX());
		laser2.getBb().setY(laser2.getY());
		laser3.getBb().setX(laser3.getX());
		laser3.getBb().setY(laser3.getY());
		stage.addActor(laser1);
		lasers.add(laser1);
		stage.addActor(laser2);
		lasers.add(laser2);
		stage.addActor(laser3);
		lasers.add(laser3);
		
		laser1.addAction(Actions.parallel(Actions.forever(Actions.moveBy(-1f, 0)),
				Actions.forever(Actions.rotateBy(0.5f))));
		laser2.addAction(Actions.parallel(Actions.forever(Actions.moveBy(1f, 0)),
				Actions.forever(Actions.rotateBy(-0.5f))));
		
		timerDisparar = 0.25f;
	}
	
	private void disparar5(){
		LaserActor laser1 = new LaserActor();
		LaserActor laser2 = new LaserActor();
		LaserActor laser3 = new LaserActor();
		laser1.setPosition(nave.getX() + nave.getWidth()/2 -
				laser1.getWidth(), nave.getY() + nave.getHeight());
		laser2.setPosition(nave.getX() + nave.getWidth()/2, nave.getY() + nave.getHeight());
		laser3.setPosition(nave.getX() + nave.getWidth()/2 -
				laser3.getWidth()/2, nave.getY() + nave.getHeight());
		laser1.getBb().setX(laser1.getX());
		laser1.getBb().setY(laser1.getY());
		laser2.getBb().setX(laser2.getX());
		laser2.getBb().setY(laser2.getY());
		laser3.getBb().setX(laser3.getX());
		laser3.getBb().setY(laser3.getY());
		stage.addActor(laser1);
		lasers.add(laser1);
		stage.addActor(laser2);
		lasers.add(laser2);
		stage.addActor(laser3);
		lasers.add(laser3);
		
		laser1.addAction(Actions.parallel(Actions.forever(Actions.moveBy(-1f, 0)),
				Actions.forever(Actions.rotateBy(0.5f))));
		laser2.addAction(Actions.parallel(Actions.forever(Actions.moveBy(1f, 0)),
				Actions.forever(Actions.rotateBy(-0.5f))));
		
		timerDisparar = 0.15f;
	}

	private void disparar6(){
		LaserActor laser1 = new LaserActor();
		LaserActor laser2 = new LaserActor();
		LaserActor laser3 = new LaserActor();
		LaserActor laser4 = new LaserActor();
		laser1.setPosition(nave.getX() + nave.getWidth()/2, nave.getY() + nave.getHeight());
		laser2.setPosition(nave.getX() + nave.getWidth()/2, nave.getY() + nave.getHeight());
		laser4.setPosition(nave.getX() + nave.getWidth()/2, nave.getY() + nave.getHeight());
		laser3.setPosition(nave.getX() + nave.getWidth()/2, nave.getY() + nave.getHeight());
		laser1.getBb().setX(laser1.getX());
		laser1.getBb().setY(laser1.getY());
		laser2.getBb().setX(laser2.getX());
		laser2.getBb().setY(laser2.getY());
		laser3.getBb().setX(laser3.getX());
		laser3.getBb().setY(laser3.getY());
		laser4.getBb().setX(laser4.getX());
		laser4.getBb().setY(laser4.getY());
		stage.addActor(laser1);
		lasers.add(laser1);
		stage.addActor(laser2);
		lasers.add(laser2);
		stage.addActor(laser3);
		lasers.add(laser3);
		stage.addActor(laser4);
		lasers.add(laser4);
		
		laser1.addAction(Actions.parallel(Actions.forever(Actions.moveBy(-1f, 0)),
				Actions.forever(Actions.rotateBy(0.5f))));
		laser2.addAction(Actions.parallel(Actions.forever(Actions.moveBy(1f, 0)),
				Actions.forever(Actions.rotateBy(-0.5f))));
		laser3.addAction(Actions.parallel(Actions.forever(Actions.moveBy(-1.5f, 0)),
				Actions.forever(Actions.rotateBy(0.5f))));
		laser4.addAction(Actions.parallel(Actions.forever(Actions.moveBy(1.5f, 0)),
				Actions.forever(Actions.rotateBy(-0.5f))));
		
		timerDisparar = 0.15f;
	}
	private void dispararLaserEnemigo(){
		Random random = new Random();
	    int index = random.nextInt(enemigos.size());
	    EnemigoActor enemigoRandom = enemigos.get(index);
		LaserEnemigoActor laserEnemigo = new LaserEnemigoActor();
		laserEnemigo.setPosition(enemigoRandom.getX() + enemigoRandom.getWidth()/2 -
				laserEnemigo.getWidth()/2, enemigoRandom.getY()-laserEnemigo.getHeight());
		laserEnemigo.getBb().setX(laserEnemigo.getX());
		laserEnemigo.getBb().setY(laserEnemigo.getY());
		stage.addActor(laserEnemigo);
		laserEnemigos.add(laserEnemigo);
		laserEnemigo.addAction(Actions.forever(
				Actions.moveBy(0, -350 * Gdx.graphics.getDeltaTime())));
		timerEnemigo = (float) (0.5 + Math.random());
		game.laserSound.play();
	}
	
	private void dispararLaserEnemigoBlue(){
		Random random = new Random();
	    int index = random.nextInt(enemigosBlue.size());
	    EnemigoActor enemigoRandom = enemigosBlue.get(index);
		LaserEnemigoActor laserEnemigo = new LaserEnemigoActor();
		laserEnemigo.setPosition(enemigoRandom.getX() + enemigoRandom.getWidth()/2 -
				laserEnemigo.getWidth()/2, enemigoRandom.getY()-laserEnemigo.getHeight());
		laserEnemigo.getBb().setX(laserEnemigo.getX());
		laserEnemigo.getBb().setY(laserEnemigo.getY());
		stage.addActor(laserEnemigo);
		laserEnemigos.add(laserEnemigo);
		laserEnemigo.addAction(Actions.forever(
				Actions.moveBy(0, -550 * Gdx.graphics.getDeltaTime())));
		timerEnemigoBlue = (float) (0.5 + Math.random());
		game.laserSound.play();
	}

	private void dispararLaserEnemigoYellow(){
		Random random = new Random();
	    int index = random.nextInt(enemigosYellow.size());
	    EnemigoActor enemigoRandom = enemigosYellow.get(index);
		LaserEnemigoActor laserEnemigo = new LaserEnemigoActor();
		laserEnemigo.setPosition(enemigoRandom.getX() + enemigoRandom.getWidth()/2 -
				laserEnemigo.getWidth()/2, enemigoRandom.getY()-laserEnemigo.getHeight());
		laserEnemigo.getBb().setX(laserEnemigo.getX());
		laserEnemigo.getBb().setY(laserEnemigo.getY());
		stage.addActor(laserEnemigo);
		laserEnemigos.add(laserEnemigo);
		laserEnemigo.addAction(Actions.forever(
				Actions.moveBy(0, -600 * Gdx.graphics.getDeltaTime())));
		timerEnemigoYellow = (float) (0.1 + Math.random());
		game.laserSound.play();
	}
	
	private void dispararLaserEnemigoRed(){
		Random random = new Random();
	    int index = random.nextInt(enemigosRed.size());
	    EnemigoActor enemigoRandom = enemigosRed.get(index);
		LaserEnemigoActor laserEnemigo = new LaserEnemigoActor();
		laserEnemigo.setPosition(enemigoRandom.getX() + enemigoRandom.getWidth()/2 -
				laserEnemigo.getWidth()/2, enemigoRandom.getY()-laserEnemigo.getHeight());
		laserEnemigo.getBb().setX(laserEnemigo.getX());
		laserEnemigo.getBb().setY(laserEnemigo.getY());
		stage.addActor(laserEnemigo);
		laserEnemigos.add(laserEnemigo);
		laserEnemigo.addAction(Actions.forever(
				Actions.moveBy(0, -650 * Gdx.graphics.getDeltaTime())));
		timerEnemigoRed = (float) (0.1 + Math.random());
		game.laserSound.play();
	}
	
	private void dispararLaserEnemigoStage7(){
		Random random = new Random();
	    int index = random.nextInt(enemigosStage7.size());
	    EnemigoActor enemigoRandom = enemigosStage7.get(index);
		LaserEnemigoActor laserEnemigo = new LaserEnemigoActor();
		laserEnemigo.setPosition(enemigoRandom.getX() + enemigoRandom.getWidth()/2 -
				laserEnemigo.getWidth()/2, enemigoRandom.getY()-laserEnemigo.getHeight());
		laserEnemigo.getBb().setX(laserEnemigo.getX());
		laserEnemigo.getBb().setY(laserEnemigo.getY());
		stage.addActor(laserEnemigo);
		laserEnemigos.add(laserEnemigo);
		laserEnemigo.addAction(Actions.forever(
				Actions.moveBy(0, -700 * Gdx.graphics.getDeltaTime())));
		timerDisparoEnemigoStage7= (float) (0.1 + Math.random());
		game.laserSound.play();
	}
	
	private void dispararLaserUfo(){
		LaserUfoActor laserUfo = new LaserUfoActor();
		laserUfo.setPosition(ufo.getX() + ufo.getWidth()/2 -
				laserUfo.getWidth()/2, ufo.getY());
		laserUfo.getBb().setX(laserUfo.getX());
		laserUfo.getBb().setY(laserUfo.getY());
		stage.addActor(laserUfo);
		laserUfos.add(laserUfo);
		timerLaserUfo = 0.4f;
		game.laserSound.play();
	}
	

	
	private void spawnUfo(){
//		ufo = new UfoActor();
		ufo.setPosition(stage.getWidth(), stage.getHeight()-150);
		ufo.getBb().setX(ufo.getX());
		ufo.getBb().setY(ufo.getY());
		stage.addActor(ufo);
//		ufos.add(ufo);
		game.ufoSound.loop();
		timerUfo = (float) (20 + Math.random());
	}
	
	private void spawnMeteorito(){
		textureMeteorito1 = new Texture("meteorBrown_big1.png");
		textureMeteorito2 = new Texture("meteorBrown_big2.png");
		textureMeteorito3 = new Texture("meteorBrown_big3.png");
		textureMeteorito4 = new Texture("meteorBrown_med1.png");
		textureMeteorito5 = new Texture("meteorBrown_small2.png");
		MeteoritoActor meteor1 = new MeteoritoActor(textureMeteorito1);
		MeteoritoActor meteor2 = new MeteoritoActor(textureMeteorito2);
		MeteoritoActor meteor3 = new MeteoritoActor(textureMeteorito3);
		MeteoritoActor meteor4 = new MeteoritoActor(textureMeteorito4);
		MeteoritoActor meteor5 = new MeteoritoActor(textureMeteorito4);
		MeteoritoActor meteor6 = new MeteoritoActor(textureMeteorito5);
		MeteoritoActor meteor7 = new MeteoritoActor(textureMeteorito5);
		List<MeteoritoActor> meteoritosSpawn = new ArrayList<MeteoritoActor>();
		float delta = Gdx.graphics.getDeltaTime();
		
		meteoritosSpawn.add(meteor1);
		meteoritosSpawn.add(meteor2);
		meteoritosSpawn.add(meteor3);
		meteoritosSpawn.add(meteor4);
		meteoritosSpawn.add(meteor5);
		meteoritosSpawn.add(meteor6);
		meteoritosSpawn.add(meteor7);
		
		Random random = new Random();
	    int index = random.nextInt(meteoritosSpawn.size());
	    meteorito = meteoritosSpawn.get(index);
	    
	    List<Integer> v = new ArrayList<Integer>();
	    v.add(-50);
	    v.add(50);
	    Random random2 = new Random();
	    int index2 = random2.nextInt(v.size());
	    int vx = v.get(index2);
	    
	    List<Integer> r = new ArrayList<Integer>();
	    r.add(-1);
	    r.add(1);
	    Random random3 = new Random();
	    int index3 = random3.nextInt(r.size());
	    int rx = r.get(index3);
	    
	    meteorito.setPosition((float) ((stage.getWidth()-meteorito.getWidth())
				* Math.random()), stage.getHeight());
	    meteorito.getBb().setX(meteorito.getX());
	    meteorito.getBb().setY(meteorito.getY());
		
		stage.addActor(meteorito);
		meteoritos.add(meteorito);
		meteorito.addAction(Actions.forever(Actions.parallel(
				Actions.moveBy(vx*delta, -100*delta),Actions.rotateBy(rx))));

		timerMeteor = (float) (5 + Math.random());
	}
	
	private void rompeMeteoritoGrande(MeteoritoActor m){
		MeteoritoActor m1 = new MeteoritoActor(new Texture("meteorBrown_med1.png"));
		MeteoritoActor m2 = new MeteoritoActor(new Texture("meteorBrown_med1.png"));
		float delta = Gdx.graphics.getDeltaTime();
		
		m1.setPosition(m.getX()+m.getWidth()/2-m1.getWidth()/2,
				m.getY()+m.getHeight()/2-m1.getHeight()/2);
		m2.setPosition(m.getX()+m.getWidth()/2-m2.getWidth()/2,
				m.getY()+m.getHeight()/2-m2.getHeight()/2);
		m1.getBb().setX(m1.getX());
	    m1.getBb().setY(m1.getY());
	    m2.getBb().setX(m2.getX());
	    m2.getBb().setY(m2.getY());
	    
	    stage.addActor(m1);
	    stage.addActor(m2);	    
	    meteoritos.add(m1);
	    meteoritos.add(m2);
	    
	    m1.addAction(Actions.forever(Actions.parallel(
	    		Actions.moveBy(-50*delta, -100*delta),Actions.rotateBy(1))));
	    m2.addAction(Actions.forever(Actions.parallel(
	    		Actions.moveBy(50*delta, -100*delta),Actions.rotateBy(-1))));
	}
	
	
	private void stage2(){
		stage2 = new Image(new Texture("stage2.png"));
		stage2.setPosition(stage.getWidth()/2 - stage2.getWidth()/2,
				stage.getHeight()/2 - stage2.getHeight()/2);
		stage.addActor(stage2);
		timerStage2 = 10000;
		stage2.addAction(Actions.sequence(Actions.delay(2),Actions.removeActor()));
	}
	
	private void stage3(){
		stage3 = new Image(new Texture("stage3.png"));
		stage3.setPosition(stage.getWidth()/2 - stage3.getWidth()/2,
				stage.getHeight()/2 - stage3.getHeight()/2);
		stage.addActor(stage3);
		timerStage3 = 10000;
		stage3.addAction(Actions.sequence(Actions.delay(2),Actions.removeActor()));
	}
	private void stage4(){
		stage4 = new Image(new Texture("stage4.png"));
		stage4.setPosition(stage.getWidth()/2 - stage4.getWidth()/2,
				stage.getHeight()/2 - stage4.getHeight()/2);
		stage.addActor(stage4);
		timerStage4 = 10000;
		stage4.addAction(Actions.sequence(Actions.delay(2),Actions.removeActor()));
	}
	
	private void stage5(){
		stage5 = new Image(new Texture("stage5.png"));
		stage5.setPosition(stage.getWidth()/2 - stage5.getWidth()/2,
				stage.getHeight()/2 - stage5.getHeight()/2);
		stage.addActor(stage5);
		timerStage5 = 10000;
		stage5.addAction(Actions.sequence(Actions.delay(2),Actions.removeActor()));
	}

	private void stage6(){
		stage6 = new Image(new Texture("stage6.png"));
		stage6.setPosition(stage.getWidth()/2 - stage6.getWidth()/2,
				stage.getHeight()/2 - stage6.getHeight()/2);
		stage.addActor(stage6);
		timerStage6 = 10000;
		stage6.addAction(Actions.sequence(Actions.delay(2),Actions.removeActor()));
	}

	private void stage7(){
		stage7 = new Image(new Texture("stage7.png"));
		stage7.setPosition(stage.getWidth()/2 - stage7.getWidth()/2,
				stage.getHeight()/2 - stage7.getHeight()/2);
		stage.addActor(stage7);
		timerStage7 = 10000;
		stage7.addAction(Actions.sequence(Actions.delay(2),Actions.removeActor()));
	}

	private void stage8(){
		stage8 = new Image(new Texture("stage8.png"));
		stage8.setPosition(stage.getWidth()/2 - stage8.getWidth()/2,
				stage.getHeight()/2 - stage8.getHeight()/2);
		stage.addActor(stage8);
		timerStage8 = 10000;
		stage8.addAction(Actions.sequence(Actions.delay(2),Actions.removeActor()));
	}
	private void clear(){
		clear = new Image(new Texture("clear.png"));
		clear.setPosition(stage.getWidth()/2 - clear.getWidth()/2,
				stage.getHeight()/2 - clear.getHeight()/2);
		stage.addActor(clear);
	}

	
	@Override
	public void dispose() {
		fondo.dispose();
		nave.dispose();
		stage.dispose();
        musicaFundo.dispose();
	}
	
	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
		stage.dispose();
	}
	
	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	
    private void initSons() {
        musicaFundo = Gdx.audio.newMusic(Gdx.files.internal("sounds/background.mp3"));
        musicaFundo.setLooping(true);
        musicaFundo.play();
        musicaFundo.setVolume((float) 0.3);
        

    	timerMusicaFondo = 1000000;
    	
    }

  
    
 
    

    

    
}
