package controller;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.GameDifficultyLevel;
import model.Model;
import view.InitConfigScreen;
import view.InitGameScreen;
import view.WelcomeScreen;

public class Controller extends Application {
    private Stage mainWindow;
    private Model model;
    private static final int WIDTH = 960;
    private static final int HEIGHT = 720;

    public void start(Stage stage) {
        mainWindow = stage;
        mainWindow.setTitle("Game");
        model = new Model();
        goToInitConfigScreen();
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
        screen.getUsername().setText("123");
        TextField nameText = screen.getUsername();
        nameText.setOnAction(e -> {
            nameText.setText(nameText.getText());
        });
        ChoiceBox<GameDifficultyLevel> difficultyChoiceBox = screen.getDifficultyChoiceBox();
        difficultyChoiceBox.setOnAction(e -> {
            difficultyChoiceBox.setValue(difficultyChoiceBox.getValue());
        });
        Button nextButton = screen.getNextButton();
        nextButton.setOnAction(e -> {
            if (model.initGame(nameText.getText().trim(), difficultyChoiceBox.getValue())) {
                goToInitGameScreen();
            }
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
