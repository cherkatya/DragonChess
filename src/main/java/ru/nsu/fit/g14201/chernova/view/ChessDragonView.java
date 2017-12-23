package ru.nsu.fit.g14201.chernova.view;

/**
 * Created by RARETA on 23.12.2017.
 */
public interface ChessDragonView {
    public void showPossibleMoves();

    public void showPossibleAttacks();

    public void makeMove();

    public void switchTurn();

    public void check();

    public void checkAndMate();    //check and Mate

    public void tie();
}
