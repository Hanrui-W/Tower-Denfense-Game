package controller;

import javafx.application.Platform;
import javafx.scene.control.Button;
import model.Model;
import view.GameOverScreen;

public class GameOverController implements IController{
    public GameOverController(int width, int height) {
        initScreen(width, height);
    }
    @Override
    public void initScreen(int width, int height) {
        GameOverScreen screen = new GameOverScreen(width, height);
        Button restartButton = screen.getRestartButton();
        restartButton.setOnAction(e -> {
            AppLauncher.goToWelcomeScreen();
        });
        Button exitButton = screen.getExitButton();
        exitButton.setOnAction(e -> {
            Platform.exit();
        });
        screen.setWin(Model.getInstance().isWin());

        AppLauncher.getMainWindow().setScene(screen.getScene());
        AppLauncher.getMainWindow().show();
    }
}
