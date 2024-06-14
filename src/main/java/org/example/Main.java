package org.example;

import org.example.base.Engine;

public class Main {
    public static void main(String[] args) {
        Engine.start();
        Engine.setFps(10);
        Engine.createObject(new TestObject());

    }
}