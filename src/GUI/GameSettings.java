package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameSettings {
    private JFrame frame = new JFrame("RecycleMania");
    private JPanel main_panel;
    private JButton startButton;
    private JRadioButton a5RadioButton;
    private JRadioButton a10RadioButton;
    private JRadioButton a15RadioButton;
    private JRadioButton easyRadioButton;
    private JRadioButton normalRadioButton;
    private JRadioButton hardRadioButton;
    private JRadioButton wordsRadioButton;
    private JRadioButton wordsAndImagesRadioButton;
    private JRadioButton ONRadioButton;
    private JRadioButton OFFRadioButton;
    private JButton backButton;

    public GameSettings(){
        frame.add(main_panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setVisible(true);


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    PlayGui g = new PlayGui();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GUI g = new GUI();
                g.run();
            }
        });
    }
    public static void main(String[] args) {
        GameSettings g = new GameSettings();
    }
}
