package com.lukategames.game.api;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Layer implements Drawable {

    private int opacity;
    private ArrayList<Sprite> sprites = new ArrayList<Sprite>();

    public Layer() {
        this.opacity = 100;
    }

    @Override
    public void draw(SpriteBatch batch) {
        for(int i = 0; i < sprites.size(); i++) {
            sprites.get(i).draw(batch);
        }
    }

    public void addSprite(Sprite sprite) {
        this.sprites.add(sprite);
    }
}
