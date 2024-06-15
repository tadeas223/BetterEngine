package org.example.components;

import org.example.base.Engine;
import org.example.base.GameComponent;

public class MovementController extends GameComponent {
    private int speed = 200;

    public MovementController() {
    }

    public MovementController(int speed) {
        this.speed = speed;
    }

    @Override
    protected void requirements() {

    }

    @Override
    public void start() {

    }

    @Override
    public void update(float deltaTime) {
        if(Engine.getKeyInput().getKey('w')){
            getSource().getTransform().subtractY(speed * deltaTime);
        }
        if(Engine.getKeyInput().getKey('s')){
            getSource().getTransform().addY(speed * deltaTime);
        }

        if(Engine.getKeyInput().getKey('a')){
            getSource().getTransform().subtractX(speed * deltaTime);
        }
        if(Engine.getKeyInput().getKey('d')){
            getSource().getTransform().addX(speed * deltaTime);
        }
    }

    //region Get&Set

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //endregion
}
