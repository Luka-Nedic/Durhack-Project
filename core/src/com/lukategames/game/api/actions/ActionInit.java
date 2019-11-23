package com.lukategames.game.api.actions;

import com.lukategames.game.api.interfaces.Init;


public class ActionInit implements Init<Action> {

    private String name;

    public String getName() {
        return name;
    }

    @Override
    public Action getObject() {
        return null;
    }
}
