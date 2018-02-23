package com.solarsystem.game.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class EnergiaActor extends Actor{
	
	private int energia;
	private BitmapFont font;
	
	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public EnergiaActor(BitmapFont font) {
		this.font = font;
		font.getData().setScale(1.2f);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		font.draw(batch, Integer.toString(energia), getX(), getY());
	}

}
