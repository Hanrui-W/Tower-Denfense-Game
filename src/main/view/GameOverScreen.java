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

public class GameOverScreen {
    private int width;
    private int height;
    private Button restartButton;
    private Button exitButton;
    private Label gameOverLabel;
    private Label resultLabel;

    public GameOverScreen(int width, int height) {
        this.width = width;
        this.height = height;
        restartButton = new Button("Restart");
        restartButton.setMinSize(70, 30);
        restartButton.setFont(Font.font("Verdana", 40));
        exitButton = new Button("Exit");
        exitButton.setMinSize(70, 30);
        exitButton.setFont(Font.font("Verdana", 40));
        gameOverLabel = new Label("Game Over");
        gameOverLabel.setFont(Font.font("Comic Sans MS", 70));
        gameOverLabel.setStyle("-fx-text-fill: WHITE; -fx-background-color: #87c136");
        resultLabel = new Label();
        resultLabel.setFont(Font.font("Comic Sans MS", 70));
        resultLabel.setStyle("-fx-text-fill: WHITE; -fx-background-color: #87c136");
    }

    public Scene getScene() {
        StackPane root = new StackPane();
        VBox vBox = new VBox(gameOverLabel, resultLabel, restartButton, exitButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setMinSize(40, 70);

        Image image = new Image(new File("src/main/resources/TowerDefenseLogo.jpeg")
                                .toURI()
                                .toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        gameOverLabel.setAlignment(Pos.TOP_CENTER);

        root.getChildren().add(imageView);
        root.getChildren().add(vBox);

        Scene scene = new Scene(root, width, height);
        return scene;
    }

    public Button getRestartButton() {
        restartButton.setAlignment(Pos.BOTTOM_CENTER);
        return restartButton;
    }

    public Button getExitButton() {
        exitButton.setAlignment(Pos.BOTTOM_CENTER);
        return exitButton;
    }

    public void setWin(boolean isWin) {
        resultLabel.setText(isWin ? "You Win" : "You Lose");
    }
}
