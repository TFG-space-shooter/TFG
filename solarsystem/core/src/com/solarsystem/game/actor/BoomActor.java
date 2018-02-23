package com.solarsystem.game.actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class BoomActor extends Actor implements Disposable{
	
	private Texture boom;
	private TextureRegion boomRegion;
	private TextureRegion[] boomFrames;
	private Animation boomAnimacion;
	private float duracion = 0;
	private TextureRegion frame;

	public BoomActor() {
		boom = new Texture("boom2.png");
		boomRegion = new TextureRegion(boom, 450, 52);
		setSize(50, 52);
		TextureRegion[][] temp = boomRegion.split(450/9, 52);
		boomFrames = new TextureRegion[temp.length*temp[0].length];
		int indice = 0;
		for(int i = 0; i < temp.length; i++){
			for(int j = 0; j < temp[i].length; j++){
				boomFrames[indice++] = temp[i][j];
				if(i==7){
					boom.dispose();
				}
			}
		}
		boomAnimacion = new Animation(0.025f, boomFrames);
		boomAnimacion.setPlayMode(PlayMode.NORMAL);
		frame = (TextureRegion) boomAnimacion.getKeyFrame(duracion, false);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(frame, getX(), getY(), getOriginX(), getOriginY(), getWidth(),
				getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		duracion += delta;
		frame = (TextureRegion) boomAnimacion.getKeyFrame(duracion, false);
	}

	@Override
	public void dispose() {
		
		
	}

}
