package ru.nsu.fit.g14201.chernova.model.figures;

import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.Figure;
import ru.nsu.fit.g14201.chernova.model.Team;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Катя on 21.12.2017.
 */
public class Griffon extends Figure {
    public Griffon(Team team){
        super(team);
    }

    private List<FieldCoordinate> getBothMoves(FieldCoordinate coords, Field field){
        List<FieldCoordinate> moves = new ArrayList<>();

        if(coords.getBoard() == 0) {
            moves.add(new FieldCoordinate(0, coords.getX() - 3, coords.getY() + 2));
            moves.add(new FieldCoordinate(0, coords.getX() + 3, coords.getY() + 2));
            moves.add(new FieldCoordinate(0, coords.getX() - 2, coords.getY() + 3));
            moves.add(new FieldCoordinate(0, coords.getX() + 2, coords.getY() + 3));
            moves.add(new FieldCoordinate(0, coords.getX() - 3, coords.getY() - 2));
            moves.add(new FieldCoordinate(0, coords.getX() + 3, coords.getY() - 2));
            moves.add(new FieldCoordinate(0, coords.getX() - 2, coords.getY() - 3));
            moves.add(new FieldCoordinate(0, coords.getX() + 2, coords.getY() - 3));

            moves.add(new FieldCoordinate(1, coords.getX() - 1, coords.getY() + 1));
            moves.add(new FieldCoordinate(1, coords.getX() + 1, coords.getY() + 1));
            moves.add(new FieldCoordinate(1, coords.getX() - 1, coords.getY() - 1));
            moves.add(new FieldCoordinate(1, coords.getX() + 1, coords.getY() - 1));
        }
        if(coords.getBoard() == 1){
            moves.add(new FieldCoordinate(0, coords.getX() - 1, coords.getY() + 1));
            moves.add(new FieldCoordinate(0, coords.getX() + 1, coords.getY() + 1));
            moves.add(new FieldCoordinate(0, coords.getX() - 1, coords.getY() - 1));
            moves.add(new FieldCoordinate(0, coords.getX() + 1, coords.getY() - 1));
        }
        checkMoveValidity(moves, field, team);

        return moves;
    }

    public List<FieldCoordinate> getPossibleMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> possibleMoves = getBothMoves(coords, field);

        checkPossibilityMoves(possibleMoves, field);

        return possibleMoves;
    }

    public List<FieldCoordinate> getCaptureMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> captureMoves = getBothMoves(coords, field);

        checkCaptureMoves(captureMoves, field);

        return captureMoves;
    }
}
