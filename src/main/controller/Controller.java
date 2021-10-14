package controller;

import javafx.application.Application;
import javafx.scene.control.Alert;
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
        TextField nameText = screen.getUsername();
        nameText.setOnAction(e -> {
            nameText.setText(nameText.getText());
        });
        ChoiceBox<GameDifficultyLevel> box = screen.getDifficultyChoiceBox();
        box.setOnAction(e -> {
            box.setValue(box.getValue());
        });
        Button nextButton = screen.getNextButton();
        nextButton.setOnAction(e -> {
            if (model.initGame(nameText.getText().trim(), box.getValue())) {
                goToInitGameScreen();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Empty Name");
                alert.setContentText("Please enter a valid name.");
                alert.showAndWait();
            }
        });

        mainWindow.setScene(screen.getScene());
        mainWindow.show();
    }

    public void goToInitGameScreen() {
        InitGameScreen screen = new InitGameScreen(WIDTH, HEIGHT);
        screen.setHealthValue(model.getMonumentHealth());
        screen.setMoneyValue(model.getMoney());
        mainWindow.setScene(screen.getScene());
        mainWindow.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
