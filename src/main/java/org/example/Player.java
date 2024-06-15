package org.example;

import org.example.base.GameObject;
import org.example.base.Vector2;
import org.example.components.BoxRenderer;
import org.example.components.MovementController;

import java.awt.*;

public class Player extends GameObject {
    @Override
    protected void init() {
        getTransform().setSize(new Vector2(50,50));
        getTransform().setPosition(new Vector2(100,100));

        addComponent(new BoxRenderer(Color.red));
        addComponent(new MovementController());
    }
}
