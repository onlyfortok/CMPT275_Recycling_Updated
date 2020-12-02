package Game;
import java.util.*;

public class Game_Info extends Data implements Game_parameters {
    protected int max_number_items=5; // num of items
    protected int counter=0; // counter will record item number
    protected int score=0; // score will record current score
    protected String difficultyLevel= "";
    protected String item_types = "";
    protected boolean Timer = false;
    protected String user_current_word;

    //Which array is selected
    protected String [] HardDiffLevel_data;
    protected String [] HardDiffLevel_answer;
    protected String [] mediumDiffLevel_data;
    protected String [] mediumDiffLevel_answer;
    protected String [] EasyDiffLevel_data;
    protected String [] EasyDiffLevel_answer;
    protected String Game_Chosen = "";
    protected String [] answer= {"Bottles/Cans","E-Waste","Mixed Paper","Organics","Plastics","Trash"};


    protected String[] items = {"Vase", "Cans", "Sandwich", "Punch Bowl","Bong"};
    protected String[] answers = {"Glass", "Metal", "Organic", "Glass","Glass"};
    protected String[] container = {"Glass","Metal","Organic"};
    protected String[] track_of_scores = {"","","","","","","","","","","","","","",""}; //record yes for correct, no for wrong
    protected static List<Double> array_full_of_scores; // we want this to be static
    public Data Database = new Data();



    public Game_Info(){
    }

    //if the user selects word option then this function will pick the database
    public void pick_Database_word_array(){
        int size = max_number_items;
        int arr[] = new int[size];
        arr = Database.playIndex(max_number_items);
        if(difficultyLevel.equals("Hard")){
            HardDiffLevel_data = Database.HardWordData(arr, size);
            HardDiffLevel_answer = Database.HardAnsData(arr, size);
            Game_Chosen = "Hard";
        }
        else if(difficultyLevel.equals("Normal")){
            mediumDiffLevel_data = Database.MediumWordData(arr, size);
            mediumDiffLevel_answer = Database.MediumAnsData(arr, size);
            Game_Chosen = "Normal";
        }
        else{ //difficulty is easy
            EasyDiffLevel_data = Database.EasyWordData(arr, size);
            EasyDiffLevel_answer = Database.EasyAnsData(arr, size);
            Game_Chosen = "Easy";
        }
    }


    //helps with intializing
    public void set_game_all_param(String param2, String param3, boolean param4, int param5 ){
        this.item_types= param3;
        this.difficultyLevel = param2;
        this.Timer = param4;
        this.max_number_items = param5;
    }



    //getters
    public String get_word(int i){ //i has to be between 0 and 5
        return this.items[i];
    }
    public int get_counter(){ //i has to be between 0 and 5
        return this.counter;
    }
    public String get_container(int i){ //i has to be between 0 and 5
        return this.container[i];
    }
    public int get_max_number_items(){ //i has to be between 0 and 5
        return this.max_number_items;
    }
    public int get_score(){ //i has to be between 0 and 5
        return this.score;
    }
    public double get_calculated_score(){ //i has to be between 0 and 5
        double temp_score=0;
        for(int i=0; i<this.max_number_items;i++) {
            if(this.track_of_scores[i].equals("yes")) {
                temp_score +=1;
            }
            }
        return (temp_score/this.max_number_items);
    }
    public String get_answer(int i){ //i has to be between 0 and 5
        return this.answers[i];
    }
    public String get_difficultyLevel(){ return this.difficultyLevel; }
    public String[] get_containers(){return this.container;}
    public String get_Item_type(){return this.item_types;}


    //getters for words from database
    public String get_Hard_database_word(int counter_game){
        return HardDiffLevel_data[counter_game];
    }
    public String get_Normal_database_word(int counter_game){
        return mediumDiffLevel_data[counter_game];
    }
    public String get_Easy_database_word(int counter_game){
        return EasyDiffLevel_data[counter_game];
    }
    //get Game_chosen
    public String getGame_Chosen(){
        return Game_Chosen;
    }
    //get Hard image
    public String get_Hard_database_image(int counter_game){
        String temp = HardDiffLevel_data[counter_game];
        return "src/RecyclingImages/" + temp + ".jpg"; //filename to image
    }
    //get Normal image
    public String get_Normal_database_image(int counter_game){
        String temp = mediumDiffLevel_data[counter_game];
        return "src/RecyclingImages/" + temp + ".jpg"; //filename to image
    }
    //get easy image
    public String get_Easy_database_image(int counter_game){
        String temp = EasyDiffLevel_data[counter_game];
        return "src/RecyclingImages/" + temp + ".jpg"; //filename to image
    }



    //getters for images from database

    //setters
    public void set_counter(int i){ //i has to be between 0 and 5
        this.counter = i;
    }
    public void set_score(int i){ //i has to be between 0 and 5
        this.counter = i;
    }

    public void set_difficultyLevel(String difficulty_level){ this.difficultyLevel = difficulty_level;}
    public void set_containers(String[] container_array){this.container = container_array;} //not too sure if you can set an array equal to another array in java
    public void set_score_history(double score){array_full_of_scores.add(score);}
    public void set_Current_user_word(String current_word){
        this.user_current_word = current_word;
    }



    // useful features
    public void increase_score(){ //i has to be between 0 and 5
        this.score = this.score +1;
    }
    public void increase_counter(){ //i has to be between 0 and 5
        this.counter = this.counter+1;
    }
    public void decrease_counter(){ //i has to be between 0 and 5
        this.counter = this.counter-1;
    }

    public void reset_counter(){ //i has to be between 0 and 5
        this.counter = 0;
    }
    public void reset_score(){ //i has to be between 0 and 5
        this.score = 0;
    }
    public void check_answer(){
        if(Game_Chosen.equals("Hard")){
            if(user_current_word.equals(HardDiffLevel_answer[this.counter])){
                increase_score();
                this.track_of_scores[this.counter] = "yes";
            }
            else{
                this.track_of_scores[this.counter] = "no";
            }
        }
        if(Game_Chosen.equals("Normal")){
            if(user_current_word.equals(mediumDiffLevel_answer[this.counter])){
                increase_score();
                this.track_of_scores[this.counter] = "yes";
            }
            else{
                this.track_of_scores[this.counter] = "no";
            }
        }
        if(Game_Chosen.equals("Easy")){
            if(user_current_word.equals( EasyDiffLevel_answer[this.counter])){
                increase_score();
                this.track_of_scores[this.counter] = "yes";
            }
            else{
                this.track_of_scores[this.counter] = "no";
            }
        }
    }

    public void reset_score_history(double score){array_full_of_scores.removeAll(array_full_of_scores);}
    public String game_statistics(){
        int sum = 0;
        for (int i = 0; i < this.array_full_of_scores.size(); i++) {
            sum += array_full_of_scores.get(i);
        }
        int mean = sum/this.array_full_of_scores.size();

        return String.valueOf(mean);
    }

}
