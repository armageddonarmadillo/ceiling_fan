package com.main;

import javax.swing.*;

public class Window extends JFrame{
    Scene current_scene;

    Window(Scene instance){
        current_scene = instance;
        add(instance);
        pack();
        setVisible(true);
        setSize(Look.ww, Look.wh);
        setLocationRelativeTo(null);
        setTitle("Ceiling Fan");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(instance);
    }
}
