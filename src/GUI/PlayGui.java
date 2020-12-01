package GUI;

import Game.GamePlayScreen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PlayGui implements GamePlayScreen {
    private JFrame frame = new JFrame("RecycleMania");
    private boolean save_game = false;
    private boolean play_again = false;
    private int score = 0;

    private JPanel main_panel;
    private JButton prevButton;
    private JPanel RecycleBin;
    private JPanel word_or_image_panel;
    private JButton nextButton;
    private JPanel Recycle_bin3;
    private JPanel Recycle_bin2;
    private JPanel Recycle_bin1;
    private JLabel pause_icon;
    private JLabel skip_icon;
    private JLabel status_icon;
    private JButton pauseButton;
    private JTextField progressTextField;

    public PlayGui() throws IOException {
        //for background
        Path path = Paths.get("src\\GamePlay Info\\Background.txt");
        String location = String.valueOf(path.toAbsolutePath()); //holds the image path
        File file = new File(location);
        BufferedReader br = new BufferedReader(new FileReader(file));
        Color bckgrnd = null, theme = null;

        String st;
        while((st= br.readLine())!=null){
            String[] num = st.split("-");
            int R,G,B;
            R= Integer.parseInt(num[0]);
            G= Integer.parseInt(num[1]);
            B= Integer.parseInt(num[2]);
            bckgrnd = new Color(R,G,B);
        }
        br.close();

        //for theme
        Path pathT = Paths.get("src\\GamePlay Info\\Theme.txt");
        String locationT = String.valueOf(pathT.toAbsolutePath()); //holds the image path
        File fileT = new File(locationT);
        BufferedReader brT = new BufferedReader(new FileReader(fileT));

        while((st= brT.readLine())!=null){
            String[] num = st.split("-");
            int R,G,B;
            R= Integer.parseInt(num[0]);
            G= Integer.parseInt(num[1]);
            B= Integer.parseInt(num[2]);
            theme = new Color(R,G,B);
        }
        brT.close();


        frame.add(main_panel);
        main_panel.setBackground(bckgrnd);
        word_or_image_panel.setBackground(bckgrnd);
        RecycleBin.setBackground(bckgrnd);
        Recycle_bin1.setBackground(bckgrnd);
        Recycle_bin2.setBackground(bckgrnd);
        Recycle_bin3.setBackground(bckgrnd);

        prevButton.setBackground(theme);
        nextButton.setBackground(theme);
        pauseButton.setBackground(theme);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setVisible(true);

    }
    @Override
    public void GameGUI(){}
    @Override
    public int getScore(){
        return score;
    }
    @Override
    public void skip(){}
    @Override
    public void pause(){}
    @Override
    public void quitCurrentGame(){}
    @Override
    public void viewGamestatus(){}
    @Override
    public void OpenGame(){}
    @Override
    public boolean playAgain(){
        return play_again;
    }
    @Override
    public void exitGame(){}
    @Override
    public boolean SaveGame(){
        return save_game;
    }

    public static void main(String[] args) throws IOException {
        PlayGui g = new PlayGui();

    }
}
