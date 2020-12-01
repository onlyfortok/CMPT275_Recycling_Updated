package GUI;


import Game.GUIOtherSettingScreen;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    private JRadioButton darkGreyRadioButton;
    private JRadioButton navyRadioButton;
    private JRadioButton maroonRadioButton;
    private JRadioButton ONRadioButton;
    private JRadioButton OFFRadioButton;
    private JPanel background;
    private JRadioButton greenRadioButton;
    private Image image;
    private Color background_color;
    private Color theme_color;
    public int R, G, B;


    public Settings() {

        frame.add(background);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setVisible(true);

        ButtonGroup backgrnd_group = new ButtonGroup();
        backgrnd_group.add(abstractRadioButton);
        backgrnd_group.add(blueSkyRadioButton);
        backgrnd_group.add(oliveRadioButton);
        backgrnd_group.add(tealRadioButton);
        backgrnd_group.add(brownWoodenRadioButton);
        abstractRadioButton.setSelected(true); //default background
        try {
            changeBackgroundColor("Forest Green");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        ButtonGroup theme_group = new ButtonGroup();
        theme_group.add(greenRadioButton);
        theme_group.add(darkGreyRadioButton);
        theme_group.add(navyRadioButton);
        theme_group.add(maroonRadioButton);
        greenRadioButton.setSelected(true);//default theme
        changeTheme("Green");

        ButtonGroup sound_group = new ButtonGroup();
        sound_group.add(ONRadioButton);
        sound_group.add(OFFRadioButton);
        ONRadioButton.setSelected(true); //default sound

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GUI g = new GUI();
                g.run();
            }
        });

        //backgrounds
        abstractRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    changeBackgroundColor("Forest Green");
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

        //themes
        greenRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeTheme("White");
            }
        });
        darkGreyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeTheme("Dark Grey");
            }
        });
        navyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeTheme("Navy");
            }
        });

        maroonRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeTheme("Maroon");
            }
        });
    }

    public Color getTheme_color(){
        return theme_color;
    }

    public Color getBackground_color(){
        return background_color;
    }
    @Override
    public void changeBackgroundColor(String str) throws IOException {


        if (str.equals("Blue sky")){
            R=51;
            G=204;
            B=255;
            background_color = new Color(R,G,B);
        }
        if(str.equals("Teal")){
            R=0;
            G=128;
            B=128;
            background_color = new Color(R,G,B);
        }
        if(str.equals("Olive")){
            R=128;
            G=128;
            B=0;
            background_color = new Color(R,G,B);
        }
        if(str.equals("Brown wooden")){
            R=153;
            G=102;
            B=0;
            background_color = new Color(R,G,B);
        }
        if(str.equals("Forest Green")){
            R=154;
            G=205;
            B=50;
            background_color = new Color(R,G,B);
        }

        Path path = Paths.get("src\\GamePlay Info\\Background.txt");
        String location = String.valueOf(path.toAbsolutePath()); //holds the image path
        File file = new File(location);

        String temp = String.valueOf(R)+"-"+String.valueOf(G)+"-"+String.valueOf(B);

        try (BufferedWriter br = new BufferedWriter(new FileWriter(file))){
            br.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void changeTheme(String str){

        if (str.equals("Green")){
            R=0;
            G=170;
            B=0;
            theme_color = new Color(R,G,B);
        }
        if(str.equals("Dark Grey")){
            R=66;
            G=73;
            B=73;
            theme_color = new Color(R,G,B);
        }
        if(str.equals("Navy")){
            R=0;
            G=0;
            B=128;
            theme_color = new Color(R,G,B);
        }

        if(str.equals("Maroon")){
            R=128;
            G=0;
            B=0;
            theme_color = new Color(R,G,B);
        }

        Path path = Paths.get("src\\GamePlay Info\\Theme.txt");
        String location = String.valueOf(path.toAbsolutePath()); //holds the image path
        File file = new File(location);

        String temp = String.valueOf(R)+"-"+String.valueOf(G)+"-"+String.valueOf(B);
        try (BufferedWriter br = new BufferedWriter(new FileWriter(file))){
            br.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @Override
    public void Changesound(String str){

    }

    public static void main(String[] args) {
        Settings g = new Settings();

    }
}
