package com.lukategames.game.api.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lukategames.game.MouseEvent;
import com.lukategames.game.api.Game;
import com.lukategames.game.api.event.Event;
import com.lukategames.game.api.event.KeyListener;
import com.lukategames.game.api.event.MouseListener;
import com.lukategames.game.api.interfaces.Drawable;
import com.lukategames.game.api.trigger.Trigger;

import java.awt.Point;
import java.util.ArrayList;
import java.util.TreeMap;

import static com.lukategames.game.api.Constants.HEIGHT;
import static com.lukategames.game.api.Constants.WIDTH;

public class Scene implements Drawable, KeyListener, MouseListener {

    private ArrayList<String> triggers;
    private TreeMap<Integer, Layer> layers = new TreeMap<>();
    private String name;
    private Event<Point> mouseEvent;
    private Event<Integer> keyEvent;

    @Override
    public void draw(SpriteBatch batch) {
        for(String trig : triggers) {
            Trigger trigger = Game.triggers.get(trig);
            if(trigger.active(this))
                trigger.trigger(this);
        }
        for(Layer layer : layers.values()) {
            layer.draw(batch);
        }
    }

    public void addLayer(int i, Layer layer) {
        this.layers.put(i, layer);
    }

    public Sprite getSprite(String name) {
        for(Layer layer : layers.values()) {
            if(layer.containsSprite(name))
                return layer.getSprite(name);
        }
        return null;
    }

    public void setTriggers(ArrayList<String> triggers) {
        this.triggers = triggers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean collides(Sprite a, Sprite b) {
        return a.getBoundingRectangle().overlaps(b.getBoundingRectangle());
    }

    public void fireTrigger(String name) {
        Game.triggers.get(name).trigger(this);
    }

    @Override
    public void onKeyType(int keycode) {
        if(keyEvent != null) {
            keyEvent.setData(keycode);
            keyEvent.handleEvent(this);
        }
    }

    @Override
    public void onClick(int x, int y) {
        if(mouseEvent != null) {
            mouseEvent.setData(new Point(-WIDTH/2 + x, HEIGHT/2 - y));
            mouseEvent.handleEvent(this);
        }
    }

    public void setMouseEvent(Event<Point> mouseEvent) {
        this.mouseEvent = mouseEvent;
    }

    public void setKeyEvent(Event<Integer> keyEvent) {
        this.keyEvent = keyEvent;
    }

    public TreeMap<Integer, Layer> getLayers() {
        return layers;
    }
}
