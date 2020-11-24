package GUI;


import Game.GUIOtherSettingScreen;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JPanel background;
    private Image image;
    private Color background_color;
    private Color theme_color;


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
                changeBackgroundColor("Forest Green");
            }
        });
        blueSkyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColor("Blue sky");
            }
        });
        brownWoodenRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColor("Brown wooden");
            }
        });
        oliveRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColor("Olive");
            }
        });
        tealRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColor("Teal");
            }
        });

        //themes
        blackRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeTheme("Black");
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
        greenRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeTheme("Green");
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
    public void changeBackgroundColor(String str) {
        int R, G, B;

        if (str=="Blue sky"){
            R=51;
            G=204;
            B=255;
            background_color = new Color(R,G,B);
        }
        if(str=="Teal"){
            R=0;
            G=128;
            B=128;
            background_color = new Color(R,G,B);
        }
        if(str=="Olive"){
            R=128;
            G=128;
            B=0;
            background_color = new Color(R,G,B);
        }
        if(str=="Brown wooden"){
            R=153;
            G=102;
            B=0;
            background_color = new Color(R,G,B);
        }
        if(str=="Forest Green"){
            R=0;
            G=153;
            B=0;
            background_color = new Color(R,G,B);
        }
    }
    @Override
    public void changeTheme(String str){
        int R, G, B;

        if (str=="Black"){
            R=51;
            G=204;
            B=255;
            theme_color = new Color(R,G,B);
        }
        if(str=="Dark Grey"){
            R=0;
            G=128;
            B=128;
            theme_color = new Color(R,G,B);
        }
        if(str=="Navy"){
            R=128;
            G=128;
            B=0;
            theme_color = new Color(R,G,B);
        }
        if(str=="Green"){
            R=153;
            G=102;
            B=0;
            theme_color = new Color(R,G,B);
        }
        if(str=="Maroon"){
            R=0;
            G=153;
            B=0;
            theme_color = new Color(R,G,B);
        }

    }
    @Override
    public void Changesound(String str){

    }

    public static void main(String[] args) {
        Settings g = new Settings();

    }
}
