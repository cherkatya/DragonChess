package ru.nsu.fit.g14201.chernova.model.figures;

import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.Figure;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.model.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Катя on 21.12.2017.
 */
public class Cleric extends Figure {
    public Cleric(Team team){
        super(team);
    }

    private List<FieldCoordinate> getMoves(FieldCoordinate coords, Field field){
        List<FieldCoordinate> moves = new ArrayList<>();

        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() - 1, coords.getY()));
        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() + 1, coords.getY()));
        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX(), coords.getY() - 1));
        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX(), coords.getY() + 1));
        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() - 1, coords.getY() - 1));
        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() - 1, coords.getY() + 1));
        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() + 1, coords.getY() - 1));
        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() + 1, coords.getY() + 1));
        moves.add(new FieldCoordinate(coords.getBoard() - 1, coords.getX(), coords.getY()));
        moves.add(new FieldCoordinate(coords.getBoard() + 1, coords.getX(), coords.getY()));

        checkMoveValidity(moves, field, team);

        return moves;
    }

    public List<FieldCoordinate> getPossibleMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> possibleMoves = getMoves(coords, field);

        checkPossibilityMoves(possibleMoves, field);

        return possibleMoves;
    }

    public List<FieldCoordinate> getCaptureMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> captureMoves = getMoves(coords, field);

        checkCaptureMoves(captureMoves, field);

        return captureMoves;
    }
}
