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
public class Paladin extends Figure {
    public Paladin(Team team){
        super(team);
    }

    private List<FieldCoordinate> getMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> moves = new ArrayList<>();

        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() - 1, coords.getY()));
        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() + 1, coords.getY()));
        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX(), coords.getY() - 1));
        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX(), coords.getY() + 1));
        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() - 1, coords.getY() - 1));
        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() - 1, coords.getY() + 1));
        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() + 1, coords.getY() - 1));
        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() + 1, coords.getY() + 1));

        if (coords.getBoard() == 1)
        {
            moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() - 1, coords.getY() - 2));
            moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() - 1, coords.getY() + 2));
            moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() - 2, coords.getY() - 1));
            moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() - 2, coords.getY() + 1));
            moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() + 1, coords.getY() - 2));
            moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() + 1, coords.getY() + 2));
            moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() + 2, coords.getY() - 1));
            moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() + 2, coords.getY() + 1));
        }

        moves.add(new FieldCoordinate(coords.getBoard() - 1, coords.getX() - 2, coords.getY()));
        moves.add(new FieldCoordinate(coords.getBoard() - 1, coords.getX() + 2, coords.getY()));
        moves.add(new FieldCoordinate(coords.getBoard() - 1, coords.getX(), coords.getY() - 2));
        moves.add(new FieldCoordinate(coords.getBoard() - 1, coords.getX(), coords.getY() + 2));
        moves.add(new FieldCoordinate(coords.getBoard() + 1, coords.getX() - 2, coords.getY()));
        moves.add(new FieldCoordinate(coords.getBoard() + 1, coords.getX() + 2, coords.getY()));
        moves.add(new FieldCoordinate(coords.getBoard() + 1, coords.getX(), coords.getY() - 2));
        moves.add(new FieldCoordinate(coords.getBoard() + 1, coords.getX(), coords.getY() + 2));
        moves.add(new FieldCoordinate(coords.getBoard() - 2, coords.getX() - 1, coords.getY()));
        moves.add(new FieldCoordinate(coords.getBoard() - 2, coords.getX() + 1, coords.getY()));
        moves.add(new FieldCoordinate(coords.getBoard() - 2, coords.getX(), coords.getY() - 1));
        moves.add(new FieldCoordinate(coords.getBoard() - 2, coords.getX(), coords.getY() + 1));
        moves.add(new FieldCoordinate(coords.getBoard() + 2, coords.getX() - 1, coords.getY()));
        moves.add(new FieldCoordinate(coords.getBoard() + 2, coords.getX() + 1, coords.getY()));
        moves.add(new FieldCoordinate(coords.getBoard() + 2, coords.getX(), coords.getY() - 1));
        moves.add(new FieldCoordinate(coords.getBoard() + 2, coords.getX(), coords.getY() + 1));

        checkMoveValidity(moves, field, team);

        return moves;
    }

    public List<FieldCoordinate> getPossibleMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> moves = getMoves(field, coords);

        checkPossibilityMoves(moves, field);

        return moves;
    }
    public List<FieldCoordinate> getCaptureMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> moves = getMoves(field, coords);

        checkCaptureMoves(moves, field);

        return moves;
    }
}
