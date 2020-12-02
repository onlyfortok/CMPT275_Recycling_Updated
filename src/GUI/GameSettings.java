package GUI;

import Game.Game_Info;

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
                //get all the info from the button groups
                //difficultly
                String Game_Difficulty = get_Difficulty();
                // item_type
                String Game_Item_type = get_Item_type();
                //timers
                boolean timer = get_Timer(); //true if it is selected
                //num of items
                int Game_num_items = get_Item_num();

                System.out.println(Game_Difficulty);

                PlayGui g = null;
                try {
                    g = new PlayGui();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                g.SetGameGUIParam( Game_Difficulty, Game_Item_type ,timer, Game_num_items);
                    g.start_word_or_images();


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

    //getter for difficulty
    public String get_Difficulty(){
        if(easyRadioButton.isSelected()){
            return "Easy";
        }
        else if(normalRadioButton.isSelected()){
            return "Normal";
        }
        else if(hardRadioButton.isSelected()){
            return "Hard";
        }
        return "Easy";
    }
    //getter for item type
    public String get_Item_type(){
        if(wordsAndImagesRadioButton.isSelected()){
            return "Images";
        }
        if(wordsRadioButton.isSelected()) {
            return "Words";
        }
        return "Images";
    }
    //getter for item numbers
    public int get_Item_num(){
        if(a5RadioButton.isSelected()){
            return 5;
        }
        else if(a10RadioButton.isSelected()){
            return 10;
        }
        else if(a15RadioButton.isSelected()){
            return 15;
        }
        return 5;
    }


    public boolean get_Timer(){
        if(ONRadioButton.isSelected()){
            return true;
        }
        else{
            return false; //also the default
        }

    }

    public static void main(String[] args) {
        GameSettings g = new GameSettings();
    }
}