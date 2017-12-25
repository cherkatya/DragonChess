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
public class Hero extends Figure {
    private FieldCoordinate lastPosition;

    public Hero(Team team){
        super(team);
        lastPosition = null;
    }

    private List<FieldCoordinate> getMoves(Field field, FieldCoordinate coords){
        if ((coords.getBoard() != 1) && (lastPosition != null))
        {
            throw new IllegalArgumentException("Hero appeared on the edge board by illegal means");
        }

        List<FieldCoordinate> moves = new ArrayList<>();

        switch (coords.getBoard())
        {
            case 0:
            case 2:
            {
                moves.add(lastPosition);
                break;
            }
            case 1:
            {
                lastPosition = coords;

                for (int i = 1; i <= 2; i++)
                {
                    moves.add(new FieldCoordinate(1, coords.getX() - i, coords.getY() - i));
                    moves.add(new FieldCoordinate(1, coords.getX() - i, coords.getY() + i));
                    moves.add(new FieldCoordinate(1, coords.getX() + i, coords.getY() - i));
                    moves.add(new FieldCoordinate(1, coords.getX() + i, coords.getY() + i));
                }

                checkMoveValidity(moves, field, team);

                break;
            }
            default:
                throw new IllegalArgumentException("Illegal board number");
        }

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
