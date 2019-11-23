package com.lukategames.game.api;

public class Fade {

    private float opacity;
    private float initialOpacity;
    private float finalOpacity;
    private float fadeSpeed;
    private boolean fading;

    public void update() {
        if(fading) {
            float fade = initialOpacity > finalOpacity ? -fadeSpeed : fadeSpeed;
            opacity += fade;

            if(Math.abs(opacity-finalOpacity) <= fadeSpeed) {
                fading = false;
            }
        }
    }

    public void fade(float initialOpacity, float finalOpacity, float fadeSpeed) {
        this.opacity = opacity;
        this.initialOpacity = initialOpacity;
        this.finalOpacity = finalOpacity;
        this.fadeSpeed = fadeSpeed;
        fading = true;
    }

    public float getOpacity() {
        return opacity;
    }

}
