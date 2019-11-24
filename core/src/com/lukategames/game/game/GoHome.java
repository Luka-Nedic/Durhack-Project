package com.lukategames.game.game;

import com.lukategames.game.api.Game;
import com.lukategames.game.api.actions.game.Move;
import com.lukategames.game.api.components.Scene;
import com.lukategames.game.api.trigger.Trigger;

public class GoHome extends Trigger
{
    @Override
    public boolean active(Scene scene) {
        return Death.death;
    }

    @Override
    public void trigger(Scene scene) {
        Game.activeScene = "home";
        Death.death = false;
        Game.camera.position.y = 0;
        Game.cameraMove = new Move();
        scene.getSprite("player").setPosition(0,0);
    }
}
