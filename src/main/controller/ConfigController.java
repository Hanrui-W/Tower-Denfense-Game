package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.GameDifficultyLevel;
import model.Model;
import view.InitConfigScreen;

public class ConfigController implements IController {
    public ConfigController(int width, int height) {
        initScreen(width, height);
    }
    @Override
    public void initScreen(int width, int height) {
        InitConfigScreen screen = new InitConfigScreen(width, height);
        TextField nameText = screen.getUsername();
        nameText.setOnAction(e -> {
            nameText.setText(nameText.getText());
        });
        ChoiceBox<GameDifficultyLevel> box = screen.getDifficultyChoiceBox();
        box.setOnAction(e -> {
            box.setValue(box.getValue());
        });
        Button nextButton = screen.getNextButton();
        nextButton.setOnAction(e -> {
            Model.init();
            if (Model.getInstance().initGame(nameText.getText().trim(), box.getValue())) {
                AppLauncher.goToInitGameScreen();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Empty Name");
                alert.setContentText("Please enter a valid name.");
                alert.showAndWait();
            }
        });

        AppLauncher.getMainWindow().setScene(screen.getScene());
        AppLauncher.getMainWindow().show();
    }
}
