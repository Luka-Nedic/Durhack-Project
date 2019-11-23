package com.lukategames.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.InputProcessor;
import com.lukategames.game.api.Game;


public class Main extends ApplicationAdapter {

	private Game game;

	@Override
	public void create () {
		this.game = new Game();
	}

	@Override
	public void render () {
		game.render();
	}

	@Override
	public void dispose () {

	}
}