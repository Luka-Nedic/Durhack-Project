package com.lukategames.game.api.event;

import com.lukategames.game.api.components.Scene;

public abstract class Event<T> {

    protected T data;

    public abstract void handleEvent(Scene scene);

    public void setData(T data) {
        this.data = data;
    }
}
