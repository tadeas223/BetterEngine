package org.example.base.execution.workables;

import org.example.base.Engine;
import org.example.base.execution.Work;
import org.example.base.execution.Workable;
import org.example.base.graphics.Renderer;

public class RenderWork implements Workable {
    @Override
    public void doWork(Work work) {
        Renderer renderer = work.getObject().getComponent(Renderer.class);

    }
}
