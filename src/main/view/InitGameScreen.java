package view;

import javafx.animation.PathTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import model.Enemy;
import model.TowerType;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public class InitGameScreen {
    private final int width;
    private final int height;
    private final int squareWidth;
    private final Label moneyLabel;
    private final Label moneyValue;
    private final Label healthLabel;
    private final Label healthValue;
    private final ArrayList<TowerType> listOfTowers;
    private final ArrayList<Button> buttons;
    private final ArrayList<VBox> vBoxes;
    private boolean purchasedTower;
    private final GridPane mapView;
    private final Label messageLabel;
    public final Button startCombat;
    private final ArrayList<Rectangle> enemyPath;
    private ArrayList<PathTransition> enemiesPathAnimation;
    private ArrayList<Node> enemiesAnimationNodes;
    public Path tmp_path;

    public InitGameScreen(int width, int height, ArrayList<TowerType> listOfTowers) {
        this.width = width;
        this.height = height;
        this.squareWidth = width / 20;
        moneyLabel = new Label("Funds: ");
        moneyValue = new Label(null);
        healthLabel = new Label("Monument Health: ");
        healthValue = new Label(null);
        messageLabel = new Label();
        purchasedTower = false;
        enemyPath = new ArrayList<>();
        startCombat = new Button("Start Combat");

        this.listOfTowers = listOfTowers;
        buttons = new ArrayList<>();
        vBoxes = new ArrayList<>();

        mapView = new GridPane();
        enemiesAnimationNodes = new ArrayList<>();
        enemiesPathAnimation = new ArrayList<>();
    }

    public Scene getScene() {
        HBox moneyPrompt = new HBox(moneyLabel, moneyValue);
        HBox healthPrompt = new HBox(healthLabel, healthValue);
        HBox messagePrompt = new HBox(messageLabel);
        HBox combatButton = new HBox(startCombat);

        VBox textualPrompts = new VBox(moneyPrompt, healthPrompt, messagePrompt, combatButton);

        HBox towerMenu = getTowerMenu();
        for (Node enemiesAnimationNode : enemiesAnimationNodes) {
            mapView.add(enemiesAnimationNode, 0, 0);
        }
        VBox bottomSupport = new VBox(mapView, new HBox(textualPrompts, towerMenu));
        return new Scene(bottomSupport, width, height);
    }

    public void setEnemiesAnimation(LinkedList<Enemy> listOfEnemies) {
        for (Enemy enemy : listOfEnemies) {
            Rectangle rect = new Rectangle(
                    enemyPath.get(0).getX(),
                    enemyPath.get(0).getY(),
                    enemyPath.get(0).getWidth(),
                    enemyPath.get(0).getHeight()
            );

            rect.setFill(Color.VIOLET);
            rect.getStyleClass().add("Enemy " + listOfEnemies.indexOf(enemy));

            PathTransition enemyAnimation = new PathTransition();
            enemyAnimation.setDuration(Duration.millis(enemyPath.size() / enemy.getSpeed() * 1000));
            Path path = new Path();
            MoveTo start = new MoveTo();
            start.xProperty().bind(enemyPath.get(0).xProperty());
            start.yProperty().bind(enemyPath.get(0).yProperty());
            path.getElements().add(start);
            for (Node node : enemyPath) {
                LineTo lineTo = new LineTo();
                lineTo.xProperty().bind(node.layoutXProperty());
                lineTo.yProperty().bind(node.layoutYProperty());
                path.getElements().add(lineTo);
            }
            tmp_path = path;
            enemyAnimation.setPath(path);
            enemyAnimation.setCycleCount(1);
            enemyAnimation.setNode(rect);
            enemiesAnimationNodes.add(rect);
            enemiesPathAnimation.add(enemyAnimation);
        }
    }

    public void playEnemiesAnimation() {
        for (PathTransition pathTransition : enemiesPathAnimation) {
            pathTransition.play();
        }
    }

    public void initMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                switch (map[i][j]) {
                        case 0:
                        Rectangle empty = new Rectangle(squareWidth, squareWidth);
                        empty.setFill(Color.WHITE);
                        empty.getStyleClass().add("available");
                        mapView.add(empty, j, i);
                        break;

                        case 1:
                        Rectangle path = new Rectangle(squareWidth, squareWidth);
                        path.setFill(Color.YELLOW);
                        path.getStyleClass().add("unavailable");
                        mapView.add(path, j, i);
                        break;

                        case 2:
                        Rectangle pedestal = new Rectangle(squareWidth, squareWidth);
                        pedestal.setFill(Color.GRAY);
                        pedestal.getStyleClass().add("unavailable");
                        Image monument = new Image(new File("src/main/resources/mario.png")
                                .toURI()
                                .toString());

                        // The monument is now sitting on a square tile instead of being an image view.
                        pedestal.setFill(new ImagePattern(monument));
                        mapView.add(pedestal, j, i);
                        break;

                        case 3:
                            Rectangle padding = new Rectangle(squareWidth, squareWidth);
                            padding.setFill(Color.YELLOW);
                            padding.getStyleClass().add("Padding");
                            mapView.add(padding, j, i);
                    default:
                        break;
                }
            }
        }
        Node[][] gridPaneArray = new Node[map.length][map[0].length];
        for (Node node : mapView.getChildren()) {
            gridPaneArray[GridPane.getRowIndex(node)][GridPane.getColumnIndex(node)] = node;
        }
        int row = 0;
        while (row < map.length && map[row][0] != 1) {
            row++;
        }
        int col = 0;
        while (col < map[0].length) {
            enemyPath.add((Rectangle) gridPaneArray[row][col]);
            if (map[row][col + 1] == 1) {
                while (col < map[0].length && map[row][col + 1] == 1) {
                    enemyPath.add((Rectangle) gridPaneArray[row][col]);
                    col++;
                }
                continue;
            }
            if (row > 0 && map[row - 1][col] == 1) {
                while (row > 0 && (map[row - 1][col] == 1 || map[row - 1][col] == 2)) {
                    enemyPath.add((Rectangle) gridPaneArray[row][col]);
                    row--;
                }
                continue;
            }
            if (row < map.length - 1 && map[row + 1][col] == 1) {
                while (row < map.length - 1 && (map[row + 1][col] == 1 || map[row + 1][col] == 2)) {
                    enemyPath.add((Rectangle) gridPaneArray[row][col]);
                    row++;
                }
                continue;
            }
            break;
        }
    }

    public HBox getTowerMenu() {
        int menuWidth = this.width / 10 * 5;
        int menuHeight = this.height / 6;

        for (TowerType towerType : listOfTowers) {
            ImageView image = new ImageView(towerType.getImage());
            image.setFitHeight(menuHeight * 0.6);
            image.setFitWidth(menuWidth / listOfTowers.size());
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
            this.buttons.add(button);
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

    public ArrayList<PathTransition> getEnemiesPathAnimation() {
        return enemiesPathAnimation;
    }

    public void setEnemiesPathAnimation(ArrayList<PathTransition> enemiesPathAnimation) {
        this.enemiesPathAnimation = enemiesPathAnimation;
    }

    public ArrayList<Node> getEnemiesAnimationNodes() {
        return enemiesAnimationNodes;
    }

    public void setEnemiesAnimationNodes(ArrayList<Node> enemiesAnimationNodes) {
        this.enemiesAnimationNodes = enemiesAnimationNodes;
    }

    public Button getStartCombatStatus() {
        return startCombat;
    }
}