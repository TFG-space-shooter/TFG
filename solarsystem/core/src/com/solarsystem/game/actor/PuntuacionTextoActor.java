package com.solarsystem.game.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.solarsystem.game.util.Preferencias;

public class PuntuacionTextoActor extends Actor{
	
	
	private String texto;
	private BitmapFont font;

	
	public PuntuacionTextoActor(BitmapFont font) {
		this.font = font;
		font.getData().setScale(1.5f);
		if(Preferencias.getEspanol()){
			texto="Puntuación:";
		}else{
			texto="Score";
		}
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		font.draw(batch, texto, getX(), getY());
	}

}
