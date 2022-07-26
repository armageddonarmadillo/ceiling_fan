package com.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class Scene extends JPanel implements KeyListener {
    public abstract void paint(Graphics g);
    public abstract void keyPressed(KeyEvent e);
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
}
