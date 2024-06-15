package org.example;

import org.example.base.Engine;
import org.example.base.GameComponent;
import org.example.interfaces.Destroyable;

public class TestComponent extends GameComponent implements Destroyable {
    @Override
    public void start() {
       // System.out.println("start");
    }

    @Override
    public void update(float deltaTime) {
        System.out.println(deltaTime);
    }

    @Override
    public void onDestroy() {
        System.out.println("on Destroy");
    }

    @Override
    protected void requirements() {

    }
}
