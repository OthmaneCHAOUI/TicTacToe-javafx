package io.github.othmanechaoui.tictactoe.controller;

import io.github.othmanechaoui.tictactoe.model.Game;
import io.github.othmanechaoui.tictactoe.model.GameStatus;
import io.github.othmanechaoui.tictactoe.model.Player;
import io.github.othmanechaoui.tictactoe.view.GameView;
import javafx.scene.Scene;

public final class GameController {
    private final Game game = new Game();
    private final GameView view = GameView.load();

    public GameController() {
        configureActions();
        updateStatus();
    }

    public Scene createScene() {
        return view.createScene();
    }

    private void configureActions() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                int selectedRow = row;
                int selectedColumn = column;
                view.getCellButton(row, column).setOnAction(
                        event -> play(selectedRow, selectedColumn));
            }
        }
        view.getRestartButton().setOnAction(event -> restart());
    }

    private void play(int row, int column) {
        Player player = game.getCurrentPlayer();
        if (!game.play(row, column)) {
            return;
        }

        view.getCellButton(row, column).setText(player.name());
        updateStatus();
        if (game.getStatus().isFinished()) {
            view.disableCells();
        }
    }

    private void restart() {
        game.restart();
        view.resetCells();
        updateStatus();
    }

    private void updateStatus() {
        GameStatus status = game.getStatus();
        switch (status) {
            case IN_PROGRESS -> view.setStatus("Player " + game.getCurrentPlayer());
            case X_WON -> view.setStatus("Player X WON !");
            case O_WON -> view.setStatus("Player O WON !");
            case DRAW -> view.setStatus("DRAW !");
        }
    }
}
