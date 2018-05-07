package com.solarsystem.game.actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BarraActor extends Actor {
	
	private Texture barra;
	private float health;
	
	public float getHealth() {
		return health;
	}

	public void setHealth(float health) {
		this.health = health;
	}

	public BarraActor(){
		barra = new Texture("vidajefe.png");
		setSize(barra.getWidth(), barra.getHeight());
		health = 1;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(barra, getX(), getY(), 0, 0, (int) (getWidth()*getHealth()), ((int) getHeight()));
	}

}
