package GUI;

import Game.GAME_GUI;
import Game.MainGameScreen;
import Game.StartingGameScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements MainGameScreen{
    private JFrame frame = new JFrame("Recycling game");
    private  JPanel panel=new JPanel(); //This panel will hold the buttons
    private JPanel panel_image=new JPanel(); //This panel will hold the image
    private JButton b1 = new JButton("GAME");
    private  JButton b2 = new JButton("How to Play");
    private  JButton b3 = new JButton("Setting");

    //constructor
    public void GUI(){
    }


    public void PlayGame() {
        frame.setLayout(null); // frame
        panel_image.add(new JLabel(new ImageIcon("C:\\Users\\16047\\IdeaProjects\\CMPT275_Project_FINAL_COPY\\DataBase\\GUI\\GUI_IMAGE.png")));
        panel_image.setBounds(150,0,300,300);

        panel.setLayout(new GridLayout(2, 2));
        panel.add(b1);
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                StartingGameScreen g = new StartingGameScreen();
                g.run();

            }
        });

        panel.setBounds(200,300,200,200);
        frame.add(panel_image);
    }

    public void HowToPlay(){
        panel.add(b2);
    }
    public void Setting(){
        panel.add(b3);
        frame.add(panel);
    }

    public void run()
    {
        PlayGame();
        HowToPlay();
        Setting();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 600));
        frame.pack();
        frame.setVisible(true);

    }



    public static void main(String[] args) {
               GUI g = new GUI();
                g.run();

    }
}

