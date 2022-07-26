package com.main;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Look extends Scene{
    static int ww = 900, wh = 600;  // Window Width, Window Height
    Fan fan;

    Look() { init(); }

    void init() {
        fan = new Fan(ww / 2, wh / 2);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, ww, wh);
        fan.draw(g);
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_1) fan.speed = ++fan.speed % 4;
        if(e.getKeyCode() == KeyEvent.VK_2) fan.cw = !fan.cw;
    }
}
