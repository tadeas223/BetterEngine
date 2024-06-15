package org.example.base.execution.workables;

import org.example.base.Engine;
import org.example.base.execution.Work;
import org.example.base.execution.Workable;

public class DestroyWork implements Workable {
    @Override
    public void doWork(Work work) {
        work.getObject().onDestroy();
        Engine.getInstance().removeObject(work.getObject());
    }
}
