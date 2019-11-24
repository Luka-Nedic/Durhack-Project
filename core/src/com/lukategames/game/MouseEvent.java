package com.lukategames.game;

import com.lukategames.game.api.components.Scene;
import com.lukategames.game.api.event.Event;

import java.awt.Point;

public class MouseEvent extends Event<Point> {

    @Override
    public void handleEvent(Scene scene) {
        System.out.println("woop");
    }
}
