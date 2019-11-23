package com.lukategames.game.api;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lukategames.game.api.interfaces.Drawable;

import java.util.TreeMap;

public class Scene implements Drawable {

    private TreeMap<Integer, Layer> layers = new TreeMap<>();

    @Override
    public void draw(SpriteBatch batch) {
        for(Layer layer : layers.values()) {
            layer.draw(batch);
        }
    }

    public void addLayer(int i, Layer layer) {
        this.layers.put(i, layer);
    }
}
