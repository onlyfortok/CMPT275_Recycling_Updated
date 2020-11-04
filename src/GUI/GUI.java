package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.Container;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;



public class GUI {
    private  static JPanel panel=new JPanel(); //This panel will hold the buttons
    private  static JPanel panel_image=new JPanel(); //This panel will hold the image
    private static JButton b1 = new JButton("GAME");
    private static JButton b2 = new JButton("How to Play");
    private static JButton b3 = new JButton("Setting");
    private static JButton b4 = new JButton("Game Setting");

    public static void addComponentsToPane(Container pane) {
        pane.setLayout(null); // frame

        panel_image.add(new JLabel(new ImageIcon("C:\\Users\\16047\\IdeaProjects\\CMPT275_Project_FINAL_COPY\\DataBase\\GUI\\GUI_IMAGE.png")));
        panel_image.setBounds(150,0,300,300);

        panel.setLayout(new GridLayout(2, 2));
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.setBounds(200,300,200,200);
        pane.add(panel);
        pane.add(panel_image);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Recycling game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

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

