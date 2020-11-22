package Game;

import GUI.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartingGameScreen implements StartGameScreen{
    private JFrame frame = new JFrame("Game Settings");
    private  JPanel panel=new JPanel(); //This panel will hold the
    private  JPanel panel2=new JPanel(); //This panel will hold the items
    private  JPanel panel3=new JPanel(); //This panel will hold the items
    private  JPanel panel4=new JPanel(); //This panel will hold the items

    private  JLabel Setdifficulty =new JLabel("Choose Difficulty"); //This label will hold the items
    private  JLabel SetWordorImages =new JLabel("Choose Word Or Image"); //This label will hold the items
    private  JLabel Timer =new JLabel("Select for Timer"); //This label will hold the items
    private JRadioButton r1 = new JRadioButton(); //Easy
    private JRadioButton r2 = new JRadioButton(); //Normal
    private JRadioButton r3 = new JRadioButton(); //Hard
    // Need to make button group
    private JRadioButton r4 = new JRadioButton(); // Images
    private JRadioButton r5 = new JRadioButton(); // Words
    // Need to make button group again

    private JRadioButton r6 = new JRadioButton(); // For timer

    private JButton b1 = new JButton("Start Game");

    public void StartingGameScreen(){
    }

    public void GameSetting(){

    }
    public void SetDifficulty(String str){}
    public void DisplayWordorImages(String str){}
    public boolean MarathonPlay(){return true;}
    public void AddTimer(){}

    public void run()
    {
        //frame.setLayout(null); // frame
       // panel.setLayout(new GridLayout(3, 5));
        panel.add(Setdifficulty);
        panel.add(r1);
        panel.add(r2);
        panel.add(r3);
        panel2.add(SetWordorImages);
        panel2.add(r4);
        panel2.add(r5);
        panel3.add(Timer);
        panel3.add(r6);
        panel4.add(b1);

        //When b1 is clicked
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                GAME_GUI G = new GAME_GUI();
            }
        });

        panel.setBounds(150,50,200,100);
        panel2.setBounds(150,150,200,100);
        panel3.setBounds(150,250,200,100);
        panel4.setBounds(150,350,200,100);

        frame.add(panel);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);



        frame.setPreferredSize(new Dimension(600, 500));
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        StartingGameScreen g = new StartingGameScreen();
        g.run();

    }
}
