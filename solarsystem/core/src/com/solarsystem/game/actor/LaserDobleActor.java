package com.solarsystem.game.actor;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Disposable;

public class LaserDobleActor extends Group{

	private Rectangle bb;
	
	public Rectangle getBb() {
		return bb;
	}

	public void setBb(Rectangle bb) {
		this.bb = bb;
	}
	
	public LaserDobleActor(LaserActor laser1, LaserActor laser2){
		setSize(laser2.getRight()-laser1.getX(), laser1.getTop()-laser1.getY());
		bb = new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		getBb().setX(getX());
		getBb().setY(getY());
		getBb().setWidth(getWidth());
		getBb().setHeight(getHeight());
	}

}
