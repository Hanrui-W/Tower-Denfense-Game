package controller;

import javafx.scene.control.Button;
import view.WelcomeScreen;

public class StartController implements IController{
    public StartController(int width, int height) {
        initScreen(width, height);
    }
    @Override
    public void initScreen(int width, int height) {
        WelcomeScreen screen = new WelcomeScreen(width, height);
        Button startButton = screen.getStartButton();
        startButton.setOnAction(e -> {
            AppLauncher.goToInitConfigScreen();
        });

        AppLauncher.getMainWindow().setScene(screen.getScene());
        AppLauncher.getMainWindow().show();
    }
}
