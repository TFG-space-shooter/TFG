package com.spaceshooter.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class FondoActor extends Actor implements Disposable{
	
	private Texture fondo;
	private int sourceY = 0;

	public int getSourceY() {
		return sourceY;
	}

	public void setSourceY(int sourceY) {
		this.sourceY = sourceY;
	}
	
	public FondoActor() {
		fondo = new Texture("darkPurple.png");
		fondo.setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		sourceY-=1;
		batch.draw(fondo, 0, 0, 0, sourceY, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}


	@Override
	public void dispose() {
		fondo.dispose();
		
	}

}
