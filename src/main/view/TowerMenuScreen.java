package view;


import javafx.scene.layout.VBox;
import model.TowerType;

import java.util.ArrayList;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


public class TowerMenuScreen {
    private final int menuWidth;
    private final int menuHeight;
    private ArrayList<TowerType> towerTypes;
    private ArrayList<Button> buttons;
    private ArrayList<Label> labels;

    public TowerMenuScreen(int menuWidth, int menuHeight) {
        this.menuWidth = menuWidth;
        this.menuHeight = menuHeight;
        this.setTowerTypes(new ArrayList<>());
    }

    public TowerMenuScreen(int meunWidth, int meunHeight, ArrayList<TowerType> towerTypes) {
        this.menuWidth = meunWidth;
        this.menuHeight = meunHeight;
        this.towerTypes = towerTypes;
    }

    public void setTowerTypes(ArrayList<TowerType> towerTypes) {
        this.towerTypes = towerTypes;
        this.buttons = new ArrayList<>();
        this.labels = new ArrayList<>();
        for (TowerType towerType : towerTypes) {
            ImageView image = new ImageView(new Image(towerType.getImagePath()));
            image.setFitHeight(this.menuHeight *0.6);
            image.setFitWidth((int)(this.menuWidth /towerTypes.size()));
            Label nameLabel = new Label(towerType.getName() + "\nCost: " + towerType.getCost(), image);
            nameLabel.setStyle("-fx-border-color: green; -fx-border-width: 2");
            nameLabel.setContentDisplay(ContentDisplay.TOP);
            nameLabel.setTextFill(Color.BLACK);
            nameLabel.setAlignment(Pos.CENTER);
            this.labels.add(nameLabel);

            Button button = new Button("Purchase");
            this.buttons.add(button);
        }
    }

    public HBox getComponent() {
        HBox hBox = new HBox();
        for (int i = 0; i < towerTypes.size(); i++) {
            VBox vbox = new VBox();
            vbox.getChildren().add(this.labels.get(i));
            vbox.getChildren().add(this.buttons.get(i));
            vbox.setAlignment(Pos.CENTER);
            hBox.getChildren().add(vbox);
        }
        return hBox;
    }

    // only for developing, should be integrated with GameScreen
    public Scene getScene() {
        HBox hBox = new HBox();
        for (int i = 0; i < towerTypes.size(); i++) {
            VBox vbox = new VBox();
            vbox.getChildren().add(this.labels.get(i));
            vbox.getChildren().add(this.buttons.get(i));
            vbox.setAlignment(Pos.CENTER);
            hBox.getChildren().add(vbox);
        }
        Scene scene = new Scene(hBox, menuWidth, menuHeight);
        return scene;
    }

    public ArrayList<TowerType> getTowerTypes() {
        return towerTypes;
    }

    public ArrayList<Button> getButtons() {
        return buttons;
    }
}
