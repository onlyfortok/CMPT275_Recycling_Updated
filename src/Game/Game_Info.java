package Game;

public class Game_Info implements Game_parameters{
    protected int max_number_items=5;
    protected int counter=0; // counter will record item number
    protected int score=0; // score will record current score

    protected String[] items = {"Vase", "Cans", "Sandwich", "Punch Bowl","Bong"};
    protected String[] answers = {"Glass", "Metal", "Organic", "Glass","Glass"};
    protected String[] container = {"Glass","Metal","Organic"};
    protected String[] track_of_scores = {"","","","",""}; //record yes for correct, no for wrong

    public Game_Info(){
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



    //setters
    public void set_counter(int i){ //i has to be between 0 and 5
        this.counter = i;
    }
    public void set_score(int i){ //i has to be between 0 and 5
        this.counter = i;
    }


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


}
