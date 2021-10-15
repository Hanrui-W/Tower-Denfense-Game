package view;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import model.GameDifficultyLevel;

public class InitConfigScreen {
    private final int width;
    private final int height;
    private final Button nextButton;
    private final Label titleLabel;
    private final Label nameLabel;
    private final Label difficultyLabel;
    private final TextField nameText;
    private final ChoiceBox<GameDifficultyLevel> difficultyChoiceBox;

    public InitConfigScreen(int width, int height) {
        this.width = width;
        this.height = height;
        nextButton = new Button("Next");
        titleLabel = new Label("Init Config Screen");
        nameLabel = new Label("Username: ");
        difficultyLabel = new Label("Difficulty: ");
        nameText = new TextField();
        difficultyChoiceBox = initChoiceBox();
    }

    private ChoiceBox initChoiceBox() {
        ChoiceBox<GameDifficultyLevel> box = new ChoiceBox<>(FXCollections.observableArrayList(
                GameDifficultyLevel.EASY,
                GameDifficultyLevel.MEDIUM,
                GameDifficultyLevel.HARD,
                GameDifficultyLevel.HELL)
        );
        box.setConverter(new StringConverter<GameDifficultyLevel>() {
            @Override
            public String toString(GameDifficultyLevel level) {
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
            }

            @Override
            public GameDifficultyLevel fromString(String string) {
                return null;
            }

        });
        box.setValue(GameDifficultyLevel.EASY);
        return box;
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

    public TextField getUsername() {
        return nameText;
    }

    public ChoiceBox<GameDifficultyLevel> getDifficultyChoiceBox() {
        return difficultyChoiceBox;
    }

}

