package com.solarsystem.game.scenebox2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.solarsystem.game.AbstractScreen;
import com.solarsystem.game.Solarsystem;

public class Box2DScreen extends AbstractScreen{
	
	private World world;
	private Box2DDebugRenderer renderer;
	private OrthographicCamera camera;
	private Body naveBody, sueloBody, pinchoBody;
	private Fixture naveFixture, sueloFixture, pinchoFixture;
	private boolean debeSaltar, naveSaltando, naveViva = true;

	public Box2DScreen(Solarsystem game) {
		super(game);
	}
	
	@Override
	public void show() {
		world = new World(new Vector2(0,-30), true);
		renderer = new Box2DDebugRenderer();
		camera = new OrthographicCamera(16, 9);
		camera.translate(0, 1);
		
		world.setContactListener(new ContactListener(){

			@Override
			public void beginContact(Contact contact) {
				Fixture fixtureA = contact.getFixtureA();
				Fixture fixtureB = contact.getFixtureB();
				if(fixtureA.getUserData().equals("player") && fixtureB.getUserData().equals("floor")||
						fixtureA.getUserData().equals("floor") && fixtureB.getUserData().equals("player")){
					if(Gdx.input.isTouched()){
						debeSaltar = true;
					}
					naveSaltando = false;
				}
				if(fixtureA.getUserData().equals("player") && fixtureB.getUserData().equals("spike")||
						fixtureA.getUserData().equals("spike") && fixtureB.getUserData().equals("player")){
					naveViva = false;
				}
				
			}

			@Override
			public void endContact(Contact contact) {
				Fixture fixtureA = contact.getFixtureA();
				Fixture fixtureB = contact.getFixtureB();
				if(fixtureA.getUserData().equals("player") && fixtureB.getUserData().equals("floor")||
						fixtureA.getUserData().equals("floor") && fixtureB.getUserData().equals("player")){
					naveSaltando = true;
				}
				
			}

			@Override
			public void preSolve(Contact contact, Manifold oldManifold) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void postSolve(Contact contact, ContactImpulse impulse) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		BodyDef naveDef = createNaveBodyDef();
		BodyDef sueloDef = createSueloBodyDef();
		BodyDef pinchoDef = createPinchoBodyDef(5);
		
		naveBody = world.createBody(naveDef);
		sueloBody = world.createBody(sueloDef);
		pinchoBody = world.createBody(pinchoDef);
		
		PolygonShape naveShape = new PolygonShape();
		naveShape.setAsBox(0.5f, 0.5f);
		naveFixture = naveBody.createFixture(naveShape, 1);
		naveShape.dispose();
		
		PolygonShape sueloShape = new PolygonShape();
		sueloShape.setAsBox(500, 1);
		sueloFixture = sueloBody.createFixture(sueloShape, 1);
		sueloShape.dispose();
		
		pinchoFixture = createPinchoFixture(pinchoBody);
		
		naveFixture.setUserData("player");
		sueloFixture.setUserData("floor");
		pinchoFixture.setUserData("spike");
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(debeSaltar){
			debeSaltar = false;
			saltar();
			naveBody.applyAngularImpulse(-1, true);
		}
		if(Gdx.input.justTouched() && !naveSaltando){
			debeSaltar = true;
		}
		
		float velocidadY = pinchoBody.getLinearVelocity().y;
		pinchoBody.setLinearVelocity(-8, velocidadY);
		
		if(!naveViva && world.getBodyCount()==3){
			naveBody.destroyFixture(naveFixture);
			world.destroyBody(naveBody);
		}
		
		world.step(delta, 6, 2);
		camera.update();
		renderer.render(world, camera.combined);
	}
	
	private BodyDef createNaveBodyDef() {
		BodyDef def = new BodyDef();
		def.position.set(0 ,0.5f);
		def.type = BodyDef.BodyType.DynamicBody;
		return def;
	}
	
	private BodyDef createSueloBodyDef() {
		BodyDef def = new BodyDef();
		def.position.set(0 ,-1);
		return def;
	}
	
	private BodyDef createPinchoBodyDef(float x) {
		BodyDef def = new BodyDef();
		def.position.set(8 ,0.5f);
		def.type = BodyDef.BodyType.DynamicBody;
		return def;
	}
	
	private Fixture createPinchoFixture(Body pinchoBody){
		Vector2[] vertices = new Vector2[3];
		vertices[0] = new Vector2(-0.5f, -0.5f);
		vertices[1] = new Vector2(0.5f, -0.5f);
		vertices[2] = new Vector2(0, 0.5f);
		
		PolygonShape shape = new PolygonShape();
		shape.set(vertices);
		Fixture fix = pinchoBody.createFixture(shape, 1);
		shape.dispose();
		return fix;
	}
	
	private void saltar(){
		Vector2 position = naveBody.getPosition();
		naveBody.applyLinearImpulse(0, 10, position.x, position.y, true);
	}
	
	@Override
	public void dispose() {
		naveBody.destroyFixture(naveFixture);
		sueloBody.destroyFixture(sueloFixture);
		pinchoBody.destroyFixture(pinchoFixture);
		world.destroyBody(naveBody);
		world.destroyBody(sueloBody);
		world.destroyBody(pinchoBody);
		world.dispose();
		renderer.dispose();
	}

}
