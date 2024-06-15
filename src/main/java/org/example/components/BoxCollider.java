package org.example.components;

import org.example.base.GameComponent;

import java.awt.*;

public class BoxCollider extends GameComponent {
    private Rectangle rectangle = null;
    private boolean trigger = false;

    public BoxCollider() {}

    public BoxCollider(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public BoxCollider(Rectangle rectangle, boolean isTrigger) {
        this.rectangle = rectangle;
        this.trigger = isTrigger;
    }

    @Override
    protected void requirements() {

    }

    @Override
    public void start() {
        if(rectangle == null) {
            rectangle = new Rectangle((int) getSource().getTransform().getX(),
                    (int) getSource().getTransform().getY(),
                    (int) getSource().getTransform().getWidth(),
                    (int) getSource().getTransform().getHeight());
        }
    }

    @Override
    public void update(float deltaTime) {

    }

}
