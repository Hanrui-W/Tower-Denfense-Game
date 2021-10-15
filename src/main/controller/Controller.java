package controller;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.GameDifficultyLevel;
import model.Model;
import model.TowerType;
import view.InitConfigScreen;
import view.InitGameScreen;
import view.WelcomeScreen;
import java.io.File;
import java.util.ArrayList;


public class Controller extends Application {
    private Stage mainWindow;
    private Model model;
    private static final int WIDTH = 960;
    private static final int HEIGHT = 720;
    private Image purchasedTower;

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
        ArrayList<TowerType> listOfTowers = new ArrayList<>();
        listOfTowers.add(new TowerType("Flowy Flower", "tower1",
                new File("src/main/resources/sunflower.gif")
                        .toURI()
                        .toString(),
                model.getTowerPriceBaseValue(), 1, 1, 1));
        listOfTowers.add(new TowerType("Pew Pew Pea", "tower2",
                new File("src/main/resources/pea.gif")
                        .toURI()
                        .toString(),
                model.getTowerPriceBaseValue() * 2, 1, 1, 1));
        listOfTowers.add(new TowerType("Wag Wag Mushroom", "tower3",
                new File("src/main/resources/mushroom.gif")
                        .toURI()
                        .toString(),
                model.getTowerPriceBaseValue() * 3, 1, 1, 1));

        InitGameScreen screen = new InitGameScreen(WIDTH, HEIGHT, listOfTowers);
        screen.setHealthValue(model.getMonumentHealth());
        screen.setMoneyValue(model.getMoney());
        screen.initMap(model.getMap());
        mainWindow.setScene(screen.getScene());

        ArrayList<Button> buttons = screen.getButtons();
        Button towerOne = buttons.get(0);
        Button towerTwo = buttons.get(1);
        Button towerThree = buttons.get(2);

        towerOne.setOnAction(e -> {
            if (screen.getPurchased()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Have not placed purchased tower");
                alert.setContentText("Must place purchased tower to continue.");
                alert.showAndWait();
            } else  if (model.getMoney() < listOfTowers.get(0).getCost()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Insufficient funds.");
                alert.setContentText("You do not have enough funds to purchase this tower.");
                alert.showAndWait();
            } else {
                model.setMoney(model.getMoney() - listOfTowers.get(0).getCost());
                screen.setMoneyValue(model.getMoney());
                screen.setPurchasedTower(true);
                purchasedTower = new Image(new File("src/main/resources/sunflower.gif")
                        .toURI()
                        .toString());
            }
        });

        towerTwo.setOnAction(e -> {
            if (screen.getPurchased()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Have not placed purchased tower");
                alert.setContentText("Must place purchased tower to continue.");
                alert.showAndWait();
            } else  if (model.getMoney() < listOfTowers.get(1).getCost()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Insufficient funds.");
                alert.setContentText("You do not have enough funds to purchase this tower.");
                alert.showAndWait();
            } else {
                model.setMoney(model.getMoney() - listOfTowers.get(1).getCost());
                screen.setMoneyValue(model.getMoney());
                screen.setPurchasedTower(true);
                purchasedTower = new Image(new File("src/main/resources/pea.gif")
                        .toURI()
                        .toString());
            }
        });

        towerThree.setOnAction(e -> {
            if (screen.getPurchased()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Have not placed purchased tower");
                alert.setContentText("Must place purchased tower to continue.");
                alert.showAndWait();
            } else  if (model.getMoney() < listOfTowers.get(2).getCost()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Insufficient funds.");
                alert.setContentText("You do not have enough funds to purchase this tower.");
                alert.showAndWait();
            } else {
                model.setMoney(model.getMoney() - listOfTowers.get(2).getCost());
                screen.setMoneyValue(model.getMoney());
                screen.setPurchasedTower(true);
                purchasedTower = new Image(new File("src/main/resources/mushroom.gif")
                        .toURI()
                        .toString());
            }
        });

        for (Node node : screen.getMap().getChildren()) {
            node.setOnMouseClicked(t -> screen.getMap().getChildren().forEach(c -> {
                Rectangle tile = (Rectangle) node;
                if (screen.getPurchased() && tile.getFill() == Color.GRAY) {
                    tile.setFill(new ImagePattern(purchasedTower));
                    System.out.println(true);
                    screen.setPurchasedTower(false);
                    screen.setMessageLabel("");
                } else if (screen.getPurchased() && tile.getFill() == Color.YELLOW) {
                    screen.setMessageLabel("You cannot place tower\n"
                            +  "on the path. Click\n"
                            + "on the grey tiles.");
                }
            }));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
