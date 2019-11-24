package com.lukategames.game.api.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lukategames.game.api.Constants;
import com.lukategames.game.api.actions.Action;
import com.lukategames.game.api.actions.ActionManager;
import com.lukategames.game.api.interfaces.Drawable;
import com.lukategames.game.api.texture.Image;
import com.lukategames.game.api.texture.TextureManager;

import java.util.ArrayList;
import java.util.HashMap;


public class Sprite extends com.badlogic.gdx.graphics.g2d.Sprite implements Drawable {

    private float scale;
    private float width;
    private float height;
    private float scaledWidth;
    private float scaledHeight;
    private float x;
    private float y;
    private HashMap<String, Action> actions = new HashMap<>();

    public Sprite(Image image) {
        super(image);

        scale = Constants.RATIO*image.getScale();
        setScale(scale);

        this.width = getWidth();
        this.height = getHeight();

        this.scaledWidth = width*scale;
        this.scaledHeight = width*scale;

        setPosition(0,0);
    }

    public Sprite(Image image, float x, float y) {
        super(image);

        scale = Constants.RATIO*image.getScale();
        setScale(scale);

        this.width = getWidth();
        this.height = getHeight();

        this.scaledWidth = width*scale;
        this.scaledHeight = height*scale;

        setPosition(x,y);
    }

    public void setPosition(float x, float y) {
        super.setPosition(x-width*(1-scale)/2 + (-scaledWidth)/2, y-height*(1-scale)/2 + (-scaledHeight)/2);
        this.x = x;
        this.y = y;
    }

    public void setTexture(String name) {
        setTexture(TextureManager.images.get(name));
        setScale(scale);
        setPosition(x,y);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        for(Action action : actions.values()) {
            action.update(this);
        }
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }


    public void addAction(String action) {
        actions.put(action, ActionManager.getAction(action));
    }

    public Action getAction(String action) {
        return actions.get(action);
    }

    public float getOpacity() {
        return this.getColor().a;
    }
}
