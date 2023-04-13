package src;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.*;
import java.awt.*;
public class Window extends JFrame {

    MainPanel mainPanel;
    public Window(){
        FlatMacDarkLaf.setup();



        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(screenSize);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setBackground(Color.black);
        setLocation(0, 0);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.pack();

        this.mainPanel = new MainPanel(this);
        this.add(mainPanel);



    }


}
