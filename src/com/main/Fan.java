package com.main;

import java.awt.*;

public class Fan {
    float x, y, angle, rspeed, speed;
    int scale = 10;
    boolean cw = true;
    Polygon poly, vpoly;
    Color c;

    Fan(int x, int y){
        this.x = x;
        this.y = y;
        c = Color.ORANGE;
        poly = new Polygon();
        poly.addPoint(23 * scale, -3 * scale);
        poly.addPoint(23 * scale, 3 * scale);
        poly.addPoint(3 * scale, 3 * scale);
        poly.addPoint(3 * scale, 23 * scale);
        poly.addPoint(-3 * scale, 23 * scale);
        poly.addPoint(-3 * scale, 3 * scale);
        poly.addPoint(-23 * scale, 3 * scale);
        poly.addPoint(-23 * scale, -3 * scale);
        poly.addPoint(-3 * scale, -3 * scale);
        poly.addPoint(-3 * scale, -23 * scale);
        poly.addPoint(3 * scale, -23 * scale);
        poly.addPoint(3 * scale, -3 * scale);

        vpoly = new Polygon();
        for(int i = 0; i < poly.npoints; i++) vpoly.addPoint(poly.xpoints[i], poly.ypoints[i]);
        speed = 0;
    }

    void draw(Graphics g){
        update();
        g.setColor(c);
        g.fillPolygon(vpoly);
        g.setFont(g.getFont().deriveFont(24f));
        g.setColor(Color.GREEN);
        g.drawString("Press 1 to increase fan speed.", 15, 24);
        g.setColor(Color.CYAN);
        g.drawString("Press 2 to change fan direction.", 15, 48);
        g.setColor(Color.RED);
        g.drawString("Spinning " + (cw ? "clockwise" : "counter-clockwise"), 15, 72);
        g.setColor(Color.YELLOW);
        g.drawString("Spinning " + (speed > 0 ? (speed == 3 ? "faster!" : speed == 2 ? "fast" : "slow") : "stopped"), 15, 96);
    }

    void update(){
        rspeed = 1/(1000f / speed) * speed * (cw ? 1 : -1);
        angle += rspeed;
        for(int i = 0; i < poly.npoints; i++){
            int x_new = (int)Math.round(poly.xpoints[i] * Math.cos(angle) - poly.ypoints[i] * Math.sin(angle));
            int y_new = (int)Math.round(poly.xpoints[i] * Math.sin(angle) + poly.ypoints[i] * Math.cos(angle));
            vpoly.xpoints[i] = x_new;
            vpoly.ypoints[i] = y_new;
        }
        vpoly.translate((int)x, (int)y);
    }
}
