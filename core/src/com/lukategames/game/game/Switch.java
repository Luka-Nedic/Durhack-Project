package com.lukategames.game.game;

import com.lukategames.game.api.components.Scene;
import com.lukategames.game.api.components.Sprite;
import com.lukategames.game.api.trigger.Trigger;

import static com.lukategames.game.api.Constants.WIDTH;

public class Switch extends Trigger {
    @Override
    public boolean active(Scene scene) {
        return scene.getSprite("player").getX() < -WIDTH/2 || scene.getSprite("player").getX() > WIDTH/2;
    }

    @Override
    public void trigger(Scene scene) {
        Sprite player = scene.getSprite("player");
        if(player.getX() < 0) {
            player.setPosition(WIDTH/2, player.getY());
        } else {
            player.setPosition(-WIDTH/2, player.getY());
        }
    }
}
