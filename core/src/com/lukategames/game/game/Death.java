package com.lukategames.game.game;

import com.lukategames.game.api.Constants;
import com.lukategames.game.api.Game;
import com.lukategames.game.api.actions.game.Fade;
import com.lukategames.game.api.components.Scene;
import com.lukategames.game.api.event.Event;
import com.lukategames.game.api.trigger.Trigger;

public class Death extends Trigger
{
    public static boolean death = false;

    @Override
    public boolean active(Scene scene) {
        return scene.getSprite("player").getY() - Game.camera.position.y < ((-5/12.0)* Constants.HEIGHT);
    }

    @Override
    public void trigger(Scene scene) {
        death = true;
    }
}
