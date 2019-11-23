package com.lukategames.game.api;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game {

    private SpriteBatch batch;
    private Scene scene;
    private OrthographicCamera camera;

    public Game() {
        this.batch = new SpriteBatch();
        this.scene = new Scene();

        camera = new OrthographicCamera(Constants.WIDTH, Constants.HEIGHT);
        camera.update();

        Layer layer = new Layer();
        Sprite sprite = new Sprite(new Image("badlogic.jpg", 0.8f));
        Sprite sprite2 = new Sprite(new Image("badlogic.jpg"));

        layer.addSprite(sprite);
        layer.addSprite(sprite2);
        scene.addLayer(layer);
    }

    public void render() {
        Gdx.gl.glClearColor(0.5f, 0.2f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.projection);
        batch.begin();
        scene.draw(batch);
        batch.end();
    }
}
