package com.lukategames.game.api.actions;

public class ShakeInit extends ActionInit {

    @Override
    public Action getObject() {
        return new Shake();
    }
}
