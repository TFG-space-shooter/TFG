package com.solarsystem.game.inputhandler;

import com.badlogic.gdx.InputAdapter;

public class EntradaNaveRaton extends InputAdapter{
	
private ControladorVirtual controlador;
	
	public EntradaNaveRaton(ControladorVirtual controlador){
		this.controlador = controlador;
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		controlador.obedeceRaton = false;
		return true;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		controlador.obedeceRaton = true;
		controlador.objetivoX = screenX;
		controlador.objetivoY = screenY;
		return true;
	}

}
