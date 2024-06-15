package org.example.base;

public class Vector2 {
    public float x;
    public float y;

    public Vector2(float y, float x) {
        this.y = y;
        this.x = x;
    }

    public void add(Vector2 v2){
        y += v2.y;
        x += v2.x;
    }

    public void subtract(Vector2 v2) {
        y -= v2.y;
        x -= v2.x;
    }
}
