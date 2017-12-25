package ru.nsu.fit.g14201.chernova.presenter;

import org.apache.log4j.Logger;
import ru.nsu.fit.g14201.chernova.model.*;
import ru.nsu.fit.g14201.chernova.view.ChessDragonView;
import ru.nsu.fit.g14201.chernova.view.FieldCoordinateView;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;
import java.util.List;

/**
 * Created by castiel on 26.12.2017.
 */
public class Presenter {
    private static Logger log = Logger.getLogger(Presenter.class);

    private GameModel model;
    private PlayerInfo playerInfo;
    private Field field;
    private FieldCoordinate selectedCell;
    private List<FieldCoordinate> currentPossibleMoves;
    private List<FieldCoordinate> currentCaptureMoves;

    public Presenter() {
        field = new Field();
        model = new GameModel(field);
        playerInfo = new PlayerInfo();
        selectedCell = null;
    }

    public ChessDragonView getView() {
        return view;
    }

    public void setView(ChessDragonView view) {
        this.view = view;
    }

    private ChessDragonView view;

    public void selectCell(FieldCoordinateView cellCoord) {
        log.debug("Coord = " + cellCoord.getBoard() + " " + cellCoord.getX() + " " + cellCoord.getY());
        FieldCoordinate fc = new FieldCoordinate(cellCoord.getBoard(), cellCoord.getX(), cellCoord.getY());

        if (selectedCell == null)
        {
            selectNewCell(fc);
        }
        else
        {

        }
    }

    private void selectNewCell(FieldCoordinate newCell)
    {
        if (field.isEmpty(newCell))
            return;

        Figure figure = field.getFigure(newCell);
        if (figure.getTeam() != playerInfo.getCurrentTurn())
            return;

        selectedCell = newCell;

        currentPossibleMoves = figure.getPossibleMoves(field, newCell);
        currentPossibleMoves.removeIf(coordinate -> !isValidMove(new GameMove(newCell, coordinate)));

        currentCaptureMoves = figure.getCaptureMoves(field, newCell);
    }

    private boolean isValidMove(GameMove move)
    {
        throw new NotImplementedException(); //TODO implement
    }

    public void start()
    {
        field.populate();
        playerInfo.startGame();
    }
}
