package GUI;

import Game.GAME_GUI;
import Game.HowToPlayScreen;
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

    private JFrame frame = new JFrame("RecycleMania");
    private JPanel main_panel;
    private JButton playButton;
    private JButton aboutUsButton;
    private JButton settingsButton;
    private JButton gameStatisticsButton;
    private JButton howToPlayButton;
    private JLabel RecycleMania;

    //constructor
    @Override
    public void GUI() {
        frame.add(main_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void PlayGame() {
        playButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                PlayGui g = new PlayGui();
            }
        });

    }

    @Override
    public void HowToPlay(){
        howToPlayButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                HowToPlayGUI g = new HowToPlayGUI();
            }

        });
    }

    @Override
    public void Setting(){
        settingsButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                Settings g = new Settings();

            }
        });
    }

    @Override
    public void GameStatistics(){
        gameStatisticsButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                GameStatistics g = new GameStatistics();
            }
        });
    }

    @Override
    public void AboutUs(){
        aboutUsButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                AboutUs g = new AboutUs();
            }
        });
    }


    public void run()
    {
        GUI();
        PlayGame();
        HowToPlay();
        Setting();
        AboutUs();
        GameStatistics();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setVisible(true);

    }



    public static void main(String[] args) {
        GUI g = new GUI();
        g.run();
    }
}

