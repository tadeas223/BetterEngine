package org.example;

import org.example.base.Engine;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        TestObject o = new TestObject("test");

        Engine.createObject(o);

        Engine.setFps(60);
        Engine.start();

    }
}