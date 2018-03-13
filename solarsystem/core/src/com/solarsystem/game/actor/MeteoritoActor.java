package com.solarsystem.game.actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class MeteoritoActor extends Actor implements Disposable{

	private Texture meteorito;
	private TextureRegion miMeteorito;
	private Rectangle bb;
	private Integer contador = 0;

	public Integer getContador() {
		return contador;
	}

	public void setContador(Integer contador) {
		this.contador = contador;
	}

	public Texture getMeteorito() {
		return meteorito;
	}

	public void setMeteorito(Texture meteorito) {
		this.meteorito = meteorito;
	}

	public Rectangle getBb() {
		return bb;
	}

	public void setBb(Rectangle bb) {
		this.bb = bb;
	}
	
	public MeteoritoActor(Texture meteorito) {
		this.meteorito = meteorito;
		miMeteorito = new TextureRegion(meteorito);
		setSize(miMeteorito.getRegionWidth(), miMeteorito.getRegionHeight());
		bb = new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(miMeteorito, getX(), getY(), getOriginX()+getWidth()/2, getOriginY()+getHeight()/2,
				getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		getBb().setX(getX());
		getBb().setY(getY());
		getBb().setWidth(getWidth());
		getBb().setHeight(getHeight());
		if(getX() < 0-getWidth()){
			setX(getStage().getWidth());
		}else if(getRight() > getStage().getWidth()+getWidth()){
			setX(-getWidth());
		}
	}

	@Override
	public void dispose() {
		meteorito.dispose();
		
	}
}
