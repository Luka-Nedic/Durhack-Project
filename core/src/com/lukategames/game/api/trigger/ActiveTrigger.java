package com.lukategames.game.api.trigger;

import com.lukategames.game.api.components.Scene;

public abstract class ActiveTrigger extends Trigger {

    @Override
    public boolean active(Scene scene) {
        return true;
    }
}
