package com.lukategames.game.api.components;

import com.lukategames.game.api.interfaces.Init;

public class LayerInit implements Init<Layer> {

    private SpriteInit[] sprites;
    private String name;
    private int zindex;

    @Override
    public Layer getObject() {
        Layer layer = new Layer();
        for(SpriteInit sprite : sprites)
            layer.addSprite(sprite.getName(), sprite.getObject());
        return layer;
    }

    public int getZindex() {
        return zindex;
    }
}
