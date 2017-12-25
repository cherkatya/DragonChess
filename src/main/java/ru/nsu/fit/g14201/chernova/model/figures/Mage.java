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
public class Mage extends Figure {
    public Mage(Team team){
        super(team);
    }

    private List<FieldCoordinate> getMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> moves = new ArrayList<>();

        switch (coords.getBoard())
        {
            case 0:
                addAdjacentMoves(moves, coords);

                moves.add(new FieldCoordinate(1, coords.getX(), coords.getY()));

                if (field.isEmpty(new FieldCoordinate(1, coords.getX(), coords.getY())))
                    moves.add(new FieldCoordinate(2, coords.getX(), coords.getY()));

                break;
            case 2:
                addAdjacentMoves(moves, coords);

                moves.add(new FieldCoordinate(1, coords.getX(), coords.getY()));

                if (field.isEmpty(new FieldCoordinate(1, coords.getX(), coords.getY())))
                    moves.add(new FieldCoordinate(0, coords.getX(), coords.getY()));

                break;
            case 1:
                addDiagonalMoves(moves, field, coords);
                addOrthogonalMoves(moves, field, coords);
                moves.add(new FieldCoordinate(0, coords.getX(), coords.getY()));
                moves.add(new FieldCoordinate(2, coords.getX(), coords.getY()));

                break;
            default:
                throw new IllegalArgumentException("Illegal board number");
        }

        checkMoveValidity(moves, field, team);

        return moves;
    }

    private void addAdjacentMoves(List<FieldCoordinate> moves, FieldCoordinate coords)
    {
        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() - 1, coords.getY()));
        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX() + 1, coords.getY()));
        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX(), coords.getY() - 1));
        moves.add(new FieldCoordinate(coords.getBoard(), coords.getX(), coords.getY() + 1));
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
