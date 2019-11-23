package com.lukategames.game.api;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Sprite extends com.badlogic.gdx.graphics.g2d.Sprite implements Drawable {

    public Sprite(Image image) {
        super(image);

        float scale = Constants.RATIO*image.getScale();
        setScale(scale);

        float width = getWidth();
        float height = getHeight();

        setPosition(-width*(1-scale)/2, -height*(1-scale)/2);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

}
