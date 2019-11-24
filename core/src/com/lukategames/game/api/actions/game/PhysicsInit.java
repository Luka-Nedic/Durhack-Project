package com.lukategames.game.api.actions.game;

import com.lukategames.game.api.actions.Action;
import com.lukategames.game.api.actions.ActionInit;

public class PhysicsInit extends ActionInit {

    public float gravity;
    public boolean gravityOn;

    @Override
    public Action getObject() {
        return new Physics(gravity, gravityOn);
    }
}
