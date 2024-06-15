package org.example.base.graphics;

import org.example.base.Engine;
import org.example.base.GameComponent;
import org.example.components.Transform;
import org.example.interfaces.Destroyable;

import java.awt.*;

public abstract class Renderer extends GameComponent implements Destroyable {

    protected abstract void renderStart();
    public abstract void render(Graphics g);

    @Override
    public void start() {
        Engine.getInstance().addRenderer(this);

        renderStart();
    }

    @Override
    public void onDestroy() {
        Engine.getInstance().removeRenderer(this);
    }
}
