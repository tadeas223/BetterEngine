package org.example.base;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

public class KeyInput implements KeyListener {
    private HashSet<KeyEvent> keyEvents = new HashSet<>();

    public void addEvent(KeyEvent event) {
        keyEvents.add(event);
    }

    public void removeEvent(KeyEvent event) {
        keyEvents.remove(event);
    }

    public boolean getKey(int keyCode) {
        for(KeyEvent event : keyEvents){
            if(event.getKeyCode() == keyCode){
                return true;
            }
        }

        return false;
    }

    public boolean getKey(char keyChar) {
        for(KeyEvent event : keyEvents){
            if(event.getKeyChar() == keyChar){
                return true;
            }
        }

        return false;
    }

    private KeyEvent getEvent(int keyCode) {
        for(KeyEvent event : keyEvents){
            if(event.getKeyCode() == keyCode){
                return event;
            }
        }
        return null;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(!getKey(e.getKeyCode())){
            addEvent(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(getKey(e.getKeyCode())){
            removeEvent(getEvent(e.getKeyCode()));
        }
    }
}
