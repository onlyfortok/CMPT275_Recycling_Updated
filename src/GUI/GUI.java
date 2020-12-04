package GUI;

import Game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GUI implements MainGameScreen{

    private JFrame frame = new JFrame("RecycleMania");
    private JPanel main_panel;
    private JButton playButton;
    private JButton aboutUsButton;
    private JButton settingsButton;
    private JButton gameStatisticsButton;
    private JButton howToPlayButton;
    private JLabel RecycleMania;
    private JPanel image_panel;
    private Image image;
    private Draw_Image Image_canvas;

    //constructor
    @Override
    public void GUI() {
        String str;
        str = "main_image.jpg";
        Path path = Paths.get(str);
        String location = String.valueOf(path.toAbsolutePath()); //holds the image path
        image = new ImageIcon(location).getImage();
        Image_canvas = new Draw_Image();
        image_panel.add(Image_canvas);
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
                frame.dispose();
                GameSettings g = new GameSettings();
            }
        });

    }

    @Override
    public void HowToPlay(){
        howToPlayButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                HowToPlayGUI g = new HowToPlayGUI();
            }

        });
    }

    @Override
    public void Setting(){
        settingsButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Settings g = new Settings();

            }
        });
    }

    @Override
    public void GameStatistics(){
        gameStatisticsButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    GameStatistics g = new GameStatistics();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    @Override
    public void AboutUs(){
        aboutUsButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                AboutUs g = new AboutUs();
            }
        });
    }
    private class Draw_Image extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(image,0,0,this.getWidth(),this.getHeight(),null);
        }
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
        SoundClass sound = new SoundClass();
    }
}

