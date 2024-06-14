package org.example.base;


import org.example.interfaces.Updatable;

import java.util.HashSet;

public abstract class GameObject implements Updatable {
    private final HashSet<GameComponent> components = new HashSet<>();

    protected abstract void init();
    @Override
    public void start() {
        init();

        for(GameComponent component : components){
            component.start();
        }
    }

    @Override
    public void update(float deltaTime) {
        for(GameComponent component : components){
            component.update(deltaTime);
        }
    }

    //region componentStuff

    public void addComponent(GameComponent component){
        components.add(component);
    }

    //endregion
}
