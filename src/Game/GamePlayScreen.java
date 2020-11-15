package Game;

public interface GamePlayScreen {
    void GameGUI();
    int getScore();
    void skip();
    void pause();
    void quitCurrentGame();
    void viewGamestatus();
    void OpenGame();
    boolean playAgain();
    void exitGame();
    boolean SaveGame();
}
