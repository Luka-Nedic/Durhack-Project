package com.lukategames.game.api;

import com.lukategames.game.api.actions.Action;
import com.lukategames.game.api.actions.ActionManager;
import com.lukategames.game.api.interfaces.Init;
import com.lukategames.game.api.texture.TextureManager;

public class SpriteInit implements Init<Sprite> {

    private String[] actions;
    private String imageName;
    private String name;

    @Override
    public Sprite getObject() {
        Sprite sprite = new Sprite(TextureManager.images.get(imageName));
        for(String action : actions) {
            sprite.addAction(action);
        }
        return sprite;
    }

    public String getName() {
        return name;
    }
}
