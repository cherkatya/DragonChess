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
public class Oliphant extends Figure {
    public Oliphant(Team team){
        super(team);
    }

    private List<FieldCoordinate> getMoves(Field field, FieldCoordinate coords)
    {
        List<FieldCoordinate> moves = new ArrayList<>();

        for (int i = 1; i < 12; i++)
        {
            moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() - i, coords.getY()));
            moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() + i, coords.getY()));
            moves.add(new FieldCoordinate(coords.getBoard(), coords.getX(), coords.getY() - i));
            moves.add(new FieldCoordinate(coords.getBoard(), coords.getX(), coords.getY() + i));
        }

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
