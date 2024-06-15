package org.example.components;

import org.example.base.GameComponent;
import org.example.base.graphics.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageRenderer extends Renderer {
    BufferedImage image;

    public ImageRenderer(BufferedImage image) {
        this.image = image;
    }

    @Override
    protected void renderStart() {

    }

    @Override
    public void render(Graphics g) {
        g.fillRect((int) getSource().getTransform().getX(),
                (int) getSource().getTransform().getY(),
                (int) getSource().getTransform().getWidth(),
                (int) getSource().getTransform().getHeight());
    }

    @Override
    protected void requirements() {

    }

    @Override
    public void update(float deltaTime) {

    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
