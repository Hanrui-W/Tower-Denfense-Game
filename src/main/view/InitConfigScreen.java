package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class InitConfigScreen {
    private int width;
    private int height;
    private Button nextButton;
    private Label label;

    public InitConfigScreen() { }
    public InitConfigScreen(int width, int height) {
        this.width = width;
        this.height = height;
        nextButton = new Button("Next");
        label = new Label("Init Config Screen");
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
