package com.solarsystem.game.actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class EscudoActor extends Actor implements Disposable{
	
	private Texture escudo;
	private TextureRegion miEscudo;
	private Rectangle bb;

	public Rectangle getBb() {
		return bb;
	}

	public void setBb(Rectangle bb) {
		this.bb = bb;
	}

	public EscudoActor() {
		this.escudo = new Texture("shield_silver.png");
		miEscudo = new TextureRegion(escudo);
		setSize(miEscudo.getRegionWidth(), miEscudo.getRegionHeight());
		bb = new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(miEscudo, getX(), getY(), getOriginX(), getOriginY(), getWidth(),
				getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		moveBy(0, -100*delta);
		getBb().setX(getX());
		getBb().setY(getY());
		getBb().setWidth(getWidth());
		getBb().setHeight(getHeight());
	}

	@Override
	public void dispose() {
		escudo.dispose();
		
	}

}
