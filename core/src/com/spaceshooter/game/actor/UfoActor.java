package com.spaceshooter.game.actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class UfoActor extends Actor implements Disposable{
	
	private Texture ufo;
	private TextureRegion miUfo;
	private Rectangle bb;
	private int spin = 0;

	public Rectangle getBb() {
		return bb;
	}

	public void setBb(Rectangle bb) {
		this.bb = bb;
	}

	public UfoActor() {
		ufo = new Texture("ufoRed.png");
		miUfo = new TextureRegion(ufo);
		setSize(miUfo.getRegionWidth(), miUfo.getRegionHeight());
		bb = new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		spin+=5;
		batch.draw(miUfo, getX(), getY(), getOriginX()+getWidth()/2, getOriginY()+getHeight()/2, getWidth(),
				getHeight(), getScaleX(), getScaleY(), spin);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		moveBy(-350 * delta, 0);
		getBb().setX(getX());
		getBb().setY(getY());
		getBb().setWidth(getWidth());
		getBb().setHeight(getHeight());
	}
	
	@Override
	public void dispose() {
		ufo.dispose();
		
	}

}
