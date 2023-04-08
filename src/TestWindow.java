package src;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

    public class TestWindow extends JFrame {
        public static void main(String[] args) {
            EventQueue.invokeLater(() -> {
                Color[] colors = new Color[]{Color.red, Color.green, Color.blue, Color.yellow};
                Point2D[] points = new Point2D[]{new Point2D.Double(0, 0), new Point2D.Double(0, 100), new Point2D.Double(100, 100), new Point2D.Double(100, 0)};
                MultiGradientPaint gp = new MultiGradientPaint(colors, points);

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        ((Graphics2D) g).setPaint(gp);
                        ((Graphics2D) g).fillRect(0, 0, getWidth(), getHeight());
                    }
                });
                frame.setSize(500, 500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            });
        }
    }

