package Game;

public interface Game_parameters {
   // static String[] words = {"Volvo", "BMW", "Ford", "Mazda"};

    //getter
    String get_word(int i); //get words at index i in the array
    String get_difficultyLevel(); // returns the difficulty level
    String[] get_containers();
    //setter
    void set_difficultyLevel(String difficulty_level);
    void set_containers(String[] container_array);
    //void set_theme();

}

//ideally we would store the words in a .txt files with its corresponding answer
