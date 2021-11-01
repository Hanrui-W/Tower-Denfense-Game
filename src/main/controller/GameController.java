package controller;

import javafx.animation.PathTransition;
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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class GameController implements IController {
    private Model model;
    private Image purchasedTower;
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

        //use for initializing enemies
        LinkedList<Enemy> listOfEnemies = new LinkedList<>();
        listOfEnemies.add(new Enemy(GameDifficultyLevel.EASY,
                3,
                model.getEnemyHealth(),
                model.getEnemyDamage()));
        listOfEnemies.add(new Enemy(GameDifficultyLevel.EASY, 4,
                model.getEnemyHealth(),
                model.getEnemyDamage()));
        listOfEnemies.add(new Enemy(GameDifficultyLevel.EASY,
                5,
                model.getEnemyHealth(),
                model.getEnemyDamage()));
        model.setEnemies(listOfEnemies);

        InitGameScreen screen = new InitGameScreen(width, height, listOfTowers);
        screen.setHealthValue(model.getMonumentHealth());
        screen.setMoneyValue(model.getMoney());
        screen.initMap(model.getMap());
        screen.setEnemiesAnimation(model.getEnemies());
        AppLauncher.getMainWindow().setScene(screen.getScene());

        //Call this method will start Enemies Animation
        Button combat = screen.getStartCombatStatus();

        combat.setOnAction(e -> screen.playEnemiesAnimation());

        for (int i = 0; i < screen.getEnemiesPathAnimation().size(); i++) {
            PathTransition transition = screen.getEnemiesPathAnimation().get(i);
            int finalI = i;
            transition.setOnFinished(e -> {
                if (model.getMonumentHealth() <= model.getEnemies().get(finalI).getAttackDamage()) {
                    //GAME OVER HERE
                    for (PathTransition pathTransition : screen.getEnemiesPathAnimation()) {
                        pathTransition.pause();
                    }
                    // SIMPLE GAME OVER ALERT(should go to game over screen here)
                    model.setWin(false);
                    AppLauncher.goToGameOverScreen();
                } else {
                    model.setMonumentHealth(model.getMonumentHealth()
                            - (int) model
                            .getEnemies()
                            .get(finalI)
                            .getAttackDamage());
                    screen.setHealthValue(model.getMonumentHealth());
                    transition.play();
                }

            });
        }

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
}
