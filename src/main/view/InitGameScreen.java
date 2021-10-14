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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.TowerType;

import java.io.File;
import java.util.ArrayList;

public class InitGameScreen {
    private final int width;
    private final int height;
    private Label moneyLabel;
    private Label moneyValue;
    private Label healthLabel;
    private Label healthValue;
    private ArrayList<TowerType> listOfTowers;
    private ArrayList<Button> buttons;
    private ArrayList<Label> labels;
    private boolean placedTower;
    private boolean purchasedTower;

    public InitGameScreen(int width, int height, ArrayList<TowerType> listOfTowers) {
        this.width = width;
        this.height = height;
        moneyLabel = new Label("Funds: ");
        moneyValue = new Label("100");
        healthLabel = new Label("Monument Health: ");
        healthValue = new Label("100");
        placedTower = false;
        purchasedTower = false;

        this.listOfTowers = listOfTowers;
        buttons = new ArrayList<>();
        labels = new ArrayList<>();
    }

    public Scene getScene() {
        ImageView map = new ImageView(new File("src/main/resources/SimpleMap.png").toURI().toString());
        map.setFitHeight(height * 0.8);
        map.setFitWidth(width);

        ImageView monument = new ImageView(new File("src/main/resources/mario.png").toURI().toString());
        monument.setFitHeight(80);
        monument.setFitWidth(80);

        GridPane bottomSupport = new GridPane();

        bottomSupport.getChildren().add(map);
        bottomSupport.add(monument, 0, 0);

        HBox bottomPanel = new HBox();

        HBox moneyPrompt = new HBox(moneyLabel, moneyValue);
        HBox healthPrompt = new HBox(healthLabel, healthValue);

        VBox textualPrompts = new VBox();
        textualPrompts.getChildren().add(moneyPrompt);
        textualPrompts.getChildren().add(healthPrompt);

        bottomPanel.getChildren().add(textualPrompts);

        // Create a tower menu down below
        HBox towerMenu = getTowerMenu();
        bottomPanel.getChildren().add(towerMenu);

        bottomSupport.add(bottomPanel, 0, 1);
        Scene scene = new Scene(bottomSupport, width, height);
        return scene;
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

    public void setPlacedTower(boolean set) {
        placedTower = set;
    }

    public boolean getPlaced() {
        return placedTower;
    }

    public ArrayList<TowerType> getListOfTowers() {
        return listOfTowers;
    }
}
