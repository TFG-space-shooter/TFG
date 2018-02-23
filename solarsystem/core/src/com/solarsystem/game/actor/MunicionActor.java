package com.solarsystem.game.actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class MunicionActor extends Actor implements Disposable{

	private Texture municion;
	private TextureRegion miMunicion;
	private Rectangle bb;
	private int tipo;

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Rectangle getBb() {
		return bb;
	}

	public void setBb(Rectangle bb) {
		this.bb = bb;
	}

	public MunicionActor(Texture municion, int tipo) {
		this.municion = municion;
		this.tipo = tipo;
		miMunicion = new TextureRegion(municion);
		setSize(miMunicion.getRegionWidth(), miMunicion.getRegionHeight());
		bb = new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(miMunicion, getX(), getY(), getOriginX(), getOriginY(), getWidth(),
				getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		moveBy(0, -100 * delta);
		getBb().setX(getX());
		getBb().setY(getY());
		getBb().setWidth(getWidth());
		getBb().setHeight(getHeight());
	}

	@Override
	public void dispose() {
		municion.dispose();
	}

}
