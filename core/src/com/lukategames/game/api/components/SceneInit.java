package com.lukategames.game.api.components;

import com.lukategames.game.api.Game;
import com.lukategames.game.api.interfaces.Init;

import java.util.ArrayList;


public class SceneInit implements Init<Scene> {

    private LayerInit[] layers;
    private String name;
    private String mouseEvent;
    private String keyEvent;

    private ArrayList<String> triggers;

    @Override
    public Scene getObject() {
        Scene scene = new Scene();
        scene.setTriggers(triggers);
        if(mouseEvent != null)
            scene.setMouseEvent(Game.events.get(mouseEvent));

        if(keyEvent != null)
            scene.setKeyEvent(Game.events.get(keyEvent));

        for(LayerInit init : layers)
            scene.addLayer(init.getZindex(), init.getObject());
        return scene;
    }

    public String getName() {
        return name;
    }
}
