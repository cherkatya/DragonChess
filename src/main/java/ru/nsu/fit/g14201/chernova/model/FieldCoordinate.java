package ru.nsu.fit.g14201.chernova.model;

/**
 * Created by Катя on 21.12.2017.
 */
public class FieldCoordinate {
    private int board;
    private int x;
    private int y;

    public FieldCoordinate(int board, int x, int y){
        this.board = board;
        this.x = x;
        this.y = y;
    }

    public int getBoard() {
        return board;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
