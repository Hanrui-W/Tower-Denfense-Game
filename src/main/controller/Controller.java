package controller;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Model;
import view.InitConfigScreen;
import view.InitGameScreen;
import view.WelcomeScreen;

public class Controller extends Application {
    private Stage mainWindow;
    private Model gameModel;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    public void start(Stage stage) {
        mainWindow = stage;
        mainWindow.setTitle("Game");
        initWelcomeScreen();
    }

    public void initWelcomeScreen() {
        WelcomeScreen screen = new WelcomeScreen(WIDTH, HEIGHT);
        Button startButton = screen.getStartButton();
        startButton.setOnAction(e -> {
            goToInitConfigScreen();
        });

        mainWindow.setScene(screen.getScene());
        mainWindow.show();
    }

    public void goToInitConfigScreen() {
        InitConfigScreen screen = new InitConfigScreen(WIDTH, HEIGHT);
        Button nextButton = screen.getNextButton();
        nextButton.setOnAction(e -> {
            goToInitGameScreen();
        });

        mainWindow.setScene(screen.getScene());
        mainWindow.show();
    }

    public void goToInitGameScreen() {
        InitGameScreen screen = new InitGameScreen(WIDTH, HEIGHT);
        Button nextButton = screen.getNextButton();
        nextButton.setOnAction(e -> {
            mainWindow.close();
        });

        mainWindow.setScene(screen.getScene());
        mainWindow.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
