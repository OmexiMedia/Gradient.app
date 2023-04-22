package src.elements;

import src.MainPanel;

import java.awt.*;

public class Cube extends Rectangle {
    public Color color1;
    public Color color2;
    public MainPanel mp;
    public Cube(int x, int y, int width, int height, int parentWidth, int parentHeight, Color color1, Color color2, MainPanel mp){
        super(x, y, width, height);

        x = (parentWidth/2)-(width/2);
        y = (parentHeight/2)-(height/2);
        this.x = x;
        this.y = y;
        this.color1 = color1;
        this.color2 = color2;
        this.mp = mp;
        System.out.println("created cube with x1: " + x + " and x2: " + x+width + " and y1: " + y + " and y2: " + y+height);

    }
    public Graphics2D cubeG2d(Graphics2D g2d){
        g2d.setPaint(null);
        GradientPaint gp = new GradientPaint(this.x, this.y, color1, this.x+width, this.height+height, color2);
        g2d.setPaint(gp);

        return g2d;
    }
}

