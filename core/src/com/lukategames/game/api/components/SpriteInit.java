package com.lukategames.game.api.components;

import com.lukategames.game.api.interfaces.Init;
import com.lukategames.game.api.texture.TextureManager;

public class SpriteInit implements Init<Sprite> {

    private String[] actions;
    private String imageName;
    private String name;
    private float x;
    private float y;

    @Override
    public Sprite getObject() {
        Sprite sprite = new Sprite(TextureManager.images.get(imageName), x, y);
        if(actions != null) {
            for (String action : actions) {
                sprite.addAction(action);
            }
        }
        return sprite;
    }

    public String getName() {
        return name;
    }
}
