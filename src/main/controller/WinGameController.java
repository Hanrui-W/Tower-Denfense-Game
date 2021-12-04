package controller;

import javafx.scene.control.Button;
import model.Model;
import view.WinGameScreen;

public class WinGameController implements IController {
    private Model model;

    public WinGameController(int width, int height) {
        model = Model.getInstance();
        initScreen(width, height);
    }

    @Override
    public void initScreen(int width, int height) {
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

        AppLauncher.getMainWindow().setScene(screen.getScene());
        AppLauncher.getMainWindow().show();
    }
}
