package com.lukategames.game.api;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lukategames.game.api.actions.ActionManager;
import com.lukategames.game.api.texture.TextureManager;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Game implements InputProcessor {

    private SpriteBatch batch;
    private ArrayList<Scene> scenes = new ArrayList<Scene>();
    private OrthographicCamera camera;

    public Game() {
        this.batch = new SpriteBatch();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        TextureManager manager = new TextureManager(gson, "images.json");
        ActionManager actions = new ActionManager("actions.json");

        try {
            FileReader reader = new FileReader("test.json");
            GameInit init = gson.fromJson(reader, GameInit.class);
            for(SceneInit scene : init.scenes)
                scenes.add(scene.getObject());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        camera = new OrthographicCamera(Constants.WIDTH, Constants.HEIGHT);
        camera.update();
    }

    public void render() {
        Gdx.gl.glClearColor(0.5f, 0.2f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.projection);
        batch.begin();
        scenes.get(0).draw(batch);
        batch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    private class GameInit {
        private SceneInit[] scenes;
    }
}
