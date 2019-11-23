package com.lukategames.game.api.actions;

import com.lukategames.game.api.Sprite;

public class Shake extends Action {

    private float initialPosition;
    private float currentPosition;
    private float shakeLength;
    private float shakeSpeed;
    private int counter;
    private int cmove;
    private int move;
    private float shakeAmount;
    private boolean shaking;

    public void update() {
        if (counter % 2 == 1) {
            currentPosition += -shakeSpeed;
        }
        else {
            currentPosition += shakeSpeed;
        }
        cmove += 1;

        if(cmove >= move) {
            cmove = 0;
            counter += 1;
        }

        if(counter >= shakeAmount) {
            currentPosition = initialPosition;
            shaking = false;
        }

    }

    public void shake(float initialPosition, float shakeLength, float shakeSpeed, float shakeAmount) {
        this.currentPosition = initialPosition;
        this.initialPosition = initialPosition;
        this.shakeLength = shakeLength;
        this.shakeSpeed = shakeSpeed;
        this.counter = 0;
        this.shakeAmount = shakeAmount;
        this.cmove = 0;
        this.move = Math.round(shakeLength/shakeSpeed);
        shaking = true;
        System.out.println(move);
    }

    public float getPosition() {
        return currentPosition;
    }

    @Override
    public void update(Sprite sprite) {
        if(shaking) {
            update();
            sprite.setPosition(getPosition(), sprite.getY());
        }
    }
}
