package controller;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import model.Model;
import view.GameOverScreen;

public class GameOverController implements IController {
    private int width;
    private int height;
    public GameOverController(int width, int height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public Scene initScreen() {
        GameOverScreen screen = new GameOverScreen(width, height);
        Button restartButton = screen.getRestartButton();
        restartButton.setOnAction(e -> {
            AppLauncher.goToWelcomeScreen();
        });
        Button exitButton = screen.getExitButton();
        exitButton.setOnAction(e -> {
            AppLauncher.getMainWindow().close();
        });
        screen.setWin(Model.getInstance().isWin());

        return screen.getScene();
    }
}
