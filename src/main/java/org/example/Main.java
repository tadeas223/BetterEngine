package org.example;

import org.example.base.Engine;

public class Main {
    public static void main(String[] args) {
        Engine.createObject(new Player());

        Engine.start();

    }
}