package com.lukategames.game.api.actions.game;

import com.lukategames.game.api.actions.Action;
import com.lukategames.game.api.components.Sprite;

public class Move extends Action {

    private float initialXPosition;
    private float finalXPosition;
    private float initialYPosition;
    private float finalYPosition;
    private float moveSpeed;
    private float currentXposition;
    private float currentYposition;
    private float gradient;
    private boolean moving;

    public void update() {
        if(moving) {
            if(initialYPosition != finalYPosition)
                currentYposition += moveSpeed * gradient;
            if(initialXPosition != finalXPosition)
                currentXposition += moveSpeed * gradient;

            if(finalXPosition == currentXposition && finalYPosition == currentYposition) {
                moving = false;
            }
        }
    }

    public void move(float initialXPosition, float initialYPosition, float finalXPosition, float finalYPosition, float moveSpeed) {
        this.initialXPosition = initialXPosition;
        this.initialYPosition = initialYPosition;
        this.finalXPosition = finalXPosition;
        this.finalYPosition = finalYPosition;
        this.currentYposition = initialYPosition;
        this.currentXposition = initialXPosition;
        this.moveSpeed = moveSpeed;
        moving = true;
        if(initialYPosition != finalYPosition && initialXPosition != finalXPosition) {
            this.gradient = (finalYPosition - initialYPosition)/(finalXPosition - initialXPosition);
        } else {
            this.gradient = 1;
        }
    }

    public float getXPosition() {
        return currentXposition;
    }

    public float getYPosition() {
        return currentYposition;
    }

    @Override
    public void update(Sprite sprite) {
        if(moving) {
            update();
            sprite.setPosition(getXPosition(), getYPosition());
        }
    }
}
