package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.*;
import model.Enemy;
import model.TowerType;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InitGameScreen {
    private final int width;
    private final int height;
    private final int squareSide;
    private final Label moneyLabel;
    private final Label moneyValue;
    private final Label healthLabel;
    private final Label healthValue;
    private final ArrayList<TowerType> listOfTowers;
    private final ArrayList<Button> buttons;
    private final ArrayList<VBox> vBoxes;
    private boolean purchasedTower;
    private Pane bottomSupport;
    private final GridPane mapView;
    private Rectangle[][] gridPaneArray;
    private Rectangle monument;
    private Label currentLevel;
    private Button upgradeButton;
    private VBox upgradeMenu;
    private final Label messageLabel;
    private final Button startCombat;
    private final ArrayList<Rectangle> enemyPath;
    private ArrayList<Line> attackLine;
    private ArrayList<Label> enemyHealthLabels;

    public InitGameScreen(int width, int height, ArrayList<TowerType> listOfTowers) {
        this.width = width;
        this.height = height;
        this.squareSide = width / 20;
        this.moneyLabel = new Label("Funds: ");
        moneyValue = new Label(null);
        healthLabel = new Label("Monument Health: ");
        healthValue = new Label(null);
        messageLabel = new Label();
        purchasedTower = false;
        enemyPath = new ArrayList<>();
        attackLine = new ArrayList<>();
        enemyHealthLabels = new ArrayList<>();
        startCombat = new Button("Start Combat");

        this.listOfTowers = listOfTowers;
        buttons = new ArrayList<>();
        vBoxes = new ArrayList<>();

        mapView = new GridPane();
    }

    public Scene getScene() {
        HBox moneyPrompt = new HBox(moneyLabel, moneyValue);
        HBox healthPrompt = new HBox(healthLabel, healthValue);
        HBox messagePrompt = new HBox(messageLabel);
        HBox combatButton = new HBox(startCombat);

        VBox textualPrompts = new VBox(moneyPrompt, healthPrompt, combatButton, messagePrompt);

        HBox towerMenu = getTowerMenu();

        currentLevel = new Label();
        upgradeButton = new Button("Upgrade");
        upgradeMenu = new VBox(currentLevel, new Label("Cost: 100"), upgradeButton);
        upgradeMenu.setVisible(false);
        VBox vbox = new VBox(mapView, new HBox(textualPrompts, towerMenu, upgradeMenu));
        bottomSupport = new Pane(vbox);
        return new Scene(bottomSupport, width, height);
    }

    public void updateEnemiesPosition(LinkedList<Enemy> listOfEnemies) {
        for (Label l : enemyHealthLabels) {
            bottomSupport.getChildren().remove(l);
        }
        enemyHealthLabels.clear();
        for (Rectangle rect : enemyPath) {
            rect.getStyleClass().remove("enemy");
            rect.setFill(Color.YELLOW);
        }
        for (Enemy enemy : listOfEnemies) {
            Rectangle rect = gridPaneArray[enemy.getxPosition()][enemy.getyPosition()];
            Label label = new Label(enemy.getHealth() + "");
            label.layoutXProperty().bind(rect.layoutXProperty());
            label.layoutYProperty().bind(rect.layoutYProperty());
            label.setTextFill(Color.WHITE);
            enemyHealthLabels.add(label);
            rect.getStyleClass().add("enemy");
            rect.setFill(enemy.getColor());
        }
        for (Label l : enemyHealthLabels) {
            bottomSupport.getChildren().add(l);
        }
    }

    public void drawAttack(List<List<Integer>> list) {
        for (Line l : attackLine) {
            bottomSupport.getChildren().remove(l);
        }
        attackLine.clear();
        for (List<Integer> selist : list) {
            Rectangle towerRect = gridPaneArray[selist.get(0)][selist.get(1)];
            Rectangle enemyRect = gridPaneArray[selist.get(2)][selist.get(3)];
            attackLine.add(new Line(towerRect.getLayoutX() + squareSide / 2,
                    towerRect.getLayoutY() + squareSide / 2,
                    enemyRect.getLayoutX() + squareSide / 2,
                    enemyRect.getLayoutY() + squareSide / 2));
        }
        for (Line l : attackLine) {
            bottomSupport.getChildren().add(l);
        }
    }

    public void initMap(int[][] map) {
        gridPaneArray = new Rectangle[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                Rectangle rect = new Rectangle(squareSide, squareSide);
                switch (map[i][j]) {
                case 0:
                    rect.setFill(Color.WHITE);
                    rect.getStyleClass().add("available");
                    break;

                case 1:
                    rect.setFill(Color.YELLOW);
                    rect.getStyleClass().add("unavailable");
                    break;

                case 2:
                    rect.setFill(Color.GRAY);
                    rect.getStyleClass().add("unavailable");
                    Image monumentImage = new Image(new File("src/main/resources/mario.png")
                            .toURI()
                            .toString());
                    // The monument is now sitting on a square tile instead of being an image view.
                    rect.setFill(new ImagePattern(monumentImage));
                    break;
                default:
                    break;
                }
                mapView.add(rect, j, i);
                gridPaneArray[i][j] = rect;
            }
        }
        int row = 0;
        while (row < map.length && map[row][0] != 1) {
            row++;
        }
        int col = 0;
        while (col < map[0].length) {
            if (map[row][col + 1] == 1) {
                while (col < map[0].length && map[row][col + 1] == 1) {
                    enemyPath.add(gridPaneArray[row][col]);
                    col++;
                }
                continue;
            }
            if (row > 0 && map[row - 1][col] == 1) {
                while (row > 0 && (map[row - 1][col] == 1)) {
                    enemyPath.add(gridPaneArray[row][col]);
                    row--;
                }
                continue;
            }
            if (row < map.length - 1 && map[row + 1][col] == 1) {
                while (row < map.length - 1 && (map[row + 1][col] == 1)) {
                    enemyPath.add(gridPaneArray[row][col]);
                    row++;
                }
                continue;
            }
            break;
        }
        enemyPath.add(gridPaneArray[row][col]);
    }

    public HBox getTowerMenu() {
        int menuWidth = this.width / 10 * 5;
        int menuHeight = this.height / 6;
        int index = 0;

        for (TowerType towerType : listOfTowers) {
            ImageView image = new ImageView(towerType.getImage());
            image.setFitHeight(menuHeight * 0.6);
            image.setFitWidth(menuWidth / (double) listOfTowers.size());
            Label imageLabel = new Label(towerType.getName(), image);
            imageLabel.setStyle("-fx-border-color: green; -fx-border-width: 2");
            imageLabel.setContentDisplay(ContentDisplay.TOP);
            imageLabel.setTextFill(Color.BLACK);
            imageLabel.setAlignment(Pos.CENTER);

            Label cost = new Label("Cost: " + towerType.getCost());
            Label attack = new Label("Attack: " + towerType.getAttackDamage());
            Label range = new Label("Range: " + towerType.getRange());

            VBox vBox = new VBox();
            vBox.getChildren().add(imageLabel);
            vBox.getChildren().add(cost);
            vBox.getChildren().add(attack);
            vBox.getChildren().add(range);

            String cssLayout = "-fx-border-color: green;\n"
                    + "-fx-border-insets: 5;\n"
                    + "-fx-border-width: 3;\n";

            vBox.setStyle(cssLayout);

            this.vBoxes.add(vBox);

            Button button = new Button("Purchase");
            button.getStyleClass().add("purchase" + index);

            this.buttons.add(button);
            index++;
        }
        HBox hBox = new HBox();
        for (int i = 0; i < listOfTowers.size(); i++) {
            VBox vbox = new VBox();
            vbox.getChildren().add(this.vBoxes.get(i));
            vbox.getChildren().add(this.buttons.get(i));
            vbox.setAlignment(Pos.CENTER);
            hBox.getChildren().add(vbox);
        }
        return hBox;
    }

    public void setUpgradeLevel(int level) {
        currentLevel.setText("Level: " + level);
    }

    public Button getUpgradeButton() {
        return upgradeButton;
    }

    public VBox getUpgradeMenu() {
        return upgradeMenu;
    }

    public ArrayList<Button> getButtons() {
        return buttons;
    }

    public void setPurchasedTower(boolean purchased) {
        purchasedTower = purchased;
    }

    public boolean getPurchased() {
        return purchasedTower;
    }

    public GridPane getMap() {
        return mapView;
    }

    public void setMessageLabel(String message) {
        messageLabel.setText(message);
    }

    public void setMoneyValue(int money) {
        moneyValue.setText(String.valueOf(money));
    }

    public void setHealthValue(int health) {
        healthValue.setText(String.valueOf(health));
    }

    public Button getStartCombatStatus() {
        return startCombat;
    }

    public ArrayList<Rectangle> getEnemyPath() {
        return enemyPath;
    }

    public Rectangle[][] getGridPaneArray() {
        return gridPaneArray;
    }
}