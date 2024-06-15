package org.example.base.graphics;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Renderer[] renderers;
    public GamePanel() {
        setLayout(null);
        setDoubleBuffered(true);
        setVisible(true);
    }

    public void renderObjects(Renderer[] renderers) {
        this.renderers = renderers;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Renderer r : renderers){
            r.render(g);
        }

        g.dispose();
    }
}
