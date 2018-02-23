package com.solarsystem.game.actor;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.solarsystem.game.Solarsystem;

public class LaserActor extends Actor implements Disposable{
	
	private Texture laser;
	private TextureRegion miLaser;
	private Rectangle bb;

	public Rectangle getBb() {
		return bb;
	}

	public void setBb(Rectangle bb) {
		this.bb = bb;
	}

	public LaserActor() {
		laser = new Texture("laserblue07.png");
		miLaser = new TextureRegion(laser);
		//		laser = new TextureRegion(Solarsystem.MANAGER.get("laserblue07.png",
//				Texture.class));
		setSize(miLaser.getRegionWidth(), miLaser.getRegionHeight());
		bb = new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(miLaser, getX(), getY(), getOriginX(), getOriginY(), getWidth(),
				getHeight(), getScaleX(), getScaleY(), getRotation());
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		moveBy(0, 700 * delta);
		getBb().setX(getX());
		getBb().setY(getY());
		getBb().setWidth(getWidth());
		getBb().setHeight(getHeight());
	}
	
	@Override
	public void dispose() {
		laser.dispose();
		
	}

}
