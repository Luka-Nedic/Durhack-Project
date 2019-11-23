package com.lukategames.game.api;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lukategames.game.api.interfaces.Drawable;

import java.util.ArrayList;
import java.util.HashMap;

public class Layer implements Drawable {

    private int opacity;
    private HashMap<String, Sprite> sprites = new HashMap<>();


    public Layer() {
        this.opacity = 100;
    }

    @Override
    public void draw(SpriteBatch batch) {
        for(Sprite sprite : sprites.values()) {
            sprite.draw(batch);
        }
    }

    public void addSprite(String name, Sprite sprite) {
        this.sprites.put(name, sprite);
    }

}
