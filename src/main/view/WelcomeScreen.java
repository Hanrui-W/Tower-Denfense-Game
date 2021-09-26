package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class WelcomeScreen {
    private int width;
    private int height;
    private Button startButton;
    private Label label;

    public WelcomeScreen() { }
    public WelcomeScreen(int width, int height) {
        this.width = width;
        this.height = height;
        startButton = new Button("Start");
        label = new Label("Welcome Screen");
    }

    public Scene getScene() {
        VBox root = new VBox(label, startButton);
        Scene scene = new Scene(root, width, height);
        return scene;
    }

    public Button getStartButton() {
        return startButton;
    }
}
