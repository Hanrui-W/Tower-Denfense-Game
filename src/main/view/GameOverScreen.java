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
    private final int width;
    private final int height;
    private final Button restartButton;
    private final Button exitButton;
    private final Label gameOverLabel;
    private final Label towersPlacedText;
    private final Label enemiesKilledText;
    private final Label towersUpgradedText;
    private int enemiesKilled;
    private int towersPlaced;
    private int towersUpgraded;

    public GameOverScreen(int width, int height) {
        this.width = width;
        this.height = height;
        restartButton = new Button("Restart");
        restartButton.setMinSize(70, 30);
        restartButton.setFont(Font.font("Verdana", 40));

        exitButton = new Button("Exit");
        exitButton.setMinSize(70, 30);
        exitButton.setFont(Font.font("Verdana", 40));

        gameOverLabel = new Label("You lost. Try again?!");
        gameOverLabel.setFont(Font.font("Comic Sans MS", 70));
        gameOverLabel.setStyle("-fx-text-fill: WHITE; -fx-background-color: #87c136");

        towersPlacedText = new Label("Total amount of towers placed: " + towersPlaced);
        towersPlacedText.setFont(Font.font("Comic San MS", 25));
        towersPlacedText.setStyle("-fx-text-fill: WHITE; -fx-background-color: #87c136");


        towersUpgradedText = new Label("Total amount of towers upgraded: " + towersUpgraded);
        towersUpgradedText.setFont(Font.font("Comic San MS", 25));
        towersUpgradedText.setStyle("-fx-text-fill: WHITE; -fx-background-color: #87c136");

        enemiesKilledText = new Label("Total amount of enemies killed: " + enemiesKilled);
        enemiesKilledText.setFont(Font.font("Comic San MS", 25));
        enemiesKilledText.setStyle("-fx-text-fill: WHITE; -fx-background-color: #87c136");
    }

    public Scene getScene() {
        StackPane root = new StackPane();
        VBox vBox = new VBox(gameOverLabel, restartButton, exitButton,
                enemiesKilledText, towersPlacedText, towersUpgradedText);
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

    public void setEnemiesKilled(int enemiesKilled) {
        this.enemiesKilled = enemiesKilled;
    }

    public void setTowersPlaced(int towersPlaced) {
        this.towersPlaced = towersPlaced;
    }

    public void setTowersUpgraded(int towersUpgraded) {
        this.towersUpgraded = towersUpgraded;
    }
}