package com.lukategames.game.api;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Sprite extends com.badlogic.gdx.graphics.g2d.Sprite implements Drawable{

    public Sprite(Texture texture) {
        super(texture);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

}
