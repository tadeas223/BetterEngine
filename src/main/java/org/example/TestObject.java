package org.example;

import org.example.base.GameObject;
import org.example.base.Vector2;
import org.example.base.graphics.Renderer;
import org.example.components.BoxRenderer;

import java.awt.*;

public class TestObject extends GameObject {
    public TestObject() {}

    public TestObject(String name) {
        super(name);
    }

    @Override
    protected void init() {
        getTransform().setPosition(new Vector2(50,50));
        getTransform().setSize(new Vector2(50,50));

        addComponent(new BoxRenderer(Color.black));
        addComponent(new TestComponent());
    }
}
