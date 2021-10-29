package view;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.*;
import model.Enemy;
import model.GameDifficultyLevel;
import model.GameObject;
import model.TowerType;
import javafx.scene.shape.Polyline;
import javafx.animation.*;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;

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
    private final GameDifficultyLevel level;
    private ArrayList<Node> enemyPath;
    PathTransition pathTransition;

    public InitGameScreen(int width, int height, ArrayList<TowerType> listOfTowers, GameDifficultyLevel level) {
        this.width = width;
        this.height = height;
        this.squareWidth = width / 20;
        this.level = level;
        moneyLabel = new Label("Funds: ");
        moneyValue = new Label("100");
        healthLabel = new Label("Monument Health: ");
        healthValue = new Label("100");
        messageLabel = new Label();
        purchasedTower = false;
        enemyPath = new ArrayList<>();

        this.listOfTowers = listOfTowers;
        buttons = new ArrayList<>();
        vBoxes = new ArrayList<>();

        mapView = new GridPane();
    }

    public Scene getScene() {
        HBox moneyPrompt = new HBox(moneyLabel, moneyValue);
        HBox healthPrompt = new HBox(healthLabel, healthValue);
        HBox messagePrompt = new HBox(messageLabel);

        VBox textualPrompts = new VBox(moneyPrompt, healthPrompt, messagePrompt);

        // Create a tower menu down below
        HBox towerMenu = getTowerMenu();
        mapView.add(EnemyMove(), 2, 1);
        VBox bottomSupport = new VBox(mapView, new HBox(textualPrompts, towerMenu));
        return new Scene(bottomSupport, width, height);
    }

    public Node EnemyMove() {
        Rectangle rect = new Rectangle(50, 50, 50, 50);
        rect.setFill(Color.VIOLET);
        pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(10000));
        pathTransition.setNode(rect);
        Path path = new Path();
        MoveTo start = new MoveTo();
        start.xProperty().bind(enemyPath.get(0).layoutXProperty());
        start.yProperty().bind(enemyPath.get(0).layoutYProperty());
        path.getElements().add(start);
        for (Node node : enemyPath) {
            LineTo lineTo = new LineTo();
            lineTo.xProperty().bind(node.layoutXProperty());
            lineTo.yProperty().bind(node.layoutYProperty());
            path.getElements().add(lineTo);
        }
//        path.getElements().add (new MoveTo (0f, 80f));
//        path.getElements().add (new LineTo (650f, 80f));
        pathTransition.setPath(path);
        pathTransition.setCycleCount(1);
        return rect;
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
                    enemyPath.add(path);
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
                    default:
                        break;
                }
            }
        }
    }

    public PathTransition getPathTransition() {
        return pathTransition;
    }

    public void setPathTransition(PathTransition pathTransition) {
        this.pathTransition = pathTransition;
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
}