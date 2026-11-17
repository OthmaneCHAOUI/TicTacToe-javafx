package io.github.othmanechaoui.tictactoe.model;

public final class Board {
    public static final int SIZE = 3;

    private final Player[][] cells = new Player[SIZE][SIZE];

    public boolean place(int row, int column, Player player) {
        validatePosition(row, column);
        if (cells[row][column] != null) {
            return false;
        }

        cells[row][column] = player;
        return true;
    }

    public Player get(int row, int column) {
        validatePosition(row, column);
        return cells[row][column];
    }

    public boolean isFull() {
        for (Player[] row : cells) {
            for (Player cell : row) {
                if (cell == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWinningLine(Player player) {
        for (int index = 0; index < SIZE; index++) {
            if (cells[index][0] == player
                    && cells[index][1] == player
                    && cells[index][2] == player) {
                return true;
            }
            if (cells[0][index] == player
                    && cells[1][index] == player
                    && cells[2][index] == player) {
                return true;
            }
        }

        return (cells[0][0] == player && cells[1][1] == player && cells[2][2] == player)
                || (cells[0][2] == player && cells[1][1] == player && cells[2][0] == player);
    }

    public void clear() {
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                cells[row][column] = null;
            }
        }
    }

    private void validatePosition(int row, int column) {
        if (row < 0 || row >= SIZE || column < 0 || column >= SIZE) {
            throw new IllegalArgumentException("Board position is outside the 3x3 board");
        }
    }
}
