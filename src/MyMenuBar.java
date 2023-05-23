package src;

import src.elements.Cube;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class MyMenuBar extends JMenuBar {

    MainPanel mp;
    //Menu's and Menu Items
    JMenu addMenu;
    JMenu configMenu;

    JMenuItem color1Btn;
    JMenuItem color2Btn;

    JMenuItem color3Btn;

    JMenuItem color4Btn;

    
    //PANELS

    JPanel backgroundPanel;
    JPanel color1Panel;
    JPanel rPanel1;
    JPanel gPanel1;
    JPanel bPanel1;

    JPanel color2Panel;
    JPanel rPanel2;
    JPanel gPanel2;
    JPanel bPanel2;

    JPanel color3Panel;
    JPanel rPanel3;
    JPanel gPanel3;
    JPanel bPanel3;

    JPanel color4Panel;
    JPanel rPanel4;
    JPanel gPanel4;
    JPanel bPanel4;

    JPanel objectPanel;
    JPanel objColor1Panel;
    JPanel rObj1;
    JPanel gObj1;
    JPanel bObj1;

    JPanel objColor2Panel;
    JPanel rObj2;
    JPanel gObj2;
    JPanel bObj2;

    JPanel objColor3Panel;
    JPanel rObj3;
    JPanel gObj3;
    JPanel bObj3;

    JPanel objColor4Panel;
    JPanel rObj4;
    JPanel gObj4;
    JPanel bObj4;


    JPanel speedPanel;
    JPanel fadePanel;
    JPanel fadePanel1;
    JPanel fadePanel2;
    JPanel fadePanel3;
    JPanel fadePanel4;

    //LABELS

    JLabel colorLabel1;
    JLabel colorLabel2;
    JLabel colorLabel3;
    JLabel colorLabel4;
    JLabel speedLabel;
    JLabel rLabel1;
    JLabel gLabel1;
    JLabel bLabel1;
    JLabel rLabel2;
    JLabel gLabel2;
    JLabel bLabel2;
    JLabel rLabel3;
    JLabel gLabel3;
    JLabel bLabel3;
    JLabel rLabel4;
    JLabel gLabel4;
    JLabel bLabel4;
    JLabel fadeLabel1;
    JLabel fadeLabel2;
    JLabel fadeLabel3;
    JLabel fadeLabel4;



    //TEXTFIELDS

    JTextField rValue1;
    JTextField gValue1;
    JTextField bValue1;
    JTextField rValue2;
    JTextField gValue2;
    JTextField bValue2;
    JTextField rValue3;
    JTextField gValue3;
    JTextField bValue3;
    JTextField rValue4;
    JTextField gValue4;
    JTextField bValue4;
    JTextField speedValue;


    //SLIDERS

    JSlider rSlider1;
    JSlider gSlider1;
    JSlider bSlider1;
    JSlider rSlider2;
    JSlider gSlider2;
    JSlider bSlider2;
    JSlider rSlider3;
    JSlider gSlider3;
    JSlider bSlider3;
    JSlider rSlider4;
    JSlider gSlider4;
    JSlider bSlider4;
    JSlider speedSlider;


    //BUTTONS

    JMenuItem speedBtn;

    //CHECKBOXES
    JCheckBox fadeCheckBox1;
    JCheckBox fadeCheckBox2;
    JCheckBox fadeCheckBox3;
    JCheckBox fadeCheckBox4;

    //Add Menu
    JPanel addPanel;
    JPopupMenu objectMenu;


    public MyMenuBar(MainPanel mp) {
        // Create a menu bar
        this.mp = mp;

        setBorderPainted(false);

        // Create the Menu's
        addMenu = new JMenu("Add");
        addMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        configMenu = new JMenu("Config");
        configMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        add(configMenu);
        add(addMenu);

        /*
        * Add Menu content
        * JLabel: Objects
        * JButton: Cube
        * JButton: Circle
        * JButton: Triangle
         */

        addMenu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                int size = 400;
                Color color3, color4;
                color3 = new Color(255, 255, 255, 255);
                color4 = new Color(0, 0, 0, 255);
                mp.cube = new Cube(0, 0, size, size, mp.gradientWidth, mp.gradientHeight, color3, color4, mp);
                mp.cube.toggleSpin("left");
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        }
        );

        /*
        * Config Menu content
        * JLabel: Background
        * JLabel: Colors, Dropdown:2-4
        * JButton (expands): Color 1
        *   * JLabel: R, JSlider: 0-255, JTextField: 0-255
        *   * JLabel: G, JSlider: 0-255, JTextField: 0-255
        *   * JLabel: B, JSlider: 0-255, JTextField: 0-255
        * JButton (expands): Color 2
        *   * JLabel: R, JSlider: 0-255, JTextField: 0-255
        *   * JLabel: G, JSlider: 0-255, JTextField: 0-255
        *   * JLabel: B, JSlider: 0-255, JTextField: 0-255
        * JButton (expands): Color 3
        *   * JLabel: R, JSlider: 0-255, JTextField: 0-255
        *   * JLabel: G, JSlider: 0-255, JTextField: 0-255
        *   * JLabel: B, JSlider: 0-255, JTextField: 0-255
        * JButton (expands): Color 4
        *   * JLabel: R, JSlider: 0-255, JTextField: 0-255
        *   * JLabel: G, JSlider: 0-255, JTextField: 0-255
        *   * JLabel: B, JSlider: 0-255, JTextField: 0-255
        * JButton (expands): Speed
        *   * JLabel: Speed, JSlider: 1-10, JTextField: 1-10
        * JButton (expands): Fade
        *   * JCheckBox: Fade 1
        *   * JCheckBox: Fade 2
        *   * JCheckBox: Fade 3
        *   * JCheckBox: Fade 4
         */

            //Important: configMenu.updateUI();



        JLabel backgroundLabel = new JLabel("Background");
        backgroundLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JPanel colorPanel = new JPanel(new BorderLayout());
        JLabel colorsLabel = new JLabel("Colors");
        colorsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        String[] colors = {"2", "3", "4"};
        JComboBox<String> colorsBox = new JComboBox<>(colors);
        colorsBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        //colorsBox.setSelectedIndex(0);

        // Add Label and ColorBox to colorPanel
        colorPanel.add(colorsLabel, BorderLayout.WEST);
        colorPanel.add(colorsBox, BorderLayout.EAST);

        color1Btn = new JMenuItem("Color 1");
        color1Btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        color2Btn = new JMenuItem("Color 2");
        color2Btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        if (mp.colors == 3){
            color3Btn = new JMenuItem("Color 3");
            color3Btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            color3Btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    toggleColorPanel(color3Panel);
                }});
        } else if (mp.colors == 4) {
            color4Btn = new JMenuItem("Color 4");
            color4Btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            color4Btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    toggleColorPanel(color4Panel);
                }});


        }

        color1Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleColorPanel(color1Panel);
            }
        });

        color2Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleColorPanel(color2Panel);
            }});




        speedBtn  = new JMenuItem("Speed");
        speedPanel = new JPanel();

        //Checkboxes
        fadePanel = new JPanel();
        fadeCheckBox1 = new JCheckBox();
        fadeCheckBox2 = new JCheckBox();


        // Create menu item's for configMenu

        backgroundPanel = new JPanel();

        color1Panel = new JPanel();

        rPanel1 = new JPanel();

        gPanel1 = new JPanel();

        bPanel1 = new JPanel();


        color2Panel = new JPanel();

        rPanel2 = new JPanel();

        gPanel2 = new JPanel();

        bPanel2 = new JPanel();

        objectPanel = new JPanel();


        backgroundPanel.setLayout(new BorderLayout());
            color1Panel.setLayout(new BorderLayout());
                rPanel1.setLayout(new BorderLayout());
                gPanel1.setLayout(new BorderLayout());
                bPanel1.setLayout(new BorderLayout());

            color2Panel.setLayout(new BorderLayout());
                rPanel2.setLayout(new BorderLayout());
                gPanel2.setLayout(new BorderLayout());
                bPanel2.setLayout(new BorderLayout());

                speedPanel.setLayout(new BorderLayout());
                fadePanel.setLayout(new BorderLayout());


        colorLabel1 = new JLabel("Color 1");

        colorLabel2 = new JLabel("Color 2");

        speedLabel = new JLabel("Speed");

        rLabel1 = new JLabel("Red: ");

        gLabel1 = new JLabel("Green: ");

        bLabel1 = new JLabel("Blue");

        rLabel2 = new JLabel("Red: ");

        gLabel2 = new JLabel("Green: ");

        bLabel2 = new JLabel("Blue: ");

        rValue1 = new JTextField();
        gValue1 = new JTextField();
        bValue1 = new JTextField();

        rValue2 = new JTextField();
        gValue2 = new JTextField();
        bValue2 = new JTextField();

        speedValue = new JTextField();

        rSlider1 = new JSlider(0,255);
        gSlider1 = new JSlider(0,255);
        bSlider1 = new JSlider(0, 255);

        rSlider2 = new JSlider(0,255);
        gSlider2 = new JSlider(0,255);
        bSlider2 = new JSlider(0,255);

        speedSlider = new JSlider(1, 10);

        color1Panel.add(colorLabel1);
        rPanel1.add(rLabel1, BorderLayout.WEST);
        rPanel1.add(rSlider1, BorderLayout.CENTER);
        rPanel1.add(rValue1, BorderLayout.EAST);

        color2Panel.add(colorLabel2);
        rPanel2.add(rLabel2, BorderLayout.WEST);
        rPanel2.add(rSlider2, BorderLayout.CENTER);
        rPanel2.add(rValue2, BorderLayout.EAST);

        speedPanel.add(speedLabel, BorderLayout.WEST);
        speedPanel.add(speedSlider, BorderLayout.CENTER);
        speedPanel.add(speedValue, BorderLayout.EAST);

        gPanel1.add(gLabel1, BorderLayout.WEST);
        gPanel1.add(gSlider1, BorderLayout.CENTER);
        gPanel1.add(gValue1, BorderLayout.EAST);

        gPanel2.add(gLabel2, BorderLayout.WEST);
        gPanel2.add(gSlider2, BorderLayout.CENTER);
        gPanel2.add(gValue2, BorderLayout.EAST);

        bPanel1.add(bLabel1, BorderLayout.WEST);
        bPanel1.add(bSlider1, BorderLayout.CENTER);
        bPanel1.add(bValue1, BorderLayout.EAST);

        bPanel2.add(bLabel2, BorderLayout.WEST);
        bPanel2.add(bSlider2, BorderLayout.CENTER);
        bPanel2.add(bValue2, BorderLayout.EAST);

        speedPanel.add(speedLabel, BorderLayout.WEST);
        speedPanel.add(speedSlider, BorderLayout.CENTER);
        speedPanel.add(speedValue, BorderLayout.EAST);

        fadePanel.add(fadeCheckBox1, BorderLayout.WEST);
        fadePanel.add(fadeCheckBox2, BorderLayout.EAST);

        //Adding to config menu
        configMenu.add(backgroundLabel);
        configMenu.add(colorPanel);

        //Temp

        configMenu.add(backgroundPanel);


        //Temp
        configMenu.add(color1Btn);
        configMenu.add(color2Btn);
        if (mp.colors == 3){
            configMenu.add(color3Btn);
        } else if (mp.colors == 4){
            configMenu.add(color4Btn);
        }

        configMenu.add(color1Panel);
        configMenu.add(rPanel1);
        configMenu.add(gPanel1);
        configMenu.add(bPanel1);

        configMenu.add(color2Panel);
        configMenu.add(rPanel2);
        configMenu.add(gPanel2);
        configMenu.add(bPanel2);

        configMenu.add(speedBtn);
        configMenu.add(fadePanel);

        //Create things for AddMenu


        getRGB();
        getSpeed();
        //Give menu items function

        configMenu.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (!configMenu.isPopupMenuVisible()){
                    configMenu.remove(speedPanel);
                }
            }
        });

        rSlider1.addChangeListener(e ->{
                rValue1.setText(String.valueOf(rSlider1.getValue()));
                mp.color1 = new Color(rSlider1.getValue(), mp.color1.getGreen(), mp.color1.getBlue());
                }
        );

        gSlider1.addChangeListener(e -> {

            gValue1.setText(String.valueOf(gSlider1.getValue()));
            mp.color1 = new Color(mp.color1.getRed(), gSlider1.getValue(), mp.color1.getBlue());
                }
        );
        bSlider1.addChangeListener(e ->{
                    bValue1.setText(String.valueOf(bSlider1.getValue()));
                    mp.color1 = new Color(mp.color1.getRed(), mp.color1.getGreen(), bSlider1.getValue());
                }
                );


        rSlider2.addChangeListener(e ->{
                    rValue2.setText(String.valueOf(rSlider2.getValue()));
                    mp.color2 = new Color(rSlider2.getValue(), mp.color2.getGreen(), mp.color2.getBlue());
                }
        );

        gSlider2.addChangeListener(e -> {
                    gValue2.setText(String.valueOf(gSlider2.getValue()));
                    mp.color2 = new Color(mp.color2.getRed(), gSlider2.getValue(), mp.color2.getBlue());
                }
        );
        bSlider2.addChangeListener(e ->{
                    bValue2.setText(String.valueOf(bSlider2.getValue()));
                    mp.color2 = new Color(mp.color2.getRed(), mp.color2.getGreen(), bSlider2.getValue());
                });

        speedSlider.addChangeListener(e -> {
            speedValue.setText(String.valueOf(speedSlider.getValue()));
            setSpeed(speedSlider.getValue());
        });
        speedBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                configMenu.add(speedPanel);
                configMenu.setPopupMenuVisible(true);
                speedBtn.setEnabled(true);
                System.out.println("Used btn");
            }
        });
        fadeCheckBox1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (fadeCheckBox1.isSelected()){
                    mp.fade1 = true;
                }else{
                    mp.fade1 = false;
                }
            }
        });
        fadeCheckBox2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(fadeCheckBox2.isSelected()){
                    mp.fade2 = true;
                }else{
                    mp.fade2 = false;
                }
            }
        });
                // Add the menus to the menu bar

        setVisible(true);
    }

    private void makeBgPanel() {

    }

    public void toggleColorPanel(JPanel panel){
        if (panel.isVisible())
            panel.setVisible(false);
        else {
            panel.setVisible(true);
        }

    }
    public void getSpeed() {
        speedValue.setText(String.valueOf(mp.sleepTime));
        //speedSlider.setValue(11-mp.sleepTime);
    }
    public void setSpeed(int speed){
        int sleepTime = 11;
        sleepTime-=speed;
        mp.sleepTime = sleepTime;
        System.out.println(sleepTime);
    }
    public void getRGB() {
        rValue1.setText(String.valueOf(mp.color1.getRed()));
        gValue1.setText(String.valueOf(mp.color1.getGreen()));
        bValue1.setText(String.valueOf(mp.color1.getBlue()));
        rValue2.setText(String.valueOf(mp.color2.getRed()));
        gValue2.setText(String.valueOf(mp.color2.getGreen()));
        bValue2.setText(String.valueOf(mp.color2.getBlue()));

        rSlider1.setValue(mp.color1.getRed());
        gSlider1.setValue(mp.color1.getGreen());
        bSlider1.setValue(mp.color1.getBlue());
        rSlider2.setValue(mp.color2.getRed());
        gSlider2.setValue(mp.color2.getGreen());
        bSlider2.setValue(mp.color2.getBlue());

    }

}
