package com.spaceshooter.game.actor;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class AnimatedActor extends Image{    
	private float stateTime = 0;
	Animation animation;
	
	public AnimatedActor(Animation animation) {
		super((NinePatch) animation.getKeyFrame(0));
		this.animation = animation;
	}
	
	@Override
	public void act(float delta){
		((TextureRegionDrawable)getDrawable()).setRegion((TextureRegion) animation.getKeyFrame(stateTime+=delta, true));
		super.act(delta);
	}
}