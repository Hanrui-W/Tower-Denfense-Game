package controller;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import model.Model;
import view.WinGameScreen;

public class WinGameController implements IController {
    private final int width;
    private final int height;
    private final Model model;

    public WinGameController(int width, int height) {
        this.width = width;
        this.height = height;
        model = Model.getInstance();
    }

    @Override
    public Scene initScreen() {
        WinGameScreen screen = new WinGameScreen(width, height);
        screen.setTowersUpgraded(model.getTowersUpgraded());
        screen.setTowersPlaced(model.getTowersPlaced());
        screen.setEnemiesKilled(model.getEnemiesKilled());
        Button restartButton = screen.getRestartButton();
        restartButton.setOnAction(e -> {
            AppLauncher.goToWelcomeScreen();
        });
        Button exitButton = screen.getExitButton();
        exitButton.setOnAction(e -> {
            AppLauncher.getMainWindow().close();
        });

        return screen.getScene();
    }
}
