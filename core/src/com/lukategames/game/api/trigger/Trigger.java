package com.lukategames.game.api.trigger;

import com.lukategames.game.api.components.Scene;

public abstract class Trigger {

    public abstract boolean active(Scene scene);
    public abstract void trigger(Scene scene);

}
