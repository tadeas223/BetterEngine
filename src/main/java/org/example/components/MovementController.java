package org.example.components;

import org.example.base.Engine;
import org.example.base.GameComponent;

public class MovementController extends GameComponent {
    private int speed = 200;
    private boolean disableVertical;
    private boolean disableHorizontal;

    public MovementController() {
    }

    public MovementController(int speed, boolean disableVertical) {
        this.speed = speed;
        this.disableVertical = disableVertical;
    }

    public MovementController(int speed, boolean disableVertical, boolean disableHorizontal) {
        this.speed = speed;
        this.disableVertical = disableVertical;
        this.disableHorizontal = disableHorizontal;
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
        if(Engine.getKeyInput().getKey('w') && !disableVertical){
            getSource().getTransform().subtractY(speed * deltaTime);
        }
        if(Engine.getKeyInput().getKey('s') && !disableVertical){
            getSource().getTransform().addY(speed * deltaTime);
        }

        if(Engine.getKeyInput().getKey('a') && !disableHorizontal){
            getSource().getTransform().subtractX(speed * deltaTime);
        }
        if(Engine.getKeyInput().getKey('d') && !disableHorizontal){
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

    public boolean isDisableVertical() {
        return disableVertical;
    }

    public void setDisableVertical(boolean disableVertical) {
        this.disableVertical = disableVertical;
    }

    public boolean isDisableHorizontal() {
        return disableHorizontal;
    }

    public void setDisableHorizontal(boolean disableHorizontal) {
        this.disableHorizontal = disableHorizontal;
    }

    //endregion
}
