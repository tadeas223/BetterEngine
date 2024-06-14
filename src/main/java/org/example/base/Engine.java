package org.example.base;

import org.example.base.execution.Work;
import org.example.base.execution.WorkType;
import org.example.base.execution.Worker;

import java.util.HashSet;

public class Engine {
    private static Engine instance = new Engine();

    private HashSet<GameObject> objects = new HashSet<>();
    private Worker worker = new Worker();

    private Engine() {}

    public static void start(){
        instance.worker.start();
    }
    public static GameObject[] getGameObjects(){
        return instance.objects.toArray(new GameObject[0]);
    }

    public static void createObject(GameObject object) {
        Worker worker = instance.getWorker();
        Work work = new Work(object, WorkType.CREATE);
        worker.addWork(work);
    }

    //region Get&Set&Add&Remove

    public Worker getWorker() {
        return worker;
    }

    public void addObject(GameObject object) {
        objects.add(object);
    }

    public static Engine getInstance() {
        return instance;
    }

    public static void setFps(int fps){
        instance.getWorker().setFps(fps);
    }

    //endregion
}
