package Game;

import java.util.Collections;
import java.util.ArrayList;

public class Data implements Database{
    protected String [] easyItems = {"Plastic Straws", "Shoe Box", "Egg Tray", "Broccoli", "Newspaper", "Broken Glass Cup", "Potato Chip Bag",
    "Juice Box", "Banana Peel", "Pizza", "Greeting Cards", "Gift Bag", "pizzabox", "Coffee Cup", "Laptop", "Homework", "Tin Can", "Plastic Clamshell"};
    protected String [] mediumItems = {"Lotion Jars", "Receipts", "Party Cups", "Beer Bottles", "Ruler", "Egg Shells", "Baby Diapers","Avocado Seed",
     "Cup Noodles", "Chocolate Wrappers", "Milk Jug", "Watermelon","Milk Carton", "Soda Bottles", "Plastic Bags", "Plastic Rings", "Styrofoam", "Glass Jar"};
    protected String [] hardItems = {"Coffee Cup Lid", "Broken Mirror", "Latex Balloons", "Medicine Bottle", "Chewed Gum","Baby Wipes", "Gift Wrap","Toilet Cleaner",
             "Wine Box", "Packaging Peanuts","Envelopes", "Face Mask", "Paint Brushes", "Magazines", "Cookies", "Candy Wrappers", "Aluminium Foil", "Game Controller"};

    protected ArrayList nums;

    protected String [] easyAnswers = {"Trash", "Mixed Paper", "Mixed Paper", "Organic", "Mixed Paper", "Bottles/Cans", "Trash", "Bottles/Cans",
    "Organic", "Organic", "Mixed Paper", "Mixed Paper", "Trash", "Mixed Paper", "E-waste", "Mixed Paper", "Bottles/Cans", "Plastics"};
    protected String [] mediumAnswers = {"Plastics", "Mixed Paper", "Trash", "Bottles/Cans", "Plastics", "Organic", "Trash", "Organic",
    "Trash", "Trash", "Plastics", "Organic", "Mixed Paper", "Bottles/Cans", "Plastics", "Trash", "Mixed Paper", "Bottles/Cans"};
    protected String [] hardAnswers = {"Plastics", "Bottles/Cans", "Plastics", "Plastics", "Organic", "Trash", "Mixed Paper", "Plastics",
    "Mixed Paper", "Trash", "Mixed Paper", "Trash", "Trash", "Mixed Paper", "Organic", "Trash", "Bottles/Cans", "E-waste"};

    public Data(){
    }

    // function to generate and array of a new game play of a specific size.
    public int[] playIndex(int size) {
        int[] play = new int[size];
        // create an ArrayList of the index numbers, which is 0 to 18 and then shuffle them
        // this makes the list random each time
        nums = new ArrayList();
        for (int i = 0; i < 18; i++){
            nums.add(i);
        }
        Collections.shuffle(nums);
        // put the generated indexes in an array and return it
        for (int i = 0; i < size; i++){
            play[i] = (int) nums.get(i);
        }
        return play;
    }

    @Override
    public String soundData(int Size) {
        return null;
    }

    //returns an array of the easy words depending on the amount of words needed
    //takes in an array with the play index and of the size of the array
    @Override
    public String[] EasyWordData(int arr[], int size) {
       String[] easyplay = new String[size];
       for (int i = 0; i < size; i ++)
       {
           easyplay[i] = easyItems[arr[i]];
       }
        return easyplay;
    }

    //returns an array of the medium words depending on the amount of words needed
    //takes in an array with the play index and of the size of the array
    @Override
    public String[] MediumWordData(int arr[], int size) {
        String[] medplay = new String[size];
        for (int i = 0; i < size; i ++)
            medplay[i] = mediumItems[arr[i]];
        return medplay;
    }

    //returns an array of the hard words depending on the amount of words needed
    //takes in an array with the play index and of the size of the array
    @Override
    public String[] HardWordData(int arr[], int size) {
        String[] hardplay = new String[size];
        for (int i = 0; i < size; i ++)
            hardplay[i] = hardItems[arr[i]];
        return hardplay;
    }

    //returns an array of the answers to the respective game play words in an array
    //takes in the same play index array that EasyWordData takes in
    @Override
    public String[] EasyAnsData(int arr[], int size) {
        String[] easyans = new String[size];
        for (int i = 0; i < size; i ++) {
            easyans[i] = easyAnswers[arr[i]];
        }
        return easyans;
    }

    //returns an array of the answers to the respective game play words in an array
    //takes in the same play index array that HardWordData takes in
    @Override
    public String[] MediumAnsData(int arr[], int size) {
        String[] medans = new String[size];
        for (int i = 0; i < size; i ++)
            medans[i] = mediumAnswers[arr[i]];
        return medans;
    }

    //returns an array of the answers to the respective game play words in an array
    //takes in the same play index array that HardWordData takes in
    @Override
    public String[] HardAnsData(int arr[], int size) {
        String[] hardans = new String[size];
        for (int i = 0; i < size; i ++)
            hardans[i] = hardAnswers[arr[i]];
        return hardans;
    }


    @Override
    public String ImageData(int Size) {
        return null;
    }

    @Override
    public String themeData(int Size) {
        return null;
    }

    @Override
    public String backgroundColorData(int Size) {
        return null;
    }

    public static void main(String[] args) {
        // A simple testing code
        Data dat = new Data();
        int size = 5;
        int arr[] = new int[size];
        arr = dat.playIndex(size);
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
        String[] easyPy = new String[size];
        easyPy = dat.MediumWordData(arr, size);
        for (int i = 0; i < size; i++) {
            System.out.println(easyPy[i]);
        }
        String[] easyAns = new String[size];
        easyAns = dat.MediumAnsData(arr, size);
        for (int i = 0; i < size; i++) {
            System.out.println(easyAns[i]);
        }
    }
}
