package com.lukategames.game.api;

import com.badlogic.gdx.graphics.Texture;

public class Image extends Texture {

    private float scale;

    public Image(String internalPath, float scale) {
        super(internalPath);
        this.scale = scale;
    }

    public Image(String internalPath) {
        super(internalPath);
        this.scale = 1.0f;
    }

    public float getScale() {
        return this.scale;
    }

}
