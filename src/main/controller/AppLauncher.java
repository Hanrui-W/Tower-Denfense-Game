package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;


public class AppLauncher extends Application {
    private static Stage mainWindow;
    private Model model;
    private static IController controller;
    private static final int WIDTH = 960;
    private static final int HEIGHT = 720;

    public void start(Stage stage) {
        mainWindow = stage;
        mainWindow.setTitle("Game");
        model = Model.getInstance();
        controller = new StartController(WIDTH, HEIGHT);
        goToWelcomeScreen();
    }

    public static Stage getMainWindow() {
        return mainWindow;
    }

    public static void goToWelcomeScreen() {
        controller = new StartController(WIDTH, HEIGHT);
    }

    public static void goToInitConfigScreen() {
        controller = new ConfigController(WIDTH, HEIGHT);
    }

    public static void goToInitGameScreen() {
        controller = new GameController(WIDTH, HEIGHT);
    }

    public static void goToGameOverScreen() {
        controller = new GameOverController(WIDTH, HEIGHT);
    }

    public static void goToWinScreen() {
        controller = new WinGameController(WIDTH, HEIGHT);
    }

    public IController getController() {
        return controller;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
