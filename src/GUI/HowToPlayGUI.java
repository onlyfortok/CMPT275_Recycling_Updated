package GUI;

import Game.HowToPlayScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HowToPlayGUI implements HowToPlayScreen {
    private JFrame frame = new JFrame("RecycleMania");
    private JPanel main_panel;
    private JButton backButton;
    private JLabel instructions_1;
    private JLabel RecycleMania;
    private JLabel instructions_2;
    private JLabel instructions_3;
    private JLabel instructions_4;
    private JLabel instructions_5;
    private JLabel instructions_8;
    private JLabel instructions_6;
    private JLabel instructions_7;
    private JLabel blank;
    private JLabel blankTwo;
    private JLabel blankFour;
    private JLabel blankThree;
    private JLabel instructions_10;
    private JLabel instructions_9;
    private JLabel instructions_11;
    private JLabel blankSix;

    public HowToPlayGUI(){
        frame.add(main_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setVisible(true);

        displayInstructions();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI g = new GUI();
                g.run();
            }
        });
    }

    @Override
    public void displayInstructions(){
        instructions_1.setText("Welcome to RecycleMania!");
        instructions_2.setText("RecycleMania is a great place to learn how to recycle materials as possible properly.");
        instructions_3.setText("Recycling saves energy, it conserves earth’s resources, it prevents the land and the");
        instructions_4.setText("oceans from being over-run with garbage!" );
        instructions_5.setText("1. Start the game by clicking Play! to be directed to the first question." );
        instructions_6.setText("2. Select the appropriate recycling bin that the item belongs to" );
        instructions_7.setText("3. Click Next to go to the next question.");
        instructions_8.setText("4. Once you have finished answering all questions, click submit.");
        instructions_9.setText("5. Your score will be displayed.");
        instructions_10.setText("Tips: you would need to know what can be thrown in each recycle bin for better and ");
        instructions_11.setText("faster results.");

        //spacing
        blank.setText(" ");
        blankTwo.setText(" ");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        HowToPlayGUI g = new HowToPlayGUI();

    }
}
