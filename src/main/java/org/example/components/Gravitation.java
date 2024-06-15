package org.example.components;

import org.example.base.GameComponent;

public class Gravitation extends GameComponent {
    private float mass = 10;
    private float gravity = 10;

    public Gravitation() {
    }

    public Gravitation(float mass, float gravity) {
        this.mass = mass;
        this.gravity = gravity;
    }

    @Override
    protected void requirements() {

    }

    @Override
    public void start() {

    }

    @Override
    public void update(float deltaTime) {
        float a = gravity / mass;

        getSource().getTransform().addY(mass * gravity * deltaTime);
    }

    //region Get&Set

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    //endregion
}
