package com.lukategames.game.api.actions;

public class PhysicsInit extends ActionInit {

    public float gravity;
    public boolean gravityOn;

    @Override
    public Action getObject() {
        return new Physics(gravity, gravityOn);
    }
}
