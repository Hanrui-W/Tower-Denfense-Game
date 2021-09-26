package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class InitGameScreen {
    private int width;
    private int height;
    private Button nextButton;
    private Label label;

    public InitGameScreen() {}
    public InitGameScreen(int width, int height) {
        this.width = width;
        this.height = height;
        nextButton = new Button("Next");
        label = new Label("Init Game Screen");
    }

    public Scene getScene() {
        VBox root = new VBox(label, nextButton);
        Scene scene = new Scene(root, width, height);
        return scene;
    }

    public Button getNextButton() {
        return nextButton;
    }
}
