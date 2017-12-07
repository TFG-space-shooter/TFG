package com.spaceshooter.game.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class PuntuacionActor extends Actor{
	
	private int puntuacion;
	private BitmapFont font;
	
	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public PuntuacionActor(BitmapFont font) {
		this.font = font;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		font.draw(batch, Integer.toString(puntuacion), getX(), getY());
	}

}
