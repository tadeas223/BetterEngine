package org.example.components;

import org.example.base.Vector2;
import org.example.base.GameComponent;

public class Transform extends GameComponent {
    private Vector2 position = new Vector2(0,0);
    private Vector2 size = new Vector2(10,10);
    private float rotation = 0;

    @Override
    protected void requirements() {
        //none
    }

    @Override
    public void start() {

    }

    @Override
    public void update(float deltaTime) {

    }

    //region Get&Set

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setX(float x){
        position.x = x;
    }

    public void setY(float y){
        position.y = y;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public Vector2 getSize() {
        return size;
    }


    public void setSize(Vector2 size) {
        this.size = size;
    }

    public void setWidth(float width) {
        size.x = width;
    }

    public void setHeight(float height) {
        size.y = height;
    }

    public float getWidth() {
        return size.x;
    }

    public float getHeight() {
        return size.y;
    }
    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    //endregion
}
