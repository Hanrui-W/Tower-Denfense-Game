package view;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import model.GameDifficultyLevel;

public class InitConfigScreen {
    private int width;
    private int height;
    private Button nextButton;
    private Label titleLabel;
    private Label nameLabel;
    private Label difficultyLabel;
    private TextField nameText;
    private ChoiceBox<GameDifficultyLevel> difficultyChoiceBox;

    public InitConfigScreen() { }
    public InitConfigScreen(int width, int height) {
        this.width = width;
        this.height = height;
        nextButton = new Button("Next");
        titleLabel = new Label("Init Config Screen");
        nameLabel = new Label("Username: ");
        difficultyLabel = new Label("Difficulty: ");
        nameText = new TextField();

        difficultyChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList(
                GameDifficultyLevel.EASY,
                GameDifficultyLevel.MEDIUM,
                GameDifficultyLevel.HARD,
                GameDifficultyLevel.HELL)
        );
        difficultyChoiceBox.setConverter(new StringConverter<GameDifficultyLevel>() {
            @Override
            public String toString(GameDifficultyLevel level) {
                /**
                switch (level) {
                    case EASY:
                        return "Easy";
                    case MEDIUM:
                        return "Medium";
                    case HARD:
                        return "Hard";
                    default:
                        return "Hell";
                }
                 */
                return "hell";
            }

            @Override
            public GameDifficultyLevel fromString(String string) {
                return null;
            }

        });
    }

    public Scene getScene() {
        HBox nameHBox = new HBox(nameLabel, nameText);
        HBox difficultyHBox = new HBox(difficultyLabel, difficultyChoiceBox);
        VBox root = new VBox(titleLabel, nameHBox, difficultyHBox, nextButton);
        Scene scene = new Scene(root, width, height);

        return scene;
    }

    public Button getNextButton() {
        return nextButton;
    }

    public TextField getUsername() {return nameText; }

    public ChoiceBox<GameDifficultyLevel> getDifficultyChoiceBox() {return difficultyChoiceBox; }

}

