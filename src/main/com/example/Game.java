package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Game extends Application {

    @Override
    public void start(Stage stage) {
        GridPane root = new GridPane();
        stage.setScene(new Scene(root,400, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
