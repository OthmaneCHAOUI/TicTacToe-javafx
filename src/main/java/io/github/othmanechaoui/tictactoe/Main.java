package io.github.othmanechaoui.tictactoe;

import io.github.othmanechaoui.tictactoe.controller.GameController;
import javafx.application.Application;
import javafx.stage.Stage;

public final class Main extends Application {
    @Override
    public void start(Stage stage) {
        GameController controller = new GameController();
        stage.setTitle("Tic Tac Toe Game");
        stage.setScene(controller.createScene());
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("Launching Tic Tac Toe Game...");
        launch(args);
    }
}
