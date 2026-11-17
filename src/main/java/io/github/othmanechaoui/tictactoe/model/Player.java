package io.github.othmanechaoui.tictactoe.model;

public enum Player {
    X,
    O;

    public Player opposite() {
        return this == X ? O : X;
    }
}
