package com.lukategames.game.api.actions;

import com.lukategames.game.api.Sprite;

public class Physics extends Action {

    private float gravity;
    private boolean gravityOn;
    private boolean impulse;

    private float deimpulseX;
    private float deimpulseY;
    private float accelerationX;
    private float targetAccelerationX;
    private float targetAccelerationY;
    private float accelerationY;

    public Physics(float gravity, boolean gravityOn) {
        this.gravity = gravity;
        this.gravityOn = gravityOn;
    }

    @Override
    public void update(Sprite sprite) {
        if(gravityOn)
            accelerationY -= gravity;
        if(impulse) {
            accelerationY += deimpulseY;

            if(Math.abs(accelerationY-targetAccelerationY) <= deimpulseY)
                deimpulseY = 0;

            if(Math.abs(accelerationX-targetAccelerationX) <= deimpulseX)
                deimpulseX = 0;
            accelerationX += deimpulseX;

            if(deimpulseX == 0 && deimpulseY == 0)
                impulse = false;
        }
        sprite.setPosition(sprite.getX()+accelerationX, sprite.getY()+accelerationY);
    }

    public void impulse(float accelerationX, float accelerationY, float targetAccelerationX, float targetAccelerationY, float deimpulseX, float deimpulseY) {
        this.accelerationX = accelerationX;
        this.accelerationY = accelerationY;
        this.targetAccelerationY = targetAccelerationY;
        this.targetAccelerationX = targetAccelerationX;
        this.deimpulseY = deimpulseY;
        this.deimpulseX = deimpulseX;
        this.impulse = true;
    }

    public void impulse(float accelerationX, float accelerationY, float deimpulseX, float deimpulseY) {
        this.accelerationX = accelerationX;
        this.accelerationY = accelerationY;
        this.targetAccelerationY = 0;
        this.targetAccelerationX = 0;
        this.deimpulseY = deimpulseY;
        this.deimpulseX = deimpulseX;
        this.impulse = true;
    }
}
