package controller;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.*;
import view.InitGameScreen;

import java.util.*;

public class GameController implements IController {
    private final int width;
    private final int height;
    private final Model model;
    private TowerType purchasedTower;
    private InitGameScreen screen;
    private final Timer timer;
    public GameController(int width, int height) {
        this.width = width;
        this.height = height;
        model = Model.getInstance();
        timer = new Timer();
    }

    @Override
    public Scene initScreen() {
        ArrayList<TowerType> listOfTowers = model.getListOfTowerTypes();

        screen = new InitGameScreen(width, height, listOfTowers);
        screen.setHealthValue(model.getMonumentHealth());
        screen.setMoneyValue(model.getMoney());
        screen.initMap(model.getMap());
        Scene scene = screen.getScene();
        //Call this method will start Enemies Animation
        Button combat = screen.getStartCombatStatus();

        combat.setOnAction(e -> {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(() -> {
                        if (model.getMonumentHealth() <= 0) {
                            AppLauncher.goToGameOverScreen();
                        }
                        model.generateNewEnemy();
                        model.generateFinalBoss();
                        ///////////////////////////////////////////
                        //for test purpose, should lead to win menu
                        if (model.isFinalBossDefeated()) {
                            AppLauncher.goToWinScreen();
                        }
                        ////////////////////////////////////////////
                        model.updateListOfEnemies();
                        screen.updateEnemiesPosition(model.getListOfEnemies());
                        screen.setHealthValue(model.getMonumentHealth());
                        screen.setMoneyValue(model.getMoney());
                        List<List<Integer>> towerToEnemy = model.towerAttack();
                        screen.drawAttack(towerToEnemy);
                    });
                    if (model.getMonumentHealth() <= 0 || model.isFinalBossDefeated()) {
                        this.cancel();
                    }
                }
            }, 0, 20);
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
                    purchasedTower = new TowerType(tower.getName(),
                            tower.getImage(),
                            tower.getCost(),
                            tower.getAttackDamage(),
                            tower.getAttackSpeed(),
                            tower.getAttackMode(),
                            tower.getRange());
                    screen.setMessageLabel("You purchased\n"
                            + towerNames.get(buttons.indexOf(button)));
                }
            });
        }

        for (Node node : screen.getMap().getChildren()) {
            node.setOnMouseClicked(t -> screen.getMap().getChildren().forEach(c -> {
                Rectangle tile = (Rectangle) node;
                if (screen.getPurchased() && tile.getStyleClass().contains("available")) {
                    tile.setFill(new ImagePattern(purchasedTower.getImage()));
                    tile.getStyleClass().remove("available");
                    tile.getStyleClass().add("unavailable");
                    tile.getStyleClass().add("tower");
                    tile.setOnMouseClicked(e -> {
                        showUpgradeMenu(GridPane.getRowIndex(node), GridPane.getColumnIndex(node));
                    });
                    model.addTower(new Tower(GridPane.getRowIndex(node),
                                            GridPane.getColumnIndex(node),
                                            purchasedTower));

                    screen.setPurchasedTower(false);
                    screen.setMessageLabel("Tower is placed.");
                } else if (screen.getPurchased() && (tile.getStyleClass().contains("unavailable")
                        || (tile.getStyleClass().contains("padding")))) {
                    screen.setMessageLabel("It is not available.\n"
                            + "Place the tower\n"
                            + "on the white areas.");
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
        return scene;
    }

    public void showUpgradeMenu(int x, int y) {
        List<Tower> listOfTowers = model.getListOfTowers();
        Tower tower = new Tower();
        for (Tower t : listOfTowers) {
            if (t.getxPosition() == x && t.getyPosition() == y) {
                tower = t;
                break;
            }
        }
        final Tower chosenTower = tower;
        screen.setUpgradeLevel(chosenTower.getLevel());
        screen.getUpgradeButton().setOnAction(e -> {
            if (model.getMoney() >= 100) {
                chosenTower.setLevel(chosenTower.getLevel() + 1);
                screen.setUpgradeLevel(chosenTower.getLevel());
                model.setMoney(model.getMoney() - 100);
                screen.setMoneyValue(model.getMoney());
                model.incrementTowersUpgraded();
            }
        });
        screen.getUpgradeMenu().setVisible(true);
    }

    public Timer getTimer() {
        return timer;
    }
}
