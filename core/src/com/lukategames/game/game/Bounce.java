package com.lukategames.game.game;

import com.lukategames.game.api.Game;
import com.lukategames.game.api.actions.game.Move;
import com.lukategames.game.api.actions.game.Physics;
import com.lukategames.game.api.components.Layer;
import com.lukategames.game.api.components.Scene;
import com.lukategames.game.api.components.Sprite;
import com.lukategames.game.api.texture.TextureManager;
import com.lukategames.game.api.trigger.Trigger;

import static com.lukategames.game.api.Constants.HEIGHT;
import static com.lukategames.game.api.Constants.WIDTH;

public class Bounce extends Trigger {


    @Override
    public boolean active(Scene scene) {
        Sprite player = scene.getSprite("player");
        for(Layer layer : scene.getLayers().values()) {
            for(String sprite : layer.getSprites().keySet()) {
                if(sprite.contains("tile")) {
                    if(scene.collides(player, layer.getSprite(sprite)) && (player.getY()-player.getWidth()/2) > layer.getSprite(sprite).getY()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void trigger(Scene scene) {
        Physics physics = (Physics) scene.getSprite("player").getAction("Physics");
        physics.impulse(0,15, 0, 0, 0, -0.1f);

    }

}
