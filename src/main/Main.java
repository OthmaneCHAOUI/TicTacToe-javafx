package main;

import javafx.application.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.text.*;

public class Main exten Application{
    private Label display;
    private Button[][] buttons = new Button[3][3];
    private String currentPlayer = "X";
    private String[][] board = new String[3][3]; 
    ds
    @Override
    public void start(Stage stage){
        setBoard();

        // seting label for turn and winner
        display = new Label("Player X");
        display.getStyleClass().add("display");
        
        // seting pane
        GridPane grid = new GridPane(10, 10);
        grid.setAlignment(Pos.CENTER);
        grid.add(display, 0, 0, 2, 1);

        // seting buttons
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                Button btn = new Button("");
                int line = i;int col = j;
                btn.setOnAction(event -> {handler(line, col);});
                btn.setMinSize(100, 100);
                grid.add(btn, j, i+2);
                buttons[i][j] = btn;
            }
        }

        // restart button
        Button restartBtn = new Button("RESTART");
        restartBtn.getStyleClass().add("restartBtn");
        restartBtn.setOnAction(event -> {enableAllButtons();resetButtons();setBoard();});
        grid.add(restartBtn, 2, 0, 3, 1);

        // seting window
        stage.setTitle("Tic Tac Toe Game");
        Scene scene = new Scene(grid, 400, 500);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }


    public boolean checkWinner(){
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
            (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)){
            return true;
        }
        for (int i=0; i<3; i++){
                if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer){
                    return true;
                }
        }
        for (int j=0; j<3; j++){
                if (board[0][j] == currentPlayer && board[1][j] == currentPlayer && board[2][j] == currentPlayer){
                    return true;
                }
        }

        return false;
    }

    public void handler(int line, int row){
        if (board[line][row].equals(" ")){
            board[line][row] = currentPlayer;
            buttons[line][row].setText(currentPlayer);
        }
        if(checkWinner()){
            display.setText("Player " + currentPlayer + " WON !");
            disableAllButtons();
            return;
        }
        else if (checkDraw()){
            display.setText("DRAW !");
            disableAllButtons();
            return;
        }

        currentPlayer = (currentPlayer == "X") ? "O" : "X";
        display.setText("Player " + currentPlayer);
    }

    public void resetButtons(){
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)
                buttons[i][j].setText(" ");
    }

    public boolean checkDraw(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (buttons[i][j].getText().equals("")) return false;
            }
        }
        return true;
    }

    private void disableAllButtons() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                buttons[i][j].setDisable(true);
    }

    private void enableAllButtons() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                buttons[i][j].setDisable(false);
    }

    public void setBoard(){
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = " ";
    }

    public static void main(String[] args) {
        System.out.println("launching application ...");
        launch(args);
    }
}