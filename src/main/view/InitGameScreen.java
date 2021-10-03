package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class InitGameScreen {
    private final int width;
    private final int height;
    private Label healthLabel;
    private Label moneyLabel;

    public InitGameScreen(int width, int height) {
        this.width = width;
        this.height = height;
        moneyLabel = new Label();
        healthLabel = new Label();
    }

    public Scene getScene() {
        ImageView map = new ImageView("resources/SimpleMap.png");
        map.setFitHeight(height * 0.9);
        map.setFitWidth(width);

        ImageView monument = new ImageView("resources/mario.png");
        monument.setFitHeight(80);
        monument.setFitWidth(80);

        GridPane bottomSupport = new GridPane();

        bottomSupport.getChildren().add(map);
        bottomSupport.add(monument, 0, 0);
        bottomSupport.add(moneyLabel, 0, 100);
        bottomSupport.add(healthLabel, 0, 101);

        Scene scene = new Scene(bottomSupport, width, height);
        return scene;
    }

    public void setHealthLabel(int health) {
        healthLabel.setText("Monument Health: " + health);
    }

    public void getMoneyLabel(int money) {
        moneyLabel.setText("Funds: " + money);
    }
}
