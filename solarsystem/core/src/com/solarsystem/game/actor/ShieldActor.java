package com.solarsystem.game.actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class ShieldActor extends Actor implements Disposable{

	private Texture shield;
	private TextureRegion miShield;
	private Rectangle bb;
	
	private int tipo;

	public int getTipo() {
		return tipo;
	}
	
	public Texture getShield() {
		return shield;
	}

	public void setShield(Texture shield) {
		this.shield = shield;
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

	public ShieldActor(Texture shield, int tipo) {
		this.shield = shield;
		this.tipo = tipo;
		miShield = new TextureRegion(shield);
		setSize(miShield.getRegionWidth(), miShield.getRegionHeight());
		bb = new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(miShield, getX(), getY(), getOriginX(), getOriginY(), getWidth(),
				getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		getBb().setX(getX());
		getBb().setY(getY());
		getBb().setWidth(getWidth());
		getBb().setHeight(getHeight());
	}

	@Override
	public void dispose() {
		shield.dispose();
		
	}
}
