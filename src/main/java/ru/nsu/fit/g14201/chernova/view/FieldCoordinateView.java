package ru.nsu.fit.g14201.chernova.view;

/**
 * Created by RARETA on 23.12.2017.
 */
public class FieldCoordinateView {
    private int board;
    private int x;
    private int y;

    public FieldCoordinateView(int board, int x, int y){
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
