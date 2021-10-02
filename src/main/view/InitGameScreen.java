package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.Model;

public class InitGameScreen {
    private final int width;
    private final int height;

    public InitGameScreen(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Scene getScene(Model model) {
        ImageView map = new ImageView("resources/SimpleMap.png");
        map.setFitHeight(height * 0.9);
        map.setFitWidth(width);

        ImageView monument = new ImageView("resources/mario.png");
        monument.setFitHeight(80);
        monument.setFitWidth(80);

        Label money = new Label("Remaining Funds: " + model.getMoney());
        Label monumentHealth = new Label("Monument Heal: " + model.getMonumentHealth());


        GridPane bottomSupport = new GridPane();

        bottomSupport.getChildren().add(map);
        bottomSupport.add(monument, 0, 0);
        bottomSupport.add(money, 0, 100);
        bottomSupport.add(monumentHealth, 0, 101);

        Scene scene = new Scene(bottomSupport, width, height);
        return scene;
    }
}
