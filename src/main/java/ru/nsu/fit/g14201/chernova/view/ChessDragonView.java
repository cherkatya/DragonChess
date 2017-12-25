package ru.nsu.fit.g14201.chernova.view;

import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.view.utils.TeamView;

import java.util.List;


/**
 * Created by RARETA on 23.12.2017.
 */
public interface ChessDragonView {
    public void showPossibleMoves(FieldCoordinateView figure, List<FieldCoordinateView> possibleMoves);

    public void showPossibleAttacks(FieldCoordinateView figure, List<FieldCoordinateView> possibleAttacks);

    public void makeMove(FieldCoordinateView from, FieldCoordinateView to, boolean isAttack);

    public void switchTurnTo(TeamView team);

    public void check(TeamView toWhom, FieldCoordinate figureWhoMakeCheck, FieldCoordinate figureThatUnderCheck);

    public void checkAndMate(TeamView toWhom, FieldCoordinate figureWhoMakeCheckAndMate,
                             FieldCoordinate figureThatUnderCheckAndMate);    //check and Mate

    public void tie();
}
