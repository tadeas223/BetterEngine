package org.example.base.execution.workables;

import org.example.base.execution.Work;
import org.example.base.execution.Workable;

public class UpdateWork implements Workable {
    @Override
    public void doWork(Work work) {
        work.getObject().update(work.getDeltaTime());
    }
}
