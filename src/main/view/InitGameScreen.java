package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.TowerType;

import java.io.File;
import java.util.ArrayList;

public class InitGameScreen {
    private final int width;
    private final int height;
    private final int SQUARE_WIDTH;
    private final Label moneyLabel;
    private final Label moneyValue;
    private final Label healthLabel;
    private final Label healthValue;
    private final ArrayList<TowerType> listOfTowers;
    private final ArrayList<Button> buttons;
    private final ArrayList<Label> labels;
    private boolean purchasedTower;
    private final GridPane mapView;
    private final ArrayList<Node> availableSites;
    private final Label messageLabel;

    public InitGameScreen(int width, int height, ArrayList<TowerType> listOfTowers) {
        this.width = width;
        this.height = height;
        this.SQUARE_WIDTH = width / 20;
        moneyLabel = new Label("Funds: ");
        moneyValue = new Label("100");
        healthLabel = new Label("Monument Health: ");
        healthValue = new Label("100");
        messageLabel = new Label();
        purchasedTower = false;

        this.listOfTowers = listOfTowers;
        buttons = new ArrayList<>();
        labels = new ArrayList<>();

        mapView = new GridPane();
        availableSites = new ArrayList<>();
    }

    public Scene getScene() {
        HBox moneyPrompt = new HBox(moneyLabel, moneyValue);
        HBox healthPrompt = new HBox(healthLabel, healthValue);
        HBox messagePrompt = new HBox(messageLabel);

        VBox textualPrompts = new VBox(moneyPrompt, healthPrompt, messagePrompt);

        // Create a tower menu down below
        HBox towerMenu = getTowerMenu();
        VBox bottomSupport = new VBox(mapView, new HBox(textualPrompts, towerMenu));
        return new Scene(bottomSupport, width, height);
    }

    public void initMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                switch (map[i][j]) {
                    case 0:
                        Rectangle empty = new Rectangle(SQUARE_WIDTH, SQUARE_WIDTH);
                        empty.setFill(Color.WHITE);
                        mapView.add(empty, j, i);
                        break;
                    case 1:
                        Rectangle path = new Rectangle(SQUARE_WIDTH, SQUARE_WIDTH);
                        path.setFill(Color.YELLOW);
                        mapView.add(path, j, i);
                        break;
                    case 2:
                        Rectangle pedestal = new Rectangle(SQUARE_WIDTH, SQUARE_WIDTH);
                        pedestal.setFill(Color.GRAY);
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

    public void setMoneyValue(int money) {
        moneyValue.setText(String.valueOf(money));
    }

    public void setHealthValue(int health) {
        healthValue.setText(String.valueOf(health));
    }


    public HBox getTowerMenu() {
        int menuWidth = this.width / 10 * 5;
        int menuHeight = this.height / 6;

        for (TowerType towerType : listOfTowers) {
            ImageView image = new ImageView(new Image(towerType.getImagePath()));
            image.setFitHeight(menuHeight * 0.6);
            image.setFitWidth(menuWidth / listOfTowers.size());
            Label nameLabel = new Label(towerType.getName() + "\n"
                    + "Cost: " + towerType.getCost(), image);
            nameLabel.setStyle("-fx-border-color: green; -fx-border-width: 2");
            nameLabel.setContentDisplay(ContentDisplay.TOP);
            nameLabel.setTextFill(Color.BLACK);
            nameLabel.setAlignment(Pos.CENTER);
            this.labels.add(nameLabel);

            Button button = new Button("Purchase");
            this.buttons.add(button);
        }
        HBox hBox = new HBox();
        for (int i = 0; i < listOfTowers.size(); i++) {
            VBox vbox = new VBox();
            vbox.getChildren().add(this.labels.get(i));
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
}
