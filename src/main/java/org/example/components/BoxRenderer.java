package org.example.components;

import org.example.base.graphics.Renderer;

import java.awt.*;

public class BoxRenderer extends Renderer {
    private Color color;

    public BoxRenderer(Color color) {
        this.color = color;
    }

    @Override
    protected void renderStart() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect((int) getSource().getTransform().getX(),
                (int) getSource().getTransform().getY()
                ,(int) getSource().getTransform().getWidth(),
                (int) getSource().getTransform().getHeight());
    }

    @Override
    protected void requirements() {

    }

    @Override
    public void update(float deltaTime) {

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
