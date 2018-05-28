package com.solarsystem.game.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.solarsystem.game.util.Preferencias;

public class EnergiaTextoActor extends Actor{
	
	private String texto;
	private BitmapFont font;

	public EnergiaTextoActor(BitmapFont font) {
		this.font = font;
		font.getData().setScale(1.5f);	
		if(Preferencias.getEspanol()){
			texto = "Energ�a:";
		}else{
			texto = "Energy:";
		}
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		font.draw(batch, texto, getX(), getY());
	}

}
