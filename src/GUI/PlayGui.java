package GUI;

import Game.GamePlayScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public PlayGui(){

        frame.add(main_panel);
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

    public static void main(String[] args) {
        HowToPlayGUI g = new HowToPlayGUI();

    }
}
