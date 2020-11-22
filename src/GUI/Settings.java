package GUI;


import Game.GUIOtherSettingScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Settings implements GUIOtherSettingScreen{
    private JFrame frame = new JFrame("RecycleMania");
    private JPanel main_panel;
    private JLabel RecycleMania;
    private JButton backButton;
    private JRadioButton abstractRadioButton;
    private JRadioButton blueSkyRadioButton;
    private JRadioButton oliveRadioButton;
    private JRadioButton tealRadioButton;
    private JRadioButton brownWoodenRadioButton;
    private JRadioButton blackRadioButton;
    private JRadioButton darkGreyRadioButton;
    private JRadioButton navyRadioButton;
    private JRadioButton greenRadioButton;
    private JRadioButton maroonRadioButton;
    private JRadioButton ONRadioButton;
    private JRadioButton OFFRadioButton;

    public Settings() {

        frame.add(main_panel);

        ButtonGroup backgrnd_group = new ButtonGroup();
        backgrnd_group.add(abstractRadioButton);
        backgrnd_group.add(blueSkyRadioButton);
        backgrnd_group.add(oliveRadioButton);
        backgrnd_group.add(tealRadioButton);
        backgrnd_group.add(brownWoodenRadioButton);
        abstractRadioButton.setSelected(true); //default background

        ButtonGroup theme_group = new ButtonGroup();
        theme_group.add(blackRadioButton);
        theme_group.add(darkGreyRadioButton);
        theme_group.add(navyRadioButton);
        theme_group.add(greenRadioButton);
        theme_group.add(maroonRadioButton);
        blackRadioButton.setSelected(true);//default theme

        ButtonGroup sound_group = new ButtonGroup();
        sound_group.add(ONRadioButton);
        sound_group.add(OFFRadioButton);
        ONRadioButton.setSelected(true); //default sound

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI g = new GUI();
                g.run();
            }
        });


        abstractRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    changeBackgroundColor("Default");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        blueSkyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    changeBackgroundColor("Blue sky");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        brownWoodenRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    changeBackgroundColor("Brown wooden");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        oliveRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    changeBackgroundColor("Olive");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        tealRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    changeBackgroundColor("Teal");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        blackRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        darkGreyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        navyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        greenRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        maroonRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    @Override
    public void changeBackgroundColor(String str) throws IOException {
        str = str + ".jpg";
        str = "CMPT275_Recycling_Updated\\Background\\"+str;
        BufferedImage backgroundImage = ImageIO.read(new File(str));
        ImageIcon image = new ImageIcon(backgroundImage);

    }
    @Override
    public void changeTheme(String str){

    }
    @Override
    public void Changesound(String str){

    }

    public static void main(String[] args) {
        Settings g = new Settings();

    }
}
