package org.example;

import org.example.base.GameComponent;

public class TestComponent extends GameComponent {
    @Override
    public void start() {
        System.out.println("start");
    }

    @Override
    public void update(float deltaTime) {
        System.out.println("update: " + deltaTime);
    }
}
