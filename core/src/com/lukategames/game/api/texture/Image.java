package com.lukategames.game.api.texture;

import com.badlogic.gdx.graphics.Texture;

public class Image extends Texture {

    private float scale;

    public Image(String internalPath, float scale) {
        super(internalPath);
        this.scale = scale;
    }

    public float getScale() {
        return this.scale;
    }

}
