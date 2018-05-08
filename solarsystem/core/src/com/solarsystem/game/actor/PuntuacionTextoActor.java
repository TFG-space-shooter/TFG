package com.solarsystem.game.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class PuntuacionTextoActor extends Actor{
	
	private String texto = "Puntuación:";
	private BitmapFont font;

	public PuntuacionTextoActor(BitmapFont font) {
		this.font = font;
		font.getData().setScale(1.5f);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		font.draw(batch, texto, getX(), getY());
	}

}
