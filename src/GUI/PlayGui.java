package GUI;

import Game.GamePlayScreen;
import Game.Game_Info;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
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
    private JButton exitButton;
    private  JPanel panel=new JPanel(); //This panel will hold all the containers
    private  JPanel panel2=new JPanel(); //This panel will hold all the radio buttons

    private JLabel Word_Image= new JLabel("");
    private static JRadioButton b1 = new JRadioButton("Bottles or Cans");
    private static JRadioButton b2 = new JRadioButton("E-Waste");
    private static JRadioButton b3 = new JRadioButton("Mixed Paper");
    private static JRadioButton b4 = new JRadioButton("Organics");
    private static JRadioButton b5 = new JRadioButton("Plastics");
    private static JRadioButton b6 = new JRadioButton("Trash");
    private static ButtonGroup bg = new ButtonGroup();

    private Game_Info G1 = new Game_Info();
    private String word;

    private JLabel image_temp = new JLabel(); // image temp

    public PlayGui() throws IOException {

        setting_containers(); //Setting the containers in the Gui
        setting_Radio_buttons();//Setting the radio buttons in the Gui


        //prev button
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                G1.decrease_counter();
                if(G1.get_Item_type().equals("Words")){ //this is all good
                    display_word_from_database();
                }
                if(G1.get_Item_type().equals("Images")){ // this might need testing
                    display_image_from_database();
                }
                //counter is dealt with but not the score yet
            }
        });


        //this button is good
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Give_userInput_for_ScoreChecking();//Check if user has gotten correct answer
                G1.increase_counter(); //go to next word

                //System.out.println( G1.get_score());//debugging purposes
                //Checks which item_type has been selected by user
                if(G1.get_Item_type().equals("Words")){ //this is all good
                    display_word_from_database();
                }
                if(G1.get_Item_type().equals("Images")){ // this might need testing
                    display_image_from_database();
                }

            }
        });

        RecycleBin_1.add(panel,BorderLayout.CENTER);
        RecycleBin_1.add(panel2,BorderLayout.SOUTH);
        frame.add(main_panel);

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
            thm = new Color(r,g,b);

        }
        br.close();

        main_panel.setBackground(bkg);
        RecycleBin_1.setBackground(bkg);
        word_or_image_panel.setBackground(bkg);
        RecycleBin_1.setBackground(bkg);
        panel.setBackground(bkg);
        panel2.setBackground(bkg);

        nextButton.setBackground(thm);
        prevButton.setBackground(thm);
        pauseButton.setBackground(thm);
        exitButton.setBackground(thm);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setVisible(true);
    }
    //help with initialization of either word or image at the start of the game
    public void start_word_or_images(){
        if(G1.get_Item_type().equals("Words")){
            display_word_from_database();
        }
        if(G1.get_Item_type().equals("Images")){
            display_image_from_database();
        }
    }

    //Based on counter in Gameinfo class this word will display the word
    public void display_word_from_database(){
        //first time around
        if(G1.get_counter()== 0){
            word_or_image_panel.add(Word_Image);
        }

        String Game_difficulty_chosen = G1.getGame_Chosen();
        if(Game_difficulty_chosen.equals("Hard")){
            word = G1.get_Hard_database_word(G1.get_counter()); //G1 will store the counter to increment the scores and current position in array
        }
        else if(Game_difficulty_chosen.equals("Normal")){
            word = G1.get_Normal_database_word(G1.get_counter()); //G1 will store the counter to increment the scores and current position in array
        }
        else{ //easy mode
            word = G1.get_Easy_database_word(G1.get_counter()); //G1 will store the counter to increment the scores and current position in array
        }
        Word_Image.setText(word);
    }

    public void display_image_from_database(){
        //array of difficulty, pick image depending on the name of those
        //image.jpg
        String Game_difficulty_chosen = G1.getGame_Chosen();

        //word in this case will be a filename to the images
        if(Game_difficulty_chosen.equals("Hard")){
            word = G1.get_Hard_database_image(G1.get_counter()); //G1 will store the counter to increment the scores and current position in array
        }
        else if(Game_difficulty_chosen.equals("Normal")){
            word = G1.get_Normal_database_image(G1.get_counter()); //G1 will store the counter to increment the scores and current position in array
        }
        else{ //easy mode
            word = G1.get_Easy_database_image(G1.get_counter()); //G1 will store the counter to increment the scores and current position in array
        }

        ImageIcon img1 = resize_containers(word); //img1 will be the image needed
        System.out.println("this is the filename of the images: " +word);

        //first loop around
        if(G1.get_counter() == 0){//starting point
            image_temp.setHorizontalAlignment(SwingConstants.CENTER);
            image_temp.setIcon(img1);
            word_or_image_panel.add(image_temp);
        }
        else{
            word_or_image_panel.remove(image_temp);
            image_temp.setHorizontalAlignment(SwingConstants.CENTER);
            image_temp.setIcon(null);
            image_temp.setIcon(img1);
            word_or_image_panel.add(image_temp);
        }


    }

    //Set Score
    public void Give_userInput_for_ScoreChecking(){
        if(b1.isSelected()){
            G1.set_Current_user_word("Bottles/Cans");
        }
        if(b2.isSelected()){
            G1.set_Current_user_word("E-Waste");
        }
        if(b3.isSelected()){
            G1.set_Current_user_word("Mixed Paper");
        }
        if(b4.isSelected()){
            G1.set_Current_user_word("Organics");
        }
        if(b5.isSelected()){
            G1.set_Current_user_word("Plastics");
        }
        if(b6.isSelected()){
            G1.set_Current_user_word("Trash");
        }
        G1.check_answer(); //checks the answer and increases score if it is corret
        if(G1.get_counter()==G1.get_max_number_items()-1){ //-1 because it goes from 0 to 14
            double final_score = G1.get_calculated_score();
            nextButton.setText("End");
            progressTextField.setText("Your Score is: " + String.valueOf(final_score));
        }
    }



    //Setting the radio buttons in the Gui
    public void setting_Radio_buttons(){

        panel2.setBounds(20,450,600,300);
        panel2.add(b1);bg.add(b1);
        panel2.add(b2);bg.add(b2);
        panel2.add(b3);bg.add(b3);
        panel2.add(b4);bg.add(b4);
        panel2.add(b5);bg.add(b5);
        panel2.add(b6);bg.add(b6);
    }
    //this function specifies the location of the containers
    public void setting_containers(){

        panel.setBounds(20,350,600,300);
        ImageIcon img1 = resize_containers("src/Bins/Bottles-Cans.jpg");//
        ImageIcon img2 = resize_containers("src/Bins/E-Waste.jpg");
        ImageIcon img3 = resize_containers("src/Bins/Mixed Paper.jpg");
        ImageIcon img4 = resize_containers("src/Bins/Organics.jpg");
        ImageIcon img5 = resize_containers("src/Bins/Plastics.jpg");
        ImageIcon img6 = resize_containers("src/Bins/Trash.jpg");

        panel.add(new JLabel(img1));
        panel.add(new JLabel(img2));
        panel.add(new JLabel(img3));
        panel.add(new JLabel(img4));
        panel.add(new JLabel(img5));
        panel.add(new JLabel(img6));
    }


    //this will resize all the images
    public ImageIcon resize_containers(String filename){
        ImageIcon imageIcon = new ImageIcon(filename); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;

    }

    //sends all info from game setting screen to game info calss
    public void SetGameGUIParam(String Game_Difficulty, String Game_Item_type , boolean timer, int Game_num_items){
        G1.set_game_all_param(Game_Difficulty, Game_Item_type ,timer, Game_num_items); //give input to this class
        G1.pick_Database_word_array(); //this class will select the array
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