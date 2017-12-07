package com.spaceshooter.game.actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.spaceshooter.game.SpaceShooter;

public class NaveActor extends Actor implements Disposable{
	
	private Texture nave;
	private TextureRegion miNave;
//	public Vector2 velocidad = new Vector2(0, 0);
	private Rectangle bb;
	
	public Rectangle getBb() {
		return bb;
	}

	public void setBb(Rectangle bb) {
		this.bb = bb;
	}

	public NaveActor() {
		nave = new Texture("playership3blue.png");
		miNave = new TextureRegion(nave);
//		nave = new TextureRegion(SpaceShooter.MANAGER.get("playership3blue.png",
//				Texture.class));
		setSize(miNave.getRegionWidth(), miNave.getRegionHeight());
		bb = new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(miNave, getX(), getY(), getOriginX(), getOriginY(), getWidth(),
				getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
//		moveBy(velocidad.x * delta, velocidad.y * delta);
		getBb().setX(getX());
		getBb().setY(getY());
		getBb().setWidth(getWidth());
		getBb().setHeight(getHeight());
//		if(getX() < 0){
//			setX(0);
//			velocidad.x = 0;
//		}else if(getRight() > getStage().getWidth()){
//			setX(getStage().getWidth() - getWidth());
//			velocidad.x = 0;
//		}
	}

	@Override
	public void dispose() {
		nave.dispose();
	}

}
