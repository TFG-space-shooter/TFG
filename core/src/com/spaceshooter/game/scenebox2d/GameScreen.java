package com.spaceshooter.game.scenebox2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.spaceshooter.game.AbstractScreen;
import com.spaceshooter.game.SpaceShooter;
import com.spaceshooter.game.entities.PlayerEntity;

public class GameScreen extends AbstractScreen {
	
	private Stage stage;
	private World world;
	private PlayerEntity player;

	public GameScreen(SpaceShooter game) {
		super(game);
	}
	
	@Override
	public void show() {
		Texture playerTexture = game.getManager().get("player.png");
		stage = new Stage(new FitViewport(1280, 720));
		world = new World(new Vector2(0,-20), true);
		player = new PlayerEntity(world, playerTexture, new Vector2(1, 2));
		stage.addActor(player);
	}
	
	@Override
	public void hide() {
		player.detach();
		player.remove();
	}
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0.2f, 0.9f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		world.step(delta, 6, 2);
		stage.draw();
	}
	
	@Override
	public void dispose() {
		stage.dispose();
		world.dispose();
	}

}
