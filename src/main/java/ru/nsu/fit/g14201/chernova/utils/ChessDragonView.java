package ru.nsu.fit.g14201.chernova.utils;

import ru.nsu.fit.g14201.chernova.view.FieldCoordinateView;

import java.util.List;


/**
 * Created by RARETA on 23.12.2017.
 */
public interface ChessDragonView {
    public void showPossibleMoves(List<FieldCoordinateView> possibleMoves);

    public void showPossibleAttacks();

    public void makeMove();

    public void switchTurn();

    public void check();

    public void checkAndMate();    //check and Mate

    public void tie();
}
