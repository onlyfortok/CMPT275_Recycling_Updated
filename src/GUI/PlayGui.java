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
    private JPanel RecycleBin_1;
    private JPanel word_or_image_panel;
    private JButton nextButton;
    private JButton pauseButton;
    private JTextField progressTextField;

    public PlayGui() throws IOException {

        frame.add(main_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setVisible(true);

        Path path = Paths.get("src\\GamePlay Info\\Background.txt");
        String location = String.valueOf(path.toAbsolutePath()); //holds the image path
        File file = new File(location);
        BufferedReader br = new BufferedReader(new FileReader(file));
        Color bkg = null, thm= null;

        String st;
        while((st= br.readLine())!=null){
            String[] num = st.split("-");
            int r,g,b;
            r= Integer.parseInt(num[0]);
            g= Integer.parseInt(num[1]);
            b= Integer.parseInt(num[2]);
            System.out.println(r);
            System.out.println(g);
            System.out.println(b);
            bkg = new Color(r,g,b);
        }
        br.close();

        Path pathT = Paths.get("src\\GamePlay Info\\Theme.txt");
        String locationT = String.valueOf(pathT.toAbsolutePath()); //holds the image path
        File fileT = new File(locationT);
        BufferedReader brT = new BufferedReader(new FileReader(fileT));

        while((st= brT.readLine())!=null){
            String[] num = st.split("-");
            int r,g,b;
            r=Integer.parseInt(num[0]);
            g= Integer.parseInt(num[1]);
            b= Integer.parseInt(num[2]);
            System.out.println(r);
            System.out.println(g);
            System.out.println(b);
            thm = new Color(r,g,b);

        }
        br.close();

        main_panel.setBackground(bkg);
        RecycleBin_1.setBackground(bkg);
        word_or_image_panel.setBackground(bkg);

        nextButton.setBackground(thm);
        prevButton.setBackground(thm);
        pauseButton.setBackground(thm);
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
