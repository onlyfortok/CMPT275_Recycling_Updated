package Game;
import java.util.*;

public class Game_Info implements Game_parameters{
    protected int max_number_items=5; // num of items
    protected int counter=0; // counter will record item number
    protected int score=0; // score will record current score
    protected String difficultyLevel= "";
    protected String theme = "";
    protected String item_types = "";
    protected boolean Timer = false;


    protected String[] items = {"Vase", "Cans", "Sandwich", "Punch Bowl","Bong"};
    protected String[] answers = {"Glass", "Metal", "Organic", "Glass","Glass"};
    protected String[] container = {"Glass","Metal","Organic"};
    protected String[] track_of_scores = {"","","","",""}; //record yes for correct, no for wrong
    protected static List<Double> array_full_of_scores; // we want this to be static


    public Game_Info(){
    }
    //helps with intializing
    public void set_game_all_param(String param1, String param2, String param3, boolean param4, int param5 ){
        this.theme = param1; // Theme
        this.item_types= param2;
        this.difficultyLevel = param3;
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
    public String get_answer(int i){ //i has to be between 0 and 5
        return this.answers[i];
    }
    public String get_difficultyLevel(){ return this.difficultyLevel; }
    public String[] get_containers(){return this.container;}


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

    // useful features
    public void increase_score(){ //i has to be between 0 and 5
        this.score = this.score +1;
    }
    public void increase_counter(){ //i has to be between 0 and 5
        this.counter = this.counter+1;
    }
    public void reset_counter(){ //i has to be between 0 and 5
        this.counter = 0;
    }
    public void reset_score(){ //i has to be between 0 and 5
        this.score = 0;
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
