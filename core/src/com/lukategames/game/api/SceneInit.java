package com.lukategames.game.api;

import com.lukategames.game.api.interfaces.Init;


public class SceneInit implements Init<Scene> {

    private LayerInit[] layers;
    private String name;

    @Override
    public Scene getObject() {
        Scene scene = new Scene();
        for(LayerInit init : layers)
            scene.addLayer(init.getZindex(), init.getObject());
        return scene;
    }

}
