package org.example.base.execution;

import org.example.base.Engine;
import org.example.base.GameObject;
import org.example.base.execution.workables.CreateWork;
import org.example.base.execution.workables.DestroyWork;
import org.example.base.execution.workables.UpdateWork;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Worker extends Thread {
    private int fps = -1;
    private double drawInterval = (double) 1000000000 / fps;
    private float deltaTime;

    private final LinkedList<Work> queue = new LinkedList<>();
    private final LinkedList<Work> bufferQueue = new LinkedList<>();

    private final HashMap<WorkType,Workable> workables = new HashMap<>();

    public Worker() { addWorkables(); }

    private void addWorkables(){
        // TODO: Add new workables here
        workables.put(WorkType.UPDATE, new UpdateWork());
        workables.put(WorkType.CREATE,new CreateWork());
        workables.put(WorkType.DESTROY,new DestroyWork());
    }
    @Override
    public void run() {
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (true) {
            long time = System.currentTimeMillis();

            update();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if (remainingTime < 0) remainingTime = 0;

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            deltaTime = (float) (System.currentTimeMillis() - time) / 1000;
        }
    }

    public void update(){
        //add Updatables
        GameObject[] objects = Engine.getGameObjects();

        for (GameObject object : objects) {
            Work work = new Work(object, WorkType.UPDATE, deltaTime);
            addWork(work);
        }

        queue.addAll(bufferQueue);
        bufferQueue.clear();

        Iterator<Work> iterator = queue.iterator();

        while(iterator.hasNext()){
            Work work = iterator.next();
            Workable workable = workables.get(work.getWorkType());

            if(workable == null) throw new UnsupportedOperationException("This \"" +
                    work.getWorkType() +
                    "\" is not supported");

            workable.doWork(work);
        }

        queue.clear();

        Engine.getInstance().renderScene();
    }

    //region Get&Set&Add&Remove
    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = (fps == 0)? -1 : fps;

        drawInterval = (double) 1000000000 / fps;
    }

    public void addWork(Work work){
        bufferQueue.add(work);
    }

    //endregion
}
