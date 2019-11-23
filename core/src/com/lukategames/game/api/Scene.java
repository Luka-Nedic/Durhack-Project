package com.lukategames.game.api;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Scene implements Drawable {

    private ArrayList<Layer> layers = new ArrayList<Layer>();

    @Override
    public void draw(SpriteBatch batch) {
        for(int i = 0; i < layers.size(); i++) {
            layers.get(i).draw(batch);
        }
    }

    public void addLayer(Layer layer) {
        this.layers.add(layer);
    }

}
