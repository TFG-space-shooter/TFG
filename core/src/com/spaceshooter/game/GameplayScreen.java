package com.spaceshooter.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.spaceshooter.game.actor.EnemigoActor;
import com.spaceshooter.game.actor.FondoActor;
import com.spaceshooter.game.actor.LaserActor;
import com.spaceshooter.game.actor.LaserEnemigoActor;
import com.spaceshooter.game.actor.LaserUfoActor;
import com.spaceshooter.game.actor.MeteoritoActor;
import com.spaceshooter.game.actor.NaveActor;
import com.spaceshooter.game.actor.PuntuacionActor;
import com.spaceshooter.game.actor.UfoActor;
import com.spaceshooter.game.inputhandler.ControladorVirtual;

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
	
	private ControladorVirtual controlador;
	private Stage stage;
	private NaveActor nave;
	private float timer;
	private float timerEnemigo;
	private float timerMeteor;
	private float timerUfo;
	private float timerLaserUfo;
	private float timerDisparar;
	private List<EnemigoActor> enemigos;
	private List<LaserActor> lasers;
	private List<LaserEnemigoActor> laserEnemigos;
	private List<MeteoritoActor> meteoritos;
	private List<UfoActor> ufos;
	private List<LaserUfoActor> laserUfos;
	private PuntuacionActor puntuacion;
	private FondoActor fondo;
	private MeteoritoActor meteorito;
	private UfoActor ufo;
	private int k;
	private Texture textureEnemigo1;
	private Texture textureEnemigo2;
	private Texture textureEnemigo3;
	private Texture textureEnemigo4;
	private Texture textureEnemigo5;
	private Texture textureMeteorito1;
	private Texture textureMeteorito2;
	private Texture textureMeteorito3;
	private Texture textureMeteorito4;
	private Texture textureMeteorito5;
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
	
	public GameplayScreen(SpaceShooter game) {
		super(game);		

	}
	
	@Override
	public void show() {	
		controlador = new ControladorVirtual();
		timer = 5;
		timerMeteor = 15;
		timerUfo = 20;
		timerDisparar = 0.1f;
		enemigos = new ArrayList<EnemigoActor>();
		lasers = new ArrayList<LaserActor>();
		laserEnemigos = new ArrayList<LaserEnemigoActor>();
		meteoritos = new ArrayList<MeteoritoActor>();
		ufos = new ArrayList<UfoActor>();
		laserUfos = new ArrayList<LaserUfoActor>();
		
		stage = new Stage(new ScreenViewport());
		nave = new NaveActor();
		puntuacion = new PuntuacionActor(new BitmapFont());
		Gdx.input.setInputProcessor(stage);
		
		fondo = new FondoActor();
//		fondo.setPosition(0, 0);
		stage.addActor(fondo);
		
		nave.setPosition(stage.getWidth()/2-nave.getWidth()/2, 70);
		nave.getBb().setX(nave.getX());
		nave.getBb().setY(nave.getY());
		stage.addActor(nave);
		
		if(Gdx.app.getType() == ApplicationType.Desktop){
			stage.setKeyboardFocus(nave);
			nave.addListener(new InputDesktopAndroidListener());
		}else if(Gdx.app.getType() == ApplicationType.Android){
			nave.addListener(new InputDesktopAndroidListener());
			
		}
		
		puntuacion.setPosition(stage.getWidth() - 30, stage.getHeight() - 20);
		puntuacion.setPuntuacion(0);
		stage.addActor(puntuacion);
		
		spawnEnemigos();
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act();
		
		timer -= delta;
		timerEnemigo -= delta;
		timerMeteor -= delta;
		timerUfo -= delta;
		timerLaserUfo -= delta;
		timerDisparar -= delta;
		
		if(enemigo2.getX() < 75){
			enemigo2.addAction(Actions.moveBy(0, 0));
		}else{
			enemigo2.addAction(Actions.moveBy(-400*delta, 0));
		}
		if(enemigo7.getX()<enemigo2.getX()+enemigo2.getWidth()+20){
			enemigo7.addAction(Actions.moveBy(0, 0));
		}else{
			enemigo7.addAction(Actions.moveBy(-400*delta, 0));
		}
		if(enemigo12.getX()<enemigo7.getX()+enemigo7.getWidth()+20){
			enemigo12.addAction(Actions.moveBy(0, 0));
		}else{
			enemigo12.addAction(Actions.moveBy(-400*delta, 0));
		}
		if(enemigo17.getX()<enemigo12.getX()+enemigo12.getWidth()+20){
			enemigo17.addAction(Actions.moveBy(0, 0));
		}else{
			enemigo17.addAction(Actions.moveBy(-400*delta, 0));
		}
		if(enemigo22.getX()<enemigo17.getX()+enemigo17.getWidth()+20){
			enemigo22.addAction(Actions.moveBy(0, 0));
		}else{
			enemigo22.addAction(Actions.moveBy(-400*delta, 0));
		}
		
		
		if(controlador.obedeceRaton){
			ir();
		}
		if(timerDisparar < 0){
			disparar();
		}
//		if(timer < 0){
//			spawnEnemigo();
//		}
//		if(timerEnemigo < 0 && stage.getActors().contains(enemigo, true)){
//			dispararLaserEnemigo();
//		}
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
//		for(int i = 0; i < enemigos.size(); i++){
//			if(enemigos.get(i).getWidth() < 0){
//				enemigos.get(i).remove();
//				enemigos.remove(i);
//				game.hitSound.play();
//			}
//		}
		
		for(int i = 0; i < lasers.size(); i++){
			if(lasers.get(i).getY() > lasers.get(i).getStage().getHeight()){
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
		
		for(int i = 0; i < ufos.size(); i++){
			if(ufos.get(i).getX() < -ufos.get(i).getWidth()){
				ufos.get(i).remove();
				ufos.remove(i);
				game.ufoSound.stop();
			}
		}
		
		for(int i = 0; i < laserUfos.size(); i++){
			if(laserUfos.get(i).getY() < -laserUfos.get(i).getHeight()){
				laserUfos.get(i).remove();
				laserUfos.remove(i);
			}
		}

	}

	private void comprobarColisiones() {
		EnemigoActor enemigo;
		LaserActor laser;
		LaserEnemigoActor laserEnemigo;
		MeteoritoActor meteorito;
		UfoActor ufo;
		LaserUfoActor laserUfo;

		for(int i = 0; i < enemigos.size(); i++){
			enemigo = enemigos.get(i);
			if(enemigo.getBb().overlaps(nave.getBb())){
				// Colisión enemigo-nave
				enemigos.get(i).remove();
				enemigos.remove(i);
				game.hitSound.play();
				game.setScreen(game.gameoverScreen);
			}else{
				for(int j = 0; j < lasers.size(); j++){
					laser = lasers.get(j);
					if(laser.getBb().overlaps(enemigo.getBb())){
						// Colisión enemigo-láser
						enemigos.get(i).remove();
						enemigos.remove(i);
						lasers.get(j).remove();
						lasers.remove(j);
						puntuacion.setPuntuacion(puntuacion.getPuntuacion()+1);
						game.explosionSound.play();
					}
				}
			}
		}
		for(int k = 0; k < laserEnemigos.size(); k++){
			laserEnemigo = laserEnemigos.get(k);
			if(laserEnemigo.getBb().overlaps(nave.getBb())){
				// Colisión nave-láser enemigo
				laserEnemigos.get(k).remove();
				laserEnemigos.remove(k);
				game.hitSound.play();
				game.setScreen(game.gameoverScreen);
			}
		}

		
		for(int k = 0; k < meteoritos.size(); k++){
			meteorito = meteoritos.get(k);
			if(meteorito.getBb().overlaps(nave.getBb())){
				// Colisión nave-meteorito
				meteoritos.get(k).remove();
				meteoritos.remove(k);
				game.hitSound.play();
				game.setScreen(game.gameoverScreen);
			}
		}
		for(int k = 0; k < ufos.size(); k++){
			ufo = ufos.get(k);
			for(int j = 0; j < lasers.size(); j++){
				laser = lasers.get(j);
				if(ufo.getBb().overlaps(laser.getBb())){
					// Colisión láser-ufo
					ufos.get(k).remove();
					ufos.remove(k);
					lasers.get(j).remove();
					lasers.remove(j);
					puntuacion.setPuntuacion(puntuacion.getPuntuacion()+5);
					game.ufoSound.stop();
					game.explosionSound.play();

				}
			}
		}
		for(int k = 0; k < laserUfos.size(); k++){
			laserUfo = laserUfos.get(k);
			if(laserUfo.getBb().overlaps(nave.getBb())){
				// Colisión nave-láser ufo
				laserUfos.get(k).remove();
				laserUfos.remove(k);
				game.hitSound.play();
				game.setScreen(game.gameoverScreen);
			}
		}

	}


	public void ir(){
		float x = Gdx.input.getX() - nave.getWidth()*0.5f;
		float y = Gdx.graphics.getHeight() - Gdx.input.getY() - nave.getHeight()*0.5f;
		nave.setPosition(x, y);
	}
	
	private void spawnEnemigos(){
		textureEnemigo1 = new Texture("enemyblack1.png");
		textureEnemigo2 = new Texture("enemyBlack2.png");
		textureEnemigo3 = new Texture("enemyBlack3.png");
		textureEnemigo4 = new Texture("enemyBlack4.png");
		textureEnemigo5 = new Texture("enemyBlack5.png");
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
		List<EnemigoActor> enemigosSpawn = new ArrayList<EnemigoActor>();
		
		enemigosSpawn.add(enemigo1);
		enemigosSpawn.add(enemigo2);
		enemigosSpawn.add(enemigo3);
		enemigosSpawn.add(enemigo4);
		enemigosSpawn.add(enemigo5);
		enemigosSpawn.add(enemigo6);
		enemigosSpawn.add(enemigo7);
		enemigosSpawn.add(enemigo8);
		enemigosSpawn.add(enemigo9);
		enemigosSpawn.add(enemigo10);
		enemigosSpawn.add(enemigo11);
		enemigosSpawn.add(enemigo12);
		enemigosSpawn.add(enemigo13);
		enemigosSpawn.add(enemigo14);
		enemigosSpawn.add(enemigo15);
		enemigosSpawn.add(enemigo16);
		enemigosSpawn.add(enemigo17);
		enemigosSpawn.add(enemigo18);
		enemigosSpawn.add(enemigo19);
		enemigosSpawn.add(enemigo20);
		enemigosSpawn.add(enemigo21);
		enemigosSpawn.add(enemigo22);
		enemigosSpawn.add(enemigo23);
		enemigosSpawn.add(enemigo24);
		enemigosSpawn.add(enemigo25);
	    
	    enemigo2.setPosition(stage.getWidth(), 300);
		enemigo2.getBb().setX(enemigo2.getX());
		enemigo2.getBb().setY(enemigo2.getY());
		enemigo7.setPosition(enemigo2.getX()+enemigo2.getWidth()+20, 300);
		enemigo7.getBb().setX(enemigo7.getX());
		enemigo7.getBb().setY(enemigo7.getY());
		enemigo12.setPosition(enemigo7.getX()+enemigo7.getWidth()+20, 300);
		enemigo12.getBb().setX(enemigo12.getX());
		enemigo12.getBb().setY(enemigo12.getY());
		enemigo17.setPosition(enemigo12.getX()+enemigo12.getWidth()+20, 300);
		enemigo17.getBb().setX(enemigo17.getX());
		enemigo17.getBb().setY(enemigo17.getY());
		enemigo22.setPosition(enemigo17.getX()+enemigo17.getWidth()+20, 300);
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

//		timer = (float) (10 + Math.random());
	}
	
	private void disparar(){
		LaserActor laser = new LaserActor();
		laser.setPosition(nave.getX() + nave.getWidth()/2 -
				laser.getWidth()/2, nave.getY() + nave.getHeight());
		laser.getBb().setX(laser.getX());
		laser.getBb().setY(laser.getY());
		stage.addActor(laser);
		lasers.add(laser);
		timerDisparar = 0.1f;
	}
	
//	private void dispararLaserEnemigo(){
//		LaserEnemigoActor laserEnemigo = new LaserEnemigoActor();
//		laserEnemigo.setPosition(enemigo.getX() + enemigo.getWidth()/2 -
//				laserEnemigo.getWidth()/2, enemigo.getY());
//		laserEnemigo.getBb().setX(laserEnemigo.getX());
//		laserEnemigo.getBb().setY(laserEnemigo.getY());
//		stage.addActor(laserEnemigo);
//		laserEnemigos.add(laserEnemigo);
//		timerEnemigo = (float) (1.5 + Math.random());
//		game.laserSound.play();
//	}
	
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
		ufo = new UfoActor();
		ufo.setPosition(stage.getWidth(), stage.getHeight()-150);
		ufo.getBb().setX(ufo.getX());
		ufo.getBb().setY(ufo.getY());
		stage.addActor(ufo);
		ufos.add(ufo);
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
