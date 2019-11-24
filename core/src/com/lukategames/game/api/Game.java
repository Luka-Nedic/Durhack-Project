package com.lukategames.game.api;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lukategames.game.api.actions.ActionManager;
import com.lukategames.game.api.actions.game.Move;
import com.lukategames.game.api.components.Scene;
import com.lukategames.game.api.components.SceneInit;
import com.lukategames.game.api.event.Event;
import com.lukategames.game.api.texture.Image;
import com.lukategames.game.api.texture.TextureManager;
import com.lukategames.game.api.trigger.Trigger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static com.lukategames.game.api.Constants.HEIGHT;
import static com.lukategames.game.api.Constants.WIDTH;

public class Game implements InputProcessor {

    private SpriteBatch batch;
    public static OrthographicCamera camera;
    public static HashMap<String, Trigger> triggers = new HashMap<>();
    public static HashMap<String, Event> events = new HashMap<>();
    public static HashMap<String, Scene> scenes = new HashMap<>();

    private Image background;
    private int hwidth;
    private int hheight;
    public static String activeScene;
    public static Move cameraMove = new Move();

    public Game() {
        this.batch = new SpriteBatch();
        camera = new OrthographicCamera(WIDTH, HEIGHT);
        camera.update();
    }

    public void create() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        GameConfig config = null;
        try {
            FileReader reader = new FileReader("config.json");
            config = gson.fromJson(reader, GameConfig.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Constants.RATIO = WIDTH/config.width < HEIGHT/config.height ? WIDTH/config.width : HEIGHT/config.height;
        System.out.println(Constants.RATIO);
        TextureManager.load(gson, config.imagePath);
        ActionManager.load(config.actionPath);

        try {
            FileReader reader = new FileReader(config.scenePath);
            GameInit init = gson.fromJson(reader, GameInit.class);
            for(com.lukategames.game.api.components.SceneInit scene : init.scenes)
                scenes.put(scene.getName(), scene.getObject());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        activeScene = config.activeScene;
        background = TextureManager.images.get(config.background);
        hheight = background.getHeight()/2;
        hwidth = background.getWidth()/2;
    }

    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cameraMove.update();
        camera.position.y = cameraMove.getYPosition();
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, camera.position.x-hwidth, camera.position.y-hheight);
        scenes.get(activeScene).draw(batch);
        batch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        scenes.get(activeScene).onKeyType(keycode);
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
        scenes.get(activeScene).onClick(screenX, screenY);
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

    private class GameConfig {
        private float width;
        private float height;
        private String scenePath;
        private String imagePath;
        private String actionPath;
        private String activeScene;
        private String background;
    }
}
