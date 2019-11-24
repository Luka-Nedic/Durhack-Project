package com.lukategames.game.game;

import com.badlogic.gdx.graphics.Texture;
import com.lukategames.game.api.Game;
import com.lukategames.game.api.components.Scene;
import com.lukategames.game.api.components.Sprite;
import com.lukategames.game.api.texture.Image;
import com.lukategames.game.api.texture.TextureManager;
import com.lukategames.game.api.trigger.ActiveTrigger;

import static com.lukategames.game.api.Constants.HEIGHT;
import static com.lukategames.game.api.Constants.WIDTH;

public class Spawn extends ActiveTrigger {

    private int tileCounter = 7;
    private float last;

    @Override
    public void trigger(Scene scene) {
        Game.cameraMove.move(0, Game.camera.position.y, 0, Game.camera.position.y - 1, 0.75f);
        if (Game.camera.position.y - last > 130) {
            float y = HEIGHT/2 + Game.camera.position.y +((float) Math.random()*20);
            float x = (float) ((Math.random() * WIDTH) - WIDTH / 2);

            Sprite sprite = new Sprite(TextureManager.images.get("path"), x, y);
            scene.getLayers().get(0).addSprite("tile" + tileCounter, sprite);
            tileCounter++;
            last = Game.camera.position.y;
        }
    }
}
