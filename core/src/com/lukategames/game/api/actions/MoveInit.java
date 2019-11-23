package com.lukategames.game.api.actions;

public class MoveInit extends ActionInit {

    @Override
    public Action getObject() {
        return new Move();
    }
}
