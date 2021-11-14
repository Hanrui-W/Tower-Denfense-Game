package controller;

import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.Enemy;
import model.GameDifficultyLevel;
import model.Model;
import model.TowerType;
import view.InitGameScreen;

import java.io.File;
import java.util.*;

public class GameController implements IController {
    private Model model;
    private Image purchasedTower;
    private InitGameScreen screen;
    public GameController(int width, int height) {
        model = Model.getInstance();
        initScreen(width, height);
    }
    @Override
    public void initScreen(int width, int height) {
        ArrayList<TowerType> listOfTowers = new ArrayList<>();

        listOfTowers.add(new TowerType("Flowy Flower",
                new Image(new File("src/main/resources/sunflower.gif")
                        .toURI()
                        .toString()),
                model.getTowerPriceBaseValue(), 1, 1, 1, 1));

        listOfTowers.add(new TowerType("Pew Pew Pea",
                new Image(new File("src/main/resources/pea.gif")
                        .toURI()
                        .toString()),
                model.getTowerPriceBaseValue() * 2, 2, 2, 2, 2));

        listOfTowers.add(new TowerType("Wag Wag Mushroom",
                new Image(new File("src/main/resources/mushroom.gif")
                        .toURI()
                        .toString()),
                model.getTowerPriceBaseValue() * 3, 3, 3, 3, 3));

        screen = new InitGameScreen(width, height, listOfTowers);
        screen.setHealthValue(model.getMonumentHealth());
        screen.setMoneyValue(model.getMoney());
        screen.initMap(model.getMap());
        AppLauncher.getMainWindow().setScene(screen.getScene());

        //Call this method will start Enemies Animation
        Button combat = screen.getStartCombatStatus();

        combat.setOnAction(e -> {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            update();
                        }
                    });
                }
            }, 0, 1000);
            combat.setOnAction(null);
        });


        ArrayList<Button> buttons = screen.getButtons();
        ArrayList<String> towerNames = new ArrayList<>();
        towerNames.add("flowy flower");
        towerNames.add("pew pew pea");
        towerNames.add("wag wag mushroom");

        for (Button button : buttons) {
            button.setOnAction(e -> {
                TowerType tower = listOfTowers.get(buttons.indexOf(button));
                if (screen.getPurchased()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Have not placed purchased tower.");
                    alert.setContentText("Must place purchased tower to continue.");
                    alert.showAndWait();
                } else if (model.getMoney() < tower.getCost()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Insufficient funds.");
                    alert.setContentText("You do not have enough funds to purchase this tower.");
                    alert.showAndWait();
                } else {
                    model.setMoney(model.getMoney() - tower.getCost());
                    screen.setMoneyValue(model.getMoney());
                    screen.setPurchasedTower(true);
                    purchasedTower = tower.getImage();
                    screen.setMessageLabel("You purchased\n"
                            + towerNames.get(buttons.indexOf(button)));
                }
            });
        }

        for (Node node : screen.getMap().getChildren()) {
            node.setOnMouseClicked(t -> screen.getMap().getChildren().forEach(c -> {
                Rectangle tile = (Rectangle) node;
                if (screen.getPurchased() && tile.getStyleClass().contains("available")) {
                    tile.setFill(new ImagePattern(purchasedTower));
                    tile.getStyleClass().remove("available");
                    tile.getStyleClass().add("unavailable");
                    screen.setPurchasedTower(false);
                    screen.setMessageLabel("Tower is placed.");
                } else if (screen.getPurchased() && (tile.getStyleClass().contains("unavailable")
                        || (tile.getStyleClass().contains("padding")))) {
                    screen.setMessageLabel("It is not available.\n"
                            + "Place the tower\n"
                            + "on the while areas.");
                }
            }));
        }

        for (Node node : screen.getMap().getChildren()) {
            node.setOnMouseEntered(t -> screen.getMap().getChildren().forEach(c -> {
                Rectangle tile = (Rectangle) node;
                if (screen.getPurchased() && tile.getFill() == Color.WHITE) {
                    tile.setFill(Color.rgb(0, 200, 0, 0.3));
                }
            }));
            node.setOnMouseExited(t -> screen.getMap().getChildren().forEach(c -> {
                Rectangle tile = (Rectangle) node;
                if (Objects.equals(tile.getFill(), Color.rgb(0, 200, 0, 0.3))) {
                    tile.setFill(Color.WHITE);
                }
            }));
        }
    }

    public void update() {
        model.setMoney(model.getMoney() + 10);
        screen.setMoneyValue(model.getMoney());
        model.setTime(model.getTime() + 1);
    }

    public void moveEachEnemy(Enemy enemy, int xPosition, int yPosition) {
        if (enemy.moveEnemy()) {
            enemy.setxPosition(xPosition);
            enemy.setyPosition(yPosition);
        }
    }
}
