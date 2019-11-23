package com.lukategames.game.api.actions;

public class FadeInit extends ActionInit {

    @Override
    public Action getObject() {
        return new Fade();
    }
}
