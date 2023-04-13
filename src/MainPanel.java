package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

public class MainPanel extends JPanel {

    int colors;
    public Color color1, color2, objColor1, objColor2;
    private int hue1 = 0;
    private int hue2 = 0;
    public int gradientWidth;
    public int sleepTime;
    public Dimension currentSize;
    public int gradientHeight;
    public String name = "Main Panel";
    public boolean fade1;
    public boolean fade2;
    JFrame parent;
    public MyMenuBar menuBar;
    private float x1, y1, x2, y2;

    String red1, green1, blue1, red2, green2, blue2;
    public Rectangle cube;


    public MainPanel(JFrame parent) {
        //temp
        color1 = new Color(136, 190, 252);
        color2 = new Color(252, 138, 136);
        colors = 2;
        sleepTime = 1;

        //Setup
        setup();
        this.parent = parent;
        menuBar = new MyMenuBar(this);
        parent.setJMenuBar(menuBar);
        currentSize = parent.getSize();
        System.out.println("Size: " + currentSize.width + "/" + currentSize.height);

        x1 = 0;
        y1 = 0;
        gradientWidth = parent.getWidth();
        gradientHeight = parent.getHeight();
        x2 = gradientWidth;
        y2 = gradientHeight;

        //testing
        Dimension newSize = parent.getSize();
        int newWidth = newSize.width;
        int newHeight = newSize.height;
        setSize(newWidth, newHeight);

        this.addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                /*
                 Dimension newSize = parent.getSize();
                int oldWidth = currentSize.width;
                int oldHeight = currentSize.height;
                int newWidth = newSize.width;
                int newHeight = newSize.height;
                int deltaX = newWidth - oldWidth;
                int deltaY = newHeight - oldHeight;

                gradientWidth = newWidth - 1;
                gradientHeight = newHeight - 1;
                setSize(newWidth, newHeight);
                // Determine direction of resize
                String direction;
                if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    if (deltaX > 0) {
                        direction = "right";
                    } else {
                        direction = "left";
                    }
                } else if (Math.abs(deltaY) > Math.abs(deltaX)) {
                    if (deltaY > 0) {
                        direction = "down";
                    } else {
                        direction = "up";
                    }
                } else {
                    direction = "diagonal";
                }

                System.out.println("Window resized to " + newSize);
                System.out.println("Delta X: " + deltaX);
                System.out.println("Delta Y: " + deltaY);
                System.out.println("Direction of resize: " + direction);

                currentSize = newSize;
                repaint();

                 */

            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });
    }

    private void setup() {
        //Setup window/panel

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        gradientWidth = this.parent.getWidth();
        gradientHeight = this.parent.getHeight();
        this.menuBar.getRGB();
        //this.menuBar.getSpeed();

        // Cast the Graphics object to Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        // Set the initial positions of the gradient

        // Create a GradientPaint object with the current colors and positions
        GradientPaint gp = new GradientPaint(x1, y1, color1, x2, y2, color2);

        // Set the paint object to the Graphics2D object
        g2d.setPaint(gp);

        // Fill the background with the gradient paint
        g2d.fillRect(0, 0, gradientWidth, gradientHeight);

        //Colorhandling
        float[] hsbValues1 = new float[3];
        float[] hsbValues2 = new float[3];
        Color.RGBtoHSB(color1.getRed(), color1.getGreen(), color1.getBlue(), hsbValues1);
        hue1 = (int) (hsbValues1[0] * 360);
        Color.RGBtoHSB(color2.getRed(), color2.getGreen(), color2.getBlue(), hsbValues2);
        hue2 = (int) (hsbValues2[0] * 360);
        System.out.println("Hue1: " + hue1);
        System.out.println("Hue2: " + hue2);

        if (fade1 || fade2) {
            fade(hsbValues1, hsbValues2);
        }

        if(cube!=null){
            gp  = new GradientPaint((float) cube.getX(), (float) cube.getY(), objColor1, (float) (cube.getX()+cube.getWidth()), (float) (cube.getY()+cube.getHeight()), objColor2);
            g2d.setPaint(gp);
            g2d.fill(cube);
        }
    }

    public void gradient() {

        while (true) {


            try {
                // Perform the task here

                Thread.sleep(sleepTime);

                if ((x1 < gradientWidth) && (y1 == 0)) {
                    x1++;
                    x2--;
                    repaint();
                    // Sleep for 1-10 milliseconds

                } else if ((x1 == gradientWidth) && (y1 < gradientHeight)) {
                    y1++;
                    y2--;
                    repaint();
                    // Sleep for 1-10 milliseconds
                } else if ((y1 == gradientHeight) && (x1 > 0)) {
                    x1--;
                    x2++;
                    repaint();
                } else if ((x1 == 0) && (y1 > 0)) {
                    y1--;
                    y2++;
                    repaint();
                    // Sleep for 1-10 milliseconds
                } else {
                    /*
                     if (!((x1<gradientWidth)&&(x1>0)&&(x2<gradientWidth)&&(x2>0))){
                        if (!(x1<gradientWidth)){
                            x1--;
                            System.out.println("x1<width");
                        } else if (!(x1>0)) {
                            x1++;
                            System.out.println("x1<0");
                        } else if (!(x2<gradientWidth)) {
                            x2--;
                            System.out.println("x2>width");
                        } else if (!(x2>0)) {
                            x2++;
                            System.out.println("x2<0");
                        }

                    }

                     */
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void fade(float[] hsbValues1, float[] hsbValues2) {

        if (fade1) {
           if(hsbValues1[0] <= 1.0f){
               color1 = Color.getHSBColor(hsbValues1[0]+0.001f, hsbValues1[1], hsbValues1[2]);
           }else if(hsbValues1[0] >= 1.0f){
               color1 = Color.getHSBColor(0, hsbValues1[1], hsbValues1[2]);
           }
        }
        System.out.println("b");
        if (fade2) {
            if(hsbValues2[0] <= 1.0f){
                color2 = Color.getHSBColor(hsbValues2[0]+0.001f, hsbValues2[1], hsbValues2[2]);
            }else if(hsbValues2[0] >= 1.0f){
                color2 = Color.getHSBColor(0, hsbValues2[1], hsbValues2[2]);
            }
        }


    }

    public char getMinusOrPlus() {
        Random rand = new Random();
        int randomInt = rand.nextInt(2);

        if (randomInt == 0) {
            return '-';
        } else if (randomInt == 1) {
            return '+';
        } else {
            // Return something else if desired
            return ' ';
        }
    }

    public ArrayList<Integer> getRgbList() {
        int r1 = color1.getRed();
        int r2 = color2.getRed();
        int g1 = color1.getGreen();
        int g2 = color2.getGreen();
        int b1 = color1.getBlue();
        int b2 = color2.getBlue();

        ArrayList<Integer> rgbList = new ArrayList<>();
        rgbList.add(r1);
        rgbList.add(g1);
        rgbList.add(b1);
        rgbList.add(r2);
        rgbList.add(g2);
        rgbList.add(b2);

        return rgbList;
    }

    public void setColors(int colors) {
        this.colors = colors;
    }

    public void addCube() {
        Rectangle cube = new Rectangle(gradientWidth/2, gradientHeight/2, 150, 150);
        this.cube = cube;
    }
}
