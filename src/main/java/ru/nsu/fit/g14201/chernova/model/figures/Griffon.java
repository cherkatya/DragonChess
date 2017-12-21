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
public class Griffon extends Figure {
    public Griffon(Team team){
        super(team);
    }

    private List<FieldCoordinate> getBothMoves(FieldCoordinate coords, Field field){
        List<FieldCoordinate> moves = new ArrayList<>();

        if(coords.getBoard() == 0) {
            moves.add(new FieldCoordinate(0, coords.getY() + 2, coords.getX() - 3));
            moves.add(new FieldCoordinate(0, coords.getY() + 2, coords.getX() + 3));
            moves.add(new FieldCoordinate(0, coords.getY() + 3, coords.getX() - 2));
            moves.add(new FieldCoordinate(0, coords.getY() + 3, coords.getX() + 2));
            moves.add(new FieldCoordinate(0, coords.getY() - 2, coords.getX() - 3));
            moves.add(new FieldCoordinate(0, coords.getY() - 2, coords.getX() + 3));
            moves.add(new FieldCoordinate(0, coords.getY() - 3, coords.getX() - 2));
            moves.add(new FieldCoordinate(0, coords.getY() - 3, coords.getX() + 2));

            moves.add(new FieldCoordinate(1, coords.getY() + 1, coords.getX() - 1));
            moves.add(new FieldCoordinate(1, coords.getY() + 1, coords.getX() + 1));
            moves.add(new FieldCoordinate(1, coords.getY() - 1, coords.getX() - 1));
            moves.add(new FieldCoordinate(1, coords.getY() - 1, coords.getX() + 1));
        }
        if(coords.getBoard() == 1){
            moves.add(new FieldCoordinate(0, coords.getY() + 1, coords.getX() - 1));
            moves.add(new FieldCoordinate(0, coords.getY() + 1, coords.getX() + 1));
            moves.add(new FieldCoordinate(0, coords.getY() - 1, coords.getX() - 1));
            moves.add(new FieldCoordinate(0, coords.getY() - 1, coords.getX() + 1));
        }
        checkMoveValidity(moves, field, team);

        return moves;
    }

    public List<FieldCoordinate> getPossibleMoves(Field field, FieldCoordinate coords){
        return getBothMoves(coords, field);
    }

    public List<FieldCoordinate> getCaptureMoves(Field field, FieldCoordinate coords){
        return getBothMoves(coords, field);
    }
}
