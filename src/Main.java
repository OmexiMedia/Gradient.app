package src;


import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
public class Main implements Runnable{

    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        Main main = new Main();
        Thread thread = new Thread(main);
        thread.start();
    }

    @Override
    public void run() {
        Window window = new Window();
        window.mainPanel.gradient();
    }
}
