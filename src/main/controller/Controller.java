package controller;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.GameDifficultyLevel;
import model.Model;
import model.TowerType;
import view.InitConfigScreen;
import view.InitGameScreen;
import view.WelcomeScreen;
import view.TowerMeunScreen;

import java.io.File;
import java.util.ArrayList;

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
        goToTowerMenu();
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

    //Only for develop, should be deleted after integration with game scene
    public void goToTowerMenu() {
        ArrayList<TowerType> towerTypes = new ArrayList<>();
        towerTypes.add(new TowerType("tower1", "tower1",
                new File("src/main/resources/sunflower.gif")
                        .toURI()
                        .toString(),
                100, 1, 1, 1));
        towerTypes.add(new TowerType("tower2", "tower2",
                new File("src/main/resources/sunflower.gif")
                        .toURI()
                        .toString(),
                200, 1, 1, 1));
        towerTypes.add(new TowerType("tower3", "tower3",
                new File("src/main/resources/mushroom.gif")
                        .toURI()
                        .toString(),
                300, 1, 1, 1));
        TowerMeunScreen towerMenu = new TowerMeunScreen(WIDTH , (int)(HEIGHT/4 +0.5));
        towerMenu.setTowerTypes(towerTypes);
        mainWindow.setScene(towerMenu.getScene());
        mainWindow.show();
     }

    public static void main(String[] args) {
        launch(args);
    }
}
