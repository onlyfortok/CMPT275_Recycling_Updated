package Game;

public interface backend {
    String retrieveGameStatistics();
    String retrieveHowtoPlay();
    String retrieveScoreHistory();
    String retrieveNewGameItem();
    String retrieveSound();
    String retrieveBackgroundColor();
    void DisplayGeneralGameOptions();
    void DisplayGameStatistics();
    void displayHowtoPlay();
    void displayResetScoreHistory();
    void displayNewGameItem();
}
