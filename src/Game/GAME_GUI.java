package Game;

import javax.swing.*;

import java.awt.*;
import java.awt.Container;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;


public class GAME_GUI {



    //panels
    private  static JPanel panel=new JPanel();
    private  static JPanel panel2=new JPanel();
    private  static JPanel panel3=new JPanel();
    private  static JPanel panel_item =new JPanel(); // words/images will be displayed here

    //labels
    private static JLabel label1 = new JLabel("organics");
    private static JLabel label2 = new JLabel("plastic");
    private static JLabel label3 = new JLabel("paper");
    private static JLabel label_item = new JLabel("");

    //radio buttons
    private static JRadioButton b1 = new JRadioButton("");
    private static JRadioButton b2 = new JRadioButton("");
    private static JRadioButton b3 = new JRadioButton("");
    private static ButtonGroup bg = new ButtonGroup();

    //buttons
    public static JButton confirm = new JButton("confirm");
    private static JButton next = new JButton("next"); // not implemented
    private static JButton skip = new JButton("skip"); // not implemented
    private static JButton restart = new JButton("restart");

    public static Game_Info database_item = new Game_Info();


    //this constructor will call the GUI
    public GAME_GUI(){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }

    //Components to add to frame
    public static void addComponentsToPane(Container pane) {
        pane.setLayout(null); // frame

        panelsetup();
        buttonsetup();

        pane.add(panel);
        pane.add(panel2);
        pane.add(panel3);
        pane.add(panel_item);
        pane.add(confirm);

        confirm.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //check if this radio button matches the container
                if(b1.isSelected()){
                    if(database_item.get_answer(database_item.get_counter()).equals(database_item.get_container(0))){
                        database_item.increase_score();

                    }
                }
                if(b2.isSelected()) {
                    if (database_item.get_answer(database_item.get_counter()).equals(database_item.get_container(1))) {
                        database_item.increase_score();
                    }
                }
                if(b3.isSelected()) {
                    if (database_item.get_answer(database_item.get_counter()).equals(database_item.get_container(2))) {
                        database_item.increase_score();
                    }
                }



                if (database_item.get_counter() < database_item.get_max_number_items()-1) {
                    database_item.increase_counter();
                    label_item.setText(database_item.get_word(database_item.get_counter()));
                }
                else{
                    JFrame frame_ending = new JFrame("Result");
                    //frame_ending.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    JPanel panel_results = new JPanel();
                    JLabel score_results = new JLabel("");
                    double score = database_item.get_score();
                    double max_items = database_item.get_max_number_items();
                    double results_game = (score/max_items)*100;

                    String string_temp = String.valueOf(results_game);
                    score_results.setText("Your score is: " + string_temp + "%");
                    panel_results.add(score_results);
                    frame_ending.add(panel_results);
                    frame_ending.setSize(300 , 300 );
                    frame_ending.setVisible(true);

                    //reset the scores to 0
                    database_item.reset_counter();
                    database_item.reset_score();

                }

            }
        });

    }




    //ALL the setup for the panels including the radio
    private static void panelsetup(){

        //layout style
        panel.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());
        panel3.setLayout(new BorderLayout());
        panel_item.setLayout(new BorderLayout());
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);

        //radio buttons
        panel.add(b1,BorderLayout.SOUTH);
        panel.add(new JLabel(new ImageIcon("C:\\Users\\16047\\IdeaProjects\\CMPT275_Project_FINAL_COPY\\DataBase\\Containers\\glass.png")));
        panel2.add(b2,BorderLayout.SOUTH);
        panel2.add(new JLabel(new ImageIcon("C:\\Users\\16047\\IdeaProjects\\CMPT275_Project_FINAL_COPY\\DataBase\\Containers\\metal.png")));
        panel3.add(b3,BorderLayout.SOUTH);
        panel3.add(new JLabel(new ImageIcon("C:\\Users\\16047\\IdeaProjects\\CMPT275_Project_FINAL_COPY\\DataBase\\Containers\\organics.png")));

        //
        int i = 0;
        label_item.setText(database_item.get_word(0)); //starts with first word automatically
        panel_item.add(label_item);

        int panel_y = 150;
        int panel_x = 150;
        int panel_start= 25;
        int panel_spaceBetween = 200;

        //panel setup for containers
        panel.setBounds(panel_start,300,panel_x,panel_y);
        panel.setBackground(Color.YELLOW);
        panel2.setBounds(panel_start+panel_spaceBetween,300,panel_x,panel_y);
        panel2.setBackground(Color.YELLOW);
        panel3.setBounds(panel_start+(panel_spaceBetween*2),300,panel_x,panel_y);
        panel3.setBackground(Color.YELLOW);

        //panel setup for chosen item
        panel_item.setBounds(150,100,panel_x,panel_y);
        panel_item.setBackground(Color.YELLOW);

    }



    private static void buttonsetup() {
        int button_width = 80;
        int button_height = 40;
        confirm.setBounds(500,500,button_width,button_height);
    }


    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Recycling game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
        //Size and display the window.

        frame.setSize(600 , 600 );
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}


