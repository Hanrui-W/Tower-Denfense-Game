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


public class TowerMeunScreen {
    private final int meunWidth;
    private final int meunHeight;
    private ArrayList<TowerType> towerTypes;
    private ArrayList<Button> buttons;
    private ArrayList<Label> labels;

    public TowerMeunScreen(int meunWidth, int meunHeight) {
        this.meunWidth = meunWidth;
        this.meunHeight = meunHeight;
        this.setTowerTypes(new ArrayList<>());
    }

    public TowerMeunScreen(int meunWidth, int meunHeight, ArrayList<TowerType> towerTypes) {
        this.meunWidth = meunWidth;
        this.meunHeight = meunHeight;
        this.towerTypes = towerTypes;
    }

    public void setTowerTypes(ArrayList<TowerType> towerTypes) {
        this.towerTypes = towerTypes;
        this.buttons = new ArrayList<>();
        this.labels = new ArrayList<>();
        for (TowerType towerType : towerTypes) {
            ImageView image = new ImageView(new Image(towerType.getImagePath()));
            image.setFitHeight(this.meunHeight*0.6);
            image.setFitWidth((int)(this.meunWidth /towerTypes.size()));
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
        Scene scene = new Scene(hBox, meunWidth, meunHeight);
        return scene;
    }



}
