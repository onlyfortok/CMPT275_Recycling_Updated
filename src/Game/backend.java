package Game;

public interface backend {
    String retrieveGameStatisctics();
    String retrieveHowtoPlay();
    String retrieveScoreHistory();
    String retrieveNewGameItem();
    String retrieveSound();
    String retrieveBackgorundColor();
    void DisplayGeneralGameOptions();
    void DisplayGameStatistics();
    void displayHowtoPlay();
    void displayResetScoreHistory();
    void displayNewGameItem();

}
