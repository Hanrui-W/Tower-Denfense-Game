package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.File;

public class InitGameScreen {
    private final int width;
    private final int height;
    private Label moneyLabel;
    private Label moneyValue;
    private Label healthLabel;
    private Label healthValue;

    public InitGameScreen(int width, int height) {
        this.width = width;
        this.height = height;
        moneyLabel = new Label("Funds: ");
        moneyValue = new Label("100");
        healthLabel = new Label("Monument Health: ");
        healthValue = new Label("100");
    }

    public Scene getScene() {
        ImageView map = new ImageView(new File("src/main/resources/SimpleMap.png").toURI().toString());
        map.setFitHeight(height * 0.9);
        map.setFitWidth(width);

        ImageView monument = new ImageView(new File("src/main/resources/mario.png").toURI().toString());
        monument.setFitHeight(80);
        monument.setFitWidth(80);

        GridPane bottomSupport = new GridPane();

        bottomSupport.getChildren().add(map);
        bottomSupport.add(monument, 0, 0);
        bottomSupport.add(new HBox(moneyLabel, moneyValue), 0, 100);
        bottomSupport.add(new HBox(healthLabel, healthValue), 0, 101);

        Scene scene = new Scene(bottomSupport, width, height);
        return scene;
    }

    public void setMoneyValue(int money) {
        moneyValue.setText(String.valueOf(money));
    }

    public void setHealthValue(int health) {
        healthValue.setText(String.valueOf(health));
    }

}
