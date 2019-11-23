package com.lukategames.game.api.texture;

import com.lukategames.game.api.interfaces.Init;

public class ImageInit implements Init<Image> {

    private String image;
    private String name;
    private float scale;

    public String getImage() {
        return image;
    }

    public float getScale() {
        return scale;
    }

    public String getName() {
        return name;
    }

    public Image getObject() {
        return new Image(image, scale);
    }

}
