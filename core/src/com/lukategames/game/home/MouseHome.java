package com.lukategames.game.home;

import com.lukategames.game.api.Game;
import com.lukategames.game.api.components.Scene;
import com.lukategames.game.api.event.Event;

import java.awt.Point;

public class MouseHome extends Event<Point>{

    @Override
    public void handleEvent(Scene scene) {
        System.out.println(data.x + " " + data.y);
        if(scene.getSprite("play").getBoundingRectangle().contains(data.x, data.y)) {
            Game.activeScene = "game";
        }
    }
}
