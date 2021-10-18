package view;

import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.File;

public class WelcomeScreen {
    private int width;
    private int height;
    private Button startButton;
    private Label label;

    public WelcomeScreen(int width, int height) {
        this.width = width;
        this.height = height;
        startButton = new Button("Start");
        startButton.setMinSize(70, 30);
        startButton.setFont(Font.font("Verdana", 40));
        label = new Label("Welcome Screen");
        label.setFont(Font.font("Comic Sans MS", 70));
        label.setStyle("-fx-text-fill: WHITE; -fx-background-color: #87c136");
    }

    public Scene getScene() {
        StackPane root = new StackPane();
        VBox vBox = new VBox(label, startButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setMinSize(40, 70);

        Image image = new Image(new File("src/main/resources/TowerDefenseLogo.jpeg")
                                .toURI()
                                .toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        label.setAlignment(Pos.TOP_CENTER);

        root.getChildren().add(imageView);
        root.getChildren().add(vBox);

        Scene scene = new Scene(root, width, height);
        return scene;
    }

    public Button getStartButton() {
        startButton.setAlignment(Pos.BOTTOM_CENTER);
        return startButton;
    }
}
