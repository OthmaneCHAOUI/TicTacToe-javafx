package io.github.othmanechaoui.tictactoe.model;

public final class Game {
    private final Board board = new Board();
    private Player currentPlayer = Player.X;
    private GameStatus status = GameStatus.IN_PROGRESS;

    public boolean play(int row, int column) {
        if (status.isFinished() || !board.place(row, column, currentPlayer)) {
            return false;
        }

        if (board.hasWinningLine(currentPlayer)) {
            status = currentPlayer == Player.X ? GameStatus.X_WON : GameStatus.O_WON;
        } else if (board.isFull()) {
            status = GameStatus.DRAW;
        } else {
            currentPlayer = currentPlayer.opposite();
        }
        return true;
    }

    public Player get(int row, int column) {
        return board.get(row, column);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void restart() {
        board.clear();
        currentPlayer = Player.X;
        status = GameStatus.IN_PROGRESS;
    }
}
