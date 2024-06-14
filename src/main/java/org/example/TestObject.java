package org.example;

import org.example.base.GameObject;

public class TestObject extends GameObject {

    @Override
    protected void init() {
        addComponent(new TestComponent());
    }
}
