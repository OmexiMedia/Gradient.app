package src.elements;

import src.MainPanel;

import java.awt.*;

public class Cube extends Rectangle {
    public Color color1;
    public Color color2;
    public MainPanel mp;
    public float gx1, gx2, gy1, gy2, xnull, ynull;
    private int spin = 0;
    private boolean isSpinning = false;
    private boolean spinningLeft = false;
    private boolean spinningRight = false;

    public Cube(int x, int y, int width, int height, int parentWidth, int parentHeight, Color color1, Color color2, MainPanel mp){
        super(x, y, width, height);

        x = (parentWidth/2)-(width/2);
        y = (parentHeight/2)-(height/2);
        this.x = x;
        this.y = y;
        this.gx1 = x;
        this.gy1 = y;
        this.xnull = x;
        this.ynull = y;
        this.gx2 = x+width;
        this.gy2 = y+height;
        this.color1 = color1;
        this.color2 = color2;
        this.mp = mp;
        System.out.println("created cube with x1: " + x + " and x2: " + x+width + " and y1: " + y + " and y2: " + y+height);
        System.out.println("created cube with x1: " + gx1 + " and x2: " + gx2 + " and y1: " + gy1 + " and y2: " + gy2);

    }
    public Graphics2D cubeG2d(Graphics2D g2d){
        if (spinningRight){
            if (spin == 360){
                spin = 0;
            }else {
                spin++;
            }
        } else if (spinningLeft) {
            if (spin == -360){
                spin = 0;
        }else {
                spin--;
            }
        }

        g2d.setPaint(null);
        GradientPaint gp = new GradientPaint(gx1, gy1, color1, gx2, gy2, color2);
        g2d.setPaint(gp);
        if(this.isSpinning){
            //Rotate 45 degrees but keep the center position
            g2d.rotate(Math.toRadians(spin), this.x + (this.width / 2), this.y + (this.height / 2));
        }
        return g2d;
    }


    public void toggleSpin(String direction){
        if (direction.equals("right")){
            if (this.spinningRight){
                this.spinningRight = false;
                this.isSpinning = false;
            }else {
                this.spinningRight = true;
                this.isSpinning = true;
            }
        }else if (direction.equals("left")){
            if (this.spinningLeft){
                this.spinningLeft = false;
                this.isSpinning = false;
            }else {
                this.spinningLeft = true;
                this.isSpinning = true;
            }
        } else if (direction.equals("stop")){
            this.spinningLeft = false;
            this.spinningRight = false;
            this.isSpinning = false;
        }
    }
}

