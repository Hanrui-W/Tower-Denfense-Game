package controller;

import javafx.scene.control.Button;
import model.Model;
import view.GameOverScreen;

public class GameOverController implements IController {
    Model model;

    public GameOverController(int width, int height) {
        model = Model.getInstance();
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

        screen.setEnemiesKilled(model.getEnemiesKilled());
        screen.setTowersPlaced(model.getTowersPlaced());
        screen.setTowersUpgraded(model.getTowersUpgraded());

        AppLauncher.getMainWindow().setScene(screen.getScene());
        AppLauncher.getMainWindow().show();
    }
}
