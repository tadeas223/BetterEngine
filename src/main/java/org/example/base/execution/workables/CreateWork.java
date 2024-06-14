package org.example.base.execution.workables;

import org.example.base.Engine;
import org.example.base.execution.Work;
import org.example.base.execution.Workable;

public class CreateWork implements Workable {
    @Override
    public void doWork(Work work) {
        Engine.getInstance().addObject(work.getObject());
        work.getObject().start();
    }
}
