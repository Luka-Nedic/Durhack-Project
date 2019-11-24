package com.lukategames.game.home;

import com.lukategames.game.api.actions.game.Physics;
import com.lukategames.game.api.components.Scene;
import com.lukategames.game.api.trigger.Trigger;

public class Jump extends Trigger {
    @Override
    public boolean active(Scene scene) {
        return scene.getSprite("player").getY() < -220;
    }

    @Override
    public void trigger(Scene scene) {
        Physics physics = (Physics) scene.getSprite("player").getAction("Physics");
        physics.impulse(0,15, 0, 0, 0, -0.1f);
    }
}
