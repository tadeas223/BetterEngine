package org.example.base.execution;

import org.example.base.GameObject;

public class Work {
    private GameObject object;
    private WorkType workType;
    private float deltaTime;

    public Work(GameObject object, WorkType workType, float deltaTime) {
        this.object = object;
        this.workType = workType;
        this.deltaTime = deltaTime;
    }

    public Work(GameObject object, WorkType workType) {
        this.object = object;
        this.workType = workType;
    }

    //region Get&Set

    public GameObject getObject() {
        return object;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public float getDeltaTime() {
        return deltaTime;
    }

    //endregion
}
