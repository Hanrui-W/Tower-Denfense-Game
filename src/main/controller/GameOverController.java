package controller;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import model.Model;
import view.GameOverScreen;

public class GameOverController implements IController {
    private int width;
    private int height;
    private Model model;
    public GameOverController(int width, int height) {
        this.width = width;
        this.height = height;
        model = Model.getInstance();
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

        screen.setEnemiesKilled(model.getEnemiesKilled());
        screen.setTowersPlaced(model.getTowersPlaced());
        screen.setTowersUpgraded(model.getTowersUpgraded());

        return screen.getScene();
    }
}
