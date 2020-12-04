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
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GameStatistics extends JFrame {
    private JFrame frame = new JFrame("RecycleMania");
    private JPanel main_panel;
    private JLabel RecycleMania;
    private JLabel lowest_score;
    private JLabel last_score;
    private JLabel highest_score;
    private JButton backButton;

    public GameStatistics() throws IOException {
        frame.add(main_panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setVisible(true);

        Path path = Paths.get("src\\GamePlay Info\\Game Statistics.txt");
        String location = String.valueOf(path.toAbsolutePath()); //holds the image path
        File file = new File(location);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while((st= br.readLine())!=null){
            String[] num = st.split("-");
            double a,b,c;
            a= Double.parseDouble(num[0]);
            b= Double.parseDouble(num[1]);
            c= Double.parseDouble(num[2]);
            last_score.setText(String.valueOf(a));
            highest_score.setText(String.valueOf(b));
            lowest_score.setText(String.valueOf(c));
        }
        br.close();



        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                GUI g = new GUI();
                g.run();
            }
        });
    }

    public static void main(String[] args) throws IOException {
        GameStatistics g = new GameStatistics();
    }

}
