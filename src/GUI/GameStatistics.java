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

public class GameStatistics extends JFrame {
    private JFrame frame = new JFrame("RecycleMania");
    private JPanel main_panel;
    private JLabel RecycleMania;
    private JLabel lowest_score;
    private JLabel last_score;
    private JLabel highest_score;
    private JButton backButton;

    public GameStatistics() {
        frame.add(main_panel);

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
    }

    public static void main(String[] args) {
        GameStatistics g = new GameStatistics();
    }

}
