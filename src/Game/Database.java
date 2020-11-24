package Game;

public interface Database {

   String soundData(int Size);
   String[] EasyWordData(int arr[], int size);
   String[] MediumWordData(int arr[], int size);
   String[] HardWordData(int arr[], int size);
   String[] EasyAnsData(int arr[], int size);
   String[] MediumAnsData(int arr[], int size);
   String[] HardAnsData(int arr[], int size);
   String ImageData(int Size);
   String themeData(int Size);
   String backgroundColorData(int Size);

}
