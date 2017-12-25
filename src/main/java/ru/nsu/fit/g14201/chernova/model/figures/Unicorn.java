package ru.nsu.fit.g14201.chernova.model.figures;

import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.model.Figure;
import ru.nsu.fit.g14201.chernova.model.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Катя on 21.12.2017.
 */
public class Unicorn extends Figure {
    public Unicorn(Team team){
        super(team);
    }

    public List<FieldCoordinate> getMoves(Field field, FieldCoordinate coords){
        if (coords.getBoard() != 1)
        {
            throw new IllegalArgumentException("Unicorn can't be on this board");
        }

        List<FieldCoordinate> moves = new ArrayList<>();

        moves.add(new FieldCoordinate(1, coords.getX() - 1, coords.getY() - 2));
        moves.add(new FieldCoordinate(1, coords.getX() - 1, coords.getY() + 2));
        moves.add(new FieldCoordinate(1, coords.getX() + 1, coords.getY() - 2));
        moves.add(new FieldCoordinate(1, coords.getX() + 1, coords.getY() + 2));
        moves.add(new FieldCoordinate(1, coords.getX() - 2, coords.getY() - 1));
        moves.add(new FieldCoordinate(1, coords.getX() - 2, coords.getY() + 1));
        moves.add(new FieldCoordinate(1, coords.getX() + 2, coords.getY() - 1));
        moves.add(new FieldCoordinate(1, coords.getX() + 2, coords.getY() + 1));

        checkMoveValidity(moves, field, team);

        return moves;
    }

    public List<FieldCoordinate> getPossibleMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> moves = new ArrayList<>();

        checkPossibilityMoves(moves, field);

        return moves;
    }
    public List<FieldCoordinate> getCaptureMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> moves = new ArrayList<>();

        checkCaptureMoves(moves, field);

        return moves;
    }
}
