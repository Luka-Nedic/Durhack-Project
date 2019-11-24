package com.lukategames.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.lukategames.game.api.Game;
import com.lukategames.game.game.Bounce;
import com.lukategames.game.game.Death;
import com.lukategames.game.game.GoHome;
import com.lukategames.game.game.KeyEvent;
import com.lukategames.game.game.Spawn;
import com.lukategames.game.game.Switch;
import com.lukategames.game.home.Jump;
import com.lukategames.game.home.MouseHome;


public class Main extends ApplicationAdapter {

	static {
		Game.triggers.put("jump", new Jump());
		Game.triggers.put("bounce", new Bounce());
		Game.triggers.put("switch", new Switch());
		Game.triggers.put("spawn", new Spawn());
		Game.triggers.put("death", new Death());
		Game.triggers.put("ghome", new GoHome());
		Game.events.put("mouse", new MouseEvent());
		Game.events.put("mousehome", new MouseHome());
		Game.events.put("key", new KeyEvent());
	}

	private Game game;

	@Override
	public void create () {
		this.game = new Game();
        game.create();
		Gdx.input.setInputProcessor(game);
	}

	@Override
	public void render () {
		game.render();
	}

	@Override
	public void dispose () {

	}
}