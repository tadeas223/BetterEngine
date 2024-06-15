package org.example.base;

import org.example.base.execution.Work;
import org.example.base.execution.WorkType;
import org.example.base.execution.Worker;
import org.example.base.graphics.GameFrame;
import org.example.base.graphics.GamePanel;
import org.example.base.graphics.Renderer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Engine {
    private static final Engine instance = new Engine();

    private final GamePanel gamePanel = new GamePanel();
    private GameFrame gameFrame;

    private final HashSet<Renderer> renderers = new HashSet<>();
    private final HashSet<GameObject> objects = new HashSet<>();

    private final Worker worker = new Worker();

    private Engine() {}

    public static void start(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                instance.gameFrame =  new GameFrame();
                instance.gameFrame.add(instance.gamePanel);
            }
        });

        instance.worker.start();
    }

    //region static stuff
    public static GameObject[] getGameObjects(){
        return instance.objects.toArray(new GameObject[0]);
    }

    public static void createObject(GameObject object) {
        Worker worker = instance.getWorker();
        Work work = new Work(object, WorkType.CREATE);
        worker.addWork(work);
    }

    public static void destroyObject(GameObject object){
        Worker worker = instance.getWorker();
        Work work = new Work(object, WorkType.DESTROY);
        worker.addWork(work);
    }

    public static Engine getInstance() {
        return instance;
    }

    public static void setFps(int fps){
        instance.getWorker().setFps(fps);
    }
    //endregion

    //region Get&Set&Add&Remove
    public Worker getWorker() {
        return worker;
    }

    public void addObject(GameObject object) {
        objects.add(object);
    }

    public void removeObject(GameObject object) {
        objects.remove(object);
    }

    public void addRenderer(Renderer renderer) {
        renderers.add(renderer);
    }

    public void removeRenderer(Renderer renderer) {
        renderers.remove(renderer);
    }

    public Renderer[] getRenderers(){
        return renderers.toArray(Renderer[]::new);
    }

    public void renderScene(){
        gamePanel.renderObjects(renderers.toArray(Renderer[]::new));
    }

    //endregion
}
