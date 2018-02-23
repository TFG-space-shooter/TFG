package com.solarsystem.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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

	private ControladorVirtual controlador;
	private Stage stage;
	public NaveActor nave;
	private float timer;
	private float timer2;
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
	private float timerFin;
	private float timerBlue;
	private float timerBlue2;
	private float timerBlue3;
	private float timerBlue4;
	private float timerEnemigoBlue;
	private List<EnemigoActor> enemigos;
	private List<EnemigoActor> enemigosBlue;
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
//	private Texture municion3;
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
	private Image clear;
	private boolean disparo1;
	private boolean disparo2;
	private boolean disparo3;
	private boolean disparo4;
	private boolean drop;
	private ShieldActor shield;
	private boolean dropShield;
	
	public GameplayScreen(Solarsystem game) {
		super(game);		

	}
	
	@Override
	public void show() {	
		controlador = new ControladorVirtual();
		timer = 5;
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
		disparo1 = true;
		disparo2 = false;
		disparo3 = false;
		disparo4 = false;
		drop = true;
		dropShield = true;
		enemigos = new ArrayList<EnemigoActor>();
		enemigosBlue = new ArrayList<EnemigoActor>();
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
		booleans.add(true);
		
//		booleans2.add(false);
//		booleans2.add(false);
//		booleans2.add(false);
//		booleans2.add(false);
//		booleans2.add(false);
//		booleans2.add(false);
//		booleans2.add(false);
//		booleans2.add(false);
//		booleans2.add(false);
		booleans2.add(true);
		
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
		municion2 = new Texture("bolt_gold.png");
//		municion3 = new Texture("bolt_gold.png");
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
		
		puntuacion.toFront();
		puntuacionTexto.toFront();
		energia.toFront();
		energiaTexto.toFront();
		nave.toFront();
		
//		if(planeta1.getTop()<0){
//			planeta1.setPosition(planeta1.getX(), stage.getHeight());
//		}

		timer -= delta;
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
		timerBlue -= delta;
		timerBlue2 -= delta;
		timerBlue3 -= delta;
		timerBlue4 -= delta;
		timerEnemigoBlue -= delta;
		
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
			}
		}
		
		if(timerStage1<0){
			stage.getActors().removeValue(stage1, false);
		}
		

		if(timer<0){
			spawnEnemigos();
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
		comprobarListas();

		comprobarColisiones();
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

	}

	private void comprobarColisiones() {
		EnemigoActor enemigo;
		EnemigoActor enemigoBlue;
		LaserActor laser;
		LaserEnemigoActor laserEnemigo;
		MeteoritoActor meteorito;
//		UfoActor ufo;
		LaserUfoActor laserUfo;
		MunicionActor municion;
		EscudoActor escudo;

		for(int i = 0; i < enemigos.size(); i++){
			enemigo = enemigos.get(i);
			if(enemigo.getBb().overlaps(nave.getBb())){
				// Colisión enemigo-nave
				enemigos.get(i).remove();
				enemigos.remove(i);
				game.hitSound.play();
				game.ufoSound.stop();
				game.setScreen(game.gameoverScreen);
			}else{
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
						    	}
//						    	}else if(energia.getEnergia()==2){
//						    		dropMunicion(enemigo, municion3, 3);
//						    	}
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
		}
		for(int k = 0; k < laserEnemigos.size(); k++){
			laserEnemigo = laserEnemigos.get(k);
			if(laserEnemigo.getBb().overlaps(nave.getBb())&&
					!stage.getActors().contains(shield, false)){
				// Colisión nave-láser enemigo
				laserEnemigos.get(k).remove();
				laserEnemigos.remove(k);
				game.hitSound.play();
				game.ufoSound.stop();
				nave.dispose();
				game.setScreen(game.gameoverScreen);
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
				game.hitSound.play();
				game.ufoSound.stop();
				game.setScreen(game.gameoverScreen);
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
					if(meteorito.getWidth()>=89&&meteorito.getContador()==60){
						meteoritos.get(k).remove();
						meteoritos.remove(k);
						BoomActor boom = new BoomActor();
						boom.setPosition(meteorito.getX()+meteorito.getWidth()/2-boom.getWidth()/2,
								meteorito.getY()+meteorito.getHeight()/2-boom.getHeight()/2);
						stage.addActor(boom);
						puntuacion.setPuntuacion(puntuacion.getPuntuacion()+500);
					}else if(meteorito.getWidth()==43&&meteorito.getContador()==30){
						meteoritos.get(k).remove();
						meteoritos.remove(k);
						BoomActor boom = new BoomActor();
						boom.setPosition(meteorito.getX()+meteorito.getWidth()/2-boom.getWidth()/2,
								meteorito.getY()+meteorito.getHeight()/2-boom.getHeight()/2);
						stage.addActor(boom);
						puntuacion.setPuntuacion(puntuacion.getPuntuacion()+250);
					}else if(meteorito.getWidth()==29&&meteorito.getContador()==15){
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
				game.hitSound.play();
				game.ufoSound.stop();
				game.setScreen(game.gameoverScreen);
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
					drop = false;
					energia.setEnergia(2);
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
			if(enemigoBlue.getBb().overlaps(nave.getBb())){
				// Colisión enemigo-nave
				enemigosBlue.get(i).remove();
				enemigosBlue.remove(i);
				game.hitSound.play();
				game.ufoSound.stop();
				game.setScreen(game.gameoverScreen);
			}else{
				for(int j = 0; j < lasers.size(); j++){
					laser = lasers.get(j);
					if(laser.getBb().overlaps(enemigoBlue.getBb())){
						// Colisión enemigo-láser
						lasers.get(j).remove();
						lasers.remove(j);
						game.explosionSound.play();
						enemigoBlue.setContador(enemigoBlue.getContador()+1);
						if(enemigoBlue.getContador()==7){
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
								timerUfo = 1000;
//								timerBlue = 8;
							}
						}
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
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		enemigoBlue5.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(2.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		enemigoBlue9.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(2.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		enemigoBlue13.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(2.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		enemigoBlue17.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(2.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		
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
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		enemigoBlue6.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(2), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		enemigoBlue10.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(2), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		enemigoBlue14.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(2), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		enemigoBlue18.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(2), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		
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
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		enemigoBlue7.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(1.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		enemigoBlue11.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(1.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		enemigoBlue15.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(1.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		enemigoBlue19.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(1.5f), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		
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
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		enemigoBlue8.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(1), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		enemigoBlue12.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(1), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		enemigoBlue16.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(1), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		enemigoBlue20.addAction(Actions.sequence(Actions.moveBy(0, -462, 1.5f), Actions.delay(1), 
				Actions.forever(Actions.sequence(Actions.moveBy(-50, 0, 1), 
						Actions.delay(0.5f), Actions.moveBy(0, -50, 1), Actions.delay(0.5f),
						Actions.moveBy(50, 0, 1), Actions.delay(0.5f), 
						Actions.moveBy(0, 50, 1), Actions.delay(0.5f)))));
		
		timerBlue4 = 10000;
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
	
	
	
	private void disparar(){
		LaserActor laser = new LaserActor();
		laser.setPosition(nave.getX() + nave.getWidth()/2 -
				laser.getWidth()/2, nave.getY() + nave.getHeight());
		laser.getBb().setX(laser.getX());
		laser.getBb().setY(laser.getY());
		stage.addActor(laser);
		lasers.add(laser);
		timerDisparar = 0.15f;
	}
	
	private void disparar2(){
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
		
		laser1.addAction(Actions.parallel(Actions.forever(Actions.moveBy(-2, 0)),
				Actions.forever(Actions.rotateBy(0.5f))));
		laser2.addAction(Actions.parallel(Actions.forever(Actions.moveBy(2, 0)),
				Actions.forever(Actions.rotateBy(-0.5f))));
		
		timerDisparar = 0.15f;
	}
	
	private void disparar3(){
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
		
		laser1.addAction(Actions.parallel(Actions.forever(Actions.moveBy(-2.5f, 0)),
				Actions.forever(Actions.rotateBy(1))));
		laser2.addAction(Actions.parallel(Actions.forever(Actions.moveBy(2.5f, 0)),
				Actions.forever(Actions.rotateBy(-1))));
		
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
		timerEnemigoBlue = (float) (0.5 + Math.random());
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
	    
	    meteorito.setPosition((float) ((stage.getWidth()-meteorito.getWidth())
				* Math.random()), stage.getHeight());
	    meteorito.getBb().setX(meteorito.getX());
	    meteorito.getBb().setY(meteorito.getY());
		
		stage.addActor(meteorito);
		meteoritos.add(meteorito);

		timerMeteor = (float) (5 + Math.random());
	}
	
	private void stage2(){
		stage2 = new Image(new Texture("stage2.png"));
		stage2.setPosition(stage.getWidth()/2 - stage2.getWidth()/2,
				stage.getHeight()/2 - stage2.getHeight()/2);
		stage.addActor(stage2);
		timerStage2 = 10000;
		stage2.addAction(Actions.sequence(Actions.delay(2),Actions.removeActor()));
	}
	

	@Override
	public void dispose() {
		fondo.dispose();
		nave.dispose();
		stage.dispose();
		
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

}
