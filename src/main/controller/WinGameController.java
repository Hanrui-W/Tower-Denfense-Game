package controller;

import javafx.scene.control.Button;
import model.Model;
import view.GameOverScreen;

public class WinGameController implements IController {
    public WinGameController(int width, int height) {
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
            AppLauncher.getMainWindow().close();
        });

        AppLauncher.getMainWindow().setScene(screen.getScene());
        AppLauncher.getMainWindow().show();
    }
}
