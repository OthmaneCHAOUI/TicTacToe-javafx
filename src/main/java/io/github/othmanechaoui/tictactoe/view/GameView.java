package io.github.othmanechaoui.tictactoe.view;

import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public final class GameView {
    @FXML
    private Label statusLabel;

    @FXML
    private Button restartButton;

    @FXML
    private Button cell00;

    @FXML
    private Button cell01;

    @FXML
    private Button cell02;

    @FXML
    private Button cell10;

    @FXML
    private Button cell11;

    @FXML
    private Button cell12;

    @FXML
    private Button cell20;

    @FXML
    private Button cell21;

    @FXML
    private Button cell22;

    @FXML
    private GridPane root;

    private final Button[][] cellButtons = new Button[3][3];

    public static GameView load() {
        FXMLLoader loader = new FXMLLoader(
                Objects.requireNonNull(GameView.class.getResource("/view/game_view.fxml")));
        try {
            loader.load();
        } catch (IOException exception) {
            throw new IllegalStateException("Could not load the game view", exception);
        }

        GameView view = loader.getController();
        view.cellButtons[0][0] = view.cell00;
        view.cellButtons[0][1] = view.cell01;
        view.cellButtons[0][2] = view.cell02;
        view.cellButtons[1][0] = view.cell10;
        view.cellButtons[1][1] = view.cell11;
        view.cellButtons[1][2] = view.cell12;
        view.cellButtons[2][0] = view.cell20;
        view.cellButtons[2][1] = view.cell21;
        view.cellButtons[2][2] = view.cell22;
        return view;
    }

    public Scene createScene() {
        Scene scene = new Scene(root, 400, 500);
        scene.getStylesheets().add(
                Objects.requireNonNull(
                        getClass().getResource("/style/style.css")).toExternalForm());
        return scene;
    }

    public Button getCellButton(int row, int column) {
        return cellButtons[row][column];
    }

    public Button getRestartButton() {
        return restartButton;
    }

    public void setStatus(String status) {
        statusLabel.setText(status);
    }

    public void resetCells() {
        for (Button[] row : cellButtons) {
            for (Button button : row) {
                button.setText("");
                button.setDisable(false);
            }
        }
    }

    public void disableCells() {
        for (Button[] row : cellButtons) {
            for (Button button : row) {
                button.setDisable(true);
            }
        }
    }
}
