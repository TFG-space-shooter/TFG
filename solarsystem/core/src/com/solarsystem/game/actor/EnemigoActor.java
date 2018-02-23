package com.solarsystem.game.actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class EnemigoActor extends Actor implements Disposable{
	
	private Texture enemigo;
	private TextureRegion miEnemigo;
	private Rectangle bb;
	private Integer contador = 0;

	public Integer getContador() {
		return contador;
	}

	public void setContador(Integer contador) {
		this.contador = contador;
	}

	public Texture getEnemigo() {
		return enemigo;
	}

	public void setEnemigo(Texture enemigo) {
		this.enemigo = enemigo;
	}

	public Rectangle getBb() {
		return bb;
	}

	public void setBb(Rectangle bb) {
		this.bb = bb;
	}
	
	public EnemigoActor(Texture enemigo) {
		this.enemigo = enemigo;
		miEnemigo = new TextureRegion(enemigo);
		setSize(miEnemigo.getRegionWidth(), miEnemigo.getRegionHeight());
		bb = new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(miEnemigo, getX(), getY(), getOriginX(), getOriginY(), getWidth(),
				getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
//		if(getX() < 100){
//			moveBy(0, 0);
//		}else{
//			if(getEnemigo().getWidth()==104||getEnemigo().getWidth()==82){
//				moveBy(-300*delta, 0);
//			}else{
//				moveBy(300*delta, 0);
//			}
//		}
		getBb().setX(getX());
		getBb().setY(getY());
		getBb().setWidth(getWidth());
		getBb().setHeight(getHeight());
	}

	@Override
	public void dispose() {
		enemigo.dispose();
		
	}
	



}
