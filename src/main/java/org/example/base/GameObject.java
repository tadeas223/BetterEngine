package org.example.base;


import org.example.components.Transform;
import org.example.exceptions.MissingComponent;
import org.example.exceptions.RequirementsMissingException;
import org.example.interfaces.Destroyable;
import org.example.interfaces.Updatable;

import java.util.HashSet;

public abstract class GameObject implements Updatable, Destroyable {
    private String name;

    private final HashSet<GameComponent> components = new HashSet<>();

    private boolean destroyed;

    private Transform transform;

    protected abstract void init();

    public GameObject() {}
    public GameObject(String name) { this.name = name; }

    @Override
    public void start() {
        transform = new Transform();
        addComponent(transform);

        if (!destroyed) {
            init();

            for(GameComponent component : components){
                component.start();
            }
        }
    }

    @Override
    public void update(float deltaTime) {
        if(!destroyed) {
            for(GameComponent component : components){
                component.update(deltaTime);
            }
        }
    }

    @Override
    public void onDestroy() {
        destroyed = true;
        for(GameComponent component : components){
            if(component instanceof Destroyable){
                ((Destroyable)component).onDestroy();
            }
        }
    }

    //region componentStuff
    public void addComponent(GameComponent component){
        component.requirements();
        for(Class<? extends GameComponent> componentClass : component.getRequirements()){
            if(!containsComponent(componentClass)){
                throw new RequirementsMissingException("Missing required component " +
                        componentClass.getName());
            }
        }

        component.setSource(this);
        components.add(component);
    }

    public boolean containsComponent(Class<? extends GameComponent> componentClass){
        for(GameComponent c : components){
            if(componentClass.isInstance(c)){
                return true;
            }
        }
        return false;
    }

    public <T extends GameComponent> T getComponent(Class<T> componentClass){
        for(GameComponent c : components) {
            if(componentClass.isInstance(c)){
                return componentClass.cast(c);
            }
        }

        throw new MissingComponent("The component \"" + componentClass.getName() + "\" is missing");
    }
    //endregion

    //region Get&Set

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Transform getTransform() {
        return transform;
    }

    //endregion
}
