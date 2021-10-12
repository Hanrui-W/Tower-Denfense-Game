package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;

public class TowerMeun {
    private final int meunWidth;
    private final int meunHeight;

    public TowerMeun(int meunWidth, int meunHeight) {
        this.meunWidth = meunWidth;
        this.meunHeight = meunHeight;
    }

    // only for developing, should be integrated with GameScreen
    public Scene getScene() {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(hBox, meunWidth, meunHeight);
        return scene;
    }

}
