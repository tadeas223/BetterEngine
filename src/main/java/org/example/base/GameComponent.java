package org.example.base;

import org.example.interfaces.Updatable;

import java.util.HashSet;

public abstract class GameComponent implements Updatable {
    public HashSet<Class<? extends GameComponent>> requirements = new HashSet<>();

    private GameObject source;

    protected abstract void requirements();

    public void require(Class<? extends GameComponent> componentClass) {
        requirements.add(componentClass);
    }

    public GameObject getSource() {
        return source;
    }

    public void setSource(GameObject source) {
        this.source = source;
    }

    public Class<? extends GameComponent>[] getRequirements() {
        return (Class<? extends GameComponent>[]) requirements.toArray(Class[]::new);
    }
}
