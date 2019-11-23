package com.lukategames.game.api;

import com.badlogic.gdx.Gdx;

public class Constants {


    public static final int HEIGHT = Gdx.graphics.getHeight();
    public static final int WIDTH = Gdx.graphics.getWidth();

    public static float RATIO = WIDTH/1125f > HEIGHT/2436f ? WIDTH/1125f : HEIGHT/2436f;

}
