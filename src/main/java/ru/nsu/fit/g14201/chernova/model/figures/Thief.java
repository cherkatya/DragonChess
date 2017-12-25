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
public class Thief extends Figure {
    public Thief(Team team){
        super(team);
    }

    private List<FieldCoordinate> getMoves(Field field, FieldCoordinate coords)
    {
        if (coords.getBoard() != 1)
        {
            throw new IllegalArgumentException("Thief appeared on the edge board");
        }
        List<FieldCoordinate> moves = new ArrayList<>();

        for (int i = 1; ((coords.getX() - i) >= 0) && ((coords.getY() - i) >= 0); i++)
        {
            FieldCoordinate fc = new FieldCoordinate(coords.getBoard(), coords.getX() - i, coords.getY() - i);

            if (!field.isEmpty(fc))
                break;

            moves.add(fc);
        }

        for (int i = 1; ((coords.getX() - i) >= 0) && ((coords.getY() + i) < 12); i++)
        {
            FieldCoordinate fc = new FieldCoordinate(coords.getBoard(), coords.getX() - i, coords.getY() + i);

            if (!field.isEmpty(fc))
                break;

            moves.add(fc);
        }

        for (int i = 1; ((coords.getX() + i) < 12) && ((coords.getY() - i) >= 0); i++)
        {
            FieldCoordinate fc = new FieldCoordinate(coords.getBoard(), coords.getX() + i, coords.getY() - i);

            if (!field.isEmpty(fc))
                break;

            moves.add(fc);
        }

        for (int i = 1; ((coords.getX() + i) < 12) && ((coords.getY() + i) < 12); i++)
        {
            FieldCoordinate fc = new FieldCoordinate(coords.getBoard(), coords.getX() + i, coords.getY() + i);

            if (!field.isEmpty(fc))
                break;

            moves.add(fc);
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
