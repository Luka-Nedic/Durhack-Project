package com.lukategames.game.api.actions.game;

import com.lukategames.game.api.actions.Action;
import com.lukategames.game.api.components.Sprite;

public class Fade extends Action {

    private float opacity;
    private float initialOpacity;
    private float finalOpacity;
    private float fadeSpeed;
    private boolean fading;

    public void update() {
        float fade = initialOpacity > finalOpacity ? -fadeSpeed : fadeSpeed;
        opacity += fade;

        if(Math.abs(opacity-finalOpacity) <= fadeSpeed) {
            fading = false;
        }

    }

    public void fade(float initialOpacity, float finalOpacity, float fadeSpeed) {
        this.opacity = opacity;
        this.initialOpacity = initialOpacity;
        this.finalOpacity = finalOpacity;
        this.fadeSpeed = fadeSpeed;
        fading = true;
    }

    private float getOpacity() {
        return opacity;
    }



    @Override
    public void update(Sprite sprite) {
        if(fading) {
            update();
            sprite.setAlpha(getOpacity());
        }
    }
}
