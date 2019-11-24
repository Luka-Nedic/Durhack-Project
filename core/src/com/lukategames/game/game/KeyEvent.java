package com.lukategames.game.game;

import com.lukategames.game.api.actions.game.Physics;
import com.lukategames.game.api.components.Scene;
import com.lukategames.game.api.components.Sprite;
import com.lukategames.game.api.event.Event;

public class KeyEvent extends Event<Integer> {
    @Override
    public void handleEvent(Scene scene) {
        Sprite player = scene.getSprite("player");

        if(data == 21) {
            ((Physics) player.getAction("Physics")).impulse(-5, 0, 0.05f );
        } else if(data == 22) {
            ((Physics) player.getAction("Physics")).impulse(5, 0, -0.05f );
        }
    }
}
