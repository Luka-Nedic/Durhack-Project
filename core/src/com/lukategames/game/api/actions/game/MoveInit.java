package com.lukategames.game.api.actions.game;

import com.lukategames.game.api.actions.Action;
import com.lukategames.game.api.actions.ActionInit;

public class MoveInit extends ActionInit {

    @Override
    public Action getObject() {
        return new Move();
    }
}
