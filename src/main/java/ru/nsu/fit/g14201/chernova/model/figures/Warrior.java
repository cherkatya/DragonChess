package ru.nsu.fit.g14201.chernova.model.figures;

import ru.nsu.fit.g14201.chernova.model.Figure;
import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.model.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Катя on 21.12.2017.
 */
public class Warrior extends Figure {
    public Warrior(Team team){
        super(team);
    }

    public List<FieldCoordinate> getPossibleMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> moves = new ArrayList<>();

        if (team == Team.GOLDEN)
        {
            moves.add(new FieldCoordinate(1, coords.getX(), coords.getY() + 1));
        }
        else
        {
            moves.add(new FieldCoordinate(1, coords.getX(), coords.getY() - 1));
        }

        checkMoveValidity(moves, field, team);
        checkPossibilityMoves(moves, field);

        return moves;
    }
    public List<FieldCoordinate> getCaptureMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> moves = new ArrayList<>();

        if (team == Team.GOLDEN)
        {
            moves.add(new FieldCoordinate(1, coords.getX() - 1, coords.getY() + 1));
            moves.add(new FieldCoordinate(1, coords.getX() + 1, coords.getY() + 1));
        }
        else
        {
            moves.add(new FieldCoordinate(1, coords.getX() - 1, coords.getY() - 1));
            moves.add(new FieldCoordinate(1, coords.getX() + 1, coords.getY() - 1));
        }

        checkMoveValidity(moves, field, team);
        checkCaptureMoves(moves, field);

        return moves;
    }
}
