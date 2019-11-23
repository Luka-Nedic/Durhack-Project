package com.lukategames.game.api;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game {

    private SpriteBatch batch;
    private Scene scene;

    public Game() {
        this.batch = new SpriteBatch();
        this.scene = new Scene();

        Layer layer = new Layer();
        Sprite sprite = new Sprite(new Texture("badlogic.jpg"));
        layer.addSprite(sprite);
        scene.addLayer(layer);
    }

    public void render() {
        Gdx.gl.glClearColor(0.5f, 0.2f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        scene.draw(batch);
        batch.end();
    }
}
